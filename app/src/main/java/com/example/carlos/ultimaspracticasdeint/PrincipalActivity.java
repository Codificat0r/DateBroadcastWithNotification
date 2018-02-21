package com.example.carlos.ultimaspracticasdeint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class PrincipalActivity extends AppCompatActivity {

    private DatePicker dpkrFecha;
    private Button btnBroadcast;
    private String fechaSeleccionada;
    public static final String BUNDLE_BROADCAST_FECHA = "fecha";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        dpkrFecha = findViewById(R.id.dpkrFecha);
        btnBroadcast = findViewById(R.id.btnBroadcast);
        btnBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fechaSeleccionada = String.format("%02d",dpkrFecha.getDayOfMonth()) + "/" + String.format("%02d",dpkrFecha.getMonth() + 1) + "/" + String.format("%04d",dpkrFecha.getYear());
                mandarFechaBroadcast();
            }
        });
    }

    private void mandarFechaBroadcast() {
        Intent intent = new Intent("com.example.carlos.ultimaspracticasdeint.fecha");
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_BROADCAST_FECHA, fechaSeleccionada);
        intent.putExtras(bundle);
        sendBroadcast(intent);
    }
}
