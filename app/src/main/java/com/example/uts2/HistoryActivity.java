package com.example.uts2;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity{

    private static final String TAG = "HistoryActivity";
    DatabaseHelper db;
    ListView li;
    ArrayList<barang> arrayList;
    BarangListAdapter myAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        li = (ListView) findViewById(R.id.listview);
        db = new DatabaseHelper(this);
        arrayList = new ArrayList<>();

        LoadDataInListView();

        db.close();
    }

    private void LoadDataInListView() {
        arrayList = db.getAllData();
        myAdapter = new BarangListAdapter(this,arrayList);
        li.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

    }



}


