package com.example.jason.tipcalculator;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText enteredAmount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView totalResultTextView;
    private TextView textViewSeekBar;
    private int seekBarPercentage;
    private float enterBillFloat;
    private TextView totalBillTxTv;
    //private String TAG = "TipCalculator";

    //public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredAmount = findViewById(R.id.billAmountID);
        seekBar = findViewById(R.id.percentageSeekBarID);
        calculateButton = findViewById(R.id.calculateIbuttonID);
        totalResultTextView = findViewById(R.id.resultID);
        textViewSeekBar = findViewById(R.id.textViewSeekBarID);
        totalBillTxTv = findViewById(R.id.totalBillID);

        //Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
        //Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_LONG).show();
        //Toast.makeTexT(getBaseContext(), "Hello", Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplication(), "Hello", Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
        //Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();

        //Log.v(TAG, MainActivity.this.getString(R.string.app_name));

        calculateButton.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //textViewSeekBar.setText(String.valueOf(seekBar.getProgress()) + "%");
                textViewSeekBar.setText(String.valueOf(seekBar.getProgress()) + getString(R.string.percent));


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarPercentage = seekBar.getProgress();
            }
        });


    }

    @Override
    public void onClick(View v) {
        calculate();
        //TODO - Build Amazinbg app with this example
    }

    public void calculate(){
        float result;

        if (!enteredAmount.getText().toString().equals("")){
            enterBillFloat = Float.parseFloat(enteredAmount.getText().toString());
            result = enterBillFloat * seekBarPercentage/100;
            totalResultTextView.setText("Your tip will be: $" + String.valueOf((result)));
            totalBillTxTv.setText("Your Total to pay is: $" + String.valueOf(enterBillFloat + result));

            //Log.v(TAG, String.valueOf(result));

        }else {
            Toast.makeText(MainActivity.this, "Please enter a bill amount!" , Toast.LENGTH_LONG).show();
        }
    }
}
