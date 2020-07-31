package ru.temp.getid

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.Assert
import ru.temp.getid.rest.IdController

@SpringBootTest
class GetIdApplicationTests {

    @Autowired
    lateinit var idController : IdController

    @Test
    fun contextLoads() {
        assertNotNull(idController)
    }

}
