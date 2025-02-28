package com.example.habitant.habits

data class HabitRequest(
    val name: String,
    val description: String,
    val status: HabitStatus
)