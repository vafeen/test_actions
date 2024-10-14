package ru.vafeen.test_actions.application_main

import android.app.Application
import android.app.NotificationManager
import android.content.SharedPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.vafeen.test_actions.noui.di.koinDIModule
import ru.vafeen.test_actions.noui.di.koinDatabaseDIModule
import ru.vafeen.test_actions.noui.di.koinNetworkDIModule
import ru.vafeen.test_actions.noui.di.koinViewModelDIModule
import ru.vafeen.test_actions.noui.notifications.NotificationChannelInfo
import ru.vafeen.test_actions.noui.notifications.createNotificationChannelKClass
import ru.vafeen.test_actions.utils.cleverUpdatingLessons
import ru.vafeen.test_actions.utils.createGSheetsService
import ru.vafeen.test_actions.utils.getLessonsListFromGSheetsTable
import ru.vafeen.test_actions.utils.getSettingsOrCreateIfNull


class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                koinDatabaseDIModule,
                koinNetworkDIModule,
                koinDIModule,
                koinViewModelDIModule,
            )
        }

        val notificationManager =
            applicationContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.createNotificationChannel(
            NotificationChannelInfo.About15MinutesBeforeLesson.createNotificationChannelKClass()
        )
        notificationManager.createNotificationChannel(
            NotificationChannelInfo.AfterStartingLesson.createNotificationChannelKClass()
        )
        notificationManager.createNotificationChannel(
            NotificationChannelInfo.ReminderRecovery.createNotificationChannelKClass()
        )

        val sharedPreferences: SharedPreferences by inject()
        val settings = sharedPreferences.getSettingsOrCreateIfNull()
        CoroutineScope(Dispatchers.IO).launch(Dispatchers.IO) {
            settings.link?.let { link ->
                try {
                    createGSheetsService(link = link)
                        ?.getLessonsListFromGSheetsTable()
                        ?.let {
                            cleverUpdatingLessons(newLessons = it)
                        }
                } catch (e: Exception) {
                }
            }
        }
    }
}
