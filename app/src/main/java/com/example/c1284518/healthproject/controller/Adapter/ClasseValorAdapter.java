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
public class ClasseValorAdapter extends BaseAdapter {
    private Activity mContext;
    private List<String> mLista;
    private int mResource;

    public ClasseValorAdapter(Activity context, List<String> lista){
        mContext = context;
        mLista = lista;
    }

    @Override
    public int getCount() {
        return mLista.size();
    }

    @Override
    public String getItem(int position) {
        return mLista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String s =  getItem(position);

        View v = mContext.getLayoutInflater().inflate(mResource, parent, false);

        TextView tv = (TextView) v.findViewById(android.R.id.text1);
        tv.setTextColor(Color.GRAY);
        tv.setText(s);
        return v;
    }

    public void setItens(List<String> newList){
        mLista.clear();
        mLista.addAll(newList);
    }

    public void setDropDownResource(@LayoutRes int resource){
        mResource = resource;
    }
}
