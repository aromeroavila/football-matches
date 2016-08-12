package com.arao.footballmatches.presentation.view.activity;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arao.footballmatches.R;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class ClickOnArsenalMatchTest {

    private static final int TEAM_1_SCORE_TEXT_VIEW_CHILD_NUMBER_IN_GROUP = 2;
    private static final int TEAM_2_SCORE_TEXT_VIEW_CHILD_NUMBER_IN_GROUP = 4;

    @Rule public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void shouldHaveSameScoreOnDetailScreenToolbar_whenClickingOnMatchItem() {
        String score = getScoreForMatchWithTeam(R.id.team1_name, "Manchester United");
        if (score == null) {
            score = getScoreForMatchWithTeam(R.id.team2_name, "Manchester United");
            if (score == null) {
                score = getScoreForMatchWithTeam(R.id.team1_name, "Arsenal");
                if (score == null) {
                    score = getScoreForMatchWithTeam(R.id.team2_name, "Arsenal");
                }
            }
        }

        if (score != null) {
            String scoreInToolbar = getTextFromViewWithMatcher(
                    allOf(instanceOf(TextView.class), withId(R.id.collapsed_title)));
            assertEquals(score, scoreInToolbar);
        } else {
            fail();
        }
    }

    private String getScoreForMatchWithTeam(int id, String text) {
        try {
            Matcher<View> viewMatcher = allOf(withId(id), withText(text), isDisplayed());
            String score = getScoreForMatchWithTeamMatcher(viewMatcher);
            onView(viewMatcher).perform(click());
            return score;
        } catch (NoMatchingViewException exception) {
            return null;
        }
    }

    private String getScoreForMatchWithTeamMatcher(final Matcher<View> matcher) {
        final StringBuilder stringBuilder = new StringBuilder();

        onView(matcher).perform(new ViewAction() {

            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                if (view.getParent() instanceof ViewGroup) {
                    ViewGroup parent = (ViewGroup) view.getParent();

                    TextView team1ScoreTextView = (TextView) parent.getChildAt(TEAM_1_SCORE_TEXT_VIEW_CHILD_NUMBER_IN_GROUP);
                    String team1Score = team1ScoreTextView.getText().toString();
                    TextView team2ScoreTextView = (TextView) parent.getChildAt(TEAM_2_SCORE_TEXT_VIEW_CHILD_NUMBER_IN_GROUP);
                    String team2Score = team2ScoreTextView.getText().toString();

                    stringBuilder.append(team1Score);
                    stringBuilder.append(" - ");
                    stringBuilder.append(team2Score);
                }
            }
        });
        return stringBuilder.toString();
    }

    private String getTextFromViewWithMatcher(final Matcher<View> matcher) {
        final StringBuilder stringBuilder = new StringBuilder();

        onView(matcher).perform(new ViewAction() {

            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView) view;
                stringBuilder.append(tv.getText().toString());
            }
        });
        return stringBuilder.toString();
    }

}
