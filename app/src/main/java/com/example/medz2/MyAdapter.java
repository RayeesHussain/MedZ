package com.example.medz2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    Activity activity;
    private ArrayList pill_id,pill_name,pill_type,weeks,form,start_date,stop_date,time;


    public MyAdapter(Activity activity,Context context, ArrayList pill_id, ArrayList pill_name, ArrayList pill_type, ArrayList weeks, ArrayList form, ArrayList start_date, ArrayList stop_date, ArrayList time) {
        this.activity=activity;
        this.context = context;
        this.pill_id = pill_id;
        this.pill_name = pill_name;
        this.pill_type = pill_type;
        this.weeks = weeks;
        this.form = form;
        this.start_date = start_date;
        this.stop_date = stop_date;
        this.time = time;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        //View view=inflater.inflate(R.layout.my_row,null);
        View view=inflater.inflate(R.layout.my_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {


      holder.id.setText(String.valueOf(pill_id.get(position)));
      holder.txtname.setText(String.valueOf(pill_name.get(position)));


     holder.main1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(context,Update.class);
              intent.putExtra("pill_id",String.valueOf(pill_id.get(position)));
              intent.putExtra("pill_name",String.valueOf(pill_name.get(position)));
              intent.putExtra("pill_type",String.valueOf(pill_type.get(position)));
              intent.putExtra("weeks",String.valueOf(weeks.get(position)));
              intent.putExtra("form",String.valueOf(form.get(position)));
              intent.putExtra("start_date",String.valueOf(start_date.get(position)));
              intent.putExtra("stop_date",String.valueOf(stop_date.get(position)));
              intent.putExtra("time",String.valueOf(time.get(position)));
              //context.startActivity(intent);
              activity.startActivityForResult(intent,1);






          }
      });
//      holder.flowmenu.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View view) {
//              PopupMenu popupMenu=new PopupMenu(context,holder.flowmenu);
//              popupMenu.inflate(R.menu.flow_menu);
//              popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                  @Override
//                  public boolean onMenuItemClick(MenuItem menuItem) {
//                      switch (menuItem.getItemId()){
//                          case R.id.edit_menu:
//                              //edit
////                              Bundle bundle=new Bundle();
////                              bundle.putString("id", model1.getId());
////                              bundle.putInt("pill_name",);
//
//                              break;
//                          case R.id.delete_menu:
//                              //delete
//                              break;
//                          case R.id.display_menu:
//                              //display
////                              DBMain dbMain=new DBMain(context);
////                              sqLiteDatabase=dbMain.getReadableDatabase();
////                              long recdelete=sqLiteDatabase.delete();
//                              break;
//                          default:
//                              return false;
//
//                      }
//                      return false;
//                  }
//              });
//             popupMenu.show();
//          }
//      });

    }

    @Override
    public int getItemCount() {
        return pill_id.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtname,id;
        //Button upd,del;
        //ImageButton flowmenu;
       //CardView main1;
        LinearLayout main1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id=(TextView)itemView.findViewById(R.id.pill_id_txt);

            txtname=(TextView)itemView.findViewById(R.id.pill_name_txt);
            //upd=(Button)itemView.findViewById(R.id.btn_upd);
            //del=(Button)itemView.findViewById(R.id.btn_del);
//            flowmenu=(ImageButton) itemView.findViewById(R.id.flowmenu);
            main1=itemView.findViewById(R.id.mainLayout);
        }
    }
}
