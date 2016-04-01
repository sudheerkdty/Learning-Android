package com.test.test.test;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by nuventure on 17/2/16.
 */
public class page1 extends AppCompatActivity {
    Button b1;
    TextView t1;
    DataBase db = new DataBase(this);
    int user_count = 0;
    User user;
    String[] User_det;
    ListView l1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
        t1 = (TextView) findViewById(R.id.textView);


        //t1.setText(User_det);
        //ArrayList list = db.getAll();
        //t1.setText(list.toString());

        user_count =db.getUserCount();
        user = db.getUser(user_count);
        User_det = new String[]{"ID:" + user.getID(), "\nName:" + user.getName(), "\nUserName:" + user.getUserName()
                , "\nPhone No:" + user.getPhoneNumber(), "\nEmail :" + user.getEmail()};
        l1 =(ListView)findViewById(R.id.listView2);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item,android.R.id.text1, User_det);
        l1.setAdapter(adapter);

        b1=(Button)findViewById(R.id.back);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page1.this, Home_page.class);
                startActivity(intent);

            }
        });

    }
}
