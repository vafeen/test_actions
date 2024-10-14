package ru.vafeen.test_actions.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import ru.vafeen.test_actions.database.entity.Lesson
import ru.vafeen.test_actions.network.service.GSheetsService

fun openLink(context: Context, link: String) {
    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
}

suspend fun GSheetsService.getLessonsListFromGSheetsTable(): List<Lesson> =
//   get data as non-parcelable string
    getSheetData().string()
//     get data as Json
        .dataToJsonString()
//     get data as class of Google Sheets from Json
        .getResponseFromJson()
//     get lessons list from class Google Sheets
        .toLessonsList()

