package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText na,ema,pass;
    Button log;
    SharedPreferences shp;

    private static final String SHARED_PREF_NAME= "mypref";
    private static final String KEY_NAME= "name";
    private static final String KEY_EMAIL= "email";
    private static final String KEY_PASS= "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        na=(EditText) findViewById(R.id.name);
        ema=(EditText) findViewById(R.id.email);
        pass=(EditText) findViewById(R.id.pass);
        log=(Button) findViewById(R.id.logout);
        shp=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name=shp.getString(KEY_NAME,null);
        String email=shp.getString(KEY_EMAIL,null);
        String password=shp.getString(KEY_PASS,null);

        if(name !=null || email!=null || pass!=null){

            na.setText("NAME -"+name);
            ema.setText("Email -"+email);
            pass.setText("PASSWORD -"+password);

        }
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor edi=shp.edit();
                edi.clear();
                edi.commit();
                finish();
                Toast.makeText(MainActivity2.this,"LOGOUT SUCCESSFUL",Toast.LENGTH_SHORT).show();
            }
        });
    }
}