package com.example.habitant.habits

import org.springframework.stereotype.Service

@Service
class HabitService(private val habitRepository: HabitRepository) {

    fun createHabit(habit: Habit): Habit {
        return habitRepository.save(habit)
    }

    fun getUserHabits(userName: String): List<Habit> {
        return habitRepository.findByUserName(userName)
    }
}