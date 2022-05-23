package com.example.fyp_preschool;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.gcacace.signaturepad.views.SignaturePad;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import yuku.ambilwarna.AmbilWarnaDialog;

public class DrawingActivity extends AppCompatActivity {

    SignaturePad signaturePad;
    ImageButton imgEraser, imgColor, imgSave;
    TextView txtPenSize;
    SeekBar seekBar;
    int defaultColor;

    ActivityResultLauncher<Intent> mGetPermission;

    private static String fileName;
    File path = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/myPaintings");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);

        signaturePad = findViewById(R.id.signature_pad);
        seekBar = findViewById(R.id.penSize);
        txtPenSize = findViewById(R.id.txtPenSize);
        imgEraser = findViewById(R.id.btnEraser);
        imgColor = findViewById(R.id.btnColor);
        imgSave = findViewById(R.id.btnSave);
        

        mGetPermission = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getResultCode() == DrawingActivity.RESULT_OK){
                Toast.makeText(getApplicationContext(), "Permission given in Android 11.", Toast.LENGTH_SHORT).show();
            }
        });

        takePermission();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        String date = format.format(new Date());
        fileName = path + "/" + date + ".png";

        if (!path.exists()){
            path.mkdirs();
        }

        imgSave.setOnClickListener(view -> {
            if (!signaturePad.isEmpty()){
                try {
                    saveFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(DrawingActivity.this, "Couldn't Save!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        defaultColor = ContextCompat.getColor(DrawingActivity.this, R.color.black);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtPenSize.setText(i + "dp");
                signaturePad.setMinWidth(i);
                seekBar.setMax(50);
                seekBar.setMin(5);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        imgColor.setOnClickListener(view -> openColorPicker());
        imgEraser.setOnClickListener(view -> signaturePad.clear());

    }

    private void saveFile() throws IOException {
        File file = new File(fileName);
        Bitmap bitmap = signaturePad.getSignatureBitmap();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, bos);
        byte[] bitmapData = bos.toByteArray();

        FileOutputStream fos = new FileOutputStream(file);

        fos.write(bitmapData);
        fos.flush();
        fos.close();
        Toast.makeText(this, "Painting Saved.", Toast.LENGTH_SHORT).show();
    }

    private void takePermissions() {
        if(Build.VERSION.SDK_INT == Build.VERSION_CODES.R){
           try {
               Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
               intent.addCategory("android.intent.category.DEFAULT");
               intent.setData(Uri.parse(String.format("package:%s",getApplicationContext().getPackageName())));
               mGetPermission.launch(intent);
           }
           catch (Exception e){
               e.printStackTrace();
           }
        }
        else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);
        }
    }

    private boolean isPermissionGranted(){
        if(Build.VERSION.SDK_INT == Build.VERSION_CODES.R){
            return Environment.isExternalStorageManager();
        }
        else {
            int readExternalStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            return readExternalStoragePermission == PackageManager.PERMISSION_GRANTED;
        }
    }

    private void takePermission(){
        if (!isPermissionGranted()){
            takePermissions();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length>0){
            if (requestCode == 101){
                boolean readExternalStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                if (readExternalStorage){
                    Toast.makeText(getApplicationContext(), "Permission Granted!", Toast.LENGTH_SHORT).show();
                }
                else {
                    takePermission();
                }
            }
        }
    }

    private void openColorPicker() {

        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(this, defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {

                defaultColor = color;
                signaturePad.setPenColor(color);
            }
        });
        ambilWarnaDialog.show();

    }
}