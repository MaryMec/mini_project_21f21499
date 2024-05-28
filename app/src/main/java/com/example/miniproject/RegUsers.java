package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegUsers extends AppCompatActivity {

    EditText fn, ln, num, mail, pass;
    Button Register, Reset;

    RegDB regdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_users);

        fn=findViewById(R.id.fned);
        ln=findViewById(R.id.lned);
        num=findViewById(R.id.numed);
        mail=findViewById(R.id.mailed);
        pass=findViewById(R.id.passed);

        Register=findViewById(R.id.regbutt);
        Reset=findViewById(R.id.resetbutt);

        ResetData();
        newUser();
        regdb=new RegDB(this);



    }

    private void ResetData() {
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        fn.setText("");
        ln.setText("");
        num.setText("");
        mail.setText("");
        pass.setText("");
            }
        });
    }


    public void newUser(){

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String efn=fn.getText().toString();
                String eln=ln.getText().toString();
                String numb=num.getText().toString();
                String emai=mail.getText().toString();
                String epass=pass.getText().toString();

                Boolean Add=regdb.newUser(efn, eln, numb,emai,epass);
                if (Add==true){
                    Toast.makeText(RegUsers.this,"Account added!", Toast.LENGTH_SHORT).show();


                    //Intent
                    Intent intent=new Intent(RegUsers.this, MainActivity.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(RegUsers.this,"Account already exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}