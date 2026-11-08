package com.example.projectelogger;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PaginaLogout extends AppCompatActivity {

    static final String TAG = "CICLE_VIDA";

    @Override
    public void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_vista);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.loginMain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvUsuari = findViewById(R.id.tvUsuari);

        Button btnAcabar = findViewById(R.id.btnAcabar);

        String nomFinal;

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String nomRebut = bundle.getString("nomUsuari");
            if (nomRebut != null && !nomRebut.trim().isEmpty()) {
                nomFinal = nomRebut;
            } else {
                nomFinal = "usuari";
            }
        } else {
            nomFinal = "usuari";
        }

        tvUsuari.setText("Benvingut , " + nomFinal + "!");

        btnAcabar.setOnClickListener( v -> {
                Intent intent = new Intent(PaginaLogout.this, PaginaLogoutFinal.class);

                Bundle bundl = new Bundle();
                bundl.putString("nomUsuari", nomFinal);
                intent.putExtras(bundle);


                startActivity(intent);
                finish();
            });

        }

    @Override
    protected void onResume(){
        super.onResume();

        Log.d(TAG,"onResume");
    }

    @Override
    protected void onStart(){
        super.onStart();

        Log.d(TAG,"onStart");
    }

    @Override
    protected void onPause(){
        super.onPause();

        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();

        Log.d(TAG,"onStop");
    }

}

