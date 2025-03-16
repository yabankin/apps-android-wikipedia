package org.wikipedia.homeworks.homework13

import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.AutoScrollParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.TopReadCardViewItem
import org.wikipedia.homeworks.homework07.CardViewItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class WebViewTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.simple {
        autoScrollParams = AutoScrollParams(allowedExceptions = emptySet())
    }
) {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun topReadTest() {
        run {
            step("Скипаем анбординг") {
                OnboardingScreen.skipButton.click()
            }
            step("Переход в произвольную статью") {
                ExploreScreen.items.childWith<TopReadCardViewItem> {
                    withDescendant {
                        withText("Top read")
                    }
                }.perform {
                    wikiCardViewItems.childAt<CardViewItem>(1) {
                        cardItemTitle.click()
                    }
                }
            }
            step("Проскроллить до элемента с id References, Проверяем текст в элементе с id References") {
                ArticleViewScreen {
                    webView {
                        withElement(Locator.ID, "References") {
                            scroll()
                            hasText("References")
                        }
                    }
                }
            }

            step(
                "Написать xpath до пятой ссылки в тексте, Нажать на этот элемент"
            ) {
                ArticleViewScreen {
                    webView {
                        withElement(
                            Locator.XPATH,
                            "//a[@class='reference-link' and .//text()='5']"
                        ) {
                            scroll()
                            click()
                        }
                    }
                }
            }
            step("Во всплывающем окне (вторая картинка) проверить на соответствие текст заголовка и номер в строке (5.)") {
                PopUpWindowViewScreen.pager.childAt<PopUpItems>(0) {
                    referenceId.isVisible()
                    referenceId.containsText("5")
                }
            }
            step("Кнопкой back закрыть всплывающее окно") {
                device.uiDevice.pressBack()
            }
            step("Найти вторую ссылку с CSS классом mw-redirect и нажать на неё") {
                ArticleViewScreen {
                    webView {
                        withElement(
                            Locator.CSS_SELECTOR, "a.mw-redirect:nth-child(4)"
                        ) {
                            scroll()
                            click()
                        }
                    }
                }
            }
            step("Перейти по этой кнопке в новую статью") {
                flakySafely(timeoutMs = 10000) {
                    Preview.readArticleButton.click()
                }
            }
            step(" Проскроллить до элемента с id References") {
                ArticleViewScreen {
                    webView {
                        withElement(Locator.ID, "References") {
                            scroll()
                            hasText("References")
                        }
                    }
                }
            }
        }
    }
}