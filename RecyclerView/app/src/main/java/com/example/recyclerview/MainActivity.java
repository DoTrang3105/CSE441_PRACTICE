package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Country> countries;
    private RecyclerView rcl_coutry;
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

        //Khởi tạo danh sách
        countries = new ArrayList<Country>();
        countries.add(new Country(R.drawable.a, "Việt Nam", "Hà Nội"));
        countries.add(new Country(R.drawable.a, "Mỹ", "Washington"));
        countries.add(new Country(R.drawable.a, "Lào", "Viên Chăn"));
        //Tham chieu va thiet lap du lieu
        rcl_coutry = (RecyclerView) findViewById(R.id.rcl_coutry);
        rcl_coutry.setAdapter(new CoutryAdapter(countries));
        rcl_coutry.setLayoutManager(new LinearLayoutManager(this));
        rcl_coutry.setHasFixedSize(true);
    }
}
