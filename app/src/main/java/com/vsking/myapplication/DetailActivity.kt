package com.vsking.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vsking.myapplication.api.apidata.ListData
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val data=intent.getSerializableExtra("data") as ListData
        tvName.text=data.first_name
        tvEmail.text=data.email
    }
}