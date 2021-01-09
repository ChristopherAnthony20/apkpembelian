package com.example.uts2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PesananActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvItem,tvJumlah,tvHarga,tvHeaderHarga,tvHargaTotal,tvSaldo;
    private Button btnFinish;

    DatabaseHelper db;

    GlobalVariable shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan);

        shared = (GlobalVariable) this.getApplication();
        db = new DatabaseHelper(getApplicationContext());


        findViews();
        fillViews();

    }

    private void findViews(){
        tvItem = findViewById(R.id.tvItem);
        tvJumlah = findViewById(R.id.tvJumlah);
        tvHarga = findViewById(R.id.tvHarga);
        tvHeaderHarga = findViewById(R.id.tvHeaderHarga);
        tvHargaTotal = findViewById(R.id.tvHargaTotal);
        btnFinish = findViewById(R.id.btnFinish);
        tvSaldo = findViewById(R.id.Saldo);
    }

    private void fillViews(){
        btnFinish.setOnClickListener(this);


        tvSaldo.setText("Rp. " + shared.getSaldo());

        Integer Total = 0;

        Total = Total + (shared.getJumlah1() * shared.getHarga1());
        Total = Total + (shared.getJumlah2() * shared.getHarga2());
        Total = Total + (shared.getJumlah3() * shared.getHarga3());
        Total = Total + (shared.getJumlah4() * shared.getHarga4());
        Total = Total + (shared.getJumlah5() * shared.getHarga5());
        Total = Total + (shared.getJumlah6() * shared.getHarga6());
        Total = Total + (shared.getJumlah7() * shared.getHarga7());
        Total = Total + (shared.getJumlah8() * shared.getHarga8());
        Total = Total + (shared.getJumlah9() * shared.getHarga9());


        tvHargaTotal.setText("Rp. "+Total.toString());

        String Item = "Item\n";

        if (shared.getJumlah1() > 0) Item = Item + shared.getItem1() + " - " +"Rp. "+ shared.getHarga1().toString() + "\n";
        if (shared.getJumlah2() > 0) Item = Item + shared.getItem2() + " - " +"Rp. "+ shared.getHarga2().toString() + "\n";
        if (shared.getJumlah3() > 0) Item = Item + shared.getItem3() + " - " +"Rp. "+ shared.getHarga3().toString() + "\n";
        if (shared.getJumlah4() > 0) Item = Item + shared.getItem4() + " - " +"Rp. "+ shared.getHarga4().toString() + "\n";
        if (shared.getJumlah5() > 0) Item = Item + shared.getItem5() + " - " +"Rp. "+ shared.getHarga5().toString() + "\n";
        if (shared.getJumlah6() > 0) Item = Item + shared.getItem6() + " - " +"Rp. "+ shared.getHarga6().toString() + "\n";
        if (shared.getJumlah7() > 0) Item = Item + shared.getItem7() + " - " +"Rp. "+ shared.getHarga7().toString() + "\n";
        if (shared.getJumlah8() > 0) Item = Item + shared.getItem8() + " - " +"Rp. "+ shared.getHarga8().toString() + "\n";
        if (shared.getJumlah9() > 0) Item = Item + shared.getItem9() + " - " +"Rp. "+ shared.getHarga9().toString() + "\n";



        tvItem.setText(Item);

        String Jumlah = "Jumlah\n";

        if (shared.getJumlah1() > 0) Jumlah = Jumlah + shared.getJumlah1() + "\n";
        if (shared.getJumlah2() > 0) Jumlah = Jumlah + shared.getJumlah2() + "\n";
        if (shared.getJumlah3() > 0) Jumlah = Jumlah + shared.getJumlah3() + "\n";
        if (shared.getJumlah4() > 0) Jumlah = Jumlah + shared.getJumlah4() + "\n";
        if (shared.getJumlah5() > 0) Jumlah = Jumlah + shared.getJumlah5() + "\n";
        if (shared.getJumlah6() > 0) Jumlah = Jumlah + shared.getJumlah6() + "\n";
        if (shared.getJumlah7() > 0) Jumlah = Jumlah + shared.getJumlah7() + "\n";
        if (shared.getJumlah8() > 0) Jumlah = Jumlah + shared.getJumlah8() + "\n";
        if (shared.getJumlah9() > 0) Jumlah = Jumlah + shared.getJumlah9() + "\n";

        tvJumlah.setText(Jumlah);

        String Harga = "Harga\n";
        if (shared.getJumlah1() > 0) Harga = Harga +"Rp. "+ shared.getHarga1()*shared.getJumlah1() + "\n";
        if (shared.getJumlah2() > 0) Harga = Harga +"Rp. "+ shared.getHarga2()*shared.getJumlah2() + "\n";
        if (shared.getJumlah3() > 0) Harga = Harga +"Rp. "+ shared.getHarga3()*shared.getJumlah3() + "\n";
        if (shared.getJumlah4() > 0) Harga = Harga +"Rp. "+ shared.getHarga4()*shared.getJumlah4() + "\n";
        if (shared.getJumlah5() > 0) Harga = Harga +"Rp. "+ shared.getHarga5()*shared.getJumlah5() + "\n";
        if (shared.getJumlah6() > 0) Harga = Harga +"Rp. "+ shared.getHarga6()*shared.getJumlah6() + "\n";
        if (shared.getJumlah7() > 0) Harga = Harga +"Rp. "+ shared.getHarga4()*shared.getJumlah7() + "\n";
        if (shared.getJumlah8() > 0) Harga = Harga +"Rp. "+ shared.getHarga5()*shared.getJumlah8() + "\n";
        if (shared.getJumlah9() > 0) Harga = Harga +"Rp. "+ shared.getHarga6()*shared.getJumlah9() + "\n";
        tvHarga.setText(Harga);



    }

    public void onClick(View v){

        if(v == btnFinish){
            Integer Total = 0;

            Total = Total + (shared.getJumlah1() * shared.getHarga1());
            Total = Total + (shared.getJumlah2() * shared.getHarga2());
            Total = Total + (shared.getJumlah3() * shared.getHarga3());
            Total = Total + (shared.getJumlah4() * shared.getHarga4());
            Total = Total + (shared.getJumlah5() * shared.getHarga5());
            Total = Total + (shared.getJumlah6() * shared.getHarga6());
            Total = Total + (shared.getJumlah7() * shared.getHarga7());
            Total = Total + (shared.getJumlah8() * shared.getHarga8());
            Total = Total + (shared.getJumlah9() * shared.getHarga9());


            if (Total <= shared.getSaldo()){

                shared.setSaldo(shared.getSaldo()-Total);



                Toast.makeText(this, "Your Order Complete Thank You", Toast.LENGTH_SHORT).show();

                if (shared.getJumlah1() > 0)  db.insertData(shared.getItem1(),shared.getHarga1()*shared.getJumlah1(),shared.getJumlah1());
                if (shared.getJumlah2() > 0)  db.insertData(shared.getItem2(),shared.getHarga2()*shared.getJumlah2(),shared.getJumlah2());
                if (shared.getJumlah3() > 0)  db.insertData(shared.getItem3(),shared.getHarga3()*shared.getJumlah3(),shared.getJumlah3());
                if (shared.getJumlah4() > 0)  db.insertData(shared.getItem4(),shared.getHarga4()*shared.getJumlah4(),shared.getJumlah4());
                if (shared.getJumlah5() > 0)  db.insertData(shared.getItem5(),shared.getHarga5()*shared.getJumlah5(),shared.getJumlah5());
                if (shared.getJumlah6() > 0)  db.insertData(shared.getItem6(),shared.getHarga6()*shared.getJumlah6(),shared.getJumlah6());
                if (shared.getJumlah7() > 0)  db.insertData(shared.getItem7(),shared.getHarga7()*shared.getJumlah7(),shared.getJumlah7());
                if (shared.getJumlah8() > 0)  db.insertData(shared.getItem8(),shared.getHarga8()*shared.getJumlah8(),shared.getJumlah8());
                if (shared.getJumlah9() > 0)  db.insertData(shared.getItem9(),shared.getHarga9()*shared.getJumlah9(),shared.getJumlah9());


                shared.setflag(1);
                startActivity(new Intent(this, MainActivity.class));

            }else if (Total > shared.getSaldo() ){
                Toast.makeText(this, "your balance is not enough, top up to pay", Toast.LENGTH_SHORT).show();
            }

            //finish();
        }

        db.close();
    }


}
