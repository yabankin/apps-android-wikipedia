package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import java.io.PrintStream


enum class Color {
    RED,
    BLUE,
    GREEN,
    YELLOW,
    BLACK,
    WHITE
}

data class Shape(val sideLength: Float, val sides: Int, val color: Color)

// Проверка длины стороны в диапазоне
class SideLengthMatcher(private val min: Float, private val max: Float) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("side length between $min and $max")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sideLength in min..max
    }
}

// Проверка количества углов
class AnglesMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("допустимое количество углов")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return when {
            shape.sides >= 3 -> true // 3 стороны и больше
            shape.sides <= 2 -> shape.sides == 0 // меньше 3
            else -> false
        }
    }
}

// Проверка четного количества сторон
class EvenSidesMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("четное количество сторон")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sides % 2 == 0
    }
}

// Проверка цвета
class ColorMatcher(private val expectedColor: Color) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("цвет должен быть $expectedColor")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.color == expectedColor
    }
}

// Проверка на отрицательную длину стороны
class NonNegativeSideLengthMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("корректная длина")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sideLength >= 0
    }
}

// Проверка на отрицательное количество сторон
class NonNegativeSidesMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("корректное число сторон")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sides >= 0
    }
}

val shapes = listOf(
    Shape(10f, 3, Color.RED), Shape(5f, 4, Color.BLUE), Shape(7f, 2, Color.GREEN),
    Shape(0.5f, 1, Color.YELLOW), Shape(-3f, 5, Color.BLACK), Shape(8f, -2, Color.WHITE),
    Shape(12f, 6, Color.RED), Shape(15f, 8, Color.BLUE), Shape(20f, 4, Color.GREEN),
    Shape(9f, 5, Color.YELLOW), Shape(2f, 3, Color.BLACK), Shape(11f, 7, Color.WHITE),
    Shape(6f, 10, Color.RED), Shape(3f, 2, Color.BLUE), Shape(4f, 1, Color.GREEN),
    Shape(25f, 12, Color.YELLOW), Shape(30f, 14, Color.BLACK), Shape(35f, 16, Color.WHITE),
    Shape(40f, 18, Color.RED), Shape(50f, 20, Color.BLUE)
)

fun main() {
    System.setOut(PrintStream(System.out, true, "UTF-8"))
    println("Изначальное количество фигур: ${shapes.size}")

    val validShapes = shapes.filter { it.sideLength >= 0 && it.sides >= 0 }
    println("Количество фигур после фильтрации отрицательных значений: ${validShapes.size}")

    validShapes.forEach { shape ->
        assertThat(shape, allOf(
            SideLengthMatcher(0.1f, 100f),
            NonNegativeSideLengthMatcher(),
            NonNegativeSidesMatcher()
        ))
    }

    validShapes.filter { it.sides % 2 == 0 }.forEach { shape ->
        assertThat(shape, EvenSidesMatcher())
    }

    assertThat(validShapes[0], anyOf(
        ColorMatcher(Color.RED),
        ColorMatcher(Color.BLUE)
    ))

    println("Отфильтрованные фигуры:")
    validShapes.forEach { shape ->
        println(shape)
    }
}
