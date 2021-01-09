package com.example.uts2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelper db;


    private Button btnMinuman,btnMakanan,btnsnack,btnTopUp,btnMyOrder, btnHistory, btnMap;

    GlobalVariable shared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  db = new DatabaseHelper(getApplicationContext());
        //db.CreateTabel();
        shared = (GlobalVariable) this.getApplication();

        findViews();
        fillViews();

        //db.close();

    }

    private void findViews(){
        btnMinuman = findViewById(R.id.btnMinuman);
        btnMakanan = findViewById(R.id.btnMakanan);
        btnsnack = findViewById(R.id.btnSnack);
        btnTopUp = findViewById(R.id.btnTopUp);
        btnMyOrder = findViewById(R.id.btnMyOrder);
        btnHistory = findViewById(R.id.btnHistory);
        btnMap = findViewById(R.id.btnMap);
    }

    private void fillViews(){
        btnMinuman.setOnClickListener(this);
        btnMakanan.setOnClickListener(this);
        btnsnack.setOnClickListener(this);
        btnTopUp.setOnClickListener(this);
        btnMyOrder.setOnClickListener(this);
        btnHistory.setOnClickListener(this);
        btnMap.setOnClickListener(this);

        if (shared.getflag() == null || shared.getflag() == 1) {
            shared.setItem1("Coca Cola");
            shared.setHarga1(5000);
            shared.setJumlah1(0);

            shared.setItem2("Fanta");
            shared.setHarga2(4000);
            shared.setJumlah2(0);

            shared.setItem3("Sprite");
            shared.setHarga3(3000);
            shared.setJumlah3(0);

            shared.setItem4("MIE");
            shared.setHarga4(20000);
            shared.setJumlah4(0);

            shared.setItem5("Nasi Goreng");
            shared.setHarga5(25000);
            shared.setJumlah5(0);

            shared.setItem6("Ayam Goreng");
            shared.setHarga6(15000);
            shared.setJumlah6(0);

            shared.setItem7("CHITATO");
            shared.setHarga7(8000);
            shared.setJumlah7(0);

            shared.setItem8("CHUBA");
            shared.setHarga8(3000);
            shared.setJumlah8(0);

            shared.setItem9("Choki-Choki");
            shared.setHarga9(1000);
            shared.setJumlah9(0);
//
//
  //        db.sqlraw("insert into barang(name,price,quantity) values ('tes',1,2)");

//            db.insertData2();
/*
            db.insertData(shared.getItem2(),shared.getHarga2(),shared.getJumlah2());
            db.insertData(shared.getItem3(),shared.getHarga3(),shared.getJumlah3());
            db.insertData(shared.getItem4(),shared.getHarga4(),shared.getJumlah4());
            db.insertData(shared.getItem5(),shared.getHarga5(),shared.getJumlah5());
            db.insertData(shared.getItem6(),shared.getHarga6(),shared.getJumlah6());
            db.insertData(shared.getItem7(),shared.getHarga7(),shared.getJumlah7());
            db.insertData(shared.getItem8(),shared.getHarga8(),shared.getJumlah8());
            db.insertData(shared.getItem9(),shared.getHarga9(),shared.getJumlah9());
*/
        }

    }

    public void onClick(View v){

        if(v == btnMinuman){

            //Toast.makeText(this, "tes", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MinumanActivity.class));
            //finish();
        }


        if(v == btnMakanan){
            startActivity(new Intent(this, MakananActivity.class));
            //Toast.makeText(this, "makanan", Toast.LENGTH_SHORT).show();
            //startActivity(new Intent(mContext, HseActivity.class));
            //finish();
        }

        if(v == btnsnack){

            //Toast.makeText(this, "makanan", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, SnackActivity.class));
            //finish();
        }

        if (v == btnTopUp){
            startActivity(new Intent(this, TopupActivity.class));

        }

        if(v == btnMyOrder){
            startActivity(new Intent(this, PesananActivity.class));
        }

        if (v == btnHistory){
            startActivity(new Intent(this, HistoryActivity.class));
        }

        if (v == btnMap){
            startActivity(new Intent(this, MapsActivity.class));
        }


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
