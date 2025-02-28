package com.example.habitant

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HabitantApplication

fun main(args: Array<String>) {
	runApplication<HabitantApplication>(*args)
}
