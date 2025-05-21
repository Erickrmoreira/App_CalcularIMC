/*AQUI ERA UMA FUNCIONALIDADE QUE EU PENSEI ADICIONAR NA ÉPOCA, PORÉM NÃO PROSSEGUI.*/

/*package com.app.calcularimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HistoricoActivity extends AppCompatActivity {

    private TextView historicoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        historicoTextView = findViewById(R.id.historicoTextView);

        // Exiba o histórico ao iniciar a Activity
        exibirHistorico();
    }

    private void exibirHistorico() {
        // Obtenha o SharedPreferences
        SharedPreferences prefs = getSharedPreferences("HistoricoIMC", Context.MODE_PRIVATE);

        // Obtenha os registros salvos
        String registrosSalvos = prefs.getString("historico", "");

        // Exiba os registros no TextView
        historicoTextView.setText(registrosSalvos);
    }
}
*/