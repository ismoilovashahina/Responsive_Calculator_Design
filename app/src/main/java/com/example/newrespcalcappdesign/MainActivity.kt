package com.example.newrespcalcappdesign

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    private lateinit var result: TextView

    private var isPoint = true
    private var isSign = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()

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
            isSign = true
            result.text = ""
        }

        backspace.setOnClickListener{
            operand.text = operand.text.dropLast(1)
            result.text = calculate()

        }

        dot.setOnClickListener{
            if (isPoint){
                if(operand.text.toString().substring(operand.text.length-1, operand.text.length).isDigitsOnly()){
                    operand.text = operand.text.toString() + "."
                    isPoint = false
                }
            }
        }

        mult.setOnClickListener {
            addSign("x")
        }
        div.setOnClickListener {
            addSign("/")
        }
        plus.setOnClickListener {
            addSign("+")
        }
        minus.setOnClickListener {
            addSign("-")
        }






    }

    @SuppressLint("SetTextI18n")
    override fun onClick(p0: View?) {
        var btn = findViewById<Button>(p0!!.id)
        if(operand.text == "0")
            operand.text = ""
            isPoint = true
        operand.text = operand.text.toString() + btn.text
        isSign = true
        isPoint = true
        result.text = calculate()

    }

    @SuppressLint("SetTextI18n")
    private fun addSign(sign: String){
        if (isSign){
            operand.text = operand.text.toString() + sign
            isSign = false
        } else{
            operand.text = operand.text.dropLast(1).toString() + sign
        }
    }

    private fun createArray(s:String):MutableList<Any>{
        var list = mutableListOf<Any>()
        var temp = ""
        for(i in s){
            if (i.isDigit() || i == '.'){
                temp+=i
            } else{
                list.add(temp.toFloat())
                temp = ""
                list.add(i)
            }
        }
        if (temp.isNotEmpty()){
            list.add(temp.toFloat())
        }
        return list
    }

    fun solve1(l: MutableList<Any>):MutableList<Any>{
        var list = l
        var i = 0
        if (l.size>2){
            while (list.contains('/') || list.contains('x')){
                if (list[i] == 'x' || list[i] == '/'){
                    var old = list[i-1] as Float
                    var next = list[i+1] as Float
                    var amal = list[i]
                    var res = 0f
                    when(amal){
                        '/'->{
                            res = old/next
                        }
                        'x'->{
                            res = old*next
                        }
                    }
                    list.set(i-1, res)
                    list.removeAt(i)
                    list.removeAt(i)
                    i -= 2
                }
                i++
            }
        }

        Log.d("ARRList", list.toString())

        return l
    }

    fun solve2(l: MutableList<Any>):String{
        var list = l
        var i = 0
        if (l.size>2){
            Log.d("TAG", "hello")
            while (list.contains('+') || list.contains('-')){
                if (list[i] == '+' || list[i] == '-'){
                    var old = list[i-1] as Float
                    var next = list[i+1] as Float
                    var amal = list[i]
                    var res = 0f
                    when(amal){
                        '+'->{
                            res = old+next
                        }
                        '-'->{
                            res = old-next
                        }
                    }
                    list.set(i-1, res)
                    list.removeAt(i)
                    list.removeAt(i)
                    i -= 2
                }
                i++
            }
            return l[0].toString()
        }
        else return ""



    }


    private fun calculate() :String{
        var list = createArray(operand.text.toString())

        solve1(list)

        return solve2(list)

    }




    fun initUI() {
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
        result = findViewById(R.id.result)
    }

}