package org.wikipedia.homeworks.homework03

import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import org.wikipedia.views.AppTextView

val mainImage = listOf(
    AppCompatImageView::class.java,
    "imageViewCentered"
)

val primaryText = listOf(
    AppTextView::class.java,
    "primaryTextView"
)

val secondaryText = listOf(
    AppTextView::class.java,
    "secondaryTextView"
)

val languagesList = listOf(
    RecyclerView::class.java,
    "languagesList",
    listOf(
        AppTextView::class.java,
        "option_label"
    ),
    listOf(
        AppTextView::class.java,
        "option_label"
    )
)

val addOrEditLanguages = listOf(
    MaterialButton::class.java,
    "addLanguageButton",
    "onboarding_multilingual_add_language_text"
)

val skipButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_skip_button",
    "onboarding_skip"
)

val pageIndicator = listOf(
    TabLayout::class.java,
    "view_onboarding_page_indicator"
)

val continueButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_forward_button",
    "onboarding_continue"
)

// -------------------Нажимаем Continue-----------------------------------

val mainImage2Page = listOf(
    AppCompatImageView::class.java,
    "imageViewCentered"
)

val primaryText2Page = listOf(
    AppTextView::class.java,
    "primaryTextView"
)

val secondaryText2Page = listOf(
    AppTextView::class.java,
    "secondaryTextView"
)
