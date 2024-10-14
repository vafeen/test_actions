package ru.vafeen.test_actions.database.converters

import androidx.room.TypeConverter
import java.time.LocalTime

class LessonTypeConverters {
    @TypeConverter
    fun localTimeToInt(value: LocalTime?): Int? {
        return value?.toSecondOfDay()
    }

    @TypeConverter
    fun intToLocalTime(secondsOfDay: Int?): LocalTime? {
        return secondsOfDay?.let { LocalTime.ofSecondOfDay(it.toLong()) }
    }
}