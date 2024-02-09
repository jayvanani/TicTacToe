package com.example.tictactoegame

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    lateinit var zero: Button
    lateinit var one: Button
    lateinit var two: Button
    lateinit var three: Button
    lateinit var four: Button
    lateinit var five: Button
    lateinit var six: Button
    lateinit var seven: Button
    lateinit var eight: Button
    lateinit var restart: Button

    var value = 1
    var arraylist = ArrayList<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        zero = findViewById(R.id.zero)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        restart = findViewById(R.id.restart)

        arraylist.add(0, zero)
        arraylist.add(1, one)
        arraylist.add(2, two)
        arraylist.add(3, three)
        arraylist.add(4, four)
        arraylist.add(5, five)
        arraylist.add(6, six)
        arraylist.add(7, seven)
        arraylist.add(8, eight)
        arraylist.add(9, restart)

        click(0, "0")
        click(1, "1")
        click(2, "2")
        click(3, "3")
        click(4, "4")
        click(5, "5")
        click(6, "6")
        click(7, "7")
        click(8, "8")
        click(9, "restart")

        restart.setOnClickListener {
            restart()
        }
    }

    fun click(i: Int, s: String) {

        arraylist[i].setOnClickListener {
            if (arraylist[i].text.toString().isEmpty()) {
                if (value == 1) {
                    arraylist[i].text = "X"
                    value = 0
                } else {
                    arraylist[i].text = "O"
                    value = 1
                }
                check()
            }
        }
    }

    fun check() {

        win(0, 1, 2)
        win(0, 3, 6)
        win(0, 4, 8)
        win(3, 4, 5)
        win(6, 7, 8)
        win(1, 4, 7)
        win(2, 5, 8)
        win(2, 4, 6)

    }

    fun win(i: Int, i1: Int, i2: Int) {

        if (arraylist[i].text == arraylist[i1].text && arraylist[i1].text == arraylist[i2].text && arraylist[i].text.isNotEmpty()) {
            winner(arraylist[i].text.toString())
        }
    }

    fun winner(winner: String) {
        Toast.makeText(this, "Congratulations! $winner you win!", Toast.LENGTH_SHORT).show()
        restart()

    }

    fun restart() {
        for (i in 0 until arraylist.size - 1) {
            arraylist[i].text = ""
        }
        value = 1
    }
}









