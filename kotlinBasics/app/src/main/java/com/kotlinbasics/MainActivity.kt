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
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        week03Variables()
        week03Functions()
        week04Classes()
        week04Collections()
    }
}

private fun week03Functions() {

    fun greet(name: String) = "Hello $name"

    println(greet("Kim"))

    fun printItem(vararg item: String) {
        for (value in item) println("$value")
    }

    val printItem = arrayOf("a", "b", "c")

    fun printAll(vip: Boolean, name: String) {
        print("$vip, $name")
    }
    printAll(false, "Kim")
    //printAll("Kil", vip)
    printAll(name="An", vip=true)
    println("");
}

private fun week03Variables() {
    Log.d("week03", "==week03==")
    val userName = "AAAA"
    //userName = "BBB"
    var value = "AAA"
    value = "bbb"

    //var nickName: String = null
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
            age++;
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
        fun sound(){
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

    dict.forEach{ (name, score) ->
    println("$name : $score")}

    mutable_char.forEach{ name ->
        println("i love $name")
    }
}

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