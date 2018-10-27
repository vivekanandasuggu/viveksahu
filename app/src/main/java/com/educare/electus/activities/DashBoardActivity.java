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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.educare.electus.Dialogues.InstructionsDialog;
import com.educare.electus.R;
import com.educare.electus.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView menu_icon;
    private DrawerLayout drawer;
    private RecyclerView menu_items_list;
    private List<MenuItem> images = new ArrayList<>();


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

        //adding the menu items
        MenuItem item = new MenuItem();
        item.setImage(R.drawable.desktop);
        item.setMenu("Home");
        images.add(item);

        item = new MenuItem();
        item.setImage(R.drawable.desktop);
        item.setMenu("Exam List");
        images.add(item);

        item = new MenuItem();
        item.setImage(R.drawable.desktop);
        item.setMenu("Results");
        images.add(item);

        item = new MenuItem();
        item.setImage(R.drawable.desktop);
        item.setMenu("Analysis");
        images.add(item);

      /*  item = new MenuItem();
        item.setImage(R.drawable.desktop);
        item.setMenugetString(R.string.promotions_menulabel));
        images.add(item);

        item = new MenuItem();
        item.setImage(R.drawable.desktop);
        item.setMenu(getString(R.string.drivewithspin_menulabel));
        images.add(item);*/
      MenuListAdapter menuListAdapter=new MenuListAdapter(this,images);
      menu_items_list.setAdapter(menuListAdapter);

    }

    @Override
    public void onClick(View v) {
        if(v==menu_icon){
            drawer.openDrawer(Gravity.LEFT);
        }
    }

    class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MenuHolder>{
        private Context context;
        private List<MenuItem> menuItems;
        public MenuListAdapter(Context context,List<MenuItem> menuItems){
            this.context=context;
            this.menuItems=menuItems;

        }
        @NonNull
        @Override
        public MenuHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.list_item_menu_options, viewGroup, false);
            return new MenuHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MenuHolder menuHolder, final int position) {
         menuHolder.txt_menu_item.setText(menuItems.get(position).getMenu());
         menuHolder.list_item.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 drawer.closeDrawer(Gravity.LEFT);
                 Toast.makeText(DashBoardActivity.this,"Clicked on "+position,Toast.LENGTH_SHORT).show();
                 new InstructionsDialog(DashBoardActivity.this,"show message");
             }
         });
        }

        @Override
        public int getItemCount() {
            return menuItems.size();
        }

        class MenuHolder extends RecyclerView.ViewHolder{
             private RelativeLayout list_item;
             private ImageView img_menu_icons;
             private TextView txt_menu_item;
            public MenuHolder(@NonNull View itemView) {
                super(itemView);
                img_menu_icons=itemView.findViewById(R.id.img_menu_icons);
                txt_menu_item=itemView.findViewById(R.id.txt_menu_item);
                list_item=itemView.findViewById(R.id.list_item);
            }
        }
    }
}
