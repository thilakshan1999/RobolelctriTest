package com.example.robolelctritest.RoboelectricTest

import android.R
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.robolelctritest.FirstFragment
import com.example.robolelctritest.MainActivity
import com.example.robolelctritest.SecondActivity
import junit.runner.Version.id
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RoboelectricTest {

    @Test
    fun check_second_activity_text(){
        val activity=Robolectric.buildActivity(SecondActivity::class.java).create().get()

        val textView : TextView = activity.findViewById<TextView>(com.example.robolelctritest.R.id.textView)
        Assert.assertEquals("Activity Test", textView.text)
    }
    @Test
    fun check_first_fragment_text(){
        val fragment = FirstFragment()
        val activity = Robolectric.buildActivity(
            MainActivity::class.java
        )
            .create()
            .start()
            .resume()
            .get()

        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(fragment, null)
        fragmentTransaction.commit()

        val textView : TextView = activity.findViewById<TextView>(com.example.robolelctritest.R.id.textview_first)
        Assert.assertEquals("Hello first fragment", textView.text)
    }
}

