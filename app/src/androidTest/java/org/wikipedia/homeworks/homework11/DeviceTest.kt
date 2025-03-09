package org.wikipedia.homeworks.homework11

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.InTheNewsCardItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity
import java.util.Locale


class DeviceTest : TestCase() {

    @get: Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun DeviceTest() =

    before {

    }.after {
        device.network.toggleWiFi(true)
        device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
        device.language.switchInApp(Locale.ENGLISH)
    }.run {
        step("поворот экрана и проверка ориентации") {
            device.exploit.setOrientation(Exploit.DeviceOrientation.Landscape)
            if (!device.uiDevice.isNaturalOrientation) {
                device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
            }
        }
        step("выключение экрана, включение и проверка отображения элемента") {
            device.uiDevice.sleep()
            Thread.sleep(3000)
            device.uiDevice.wakeUp()
            OnboardingScreen.pageIndicator.isDisplayed()
            OnboardingScreen.skipButton.click()
        }
        step(
            "свернуть приложение кнопкой home и развернуть дважды нажав recent apps и проверить отображение элемента"
        ) {
            device.uiDevice.pressHome()
            device.uiDevice.pressRecentApps()
            device.uiDevice.waitForIdle()
            Thread.sleep(3000)
            device.uiDevice.pressRecentApps()
            ExploreScreen.toolbarTitle.isDisplayed()
        }
        step("проверить, что сейчас активна MainActivity") {
            device.activities.isCurrent(MainActivity::class.java)
        }

    }
}