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
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.c1284518.healthproject.R;
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


    public ArrayAdapter<CentroDeCusto> adapter1 = new ArrayAdapter<CentroDeCusto>(mContext, android.R.layout.simple_list_item_1, listCentro);
    public ArrayAdapter<ItemDeConta> adapter2 = new ArrayAdapter<ItemDeConta>(mContext, android.R.layout.simple_list_item_1, listItem);
    public ArrayAdapter<ClasseDeValor> adapter3 = new ArrayAdapter<ClasseDeValor>(mContext, android.R.layout.simple_list_item_1, listClasse);

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
        View layout = inflater.inflate(R.layout.recycler_view_fragment, container, false);
        Bundle bundle = getArguments();
        int position = bundle.getInt(TAB_POSITION_KEY);
        mListView = (ListView) layout.findViewById(R.id.recyclerView);

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
