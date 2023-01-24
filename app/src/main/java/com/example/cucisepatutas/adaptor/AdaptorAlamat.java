package com.example.cucisepatutas.adaptor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cucisepatutas.Dialog.DialogForm;
import com.example.cucisepatutas.Model.ModelAlamat;
import com.example.cucisepatutas.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdaptorAlamat extends RecyclerView.Adapter<AdaptorAlamat.MyViewHolder> {
    private List<ModelAlamat> mList;
    private Activity activity;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public AdaptorAlamat(List<ModelAlamat>mList, Activity activity) {
        this.mList = mList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.layout_pop_up_address_choose_activity, parent, false);
        return new MyViewHolder(viewItem);
    }

    /* attachToRoot
    * jika disetel ke false, mereka tidak ditambahkan sebagai turunan langsung dari induk
    * dan induk tidak
    *  menerima peristiwa sentuh apa pun dari tampilan
    * */

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    //memasukkan datanya disini
        final ModelAlamat data  = mList.get(position);
        holder.Rumah.setText("Label Nama : " + data.getLabelAlamat());
        holder.SpesifikAlamat1.setText("Alamat Lengkap : " + data.getNoRumah());
        //inisialisasi button hapus dan setoNCLICKLISTENER, jika diklik akan menjalankan sebuah
        // perintah
        holder.btn_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ketika diklik buttonnya, maka:
                //entar ada alert apakah user akan menghapus data nya atau tidak, klik YES or NO
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        database.child("Alamat").child(data.getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(activity, "Berhasil dihapus!", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(activity, "Gagal Menghapus Data!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setMessage("Apakah yakin mau menghapus ? " + data.getLabelAlamat() + data.getNoRumah());
                builder.show();
            }
        });
        holder.card_hasil.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                //menuliskan fragmentManager, klik cardhasil akan menjalankan fragment manager
                FragmentManager manager = ((AppCompatActivity)activity).getSupportFragmentManager();
                //setelah dibuat fragment manager, lalu constructor dialog form yang mana akan
                //mengirimkan data ke dialog form
                DialogForm dialog = new DialogForm(
                        data.getLabelAlamat(),
                        data.getNoRumah(),
                        data.getKey(),
                        "ubah"
                );
                dialog.show(manager, "form");

                return true;
            }
        });
       ///setOnLongClickListener, ketika tekan card, maka langsung keproses
        ///setOnLongListener,ketika pencet cardnya lama baru diproses
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Rumah, SpesifikAlamat1;
        ImageView btn_hapus;
        CardView card_hasil;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Rumah = itemView.findViewById(R.id.Rumah);
            SpesifikAlamat1 = itemView.findViewById(R.id.SpesifikAlamat1);
            btn_hapus = itemView.findViewById(R.id.hapusAlamat);
            card_hasil = itemView.findViewById(R.id.card_pesanan);
        }
    }
}


/*
* jika kita klik cardHasil yang ada di PopUpAddressChoose, klik lama, maka dia akan menjalankan
* setOnLongClickListener yang ada di baris 93 class adaptorAlamat, then kita akan menjalankan
* sebuah fragmentManager dimana nanti akan membuka sebuah dialogForm yang sudah kita buat.
* didalam dialogform terdapat constructor a.k.a mengirimkan sebuah data, setelah itu bakal
* ke transfer ke dialogForm constructor
*
* di class dialogForm baris 24, string nya entar akan dimasukkan ke baris setTextLabelAlamat,
* setTextAlamatLengkap dll.
*
* setelah menjalankan dialogForm, maka akan muncul dialognya, setelah diisi, diedit, baru
* ketika klik ubah pilih nya ubah, maka dia akan menjalankan perintah update sesuai dengan
* modelAlamat
*
* */