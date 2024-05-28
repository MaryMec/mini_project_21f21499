package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class booking extends AppCompatActivity {
CardView crd1, crd2, crd3, crd4;

ImageView img1,img2, backk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        crd1=findViewById(R.id.c1);
        crd2=findViewById(R.id.c2);
        crd3=findViewById(R.id.c3);
        crd4=findViewById(R.id.c4);
       backk=findViewById(R.id.bckk);

        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(booking.this, User.class);
                startActivity(intent);
            }
        });

        crd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(booking.this, firstevent.class);
                startActivity(intent);

            }
        });

        crd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(booking.this,secondevent.class);
                startActivity(intent);
            }
        });

        crd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(booking.this,thirdevent.class);
                startActivity(intent);
            }
        });

        crd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(booking.this,fourevent.class);
                startActivity(intent);
            }
        });

    }
}