package com.example.projectelogger;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PaginaLogoutFinal extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.logout_vista);


        TextView tvMissatge = findViewById(R.id.tvDespedida);
        Button btnTornarLogin = findViewById(R.id.btnTornarLogIn);

        Bundle bundle = getIntent().getExtras();
        String nomUsuari = "";
        if (bundle != null) {
            nomUsuari = bundle.getString("nomUsuari", "");
        }

        tvMissatge.setText("Sessió tancada correctament. Fins aviat, " + nomUsuari + "!");

        btnTornarLogin.setOnClickListener(v -> {
            Intent intent = new Intent(PaginaLogoutFinal.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

