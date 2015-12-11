package com.example.c1284518.healthproject.controller.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by c1284518 on 09/12/2015.
 */
public class ItemContaAdapter extends BaseAdapter {
    private Activity mContext;
    private List<String> mList;
    private int mResource;

    public ItemContaAdapter(Activity context, List<String> list ){
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public String getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String palavra = getItem(position);

        View v = mContext.getLayoutInflater().inflate(mResource, parent, false);
        TextView tv = (TextView) v.findViewById(android.R.id.text1);
        tv.setTextColor(Color.GRAY);
        tv.setText(palavra);
        return v;
    }

    public void setItens(List<String> newList){
        mList.clear();
        mList.addAll(newList);
    }

    public void setDropDownResource(@LayoutRes int resource){
        mResource = resource;
    }
}
