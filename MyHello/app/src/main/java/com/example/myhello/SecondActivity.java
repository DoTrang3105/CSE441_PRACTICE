package com.example.myhello;

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

public class SecondActivity extends AppCompatActivity {
    private Button btnBack2main;
    private TextView txt_getdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnBack2main = (Button) findViewById(R.id.btn_Back2Main);
        txt_getdata = (TextView) findViewById(R.id.txt_getdata);
        btnBack2main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent  = new Intent(SecondActivity.this, MainActivity.class);
                Intent myGotIntent = getIntent();
                Bundle mygetBundle = myGotIntent.getBundleExtra("myobj");
                String myGetString = mygetBundle.getString("data");
                txt_getdata.setText(myGetString);
                //startActivity(myIntent);
                Toast.makeText(SecondActivity.this, myGetString, Toast.LENGTH_LONG).show();
            }
        });
    }
}