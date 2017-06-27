package hwp.basketball.mobility.login


import android.support.test.espresso.ViewInteraction
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.test.suitebuilder.annotation.LargeTest
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import hwp.basketball.mobility.R

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.scrollTo
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withContentDescription
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf

@android.test.suitebuilder.annotation.SmallTest
@RunWith(AndroidJUnit4::class)
class DrawingTest {

    @Rule
    var mActivityTestRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun drawingTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(60000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        pressBack()

        val appCompatButton = onView(
                allOf(withId(R.id.btn_skip_to_draw), withText("Skip To Draw")))
        appCompatButton.perform(scrollTo(), click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3590788)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        val actionMenuItemView = onView(
                allOf(withId(R.id.menu_start_scan), withContentDescription("Start Scan"), isDisplayed()))
        actionMenuItemView.perform(click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(10000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        val relativeLayout = onView(
                allOf(childAtPosition(
                        withId(R.id.nodeListView),
                        0),
                        isDisplayed()))
        relativeLayout.perform(click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3589733)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        val actionMenuItemView2 = onView(
                allOf(withId(R.id.menu_startResumeMovement), withContentDescription("Start Movement Tracking"), isDisplayed()))
        actionMenuItemView2.perform(click())

        val actionMenuItemView3 = onView(
                allOf(withId(R.id.menu_stopMovement), withContentDescription("Pause Movement Tracking"), isDisplayed()))
        actionMenuItemView3.perform(click())

    }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
