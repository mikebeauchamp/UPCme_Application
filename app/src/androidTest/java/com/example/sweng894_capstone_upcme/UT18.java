package com.example.sweng894_capstone_upcme;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

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
/**
 * Used to validate that the online sellers’ names are displayed in the Other Online Sellers
 * ListView control in the UI.
 */
public class UT18
{
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.CAMERA");

    @Test
    public void ut18() throws InterruptedException
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
        nameTextView.check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

        mActivityScenarioRule.getScenario().onActivity(activity ->
        {
            activity.runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    //Mimic application functionality when a 12 digit barcode is scanned
                    //that is not contained in the Barcode Lookup API
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



        Thread.sleep(2000);
        onView(withId(R.id.scroll_view)).perform(ViewActions.swipeUp());
        Thread.sleep(2000);

        ViewInteraction nameTextView2 = onView(
                Matchers.allOf(
                        getElementFromMatchAtPosition(Matchers.allOf(withId(R.id.tv_NameTextView)), 0),
                        isDisplayed()));
        nameTextView2.check(doesNotExist());
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
}
