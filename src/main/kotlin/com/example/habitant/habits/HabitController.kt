package com.example.habitant.habits

import com.example.habitant.user.UserRepository
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/api/habits")
class HabitController(
    private val habitService: HabitService,
    private val userRepository: UserRepository
) {
    @PostMapping
    fun createHabit(
        @RequestBody request: HabitRequest,
        principal: Principal
    ): Habit {
        val user = userRepository.findByUsername(principal.name) ?: throw UsernameNotFoundException("User not found")
        val habit = Habit(
            name = request.name,
            description = request.description,
            status = request.status,
            userName = user.username
        )
        return habitService.createHabit(habit)
    }

    @GetMapping
    fun getUserHabits(principal: Principal): List<Habit> {
        val user = userRepository.findByUsername(principal.name) ?: throw UsernameNotFoundException("User not found")
        return habitService.getUserHabits(user.username)
    }
}