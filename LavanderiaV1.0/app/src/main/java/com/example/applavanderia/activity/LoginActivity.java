package com.example.applavanderia.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.applavanderia.R;
import com.example.applavanderia.activity.util.ParseErrors;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity{

    private TextView textoCriarCadastro;
    private TextView textoLogin;
    private TextView textoSenha;
    private Button botaoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textoCriarCadastro = (TextView)findViewById(R.id.texto_CriarCadastro);
        textoLogin = (TextView)findViewById(R.id.texto_Login);
        textoSenha = (TextView)findViewById(R.id.texto_Senha);
        botaoLogin = (Button) findViewById(R.id.botao_Login);


        // Habilite armazenamento local
        Parse.enableLocalDatastore(this);

        // Codigo de configuração do app
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build());


        //ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Opitionally enable public read access
        defaultACL.setPublicReadAccess(true);
        //ParseACL.setDefaultACL(defaultACL, true);

        ParseUser.logOut();

        //Verificar se o usuário está logado.
        verificarUsuarioLogado();

        //Adiciona evento de click no botão logar.
        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = textoLogin.getText().toString();
                String senha = textoSenha.getText().toString();
                verificarLogin(usuario, senha);
            }
        });

        textoCriarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });
    }

    private void verificarLogin(String usuario, String senha) {
        ParseUser.logInInBackground(usuario, senha, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e == null) { // sucesso no login
                    Toast.makeText(LoginActivity.this, "Login realizado com sucesso.", Toast.LENGTH_LONG).show();
                    abrirAreaPrincipal();
                }else {
                    ParseErrors parseErrors = new ParseErrors();
                    String erro = parseErrors.getErro(e.getCode());
                    Toast.makeText(LoginActivity.this, erro, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void verificarUsuarioLogado() {
        if (ParseUser.getCurrentUser() != null) {
            //Enviar usuário para tela principal do app
            abrirAreaPrincipal();
        }
    }

    private void abrirAreaPrincipal() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}