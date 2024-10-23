package vn.edu.tlu.m2151173772;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// open drawer
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new coffeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_coffe);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_coffe) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new coffeFragment()).commit();
        } else if (id == R.id.nav_juice) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fruitjuiceFragment()).commit();
        } else if (id == R.id.nav_tea) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new specialteaFragment()).commit();
        } else if (id == R.id.nav_cake) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new cakeFragment()).commit();
        } else if (id == R.id.nav_savory) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new savorycakeFragment()).commit();
        } else if (id == R.id.nav_setting) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new settingFragment()).commit();
        } else if (id == R.id.nav_singout) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new singoutFragment()).commit();
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

        return false;
    }
}
