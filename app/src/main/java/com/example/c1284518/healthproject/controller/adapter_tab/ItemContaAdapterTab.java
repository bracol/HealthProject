package com.example.c1284518.healthproject.controller.adapter_tab;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.c1284518.healthproject.R;
import com.example.c1284518.healthproject.model.entitites.ItemDeConta;

import java.util.List;

/**
 * Created by c1284518 on 11/12/2015.
 */
public class ItemContaAdapterTab extends BaseAdapter {
    private Activity mContext;
    private List<ItemDeConta> mLista;

    public ItemContaAdapterTab(Activity context, List<ItemDeConta> lista){
        mContext = context;
        mLista = lista;
    }

    @Override
    public int getCount() {
        return mLista.size();
    }

    @Override
    public ItemDeConta getItem(int position) {
        return mLista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemDeConta itemDeConta =  getItem(position);

        View v = mContext.getLayoutInflater().inflate(R.layout.list_item_recycle, parent, false);

        TextView tv = (TextView) v.findViewById(android.R.id.text1);
        tv.setTextColor(Color.GRAY);
        tv.setText(itemDeConta.getItem());
        return v;
    }

    public void setItens(List<ItemDeConta> newList){
        mLista.clear();
        mLista.addAll(newList);
    }

}
