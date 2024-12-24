package com.example.app

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var canAddOperation = false
    private var canAddDecimal = true
    private lateinit var workingsTV: TextView
    private lateinit var resultsTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workingsTV = findViewById(R.id.workingTV)
        resultsTV = findViewById(R.id.resultTV)
    }

    fun numberAction(view: View) {
        if (view is Button) {
            if (view.text == ".") {
                if (canAddDecimal) {
                    workingsTV.append(view.text)
                    canAddDecimal = false
                }
            } else {
                workingsTV.append(view.text)
                canAddOperation = true
            }
        }
    }

    fun operationAction(view: View) {
        if (view is Button && canAddOperation) {
            workingsTV.append(view.text)
            canAddOperation = false
            canAddDecimal = true
        }
    }

    fun allclearAction(view: View) {
        workingsTV.text = ""
        resultsTV.text = ""
        canAddOperation = false
        canAddDecimal = true
    }

    fun backspaceAction(view: View) {
        val length = workingsTV.text.length
        if (length > 0) {
            val text = workingsTV.text.subSequence(0, length - 1)
            workingsTV.text = text
            canAddOperation = text.isNotEmpty()
            canAddDecimal = !text.contains('.')
        }
    }

    fun equalAction(view: View) {
        resultsTV.text = calculateResults()
    }

    private fun calculateResults(): String {
        val digitsOperators = digitsOperators()
        if (digitsOperators.isEmpty()) return ""

        val timesDivision = timesDivisionCalculate(digitsOperators)
        if (timesDivision.isEmpty()) return ""

        return addSubtractCalculate(timesDivision).toString()
    }

    private fun addSubtractCalculate(passedList: MutableList<Any>): Float {
        var result = passedList[0] as Float
        for (i in passedList.indices) {
            if (passedList[i] is Char && i != passedList.lastIndex) {
                val operator = passedList[i] as Char
                val nextDigit = passedList[i + 1] as Float
                result = when (operator) {
                    '+' -> result + nextDigit
                    '-' -> result - nextDigit
                    else -> result
                }
            }
        }
        return result
    }

    private fun timesDivisionCalculate(passedList: MutableList<Any>): MutableList<Any> {
        var list = passedList
        while (list.contains('*') || list.contains('/')) {
            list = calctimesDiv(list)
        }
        return list
    }

    private fun calctimesDiv(passedList: MutableList<Any>): MutableList<Any> {
        val newList = mutableListOf<Any>()
        var i = 0
        while (i < passedList.size) {
            if (passedList[i] is Char && i != passedList.lastIndex) {
                val operator = passedList[i] as Char
                val prevDigit = passedList[i - 1] as Float
                val nextDigit = passedList[i + 1] as Float
                when (operator) {
                    '*' -> {
                        newList.add(prevDigit * nextDigit)
                        i += 2
                    }
                    '/' -> {
                        newList.add(prevDigit / nextDigit)
                        i += 2
                    }
                    else -> {
                        newList.add(prevDigit)
                        newList.add(operator)
                        i++
                    }
                }
            } else {
                newList.add(passedList[i])
                i++
            }
        }
        return newList
    }

    private fun digitsOperators(): MutableList<Any> {
        val list = mutableListOf<Any>()
        var currentDigit = ""
        for (character in workingsTV.text) {
            if (character.isDigit() || character == '.') {
                currentDigit += character
            } else {
                if (currentDigit.isNotEmpty()) {
                    list.add(currentDigit.toFloat())
                    currentDigit = ""
                }
                list.add(character)
            }
        }
        if (currentDigit.isNotEmpty()) {
            list.add(currentDigit.toFloat())
        }
        return list
    }}

