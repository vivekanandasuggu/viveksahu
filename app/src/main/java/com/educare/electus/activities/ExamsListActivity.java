package com.educare.electus.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.educare.electus.Dialogues.ValidationAlertDialog;
import com.educare.electus.R;
import com.educare.electus.adapters.ExamsListAdapter;
import com.educare.electus.model.ClientsList;
import com.educare.electus.model.ExamsListModel;
import com.educare.electus.utilities.AppConstants;
import com.educare.electus.utilities.AppServiceUrls;
import com.educare.electus.utilities.MySingleton;
import com.educare.electus.utilities.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ExamsListActivity extends AppCompatActivity {
   private RecyclerView rv_exams_list;
   private ImageView iv_back_arrow;
   private TextView tv_header;
    private ProgressDialog progressDialog;
    private TextView tv_no_exams;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams_list);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Please Wait...");
        rv_exams_list=findViewById(R.id.rv_exams_list);
        iv_back_arrow=findViewById(R.id.iv_back_arrow);
        tv_no_exams=findViewById(R.id.tv_no_exams);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rv_exams_list.setLayoutManager(linearLayoutManager);

        getExamsList();
        }
    private void getExamsList() {
        progressDialog.show();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                AppServiceUrls.GETEXAMS_LIST+PreferenceManager.getString(
                        ExamsListActivity.this,AppConstants.STUDENT_ID,"")
                        +AppConstants.KEYDS+
                        PreferenceManager.getInt(ExamsListActivity.this,AppConstants.SELECTED_DATABASE,0),
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        try {
                            ExamsListModel examsListModel=gson.fromJson(response.toString(),ExamsListModel.class);
                            List<ExamsListModel.Datum> examsList=examsListModel.getData();
                            if(examsList!=null&&examsList.size()>0) {
                                ExamsListAdapter examsListAdapter = new ExamsListAdapter(ExamsListActivity.this, examsList);
                                rv_exams_list.setAdapter(examsListAdapter);
                            }else{
                                tv_no_exams.setVisibility(View.VISIBLE);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Log.v("ElectusClinets", "Electus" + response.toString());
                        progressDialog.dismiss();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Do something when error occurred
                        new ValidationAlertDialog(ExamsListActivity.this, getString(R.string.error_failure_header), getString(R.string.error_description));
                        Log.v("ElectusClinets", "Electus" + error.toString());
                        progressDialog.dismiss();
                    }
                }
        );
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }


}
