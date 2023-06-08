package com.example.sweng894_capstone_upcme;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.budiyev.android.codescanner.AutoFocusMode;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.budiyev.android.codescanner.ErrorCallback;
import com.budiyev.android.codescanner.ScanMode;
import com.google.zxing.Result;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CAMERA_CODE = 201;
    private static final String REQUEST_CAMERA_PERMISSION = Manifest.permission.CAMERA;
    private CodeScanner codeScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setupPermissions();
        setContentView(R.layout.activity_main);
        CodeScanner();
    }

    private void CodeScanner()
    {
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        codeScanner = new CodeScanner(this, scannerView);

        codeScanner.setCamera(CodeScanner.CAMERA_BACK);
        codeScanner.setFormats(CodeScanner.ALL_FORMATS);

        codeScanner.setAutoFocusMode(AutoFocusMode.SAFE);
        codeScanner.setScanMode(ScanMode.CONTINUOUS);
        codeScanner.setAutoFocusEnabled(true);
        codeScanner.setFlashEnabled(false);

        codeScanner.setDecodeCallback(new DecodeCallback()
        {
            @Override
            public void onDecoded(@NonNull final Result result)
            {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        TextView textView = findViewById(R.id.tv_textview);
                        //add UPC logic here
                        textView.setText(result.getText());
                    }
                });
            }
        });

        codeScanner.setErrorCallback(new ErrorCallback()
        {
            @Override
            public void onError(@NonNull Throwable thrown)
            {
                Log.e("Main" ,"Camera Initialization Error: " + thrown.getMessage());
            }
        });

        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                codeScanner.startPreview();
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        codeScanner.startPreview();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        codeScanner.releaseResources();
    }


    private void setupPermissions()
    {
        //Check if camera permissions have already been granted
        if(ContextCompat.checkSelfPermission(this, REQUEST_CAMERA_PERMISSION) != PackageManager.PERMISSION_GRANTED)
        {
            makeRequest();
        }
    }

    private void makeRequest(){
        ActivityCompat.requestPermissions(this, new String[]{REQUEST_CAMERA_PERMISSION}, REQUEST_CAMERA_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CAMERA_CODE)
        {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED)
            {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, REQUEST_CAMERA_PERMISSION))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("The UPCme application is unavailable because it is dependent on the Camera permission you denied. Please allow the Camera permission " +
                                    "from the application''s settings.")
                            .setTitle("Camera Permission Required")
                            .setCancelable(false)
                            .setNegativeButton("Close App", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                    dialog.dismiss();
                                    finish();
                                    finishAffinity();
                                    System.exit(0);

//                                    android.os.Process.killProcess(android.os.Process.myPid());
//                                    System.exit(1);
                                }
                            })
                            .setPositiveButton("Settings", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                                    intent.setData(uri);
                                    startActivity(intent);

                                    dialog.dismiss();
                                }
                            });

                    builder.create().show();

                    return;
                }

                makeRequest();

            }
        }
    }
}