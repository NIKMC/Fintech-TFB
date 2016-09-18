package com.inspirussia.nikmc.fintech_tfb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.inspirussia.nikmc.fintech_tfb.rest.CreateRestAdapter;
import com.inspirussia.nikmc.fintech_tfb.rest.model.cards;

import java.io.IOException;
import java.util.List;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button btnPay = (Button) findViewById(R.id.btnPay);
        Button btnBuy = (Button) findViewById(R.id.btnSomethink);

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this, MainActivity.class));
            }
        });

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseActivity.this, PayActivity.class));
            }
        });

    }
}
