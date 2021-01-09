package com.example.uts2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SnackActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnMinus1,btnAdd1,btnMinus2,btnAdd2,btnMinus3,btnAdd3,btnPesanan,btnOrderMore;
    private TextView tvItem1,tvJumlah1,tvItem2,tvJumlah2,tvItem3,tvJumlah3,tvHargaTotal;
    GlobalVariable shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);

        shared = (GlobalVariable) this.getApplication();

        findViews();
        fillViews();

    }

    private void findViews(){
        btnMinus1 = findViewById(R.id.btnMinus7);
        btnAdd1 = findViewById(R.id.btnAdd7);
        btnMinus2 = findViewById(R.id.btnMinus8);
        btnAdd2  = findViewById(R.id.btnAdd8);
        btnMinus3 = findViewById(R.id.btnMinus9);
        btnAdd3  = findViewById(R.id.btnAdd9);
        btnPesanan = findViewById(R.id.btnPesanannn);

        tvItem1 = findViewById(R.id.tvItem7);
        tvJumlah1 = findViewById(R.id.tvJumlah7);
        tvItem2 = findViewById(R.id.tvItem8);
        tvJumlah2 = findViewById(R.id.tvJumlah8);
        tvItem3 = findViewById(R.id.tvItem9);
        tvJumlah3 = findViewById(R.id.tvJumlah9);
        tvHargaTotal = findViewById(R.id.tvHargaTotalll);
        btnOrderMore = findViewById(R.id.btnOrderMore);
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

        tvItem1.setText(shared.getItem7() + " - " +"Rp. " + shared.getHarga7().toString());
        tvItem2.setText(shared.getItem8() + " - " +"Rp. " + shared.getHarga8().toString());
        tvItem3.setText(shared.getItem9() + " - " +"Rp. " + shared.getHarga9().toString());

        tvJumlah1.setText(shared.getJumlah7().toString());
        tvJumlah2.setText(shared.getJumlah8().toString());
        tvJumlah3.setText(shared.getJumlah9().toString());

        tvHargaTotal.setText("Rp. "+hitungTotal().toString());
    }

    public void onClick(View v){

        if(v == btnMinus1){

            Integer vjumlah = shared.getJumlah7();
            if(vjumlah>0){

                vjumlah = vjumlah - 1;
                shared.setJumlah7(vjumlah);
            }

            tvJumlah1.setText(vjumlah.toString());
            tvHargaTotal.setText("Rp. "+hitungTotal().toString());

        }

        if(v == btnAdd1){

            Integer vjumlah = shared.getJumlah7();

            vjumlah = vjumlah + 1;
            shared.setJumlah7(vjumlah);

            tvJumlah1.setText(vjumlah.toString());
            tvHargaTotal.setText("Rp. "+hitungTotal().toString());

        }


        if(v == btnMinus2){

            Integer vjumlah = shared.getJumlah8();
            if(vjumlah>0){

                vjumlah = vjumlah - 1;
                shared.setJumlah8(vjumlah);
            }

            tvJumlah2.setText(vjumlah.toString());
            tvHargaTotal.setText("Rp. "+hitungTotal().toString());

        }

        if(v == btnAdd2){

            Integer vjumlah = shared.getJumlah8();
            vjumlah = vjumlah + 1;
            shared.setJumlah8(vjumlah);

            tvJumlah2.setText(vjumlah.toString());
            tvHargaTotal.setText("Rp. "+hitungTotal().toString());

        }


        if(v == btnMinus3){

            Integer vjumlah = shared.getJumlah9();
            if(vjumlah>0){

                vjumlah = vjumlah - 1;
                shared.setJumlah9(vjumlah);
            }

            tvJumlah3.setText(vjumlah.toString());
            tvHargaTotal.setText("Rp. "+hitungTotal().toString());

        }

        if(v == btnAdd3){

            Integer vjumlah = shared.getJumlah9();

            vjumlah = vjumlah + 1;
            shared.setJumlah9(vjumlah);

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

        Total = Total + (shared.getJumlah7() * shared.getHarga7());
        Total = Total + (shared.getJumlah8() * shared.getHarga8());
        Total = Total + (shared.getJumlah9() * shared.getHarga9());

        return Total;
    }
}
