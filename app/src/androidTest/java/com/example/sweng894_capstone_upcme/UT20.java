package com.example.sweng894_capstone_upcme;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.GrantPermissionRule;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class UT20
{
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.CAMERA");

    private static Matcher<View> getElementFromMatchAtPosition(final Matcher<View> matcher, final int position) {
        return new BaseMatcher<View>()
        {
            int counter = 0;
            @Override
            public boolean matches(final Object item) {
                if (matcher.matches(item)) {
                    if(counter == position) {
                        counter++;
                        return true;
                    }
                    counter++;
                }
                return false;
            }

            @Override
            public void describeTo(Description description)
            {
                description.appendText("Element at hierarchy position " + position);
            }
        };
    }

    @Test
    public void ut20() throws InterruptedException
    {
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
                        activity.callBarcodeLookupAPI("079100520008");
                    }
                    else
                    {

                    }
                }
            });
        });

        Thread.sleep(2000);
        onView(withId(R.id.scroll_view)).perform(ViewActions.swipeUp());
        Thread.sleep(2000);

        ViewInteraction nameTextView = onView(
                Matchers.allOf(
                        getElementFromMatchAtPosition(Matchers.allOf(withId(R.id.tv_NameTextView)), 0),
                        isDisplayed()));
        nameTextView.perform(ViewActions.click());
    }
}
