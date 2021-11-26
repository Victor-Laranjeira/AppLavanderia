package com.example.applavanderia.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applavanderia.R;
import com.example.applavanderia.activity.model.LavagemCompleta;

import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.MyViewHolder> {

    private List<LavagemCompleta> listaLavagem2;

    public Adapter2(List<LavagemCompleta> listaLavagem2) {
        this.listaLavagem2 = listaLavagem2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.adapter_lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        LavagemCompleta lavagem = listaLavagem2.get(position);
        holder.titulo.setText(lavagem.getTitulo());
        holder.descricao.setText(lavagem.getDescricao());
        holder.real.setText("R$");
        holder.preco.setText(lavagem.getPreco());
    }

    @Override
    public int getItemCount() {
        return listaLavagem2.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView descricao;
        TextView real;
        TextView preco;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.texto_Titulo);
            descricao = itemView.findViewById(R.id.texto_Descricao);
            real = itemView.findViewById(R.id.texto_Real);
            preco = itemView.findViewById(R.id.texto_Preco);

        }
    }

}
