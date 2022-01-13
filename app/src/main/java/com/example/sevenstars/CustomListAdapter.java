package com.example.sevenstars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> ID;
    ArrayList<String> Title;

    public CustomListAdapter(Context  context1, ArrayList<String> id_array, ArrayList<String> title_array) {
        this.context=context1;
        this.ID=id_array;
        this.Title=title_array;
    }

    @Override
    public int getCount() {
        return ID.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;

        LayoutInflater layoutInflater;

        if (convertView==null){
            layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.raw_items,null);

            holder=new Holder();

            holder.Title=convertView.findViewById(R.id.t4);

            convertView.setTag(holder);

        }
        else {
            holder=(Holder)convertView.getTag();
        }

        holder.Title.setText(Title.get(position));

        return convertView;
    }

    public static class Holder {
        TextView Title;
    }
}
