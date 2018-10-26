package com.educare.electus.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.educare.electus.R;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView menu_icon;
    private DrawerLayout drawer;
    private RecyclerView menu_items_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        menu_icon = (ImageView) findViewById(R.id.menu_icon);
        menu_icon.setOnClickListener(this);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        menu_items_list = (RecyclerView) findViewById(R.id.menu_items_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        menu_items_list.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onClick(View v) {
        if(v==menu_icon){
            drawer.openDrawer(Gravity.LEFT);
        }
    }

    class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MenuHolder>{
        private Context context;
        public MenuListAdapter(Context context){
            this.context=context;

        }
        @NonNull
        @Override
        public MenuHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.list_item_menu_options, viewGroup, false);
            return new MenuHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MenuHolder menuHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class MenuHolder extends RecyclerView.ViewHolder{

            public MenuHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}
