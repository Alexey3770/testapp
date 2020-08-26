package com.example.testapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.microsoft.appcenter.espresso.Factory
import com.microsoft.appcenter.espresso.ReportHelper
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListScreenTest {

    @get:Rule
    val reportHelper: ReportHelper = Factory.getReportHelper()
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun userCanRemoveSelectedItems() {
        onView(withId(R.id.homeBtnListScreen))
            .perform(click())

        onView(allOf(withId(R.id.itemListText), withText("App")))
            .check(matches(isDisplayed()))
            .perform(click())
        onView(allOf(withId(R.id.itemListText), withText("First")))
            .check(matches(isDisplayed()))
            .perform(click())
        onView(allOf(withId(R.id.itemListText), withText("Test")))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.listBtnRemoveItem))
            .perform(click())

        onView(allOf(withId(R.id.itemListText), withText("Test")))
            .check(doesNotExist())
        onView(allOf(withId(R.id.itemListText), withText("App")))
            .check(doesNotExist())
        onView(allOf(withId(R.id.itemListText), withText("First")))
            .check(doesNotExist())
    }

    @Test
    fun userCanRemoveOneItem() {
        onView(withId(R.id.homeBtnListScreen))
            .perform(click())

        onView(allOf(withId(R.id.itemListText), withText("App")))
            .check(matches(isDisplayed()))
        onView(allOf(withId(R.id.itemListText), withText("First")))
            .check(matches(isDisplayed()))
        onView(allOf(withId(R.id.itemListText), withText("Test")))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.listBtnRemoveItem))
            .perform(click())

        onView(allOf(withId(R.id.itemListText), withText("Test")))
            .check(doesNotExist())
        onView(allOf(withId(R.id.itemListText), withText("App")))
            .check(matches(isDisplayed()))
        onView(allOf(withId(R.id.itemListText), withText("First")))
            .check(matches(isDisplayed()))
    }
}