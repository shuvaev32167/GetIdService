package ru.temp.getid.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Контролер получения ID
 *
 * @property environment Environment окружение
 * @property currentId Long текущее значение id
 */
@RestController
class IdController(@Autowired val environment: Environment) {
    @Volatile
    var currentId = environment.getProperty("startValue", Long::class.java) ?: 1

    @GetMapping("/getId")
    fun getId(): Id {
        synchronized(this) {
            val id = Id(currentId)
            currentId += 1000;
            return id
        }
    }
}

data class Id(val id: Long)