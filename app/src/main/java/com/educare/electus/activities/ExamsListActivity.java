package com.educare.electus.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.educare.electus.R;
import com.educare.electus.adapters.ExamsListAdapter;

public class ExamsListActivity extends AppCompatActivity {
   private RecyclerView rv_exams_list;
   private ImageView iv_back_arrow;
   private TextView tv_header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams_list);
        rv_exams_list=findViewById(R.id.rv_exams_list);
        iv_back_arrow=findViewById(R.id.iv_back_arrow);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rv_exams_list.setLayoutManager(linearLayoutManager);
        ExamsListAdapter examsListAdapter=new ExamsListAdapter();
        rv_exams_list.setAdapter(examsListAdapter);
        }
}
