package cl.umag.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textViewResult: TextView
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operator: String = ""
    private var isOperatorClicked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResult = findViewById(R.id.Resultado)
    }

    fun onNumberClick(view: View) {
        if (view is Button) {
            val number = view.text.toString()
            if (isOperatorClicked) {
                textViewResult.text = number
                isOperatorClicked = false
            } else {
                textViewResult.append(number)
            }
        }
    }

    fun onOperatorClick(view: View) {
        if (view is Button) {
            operator = view.text.toString()
            num1 = textViewResult.text.toString().toDouble()
            isOperatorClicked = true
        }
    }

    fun onEqualClick(view: View) {
        if (!isOperatorClicked) {
            val result: Double
            num2 = textViewResult.text.toString().toDouble()
            when (operator) {
                "+" -> result = num1 + num2
                "-" -> result = num1 - num2
                "*" -> result = num1 * num2
                "/" -> result = num1 / num2
                else -> result = 0.0
            }
            textViewResult.text = result.toString()
        }
    }


}
