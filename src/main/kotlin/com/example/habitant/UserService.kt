package com.example.habitant

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository
) {
    fun registerUser(username: String, password: String): User {
        val user = User(username = username, password = password)
        return userRepository.save(user)
    }

    fun loginUser(username: String, password: String): User? {
        return userRepository.findAll().find { it.username == username && it.password == password }
    }

    fun getUsers() : List<User> {
        return userRepository.findAll().toList();
    }
}