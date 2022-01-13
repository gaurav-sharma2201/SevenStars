package com.example.sevenstars;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.telecom.Call;
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
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<GetterSetter> getterSetterArrayList;
    SQLiteDatabase sqLiteDatabase;

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
        TextView t1, t2, t3, t4,t5,read_more;
        Button select;
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
            read_more=itemView.findViewById(R.id.read_more_text);
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

                            final Intent intent;

                            switch (item.getItemId()) {

                                case R.id.share01:

                                    if (name.matches("Om Shakti Mahila Charitable Trust")) {
                                        intent = new Intent(Intent.ACTION_SEND);
                                        intent.putExtra(Intent.EXTRA_TEXT, "Let's go here on New Year\n" + name + "\n http://www.omshakthimahilacharitabletrust.com/ \n");
                                        intent.setType("text/plain");
                                        context.startActivity(Intent.createChooser(intent, "Send to"));
                                    } else {
                                        intent = new Intent(Intent.ACTION_SEND);
                                        intent.putExtra(Intent.EXTRA_TEXT, "Let's go here on New Year\n" + name);
                                        intent.setType("text/plain");
                                        context.startActivity(Intent.createChooser(intent, "Send to"));

                                    }
                                    break;

                                case R.id.add:
                                    intent=new Intent(v.getContext(),WishList.class);
                                    intent.putExtra("wish",name);
                                    context.startActivity(intent);

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

            read_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,Read_more.class);
                    context.startActivity(intent);
                }
            });
        }

    }


}




