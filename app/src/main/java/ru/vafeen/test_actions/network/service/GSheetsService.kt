package ru.vafeen.test_actions.network.service

import okhttp3.ResponseBody
import retrofit2.http.GET
import ru.vafeen.test_actions.network.end_points.GSServiceLink

/**
 * Service for getting data from Google sheets
 */
interface GSheetsService {
    @GET(GSServiceLink.EndPoint.JSON)
    suspend fun getSheetData(): ResponseBody

}