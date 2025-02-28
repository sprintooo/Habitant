package com.example.habitant.habits

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HabitRepository: JpaRepository<Habit, Long> {

    fun findByUserName(userName: String): List<Habit>

}