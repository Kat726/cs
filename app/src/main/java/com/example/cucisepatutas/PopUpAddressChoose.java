package com.example.cucisepatutas;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.example.cucisepatutas.Model.ModelAlamat;
import com.example.cucisepatutas.adaptor.AdaptorAlamat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PopUpAddressChoose extends Activity {

    FloatingActionButton tambah;
    AdaptorAlamat adaptorAlamat;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<ModelAlamat> listAlamat;
    RecyclerView alamatTampil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_address_choose);


        tambah = findViewById(R.id.btnTambahAlamat);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PopUpAddressChoose.this, tambahActivity.class));
            }
        });   //buat menjalankan sebuah perintah pindah activity

        //diisinialisasi alamatTampil
        alamatTampil = findViewById(R.id.alamatTampil);
        //inisialisasi recycleView
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        alamatTampil.setLayoutManager(mLayout);
        alamatTampil.setItemAnimator(new DefaultItemAnimator());

        //function
        tampilData();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*8.), (int) (height*.7));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);


    }

    private void tampilData() {
        database.child("Alamat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listAlamat =  new ArrayList<>();
                //perulangan untuk mengulangkan data
                for (DataSnapshot item : snapshot.getChildren()) {
                    ModelAlamat alamat = item.getValue(ModelAlamat.class);
                    alamat.setKey(item.getKey());
                    listAlamat.add(alamat); //ditambahkan di list alamat
                }
                adaptorAlamat  = new AdaptorAlamat(listAlamat, PopUpAddressChoose.this);
                alamatTampil.setAdapter(adaptorAlamat);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}