package com.example.sweng894_capstone_upcme;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;

import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
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
/**
 * Used to validate the functionality of the Amazon Product webpage hyperlink control is both clickable
 * and navigates the end user to the Amazon product page when clicked.
 */
public class UT22
{
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.CAMERA");

    @Test
    public void ut23() throws InterruptedException {
        mActivityScenarioRule.getScenario().onActivity(activity ->
        {
            activity.runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    //Mimic application functionality when a 12 digit barcode is scanned
                    if (activity.isUpcABarcode("079100520008"))
                    {
                        activity.callAmazonPriceRapidAPI("079100520008");
                    }
                    else
                    {

                    }
                }
            });
        });

        Thread.sleep(5000);

        ViewInteraction amazonURLTextView = onView(
                allOf(withId(R.id.tv_AmazonURLTextView),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class))),
                        isDisplayed()));

        amazonURLTextView.perform(ViewActions.click());
    }
}
