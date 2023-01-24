package com.example.cucisepatutas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cucisepatutas.Model.ModelAlamat;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tambahActivity extends AppCompatActivity {
    EditText editLabelAlamat, editAlamatLengkap;
    Button btnSimpan;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        editLabelAlamat = findViewById(R.id.labelAlamat);
        editAlamatLengkap = findViewById(R.id.alamatLengkap);
        btnSimpan = findViewById(R.id.btn_Simpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getLabelAlamat = editLabelAlamat.getText().toString();
                String getAlamatLengkap = editAlamatLengkap.getText().toString();

                if (getLabelAlamat.isEmpty()) {
                    editLabelAlamat.setError("Label Alamat masih kosong");
                } else if (getAlamatLengkap.isEmpty()) {
                    editAlamatLengkap.setError("Alamat Lengkap masih kosong");
                } else {
                    database.child("Alamat").push().setValue(new ModelAlamat(getLabelAlamat, getAlamatLengkap)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(tambahActivity.this,"Data berhasil disimpan !",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(tambahActivity.this, PopUpAddressChoose.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(tambahActivity.this,"Gagal Menyimpan Data !",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        /*
        ketika btn simpan di klik, kita mau menjalankan input data, nah datanya itu diambil dari
        editText text label alamat dengan alamat lengkap

        *mengambil data ialah getText
        *menampilkan data ialah setText

        * */
    }
}