package com.tc.mvpvmdemo.login

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.test.suitebuilder.annotation.LargeTest
import android.view.View
import android.view.ViewGroup

import com.tc.mvpvmdemo.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Test
import org.junit.runner.RunWith

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.closeSoftKeyboard
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import org.junit.Rule

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    public var mActivityTestRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun loginActivityTest() {
        val appCompatAutoCompleteTextView = onView(
                allOf(withId(R.id.et_email), isDisplayed()))
        appCompatAutoCompleteTextView.perform(click())

        val appCompatAutoCompleteTextView2 = onView(
                allOf(withId(R.id.et_email), isDisplayed()))
        appCompatAutoCompleteTextView2.perform(replaceText("t4@gmail.com"), closeSoftKeyboard())

        val appCompatEditText = onView(
                allOf(withId(R.id.et_password), isDisplayed()))
        appCompatEditText.perform(replaceText("password"), closeSoftKeyboard())

        val appCompatButton = onView(
                allOf(withId(R.id.submit_button), withText("sign in"), isDisplayed()))
        appCompatButton.perform(click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        val linearLayout = onView(
                allOf(childAtPosition(allOf(withId(R.id.activity_user_info), childAtPosition(
                        withId(android.R.id.content),
                        0)),
                        0),
                        isDisplayed()))
        linearLayout.check(matches(isDisplayed()))

        pressBack()

        val textView = onView(
                allOf(withText("登录"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                0),
                        isDisplayed()))
        textView.check(matches(withText("登录")))
    }

    companion object {

        fun childAtPosition(
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
}
