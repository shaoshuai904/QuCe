package com.maple.quce.renye;

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

        onView(withText("人业简介")).check(matches(isDisplayed()));
        onView(withId(R.id.tv_start_test)).perform(click());

        sleep(1000);

        onView(withText("第1题")).check(matches(isDisplayed()));
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

        sleep(3000);

//        onView(withId(R.id.bt_next)).perform(click());

        // onView(withText("人业简介")).check(doesNotExist());

        //onView(withText("OK")).check(matches(isDisplayed()));


    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}