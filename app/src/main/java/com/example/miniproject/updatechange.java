package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class updatechange extends AppCompatActivity {
EditText newDate, eventId;
Button  chanBt;
ImageView back;
EventDB edb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatechange);

        newDate=findViewById(R.id.datex);
        eventId=findViewById(R.id.idtxt);
        chanBt=findViewById(R.id.chBT);
        back=findViewById(R.id.bck);
        edb=new EventDB(this);
        ChangeBooking();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent (updatechange.this, User.class);
                startActivity(intent);
            }
        });
    }
    public void ChangeBooking(){
        chanBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String evexid=eventId.getText().toString();
                String NewD=newDate.getText().toString();

                boolean boo= edb.ChangeBooking(NewD, evexid);
                if (boo==true){

                    Toast.makeText(updatechange.this,"update done!", Toast.LENGTH_SHORT).show();
                    
                //Intent to switch layouts
                Intent intent=new Intent(updatechange.this, booking.class);
                startActivity(intent);

            }
                else
            {
                Toast.makeText(updatechange.this,"change already done", Toast.LENGTH_SHORT).show();
            }
            }
        });

    }
}
