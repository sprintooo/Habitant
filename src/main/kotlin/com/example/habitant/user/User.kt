package com.example.habitant.user

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val username: String,
    val password: String,

    @Enumerated(EnumType.STRING)
    val role: Role = Role.USER // Default role
)
