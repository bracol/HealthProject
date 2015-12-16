package com.example.c1284518.healthproject.controller.activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.c1284518.healthproject.R;
import com.example.c1284518.healthproject.controller.Adapter.CentroCustoAdapter;
import com.example.c1284518.healthproject.controller.Adapter.ClasseValorAdapter;
import com.example.c1284518.healthproject.controller.Adapter.ItemContaAdapter;
import com.example.c1284518.healthproject.controller.SearchActivityW;
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
public class CentroCustoFragment extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener {

    public final static String TAB_POSITION_KEY = "TAB_POSITION_KEY";
    public ListView mListView;
    public static Activity mContext;
    private int mPosition;


    List<CentroDeCusto> listCentro = getItensCentro();
    List<ItemDeConta> listItem = getItensItem();
    List<ClasseDeValor> listClasse = getItensClasse();


    public CentroCustoAdapterTab adapter1;
    public ItemContaAdapterTab adapter2;
    public ClasseValorAdapterTab adapter3;

    public static CentroCustoFragment getInstance(int position, Activity context) {
        mContext = context;
        CentroCustoFragment centroCustoFragment = new CentroCustoFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION_KEY, position);
        centroCustoFragment.setArguments(args);
        return centroCustoFragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bindAdapters();
        View layout = inflater.inflate(R.layout.recycler_view_fragment, container, false);
        mListView = (ListView) layout.findViewById(R.id.recyclerView);
        mListView.setOnItemClickListener(this);
        //Bundle bundle = getArguments();
        //int position = bundle.getInt(TAB_POSITION_KEY);

        /*switch (position) {
            case 0:*/
                mListView.setAdapter(adapter1);
                /*break;
            case 1:
                mListView.setAdapter(adapter2);
                break;
            case 2:
                mListView.setAdapter(adapter3);
                break;
        }*/


        return layout;
    }


    private void bindAdapters() {
        adapter1 = new CentroCustoAdapterTab(mContext, listCentro);
        adapter2 = new ItemContaAdapterTab(mContext, listItem);
        adapter3 = new ClasseValorAdapterTab(mContext, listClasse);
    }

    public List<CentroDeCusto> getItensCentro() {
        listCentro = new ArrayList<>();
        CentroDeCusto c1 = new CentroDeCusto(1, "Primeiro");
        CentroDeCusto c2 = new CentroDeCusto(2, "Segundo");
        listCentro.add(c1);
        listCentro.add(c2);
        return listCentro;
    }

    public List<ItemDeConta> getItensItem() {
        listItem = new ArrayList<>();
        ItemDeConta i1 = new ItemDeConta(1, "Primeiro Item", 1);
        ItemDeConta i2 = new ItemDeConta(2, "Segundo Item", 2);
        listItem.add(i1);
        listItem.add(i2);
        return listItem;
    }

    public List<ClasseDeValor> getItensClasse() {
        listClasse = new ArrayList<>();
        ClasseDeValor cv1 = new ClasseDeValor(1, "Primeira classe", 1);
        ClasseDeValor cv2 = new ClasseDeValor(1, "Segunda classe", 1);
        listClasse.add(cv1);
        listClasse.add(cv2);
        return listClasse;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Object teste = parent.getItemAtPosition(position);
        //Bundle bundle = getArguments();
        //int mPosition = bundle.getInt(TAB_POSITION_KEY);
        if (teste instanceof CentroDeCusto) {
            SearchActivityW.id_centro = ((CentroDeCusto) (parent.getItemAtPosition(position))).get_id();
            View mView = SearchActivityW.mViewPager.getChildAt(SearchActivityW.mViewPager.getCurrentItem() + 1);
            ItemVendaFragment itemVendaFragment = ItemVendaFragment.getInstance(1, mContext);
            ItemContaAdapterTab itemContaAdapterTab = (ItemContaAdapterTab) itemVendaFragment.mListView.getAdapter();
            itemContaAdapterTab.setItens(getItensConta());
            itemContaAdapterTab.notifyDataSetChanged();
            SearchActivityW.mViewPager.setCurrentItem(SearchActivityW.mViewPager.getCurrentItem() + 1);
            //ItemContaAdapterTab itemContaAdapterTab = new ItemContaAdapterTab(mContext, getItensConta());
            //itemVendaFragment.mListView.setAdapter(itemContaAdapterTab);
            //ItemContaAdapterTab itemContaAdapterTab1 = (ItemContaAdapterTab) itemVendaFragment.mListView.getAdapter();
            //itemContaAdapterTab1.setItens(getItensConta());
            //itemContaAdapterTab1.notifyDataSetChanged();


            //ListView listView = (ListView) mView.findViewById(R.id.recyclerView);
            //listView.setAdapter(itemContaAdapterTab);



        } else if (teste instanceof ItemDeConta) {
            SearchActivityW.id_item = ((ItemDeConta) (parent.getItemAtPosition(position))).get_id();
            SearchActivityW.mViewPager.setCurrentItem(2);
        }
    }

    public List<ItemDeConta> getItensConta(){
        List<ItemDeConta> listItemConta = new ArrayList<>();
        for (ItemDeConta ic : listItem) {
            if (ic.getFk_centro_id() == SearchActivityW.id_centro) {
                listItemConta.add(ic);
            }
        }
        return listItemConta;
    }

    /*private void changeListAdapter(Adapter adapter) {

        if (adapter == adapter2) {
            List<ItemDeConta> listItemConta = new ArrayList<>();
            for (ItemDeConta ic : listItem) {
                if (ic.getFk_centro_id() == SearchActivityW.id_centro) {
                    listItemConta.add(ic);
                }
            }
            View mView = SearchActivityW.mViewPager.getChildAt(1);
            ListView listView = (ListView) mView.findViewById(R.id.recyclerView);
            ItemContaAdapterTab itemContaAdapterTab = (ItemContaAdapterTab) listView.getAdapter();
            itemContaAdapterTab.setItens(listItemConta);
            itemContaAdapterTab.notifyDataSetChanged();

        } else if (adapter == adapter3) {
            List<ClasseDeValor> listClasseDeValor = new ArrayList<>();
            for (ClasseDeValor cv : listClasse) {
                if (cv.getFk_item() == SearchActivityW.id_item) {
                    listClasseDeValor.add(cv);
                }
            }
            adapter3.setItens(listClasseDeValor);
            adapter3.notifyDataSetChanged();
        }
    }*/
}
