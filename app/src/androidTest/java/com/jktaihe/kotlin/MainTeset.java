package com.jktaihe.kotlin;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

/**
 * Created by hzjixiaohui on 2017-6-26.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainTeset {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void uiTest() {

        onView(withId(R.id.action_girl))
                .perform(click(),typeText("test"))
                .check(matches(isDisplayed()));

        onView(allOf(withId(R.id.action_girl),not(withText("test"))))
                .perform(click())
                .check(matches(isDisplayed()));



    }
}
