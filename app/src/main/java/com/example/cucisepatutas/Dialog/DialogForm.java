package com.example.cucisepatutas.Dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.app.Dialog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.cucisepatutas.Model.ModelAlamat;
import com.example.cucisepatutas.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogForm extends DialogFragment {
    String labelAlamat, spesifikAlamat, key, pilih;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    //membuat constructor

    public DialogForm(String alamat, String labelAlamat, String spesifikAlamat, String pilih) {
        this.labelAlamat = labelAlamat;
        this.spesifikAlamat = labelAlamat;
        this.key  = key;
        this.pilih = pilih;
    }
    TextView tLabelAlamat, tAlamatLengkap;
    Button btn_Simpan;

    // membuat onCreateView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_tambah, container, false);
        tLabelAlamat = view.findViewById(R.id.labelAlamat);
        tAlamatLengkap = view.findViewById(R.id.alamatLengkap);
        btn_Simpan = view.findViewById(R.id.btn_Simpan);

        //memasukkan isinya
        tLabelAlamat.setText(labelAlamat);
        tAlamatLengkap.setText(spesifikAlamat);
        btn_Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mengambil data2 form yang kita edit atau kita ambil dengan getText
                String labelAlamat = tLabelAlamat.getText().toString();
                String alamatLengkap =tAlamatLengkap.getText().toString();
                //pilih sesuai pilihannya
                if (pilih.equals("Ubah")){
                    //jika pilih isinya ialah ubah, maka dia akan menjalankan perintah update
                    database.child("Alamat").child(key).setValue(new ModelAlamat(labelAlamat, alamatLengkap)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(view.getContext(), "Berhasil di Update", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(view.getContext(), "Maaf gagal mengupdate data!", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });

        return view;
    }

    @Override
    public void onStart() {  //template method
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}

//membuat layout inflator, supaya menampilkan layout punyanya si activity tambah
