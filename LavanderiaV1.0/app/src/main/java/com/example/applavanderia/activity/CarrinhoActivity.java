package com.example.applavanderia.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.applavanderia.R;
import com.example.applavanderia.activity.model.CarrinhoTexto;

public class CarrinhoActivity extends AppCompatActivity {

    private TextView tituloCarrinho;
    private TextView descricaoCarrinho;
    private TextView precoCarrinho;
    private Button fazerPedido;
    private TextView precoSubTotal;
    private TextView precoTaxaEngrega;
    private TextView precoTotal;

    CarrinhoTexto carrinhoTexto = new CarrinhoTexto();

    private Toolbar toolbarPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        tituloCarrinho = findViewById(R.id.texto_TituloCarrinho);
        descricaoCarrinho = findViewById(R.id.texto_DescricaoCarrinho);
        precoCarrinho = findViewById(R.id.texto_PrecoCarrinho);
        precoSubTotal = findViewById(R.id.texto_PrecoSubTotal);
        precoTaxaEngrega = findViewById(R.id.texto_PrecoTaxaEntrega);
        precoTotal = findViewById(R.id.texto_PrecoTotal);

        //Configura toolbar
        toolbarPrincipal = findViewById(R.id.toolbar_Principal);
        setSupportActionBar(toolbarPrincipal);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int position = extras.getInt("position");
            int tipo = extras.getInt("tipo");
            carrinhoParametro(position, tipo);
        }


        tituloCarrinho.setText(carrinhoTexto.getTituloCarrinho());
        descricaoCarrinho.setText(carrinhoTexto.getDescricaoCarrinho());
        precoCarrinho.setText(carrinhoTexto.getPrecoCarrinho());
        precoSubTotal.setText(carrinhoTexto.getPrecoCarrinho());
        int taxaEntrega = 7;
        int precoTotal1 = Integer.parseInt(carrinhoTexto.getPrecoCarrinho());
        int total = taxaEntrega + precoTotal1;
        String total1 = String.valueOf(total);
        precoTotal.setText(total1);

        fazerPedido = findViewById(R.id.botao_FazerPedido);
        fazerPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CarrinhoActivity.this, "Pedido efetuado com sucesso.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CarrinhoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void carrinhoParametro (int position, int tipo) {
        if (position == 0 && tipo == 0) {
            carrinhoTexto.setTituloCarrinho("1 Peça (Lavagem simples)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem simples de 1 peça de roupa a sua escolha");
            carrinhoTexto.setPrecoCarrinho("5");
        }else if (position == 1 && tipo == 0) {
            carrinhoTexto.setTituloCarrinho("2 Peças (Lavagem simples)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem simples de 2 peça de roupa a sua escolha");
            carrinhoTexto.setPrecoCarrinho("10");
        }else if (position == 2 && tipo == 0) {
            carrinhoTexto.setTituloCarrinho("3 Peças (Lavagem simples)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem simples de 3 peça de roupa a sua escolha");
            carrinhoTexto.setPrecoCarrinho("17");
        }else if (position == 3 && tipo == 0) {
            carrinhoTexto.setTituloCarrinho("4 Peças (Lavagem simples)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem simples de 4 peça de roupa a sua escolha");
            carrinhoTexto.setPrecoCarrinho("24");
        }else if (position == 4 && tipo == 0) {
            carrinhoTexto.setTituloCarrinho("5 Peças (Lavagem simples)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem simples de 5 peça de roupa a sua escolha");
            carrinhoTexto.setPrecoCarrinho("30");
        }else if (position == 0 && tipo == 1) {
            carrinhoTexto.setTituloCarrinho("1 Peça (Lavagem completa)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem completa, tira manchas profundas com uso de produto adequados");
            carrinhoTexto.setPrecoCarrinho("11");
        }else if (position == 1 && tipo == 1) {
            carrinhoTexto.setTituloCarrinho("2 Peças (Lavagem completa)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem completa, tira manchas profundas com uso de produto adequados");
            carrinhoTexto.setPrecoCarrinho("22");
        }else if (position == 2 && tipo == 1) {
            carrinhoTexto.setTituloCarrinho("3 Peças (Lavagem completa)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem completa, tira manchas profundas com uso de produto adequados");
            carrinhoTexto.setPrecoCarrinho("35");
        }else if (position == 3 && tipo == 1) {
            carrinhoTexto.setTituloCarrinho("4 Peças (Lavagem completa)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem completa, tira manchas profundas com uso de produto adequados");
            carrinhoTexto.setPrecoCarrinho("47");
        }else if (position == 4 && tipo == 1) {
            carrinhoTexto.setTituloCarrinho("5 Peças (Lavagem completa)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem completa, tira manchas profundas com uso de produto adequados");
            carrinhoTexto.setPrecoCarrinho("60");
        }
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