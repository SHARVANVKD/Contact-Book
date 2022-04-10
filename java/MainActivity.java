package com.example.contactbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText name , phone , email;
    Button add,show;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button) findViewById(R.id.btn_add_contact);
        show = (Button)findViewById(R.id.btn_show_contacts);

        name = (EditText)findViewById(R.id.Edt_name);
        phone = (EditText)findViewById(R.id.Edt_phone_num);
        email = (EditText)findViewById(R.id.Edt_email);

        dbHandler = new DBHandler(MainActivity.this);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_feild = name.getText().toString();
                String phone_feild = phone.getText().toString();
                String email_feild = email.getText().toString();

                if (name_feild.isEmpty() || phone_feild.isEmpty() || email_feild.isEmpty() ) {
                    Toast.makeText(MainActivity.this, "All Data Wanted , Please Try", Toast.LENGTH_SHORT).show();
                }else {
                    dbHandler.addNewContact(name_feild, phone_feild, email_feild);

                    Toast.makeText(MainActivity.this, "New Contact Successfully Added", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    phone.setText("");
                    email.setText("");
                }
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , show_contacts.class);
                startActivity(intent);
            }
        });
    }
}