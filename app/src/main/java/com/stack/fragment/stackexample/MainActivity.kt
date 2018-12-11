package com.stack.fragment.stackexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var redBt:Button? = null
    private var blueBt:Button? = null
    private var greenBt:Button? = null
    private var yellowBt:Button? = null
    private var fmNameText: TextView? = null
    private var scrollview: LinearLayout? = null
    private var clearBt: Button? = null
    private val cntStr = "current Stack : "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // button setting
        setButtons()
    }

    private fun setButtons() {

        fmNameText = findViewById(R.id.fragment_name)
        fmNameText?.text = cntStr + 0

        redBt = findViewById(R.id.redFragment)
        blueBt = findViewById(R.id.blueFragment)
        greenBt = findViewById(R.id.greenFragment)
        yellowBt = findViewById(R.id.yellowFragment)
        clearBt = findViewById(R.id.clearBtn)

        scrollview = findViewById(R.id.scrollView)


        clearBt?.setOnClickListener {
            clearStack()
        }

        redBt?.setOnClickListener {
            fmNameText?.text = "fragment: red"
            replaceFragment(RedFragment())
            addButton("red")
        }

        blueBt?.setOnClickListener {
            fmNameText?.text = "fragment: blue"
            replaceFragment(BlueFragment())
            addButton("blue")
        }

        greenBt?.setOnClickListener {
            fmNameText?.text = "fragment: green"
            replaceFragment(GreenFragment())
            addButton("green")
        }

        yellowBt?.setOnClickListener {
            fmNameText?.text = "fragment: yellow"
            replaceFragment(YellowFragment())
            addButton("yellow")
        }
    }

    private fun addButton(text: String) {
        val btn = Button(this)
        btn.text = text

        scrollview?.addView(btn)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.fg_container, fragment)
        ft.addToBackStack(null)
        ft.commit()

        fmNameText?.text = "$cntStr ${fm.backStackEntryCount + 1}"
    }

    private fun clearStack() {
        scrollview?.removeAllViews()

        val fm = supportFragmentManager
        for (i in fm.backStackEntryCount -1 downTo 0) {
            fm.popBackStack()
        }

        fmNameText?.text = cntStr + 0
    }
}
