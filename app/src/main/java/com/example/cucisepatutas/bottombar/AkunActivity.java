package com.example.cucisepatutas.bottombar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cucisepatutas.Lodingactivity;
import com.example.cucisepatutas.MainActivity;
import com.example.cucisepatutas.R;
import com.example.cucisepatutas.Signup;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class AkunActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mTonggle;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    private Button btnlogout;
    private FirebaseAuth Mauth;

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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (mTonggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_for_akun);
        navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setItemIconTintList(null);
        mTonggle = new ActionBarDrawerToggle(this,mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mTonggle);
        mTonggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                    {
                        Toast.makeText(AkunActivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.nav_pesanan:
                    {
                        Toast.makeText(AkunActivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.nav_notif:
                    {
                        Toast.makeText(AkunActivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.nav_promo:
                    {
                        Toast.makeText(AkunActivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.nav_account:
                    {
                        Toast.makeText(AkunActivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.nav_setting:
                    {
                        Toast.makeText(AkunActivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.nav_commonRequlation:
                    {
                        Toast.makeText(AkunActivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.nav_PrivRules:
                    {
                        Toast.makeText(AkunActivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.nav_CS_call:
                    {
                        Toast.makeText(AkunActivity.this, "feature coming soon", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

                return false;
            }
        });



        btnlogout = findViewById(R.id.logout);
        btnlogout.setOnClickListener(v ->{
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), Lodingactivity.class));
            finish();
        });

    }
    public void launchLogOutActivity (View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void launchAccountToHomeMenu(View view){
        Intent intent = new Intent(this, Homeactivity.class);
        startActivity(intent);
    }

    public void launchPesananActivity (View view){
        Intent intent = new Intent(this, PesananActivity.class);
        startActivity(intent);
    }

    public void launchHomeMenuActivitity(View view) {
        Intent intent = new Intent(this, Homeactivity.class);
        startActivity(intent);
    }



}