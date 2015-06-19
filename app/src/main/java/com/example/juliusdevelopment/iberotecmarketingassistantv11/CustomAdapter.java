package com.example.juliusdevelopment.iberotecmarketingassistantv11;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by JuliusDevelopment on 13/06/2015.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    //Projects rowItem;

    List<RowItem> rowItem;
    boolean inverse=false;
    //Projects[] projects
    CustomAdapter(Context context, List<RowItem> rowItem){
        this.context=context;
        this.rowItem=rowItem;
    }

    CustomAdapter(Context context, List<RowItem> rowItem, boolean inverse){
        this.context=context;
        this.rowItem=rowItem;
        this.inverse=inverse;
    }

    @Override
    public int getCount() {
        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {

        return rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        float orientation=0;
        if (inverse==true){
            orientation=180;
        }

        if (convertView==null){
            LayoutInflater mInflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=mInflater.inflate(R.layout.custom_row,null);
        }

        ImageView imgIcon=(ImageView)convertView.findViewById(R.id.imgId);
        TextView txtTitle=(TextView)convertView.findViewById(R.id.txtId);

        RowItem row_pos=rowItem.get(position);
        imgIcon.setImageResource(row_pos.getIcon());
        txtTitle.setText(row_pos.getTitle());
        imgIcon.setRotation(orientation);
        txtTitle.setRotation(orientation);

        return convertView;
    }
}
