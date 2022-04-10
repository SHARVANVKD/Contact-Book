package com.example.contactbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class show_contacts extends AppCompatActivity {
    private ArrayList<ContactModal> contactModalArrayList;
    private DBHandler dbHandler;
    private ContactRVAdapter contactAdapter;
    private RecyclerView coursesRV;

    AutoCompleteTextView name;
    List<String> item = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contacts);

        contactModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(show_contacts.this);
        contactModalArrayList = dbHandler.readContact();

        contactAdapter = new ContactRVAdapter(contactModalArrayList, show_contacts.this);
        coursesRV = (RecyclerView) findViewById(R.id.RV_Contact);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(show_contacts.this,
                RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);

        coursesRV.setAdapter(contactAdapter);

        item = dbHandler.read_for_AutoTextView();
        adapter = new ArrayAdapter<String>(show_contacts.this , android.R.layout.simple_list_item_1,item);
        name.setThreshold(1);
        name.setAdapter(adapter);

//        while (cur.isAfterLast() == false) {
//            String logic = cur.getString(0);
//            item.add(logic);
//            cur.moveToNext();
//        }
//
//        adapter = new ArrayAdapter<String>(getBaseContext(),
//                android.R.layout.simple_list_item_1, item);
//        name.setThreshold(1);
//        name.setAdapter(adapter);


    }
}