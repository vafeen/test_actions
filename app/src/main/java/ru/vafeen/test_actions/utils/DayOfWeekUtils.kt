package ru.vafeen.test_actions.utils

import java.time.DayOfWeek


fun DayOfWeek.ruDayOfWeek(ruDaysOfWeek: List<String>): String = ruDaysOfWeek[this.value - 1]
