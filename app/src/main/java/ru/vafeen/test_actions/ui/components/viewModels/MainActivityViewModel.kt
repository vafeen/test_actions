package ru.vafeen.test_actions.ui.components.viewModels

import androidx.lifecycle.ViewModel
import ru.vafeen.test_actions.network.repository.NetworkRepository


class MainActivityViewModel(
    val networkRepository: NetworkRepository,
) : ViewModel() {
    var updateIsShowed = false
}