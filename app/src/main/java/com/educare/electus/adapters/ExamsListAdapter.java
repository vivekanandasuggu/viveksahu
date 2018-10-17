package com.educare.electus.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        public ExamsListHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
