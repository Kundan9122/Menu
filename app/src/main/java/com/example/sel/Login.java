package com.example.sel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Button bt;
    String name,reg,dept;
    Spinner s;

    //Data for populating in Spinner
    String [] dept_array={"Kormangla","BTM","Sarjapur","Ejipura","Yashwantpur"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1= (EditText) findViewById(R.id.txtName);
        e2= (EditText) findViewById(R.id.txtPwd);
        s= (Spinner) findViewById(R.id.spinner);

        ArrayAdapter adapter= new ArrayAdapter(Login.this,android.R.layout.simple_spinner_item,dept_array);
        s.setAdapter(adapter);

        bt= (Button) findViewById(R.id.btnLogin);
        TextView login = (TextView)findViewById(R.id.btnLogin);
        login.setMovementMethod(LinkMovementMethod.getInstance());

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
//                startActivity(intent);
                name=e1.getText().toString();
                reg=e2.getText().toString();
                dept=s.getSelectedItem().toString();

                if (name.isEmpty() || reg.isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(),"Fields can not be empty",Toast.LENGTH_LONG);
                    toast.show();
                }
                else{
                    //Intent For Navigating to Second Activity
                    Intent i = new Intent(Login.this,MainActivity.class);

                    //For Passing the Values to Second Activity
                    i.putExtra("name_key", name);
                    i.putExtra("reg_key",reg);
                    i.putExtra("dept_key", dept);
                    startActivity(i);

                }


            }
        });
    }
}
