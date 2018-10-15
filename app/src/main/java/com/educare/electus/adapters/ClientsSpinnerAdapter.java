package com.educare.electus.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.educare.electus.R;
import com.educare.electus.model.ClientsList;

import java.util.List;

public class ClientsSpinnerAdapter extends ArrayAdapter<ClientsList> {
    private Context context;
    private List<ClientsList> clientsLists;
    public ClientsSpinnerAdapter(Context context, int resource,List<ClientsList> clientsLists) {
        super(context, resource);
        this.context=context;
        this.clientsLists=clientsLists;
    }


    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater) context.getSystemService(  Context.LAYOUT_INFLATER_SERVICE );
        View row=inflater.inflate(R.layout.spinner_list_item_clinets, parent, false);
        TextView label=row.findViewById(R.id.tv_clients);
        label.setText(clientsLists.get(position).getClientname());
        return row;
    }
}
