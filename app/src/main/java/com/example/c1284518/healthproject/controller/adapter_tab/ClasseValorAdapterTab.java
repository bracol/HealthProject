package com.example.c1284518.healthproject.controller.adapter_tab;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.c1284518.healthproject.R;
import com.example.c1284518.healthproject.controller.SearchActivityW;
import com.example.c1284518.healthproject.model.entitites.ClasseDeValor;

import java.util.List;

/**
 * Created by c1284518 on 11/12/2015.
 */
public class ClasseValorAdapterTab extends BaseAdapter {
    private Activity mContext;
    private List<ClasseDeValor> mLista;

    public ClasseValorAdapterTab(Activity context, List<ClasseDeValor> lista) {
        mContext = context;
        mLista = lista;
    }

    @Override
    public int getCount() {
        return mLista.size();
    }

    @Override
    public ClasseDeValor getItem(int position) {
        return mLista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ClasseDeValor classeDeValor = getItem(position);

        View v = mContext.getLayoutInflater().inflate(R.layout.list_item_recycle, parent, false);

        TextView tv = (TextView) v.findViewById(R.id.textViewRecycler);
        tv.setTextColor(Color.GRAY);
        tv.setText(classeDeValor.getClasseValor());
        return v;
    }

    public void setItens(List<ClasseDeValor> newList) {
        mLista.clear();
        mLista.addAll(newList);
    }

}

