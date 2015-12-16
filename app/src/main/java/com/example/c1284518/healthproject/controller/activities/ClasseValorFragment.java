package com.example.c1284518.healthproject.controller.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.c1284518.healthproject.R;
import com.example.c1284518.healthproject.controller.adapter_tab.ClasseValorAdapterTab;
import com.example.c1284518.healthproject.controller.adapter_tab.ItemContaAdapterTab;
import com.example.c1284518.healthproject.model.entitites.ClasseDeValor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c1284518 on 16/12/2015.
 */
public class ClasseValorFragment extends android.support.v4.app.Fragment {

    public final static String TAB_POSITION_KEY = "TAB_POSITION_KEY";
    public ListView mListView;
    public static Activity mContext;
    public ClasseValorAdapterTab adapter3;
    List<ClasseDeValor> listClasse = getItensClasse();

    public static ClasseValorFragment getInstance(int position, Activity context){
        mContext = context;
        ClasseValorFragment classeValorFragment = new ClasseValorFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION_KEY, position);
        classeValorFragment.setArguments(args);
        return  classeValorFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bindAdapters();
        View layout = inflater.inflate(R.layout.recycler_view_fragment, container, false);
        mListView = (ListView) layout.findViewById(R.id.recyclerView);
        mListView.setAdapter(adapter3);

        return layout;

    }



    private void bindAdapters() {
        adapter3 = new ClasseValorAdapterTab(mContext, listClasse);
    }


    public List<ClasseDeValor> getItensClasse() {
        List<ClasseDeValor> listaClasse = new ArrayList<>();
        ClasseDeValor cv1 = new ClasseDeValor(1, "Primeira classe", 1);
        ClasseDeValor cv2 = new ClasseDeValor(1, "Segunda classe", 1);
        listaClasse.add(cv1);
        listaClasse.add(cv2);
        return listaClasse;
    }

}
