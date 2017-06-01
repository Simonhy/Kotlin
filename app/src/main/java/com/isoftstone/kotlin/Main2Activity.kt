package com.isoftstone.kotlin

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.example.hy.refreshlistview.RefreshListView
import java.util.*

/**
 * Created by yonghuangl on 2017/6/1.
 */
class Main2Activity : AppCompatActivity() {
    private var listview: RefreshListView? = null
    private val allData = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listview = findViewById(R.id.listView) as RefreshListView
        initData()
    }

    private fun initData() {
        if (allData.size <= 0) {
            for (i in 0..99) {
                allData.add("我是张三-----" + i)
            }
        }
        val adpter = MyAdpter(this, allData)
        listview!!.adapter = adpter
       // listview!!.onItemClickListener = this
        listview!!.setOnRefreshListener(object : RefreshListView.OnRefreshListener {
            override fun onPullDownRefresh() {
                try {
                    Handler().postDelayed(object : Runnable {
                         override fun run() {
                            // 会在3秒钟后执行.
                            allData.add(0, "我是下拉刷新出来的数据.. ")
                            adpter.notifyDataSetChanged()
                            // 把头布局隐藏掉
                            listview!!.onRefreshFinish()
                        }
                    }, 3000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }

            override fun onLoadingMore() {
                try {
                    Handler().postDelayed(object : Runnable {

                        override fun run() {
                            allData.add("我是加载更多的数据1")
                            allData.add("我是加载更多的数据2")
                            allData.add("我是加载更多的数据3")
                            listview!!.onRefreshFinish()
                        }
                    }, 5000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }
        })
    }
}
