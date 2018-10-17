package com.educare.electus.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.educare.electus.R;

public class ExamsListActivity extends AppCompatActivity {
   private RecyclerView rv_exams_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams_list);
        rv_exams_list=findViewById(R.id.rv_exams_list);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rv_exams_list.setLayoutManager(linearLayoutManager);
        }
}
