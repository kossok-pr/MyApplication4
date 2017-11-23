package com.example.android.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        var subjectEdit:EditText = findViewById(R.id.subject_edit)
        var textEdit:EditText = findViewById(R.id.text_edit)
        var sendBtn:Button = findViewById(R.id.send_btn)

        sendBtn.setOnClickListener(View.OnClickListener {
            var subject = subjectEdit.text.toString()
            var text = textEdit.text.toString()
            var intent = Intent(applicationContext, TestActivity::class.java)
            intent.putExtra(Intent.EXTRA_TEXT, text)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            startActivity(intent)
        })
    }
}
