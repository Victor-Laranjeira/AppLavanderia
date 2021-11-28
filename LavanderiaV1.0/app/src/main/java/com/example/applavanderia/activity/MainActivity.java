package com.example.applavanderia.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applavanderia.R;
import com.example.applavanderia.activity.adapter.Adapter;
import com.example.applavanderia.activity.adapter.Adapter2;
import com.example.applavanderia.activity.model.CarrinhoTexto;
import com.example.applavanderia.activity.model.Lavagem;
import com.example.applavanderia.activity.model.LavagemCompleta;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbarPrincipal;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private List<Lavagem> listaLavagem = new ArrayList<>();
    private List<LavagemCompleta> listaLavagem2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Configura toolbar
        toolbarPrincipal = findViewById(R.id.toolbar_Principal);
        setSupportActionBar(toolbarPrincipal);

        recyclerView1 = findViewById(R.id.recycler_View1);
        recyclerView2 = findViewById(R.id.recycler_View2);

        //Listagem de lavagem simples
        this.criarLavagem();

        //Listagem de lavagem completa
        this.criarLavagemCompleta();

        //Configurar Adapater
        Adapter adapter = new Adapter(listaLavagem);
        Adapter2 adapter2 = new Adapter2(listaLavagem2);


        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getApplicationContext());
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView1.setAdapter(adapter);

        //Configurar evento de click lavagem simples
        recyclerView1.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView1,
                        new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int tipo = 0;
                Intent intent = new Intent(MainActivity.this, CarrinhoActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("tipo", tipo);
                startActivity(intent);
                finish();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                int tipo = 0;
                Intent intent = new Intent(MainActivity.this, CarrinhoActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("tipo", tipo);
                startActivity(intent);
                finish();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));



        //Configurar RecyclerView2
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView2.setAdapter(adapter2);

        //Configurar evento de click lavagem completa
        recyclerView2.addOnItemTouchListener(
                    new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView2,
                        new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int tipo = 1;
                Intent intent = new Intent(MainActivity.this, CarrinhoActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("tipo", tipo);
                startActivity(intent);
                finish();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                int tipo = 1;
                Intent intent = new Intent(MainActivity.this, CarrinhoActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("tipo", tipo);
                startActivity(intent);
                finish();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    private void deslogarUsuario() {
        ParseUser.logOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_Sair:
                deslogarUsuario();
                return true;
            case R.id.action_Configuracoes:
                Intent intent = new Intent(MainActivity.this, ConfiguracaoActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void criarLavagem() {
        Lavagem lavagem = new Lavagem("1 Peça (Lavagem simples)", "Lavagem simples de 1 peça de roupa a sua escolha", "5,00");
        this.listaLavagem.add(lavagem);
        lavagem = new Lavagem("2 Peças (Lavagem simples)", "Lavagem simples de 2 peça de roupa a sua escolha", "10,00");
        this.listaLavagem.add(lavagem);
        lavagem = new Lavagem("3 Peça (Lavagem simples)", "Lavagem simples de 3 peça de roupa a sua escolha", "17,00");
        this.listaLavagem.add(lavagem);
        lavagem = new Lavagem("4 Peça (Lavagem simples)", "Lavagem simples de 4 peça de roupa a sua escolha", "24,00");
        this.listaLavagem.add(lavagem);
        lavagem = new Lavagem("5 Peça (Lavagem simples)", "Lavagem simples de 5 peça de roupa a sua escolha", "30,00");
        this.listaLavagem.add(lavagem);
    }

    public void criarLavagemCompleta() {
        LavagemCompleta lavagemCompleta = new LavagemCompleta("1 peça (Lavagem completa)", "Lavagem completa, tira manchas profundas com uso de produto adequado", "11,00");
        this.listaLavagem2.add(lavagemCompleta);
        lavagemCompleta = new LavagemCompleta("2 peças (Lavagem completa)", "Lavagem completa, tira manchas profundas com uso de produto adequado", "22,00");
        this.listaLavagem2.add(lavagemCompleta);
        lavagemCompleta = new LavagemCompleta("3 peças (Lavagem completa)", "Lavagem completa, tira manchas profundas com uso de produto adequado", "35,00");
        this.listaLavagem2.add(lavagemCompleta);
        lavagemCompleta = new LavagemCompleta("4 peças (Lavagem completa)", "Lavagem completa, tira manchas profundas com uso de produto adequado", "47,00");
        this.listaLavagem2.add(lavagemCompleta);
        lavagemCompleta = new LavagemCompleta("5 peças (Lavagem completa)", "Lavagem completa, tira manchas profundas com uso de produto adequado", "60,00");
        this.listaLavagem2.add(lavagemCompleta);
    }

    public void carrinhoParametroSimples(int position) {
        CarrinhoTexto carrinhoTexto = new CarrinhoTexto();
        if (position == 0) {
            carrinhoTexto.setTituloCarrinho("1 Peça (Lavagem simples)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem simples de 1 peça de roupa a sua escolha");
            carrinhoTexto.setPrecoCarrinho("5,00");
        }else if (position == 1) {
            carrinhoTexto.setTituloCarrinho("2 Peças (Lavagem simples)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem simples de 2 peça de roupa a sua escolha");
            carrinhoTexto.setPrecoCarrinho("10,00");
        }else if (position == 2) {
            carrinhoTexto.setTituloCarrinho("3 Peças (Lavagem simples)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem simples de 3 peça de roupa a sua escolha");
            carrinhoTexto.setPrecoCarrinho("17,00");
        }else if (position == 3) {
            carrinhoTexto.setTituloCarrinho("4 Peças (Lavagem simples)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem simples de 4 peça de roupa a sua escolha");
            carrinhoTexto.setPrecoCarrinho("24,00");
        }else if (position == 4) {
            carrinhoTexto.setTituloCarrinho("5 Peças (Lavagem simples)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem simples de 5 peça de roupa a sua escolha");
            carrinhoTexto.setPrecoCarrinho("30,00");
        }
    }

    public void carrinhoParametroCompleto (int position) {
        CarrinhoTexto carrinhoTexto = new CarrinhoTexto();
        if (position == 0) {
            carrinhoTexto.setTituloCarrinho("1 Peça (Lavagem completa)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem completa, tira manchas profundas com uso de produto adequados");
            carrinhoTexto.setPrecoCarrinho("11,00");
        }else if (position == 1) {
            carrinhoTexto.setTituloCarrinho("2 Peças (Lavagem completa)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem completa, tira manchas profundas com uso de produto adequados");
            carrinhoTexto.setPrecoCarrinho("22,00");
        }else if (position == 2) {
            carrinhoTexto.setTituloCarrinho("3 Peças (Lavagem completa)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem completa, tira manchas profundas com uso de produto adequados");
            carrinhoTexto.setPrecoCarrinho("35,00");
        }else if (position == 3) {
            carrinhoTexto.setTituloCarrinho("4 Peças (Lavagem completa)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem completa, tira manchas profundas com uso de produto adequados");
            carrinhoTexto.setPrecoCarrinho("47,00");
        }else if (position == 4) {
            carrinhoTexto.setTituloCarrinho("5 Peças (Lavagem completa)");
            carrinhoTexto.setDescricaoCarrinho("Lavagem completa, tira manchas profundas com uso de produto adequados");
            carrinhoTexto.setPrecoCarrinho("60,00");
        }
    }

}