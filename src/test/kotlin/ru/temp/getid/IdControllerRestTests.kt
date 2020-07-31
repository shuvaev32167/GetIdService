package ru.temp.getid

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import ru.temp.getid.rest.Id


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, args = ["--startValue=3"])
class IdControllerRestTests {
    @LocalServerPort
    private val port = 0

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @Test
    fun testGetId() {
        assertThat(this.restTemplate?.getForObject("http://localhost:$port/getId", Id::class.java)).isEqualTo(Id(3))
        assertThat(this.restTemplate?.getForObject("http://localhost:$port/getId", Id::class.java)).isEqualTo(Id(1_003))
        assertThat(this.restTemplate?.getForObject("http://localhost:$port/getId", Id::class.java)).isEqualTo(Id(2_003))
        assertThat(this.restTemplate?.getForObject("http://localhost:$port/getId", String::class.java)).isEqualTo("{\"id\":3003}")
    }
}

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IdControllerRestWithOutArgsTests {
    @LocalServerPort
    private val port = 0

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @Test
    fun testGetId() {
        assertThat(this.restTemplate?.getForObject("http://localhost:$port/getId", Id::class.java)).isEqualTo(Id(1))
        assertThat(this.restTemplate?.getForObject("http://localhost:$port/getId", Id::class.java)).isEqualTo(Id(1_001))
        assertThat(this.restTemplate?.getForObject("http://localhost:$port/getId", Id::class.java)).isEqualTo(Id(2_001))
        assertThat(this.restTemplate?.getForObject("http://localhost:$port/getId", String::class.java)).isEqualTo("{\"id\":3001}")
    }
}
