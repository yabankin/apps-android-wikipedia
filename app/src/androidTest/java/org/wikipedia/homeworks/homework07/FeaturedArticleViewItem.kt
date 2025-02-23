package org.wikipedia.homeworks.homework07

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class FeaturedArticleCardViewItem(matcher: Matcher<View>) :
    KRecyclerItem<FeaturedArticleCardViewItem>(matcher) {
    val headerTitle = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }
    val langCode = KTextView(matcher) {
        withId(R.id.langCodeText)
    }
    val headerMenu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }
    val articleImage = KImageView(matcher) {
        withId(R.id.articleImage)
    }
    val articleTitle = KTextView(matcher) {
        withId(R.id.articleTitle)
    }
    val articleDescription = KTextView(matcher) {
        withId(R.id.articleDescription)
    }
    val articleDivider = KImageView(matcher) {
        withId(R.id.articleDivider)
    }
    val articleExtract = KTextView(matcher) {
        withId(R.id.articleExtract)
    }
    val footerButton = KTextView(matcher) {
        withId(R.id.footerActionButton)
    }

}