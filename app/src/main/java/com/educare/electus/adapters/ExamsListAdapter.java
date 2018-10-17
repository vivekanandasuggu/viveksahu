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
    public void onBindViewHolder(@NonNull ExamsListHolder examsListHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ExamsListHolder extends RecyclerView.ViewHolder{
    private Button btn_start_exam;
    private TextView tv_exam_name,tv_subject;
        public ExamsListHolder(@NonNull View itemView) {
            super(itemView);
            btn_start_exam=itemView.findViewById(R.id.btn_start_exam);
            tv_exam_name=itemView.findViewById(R.id.tv_exam_name);
            tv_subject=itemView.findViewById(R.id.tv_subject);
            }
    }
}
