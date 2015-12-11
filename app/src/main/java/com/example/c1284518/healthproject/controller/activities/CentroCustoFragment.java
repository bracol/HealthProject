package com.example.c1284518.healthproject.controller.activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.c1284518.healthproject.R;
import com.example.c1284518.healthproject.controller.Adapter.CentroCustoAdapter;
import com.example.c1284518.healthproject.controller.adapter_tab.CentroCustoAdapterTab;
import com.example.c1284518.healthproject.controller.adapter_tab.ClasseValorAdapterTab;
import com.example.c1284518.healthproject.controller.adapter_tab.ItemContaAdapterTab;
import com.example.c1284518.healthproject.model.entitites.CentroDeCusto;
import com.example.c1284518.healthproject.model.entitites.ClasseDeValor;
import com.example.c1284518.healthproject.model.entitites.ItemDeConta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c1284518 on 09/12/2015.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CentroCustoFragment extends android.support.v4.app.Fragment {

    public final static String TAB_POSITION_KEY = "TAB_POSITION_KEY";
    public final static String ID_CENTRO_CUSTO = "ID_CENTRO_CUSTO";
    public final static String ID_ITEM_VENDA = "ID_ITEM_VENDA";
    private int id_centro;
    private int id_item;
    public RecyclerView mRecyclerView;
    public ListView mListView;
    public static Activity mContext;
    public RecyclerView.LayoutManager mLayoutManager;
    //public String[] itens1 = {"ITEM 1", "ITEM 2", "ITEM 3"};
    //public String[] itens2 = {"ITEM 10", "ITEM 20", "ITEM 30"};
    //public String[] itens3 = {"ITEM 100", "ITEM 200", "ITEM 300"};




    List<CentroDeCusto> listCentro = getItensCentro();
    List<ItemDeConta> listItem = getItensItem();
    List<ClasseDeValor> listClasse = getItensClasse();


    public CentroCustoAdapterTab adapter1;
    public ItemContaAdapterTab adapter2;
    public ClasseValorAdapterTab adapter3;

    public static CentroCustoFragment getInstance(int position, Activity context){
        mContext = context;
        CentroCustoFragment centroCustoFragment = new CentroCustoFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION_KEY, position);
        centroCustoFragment.setArguments(args);
        return  centroCustoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bindAdapters();
        View layout = inflater.inflate(R.layout.recycler_view_fragment, container, false);
        bindListView(layout);
        Bundle bundle = getArguments();
        int position = bundle.getInt(TAB_POSITION_KEY);


        switch (position){
            case 0:
                mListView.setAdapter(adapter1); break;
            case 1:
                mListView.setAdapter(adapter2); break;
            case 2:
                mListView.setAdapter(adapter3); break;

        }

        return layout;
    }

    public void bindListView(View v){
        mListView = (ListView) v.findViewById(R.id.recyclerView);
    }

    private void bindAdapters() {
        adapter1 = new CentroCustoAdapterTab(mContext, listCentro);
        adapter2 = new ItemContaAdapterTab(mContext, listItem);
        adapter3 = new ClasseValorAdapterTab(mContext, listClasse);
    }

    public List<CentroDeCusto> getItensCentro(){
        listCentro = new ArrayList<>();
        CentroDeCusto c1 = new CentroDeCusto(1, "Primeiro");
        CentroDeCusto c2 = new CentroDeCusto(2, "Segundo");
        listCentro.add(c1);
        listCentro.add(c2);
        return listCentro;
    }

    public List<ItemDeConta> getItensItem(){
        listItem = new ArrayList<>();
        ItemDeConta i1 = new ItemDeConta(1, "Primeiro Item", 1);
        ItemDeConta i2 = new ItemDeConta(2, "Segundo Item", 2);
        listItem.add(i1);
        listItem.add(i2);
        return listItem;
    }

    public List<ClasseDeValor> getItensClasse(){
        listClasse = new ArrayList<>();
        ClasseDeValor cv1 = new ClasseDeValor(1, "Primeira classe", 1);
        ClasseDeValor cv2 = new ClasseDeValor(1, "Segunda classe", 1);
        listClasse.add(cv1);
        listClasse.add(cv2);
        return listClasse;
    }
}
