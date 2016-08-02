package com.arao.footballmatches.presentation.view.activity;


import android.support.test.espresso.NoMatchingViewException;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import com.arao.footballmatches.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class ClickOnArsenalMatchTest {

    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void clickOnArsenalMatchTest() {
        boolean successfullyClicked = tryToPerformClickOnViewWithText(R.id.team1_name, "Manchester United");
        if (!successfullyClicked) {
            successfullyClicked = tryToPerformClickOnViewWithText(R.id.team2_name, "Manchester United");
            if (!successfullyClicked) {
                successfullyClicked = tryToPerformClickOnViewWithText(R.id.team1_name, "Arsenal");
                if (!successfullyClicked) {
                    successfullyClicked = tryToPerformClickOnViewWithText(R.id.team2_name, "Arsenal");
                }
            }
        }

        if (successfullyClicked) {
            onView(allOf(instanceOf(TextView.class), withParent(withId(R.id.inner_toolbar))));
        } else {
            fail();
        }
    }

    private boolean tryToPerformClickOnViewWithText(int id, String text) {
        try {
            onView(allOf(withId(id), withText(text), isDisplayed())).perform(click());
            return true;
        } catch (NoMatchingViewException exception) {
            return false;
        }
    }

}
