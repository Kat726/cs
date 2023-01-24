package com.example.cucisepatutas.bottombar;

//import static com.example.cucisepatutas.R.menu.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cucisepatutas.DeepCleanActivity;
import com.example.cucisepatutas.R;
import com.example.cucisepatutas.UnyellowingActivity;
import com.google.android.material.navigation.NavigationView;

public class Homeactivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mTonggle;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    //ListView listView;
    //String[] name = {"Christopher", "Jean", "Petra", "Mike", "Lina"};
    //ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setItemIconTintList(null);
        mTonggle = new ActionBarDrawerToggle(this,mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mTonggle);
        mTonggle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                    {
                        Toast.makeText(Homeactivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.nav_pesanan:
                    {
                        Toast.makeText(Homeactivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.nav_notif:
                    {
                        Toast.makeText(Homeactivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.nav_promo:
                    {
                        Toast.makeText(Homeactivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.nav_account:
                    {
                        Toast.makeText(Homeactivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.nav_setting:
                    {
                        Toast.makeText(Homeactivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.nav_commonRequlation:
                    {
                        Toast.makeText(Homeactivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.nav_PrivRules:
                    {
                        Toast.makeText(Homeactivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.nav_CS_call:
                    {
                        Toast.makeText(Homeactivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                return false;
            }
        });

//        listView = findViewById(R.id.listview);

//        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,name);
//        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
        {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else
        {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mTonggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void launchaAkunActivity(View view){
        Intent intent = new Intent(this, AkunActivity.class);
        startActivity(intent);
    }

    public void launchPesananActivity(View view){
        Intent intent = new Intent(this, PesananActivity.class);
        startActivity(intent);
    }

    public void launchDeepCleanActiviy(View view){
        Intent intent = new Intent(this, DeepCleanActivity.class);
        startActivity(intent);
    }
    public void launchUnyellowingActivity(View view){
        Intent intent = new Intent(this, UnyellowingActivity.class);
        startActivity(intent);
    }



}