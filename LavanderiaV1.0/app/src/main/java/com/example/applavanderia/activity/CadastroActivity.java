package com.example.applavanderia.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.applavanderia.R;
import com.example.applavanderia.activity.util.ParseErrors;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class CadastroActivity extends AppCompatActivity {

    private EditText textoUsuario;
    private EditText textoEmail;
    private EditText textoSenha;
    private Button botaoCadastrar;
    private TextView textoLoginCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        textoUsuario = (EditText)findViewById(R.id.texto_Usuario);
        textoEmail = (EditText)findViewById(R.id.texto_Email);
        textoSenha = (EditText)findViewById(R.id.texto_SenhaCadastro);
        botaoCadastrar = (Button)findViewById(R.id.botao_Cadastrar);
        textoLoginCadastro = (TextView)findViewById(R.id.texto_LoginCadastro);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
            }
        });

        textoLoginCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void cadastrarUsuario() {
        //Criar objeto Usuario
        ParseUser usuario = new ParseUser();
        usuario.setUsername(textoUsuario.getText().toString());
        usuario.setEmail(textoEmail.getText().toString());
        usuario.setPassword(textoSenha.getText().toString());

        //Salvar dados do usuario
        usuario.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) { //Sucesso ao salvar
                    Toast.makeText(CadastroActivity.this, "Cadastro feito com sucesso.", Toast.LENGTH_LONG).show();
                    textoLoginCadastro.callOnClick();
                }else { //Erro ao salvar
                    ParseErrors parseErrors = new ParseErrors();
                    String erro = parseErrors.getErro(e.getCode());
                    Toast.makeText(CadastroActivity.this, erro, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}