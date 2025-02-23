package org.wikipedia.homeworks.homework08

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class ExploreTestScreen : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun SkipButtonTest() {
        run {
            step("Кнопка Skip отображается") {
                OnboardingScreen.skipButton.isDisplayed()
            }
        }
    }

    @Test
    fun wikiLogoTest() {
        val pages = 3
        run {
            var currentPage = 0
            repeat(pages) {
                step("Лого отображется") {
                    OnboardingScreen.slider.childAt<OnboardingPagerItem>(currentPage) {
                        wikiLogo.isDisplayed()
                    }
                }
                step("Следующая страница") {
                    OnboardingScreen.forwardButton.click()
                }
                currentPage++
            }
        }
    }


    @Test
    fun addLanguageTest() {
        run {
            step("Кнопка добавить язык отображается") {
                OnboardingScreen.slider.childAt<OnboardingPagerItem>(0) {
                    addLanguageButton.isDisplayed()
                }
            }
        }
    }


    @Test
    fun addLanguageTest1() {
        run {
            step("Кнопка добавить язык нажимается") {
                OnboardingScreen.slider.childAt<OnboardingPagerItem>(0) {
                    addLanguageButton.isClickable()
                }
            }
        }
    }
}