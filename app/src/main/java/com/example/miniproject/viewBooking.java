package com.example.miniproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class viewBooking extends AppCompatActivity {

    EditText edit;
    Button sear;
    ImageView backs;
    EventDB edb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_booking);

        edit=findViewById(R.id.ed);
        backs=findViewById(R.id.bck3);
        sear=findViewById(R.id.search);
        edb=new EventDB(this);
        ShowBook();

        backs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(viewBooking.this, User.class);
                startActivity(intent);
            }
        });
    }
    public void ShowBook(){
        sear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String EVid=edit.getText().toString();

                Cursor curs= edb.ShowBook(EVid);
                if (curs.getCount() == 0) {
                    ViewUsersDetails("Caution", "No events available");
                    return;
                }
                StringBuffer stbf=new StringBuffer();
                while(curs.moveToNext())
                {

                    stbf.append("Event ID: "+curs.getString(0)+"\n");
                    stbf.append("Event Name: "+curs.getString(1)+"\n");
                    stbf.append("Number of Tickets: "+curs.getString(2)+"\n");
                    stbf.append("Price: "+curs.getString(3)+"\n");
                    stbf.append("Phone No.: "+curs.getString(4)+"\n");
                    stbf.append("Date: "+curs.getString(5)+"\n");

                }
                ViewUsersDetails("View Event Details",stbf.toString());
            }
        });
    }
    public void ViewUsersDetails(String title, String detail){
        AlertDialog.Builder alter = new AlertDialog.Builder(this);
        alter.setCancelable(true);
        alter.setTitle(title);
        alter.setMessage(detail);
        alter.show();
    }
}