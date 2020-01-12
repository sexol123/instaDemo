package kh.sergeimaleev.helper

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class ConvertersTest {

    private lateinit var listString: List<String>

    @Before
    fun setUp() {
        listString = listOf("Sergei", "Ivan", "Julia")
    }

    @Test
    fun toFormattedString() {
        assertEquals("should be formatted date string", "Sat, 11 Jan 2020 18:49:33",Converters.toFormattedString(1578761373000))
    }

    @Test
    fun toClearString() {
        assertEquals("","Sergei Ivan Julia", Converters.toClearString(listString))
    }
}