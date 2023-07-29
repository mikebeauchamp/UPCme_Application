package com.example.sweng894_capstone_upcme;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
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
import com.example.sweng894_capstone_upcme.AmazonPriceRapidAPIModel.AmazonPriceResult;
import com.example.sweng894_capstone_upcme.AmazonPriceRapidAPIModel.Asin;
import com.example.sweng894_capstone_upcme.AmazonRealTimeRapidAPIModel.RealTimeRapidAPIResult;
import com.example.sweng894_capstone_upcme.AmazonRealTimeRapidAPIModel.Review;
import com.example.sweng894_capstone_upcme.BarcodeLookupAPIModel.OnlineStore;
import com.example.sweng894_capstone_upcme.BarcodeLookupAPIModel.ProductList;
import com.google.zxing.Result;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity
{

    private static final int REQUEST_CAMERA_CODE = 201;
    private static final String REQUEST_CAMERA_PERMISSION = Manifest.permission.CAMERA;
    private CodeScanner codeScanner;
    BarcodeLookupAPIInterface barcodeLookupAPIInterface;
    AmazonPriceUPCToASINInterface amazonPriceUPCToASINInterface;
    AmazonPriceSearchInterface amazonPriceSearchInterface;

    AmazonRealTimeRapidAPIInterface amazonRealTimeRapidAPIInterface;


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
                            codeScanner.stopPreview();
                            callBarcodeLookupAPI(result.getText());
                            callAmazonPriceRapidAPI(result.getText());

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
                keepScanning(view);
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
    public boolean isUpcABarcode (String barcode)
    {
        boolean isScannableUpcABarcode = false;

        if ((barcode.charAt(0) == '0' || barcode.charAt(0) == '1' || barcode.charAt(0) == '6' ||
                barcode.charAt(0) == '7' || barcode.charAt(0) == '8') && barcode.length() == 12)
        {
            isScannableUpcABarcode = true;
        }

        return isScannableUpcABarcode;
    }

    public void displayBarcodeErrorMessage(String barcode)
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
                        "UPC codes that begin with the number 5 or 9 are for coupon use.");
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
        clearUI();
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
                                    codeScanner.releaseResources();
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



    public void callBarcodeLookupAPI(String barcode)
    {

        barcodeLookupAPIInterface = BarcodeLookupAPIClient.getClient().create(BarcodeLookupAPIInterface.class);

        String formatString = "y";

        ApplicationInfo applicationInfo = null;

        String call1Key = "";

        try
        {
            applicationInfo = this.getPackageManager().getApplicationInfo(this.getPackageName(), PackageManager.GET_META_DATA);
            call1Key = applicationInfo.metaData.getString("BarcodeKey");
        }
        catch (PackageManager.NameNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        Call<ProductList> call1 = barcodeLookupAPIInterface.doGetProductList(barcode, formatString, call1Key);
        call1.enqueue(new Callback<ProductList>()
        {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response)
            {
                if (response.isSuccessful()){
                    //System.out.println("TESTING" + call.request().url());
                    ProductList productList = response.body();

                    //System.out.println(productList.getProducts().get(0).getTitle());

                    if (!TextUtils.isEmpty(productList.getProducts().get(0).getTitle()))
                    {
                        TextView ptTextView = findViewById(R.id.tv_ProductTitleTextView);
                        ptTextView.setText(productList.getProducts().get(0).getTitle());
                        ptTextView.setVisibility(View.VISIBLE);
                    }

                    if (!TextUtils.isEmpty(productList.getProducts().get(0).getImages().get(0)))
                    {
                        ImageView imageView = (ImageView) findViewById(R.id.ProductImageView);
                        Picasso.get().load(productList.getProducts().get(0).getImages().get(0)).resize(400,400).into(imageView);
                        imageView.setVisibility(View.VISIBLE);
                    }

                    if (!TextUtils.isEmpty(productList.getProducts().get(0).getDescription()))
                    {
                        TextView pdTextView = findViewById(R.id.tv_ProductDescriptionTextView);
                        pdTextView.setText(productList.getProducts().get(0).getDescription());
                        pdTextView.setVisibility(View.VISIBLE);
                    }

                    if (productList.getProducts().get(0).getStores().size() > 0)
                    {
                        NonScrollListView listView = (NonScrollListView) findViewById(R.id.lv_OtherOnlineRetailersListView);
                        TextView olretTextView = findViewById(R.id.tv_OtherOnlineRetailers);

                        ArrayList<OnlineStore> onlineStoreList = new ArrayList<OnlineStore>();

                        for (OnlineStore onlineStore : productList.getProducts().get(0).getStores())
                        {
                            //Only add online stores that are from the US and have a Last Update date that is greater than a year from today
                            if ((onlineStore.getCountry().equals("US")) && (!TextUtils.isEmpty(onlineStore.getLastUpdate())))
                            {
                                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                Date lastUpdatedDate;
                                Date yearAgoFromToday;
                                try
                                {
                                    Calendar c = Calendar.getInstance();
                                    c.add(Calendar.YEAR, -1);
                                    yearAgoFromToday = c.getTime();

                                    lastUpdatedDate = formatter.parse(onlineStore.getLastUpdate());

                                    if (lastUpdatedDate.after(yearAgoFromToday))
                                    {
                                        onlineStoreList.add(onlineStore);
                                    }
                                }
                                catch (ParseException e)
                                {
                                    throw new RuntimeException(e);
                                }
                            }
                        }

                        if (onlineStoreList.size() > 0)
                        {
                            CustomBarcodeAPIListViewAdapter customAdapter = new CustomBarcodeAPIListViewAdapter(getApplicationContext(), onlineStoreList);

                            listView.setAdapter(customAdapter);
                            olretTextView.setVisibility(View.VISIBLE);
                            olretTextView.setPaintFlags(olretTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                            listView.setVisibility(View.VISIBLE);
                        }
                    }
                }
                else
                {
                    displayResponseFailedErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t)
            {
                call.cancel();
                displayCheckInternetConnectionErrorMessage();
            }
        });
    }

    public void callAmazonPriceRapidAPI(String barcode)
    {
        amazonPriceUPCToASINInterface = AmazonPriceRapidAPIClient.getClient().create(AmazonPriceUPCToASINInterface.class);

        String host = "amazon-price1.p.rapidapi.com";

        String marketplace = "US";

        ApplicationInfo applicationInfo = null;
        String rapidKey = "";

        try
        {
            applicationInfo = this.getPackageManager().getApplicationInfo(this.getPackageName(), PackageManager.GET_META_DATA);
            rapidKey = applicationInfo.metaData.getString("RapidKey");
        }
        catch (PackageManager.NameNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        Call<Asin> call2 = amazonPriceUPCToASINInterface.getAsin(host, rapidKey, barcode, marketplace);
        call2.enqueue(new Callback<Asin>()
        {
            @Override
            public void onResponse(Call<Asin> call, Response<Asin> response)
            {
                if (response.isSuccessful())
                {
                    //System.out.println("TESTING" + call.request().url());
                    //System.out.println(response.body());
                    Asin asin = response.body();

                    callAmazonPriceSearchRapidAPI(asin.getAsin());
                    callAmazonRealTimeRapidAPI(asin.getAsin());
                }
            }

            @Override
            public void onFailure(Call<Asin> call, Throwable t)
            {
                call.cancel();
            }
        });
    }

    public void callAmazonPriceSearchRapidAPI(String asin)
    {
        amazonPriceSearchInterface = AmazonPriceRapidAPIClient.getClient().create(AmazonPriceSearchInterface.class);

        String host = "amazon-price1.p.rapidapi.com";

        String marketplace = "US";

        ApplicationInfo applicationInfo = null;
        String rapidKey = "";

        try
        {
            applicationInfo = this.getPackageManager().getApplicationInfo(this.getPackageName(), PackageManager.GET_META_DATA);
            rapidKey = applicationInfo.metaData.getString("RapidKey");
        }
        catch (PackageManager.NameNotFoundException e)
        {
            throw new RuntimeException(e);
        }



        Call<List<AmazonPriceResult>> call2 = amazonPriceSearchInterface.getAmazonPriceResult(host, rapidKey, asin, marketplace);
        call2.enqueue(new Callback<List<AmazonPriceResult>>()
        {
            @Override
            public void onResponse(Call<List<AmazonPriceResult>> call, Response<List<AmazonPriceResult>> response)
            {
                if (response.isSuccessful())
                {
                    List<AmazonPriceResult> amazonPriceResult = response.body();

                    TextView amazonLabelTextView = findViewById(R.id.tv_AmazonLabel);
                    amazonLabelTextView.setVisibility(View.VISIBLE);
                    amazonLabelTextView.setPaintFlags(amazonLabelTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

                    if (!TextUtils.isEmpty(amazonPriceResult.get(0).getRating()))
                    {
                        //The overall rating of the product, out of 5.
                        TextView arTextView = findViewById(R.id.tv_AmazonRatingTextView);
                        arTextView.setText("Amazon Rating: " + amazonPriceResult.get(0).getRating() + " out of 5 overall for " + amazonPriceResult.get(0).getTotalReviews() + " total reviews.");
                        arTextView.setVisibility(View.VISIBLE);
                    }

                    if (!TextUtils.isEmpty(amazonPriceResult.get(0).getDetailPageURL()))
                    {
                        TextView urlTextView = findViewById(R.id.tv_AmazonURLTextView);
                        urlTextView.setText(Html.fromHtml("<a href=\"" + amazonPriceResult.get(0).getDetailPageURL() + "\" target=\"_blank\">Amazon Product Page</a>"));
                        urlTextView.setMovementMethod(LinkMovementMethod.getInstance());
                        urlTextView.setVisibility(View.VISIBLE);
                    }

                    if (!TextUtils.isEmpty(amazonPriceResult.get(0).getPrice()))
                    {
                        TextView apTextView = findViewById(R.id.tv_AmazonPriceTextView);
                        apTextView.setText("Amazon Price: " + amazonPriceResult.get(0).getPrice());
                        apTextView.setVisibility(View.VISIBLE);
                    }

                    if (!TextUtils.isEmpty(amazonPriceResult.get(0).getIsPrimeEligible())) {
                        TextView apfTextView = findViewById(R.id.tv_AmazonPrimeFlagTextView);
                        if (amazonPriceResult.get(0).getIsPrimeEligible().equals("1"))
                        {
                            apfTextView.setText("This product is sold via Amazon Prime.");
                            apfTextView.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<AmazonPriceResult>> call, Throwable t)
            {
                call.cancel();
            }
        });
    }

    /**
     *
     * This method will return the top 3 Amazon reviews for a given ASIN
     * @param asin
     */
    public void callAmazonRealTimeRapidAPI(String asin)
    {
        amazonRealTimeRapidAPIInterface = AmazonRealTimeRapidAPIClient.getClient().create(AmazonRealTimeRapidAPIInterface.class);

        String host = "real-time-amazon-data.p.rapidapi.com";
        String country = "US";
        String sortBy = "TOP_REVIEWS";
        String starRating = "ALL";
        String verifiedPurchasesOnly = "true";
        String imagesOrVideosOnly = "false";
        String page = "1";
        String pageSize = "3";

        ApplicationInfo applicationInfo = null;
        String rapidKey = "";

        try
        {
            applicationInfo = this.getPackageManager().getApplicationInfo(this.getPackageName(), PackageManager.GET_META_DATA);
            rapidKey = applicationInfo.metaData.getString("RapidKey");
        }
        catch (PackageManager.NameNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        Call<RealTimeRapidAPIResult> call2 = amazonRealTimeRapidAPIInterface.getProductReviews(host, rapidKey, asin, country, sortBy, starRating, verifiedPurchasesOnly,
                imagesOrVideosOnly, page, pageSize);
        call2.enqueue(new Callback<RealTimeRapidAPIResult>()
        {
            @Override
            public void onResponse(Call<RealTimeRapidAPIResult> call, Response<RealTimeRapidAPIResult> response)
            {
                if (response.isSuccessful())
                {
                    RealTimeRapidAPIResult realTimeRapidAPIResult = response.body();

                    if (realTimeRapidAPIResult.getData().getReviews().size() > 0)
                    {
                        NonScrollListView listView = (NonScrollListView) findViewById(R.id.lv_AmazonReviewsListView);
                        TextView reviewLabelTextView = findViewById(R.id.tv_ReviewLabel);

                        ArrayList<Review> reviewList = new ArrayList<Review>();

                        for (Review review : realTimeRapidAPIResult.getData().getReviews()) {
                            reviewList.add(review);
                        }

                        if (reviewList.size() > 0) {
                            AmazonRealTimeListViewAdapter customAdapter = new AmazonRealTimeListViewAdapter(getApplicationContext(), reviewList);

                            listView.setAdapter(customAdapter);
                            listView.setVisibility(View.VISIBLE);
                            reviewLabelTextView.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<RealTimeRapidAPIResult> call, Throwable t)
            {
                call.cancel();
            }
        });
    }

    public void displayCheckInternetConnectionErrorMessage()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please check your wi-fi/internet connection in order to retrieve product data.")
                .setTitle("Internet Required")
                .setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                });

        builder.create().show();
    }

    public void displayResponseFailedErrorMessage()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Barcode not found.")
                .setTitle("Barcode Scanning Error")
                .setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                        clearUI();
                        codeScanner.startPreview();
                    }
                });

        builder.create().show();
    }

    public void keepScanning(View view)
    {
        clearUI();
        codeScanner.startPreview();
    }

    private void clearUI()
    {
        TextView ptTextView = findViewById(R.id.tv_ProductTitleTextView);
        ptTextView.setText("");

        TextView pdTextView = findViewById(R.id.tv_ProductDescriptionTextView);
        pdTextView.setText("");

        ImageView imageView = (ImageView) findViewById(R.id.ProductImageView);
        imageView.setImageDrawable(null);

        TextView amazonLabelTextView = findViewById(R.id.tv_AmazonLabel);
        amazonLabelTextView.setVisibility(View.INVISIBLE);

        TextView reviewLabelTextView = findViewById(R.id.tv_ReviewLabel);
        reviewLabelTextView.setVisibility(View.INVISIBLE);

        TextView urlTextView = findViewById(R.id.tv_AmazonURLTextView);
        urlTextView.setText("");

        TextView arTextView = findViewById(R.id.tv_AmazonRatingTextView);
        arTextView.setText("");

        NonScrollListView reviewListView = (NonScrollListView) findViewById(R.id.lv_AmazonReviewsListView);
        reviewListView.setAdapter(null);

        TextView apTextView = findViewById(R.id.tv_AmazonPriceTextView);
        apTextView.setText("");

        TextView apfTextView = findViewById(R.id.tv_AmazonPrimeFlagTextView);
        apfTextView.setText("");

        TextView olretTextView = findViewById(R.id.tv_OtherOnlineRetailers);
        olretTextView.setVisibility(View.INVISIBLE);

        NonScrollListView listView = (NonScrollListView) findViewById(R.id.lv_OtherOnlineRetailersListView);
        listView.setAdapter(null);
    }
}