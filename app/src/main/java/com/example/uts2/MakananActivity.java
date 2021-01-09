package com.example.uts2;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MakananActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnMinus1,btnAdd1,btnMinus2,btnAdd2,btnMinus3,btnAdd3,btnPesanan,btnOrderMore;
    private TextView tvItem1,tvJumlah1,tvItem2,tvJumlah2,tvItem3,tvJumlah3,tvHargaTotal;
    GlobalVariable shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan);

        shared = (GlobalVariable) this.getApplication();

        findViews();
        fillViews();

    }

    private void findViews(){
        btnMinus1 = findViewById(R.id.btnMinus4);
        btnAdd1 = findViewById(R.id.btnAdd4);
        btnMinus2 = findViewById(R.id.btnMinus5);
        btnAdd2  = findViewById(R.id.btnAdd5);
        btnMinus3 = findViewById(R.id.btnMinus6);
        btnAdd3  = findViewById(R.id.btnAdd6);
        btnPesanan = findViewById(R.id.btnPesanann);

        tvItem1 = findViewById(R.id.tvItem4);
        tvJumlah1 = findViewById(R.id.tvJumlah4);
        tvItem2 = findViewById(R.id.tvItem5);
        tvJumlah2 = findViewById(R.id.tvJumlah5);
        tvItem3 = findViewById(R.id.tvItem6);
        tvJumlah3 = findViewById(R.id.tvJumlah6);
        tvHargaTotal = findViewById(R.id.tvHargaTotall);
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

        tvItem1.setText(shared.getItem4() + " - " +"Rp. " + shared.getHarga4().toString());
        tvItem2.setText(shared.getItem5() + " - " +"Rp. " + shared.getHarga5().toString());
        tvItem3.setText(shared.getItem6() + " - " +"Rp. " + shared.getHarga6().toString());

        tvJumlah1.setText(shared.getJumlah4().toString());
        tvJumlah2.setText(shared.getJumlah5().toString());
        tvJumlah3.setText(shared.getJumlah6().toString());

        tvHargaTotal.setText(hitungTotal().toString());
    }

    public void onClick(View v){

        if(v == btnMinus1){

            Integer vjumlah = shared.getJumlah4();
            if(vjumlah>0){

                vjumlah = vjumlah - 1;
                shared.setJumlah4(vjumlah);
            }

            tvJumlah1.setText(vjumlah.toString());
            tvHargaTotal.setText("Rp. "+hitungTotal().toString());

        }

        if(v == btnAdd1){

            Integer vjumlah = shared.getJumlah4();

            vjumlah = vjumlah + 1;
            shared.setJumlah4(vjumlah);

            tvJumlah1.setText(vjumlah.toString());
            tvHargaTotal.setText("Rp. "+hitungTotal().toString());

        }


        if(v == btnMinus2){

            Integer vjumlah = shared.getJumlah5();
            if(vjumlah>0){

                vjumlah = vjumlah - 1;
                shared.setJumlah5(vjumlah);
            }

            tvJumlah2.setText(vjumlah.toString());
            tvHargaTotal.setText("Rp. "+hitungTotal().toString());

        }

        if(v == btnAdd2){

            Integer vjumlah = shared.getJumlah5();

            vjumlah = vjumlah + 1;
            shared.setJumlah5(vjumlah);

            tvJumlah2.setText(vjumlah.toString());
            tvHargaTotal.setText("Rp. "+hitungTotal().toString());

        }


        if(v == btnMinus3){

            Integer vjumlah = shared.getJumlah6();
            if(vjumlah>0){

                vjumlah = vjumlah - 1;
                shared.setJumlah6(vjumlah);
            }

            tvJumlah3.setText(vjumlah.toString());
            tvHargaTotal.setText("Rp. "+hitungTotal().toString());

        }

        if(v == btnAdd3){

            Integer vjumlah = shared.getJumlah6();

            vjumlah = vjumlah + 1;
            shared.setJumlah6(vjumlah);

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

        Total = Total + (shared.getJumlah4() * shared.getHarga4());
        Total = Total + (shared.getJumlah5() * shared.getHarga5());
        Total = Total + (shared.getJumlah6() * shared.getHarga6());

        return Total;
    }
}
