package com.example.carlos.ultimaspracticasdeint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DateInformationActivity extends AppCompatActivity {

    private TextView txvFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_information);

        txvFecha = findViewById(R.id.txvFecha);

        txvFecha.setText(getIntent().getExtras().getString(PrincipalActivity.BUNDLE_BROADCAST_FECHA));
    }
}
