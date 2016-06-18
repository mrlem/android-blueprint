package org.mrlem.blueprint.ui;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mrlem.blueprint.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainActivityInstrumentationTest {


    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void captionChanges() {
        // initial text
        onView(withId(R.id.text)).check(matches(withText(R.string.main_text)));

        // text after click on the button
        onView(withText(R.string.main_button)).perform(click());
        onView(withId(R.id.text)).check(matches(withText(R.string.main_text_done)));
    }

}
