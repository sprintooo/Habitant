package com.example.habitant.user

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService,
    private val authenticationManager: AuthenticationManager
) {
    @PostMapping("/register")
    fun register(@RequestBody request: Map<String, String>): User {
        val username = request["username"] ?: throw IllegalArgumentException("Username is required")
        val password = request["password"] ?: throw IllegalArgumentException("Password is required")
        return userService.registerUser(username, password)
    }

    @PostMapping("/login")
    fun login(@RequestBody request: Map<String, String>): String {
        val username = request["username"] ?: throw IllegalArgumentException("Username is required")
        val password = request["password"] ?: throw IllegalArgumentException("Password is required")

        return userService.loginUser(username, password)
    }

}