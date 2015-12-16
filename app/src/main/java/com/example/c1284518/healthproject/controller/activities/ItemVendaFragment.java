package com.example.c1284518.healthproject.controller.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.c1284518.healthproject.R;
import com.example.c1284518.healthproject.controller.SearchActivityW;
import com.example.c1284518.healthproject.controller.adapter_tab.ItemContaAdapterTab;
import com.example.c1284518.healthproject.model.entitites.ItemDeConta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c1284518 on 14/12/2015.
 */
public class ItemVendaFragment extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener {

    public final static String TAB_POSITION_KEY = "TAB_POSITION_KEY";
    public ListView mListView;
    public static Activity mContext;
    public ItemContaAdapterTab adapter2;
    List<ItemDeConta> listItem = getItensItem();
    List<ItemDeConta> listItem2 = new ArrayList<>();
    public static ItemVendaFragment itemVendaFragment;


    public static ItemVendaFragment getInstance(int position, Activity context){
        if(itemVendaFragment == null) {
            mContext = context;
            itemVendaFragment = new ItemVendaFragment();
            Bundle args = new Bundle();
            args.putInt(TAB_POSITION_KEY, position);
            itemVendaFragment.setArguments(args);
            return itemVendaFragment;
        } else {
            return itemVendaFragment;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getFKItens();
        bindAdapters();
        View layout = inflater.inflate(R.layout.recycler_view_fragment, container, false);
        mListView = (ListView) layout.findViewById(R.id.recyclerView);
        mListView.setOnItemClickListener(this);
        mListView.setAdapter(adapter2);

        return layout;

    }

    private void bindAdapters() {
        adapter2 = new ItemContaAdapterTab(mContext, listItem2);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public List<ItemDeConta> getItensItem(){
        listItem = new ArrayList<>();
        ItemDeConta i1 = new ItemDeConta(1, "Primeiro Item", 1);
        ItemDeConta i2 = new ItemDeConta(2, "Segundo Item", 2);
        listItem.add(i1);
        listItem.add(i2);
        return listItem;
    }

    public void getFKItens(){
        List<ItemDeConta> listItemConta = new ArrayList<>();
        for(ItemDeConta ic : listItem){
            if(ic.getFk_centro_id() == SearchActivityW.id_centro){
                listItemConta.add(ic);
            }
        }
        listItem2 = listItemConta;
    }
}
