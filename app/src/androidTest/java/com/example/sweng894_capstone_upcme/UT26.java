package com.example.sweng894_capstone_upcme;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.GrantPermissionRule;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class UT26
{
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.CAMERA");

    @Test
    public void ut23() throws InterruptedException
    {
        mActivityScenarioRule.getScenario().onActivity(activity ->
        {
            activity.runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    //Mimic application functionality when a 12 digit barcode is scanned
                    //that is not contained in the Barcode Lookup API which will not return Amazon ASIN
                    //which will not return an Amazon Rating. When a barcode is not found, the UI will clear.
                    //This following test below is to ensure that control has been cleared.

                    if (activity.isUpcABarcode("044670012826"))
                    {
                        activity.callBarcodeLookupAPI("044670012826");
                    }
                    else
                    {

                    }
                }
            });
        });

        Thread.sleep(3000);

        ViewInteraction materialButton = onView(
                allOf(withId(android.R.id.button2), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                2)));
        materialButton.perform(scrollTo(), click());

        Thread.sleep(3000);

        onView(withId(R.id.lv_AmazonReviewsListView)).check(matches(not(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))));

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

        onView(withId(R.id.lv_AmazonReviewsListView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        Thread.sleep(2000);

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
