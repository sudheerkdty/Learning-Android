package com.test.test.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import junit.framework.Assert;

/**
 * Created by nuventure on 19/2/16.
 */
public class EditUser extends AppCompatActivity {
    Spinner dropdown;
    Button update;
    EditText editText;
    String[] items;
    DataBase db = new DataBase(this);
    User user;
    String update_data = null;
    int user_id,choice ;
    String userid;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_user);
        user_id = getIntent().getIntExtra("intVariableName",0);

        update = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);

        update_data = editText.getText().toString();


        dropdown = (Spinner) findViewById(R.id.dropDown);
        items = new String[]{"Name", "Username", "Password", "Phone No", "Email ID"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        user = db.getUser(user_id);

        dropdown.setAdapter(adapter);
        //Toast.makeText(this,user.getUserName(),Toast.LENGTH_LONG).show();
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

                choice = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }});

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                userid = user.getUserName();
                update(user, update_data, choice);
                db.updateUser(user);

                Intent intent = new Intent(EditUser.this,loginSuccess.class).putExtra("<StringName>", userid);
                startActivity(intent);
                finish();

            }
        });


    }
    User update(User user, String data, int pos){
        switch (pos) {
            case 0:
                user.setName(data);
                break;
            case 1:
                user.setUserName(data);
                break;
            case 2:
                user.set_password(data);
                break;
            case 3:
                user.setPhoneNumber(data);
                break;
            case 4:
                user.setEmail(data);
                break;

        }
        return user;
    }



    }


