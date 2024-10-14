package ru.vafeen.test_actions.network.parcelable.googlesheets_service

import com.google.gson.annotations.SerializedName

data class Column(
    @SerializedName("id") val id: String,
    @SerializedName("label") val label: String,
    @SerializedName("type") val type: String?
) {
    override fun toString(): String {
        return "|id=$id, label=$label, type=$type|"
    }
}