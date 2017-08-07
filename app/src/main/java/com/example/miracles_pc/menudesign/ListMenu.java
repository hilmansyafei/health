package com.example.miracles_pc.menudesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class ListMenu extends AppCompatActivity {
    private ListView mListView;
    private DatabaseReference ref;
    private ArrayList mFruits = new ArrayList();
    EditText inputSearch;
    ArrayAdapter<String> adapter;
    static boolean calledAlready = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //tambahan
        mListView = (ListView) findViewById(R.id.listView);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        if (!calledAlready)
        {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            calledAlready = true;
        }
        ref = FirebaseDatabase.getInstance().getReferenceFromUrl
                ("https://myhope-64e5e.firebaseio.com/Fruits");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mFruits);
        mListView.setAdapter(adapter);


        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Map<String, Object> newPost = (Map<String, Object>) dataSnapshot.getValue();
                String buah = newPost.get("Fruit").toString();
                mFruits.add(buah);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                ListMenu.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {

            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                Object fruit = (String) arg0.getItemAtPosition(arg2);
                String string = fruit.toString();

                if (Objects.equals(string, "Mango")) {
                    Intent myIntent = new Intent(arg1.getContext(), GetMenu_1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (Objects.equals(string, "Apple")) {
                    Intent myIntent = new Intent(arg1.getContext(), GetMenu_2.class);
                    startActivityForResult(myIntent, 0);
                }

                if (Objects.equals(string, "Kiwi")) {
                    Intent myIntent = new Intent(arg1.getContext(), GetMenu_3.class);
                    startActivityForResult(myIntent, 0);
                }

                if (Objects.equals(string, "Strawberry")) {
                    Intent myIntent = new Intent(arg1.getContext(), GetMenu_4.class);
                    startActivityForResult(myIntent, 0);
                }
        }});
    }
}

