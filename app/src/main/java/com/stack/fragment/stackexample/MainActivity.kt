package com.stack.fragment.stackexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var redBt:Button? = null
    private var blueBt:Button? = null
    private var greenBt:Button? = null
    private var yellowBt:Button? = null
    private var fmNameText: TextView? = null
    private var scrollview: ScrollView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // button setting
        setButtons()
    }

    private fun setButtons() {

        fmNameText = findViewById(R.id.fragment_name)

        redBt = findViewById(R.id.redFragment)
        blueBt = findViewById(R.id.blueFragment)
        greenBt = findViewById(R.id.greenFragment)
        yellowBt = findViewById(R.id.yellowFragment)

        scrollview = findViewById(R.id.scrollView)

        redBt?.setOnClickListener {
            fmNameText?.text = "fragment: red"
            replaceFragment(RedFragment())
            addButton()
        }

        blueBt?.setOnClickListener {
            fmNameText?.text = "fragment: blue"
            replaceFragment(BlueFragment())
            addButton()
        }

        greenBt?.setOnClickListener {
            fmNameText?.text = "fragment: green"
            replaceFragment(GreenFragment())
            addButton()
        }

        yellowBt?.setOnClickListener {
            fmNameText?.text = "fragment: yellow"
            replaceFragment(YellowFragment())
            addButton()
        }
    }

    private fun addButton() {
        val btn = Button(this)
        btn.text = "ccc"

        scrollview?.addView(btn)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.fg_container, fragment)
        ft.commit()
    }
}
