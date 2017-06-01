package com.isoftstone.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val listView = ListView(this)
        listView.onItemClickListener = this

    }
    override fun onItemClick(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {

    }
}
