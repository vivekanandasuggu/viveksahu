package com.educare.electus.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.educare.electus.R;
import com.educare.electus.fragments.QuestionsCheckboxFragment;

public class ExamsListAdapter extends RecyclerView.Adapter<ExamsListAdapter.ExamsListHolder> {
    @NonNull
    @Override
    public ExamsListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_exams, viewGroup, false);
        return new ExamsListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamsListHolder examsListHolder, int position) {
         examsListHolder.tv_exam_name.setText("Exam Name : "+"");
         examsListHolder.tv_exam_name.setText("Subject : "+"");



    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class ExamsListHolder extends RecyclerView.ViewHolder{
    private Button btn_start_exam;
    private TextView tv_exam_name,tv_subject,tv_date,tv_start_time,tv_end_time;
        public ExamsListHolder(@NonNull View itemView) {
            super(itemView);
            btn_start_exam=itemView.findViewById(R.id.btn_start_exam);
            tv_exam_name=itemView.findViewById(R.id.tv_exam_name);
            tv_subject=itemView.findViewById(R.id.tv_subject);
            tv_date=itemView.findViewById(R.id.tv_date);
            tv_start_time=itemView.findViewById(R.id.tv_start_time);
            tv_end_time=itemView.findViewById(R.id.tv_end_time);
            }
    }
}
