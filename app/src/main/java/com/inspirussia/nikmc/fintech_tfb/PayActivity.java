package com.inspirussia.nikmc.fintech_tfb;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.inspirussia.nikmc.fintech_tfb.adapter.SpinnerCardAdapter;

import java.util.ArrayList;
import java.util.List;

public class PayActivity extends AppCompatActivity {

    private static final String TYPE_SCAN = "TYPE_SCAN";
    private static final String SCAN_GAS = "0";
    private static final String SCAN_GKH = "1";

    private Spinner mCreditCard;
    private Button btnPay;
    private TextView tvPA,tvSum, tvDate;
    private static final String CYPHER_CODE="scanned_сode";
    private String plainCode;
    private TextView code;
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



//        code=(TextView) findViewById(R.id.showCode);
//        code.setText(plainCode);
    }

    private void doInit(){
        String plainCode = getIntent().getStringExtra(CYPHER_CODE);
        Log.d("LOLOL", "type = " + getIntent().getStringExtra(TYPE_SCAN) +"| "+ plainCode);
        if (getIntent().getStringExtra(TYPE_SCAN).equals(SCAN_GAS)){
            try {
                if (plainCode.toCharArray().length > 9) {
                    tvPA.setText(plainCode.toString().substring(5, 14));
                    tvSum.setText(Integer.parseInt(plainCode.toString().substring(14, 20)) + "," + Integer.parseInt(plainCode.toString().substring(20, 22)));
                }
            }catch (NullPointerException e){
                Toast toast = Toast.makeText(getApplicationContext(),
                        "No scan data received! Please go back and retry", Toast.LENGTH_SHORT);
                toast.show();
            }
        } else if (getIntent().getStringExtra(TYPE_SCAN).equals(SCAN_GKH)){
            try {
                if (plainCode.toCharArray().length >9) {
                    tvPA.setText(plainCode.toString().substring(2, 12));
                    tvDate.setText(plainCode.toString().substring(12,14) + "/" + plainCode.toString().substring(14,16));
                    tvSum.setText(Integer.parseInt(plainCode.toString().substring(16,25))+"," + Integer.parseInt(plainCode.toString().substring(25,27)));

                }
            }catch (NullPointerException e){
                Toast toast = Toast.makeText(getApplicationContext(),
                        "No scan data received! Please go back and retry", Toast.LENGTH_SHORT);
                toast.show();
            }

        }


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
