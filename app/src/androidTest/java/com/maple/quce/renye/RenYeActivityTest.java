package com.maple.quce.renye;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.maple.quce.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by maple on 17/3/6.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class RenYeActivityTest {

    @Rule
    public ActivityTestRule<RenYeActivity> activityTestRule = new ActivityTestRule<>(RenYeActivity.class);

    @Before
    public void init() {
    }

    @Test
    public void verifyTest() {
        // onView(ViewMatchers.withId(R.id.edt_username)).perform(typeText("ming1"), closeSoftKeyboard());
        // onView(withId(R.id.tv_title)).perform(replaceText("Mmmmmmm9"));
//         onView(withId(R.id.rg_select)).perform(isNotChecked());

        onView(withText("人业简介")).check(matches(isDisplayed()));
        onView(withId(R.id.tv_start_test)).perform(click());

        onView(withText("第1题")).check(matches(isDisplayed()));
        onView(withId(R.id.bt_next)).check(matches(withText("第1题")));
        onView(withText("YES")).perform(click());
        onView(allOf(withId(R.id.bt_next), withText("下一题"))).perform(click());

        onView(withText("第2题")).check(matches(isDisplayed()));
        onView(withText("YES")).perform(click());
        onView(withId(R.id.bt_next)).perform(click());

        onView(withText("第3题")).check(matches(isDisplayed()));
        onView(withText("NO")).perform(click());
        onView(withId(R.id.bt_next)).perform(click());

        onView(withText("第4题")).check(matches(isDisplayed()));
        onView(withText("YES")).perform(click());
        onView(withId(R.id.bt_next)).perform(click());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.bt_next)).perform(click());

        // onView(withText("人业简介")).check(doesNotExist());

        //onView(withText("OK")).check(matches(isDisplayed()));


    }

    @Test
    public void validateIntentSentToPackage() {
        // Build a result to return when a particular activity is launched.
        Intent resultData = new Intent();
        String phoneNumber = "123-345-6789";
        resultData.putExtra("phone", phoneNumber);
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);

        // Set up result stubbing when an intent sent to "contacts" is seen.
        // intending(toPackage("com.android.contacts")).respondWith(result);

        // User action that results in "contacts" activity being launched.
        // Launching activity expects phoneNumber to be returned and displays it on the screen.
        // onView(withId(R.id.pickButton)).perform(click());

        // Assert that data we set up above is shown.
        // onView(withId(R.id.phoneNumber).check(matches(withText(phoneNumber)));
    }
}