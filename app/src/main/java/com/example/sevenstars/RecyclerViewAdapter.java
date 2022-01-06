package com.example.sevenstars;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ArrayList<Wishlist_getter_setter> wishlistGetterSetterArrayList;

    public RecyclerViewAdapter(ArrayList<Wishlist_getter_setter> wishlist_getter_setterArrayList) {
        this.wishlistGetterSetterArrayList=wishlist_getter_setterArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_items_list,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Wishlist_getter_setter wishlistGetterSetter=wishlistGetterSetterArrayList.get(position);
        holder.Name.setText(wishlistGetterSetter.getName());


    }

    @Override
    public int getItemCount() {
        return wishlistGetterSetterArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Name=itemView.findViewById(R.id.t6);
        }
    }
}
