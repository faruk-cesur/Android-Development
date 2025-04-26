package com.farukcesur.kotlindersleri.odevler

fun main() {
    println("1) Degrees as Fahrenheit: ${convertDegreesToFahrenheit(10.0)}")
    println("2) Rectangle Perimeter: ${calculateRectanglePerimeter(5.0, 8.0)}")
    println("3) Factorial Value: ${calculateFactorialValue(5)}")
    println("4) Repeated Letter Count: ${countRepeatedLettersInWord("I am Doing My Bootcamp Homework.", 'o')}")
    println("5) Total Interior Angle: ${sumOfInteriorAngles(3)}")
    println("6) Calculated Salary: ${calculateSalary(30)}")
    println("7) Calculated Quota Price: ${calculateInternetQuota(70)}")
}

fun convertDegreesToFahrenheit(celsius: Double): Double {
    val fahrenheit = celsius * 1.8 + 32
    return fahrenheit
}

fun calculateRectanglePerimeter(shortEdge: Double, longEdge: Double): Double {
    val rectanglePerimeter = 2 * (shortEdge + longEdge)
    return rectanglePerimeter
}

fun calculateFactorialValue(number: Int): Int {
    var factorialValue = 1

    for (i in 1..number) {
        factorialValue *= i
    }

    return factorialValue
}

fun countRepeatedLettersInWord(word: String, letterToCount: Char): Int {
    var totalRepeatedLetter = 0

    for (i in word) {
        if (letterToCount == i) {
            totalRepeatedLetter++
        }
    }

    return totalRepeatedLetter
}

fun sumOfInteriorAngles(numberOfEdges: Int): Int {
    val interiorAngles = (numberOfEdges - 2) * 180
    return interiorAngles
}

fun calculateSalary(workingDay: Int): Int {
    val oneHourPrice = 10
    val overTimeOneHourPrice = 20
    val totalWorkHours = workingDay * 8
    var totalSalary = 0

    if (totalWorkHours > 160) {
        val normalHours = 160
        val overTimeHours = totalWorkHours - 160
        totalSalary = (normalHours * oneHourPrice) + (overTimeHours * overTimeOneHourPrice)
    } else {
        totalSalary = totalWorkHours * oneHourPrice
    }

    return totalSalary
}

fun calculateInternetQuota(usedQuota: Int): Int {
    var totalPrice = 0
    val constantPrice = 100
    val startingQuota = 50
    val overUsingPrice = 4

    if (usedQuota <= 50) {
        totalPrice = constantPrice
    } else {
        totalPrice = constantPrice + (overUsingPrice * (usedQuota - startingQuota))
    }

    return totalPrice
}