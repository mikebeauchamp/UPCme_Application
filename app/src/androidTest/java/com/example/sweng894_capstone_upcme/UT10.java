package com.example.sweng894_capstone_upcme;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.GrantPermissionRule;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class UT10 {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.CAMERA");

    @Test
    public void ut10() throws InterruptedException {
        mActivityScenarioRule.getScenario().onActivity(activity ->
        {
            activity.runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    //Mimic application functionality when a 12 digit barcode is scanned with a first digit that begins with a 4
                    if (activity.isUpcABarcode("401234567893"))
                    {

                    }
                    else
                    {
                        activity.displayBarcodeErrorMessage("401234567893");
                    }
                }
            });
        });

        Thread.sleep(1000);

        ViewInteraction textView = onView(
                allOf(withId(android.R.id.message), withText("The scanned barcode cannot be processed in this application. " +
                                "UPC codes that begin with the number 4 denote in-store marking of non-food items."),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class))),
                        isDisplayed()));
        textView.inRoot(isDialog()).check(matches(isDisplayed()));
    }
}
