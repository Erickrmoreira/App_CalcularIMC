package com.app.calcularimc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CadastroActivity extends AppCompatActivity {

    private EditText usuarioEditText;
    private EditText emailEditText;
    private EditText senhaEditText;
    private EditText confirmarSenhaEditText;
    private Button cadastrarUsuarioButton;

    private static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        usuarioEditText = findViewById(R.id.usuarioEditText);
        emailEditText = findViewById(R.id.emailEditText);
        senhaEditText = findViewById(R.id.senhaEditText);
        confirmarSenhaEditText = findViewById(R.id.confirmarSenhaEditText);
        cadastrarUsuarioButton = findViewById(R.id.cadastrarUsuarioButton);

        cadastrarUsuarioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarUsuario();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void cadastrarUsuario() {
        String usuario = usuarioEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String senha = senhaEditText.getText().toString();
        String confirmarSenha = confirmarSenhaEditText.getText().toString();

        if (TextUtils.isEmpty(usuario) || TextUtils.isEmpty(email) ||
                TextUtils.isEmpty(senha) || TextUtils.isEmpty(confirmarSenha)) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "E-mail inválido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (senha.contains(" ")) {
            Toast.makeText(this, "A senha não pode conter espaços", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!senha.equals(confirmarSenha)) {
            Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
            return;
        }

        salvarDados(usuario, email, senha);
        Toast.makeText(this, "Novo usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void salvarDados(String usuario, String email, String senha) {
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit();
        editor.putString("username", usuario);
        editor.putString("email", email);
        editor.putString("password", senha);
        editor.apply();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
