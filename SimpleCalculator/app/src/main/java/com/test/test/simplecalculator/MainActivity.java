package com.test.test.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button zer,on,tw,thr,fou,fiv,sx,sevn,eit,nin,addd,subs,mult,divid,memadd,memremv,memory,delete,dott,equals;
    TextView disp;
    String result,memorydata,operand1,operand2,operator;
    int limit = 7;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zer = (Button)findViewById(R.id.zero);
        on = (Button)findViewById(R.id.one);
        tw = (Button)findViewById(R.id.two);
        thr = (Button)findViewById(R.id.three);
        fou = (Button)findViewById(R.id.four);
        fiv = (Button)findViewById(R.id.five);
        sx = (Button)findViewById(R.id.six);
        sevn = (Button)findViewById(R.id.seven);
        eit = (Button)findViewById(R.id.eight);
        nin = (Button)findViewById(R.id.nine);
        dott = (Button)findViewById(R.id.dot);
        equals = (Button)findViewById(R.id.equals);
        addd = (Button)findViewById(R.id.add);
        subs = (Button)findViewById(R.id.sub);
        mult = (Button)findViewById(R.id.mul);
        divid = (Button)findViewById(R.id.div);
        memadd = (Button)findViewById(R.id.mp);
        memremv = (Button)findViewById(R.id.mm);
        memory = (Button)findViewById(R.id.mem);
        delete = (Button)findViewById(R.id.del);
        disp = (TextView)findViewById(R.id.display);
        result = memorydata = operand1 = operand2 =operator = "";
        zer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ((operand1.length())<limit) {
                    operand1 = operand1 + '0';
                    disp.setText(operand1);
                }
            }
        });
        memory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!(memorydata.equals(""))) {
                    operand2 = memorydata;
                    disp.setText(memorydata);

                }
            }
        });
        memadd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                memorydata = operand1;
                Toast.makeText(getBaseContext(),memorydata+"  Added to Memory",Toast.LENGTH_LONG).show();
            }
        });
        memremv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                memorydata ="";
                Toast.makeText(getBaseContext(),"Memory Cleared",Toast.LENGTH_LONG).show();
            }
        });
        on.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ((operand1.length())<limit) {
                    operand1 = operand1 + '1';
                    disp.setText(operand1);
                }
            }
        });
        tw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ((operand1.length())<limit) {
                    operand1 = operand1 + '2';
                    disp.setText(operand1);
                }
            }
        });
        thr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ((operand1.length())<limit) {
                    operand1 = operand1 + '3';
                    disp.setText(operand1);
                }
            }
        });
        fou.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ((operand1.length())<limit) {
                    operand1 = operand1 + '4';
                    disp.setText(operand1);
                }
            }
        });
        fiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ((operand1.length())<limit) {
                    operand1 = operand1 + '5';
                    disp.setText(operand1);
                }
            }
        });
        sx.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ((operand1.length())<limit) {
                    operand1 = operand1 + '6';
                    disp.setText(operand1);
                }
            }
        });
        sevn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ((operand1.length())<limit) {
                    operand1 = operand1 + '7';
                    disp.setText(operand1);
                }
            }
        });
        eit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ((operand1.length())<limit) {
                    operand1 = operand1 + '8';
                    disp.setText(operand1);
                }
            }
        });
        nin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ((operand1.length())<limit) {
                    operand1 = operand1 + '9';
                    disp.setText(operand1);
                }
            }
        });
        dott.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if ((operand1.length())<limit) {
                    if (!(operand1.endsWith("."))) {
                        operand1 = operand1 + '.';
                        disp.setText(operand1);
                    }
                }
                disp.setText(operand1);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (operand1.length() > 0) {
                    operand1 = operand1.substring(0, operand1.length() - 1);
                }
                disp.setText(operand1);
            }
        });
        delete.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getBaseContext(),"RESET",Toast.LENGTH_LONG).show();
                operand1 = operand2 = "";
                disp.clearComposingText();
                return false;
            }


        });
        mult.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(getBaseContext(),"*",Toast.LENGTH_LONG).show();
                operator = "*";
                if((operand2.equals(""))) {
                    operand2 = operand1;
                    operand1 = "";
                }operand1 = "";
            }
        });
        divid.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(getBaseContext(),"/",Toast.LENGTH_LONG).show();
                operator = "/";
                if((operand2.equals(""))) {
                    operand2 = operand1;
                    operand1 = "";
                }operand1 = "";
            }
        });
        subs.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                operator = "-";
                Toast.makeText(getBaseContext(),"-",Toast.LENGTH_LONG).show();
                if((operand2.equals(""))) {
                    operand2 = operand1;
                    operand1 = "";
                }operand1 = "";
            }
        });
        addd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                operator = "+";
                if((operand2.equals(""))) {
                    operand2 = operand1;
                    operand1 = "";
                }operand1 = "";
                Toast.makeText(getBaseContext(),operator,Toast.LENGTH_LONG).show();
                //Toast.makeText(getBaseContext(),"+"+"operand2 ="+operand2+"op1="+operand1,Toast.LENGTH_LONG).show();
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                float res = 0, op1 = 0, op2 = 0;
                try {
                    if (!(operand2.contains(".") && operand1.contains("."))) {
                        op1 = Float.parseFloat(operand1);
                        op2 = Float.parseFloat(operand2);
                    } else {

                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }

                if (operator.equals("+")) {
                    if (!(operand1.equals(""))) {
                        res = op2 + op1;

                    }
                } else if (operator.equals("-")) {
                    if (!(operand1.equals(""))) {
                        res = op2 - op1;

                    }
                } else if (operator.equals("/")) {
                    if (!(operand1.equals(""))) {
                        res = op2 / op1;

                    }
                } else if (operator.equals("*")) {
                    if (!(operand1.equals(""))) {
                        res = op2 * op1;

                    }

                }
                if ((String.valueOf(res)).endsWith(".0")) {
                    disp.setText(String.valueOf(Math.round(res)));
                } else {
                    disp.setText(String.valueOf(res));
                }
                operand1 = "";
                operand2 = String.valueOf(res);
            }
        });
        }
    }
