package com.example.myhello;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//properties
    private TextView txtGreeting;
    private Button btnClickMe;
//hethods
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //B1.Tham chiếu Biến tới phần tử giao diện
        txtGreeting = (TextView) findViewById(R.id.txt_Greeting);
        btnClickMe = (Button) findViewById(R.id.btn_click_me);
        //B2 Bat su kien Click
        btnClickMe.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(myIntent);
        //Truyen cai gi: Bundle Object
        Bundle myObject = new Bundle();
        myObject.putString("data","Xin chao Second");
        //Truyen thong tin trong Intent
        myIntent.putExtra("myobj",myObject);
        startActivity(myIntent);
    }
}