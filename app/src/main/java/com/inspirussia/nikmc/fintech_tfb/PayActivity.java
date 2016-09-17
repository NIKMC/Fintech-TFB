package com.inspirussia.nikmc.fintech_tfb;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.inspirussia.nikmc.fintech_tfb.adapter.SpinnerCardAdapter;

import java.util.ArrayList;
import java.util.List;

public class PayActivity extends AppCompatActivity {


    private Spinner mCreditCard;
    private Button btnPay;
    private TextView tvPA,tvSum, tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mCreditCard = (Spinner) findViewById(R.id.etCard);
        btnPay = (Button)findViewById(R.id.btnPay);
        tvPA = (TextView) findViewById(R.id.tvPA);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvSum = (TextView) findViewById(R.id.tvSum);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValid();
            }
        });

        doInit();

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    private void doInit(){
        tvPA.setText("123");
        tvDate.setText("456");
        tvSum.setText("789");
        List<String> cards = new ArrayList<>();
        cards.add("счет1");
        cards.add("счет2");
        cards.add("счет3");
        cards.add("счет4");

        SpinnerCardAdapter adapter = new SpinnerCardAdapter( getApplicationContext(), cards);
        mCreditCard.setAdapter(adapter);
        mCreditCard.setPrompt("Счёт");
    }

    private void checkValid(){
     //compare money

        startActivity(new Intent(this, FinishActivity.class));
    }
}
