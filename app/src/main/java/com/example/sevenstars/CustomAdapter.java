package com.example.sevenstars;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<GetterSetter> getterSetterArrayList;

    public CustomAdapter(ArrayList<GetterSetter> getterSetterArrayList1) {
        this.getterSetterArrayList = getterSetterArrayList1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GetterSetter getterSetter = getterSetterArrayList.get(position);
        holder.i1.setImageResource(getterSetter.getImage());
        holder.t1.setText(getterSetter.getName());
        holder.t2.setText(getterSetter.getType());
        holder.t3.setText(getterSetter.getKey_People());
        holder.t5.setText(getterSetter.getAddress());
    }

    @Override
    public int getItemCount() {
        return getterSetterArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t1, t2, t3, t4,t5;
        Button select,remind;
        ImageView i1,drop_menu;
        private final Context context;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.name);
            t2 = itemView.findViewById(R.id.type);
            t3 = itemView.findViewById(R.id.key_people_view);
            t4=itemView.findViewById(R.id.volunteers_view);
            t5=itemView.findViewById(R.id.address_view);

            select=itemView.findViewById(R.id.select);
            remind=itemView.findViewById(R.id.remind);
            i1 = itemView.findViewById(R.id.image1);
            drop_menu=itemView.findViewById(R.id.menu);
            context = itemView.getContext();

            drop_menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu p=new PopupMenu(v.getContext(),drop_menu);
                    p.getMenuInflater().inflate(R.menu.menu,p.getMenu());

                    p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @SuppressLint("NonConstantResourceId")
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            String name=t1.getText().toString();
                            String chairman=t3.getText().toString();
                            String address = t5.getText().toString();
                            final Intent intent;
                            switch (item.getItemId()){
                                case R.id.select:
                                    Toast.makeText(v.getContext(), "Select is clicked", Toast.LENGTH_SHORT).show();
                                    intent=new Intent(v.getContext(),Details.class);
                                    intent.putExtra("Name",name);
                                    intent.putExtra("Chairman",chairman);
                                    intent.putExtra("Address",address);
                                    context.startActivity(intent);
                                    break;

                                case R.id.save:
                                    Toast.makeText(v.getContext(), "Save is clicked", Toast.LENGTH_SHORT).show();
                                    break;
                            }

                            return true;
                        }
                    });
                    p.show();
                }
            });

            select.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent;
                    String Name = t1.getText().toString();
                    String chairman=t3.getText().toString();
                    String address = t5.getText().toString();

                    intent=new Intent(context,Details.class);
                    intent.putExtra("Name",Name);
                    intent.putExtra("Chairman",chairman);
                    intent.putExtra("Address",address);

                    context.startActivity(intent);
                }
             });

             remind.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     final Intent intent1;
                     String new_name=t1.getText().toString();
                     intent1=new Intent(context,My_wishlist.class);
                     intent1.putExtra("new",new_name);
                     context.startActivity(intent1);

                     Toast.makeText(v.getContext(), "Added to wishlist", Toast.LENGTH_SHORT).show();
                 }
             });
        }

    }
}




