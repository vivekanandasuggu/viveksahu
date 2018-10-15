package com.educare.electus.activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.educare.electus.R;
import com.educare.electus.fragments.QuestionsCheckboxFragment;
import com.educare.electus.fragments.QuestionsRadioButtonFragments;
import com.educare.electus.fragments.TutorialFragment;
import com.educare.electus.model.QuestionsModel;
import com.educare.electus.utilities.AppConstants;

import java.util.ArrayList;

public class ExamActivity extends AppCompatActivity {
    private RecyclerView rv_questions;
    private ArrayList<QuestionsModel> questionsModelArrayList = new ArrayList<>();
    private QuestionsRecyclerViewAdapter questionsRecyclerViewAdapter;
    private ViewPager viewPager;
    private TextView tv_previous,tv_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        tv_previous=findViewById(R.id.tv_previous);
        tv_next=findViewById(R.id.tv_next);
        for (int i = 0; i < 6; i++) {
            QuestionsModel questionsModel = new QuestionsModel();
            questionsModel.setViewed(false);
            questionsModel.setAnswered(false);
            if (i == 0) {
                questionsModel.setViewed(true);
            }
            questionsModelArrayList.add(questionsModel);
        }
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new ExamPagerAdapter(getSupportFragmentManager()));
        rv_questions = findViewById(R.id.rv_question);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
        rv_questions.setLayoutManager(gridLayoutManager);
        questionsRecyclerViewAdapter = new QuestionsRecyclerViewAdapter(this, questionsModelArrayList);
        rv_questions.setAdapter(questionsRecyclerViewAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                questionsModelArrayList.get(i).setViewed(true);
                questionsRecyclerViewAdapter.notifyDataSetChanged();
                Toast.makeText(ExamActivity.this, "Current Page" + i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        tv_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewPager.getCurrentItem()>0){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
                }
            }
        });
        tv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewPager.getCurrentItem()<5)
                {
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }
            }
        });
    }

    class ExamPagerAdapter extends FragmentPagerAdapter {

        public ExamPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            if (i % 2 == 0) {
                QuestionsCheckboxFragment fragment = new QuestionsCheckboxFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(AppConstants.questionNumber, i + 1);
                fragment.setArguments(bundle);
                return fragment;
            } else {
                QuestionsRadioButtonFragments fragments = new QuestionsRadioButtonFragments();
                Bundle bundle = new Bundle();
                bundle.putInt(AppConstants.questionNumber, i + 1);
                fragments.setArguments(bundle);
                return fragments;
            }

        }

        @Override
        public int getCount() {
            return 6;
        }
    }

    class QuestionsRecyclerViewAdapter extends RecyclerView.Adapter<QuestionsRecyclerViewAdapter.QuestionsViewHolder> {
        private Context context;
        private ArrayList<QuestionsModel> questionsModelArrayList;

        public QuestionsRecyclerViewAdapter(Context context, ArrayList<QuestionsModel> questionsModelArrayList) {
            this.context = context;
            this.questionsModelArrayList = questionsModelArrayList;
        }

        @NonNull
        @Override
        public QuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.grid_item_questions, viewGroup, false);
            return new QuestionsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull QuestionsViewHolder questionsViewHolder, final int i) {
            int questionnumber = i + 1;
            questionsViewHolder.btn_qstn_number.setText("" + questionnumber);
            GradientDrawable bgDrawable = (GradientDrawable) questionsViewHolder.btn_qstn_number.getBackground();
            if (questionsModelArrayList.get(i).isViewed()) {
                bgDrawable.setColor(Color.parseColor("#4BC567"));
            } else {
                bgDrawable.setColor(Color.parseColor("#f00000"));
            }
            questionsViewHolder.btn_qstn_number.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 viewPager.setCurrentItem(i);
                }
            });

        }

        @Override
        public int getItemCount() {
            return 6;
        }

        class QuestionsViewHolder extends RecyclerView.ViewHolder {
            Button btn_qstn_number;

            public QuestionsViewHolder(@NonNull View itemView) {
                super(itemView);
                btn_qstn_number = itemView.findViewById(R.id.btn_qstn_number);
            }
        }
    }
}
