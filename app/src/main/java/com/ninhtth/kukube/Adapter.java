package com.ninhtth.kukube;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<String> {
    Context ct;
    ArrayList<String> arr;
    public Adapter( Context context, int resource, List objects) {
        super(context, resource, objects);
        this.ct=context;
        this.arr = new ArrayList<>(objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater=(LayoutInflater) ct.getSystemService(ct.LAYOUT_INFLATER_SERVICE);
        row = inflater.inflate(R.layout.item,null);
        if(arr!=null && arr.size()>0){
            com.ninhtth.kukube.textview a=(com.ninhtth.kukube.textview) row.findViewById(R.id.item);
            a.setBackgroundColor(Color.parseColor(arr.get(position)));
        }
        return row;
    }
}
