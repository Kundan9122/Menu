package com.example.sel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView t1,t2;
    String name,name1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1= (TextView) findViewById(R.id.textView);
        t2= (TextView) findViewById(R.id.textView3);
        Intent i = getIntent();

        name=i.getStringExtra("name_key");
        name1=i.getStringExtra("name1_key");

        t1.setText(name);
        t2.setText(name1);
    }
}
