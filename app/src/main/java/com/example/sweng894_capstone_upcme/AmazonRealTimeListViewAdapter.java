package com.example.sweng894_capstone_upcme;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sweng894_capstone_upcme.AmazonRealTimeRapidAPIModel.Review;
import com.example.sweng894_capstone_upcme.BarcodeLookupAPIModel.OnlineStore;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AmazonRealTimeListViewAdapter extends ArrayAdapter<Review>
{
    public AmazonRealTimeListViewAdapter(@NonNull Context context, ArrayList<Review> arrayList)
    {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.review_listview, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        Review currentNumberPosition = getItem(position);

        TextView reviewTextView = currentItemView.findViewById(R.id.tv_CommentTextView);
        reviewTextView.setText(Html.fromHtml("<b>Review</b>: " + currentNumberPosition.getReviewComment()));
        TextView starRatingTextView = currentItemView.findViewById(R.id.tv_StarRatingTextView);
        starRatingTextView.setText(Html.fromHtml("<b>Rating:</b> " + currentNumberPosition.getReviewStarRating() + " out of 5."));
        TextView authorTextView = currentItemView.findViewById(R.id.tv_AuthorTextView);
        authorTextView.setText(Html.fromHtml("<b>Author:</b> " + currentNumberPosition.getReviewAuthor()));
        TextView reviewDateTextView = currentItemView.findViewById(R.id.tv_ReviewDateTextView);
        reviewDateTextView.setText(Html.fromHtml("<b>Review Date:</b> " + currentNumberPosition.getReviewDate()));

        return currentItemView;
    }
}
