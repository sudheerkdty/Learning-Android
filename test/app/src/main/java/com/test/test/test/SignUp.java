package com.test.test.test;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by nuventure on 17/2/16.
 */
public class SignUp extends AppCompatActivity {
    Button submit;
    EditText nam,usert,pass,pass1,phon,emal;
    DataBase db = new DataBase(this);
    int user_count = 0;
    String name,username,password,password1,phone,email;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        final User userObj = new User(user_count,name,username,password,phone,email);
        submit =(Button)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                nam = (EditText)findViewById(R.id.name);
                usert = (EditText)findViewById(R.id.username);
                pass = (EditText)findViewById(R.id.password);
                pass1 = (EditText)findViewById(R.id.password1);
                phon = (EditText)findViewById(R.id.phone);
                emal = (EditText)findViewById(R.id.email);
                name = nam.getText().toString();
                username =usert.getText().toString();
                password = pass.getText().toString();
                password1 = pass1.getText().toString();
                phone = phon.getText().toString();
                email = emal.getText().toString();
                if (!(db.userExists(username))) {
                    if (password.equals(password1)) {
                        user_count = db.getUserCount();
                        userObj.setID(user_count + 1);
                        userObj.setName(name);
                        userObj.setUserName(username);
                        userObj.set_password(password);
                        userObj.setPhoneNumber(phone);
                        userObj.setEmail(email);
                        db.Add_User(userObj);
                        //db.Add_Usr(user_count+1,name, username,password1,phone,email);
                        ArrayList list = db.getAll();
                        //db.deleteAll();
                        //Toast.makeText(getApplicationContext(), "Total users signed ="+user_count, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignUp.this, page1.class);
                        startActivity(intent);
                    } else {
                        pass1.setTextColor(Color.parseColor("red"));
                        Toast.makeText(getApplicationContext(), "Passwords doesn't Match", Toast.LENGTH_LONG).show();

                        pass1.setHint("Password doesn't match");
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), username+" Aleady exists. Try a new username", Toast.LENGTH_LONG).show();
                    usert.setTextColor(Color.parseColor("red"));
                    usert.setHint("Try a new username");

                }
            }
        });
    }
}

