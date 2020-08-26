package com.example.testapp

import android.view.View.FIND_VIEWS_WITH_TEXT
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.microsoft.appcenter.espresso.Factory
import com.microsoft.appcenter.espresso.ReportHelper
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CheckboxScreenTest {

    @get:Rule
    val reportHelper: ReportHelper = Factory.getReportHelper()
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun userCanAddTestItemToListWithClickOnCheckboxes() {
        onView(withId(R.id.homeBtnCheckboxScreen))
            .perform(click())

        onView(allOf(withId(R.id.itemListText), withText("Test")))
            .check(doesNotExist())
        onView(allOf(withId(R.id.itemListText), withText("App")))
            .check(doesNotExist())

        onView(withId(R.id.checkboxTest))
            .perform(click())

        onView(allOf(withId(R.id.itemListText), withText("Test")))
            .check(matches(isDisplayed()))
        onView(allOf(withId(R.id.itemListText), withText("App")))
            .check(doesNotExist())
    }

    @Test
    fun userCanAddAppItemToListWithClickOnCheckboxes() {
        onView(withId(R.id.homeBtnCheckboxScreen))
            .perform(click())

        onView(allOf(withId(R.id.itemListText), withText("Test")))
            .check(doesNotExist())
        onView(allOf(withId(R.id.itemListText), withText("App")))
            .check(doesNotExist())

        onView(withId(R.id.checkboxApp))
            .perform(click())

        onView(allOf(withId(R.id.itemListText), withText("Test")))
            .check(doesNotExist())
        onView(allOf(withId(R.id.itemListText), withText("App")))
            .check(matches(isDisplayed()))
    }

    @Test
    fun userCanAddAppAndTestItemToListWithClickOnCheckboxes() {
        onView(withId(R.id.homeBtnCheckboxScreen))
            .perform(click())

        onView(allOf(withId(R.id.itemListText), withText("Test")))
            .check(doesNotExist())
        onView(allOf(withId(R.id.itemListText), withText("App")))
            .check(doesNotExist())

        onView(withId(R.id.checkboxApp))
            .perform(click())
        onView(withId(R.id.checkboxTest))
            .perform(click())

        onView(allOf(withId(R.id.itemListText), withText("Test")))
            .check(matches(isDisplayed()))
        onView(allOf(withId(R.id.itemListText), withText("App")))
            .check(matches(isDisplayed()))
    }

    @After
    fun tearDown() {
        reportHelper.label("Stopping App")
    }
}