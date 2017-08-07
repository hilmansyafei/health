package com.example.miracles_pc.menudesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GetMenu_1 extends AppCompatActivity {
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_get1);

        imgView = (ImageView) findViewById(R.id.imgView);

        String url = "https://firebasestorage.googleapis.com/v0/b/myhope-64e5e.appspot.com/o/Buah%2FApple.PNG?alt=media&token=7f7cc4af-affb-4055-b610-5537e81d4641";

        Glide.with(getApplicationContext()).load(url).into(imgView);

        Button next = (Button) findViewById(R.id.btnNext);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MenuSelection.class);
                startActivityForResult(myIntent, 0);
            }

        });
    }
}
