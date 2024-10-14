package ru.vafeen.test_actions.utils

import ru.vafeen.test_actions.database.entity.Lesson
import ru.vafeen.test_actions.network.parcelable.googlesheets_service.ResponseWrapper
import ru.vafeen.test_actions.network.parcelable.googlesheets_service.Row

fun Row.toLesson(): Lesson? = this.cells.map {
    it?.value
}.let {
    try {
        Lesson(
            dayOfWeek = it[0]?.toDayOfWeek(),
            name = it[1].makeNullIfNull(),
            startTime = "${it[2]}".toTimeOfLessonAsLocalTime(),
            endTime = "${it[3]}".toTimeOfLessonAsLocalTime(),
            classroom = it[4].makeNullIfNull(),
            teacher = it[5].makeNullIfNull(),
            subGroup = it[6].makeNullIfNull()?.normalizeCase(),
            frequency = it[7].makeNullIfNull()?.toFrequency()
        )
    } catch (e: Exception) {
        null
    }
}

fun ResponseWrapper.toLessonsList(): List<Lesson> {
    val result = mutableListOf<Lesson>()
    for (row in this.table.rows) {
        row.toLesson()?.let { result.add(element = it) }
    }
    return result
}





