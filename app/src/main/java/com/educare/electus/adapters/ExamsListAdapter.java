package com.educare.electus.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.educare.electus.Dialogues.InstructionsDialog;
import com.educare.electus.R;
import com.educare.electus.activities.ExamsListActivity;
import com.educare.electus.fragments.QuestionsCheckboxFragment;
import com.educare.electus.model.ExamsListModel;

import java.util.List;

public class ExamsListAdapter extends RecyclerView.Adapter<ExamsListAdapter.ExamsListHolder> {
    private Context context;
    private  List<ExamsListModel.Datum> examsList;
    public ExamsListAdapter(Context context, List<ExamsListModel.Datum> examsList) {
        this.context=context;
        this.examsList=examsList;
    }

    @NonNull
    @Override
    public ExamsListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_exams, viewGroup, false);
        return new ExamsListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamsListHolder examsListHolder, int position) {
        examsListHolder.tv_exam_type.setText(examsList.get(position).getExamtype());
         examsListHolder.tv_exam_name.setText(examsList.get(position).getExamname());
         StringBuffer stringBuffer=new StringBuffer();
         List<String> subjectList=examsList.get(position).getSubnamelist();
         for(int i=0;i<subjectList.size();i++){
             stringBuffer.append(subjectList.get(i));
           //  stringBuffer.append(",");
         }
         examsListHolder.tv_subject.setText(stringBuffer.toString());
         examsListHolder.tv_date.setText("Date : "+examsList.get(position).getSlotdate());
         examsListHolder.tv_start_time.setText("Start time : "+examsList.get(position).getStarttime());
         examsListHolder.tv_end_time.setText("End time : "+examsList.get(position).getEndtime());
         examsListHolder.btn_instructions.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 new InstructionsDialog(context,"Show Message");
             }
         });
         }


    @Override
    public int getItemCount() {
        return examsList.size();
    }

    class ExamsListHolder extends RecyclerView.ViewHolder{
    private Button btn_start_exam,btn_instructions;
    private TextView tv_exam_name,tv_subject,tv_date,tv_start_time,tv_end_time,tv_exam_type;
        public ExamsListHolder(@NonNull View itemView) {
            super(itemView);
            btn_start_exam=itemView.findViewById(R.id.btn_start_exam);
            tv_exam_name=itemView.findViewById(R.id.tv_exam_name);
            tv_subject=itemView.findViewById(R.id.tv_subject);
            tv_date=itemView.findViewById(R.id.tv_date);
            tv_start_time=itemView.findViewById(R.id.tv_start_time);
            tv_end_time=itemView.findViewById(R.id.tv_end_time);
            tv_exam_type=itemView.findViewById(R.id.tv_exam_type);
            btn_instructions=itemView.findViewById(R.id.btn_instructions);
            }
    }
}
