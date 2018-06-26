package com.example.jason.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        calculateButton.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewSeekBar.setText(String.valueOf(seekBar.getProgress()) + "%");
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
    }

    public void calculate(){
        float result;

        if (!enteredAmount.getText().toString().equals("")){
            enterBillFloat = Float.parseFloat(enteredAmount.getText().toString());
            result = enterBillFloat * seekBarPercentage/100;
            totalResultTextView.setText("Your tip will be: $" + String.valueOf((result)));
            totalBillTxTv.setText("Your Total to pay is: $" + String.valueOf(enterBillFloat + result));

        }else {
            Toast.makeText(MainActivity.this, "Please enter a bill amount!" , Toast.LENGTH_LONG).show();
        }
    }
}
