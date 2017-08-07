package com.example.miracles_pc.menudesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MenuSelection extends AppCompatActivity {
    private Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_select);

        /*btn1 = (Button) findViewById(R.id.btnDone);
        btn2 = (Button) findViewById(R.id.btnBack);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(v.getId()==R.id.btnDone)
                {

                    finish();
                }
                else if (v.getId()==R.id.btnBack)
                {
                    Intent in=new Intent(getApplicationContext(),ListMenu.class);
                    startActivity(in);
                    finish();
                }
            }
        };
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);*/

    }
}

