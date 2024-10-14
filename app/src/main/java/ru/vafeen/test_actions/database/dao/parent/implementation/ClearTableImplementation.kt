package ru.vafeen.test_actions.database.dao.parent.implementation

import androidx.room.Dao

/**
 * Interface of additions for basic [DataAccessObject][ru.vafeen.test_actions.database.dao.parent.DataAccessObject]
 *
 * Addition: clearing table
 */
@Dao
interface ClearTableImplementation {

    /**
     * Очистка таблицы
     */
    suspend fun clearTable()
}