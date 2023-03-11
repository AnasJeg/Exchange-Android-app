package me.jegoualanas.app_cours;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cal_crypto extends AppCompatActivity {
    Spinner spinner;
    Button btn;

    EditText crypto;
    TextView tp,td;
    Switch st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_crypto);
        spinner=findViewById(R.id.spinner);
        btn=findViewById(R.id.button);
        crypto=findViewById(R.id.editTextNumber);
        tp=findViewById(R.id.textView2);
        td=findViewById(R.id.textView3);

        ArrayList<String> lis = new ArrayList<>();
        lis.add("MAD");
        lis.add("USD");
        lis.add("EURO");
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lis);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double s1,s2;
                double montant=Double.parseDouble(crypto.getText().toString());
                if(spinner.getSelectedItem().toString()=="MAD") {
                    s1 = montant * 0.097;
                    s2 = montant * 0.091;

                    tp.setText(new DecimalFormat("##.##").format(s1) + " USD");
                    td.setText(new DecimalFormat("##.##").format(s2) + " EURO");
                }else if(spinner.getSelectedItem().toString()=="USD"){
                    s1=montant * 10.34;
                    s2=montant * 0.95;

                    tp.setText(new DecimalFormat("##.##").format(s1)+" MAD");
                    td.setText(new DecimalFormat("##.##").format(s2)+" EURO");
                }else{
                    s1=montant * 1.07;
                    s2=montant * 11.02;

                    tp.setText(new DecimalFormat("##.##").format(s1)+" USD");
                    td.setText(new DecimalFormat("##.##").format(s2)+" MAD");
                }

            }
        });

        st=findViewById(R.id.switch2);
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Cal_crypto.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
}