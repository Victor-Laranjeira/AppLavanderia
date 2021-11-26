package com.example.applavanderia.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.applavanderia.R;
import com.parse.ParseUser;

public class AlterarEmail extends AppCompatActivity {

    private Toolbar toolbarPrincipal;
    private Button botaoAlterar;
    private EditText alterarEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_email);

        //Configura toolbar
        toolbarPrincipal = findViewById(R.id.toolbar_Principal);
        setSupportActionBar(toolbarPrincipal);

        alterarEmail = findViewById(R.id.edit_Alterar);

        botaoAlterar = findViewById(R.id.botao_Alterar);
        botaoAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = alterarEmail.getText().toString();
                alterarEmail(email);
                Intent intent = new Intent(AlterarEmail.this, ConfiguracaoActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    public void alterarEmail(String email) {
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            // Other attributes than "email" will remain unchanged!
            currentUser.put("email", email);

            // Saves the object.
            currentUser.saveInBackground(e -> {
                if(e==null){
                    if (!email.equals("")) {
                        //Save successfull
                        Toast.makeText(this, "Novo e-mail salvo com sucesso", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(this, "Insira um e-mail válido.", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
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
                Intent intent = new Intent(AlterarEmail.this, ConfiguracaoActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}