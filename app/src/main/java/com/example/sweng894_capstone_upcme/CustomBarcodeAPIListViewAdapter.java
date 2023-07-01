package com.example.sweng894_capstone_upcme;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sweng894_capstone_upcme.Model.OnlineStore;

import java.util.ArrayList;
import java.util.List;

public class CustomBarcodeAPIListViewAdapter extends ArrayAdapter<OnlineStore>
{
    public CustomBarcodeAPIListViewAdapter(@NonNull Context context, ArrayList<OnlineStore> arrayList)
    {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_listview, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        OnlineStore currentNumberPosition = getItem(position);

        TextView nameTextView = currentItemView.findViewById(R.id.tv_NameTextView);
        nameTextView.setText(Html.fromHtml("<a href=\"" + currentNumberPosition.getLink() + "\">" + currentNumberPosition.getName() + "</a>"));
        nameTextView.setMovementMethod(LinkMovementMethod.getInstance());
        //System.out.println ("<a href=\"" + currentNumberPosition.getLink() + "\">" + currentNumberPosition.getName() + "</a>");

        TextView priceTextView = currentItemView.findViewById(R.id.tv_PriceTextView);

        //Show sale price instead of regular price if sale price exists
        if (TextUtils.isEmpty(currentNumberPosition.getSalePrice()))
        {
            priceTextView.setText(currentNumberPosition.getCurrencySymbol() + currentNumberPosition.getPrice());
        }
        else
        {
            if (Float.parseFloat(currentNumberPosition.getSalePrice()) < Float.parseFloat(currentNumberPosition.getPrice()))
            {
                priceTextView.setText(currentNumberPosition.getCurrencySymbol() + currentNumberPosition.getSalePrice());
            }
            else
            {
                priceTextView.setText(currentNumberPosition.getCurrencySymbol() + currentNumberPosition.getPrice());
            }
        }

        TextView lastUpdateTextView = currentItemView.findViewById(R.id.tv_LastUpdateTextView);
        lastUpdateTextView.setText(currentNumberPosition.getLastUpdate());

        return currentItemView;
    }
}
