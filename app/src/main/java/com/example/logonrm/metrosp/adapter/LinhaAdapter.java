package com.example.logonrm.metrosp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.logonrm.metrosp.R;
import com.example.logonrm.metrosp.model.Linha;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by logonrm on 26/06/2017.
 */

public class LinhaAdapter extends RecyclerView.Adapter<LinhaAdapter.LinhaViewHolder> {


    private List<Linha> linhas;


    public LinhaAdapter(List<Linha> linhas) {
        this.linhas = linhas;
    }

    @Override
    public LinhaAdapter.LinhaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View meuLayout = inflater.inflate(R.layout.linha_metro_row,
                parent, false);

        return new LinhaViewHolder(meuLayout);
    }

    @Override
    public void onBindViewHolder(LinhaAdapter.LinhaViewHolder holder, int position) {

        holder.tvNome.setText(linhas.get(position).getCor());
        holder.tvNumero.setText(linhas.get(position).getNumero());

        Picasso.with(holder.itemView.getContext())
                .load("http://10.3.1.29:3000"+linhas.get(position).getUrlImagem())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivLinha);

    }

    @Override
    public int getItemCount() {
        return linhas.size();
    }

    public class LinhaViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivLinha;
        public TextView tvNome;
        public TextView tvNumero;

        public LinhaViewHolder(View itemView) {
            super(itemView);

            ivLinha = (ImageView) itemView.findViewById(R.id.ivLinha);
            tvNome = (TextView) itemView.findViewById(R.id.tvNome);
            tvNumero = (TextView) itemView.findViewById(R.id.tvNumero);


        }
    }

    public  void update(List<Linha> linhas){
        this.linhas = linhas;
        notifyDataSetChanged();
    }
}
