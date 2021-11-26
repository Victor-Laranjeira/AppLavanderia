package com.example.applavanderia.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.applavanderia.R;
import com.parse.ParseUser;

public class ConfiguracaoActivity extends AppCompatActivity {

    private Toolbar toolbarPrincipal;
    private Button botaoExcluir;
    private Button botaoTrocarEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);

        //Configura toolbar
        toolbarPrincipal = (Toolbar) findViewById(R.id.toolbar_Principal);
        setSupportActionBar(toolbarPrincipal);

        botaoExcluir = findViewById(R.id.botao_Excluir);
        botaoExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excluirUsuario();
                finish();
                deslogarUsuario();
            }
        });

        botaoTrocarEmail = findViewById(R.id.botao_TrocarEmail);
        botaoTrocarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfiguracaoActivity.this, AlterarEmail.class);
                startActivity(intent);
                finish();
            }
        });


    }

    public void excluirUsuario() {
        // Notice that ParseUser extends ParseObject class, so we can
        // use the "remove" method in order to delete a single attribute.
        ParseUser currentUser = ParseUser.getCurrentUser();

        if (currentUser != null) {
            // Deletes the user.
            // Notice that the DeleteCallback is totally optional!
            currentUser.deleteInBackground(e -> {
                if(e==null){
                    //Delete successfull
                    Toast.makeText(this, "User was deleted", Toast.LENGTH_SHORT).show();
                }else{
                    // Something went wrong while deleting
                    Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    private void deslogarUsuario() {
        ParseUser.logOut();
        Intent intent = new Intent(ConfiguracaoActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_configuracao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_Voltar:
                Intent intent = new Intent(ConfiguracaoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}