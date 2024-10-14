package ru.vafeen.test_actions.utils

import ru.vafeen.test_actions.noui.lesson_additions.Frequency
import ru.vafeen.test_actions.ui.components.Settings

fun Frequency.changeFrequencyIfDefinedInSettings(settings: Settings): Frequency {
    return if (settings.isSelectedFrequencyCorrespondsToTheWeekNumbers != false)
        this
    else this.getOpposite()
}