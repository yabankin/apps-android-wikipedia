package org.wikipedia.homeworks.homework10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class OnboardingUiScreenTest : TestCase() {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkImage() {
        run {
            OnboardingUIScreen.image.isDisplayed()
        }
    }

    @Test
    fun checkTitle() {
        run {
            OnboardingUIScreen.primaryTitle.isDisplayed()
        }
    }
    @Test
    fun checkDescription() {
        run {
            OnboardingUIScreen.secondaryTitle.isDisplayed()
        }
    }
    @Test
    fun nextPage() {
        run {
            OnboardingUIScreen.viewPager.swipeLeft()
        }
    }

}