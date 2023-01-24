package com.example.newrespcalcappdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
    private lateinit var zero: Button

    private lateinit var backspace: Button
    private lateinit var clear: Button

    private lateinit var dot: Button
    private lateinit var percent: Button
    private lateinit var pos_neg: Button

    private lateinit var plus: Button
    private lateinit var minus: Button
    private lateinit var mult: Button
    private lateinit var div: Button

    private lateinit var operand: TextView

    private var isPoint = true
    private var isDigit = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)

        plus = findViewById(R.id.plus)
        minus = findViewById(R.id.minus)
        mult = findViewById(R.id.mult)
        div = findViewById(R.id.div)

        clear = findViewById(R.id.clear)
        backspace = findViewById(R.id.backspace)

        dot = findViewById(R.id.dot)
        percent = findViewById(R.id.percent)
        pos_neg = findViewById(R.id.pos_neg)

        operand = findViewById(R.id.operand)

        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)
        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)
        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)
        zero.setOnClickListener(this)

        clear.setOnClickListener{
            operand.text="0"
            isPoint = true
        }

        backspace.setOnClickListener{
            operand.text = operand.text.dropLast(1)
        }

        dot.setOnClickListener{
            if (isPoint){
                if(operand.text.substring(operand.text.length-1, operand.text.length).isDigitsOnly()){
                    operand.text = operand.text.toString() + "."
                }
            }
            isPoint = false
        }


    }

    override fun onClick(p0: View?) {
        var btn = findViewById<Button>(p0!!.id)
        if(operand.text != "0")
            operand.text = operand.text.toString() + btn.text
        else
            operand.text = btn.text

    }


//    package uz.itschool.myapplication
//
//    import androidx.appcompat.app.AppCompatActivity
//    import android.os.Bundle
//    import android.widget.Button
//    import android.widget.TextView
//
//    class MainActivity : AppCompatActivity() {
//        private lateinit var salom: Button
//        private lateinit var hello: Button
//        private lateinit var backspace: Button
//        private lateinit var tv: TextView
//        private lateinit var clear: Button
//
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            setContentView(R.layout.activity_main)
//
//            hello = findViewById(R.id.button)
//            salom = findViewById(R.id.button2)
//            backspace = findViewById(R.id.button3)
//            clear = findViewById(R.id.button4)
//
//            tv = findViewById(R.id.textView)
//
//            salom.setOnClickListener{
//                tv.text=tv.text.toString()+"salom"
//            }
//            hello.setOnClickListener{
//                tv.text=tv.text.toString()+"hello"
//            }
//
//
//            backspace.setOnClickListener{
//                tv.text = tv.text.dropLast(1)
//            }
//
//            clear.setOnClickListener{
//                tv.text=""
//            }
//
//        }
//    }



}