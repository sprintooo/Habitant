package com.example.habitant.habits

import com.example.habitant.user.User
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User  // Associate habit with a specific user
)


