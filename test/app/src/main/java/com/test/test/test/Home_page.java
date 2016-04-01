package com.test.test.test;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Home_page extends AppCompatActivity {
    String msg = "Android : ";
    Button b1,b2;
    EditText e1,e2;
    TextView t1;
    DataBase db = new DataBase(this);
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        e1 =(EditText)findViewById(R.id.usr);
        e2 =(EditText)findViewById(R.id.pwd);
        t1 = (TextView)findViewById(R.id.textView);
        b1=(Button)findViewById(R.id.start);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startService();
                String username = e1.getText().toString();
                String password = e2.getText().toString();
                if((db.userExists(username))) {
                    String pwd = db.getpwd(username);
                    if (pwd.equals(password)) {
                        if (username.equals("Admin")||username.equals("admin")){
                            Intent intent1 = new Intent(Home_page.this, Admin.class);
                            startActivity(intent1);
                        }
                        else {
                            Intent intent = new Intent(Home_page.this, loginSuccess.class).putExtra("<StringName>", username);
                            startActivity(intent);
                        }
                    } else {
                        e2.setTextColor(Color.parseColor("red"));
                        e2.setText("Error");
                        t1.setTextColor(Color.parseColor("red"));
                        t1.setText("Try Again");
                        Toast.makeText(getApplicationContext(), "The password you entered is wrong", Toast.LENGTH_LONG).show();

                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), username + " Does not exist. Please Sign Up", Toast.LENGTH_LONG).show();
                    e1.setHint("Try Existing Username");
                    e1.setTextColor(Color.parseColor("red"));
                }
            }
        });
        b2=(Button)findViewById(R.id.signup);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_page.this, SignUp.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }
}
