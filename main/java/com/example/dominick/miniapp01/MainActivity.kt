package com.example.dominick.miniapp01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText;

import kotlinx.android.synthetic.main.activity_main.*

import java.text.DecimalFormat
import android.R.attr.name



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calcButton.isEnabled = false;

        //used an object to implement the two TextWatcher interface for both EditText Views
        //the Calculate button will be disabled if any of the input fields are empty

        //TextWatcher interface for netInput
        netInput.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                calcButton.isEnabled = !fileInput.text.isEmpty() && !netInput.text.isEmpty()
            }
        })
        //TextWatcher interface for fileInput
        fileInput.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                calcButton.isEnabled = !fileInput.text.isEmpty() && !netInput.text.isEmpty()
            }
        })
    }

    //function that takes both user inputs and calculates the transfer time
    fun ttCalculation(view: View) {
        val n_input = Integer.valueOf(netInput.text.toString())
        val f_input = Integer.valueOf(fileInput.text.toString())

        //convert MiB and M to bytes to find the transfer time in seconds
        val f_size = f_input * Math.pow(2.0, 20.0)
        val n_size = (n_input * 125000).toDouble()

        val result = f_size / n_size

        val df = DecimalFormat("#.#")

        tt_result.text = df.format(result)
    }


}
