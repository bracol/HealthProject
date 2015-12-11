package com.example.c1284518.healthproject.controller.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.c1284518.healthproject.R;

/**
 * Created by c1284518 on 09/12/2015.
 */
public class CentroCustoAdapter extends RecyclerView.Adapter<CentroCustoAdapter.MyViewHolder> {



    @Override
    public CentroCustoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textViewRecycler);
        }

    }
}
