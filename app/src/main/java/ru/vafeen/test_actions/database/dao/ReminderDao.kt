package ru.vafeen.test_actions.database.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.vafeen.test_actions.database.dao.parent.DataAccessObject
import ru.vafeen.test_actions.database.dao.parent.implementation.FlowGetAllImplementation
import ru.vafeen.test_actions.database.entity.Reminder

@Dao
interface ReminderDao : DataAccessObject<Reminder>, FlowGetAllImplementation<Reminder> {
    @Query("select * from reminder")
    override fun getAllAsFlow(): Flow<List<Reminder>>

    @Query("select * from reminder where idOfReminder=:idOfReminder limit 1")
    fun getReminderByIdOfReminder(idOfReminder: Int): Reminder?
}