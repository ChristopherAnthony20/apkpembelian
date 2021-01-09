package com.example.uts2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MinumanActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMinus1,btnAdd1,btnMinus2,btnAdd2,btnMinus3,btnAdd3,btnPesanan;
    private TextView tvItem1,tvJumlah1,tvItem2,tvJumlah2,tvItem3,tvJumlah3,tvHargaTotal,btnOrderMore;
    GlobalVariable shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minuman);

        shared = (GlobalVariable) this.getApplication();

        findViews();
        fillViews();

    }

    private void findViews(){
        btnMinus1 = findViewById(R.id.btnMinus1);
        btnAdd1 = findViewById(R.id.btnAdd1);
        btnMinus2 = findViewById(R.id.btnMinus2);
        btnAdd2  = findViewById(R.id.btnAdd2);
        btnMinus3 = findViewById(R.id.btnMinus3);
        btnAdd3  = findViewById(R.id.btnAdd3);
        btnPesanan = findViewById(R.id.btnPesanan);
        btnOrderMore = findViewById(R.id.btnOrderMore);
        tvItem1 = findViewById(R.id.tvItem1);
        tvJumlah1 = findViewById(R.id.tvJumlah1);
        tvItem2 = findViewById(R.id.tvItem2);
        tvJumlah2 = findViewById(R.id.tvJumlah2);
        tvItem3 = findViewById(R.id.tvItem3);
        tvJumlah3 = findViewById(R.id.tvJumlah3);
        tvHargaTotal = findViewById(R.id.tvHargaTotal);
    }

    private void fillViews(){
        btnMinus1.setOnClickListener(this);
        btnAdd1.setOnClickListener(this);
        btnMinus2.setOnClickListener(this);
        btnAdd2.setOnClickListener(this);
        btnMinus3.setOnClickListener(this);
        btnAdd3.setOnClickListener(this);
        btnPesanan.setOnClickListener(this);
        btnOrderMore.setOnClickListener(this);

        tvItem1.setText(shared.getItem1() + " - " +"Rp. " +shared.getHarga1().toString());
        tvItem2.setText(shared.getItem2() + " - " +"Rp. " + shared.getHarga2().toString());
        tvItem3.setText(shared.getItem3() + " - " +"Rp. " + shared.getHarga3().toString());

        tvJumlah1.setText(shared.getJumlah1().toString());
        tvJumlah2.setText(shared.getJumlah2().toString());
        tvJumlah3.setText(shared.getJumlah3().toString());


        tvHargaTotal.setText("Rp. "+hitungTotal().toString());
    }

    public void onClick(View v){

        if(v == btnMinus1){

            Integer vjumlah = shared.getJumlah1();
            if(vjumlah>0){

                vjumlah = vjumlah - 1;
                shared.setJumlah1(vjumlah);
            }

            tvJumlah1.setText(vjumlah.toString());
            tvHargaTotal.setText("Rp. "+hitungTotal().toString());

        }

        if(v == btnAdd1){

            Integer vjumlah = shared.getJumlah1();

            vjumlah = vjumlah + 1;
            shared.setJumlah1(vjumlah);

            tvJumlah1.setText(vjumlah.toString());
            tvHargaTotal.setText("Rp. "+hitungTotal().toString());

        }


        if(v == btnMinus2){

            Integer vjumlah = shared.getJumlah2();
            if(vjumlah>0){

                vjumlah = vjumlah - 1;
                shared.setJumlah2(vjumlah);
            }

            tvJumlah2.setText(vjumlah.toString());
            tvHargaTotal.setText("Rp. "+hitungTotal().toString());

        }

        if(v == btnAdd2){

            Integer vjumlah = shared.getJumlah2();

            vjumlah = vjumlah + 1;
            shared.setJumlah2(vjumlah);

            tvJumlah2.setText(vjumlah.toString());
            tvHargaTotal.setText("Rp. "+hitungTotal().toString());

        }


        if(v == btnMinus3){

            Integer vjumlah = shared.getJumlah3();
            if(vjumlah>0){

                vjumlah = vjumlah - 1;
                shared.setJumlah3(vjumlah);
            }

            tvJumlah3.setText(vjumlah.toString());
            tvHargaTotal.setText("Rp. "+hitungTotal().toString());

        }

        if(v == btnAdd3){

            Integer vjumlah = shared.getJumlah3();

            vjumlah = vjumlah + 1;
            shared.setJumlah3(vjumlah);

            tvJumlah3.setText(vjumlah.toString());
            tvHargaTotal.setText("Rp. "+hitungTotal().toString());

        }

        if(v == btnPesanan){

            startActivity(new Intent(this, PesananActivity.class));

        }
        if (v == btnOrderMore){
            shared.setflag(0);
            startActivity(new Intent(this, MainActivity.class));

        }

    }

    private Integer hitungTotal(){
        Integer Total = 0;

        Total = Total + (shared.getJumlah1() * shared.getHarga1());
        Total = Total + (shared.getJumlah2() * shared.getHarga2());
        Total = Total + (shared.getJumlah3() * shared.getHarga3());

        return Total;
    }

}
