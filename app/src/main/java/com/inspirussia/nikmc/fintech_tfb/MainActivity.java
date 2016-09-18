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
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/*
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
*/

public class MainActivity extends AppCompatActivity {

    private Button scan;
    private static final String TYPE_SCAN = "TYPE_SCAN";
    private static final String SCAN_GAS = "0";
    private static final String SCAN_GKH = "1";
    private static final String CYPHER_CODE= "scanned_сode";
    private Intent mainIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainIntent = getIntent();

        doInt();

/*
        scan = (Button) findViewById(R.id.buttonScan);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator scanIntegrator = new IntentIntegrator(MainActivity.this);
                scanIntegrator.initiateScan();
            }
        });
*/

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void doInt(){
        IntentIntegrator scanIntegrator = new IntentIntegrator(MainActivity.this);
        scanIntegrator.initiateScan();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //retrieve scan result
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        Log.d("lololo", "resultCode = " + resultCode);
        if (resultCode == RESULT_OK) {
            if (scanningResult != null) {
                //we have a result
                mainIntent.getStringExtra(TYPE_SCAN);
                String scanContent = scanningResult.getContents();
                Intent i = new Intent(this, PayActivity.class);
                Log.d("lolo", "scan = " + mainIntent.getStringExtra(TYPE_SCAN) +"||||"+ scanContent);
                if (mainIntent.getStringExtra(TYPE_SCAN) != null) {
                    if (mainIntent.getStringExtra(TYPE_SCAN).equals(SCAN_GAS)) {
                        i.putExtra(TYPE_SCAN, SCAN_GAS);
                    } else if (mainIntent.getStringExtra(TYPE_SCAN).equals(SCAN_GKH)) {
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
