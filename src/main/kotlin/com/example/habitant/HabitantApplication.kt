package com.example.habitant

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import javax.sql.DataSource

@SpringBootApplication
class HabitantApplication

fun main(args: Array<String>) {
	runApplication<HabitantApplication>(*args)
}
