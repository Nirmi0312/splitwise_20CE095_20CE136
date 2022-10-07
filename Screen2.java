package com.example.bill_splitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.MessageFormat;

public class Screen2 extends AppCompatActivity {
    //Declare variable
    double tax = 0.18;
    double tip;
    double billTotal, finalBill;
    int numofPeople;
    String groupChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        final EditText bill = findViewById(R.id.txtBill);
        final EditText group= findViewById(R.id.txtGroup);
        final Spinner spinner=findViewById(R.id.spnGroup);

        Button split =findViewById(R.id.btn2);
        split.setOnClickListener(new View.OnClickListener() {
            final TextView result=findViewById(R.id.txtResult);
            @Override
            public void onClick(View view) {
                numofPeople=Integer.parseInt(group.getText().toString());
                billTotal=Double.parseDouble(bill.getText().toString());
                tip=billTotal*tax;
                finalBill=(billTotal*tip) / numofPeople;
                DecimalFormat currency = new DecimalFormat("$###,###.00");
                groupChoice = spinner.getSelectedItem(). toString();
                result.setText(MessageFormat.format("Billtotal :{0}\n Tip amount :{1}\n Individual share :{2}", billTotal, tip, finalBill));

            }
        });
    }//end oncreat
}//end screen2