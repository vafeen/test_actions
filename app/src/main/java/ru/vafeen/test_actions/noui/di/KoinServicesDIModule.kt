package ru.vafeen.test_actions.noui.di

import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.vafeen.test_actions.database.DTConverters
import ru.vafeen.test_actions.noui.notifications.NotificationService
import ru.vafeen.test_actions.noui.planner.Scheduler
import ru.vafeen.test_actions.noui.shared_preferences.SharedPreferencesValue

val koinDIModule = module {
    singleOf(::NotificationService)
    singleOf(::Scheduler)
    singleOf(::DTConverters)
    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            SharedPreferencesValue.Name.key, Context.MODE_PRIVATE
        )
    }
}