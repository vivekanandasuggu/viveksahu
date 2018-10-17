package com.educare.electus.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.educare.electus.Dialogues.ValidationAlertDialog;
import com.educare.electus.R;
import com.educare.electus.utilities.AppConstants;
import com.educare.electus.utilities.AppServiceUrls;
import com.educare.electus.utilities.PreferenceManager;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout rlHeader;
    private ImageView ivBackArrow;
    private TextView tvHeader;
    private EditText etUserName;
    private EditText etPassword;
    private LinearLayout llBtnsLayout;
    private Button btnSubmit;
    private Button btnOtp;
    private TextView tvForgotPassword;
    private TextView tvNeedHelp;
    private ProgressDialog progressDialog;
    // private String loginURL="http://192.168.0.4:8092/ElectusEduCare/checklogin?username=09111&password=09111";
    private String loginURL = "http://192.168.0.4:8092/ElectusEduCare/checklogin?username=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
    }

    private void findViews() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.loading_please_wait));
        rlHeader = (RelativeLayout) findViewById(R.id.rl_header);
        ivBackArrow = (ImageView) findViewById(R.id.iv_back_arrow);
        tvHeader = (TextView) findViewById(R.id.tv_header);
        etUserName = (EditText) findViewById(R.id.et_user_name);
        etPassword = (EditText) findViewById(R.id.et_password);
        llBtnsLayout = (LinearLayout) findViewById(R.id.ll_btns_layout);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnOtp = (Button) findViewById(R.id.btn_otp);
        tvForgotPassword = (TextView) findViewById(R.id.tv_forgot_password);
        tvNeedHelp = (TextView) findViewById(R.id.tv_need_help);
        btnSubmit.setOnClickListener(this);
        btnOtp.setOnClickListener(this);
        ivBackArrow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnSubmit) {
            // Handle clicks for btnSubmit
            if (validate()) {
                signInUser(etUserName.getText().toString().trim(), etPassword.getText().toString().trim());
            }

        } else if (v == btnOtp) {
            // Handle clicks for btnOtp
        } else if (v == tvForgotPassword) {
       //Here we have to write the code for the forgot password
        } else if (v == ivBackArrow) {
            onBackPressed();
        }
    }

    private void navigate() {
        Intent examIntent = new Intent(this, ExamActivity.class);
        startActivity(examIntent);
    }

    private void signInUser(String userName, String password) {
        progressDialog.show();
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        // Initialize a new JsonObjectRequest instance
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                loginURL + userName + "&password=" + password + "&keyDS=" + PreferenceManager.getInt(LoginActivity.this,
                        AppConstants.SELECTED_DATABASE, 0),
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.v("ElectusClinets", "Electus" + response.toString());
                        try {
                            if (response.has(AppConstants.STUDENT_ID) && response.get(AppConstants.STUDENT_ID) != null)
                                PreferenceManager.saveString(LoginActivity.this, AppConstants.STUDENT_ID, response.get(AppConstants.STUDENT_ID).toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        progressDialog.dismiss();
                        navigate();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        new ValidationAlertDialog(LoginActivity.this, getString(R.string.error_failure_header), getString(R.string.error_description));
                        NetworkResponse networkResponse = error.networkResponse;
                        progressDialog.dismiss();
                    }
                });

        // Add JsonObjectRequest to the RequestQueue
        requestQueue.add(jsonObjectRequest);
    }

    private boolean validate() {
        if (!(etUserName.getText().toString().trim().length() > 0)) {
            new ValidationAlertDialog(LoginActivity.this, "Error", "Please enter username");
            return false;
        } else if (!(etPassword.getText().toString().trim().length() > 0)) {
            new ValidationAlertDialog(LoginActivity.this, "Error", "Please enter password");
            return false;
        }
        return true;
    }


}







