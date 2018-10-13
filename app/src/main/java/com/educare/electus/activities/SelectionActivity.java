package com.educare.electus.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.educare.electus.R;
import com.educare.electus.adapters.ClientsSpinnerAdapter;
import com.educare.electus.model.ClientsList;
import com.educare.electus.utilities.AppConstants;
import com.educare.electus.utilities.AppServiceUrls;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SelectionActivity extends AppCompatActivity {
    private Button btn_submit;
    private ProgressDialog progressDialog;
    private List<ClientsList> clientsListsSpinner = new ArrayList<>();
    private String[] clinets ;
    private Spinner spinner;
    private ArrayAdapter<ClientsList> myAdapter;
    private ArrayAdapter<CharSequence> langAdapter;
    private String selectedClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading Please Wait...");
        spinner = (Spinner) findViewById(R.id.spinner_schools);
        btn_submit = findViewById(R.id.btn_submit);
        getClientsList();
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent examIntent=new Intent(SelectionActivity.this,ExamActivity.class);
                startActivity(examIntent);

            }
        });
       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               if(position>0){
                   selectedClient=clinets[position];
               }

           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
    }

    private void getClientsList() {
        progressDialog.show();
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        // Initialize a new JsonObjectRequest instance
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                AppServiceUrls.GET_CLIENTS_URLS,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        clientsListsSpinner = new ArrayList<>();
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<ClientsList>>() {
                        }.getType();
                        try {
                            List<ClientsList> clientsLists = gson.fromJson(response.getJSONArray(AppConstants.DATA).toString(), type);
                            int arraySize=clientsLists.size()+1;
                            clinets=new String[arraySize];
                            if (clientsLists != null && clientsLists.size() > 0) {
                                for (int i = 0; i < clientsLists.size(); i++) {
                                    if (i == 0) {
                                        ClientsList clientsList = new ClientsList();
                                        clientsList.setClientid(0);
                                        clientsList.setClientname("-- Choose one --");
                                        clientsListsSpinner.add(clientsList);
                                        clinets[i] = "-- Choose one --";
                                    }
                                    int postion = i + 1;
                                    clinets[postion] = clientsLists.get(i).getClientname();
                                    clientsListsSpinner.add(postion, clientsLists.get(i));
                                }
                                showSpinner(clinets);

                               /* myAdapter = new ClientsSpinnerAdapter(SelectionActivity.this, R.layout.spinner_list_item_clinets, clientsListsSpinner);
                                spinner.setAdapter(myAdapter);*/
                               }

                        } catch (JSONException e) {
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
                        Log.v("ElectusClinets", "Electus" + error.toString());
                        progressDialog.dismiss();
                    }
                }
        );
        // Add JsonObjectRequest to the RequestQueue
        requestQueue.add(jsonObjectRequest);
    }

    private void showSpinner(String[] clinets) {
        ArrayAdapter<CharSequence> langAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, clinets);
        langAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(langAdapter);
    }

    private void sendSelectedClient(){

    }
}
