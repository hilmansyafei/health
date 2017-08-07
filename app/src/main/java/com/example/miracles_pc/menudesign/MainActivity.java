package com.example.miracles_pc.menudesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.miracles_pc.menudesign.data.SaveFruit;
import com.example.miracles_pc.menudesign.data.TestData;
import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    ImageView iBreakfast, iLunch;
    //add Hilman
    private static final String TAG = MainActivity.class.getSimpleName();
    private Firebase mRef;
    private Button addData;
    //end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this);

        //Newer version of Firebase
        if(!FirebaseApp.getApps(this).isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }

        addData = (Button)findViewById(R.id.addData);
        mRef = new Firebase("https://myhope-64e5e.firebaseio.com/Fruits");
        addData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
//                TestData data =  new TestData();
//                data.setName("hilman");
//                data.setAddress("Jakarta");
//                data.setPhoneNumber("021021021");
                //Firebase mrefChild = mRef.push();
                //mrefChild.setValue(data);

                //Firebase mrefChild = mRef.child('F4');

                //save data to Fruits
                SaveFruit data  = new SaveFruit();
                data.setCarbo("12");
                data.setFat("12");
                data.setFruit("Orange");
                data.setKkal("12");
                data.setProtein("14");
                Firebase mrefChild = mRef.child("F5");
                mrefChild.setValue(data);

                Log.v(TAG,"masuk");
            }
        });

        iBreakfast = (ImageView) findViewById(R.id.img1);
        iLunch = (ImageView) findViewById(R.id.img3);

        iBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListMenu.class);
                startActivity(intent);
            }
        });
        iLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListMenu.class);
                startActivity(intent);
            }
        });
    }
}
