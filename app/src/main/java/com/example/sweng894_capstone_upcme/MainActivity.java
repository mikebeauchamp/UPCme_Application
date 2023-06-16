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
import android.widget.ImageView;
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
import com.example.sweng894_capstone_upcme.Model.Product;
import com.example.sweng894_capstone_upcme.Model.ProductList;
import com.google.zxing.Result;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity
{

    private static final int REQUEST_CAMERA_CODE = 201;
    private static final String REQUEST_CAMERA_PERMISSION = Manifest.permission.CAMERA;
    private CodeScanner codeScanner;

    public static final String BASE_URL = "https://api.barcodelookup.com/";

    BarcodeAPIInterface apiInterface;

    //private BarcodeAPIModel barcodeAPIModel;

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
                        if (isUpcABarcode(result.getText()))
                        {
                            TextView textView = findViewById(R.id.tv_textview);
                            textView.setText(result.getText());

                            callBarcodeAPI(result.getText());
                        }
                        else
                        {
                            //Show Dialog that scanned barcode is not a UPC-A Code
                            codeScanner.stopPreview();
                            displayBarcodeErrorMessage(result.getText());
                        }
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



    /**
     * This method searches the first digit of a scanned barcode. Typical UPC-A barcodes (which
     * will be scanned by this application) begin with a first digit of 0, 1, 6, 7, or 8.
     * Barcodes that have a first digit of 2, 3, 4, 5 or 9 will not be scanned by this application:
     * 2 is for random weight items, e.g. meat, marked in-store
     * 3 is for National Drug Code and National Health Related Items
     * 4 is for in-store marking of non-food items
     * 5 and 9 are for coupon use
     *
     * @param barcode String
     * @return Boolean isScannableUpcABarcode
     */
    private boolean isUpcABarcode (String barcode)
    {
        boolean isScannableUpcABarcode = false;

        if ((barcode.charAt(0) == '0' || barcode.charAt(0) == '1' || barcode.charAt(0) == '6' ||
                barcode.charAt(0) == '7' || barcode.charAt(0) == '8') && barcode.length() == 12)
        {
            isScannableUpcABarcode = true;
        }

        return isScannableUpcABarcode;
    }

    private void displayBarcodeErrorMessage(String barcode)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if (barcode.length() == 12)
        {
            if (barcode.charAt(0) == '2')
            {
                builder.setMessage("The scanned barcode cannot be processed in this application. " +
                        "UPC codes that begin with the number 2 denote random weight items, " +
                        "e.g. meat, marked in-store.");
            }
            if (barcode.charAt(0) == '3')
            {
                builder.setMessage("The scanned barcode cannot be processed in this application. " +
                        "UPC codes that begin with the number 3 denote National Drug Code and " +
                        "National Health related items.");
            }
            if (barcode.charAt(0) == '4')
            {
                builder.setMessage("The scanned barcode cannot be processed in this application. " +
                        "UPC codes that begin with the number 4 denote in-store marking of " +
                        "non-food items.");
            }
            if (barcode.charAt(0) == '5' || barcode.charAt(0) == '9')
            {
                builder.setMessage("The scanned barcode cannot be processed in this application. " +
                        "UPC codes that begin with the number 9 are are for coupon use.");
            }
        }
        else
        {
            builder.setMessage("The scanned barcode is not UPC-A barcode.");
        }

        builder.setTitle("Barcode Scanning Error")
                .setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                        codeScanner.startPreview();
                    }
                });

        builder.create().show();

        return;
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
                    builder.setMessage("The UPCme application is unavailable because it is dependent on the Camera permission you denied. " +
                                    "Please grant the Camera permission from the application''s settings.")
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
                                    System.exit(0);//
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



    private void callBarcodeAPI(String barcode)
    {
        codeScanner.stopPreview();
        apiInterface = BarcodeAPIClient.getClient().create(BarcodeAPIInterface.class);

        String formatString = "y";
        String text =  "fv0a60gml7xsttbqvkvywi3q1v2wi6";
        /**
         GET List Users
         **/
        Call<ProductList> call2 = apiInterface.doGetProductList(barcode, formatString, text);
        call2.enqueue(new Callback<ProductList>()
        {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response)
            {
                //System.out.println("TESTING" + call.request().url());
                ProductList productList = response.body();
                System.out.println(productList.getProducts().get(0).getTitle());

                TextView pttextView = findViewById(R.id.tv_ProductTitleTextView);
                pttextView.setText(productList.getProducts().get(0).getTitle());

                //System.out.println(productList.getProducts().get(0).getImages().get(0));


                ImageView imageView = (ImageView) findViewById(R.id.ProductImageView);
                Picasso.get().load(productList.getProducts().get(0).getImages().get(0)).resize(400,400).into(imageView);

                TextView pdtextView = findViewById(R.id.tv_ProductDescriptionTextView);
                pdtextView.setText(productList.getProducts().get(0).getDescription());

            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                call.cancel();
            }
        });

    }
}