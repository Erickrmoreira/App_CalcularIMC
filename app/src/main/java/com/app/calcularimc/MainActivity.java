package com.app.calcularimc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imgEstadoSaude;
    private TextView txtEstadoSaude;
    private EditText edtPeso;
    private EditText edtAltura;
    private TextView txtResultado;
    private TextView txtConselho;
    private Button btnCalcular;
    private Button btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgEstadoSaude = findViewById(R.id.imgEstadoSaude);
        txtEstadoSaude = findViewById(R.id.txtEstadoSaude);
        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        txtResultado = findViewById(R.id.txtResultado);
        txtConselho = findViewById(R.id.txtConselho);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnSair = findViewById(R.id.btnSair);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoConfirmacaoLogout();
            }
        });
    }

    private void mostrarDialogoConfirmacaoLogout() {
        new AlertDialog.Builder(this)
                .setTitle("Confirmação de Logout")
                .setMessage("Tem certeza que deseja sair?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        fazerLogout();
                    }
                })
                .setNegativeButton("Não", null)
                .show();
    }

    private void fazerLogout() {
        getSharedPreferences("app_prefs", MODE_PRIVATE).edit().clear().apply();

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void calcularIMC() {
        String pesoStr = edtPeso.getText().toString().trim();
        String alturaStr = edtAltura.getText().toString().trim();

        if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
            Toast.makeText(this, "Preencha os campos de peso e altura.", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double peso = Double.parseDouble(pesoStr);
            double altura = Double.parseDouble(alturaStr);

            if (peso <= 0 || altura <= 0) {
                Toast.makeText(this, "Peso e altura devem ser maiores que zero.", Toast.LENGTH_SHORT).show();
                return;
            }

            double imc = peso / (altura * altura);
            txtResultado.setText(String.format("IMC: %.2f", imc));

            String conselho = obterConselhoComBaseNoIMC(imc);
            txtConselho.setText(conselho);

            exibirStatusDeSaude(imc);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Valores inválidos. Digite números válidos.", Toast.LENGTH_SHORT).show();
        }
    }

    private String obterConselhoComBaseNoIMC(double imc) {
        if (imc < 18.5) {
            return "Você está abaixo do peso ideal para a sua altura. Recomendamos consultar um profissional de saúde.";
        } else if (imc < 25) {
            return "Seu peso está dentro da faixa normal para a sua altura. Continue com hábitos saudáveis!";
        } else {
            return "Você está acima do peso ideal para a sua altura. Recomendamos consultar um profissional de saúde.";
        }
    }

    private void exibirStatusDeSaude(double imc) {
        String status;
        int imagemResource;

        if (imc < 18.5) {
            status = "Abaixo do peso";
            imagemResource = R.drawable.abaixo_do_peso_icon;
        } else if (imc < 25) {
            status = "Peso normal";
            imagemResource = R.drawable.peso_normal_icon;
        } else {
            status = "Acima do peso";
            imagemResource = R.drawable.acima_do_peso_icon;
        }

        imgEstadoSaude.setVisibility(View.VISIBLE);
        imgEstadoSaude.setImageResource(imagemResource);
        txtEstadoSaude.setText(status);
    }
}
