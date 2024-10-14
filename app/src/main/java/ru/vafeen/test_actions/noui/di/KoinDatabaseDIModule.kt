package ru.vafeen.test_actions.noui.di


import androidx.room.Room
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.vafeen.test_actions.database.AppDatabase
import ru.vafeen.test_actions.database.DBInfo
import ru.vafeen.test_actions.database.DatabaseRepository


val koinDatabaseDIModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            context = get(), klass = AppDatabase::class.java, name = DBInfo.NAME
        ).addMigrations(
            AppDatabase.MIGRATION_1_2,
            AppDatabase.MIGRATION_2_3,
            AppDatabase.MIGRATION_3_4,
            AppDatabase.MIGRATION_4_5,
        ).build()
    }
    singleOf(::DatabaseRepository)
}