
package com.kotlinbasics

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kotlinbasics.ui.theme.KotlinBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            KotlinBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        // 내가 작성한 실습 코드
        week03Variables()
        week03Functions()
        week04Classes()
        week04Collections()

        // GitHub 수업 코드 (필요할 때 주석 해제)
        // teacherWeek03Variables()
        // teacherWeek03Functions()
        // teacherWeek04Classes()
        // teacherWeek04Collections()
    }
}

// ====================================
// 내가 작성한 코드
// ====================================

private fun week03Functions() {

    fun greet(name: String) = "Hello $name"

    println(greet("Kim"))

    fun printItem(vararg item: String) {
        for (value in item) println(value)
    }

    val items = arrayOf("a", "b", "c")
    printItem(*items)

    fun printAll(vip: Boolean, name: String) {
        print("$vip, $name")
    }

    printAll(false, "Kim")
    printAll(name = "An", vip = true)
    println()
}

private fun week03Variables() {
    Log.d("week03", "==week03==")

    val userName = "AAAA"
    // userName = "BBB"

    var value = "AAA"
    value = "bbb"

    var nickName: String? = null
    nickName = "Kim"

    println("nickName : $nickName / ${nickName?.length}")
}

private fun week04Classes() {
    Log.d("kotlinWeek04", "===week04===")

    class Person(val name: String, var age: Int) {

        fun introduce() {
            Log.d("week04", "name : $name, age : $age")
        }

        fun nextYear() {
            age++
            Log.d("week04", "next age : $age")
        }
    }

    val person1 = Person("홍길동", 23)
    person1.introduce()
    person1.nextYear()

    class Animal(var species: String) {
        var weight = 0.0

        constructor(species: String, weight: Double) : this(species) {
            this.weight = weight
            Log.d("week04", "$species 의 무게 : $weight")
        }

        fun sound() {
            Log.d("week04", "$species 가 소리를 냅니다.")
        }
    }

    val dog1 = Animal("푸들")
    val dog2 = Animal("마티즈", 4.2)

    dog1.sound()
    dog2.sound()
}

private fun week04Collections() {
    println("=====week04=====")

    val char_list = listOf("arona", "plana", "kei")
    val mutable_char = mutableListOf("noa", "yuuka")

    mutable_char.add("koyuki")

    val dict = mapOf("a" to 100, "b" to 90, "c" to 80)

    println("ch : $char_list")
    println("ch : $mutable_char")
    println("score : $dict")

    for (ch in char_list) {
        println("i like $ch")
    }

    dict.forEach { (name, score) ->
        println("$name : $score")
    }

    mutable_char.forEach { name ->
        println("i love $name")
    }
}

// ====================================
// GitHub에서 가져온 수업 코드
// 함수 이름을 변경하여 충돌 방지
// ====================================

private fun teacherWeek03Variables() {
    println("Week 03 : Variables")

    val courseName = "Mobile Programming"
    // courseName = "DataStructure"

    var week = 2
    week = 3

    println("Course : $courseName")
    println("Week : $week")

    println("========= Kotlin Variables =========")

    val name = "Android"
    var version = 8

    println("Hi $name $version")

    val age: Int = 24
    val height: Double = 177.7
    val isStudent: Boolean = false

    println("Age: $age, Height: $height, Student: $isStudent")

    var nickname: String? = null
    nickname = "mirae"

    println("Nickname: $nickname ${nickname?.length}")
}

private fun teacherWeek03Functions() {
    println("========= Kotlin Functions =========")

    fun printAll(vip: Boolean, name: String) {
        println("$vip, $name")
    }

    fun printMany(vararg msg: String) {
        for (m in msg) println(m)
    }

    printAll(true, "dy")
    printAll(name = "mirae", vip = true)

    printMany("A", "B", "C", "D")
}

private fun teacherWeek04Classes() {
    Log.d("KotlinWeek04", "== Kotlin Classes ==")

    class Person(val name: String, var age: Int) {
        fun introduce() {
            Log.d("KotlinWeek04", "안녕하세요, $name ($age 세)입니다.")
        }

        fun birthday() {
            age++
            Log.d("KotlinWeek04", "$name 의 생일! 이제 $age 세...")
        }
    }

    val person1 = Person("홍길동", 27)
    person1.introduce()
    person1.birthday()

    class Animal(var species: String) {
        var weight: Double = 0.0

        constructor(species: String, weight: Double) : this(species) {
            this.weight = weight
            Log.d("KotlinWeek04", "$species 의 무게 : $weight kg")
        }

        fun makeSound() {
            Log.d("KotlinWeek04", "$species 가 소리를 냅니다.")
        }
    }

    val puppy = Animal("웰시코기", 10.5)
    val puppy2 = Animal("골든리트리버")

    puppy.makeSound()
    puppy2.makeSound()
}

private fun teacherWeek04Collections() {
    println("========= Kotlin Collections =========")

    val fruits = listOf("apple", "banana", "orange")
    val mutableFruits = mutableListOf("kiwi", "watermelon")

    // fruits.add("kiwi")
    mutableFruits.add("banana")

    println("Fruits: $fruits")
    println("Mutable Fruits: $mutableFruits")

    val scores = mapOf(
        "Kim" to 100,
        "Park" to 96,
        "Lee" to 97
    )

    println("Scores: $scores")

    for (fruit in mutableFruits) {
        println("I like $fruit")
    }

    scores.forEach { (name, score) ->
        println("$name scored $score")
    }

    fruits.forEach { fruit ->
        println(fruit)
    }
}

// ====================================
// Compose UI
// ====================================

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinBasicsTheme {
        Greeting("Android")
    }
}
