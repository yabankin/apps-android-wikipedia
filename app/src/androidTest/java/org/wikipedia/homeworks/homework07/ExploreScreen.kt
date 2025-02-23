package org.wikipedia.homeworks.homework07

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView

object ExploreScreen : KScreen<ExploreScreen>() {
    override val layoutId = R.layout.fragment_feed
    override val viewClass = FeedView::class.java

    val toolbarTitle = KImageView{
        withId(R.id.main_toolbar_wordmark)
    }

    val items = KRecyclerView(
        builder = {
            withId(R.id.feed_view)
        },
        itemTypeBuilder = {
            itemType (::AnnouncementCardViewItem)
            itemType (::CardViewItem)
            itemType (::DateViewItem)
            itemType (::FeaturedArticleCardViewItem)
            itemType (::NewsCardViewItem)
            itemType (::SearchCardViewItem)
            itemType (::TopReadCardViewItem)

        }
    )
}
