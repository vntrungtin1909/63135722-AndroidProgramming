package com.example.sqlite_ql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtMaLop, edtTenLop, edtNum;
    Button btnIn, btnDel, btnUp, btnQue;
    ListView lv;
    ArrayList<String> myList;
    ArrayAdapter<String> adapter;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtMaLop = findViewById(R.id.edtMaLop);
        edtTenLop = findViewById(R.id.edtTenLop);
        edtNum = findViewById(R.id.edtNum);
        btnIn = findViewById(R.id.btnInsert);
        btnDel = findViewById(R.id.btnDel);
        btnUp = findViewById(R.id.btnUpdate);
        btnQue = findViewById(R.id.btnQuery);

        lv = findViewById(R.id.lv);
        myList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
        lv.setAdapter(adapter);

        db = openOrCreateDatabase("qlsv.db", MODE_PRIVATE, null);

        try {
            String sql = "CREATE TABLE tbllop(malop TEXT primary key, tenlop TEXT, siso INTEGER)";
            db.execSQL(sql);
        }
        catch (Exception e) {
            Log.e("Error", "table da ton tai");
        }
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String malop = edtMaLop.getText().toString();
                String tenlop = edtTenLop.getText().toString();
                int siso = Integer.parseInt(edtNum.getText().toString());

                ContentValues vl = new ContentValues();
                vl.put("malop", malop);
                vl.put("tenlop", tenlop);
                vl.put("siso", siso);
                String msg = "";
                if (db.insert("tbllop", null, vl) == -1) {
                    msg = "insert fail";
                }
                else {
                    msg = "successfully";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String malop = edtMaLop.getText().toString();
                int n = db.delete("tbllop", "malop = ?", new String[]{malop});
                String msg = "";
                if (n == 0) {
                    msg = "no record to delete";
                }
                else {
                    msg = n + " record is deleted";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int siso = Integer.parseInt(edtNum.getText().toString());
                String malop = edtMaLop.getText().toString();
                ContentValues vl = new ContentValues();
                vl.put("siso", siso);
                int n = db.update("tbllop", vl, "malop = ?", new String[]{malop});
                String msg = "";
                if (n == 0) {
                    msg = "no record";
                }
                else {
                    msg = n + " record is updated";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });


        btnQue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myList.clear();
                String sqlSelect ="Select * from tbllop;";
                Cursor cs = db.rawQuery(sqlSelect,null);
                cs.moveToFirst();
                String data = "";
                do {
                    data = cs.getString(0) + " - " + cs.getString(1) + " - " + cs.getString(2);
                    myList.add(data);
                } while (cs.moveToNext());
                cs.close();
                adapter.notifyDataSetChanged();

            }
        });



    }
}