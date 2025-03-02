package org.wikipedia.homeworks.homework09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.InTheNewsCardItem
import org.wikipedia.homeworks.homework07.NewsCardViewItem
import org.wikipedia.homeworks.homework08.OnboardingScreen

class TestInTheNews : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun NewsTest() {
        run {
            step("Скипаем онбординг") {
                OnboardingScreen.skipButton.click()
            }
            step("Проверяем есть ли у нас блок 'In the news'") {
                ExploreScreen.items.childWith<NewsCardViewItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }.perform {
                    newsCardText.hasAnyText()
                }
            }
            step("Листаем до третьей картинки и кликаем по ней") {
                ExploreScreen.items.childWith<InTheNewsCardItem> {
                    withDescendant {
                        withText("In the news")
                    }
                }.perform {
                    newsCardReaderItem.childAt<NewsCardViewItem>(2) {
                        newsCardImage.click()
                    }
                }
            }
            step("Кликаем по второй статье из списка") {
                FragmentContainerNews.newsStoryItemsRecycler.childAt<NewsCards>(1) {
                    newsCardItemImage.click()
                }
            }
            step ("Проверяем, что отображается элемент с ID page_web_view") {
                NewsPage.newsPageWebView.isDisplayed()
            }

        }
    }
}









