package com.example.habitant.habits

import com.example.habitant.user.User
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/habits")
class HabitController(private val habitService: HabitService) {

    @PostMapping
    fun createHabit(
        @RequestBody request: HabitRequest,
        @AuthenticationPrincipal user: User  // Get logged-in user
    ): Habit {
        val habit = Habit(
            name = request.name,
            description = request.description,
            status = request.status,
            user = user
        )
        return habitService.createHabit(habit)
    }

    @GetMapping
    fun getUserHabits(@AuthenticationPrincipal user: User?): List<Habit> {
        println("Inside getUserHabits function") // Debugging line
        val authentication = SecurityContextHolder.getContext().authentication

        if (authentication == null) {
            println("❌ Authentication is NULL")
            throw IllegalStateException("User is not authenticated")
        }

        println("✅ Authenticated User: ${authentication.name}")

        return habitService.getUserHabits(user?.id ?: throw IllegalStateException("User is null"))
    }
}