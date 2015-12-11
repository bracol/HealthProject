package com.example.c1284518.healthproject.controller.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.c1284518.healthproject.R;
import com.example.c1284518.healthproject.controller.Adapter.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c1284518 on 08/12/2015.
 */
public class SearchActivity extends AppCompatActivity {

    private Spinner mCentroCusto;
    private Spinner mItemConta;
    private Spinner mClasseValor;
    private List<String> mLista = new ArrayList<>();
    private List<String> mListaConta = new ArrayList<>();
    private List<String> mListaClasse = new ArrayList<>();
    List<String> lista = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        bindCentroCusto();
        bindItemConta();
        bindClasseValor();

    }

    private void bindClasseValor() {
        mClasseValor = (Spinner) findViewById(R.id.classe_valor);
        mClasseValor.setEnabled(false);
        mClasseValor.setSelection(0);
        populateClasseValor();
        ClasseValorAdapter classeValorAdapter = new ClasseValorAdapter(this, mListaClasse);
        classeValorAdapter.setDropDownResource(android.R.layout.simple_spinner_dropdown_item);
        mClasseValor.setAdapter(classeValorAdapter);
    }

    private void populateClasseValor() {
        mListaClasse.clear();
        mListaClasse.add("Selecione uma classe de valor");
        mListaClasse.add("custo1 itemConta1  Classe Valor1");
        mListaClasse.add("custo1 itemConta2  Classe Valor2");
        mListaClasse.add("custo1 itemConta3  Classe Valor3");
        mListaClasse.add("custo2 itemConta4  Classe Valor5");
        mListaClasse.add("custo2 itemConta5  Classe Valor4");
    }

    private void bindItemConta() {
        mItemConta = (Spinner) findViewById(R.id.item_conta);
        mItemConta.setEnabled(false);
        mItemConta.setSelection(0);
        populateItemConta();
        ItemContaAdapter itemContaAdapter = new ItemContaAdapter(this, mListaConta);
        itemContaAdapter.setDropDownResource(android.R.layout.simple_spinner_dropdown_item);
        mItemConta.setAdapter(itemContaAdapter);
        mItemConta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!(parent.getSelectedItemId() == 0)) {
                    mClasseValor.setEnabled(true);
                    mClasseValor.setSelection(0);
                } else
                    mClasseValor.setEnabled(false);
                updateItensClasse((String) parent.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void populateItemConta() {
        mListaConta.clear();
        mListaConta.add("Selecione um item de conta");
        mListaConta.add("custo1 itemConta1");
        mListaConta.add("custo1 itemConta2");
        mListaConta.add("custo1 itemConta3");
        mListaConta.add("custo2 itemConta4");
        mListaConta.add("custo2 itemConta5");
    }

    private void bindCentroCusto() {
        mCentroCusto = (Spinner) findViewById(R.id.centro_custo);
        populateList();
        CentroCustoAdapter centroCustoAdapter = new CentroCustoAdapter(this, mLista);
        centroCustoAdapter.setDropDownResource(android.R.layout.simple_spinner_dropdown_item);
        mCentroCusto.setAdapter(centroCustoAdapter);
        mCentroCusto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!(parent.getSelectedItemPosition() == 0)) {
                    mItemConta.setEnabled(true);
                    mItemConta.setSelection(0);
                    mClasseValor.setEnabled(false);
                } else {
                    mItemConta.setEnabled(false);
                    mClasseValor.setEnabled(false);
                }
                updateItens((String) parent.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void updateItens(String s) {
        lista.clear();
        lista.add("Selecione um custo");
        populateItemConta();
        if(!s.equals("Selecione um custo")){
            for(String st : mListaConta){
                if(st.contains(s)){
                    lista.add(st);
                }
            }
        }

        ItemContaAdapter adapter = (ItemContaAdapter) mItemConta.getAdapter();
        adapter.setItens(lista);
        adapter.notifyDataSetChanged();
        updateItensClasse("");
    }

    private void updateItensClasse(String s) {
        lista.clear();
        lista.add("Selecione uma classe de valor");
        populateClasseValor();
        if(!s.equals("Selecione uma classe de valor")){
            for(String st : mListaClasse){
                if(st.contains(s)){
                    lista.add(st);
                }
            }
        }

        ClasseValorAdapter adapter = (ClasseValorAdapter) mClasseValor.getAdapter();
        adapter.setItens(lista);
        adapter.notifyDataSetChanged();
    }



    private void populateList(){
        mLista.add("Selecione um custo");
        mLista.add("custo1");
        mLista.add("custo2");
        mLista.add("custo3");
        mLista.add("custo4");
        mLista.add("custo5");
    }
}
