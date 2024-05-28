package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//first we define the variables
    EditText email, password;
    Button   login, signup;

    RegDB regDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.ed1);
        password = (EditText) findViewById(R.id.ed2);
        login = (Button) findViewById(R.id.b1);
        signup = (Button) findViewById(R.id.b2);






        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, RegUsers.class);
                startActivity(intent);

            }
        });

        regDB=new RegDB(this);
        login();


    }

    public void login()
    {


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=email.getText().toString();
                String pass=password.getText().toString();
                if (mail.equals("admin") &&  pass.equals("password"))
                {

                        Intent intent=new Intent(MainActivity.this, admin.class);
                        startActivity(intent);


                }
else
                {
                    try{
                        String det=regDB.login(mail);
                        if(pass.equals(det))
                        {
                            Toast.makeText(MainActivity.this,"Logged in!", Toast.LENGTH_SHORT).show();
                            email.setText("");
                            password.setText("");
                            Intent intent=new Intent(MainActivity.this, User.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity.this,"invalid details", Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch(Exception e){
                        Toast.makeText(MainActivity.this," incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}