package com.example.persistentdatainternaleksternalstorage;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class activity_external extends AppCompatActivity implements View.OnClickListener {
    public static final String FILENAME = "namafile.txt";
    public static String TAG = BuildConfig.APPLICATION_ID;
    public static final int REQUEST_CODE_STORAGE = 100;
    Button buatFile, ubahFile, bacaFile, deleteFile;
    public int selectEvent = 0;

    TextView textBaca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);
        buatFile = findViewById(R.id.buttonBuatFile);
        ubahFile = findViewById(R.id.buttonUbahFile);
        bacaFile = findViewById(R.id.buttonBacaFile);
        deleteFile = findViewById(R.id.buttonHapusFile);
        textBaca = findViewById(R.id.textBaca);
        buatFile.setOnClickListener(this);
        ubahFile.setOnClickListener(this);
        bacaFile.setOnClickListener(this);
        deleteFile.setOnClickListener(this);
    }

    public boolean periksaIzinPenyimpanan() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_STORAGE);
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE_STORAGE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    jalankanPerintah(selectEvent);
                }
                break;
        }
    }

    void buatFile() {
        String isiFile = "Coba Isi Data File Text";
        String state = Environment.getExternalStorageState();

        if (!Environment.MEDIA_MOUNTED.equals(state)) {
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(), FILENAME);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void ubahFile() {
        String ubah = "Update Isi Data File Text";
        String state = Environment.getExternalStorageState();

        if (!Environment.MEDIA_MOUNTED.equals(state)) {
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory(), FILENAME);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(ubah.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bacaFile() {
        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(sdcard, FILENAME);

        if(file.exists()) {

            StringBuilder text = new StringBuilder();

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));

                String line = br.readLine();

                while (line != null) {
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }
            textBaca.setText(text.toString());
        }
    }

    void hapusFile() {
        File file = new File(Environment.getExternalStorageDirectory(), FILENAME);
        if (file.exists()) {
            file.delete();
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonBuatFile:
            case R.id.buttonBacaFile:
            case R.id.buttonUbahFile:
            case R.id.buttonHapusFile:
                if (periksaIzinPenyimpanan()) {
                    selectEvent = v.getId();
                    jalankanPerintah(v.getId());
                }
                break;
        }
    }

    public void jalankanPerintah(int id) {
        switch (id) {
            case R.id.buttonBuatFile:
                buatFile();
                break;
            case R.id.buttonBacaFile:
                bacaFile();
                break;
            case R.id.buttonUbahFile:
                ubahFile();
                break;
            case R.id.buttonHapusFile:
                hapusFile();
                break;
        }
    }
}




