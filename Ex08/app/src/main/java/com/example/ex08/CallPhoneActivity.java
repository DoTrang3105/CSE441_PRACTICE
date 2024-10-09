package com.example.ex08;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class CallPhoneActivity extends AppCompatActivity {
    EditText edtcall;
    ImageButton btncallphone;
    Button btnback1; 
    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); onCreate(R.layout.call_layout);
        edtcall = (EditText) edtcall.findViewById(R.id.edtcall);
        btnback1 = (Button) edtcall.findViewById(R.id.btnback1);
        btncallphone = (ImageButton) edtcall.findViewById(R.id.btncallphone);
        btncallphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callintent = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:"+edtcall.getText().toString()));
// Yêu cầu người dùng đồng ý quyền truy cập vào tính năng gọi điện
                if (ActivityCompat.checkSelfPermission(CallPhoneActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CallPhoneActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
                    return;
                }
                startActivity(callintent);

            }
        });
        btnback1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}


