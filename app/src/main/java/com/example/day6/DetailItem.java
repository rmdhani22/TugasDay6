package com.example.day6;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.text.NumberFormat;
import java.util.Locale;


public  class DetailItem extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.detail_item);
        String namaItem = getIntent().getStringExtra("nama_barang");
        String deskripsiItem = getIntent().getStringExtra("deskripsi_barang");
        double hargaItem = getIntent().getDoubleExtra("harga_barang", 0.0);
        int gambarItems = getIntent().getIntExtra("gambar_Item", R.drawable.ic_launcher_background);

        TextView namaTextView = findViewById(R.id.nama_barang);
        TextView deskripsiTextView = findViewById(R.id.deskripsi_barang);
        TextView hargaTextView = findViewById(R.id.harga_barang);
        ImageView gambarImageView = findViewById(R.id.gambar_barang);
        Button shareButton = findViewById(R.id.share);

        namaTextView.setText(namaItem);
        deskripsiTextView.setText(deskripsiItem);
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedHarga = formatter.format(hargaItem);
        hargaTextView.setText("Harga: " + formattedHarga);
        gambarImageView.setImageResource(gambarItems);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), gambarItems);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, bytes);
                String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Title", null);
                Uri imageUri = Uri.parse(path);

                String shareText = "Check this out : " + namaItem + "\n\nDescription: " + deskripsiItem + "\n\nPrice: " + hargaItem;
                Intent shareIntent = new Intent(Intent.ACTION_SEND);

                shareIntent.setType("image/*");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });
    }
}