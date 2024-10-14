package ru.vafeen.test_actions.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.vafeen.test_actions.database.ReminderType
import ru.vafeen.test_actions.noui.duration.RepeatDuration
import java.time.LocalDateTime

@Entity
data class Reminder(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val idOfReminder: Int,
    val title: String,
    val text: String,
    val dt: LocalDateTime,
    val duration: RepeatDuration = RepeatDuration.EVERY_WEEK,
    val type: ReminderType = ReminderType.AFTER_BEGINNING_LESSON,
) {
}