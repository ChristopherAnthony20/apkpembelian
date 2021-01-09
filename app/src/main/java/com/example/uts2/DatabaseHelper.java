package com.example.uts2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
      private static final String DATABASE_NAME = "barang.db";
      private static final int DATABASE_VERSION = 1;
       public DatabaseHelper(Context context){
           super(context, DATABASE_NAME,null,DATABASE_VERSION);
       }

        @Override
       public void onCreate(SQLiteDatabase db){
           String sql = "create table barang(name TEXT primary key, total int, quantity int, DATETIME DEFAULT CURRENT_TIMESTAMP);";
           Log.d("Data","onCreate; "+ sql);
           db.execSQL(sql);

           // create db
       }

    @Override
       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
           db.execSQL("drop table if exists barang");
           onCreate(db);
           //untuk perubahan atau nambahin table / kolom
       }

    @Override
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }


        public void sqlraw(String sqldata){

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(sqldata);

        }

        public boolean insertData(String name, int total, int quantity){

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name",name);
            contentValues.put("total",total);
            contentValues.put("quantity",quantity);

            long result =  db.insert("barang",null,contentValues);
            if(result == -1){
                return false;
            }else {
                return true;
            }




            /*SQLiteDatabase sqLiteDatabaseObj = SQLiteDatabase.openOrCreateDatabase("barang", null);

            sqLiteDatabaseObj.execSQL("insert into barang(name,price,quantity) values('"+name+"',"+price+","+quantity+")");
            return true;*/
        }
    public Cursor getdata(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * From barang",null);
        return cursor;
        //mengambil data dari database
    }

    public ArrayList<barang> getAllData(){
           ArrayList<barang> arrayList = new ArrayList<>();
           SQLiteDatabase db = this.getReadableDatabase();
           Cursor cursor = db.rawQuery("Select * From barang",null);

           while(cursor.moveToNext()){
               String name = cursor.getString(0);
               String total = cursor.getString(1);
               String quantity = cursor.getString(2);
               String time = cursor.getString(3);
               barang barang = new barang(name,total,quantity,time);

               arrayList.add(barang);
           }

           return arrayList;
    }
}
