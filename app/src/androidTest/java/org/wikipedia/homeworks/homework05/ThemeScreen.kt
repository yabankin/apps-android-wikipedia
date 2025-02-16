package org.wikipedia.homeworks.homework05

import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

val themeCategory = KTextView{
    withId(R.id.textSettingsCategory)
    withText(R.string.theme_category_reading)
}

val textSize = KTextView{
    withId(R.id.text_size_percent)
}

val buttonDecreaseTextSize = KTextView{
    withId(R.id.buttonDecreaseTextSize)
}

val buttonIncreaseTextSize = KTextView{
    withId(R.id.buttonIncreaseTextSize)
}

val textSizeSeekBar = KSeekBar{
    withId(R.id.text_size_seek_bar)
}

val buttonFontFamilySans = KButton{
    withId(R.id.button_font_family_sans_serif)
}

val buttonFontFamilySerif = KButton{
    withId(R.id.button_font_family_serif)
}

val readingFocusModeImage = KImageView{
    withParent { isInstanceOf(AppCompatImageView::class.java) }
    withSibling { withId(R.id.theme_chooser_reading_focus_mode_switch) }
}

val themeChooserReadingFocusModeSwitch = KSwitch{
    withId(R.id.theme_chooser_reading_focus_mode_switch)
    withText(R.string.reading_focus_mode)
}

val themeChooserReadingFocusModeDescription = KTextView{
    withId(R.id.theme_chooser_reading_focus_mode_description)
    withText(R.id.theme_chooser_reading_focus_mode_description)
}

val themeChooseTextBanner = KTextView{
    withParent { isInstanceOf(MaterialTextView::class.java) }
    withText(R.string.color_theme_select)
}

val buttonThemeLight = KButton{
    withId(R.id.button_theme_light)
}

val buttonThemeSepia = KButton{
    withId(R.id.button_theme_sepia)
}

val buttonThemeDark = KButton{
    withId(R.id.button_theme_dark)
}

val buttonThemeBlack = KButton{
    withId(R.id.button_theme_black)
}

val themeChooserMatchSystemThemeSwitch = KSwitch{
    withId(R.id.theme_chooser_match_system_theme_switch)
    withText(R.string.theme_chooser_dialog_match_system_theme_switch_label)
}

val themeChooserDarkModeImagesSwitch = KSwitch{
    withId(R.id.theme_chooser_dark_mode_dim_images_switch)
    withText(R.string.theme_chooser_dialog_image_dimming_switch_label)
}