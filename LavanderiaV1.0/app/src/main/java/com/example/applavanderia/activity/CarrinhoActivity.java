package com.example.applavanderia.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.applavanderia.R;
import com.example.applavanderia.activity.model.Lavagem;

public class CarrinhoActivity extends AppCompatActivity {

    private TextView tituloCarrinho;
    private TextView descricaoCarrinho;
    private TextView precoCarrinho;

    private Toolbar toolbarPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        tituloCarrinho = findViewById(R.id.texto_TituloCarrinho);
        descricaoCarrinho = findViewById(R.id.texto_DescricaoCarrinho);
        precoCarrinho = findViewById(R.id.texto_PrecoCarrinho);

        //Configura toolbar
        toolbarPrincipal = findViewById(R.id.toolbar_Principal);
        setSupportActionBar(toolbarPrincipal);

        //Configurando texto do CarrinhoActicity
        Lavagem lavagem = new Lavagem();

        tituloCarrinho.setText(lavagem.getTitulo());
        descricaoCarrinho.setText(lavagem.getDescricao());
        precoCarrinho.setText(lavagem.getPreco());
//
//        CarrinhoTexto carrinhoTexto = new CarrinhoTexto(lavagem.getTitulo(),lavagem.getDescricao(),lavagem.getPreco());
//        carrinhoTexto.setTituloCarrinho(carrinhoTexto.getTituloCarrinho());
//        carrinhoTexto.setDescricaoCarrinho(carrinhoTexto.getDescricaoCarrinho());
//        carrinhoTexto.setPrecoCarrinho(carrinhoTexto.getPrecoCarrinho());



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_carrinho, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_Limpar:


                Intent intent = new Intent(CarrinhoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}