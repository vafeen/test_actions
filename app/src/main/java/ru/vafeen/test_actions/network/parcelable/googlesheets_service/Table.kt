package ru.vafeen.test_actions.network.parcelable.googlesheets_service

import com.google.gson.annotations.SerializedName

data class Table(
    @SerializedName("cols") val cols: List<Column>,
    @SerializedName("rows") val rows: List<Row>,
    @SerializedName("parsedNumHeaders") val parsedNumHeaders: Int
) {
    override fun toString(): String = rows.toString()
}