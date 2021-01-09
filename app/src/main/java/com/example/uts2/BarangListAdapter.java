package com.example.uts2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BarangListAdapter extends BaseAdapter {

    Context context;
    ArrayList<barang> arrayList;
    public BarangListAdapter(Context context, ArrayList<barang> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item,null);
            TextView t1_name = (TextView)convertView.findViewById(R.id.NamaBarang);
            TextView t2_total = (TextView)convertView.findViewById(R.id.total);
            TextView t3_quantity = (TextView)convertView.findViewById(R.id.quantity);
            TextView t4_time = (TextView)convertView.findViewById(R.id.timee);


            barang barang = arrayList.get(position);

            t1_name.setText(barang.getName());
            t3_quantity.setText(barang.getQuantity());
            t2_total.setText("Rp."+ barang.getTotal());
            t4_time.setText(barang.getTime());
        return convertView;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }
}
