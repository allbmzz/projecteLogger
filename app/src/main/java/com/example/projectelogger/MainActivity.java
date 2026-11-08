package com.example.projectelogger;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CICLE_VIDA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etUsuari = findViewById(R.id.etNomUsuari);
        EditText etContrasenya = findViewById(R.id.etConstrasenya);

        Button btnLogIn = findViewById(R.id.btnLogin);

        btnLogIn.setOnClickListener(vistaLogIn -> {

            Intent intent = new Intent(MainActivity.this,PaginaLogout.class);
            Bundle bundle = new Bundle();

            String usuari =  etUsuari.getText().toString();
            String contrasenya = etContrasenya.getText().toString();

            if (usuari.isEmpty()) {
                etUsuari.setText("El nom d'usuari és obligatori");
                return;
            }
            if (contrasenya.isEmpty()) {
                etContrasenya.setText("La contrasenya és obligatòria");
                return;
            }


            intent.putExtra("nomUsuari", usuari);
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