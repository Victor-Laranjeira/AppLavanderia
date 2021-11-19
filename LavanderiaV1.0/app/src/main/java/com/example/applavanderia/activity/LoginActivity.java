package com.example.applavanderia.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.applavanderia.R;
import com.parse.Parse;
import com.parse.ParseACL;

public class LoginActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView textCadastro = (TextView)findViewById(R.id.texto_CriarCadastro);


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

        TextView textoCriarCadastro = (TextView)findViewById(R.id.texto_CriarCadastro);
        textoCriarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });








//        /****** Cadastro de Usuários*/
//
////        ParseUser usuario = new ParseUser();
////        usuario.setUsername("joao");
////        usuario.setPassword("1234");
////        usuario.setEmail("victor-larnjeira1@hotmail.com");
////
////        //Cadastrar
////        usuario.signUpInBackground(new SignUpCallback() {
////            @Override
////            public void done(ParseException e) {
////                if (e == null) {
////                    Log.i("CadastroUsuario", "Sucesso ao cadastrar usuario");
////                }else {
////                    Log.i("CadastroUsuario", "Erro ao cadastrar usuario" + e.getMessage());
////                }
////            }
////        });
//
//        /**********
//         * Verificar usuari logado */
//
//        //desloga
//        ParseUser.logOut();
//
//        //Verifica usuario logado
//        if (ParseUser.getCurrentUser() != null) { //Logado
//            Log.i("LoginUsuario", "Usuário está logado");
//        }else { //Não logado
//            Log.i("LoginUsuario", "Usuário não está logado");
//        }
    }
}