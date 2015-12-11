package com.example.c1284518.healthproject.controller.adapter_tab;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

import com.example.c1284518.healthproject.R;
import com.example.c1284518.healthproject.model.entitites.CentroDeCusto;

import java.util.List;

/**
 * Created by c1284518 on 11/12/2015.
 */
public class CentroCustoAdapterTab extends BaseAdapter {
    private Activity mContext;
    private List<CentroDeCusto> mList;

    public CentroCustoAdapterTab(Activity context, List<CentroDeCusto> list) {
        mContext = context;
        mList = list;
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CentroDeCusto getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CentroDeCusto centro = getItem(position);
        View v = mContext.getLayoutInflater().inflate(R.layout.list_item_recycle, parent, false);

        CheckedTextView tv = (CheckedTextView) v.findViewById(android.R.id.text1);
        tv.setTextColor(Color.GRAY);
        tv.setText(centro.getCentro());


        return v;
    }


    public void setItens(List<CentroDeCusto> newList) {
        mList.clear();
        mList = newList;
    }

}
