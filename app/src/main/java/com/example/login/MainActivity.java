package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText na,ema,pass;
    Button res;
    SharedPreferences shp;

    private static final String SHARED_PREF_NAME= "mypref";
    private static final String KEY_NAME= "name";
    private static final String KEY_EMAIL= "email";
    private static final String KEY_PASS= "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        na=(EditText) findViewById(R.id.name);
        ema=(EditText) findViewById(R.id.email);
        pass=(EditText) findViewById(R.id.pass);
        res=(Button) findViewById(R.id.logout);
        shp=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name=shp.getString(KEY_NAME,null);
        if(name!=null){
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor edi=shp.edit();
                edi.putString(KEY_NAME,na.getText().toString());
                edi.putString(KEY_EMAIL,ema.getText().toString());
                edi.putString(KEY_PASS,pass.getText().toString());

                edi.apply();
                Intent in = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(in);

                Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
            }
        });

    }
}