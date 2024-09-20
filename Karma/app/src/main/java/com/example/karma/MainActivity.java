package com.example.karma;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView txt_karma;
    private TextView txt_signin;
    private EditText edit_textemail;
    private EditText edit_textpass;
    private CheckBox CheckBox_me;
    private TextView txt_Still;
    private TextView txt_Signup;
    private Button btn_signin;
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
        txt_karma = (TextView)  findViewById(R.id.txt_karma);
        txt_signin = (TextView) findViewById(R.id.txt_signin);
        edit_textemail = (EditText) findViewById(R.id.edit_textemail);
        edit_textpass = (EditText) findViewById(R.id.edit_textpass);
        CheckBox_me = (CheckBox) findViewById(R.id.CheckBox_me);
        txt_Still = (TextView) findViewById(R.id.txt_Still);
        txt_Signup = (TextView) findViewById(R.id.txt_Signup);
        btn_signin = (Button) findViewById(R.id.btn_signin);
    }
}