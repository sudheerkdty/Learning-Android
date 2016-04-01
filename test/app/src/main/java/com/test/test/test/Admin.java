package com.test.test.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by nuventure on 19/2/16.
 */
public class Admin extends AppCompatActivity {
    DataBase db = new DataBase(this);
    ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_success);
        ArrayList list = db.getAll();
        lv = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item,android.R.id.text1, list);
        lv.setAdapter(adapter);

    }
}
