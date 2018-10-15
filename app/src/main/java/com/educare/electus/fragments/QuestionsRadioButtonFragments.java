package com.educare.electus.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.educare.electus.R;
import com.educare.electus.utilities.AppConstants;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionsRadioButtonFragments extends Fragment {
    private TextView tv_qstn;
    private RecyclerView rv_answer_options;
    private int questionNumber=0;

    public QuestionsRadioButtonFragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_questions_radio_button_fragments, container, false);
        tv_qstn=view.findViewById(R.id.tv_qstn);
        if(getArguments()!=null){
            questionNumber=getArguments().getInt(AppConstants.questionNumber,0);
        }
        tv_qstn.setText(questionNumber+") What is the captial of India?");
        rv_answer_options=view.findViewById(R.id.rv_answer_options);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        rv_answer_options.setLayoutManager(linearLayoutManager);
        rv_answer_options.setAdapter(new AnswerAdapter());
        return view;
    }

    class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswersHolder>{
        @NonNull
        @Override
        public AnswersHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.list_item_answer_radio_buttons, viewGroup, false);
            return new AnswersHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AnswersHolder answersHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 4;
        }

        class AnswersHolder extends RecyclerView.ViewHolder{

            public AnswersHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }

}
