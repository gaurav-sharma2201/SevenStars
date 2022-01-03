package com.example.sevenstars;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {

    private Context mContext;
    public int[] m_Thumbs={R.drawable.charity,R.drawable.charity1,R.drawable.charity3,R.drawable.charity4,R.drawable.charity5};

    public GridAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return m_Thumbs.length;
    }

    @Override
    public Object getItem(int position) {
        return m_Thumbs[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView i1=new ImageView(mContext);
        i1.setImageResource(m_Thumbs[position]);
        i1.setScaleType(ImageView.ScaleType.FIT_XY);
        i1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,600));
        return i1;
    }
}
