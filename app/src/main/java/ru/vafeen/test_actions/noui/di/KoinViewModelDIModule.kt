package ru.vafeen.test_actions.noui.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.vafeen.test_actions.ui.components.viewModels.MainActivityViewModel
import ru.vafeen.test_actions.ui.components.viewModels.MainScreenViewModel
import ru.vafeen.test_actions.ui.components.viewModels.SettingsScreenViewModel

val koinViewModelDIModule = module {
    viewModelOf(::MainActivityViewModel)
    viewModelOf(::MainScreenViewModel)
    viewModelOf(::SettingsScreenViewModel)
}