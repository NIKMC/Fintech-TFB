package com.inspirussia.nikmc.fintech_tfb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.inspirussia.nikmc.fintech_tfb.rest.CreateRestAdapter;
import com.inspirussia.nikmc.fintech_tfb.rest.model.cards;

import java.io.IOException;
import java.util.List;

public class ChooseActivity extends AppCompatActivity {


    private static final String TYPE_SCAN = "TYPE_SCAN";
    private static final String SCAN_GAS = "0";
    private static final String SCAN_GKH = "1";
    private static final String CYPHER_CODE= "scanned_сode";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button btnGkh = (Button) findViewById(R.id.btnGkh);
        Button btnGas = (Button) findViewById(R.id.btnGas);

        btnGas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*IntentIntegrator scanIntegrator = new IntentIntegrator(ChooseActivity.this);
                scanIntegrator.createScanIntent().putExtra(TYPE_SCAN,SCAN_GAS);
                scanIntegrator.initiateScan();
*/
                startActivity(new Intent(ChooseActivity.this, MainActivity.class).putExtra(TYPE_SCAN,SCAN_GAS));
            }
        });

        btnGkh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                IntentIntegrator scanIntegrator = new IntentIntegrator(ChooseActivity.this).addExtra(TYPE_SCAN,SCAN_GKH);
//                scanIntegrator.initiateScan();
                startActivity(new Intent(ChooseActivity.this, MainActivity.class).putExtra(TYPE_SCAN,SCAN_GKH));
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //retrieve scan result
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        Log.d("lololo", "resultCode = " + resultCode);
        if (resultCode == RESULT_OK) {
            if (scanningResult != null) {
                //we have a result
                intent.getStringExtra(TYPE_SCAN);
                String scanContent = scanningResult.getContents();
                Intent i = new Intent(this, PayActivity.class);
                Log.d("lolo", "scan = " + intent.getStringExtra(TYPE_SCAN) +"||||"+ scanContent);
                if (intent.getStringExtra(TYPE_SCAN) != null) {
                    if (intent.getStringExtra(TYPE_SCAN) == SCAN_GAS) {
                        i.putExtra(TYPE_SCAN, SCAN_GAS);
                    } else if (intent.getStringExtra(TYPE_SCAN) == SCAN_GKH) {
                        i.putExtra(TYPE_SCAN, SCAN_GKH);
                    }
                }
                i.putExtra(CYPHER_CODE, scanContent);
                startActivity(i);
            } else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "No scan data received!", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
