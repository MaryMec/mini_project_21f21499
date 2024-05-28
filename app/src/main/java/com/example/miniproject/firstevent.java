package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class firstevent extends AppCompatActivity {
EditText Ted, Phd, Ded;
TextView t1,pri,pvi;
Button Cal, Conf;
ticket tc;
ImageView back;
EventDB edb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstevent);
        
       t1=findViewById(R.id.title);

        Ted=findViewById(R.id.tickEd);
        Phd=findViewById(R.id.PhoneED);
        Ded=findViewById(R.id.DateED);
        pri=findViewById(R.id.price);
        pvi=findViewById(R.id.Pricevi);
        back=findViewById(R.id.bck);
        Cal=findViewById(R.id.calc);
        tc=new ticket();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(firstevent.this, booking.class);
                startActivity(intent);
            }
        });

        Cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p=pri.getText().toString();
                String t=Ted.getText().toString();

                Double tp=Double.parseDouble(p);
                Double dt=Double.parseDouble(t);
                Double calc=tc.getDiscount(tp,dt);

                pvi.setText(""+calc);
                pvi.setVisibility(view.VISIBLE);
            }
        });


        Conf=findViewById(R.id.confirm);

        edb=new EventDB(this);

        AddEvent();

    }
    public void AddEvent(){
        Conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=t1.getText().toString();
                String tick=Ted.getText().toString();
                String phone=Phd.getText().toString();
                String da=Ded.getText().toString();
                String con=pvi.getText().toString();
                boolean haha=edb.AddEvent(name, tick, con, phone, da);
                if (haha==true){
                    Toast.makeText(firstevent.this,"Event added!", Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(firstevent.this, booking.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(firstevent.this,"Event already exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}