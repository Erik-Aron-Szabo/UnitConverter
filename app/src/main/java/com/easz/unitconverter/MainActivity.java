package com.easz.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btn_convert;
    EditText et_num;
    TextView tv_unit;

    private static boolean changer = true;
    private static double displayNum = 888;

    // singleton
    private static Utility utility = Utility.getUtility();

    // use adapter
    private static String[] km_mile = {"Kms", "Miles"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {
        btn_convert = (Button)findViewById(R.id.btn_convert);
        et_num = (EditText)findViewById(R.id.editTextNumber);
        tv_unit = (TextView)findViewById(R.id.tv_unit);

        String numString = et_num.getText().toString();
        double num = Double.parseDouble(numString);
        // Change Km -> Mi (Btn - setText() )



        if (changer) {
            double answer = utility.kmToMi(num);
            String stringAnswer = String.valueOf(answer);
            tv_unit.setText(km_mile[1]);
            et_num.setText(stringAnswer);
            et_num.selectAll();
            Toast.makeText(this, stringAnswer + " miles", Toast.LENGTH_SHORT).show();
            changer = false;
        } else {
            double answer2 = utility.miToKm(num);
            String stringAnswer2 = String.valueOf(answer2);
            tv_unit.setText(km_mile[0]);
            et_num.setText(stringAnswer2);
            et_num.selectAll();
            Toast.makeText(this, stringAnswer2 + " kilometers", Toast.LENGTH_SHORT).show();
            changer = true;
        }

        // change # to 0
        // Show result in Toast

    }


}