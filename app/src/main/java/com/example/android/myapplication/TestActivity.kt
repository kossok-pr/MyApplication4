package com.example.android.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class TestActivity : AppCompatActivity() {

    lateinit var subjectTextView:TextView
    lateinit var textTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        subjectTextView = findViewById(R.id.subject_text_view)
        textTextView = findViewById(R.id.text_text_view)

        var testButton: Button = findViewById(R.id.test_btn)

        testButton.setOnClickListener(View.OnClickListener {
            subjectTextView.text = intent.getStringExtra(Intent.EXTRA_SUBJECT)
            textTextView.text = intent.getStringExtra(Intent.EXTRA_TEXT)
        })
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putString("text", intent.getStringExtra(Intent.EXTRA_TEXT))
        outState!!.putString("subject", intent.getStringExtra(Intent.EXTRA_SUBJECT))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        subjectTextView.text = savedInstanceState!!.getString("subject")
        textTextView.text = savedInstanceState!!.getString("text")
    }
}
