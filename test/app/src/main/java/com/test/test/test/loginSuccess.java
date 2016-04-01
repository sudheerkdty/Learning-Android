package com.test.test.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by nuventure on 19/2/16.
 */
public class loginSuccess extends AppCompatActivity {
    DataBase db = new DataBase(this);
    User user;
    String[] User_det;
    ListView lv;
    Button editProfile;
    int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //finishActivity();
        setContentView(R.layout.login_success);
        String userid= getIntent().getStringExtra("<StringName>");
        user = db.getUserbyUsername(userid);
        User_det = new String[]{"ID:" + user.getID(), "\nName:" + user.getName(), "\nUserName:" + user.getUserName()
                , "\nPhone No:" + user.getPhoneNumber(), "\nEmail :" + user.getEmail()};
        lv = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item,android.R.id.text1, User_det);
        lv.setAdapter(adapter);
        ID =user.getID();
        editProfile = (Button)findViewById(R.id.editData);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(loginSuccess.this, EditUser.class).putExtra("intVariableName", ID);
                startActivity(intent);

            }
        });



    }
    @Override
    protected void onStop(){
        super.onStop();
        finish();
    }

}
