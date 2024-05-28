package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class admin extends AppCompatActivity {
    Button Vbook, Vusers, out;
    ImageView back;
    RegDB regDB;
    EventDB eventDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Vusers=findViewById(R.id.adminuserbtn);
        Vbook=findViewById(R.id.adminbookingbtn);
        out=findViewById(R.id.logout);
        back=findViewById(R.id.bck);

        eventDB=new EventDB(this);
        regDB=new RegDB(this );
        ViewUsers();
        ViewBooking();
    }


    private void ViewBooking() {

        Vbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(admin.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

                out.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    System.exit(0);
                    }
                });

                Cursor curs=eventDB.ViewBooking();
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

    public void ViewUsers ()
    {
        Vusers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor curs=regDB.ViewUsers();
                if(curs.getCount()==0)
                {
                    ViewUsersDetails("No details available", "Cannot display details");
                    return;

                }
StringBuffer buff = new StringBuffer();
                while (curs.moveToNext()){
                    buff.append("FirstName :"+curs.getString(0)+"\n");
                    buff.append("LastName :"+curs.getString(1)+"\n");
                    buff.append("PhoneNumber :"+curs.getString(2)+"\n");
                    buff.append("Email :"+curs.getString(3)+"\n");
                    buff.append("Password :"+curs.getString(4)+"\n");
                }
            ViewUsersDetails("The user Details", buff.toString());
            }

        }) ;

    }

    public void ViewUsersDetails(String title, String detail){
        AlertDialog.Builder alter = new AlertDialog.Builder(this);
        alter.setCancelable(true);
        alter.setTitle(title);
        alter.setMessage(detail);
        alter.show();
    }
}