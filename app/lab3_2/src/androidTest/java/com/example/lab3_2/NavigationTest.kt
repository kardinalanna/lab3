package com.example.lab3_2

import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {

   @get:Rule
   val rule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun testAbout() {
        openAbout()
        onView(withId(R.id.activity_about))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkFragment1() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).check(matches(isDisplayed()))

        onView(withId(R.id.fragment2)).check(doesNotExist())
        onView(withId(R.id.fragment3)).check(doesNotExist())
        onView(withId(R.id.bnToFirst)).check(doesNotExist())
        onView(withId(R.id.bnToThird)).check(doesNotExist())
    }

    @Test
    fun checkFragment2(){
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).check(matches(isDisplayed()))

        onView(withId(R.id.fragment1)).check(doesNotExist())
        onView(withId(R.id.fragment3)).check(doesNotExist())
        onView(withId(R.id.bnToSecond)).check(doesNotExist())
    }

    @Test
    fun checkFragment3(){
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).check(matches(isDisplayed()))

        onView(withId(R.id.fragment1)).check(doesNotExist())
        onView(withId(R.id.fragment2)).check(doesNotExist())
        onView(withId(R.id.bnToThird)).check(doesNotExist())
    }

    @Test
    fun checkActivityAbout(){
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.tvAbout)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))

        onView(withId(R.id.bnToSecond)).perform(click())
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.tvAbout)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))

        onView(withId(R.id.bnToThird)).perform(click())
        openAbout()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.tvAbout)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
    }

    @Test
    fun testNavigation1(){
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
    }

    @Test
    fun testNavigation2(){
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun testNavigation3(){
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }

    @Test
    fun testBackFromFirst(){
        pressBackUnconditionally()
        assertTrue(rule.scenario.state.isAtLeast(Lifecycle.State.DESTROYED))
    }

    @Test
    fun testBackFromSecond() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        pressBackUnconditionally()
        assertTrue(rule.scenario.state.isAtLeast(Lifecycle.State.DESTROYED))
    }

    @Test
    fun testBackFromThird() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        pressBackUnconditionally()
        assertTrue(rule.scenario.state.isAtLeast(Lifecycle.State.DESTROYED))
    }

    @Test
    fun testBackFromThird1() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())
        pressBack()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))

        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))

        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.bnToFirst)).perform(click())
        pressBackUnconditionally()
        assertTrue(rule.scenario.state.isAtLeast(Lifecycle.State.DESTROYED))
    }

   @Test
    fun testRotates1(){
        rule.scenario.onActivity { activity ->
            activity.requestedOrientation = SCREEN_ORIENTATION_LANDSCAPE }
       onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
       onView(withId(R.id.bnToSecond)).check(matches(isDisplayed()))

       rule.scenario.onActivity { activity ->
           activity.requestedOrientation = SCREEN_ORIENTATION_PORTRAIT }
       onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
       onView(withId(R.id.bnToSecond)).check(matches(isDisplayed()))
    }

    @Test
    fun testRotates2() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        rule.scenario.onActivity { activity ->
            activity.requestedOrientation = SCREEN_ORIENTATION_LANDSCAPE }
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).check(matches(isDisplayed()))

        rule.scenario.onActivity { activity ->
            activity.requestedOrientation = SCREEN_ORIENTATION_PORTRAIT }
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).check(matches(isDisplayed()))
    }

    @Test
    fun testRotates3() {
        onView(withId(R.id.bnToSecond)).perform(click())
        onView(withId(R.id.bnToThird)).perform(click())
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        rule.scenario.onActivity { activity ->
            activity.requestedOrientation = SCREEN_ORIENTATION_LANDSCAPE }
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).check(matches(isDisplayed()))

        rule.scenario.onActivity { activity ->
            activity.requestedOrientation = SCREEN_ORIENTATION_PORTRAIT }
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).check(matches(isDisplayed()))
    }

    @Test
    fun testRotatesAbout() {
        openAbout()
        rule.scenario.onActivity { activity ->
            activity.requestedOrientation = SCREEN_ORIENTATION_LANDSCAPE
        }
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.tvAbout)).check(matches(isDisplayed()))

        rule.scenario.onActivity { activity ->
            activity.requestedOrientation = SCREEN_ORIENTATION_PORTRAIT
        }
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        onView(withId(R.id.tvAbout)).check(matches(isDisplayed()))

    }
}