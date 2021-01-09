package com.example.uts2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TopupActivity extends AppCompatActivity implements View.OnClickListener {

    GlobalVariable shared;

    private EditText Topup;
    private TextView saldoku;
    private Button btnTopUp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);

        shared = (GlobalVariable) this.getApplication();

        findViews();
        fillViews();

    }
    private void findViews() {

    Topup = (EditText)findViewById(R.id.tambahsaldo);
    saldoku = findViewById(R.id.Saldo);
    btnTopUp = findViewById(R.id.btnTopUp);

        }


    private void fillViews(){

    btnTopUp.setOnClickListener(this);


    saldoku.setText("Rp. " + shared.getSaldo().toString());

    }

    public void onClick(View v){


        if (v == btnTopUp){


            String jmlhtopup = Topup.getText().toString();
            int injmlhtopup;
            injmlhtopup = Integer.parseInt(jmlhtopup);

            if (injmlhtopup + shared.getSaldo() <= 2000000) {
                injmlhtopup = injmlhtopup + shared.getSaldo();
                shared.setSaldo(injmlhtopup);
                startActivity(new Intent(this, MainActivity.class));

            } else {

                Toast.makeText(this, "sorry you can only add a balance up to Rp. 2.000.000", Toast.LENGTH_SHORT).show();
            }
            
        }


    }



}
