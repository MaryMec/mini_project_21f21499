package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class cancel extends AppCompatActivity {

    EditText edit;
    Button canc;
    ImageView back;
    EventDB edb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);

        edit=findViewById(R.id.ed);
        canc=findViewById(R.id.cancel);
        back=findViewById(R.id.bckk2);
        edb=new EventDB(this);
        canceldata();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(cancel.this, User.class);
                startActivity(intent);
            }
        });
    }
    public void canceldata(){
        canc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Phone = edit.getText().toString();
                Integer cancel = edb.canceldata(Phone);
                if (cancel > 0) {
                    Toast.makeText(cancel.this, "Event cancelled!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(cancel.this, User.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(cancel.this, "cancel incomplete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}