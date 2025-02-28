package com.example.habitant.habits

import jakarta.persistence.*

@Entity
@Table(name = "habits")
data class Habit(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val description: String,

    @Enumerated(EnumType.STRING)
    val status: HabitStatus,
    val userName: String  // Associate habit with a specific user
)


