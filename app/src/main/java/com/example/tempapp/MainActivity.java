package com.example.tempapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_temp;   //  import all the elements in the (reference)uer interaface
    RadioButton rd_btnc;
    RadioButton rd_btnf;
    Button btn_calc;
    TextView tv_ans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //assign value to elemets
        et_temp = findViewById(R.id.et_temp);  // calc button assign
        rd_btnc = findViewById(R.id.rd_btnc);  // R means the resource
        rd_btnf = findViewById(R.id.rd_btnf);
        btn_calc = findViewById(R.id.btn_calc);
        tv_ans = findViewById(R.id.tv_ans);


    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAnswer();

            }
        });
    }

    private void calculateAnswer() {
        Calculations cal = new Calculations();   //create an object
        String value = et_temp.getText().toString(); //get the value

        if (TextUtils.isEmpty(value)) {//input value is empty
            Toast.makeText(this, "Enter the Temperature ", Toast.LENGTH_SHORT).show();  //length long -  denote the duration
        } else {
            Float temp = Float.parseFloat(value);
            if (rd_btnc.isChecked()) {   // whether it is not empty
                temp = cal.convertCelciusToFahrenheit(temp);
            } else if (rd_btnf.isChecked()) {
                temp = cal.convertFahrenheitToCelcius(temp);
            } else {
                Toast.makeText(this, "Select the radio button", Toast.LENGTH_SHORT).show();
                temp = 0.0f;
                tv_ans.setText(new Float(temp).toString());

            }
        }
    }
}