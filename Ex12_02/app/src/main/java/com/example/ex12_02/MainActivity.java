package com.example.ex12_02;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ex12_02.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<String> arraywork;
    ArrayAdapter<String> arrAdapter;
    EditText edtwork, edth, edtm;
    TextView txtdate;
    Button btnwork;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edth = findViewById(R.id.edthour);
        edtm = findViewById(R.id.edtmi);
        edtwork = findViewById(R.id.edtwork);
        btnwork = findViewById(R.id.btnadd);
        lv = findViewById(R.id.listView1);
        txtdate = findViewById(R.id.txtDate);
        arraywork = new ArrayList<>();
        arrAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arraywork);
        lv.setAdapter(arrAdapter);
        sharedPreferences = getSharedPreferences("workData", MODE_PRIVATE);
        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText("Hôm nay: "+simpleDateFormat.format(currentDate));
        loadSavedWork();
        btnwork.setOnClickListener(new View.OnClickListener() {

        });
    }


    private void saveWorkList() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> set = new HashSet<>(arraywork);
        editor.putStringSet("workList", set);
        editor.apply();
    }


    private void loadSavedWork() {
        Set<String> set = sharedPreferences.getStringSet("workList", null);
        if (set != null) {
            arraywork.clear();
            arraywork.addAll(set);
            arrAdapter.notifyDataSetChanged();
        }
    }
}