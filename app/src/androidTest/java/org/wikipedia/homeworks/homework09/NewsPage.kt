package org.wikipedia.homeworks.homework09

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import org.wikipedia.R

object NewsPage: KScreen<NewsPage>() {
    override val layoutId = null
    override val viewClass = null

    val newsPageWebView = KView {
        withId(R.id.page_web_view)
    }
}