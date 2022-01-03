package com.example.sevenstars;

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
//        holder.t3.setText(getterSetter.getAddress());
    }

    @Override
    public int getItemCount() {
        return getterSetterArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t1, t2, t3, t4,select;
        ImageView i1,drop_menu;
        private final Context context;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.name);
            t2 = itemView.findViewById(R.id.type);
          //  t3 = itemView.findViewById(R.id.address);
            select=itemView.findViewById(R.id.select);
            i1 = itemView.findViewById(R.id.image1);
            drop_menu=itemView.findViewById(R.id.menu);

            drop_menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu p=new PopupMenu(v.getContext(),drop_menu);
                    p.getMenuInflater().inflate(R.menu.menu,p.getMenu());

                    p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                          //  Toast.makeText(v.getContext(), "You clicked "+item, Toast.LENGTH_SHORT).show();

                            switch (getAdapterPosition()){
                                case 0:

                                    String click=item.getTitle().toString();
                                    int click1=item.getItemId();

                                    if (item.getItemId()==1){
                                     //   Toast.makeText(v.getContext(), "Checking out", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        //Toast.makeText(v.getContext(), "Check message"+click, Toast.LENGTH_SHORT).show();
                                    }

                                   break;

                                case 1:
                                    Toast.makeText(v.getContext(), "check case 2"+item, Toast.LENGTH_SHORT).show();

                            }
                            return true;
                        }
                    });
                    p.show();
                }
            });




           // select=itemView.findViewById(R.id.select);

            context = itemView.getContext();


             select.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent;
                    String Name=t1.getText().toString();
                    String Type = t2.getText().toString();

                    switch (getAdapterPosition()){
                        case  0:

                            intent=new Intent(context,Details.class);
                            intent.putExtra("Name",Name);
                            intent.putExtra("Type",Type);


                            break;

                        case 1:

                           intent=new Intent(context,Details.class);
                           intent.putExtra("Name",Name);
                           intent.putExtra("Type",Type);

                           break;

                        case 2:
                            intent=new Intent(context,Details.class);
                            intent.putExtra("Name",Name);
                            intent.putExtra("Type",Type);

                            break;

                        case 3:
                            intent=new Intent(context,Details.class);
                            intent.putExtra("Name",Name);
                            intent.putExtra("Type",Type);

                            break;
//
                        case 4:
                            intent=new Intent(context,Details.class);
                            intent.putExtra("Name",Name);
                            intent.putExtra("Type",Type);
                            break;

                        case 5:
                            intent=new Intent(context,Details.class);
                            intent.putExtra("Name",Name);
                            intent.putExtra("Type",Type);
                            break;

                        case 6:
                            intent=new Intent(context,Details.class);
                            intent.putExtra("Name",Name);
                            intent.putExtra("Type",Type);
                            break;

                        case 7:
                            intent=new Intent(context,Details.class);
                            intent.putExtra("Name",Name);
                            intent.putExtra("Type",Type);
                            break;

                        case 8:
                            intent=new Intent(context,Details.class);
                            intent.putExtra("Name",Name);
                            intent.putExtra("Type",Type);
                            break;

                        case 9:
                            intent=new Intent(context,Details.class);
                            intent.putExtra("Name",Name);
                            intent.putExtra("Type",Type);
                            break;

                            default:
                            System.out.println("Unexpected value " + getAdapterPosition());
                          throw new IllegalArgumentException("Unexpected value: " + getAdapterPosition());

                    }
                    context.startActivity(intent);
                }

             });
        }

    }
}




