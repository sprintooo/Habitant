package com.example.habitant.user

import jakarta.transaction.Transactional
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository,
    private val authenticationManager: AuthenticationManager,
    private val passwordEncoder: PasswordEncoder
){
    fun registerUser(username: String, password: String): User {
        val hashedPassword = passwordEncoder.encode(password)
        val user = User(username = username, password = hashedPassword, role = Role.USER)
        return userRepository.save(user)
    }

    fun loginUser(username: String, password: String): String {
        //val user = userRepository.findByUsername(username) ?: return null
        //return if (password == user.password) user else null

        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(username, password)
        )
        return if (authentication.isAuthenticated) "Login successful $username $password" else "Invalid credentials"
    }
}

@Service
class CustomUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("User not found")

        return org.springframework.security.core.userdetails.User
            .withUsername(user.username)
            .password(user.password)
            .roles(user.role.name)
            .build()
    }
}