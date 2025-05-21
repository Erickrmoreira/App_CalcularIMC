package com.app.calcularimc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usuarioEditText;
    private EditText senhaEditText;
    private Button loginBotao;
    private Button cadastrarBotao;

    // Chave para salvar dados no SharedPreferences
    private static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuarioEditText = findViewById(R.id.usuarioEditText);
        senhaEditText = findViewById(R.id.senhaEditText);
        loginBotao = findViewById(R.id.loginButton);
        cadastrarBotao = findViewById(R.id.cadastrarButton);

        carregarDadosSalvos();

        cadastrarBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        loginBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = usuarioEditText.getText().toString().trim();
                String senha = senhaEditText.getText().toString();

                // Validação de campos não vazios
                if (TextUtils.isEmpty(usuario) || TextUtils.isEmpty(senha)) {
                    Toast.makeText(LoginActivity.this, "Preencha usuário e senha", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Autenticar usuário
                int resultado = autenticarUsuario(usuario, senha);
                if (resultado == 0) {
                    Toast.makeText(LoginActivity.this, "Usuário não encontrado", Toast.LENGTH_SHORT).show();
                } else if (resultado == 1) {
                    Toast.makeText(LoginActivity.this, "Senha incorreta", Toast.LENGTH_SHORT).show();
                } else {
                    // Sucesso no login, salva estado de login
                    salvarEstadoLogin(usuario);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private int autenticarUsuario(String usuario, String senha) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String usuarioSalvo = prefs.getString("username", null);
        String senhaSalva = prefs.getString("password", null);

        if (usuarioSalvo == null || !usuario.equals(usuarioSalvo)) {
            return 0; // usuário não encontrado
        }

        if (!senha.equals(senhaSalva)) {
            return 1; // senha incorreta
        }

        return 2; // sucesso
    }

    // Salva o estado de login no SharedPreferences. //
    private void salvarEstadoLogin(String usuario) {
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();
        editor.putString("username", usuario);
        editor.putBoolean("isLoggedIn", true); // flag para indicar usuário logado
        editor.apply();
    }

    private void carregarDadosSalvos() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String usuarioSalvo = prefs.getString("username", "");
        usuarioEditText.setText(usuarioSalvo);
    }
}
