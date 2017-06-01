package com.isoftstone.kotlin

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

/**
 * Created by yonghuangl on 2017/6/1.
 */
class MyAdpter(private val context: Context, private val list: List<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return if (list.size == 0) 0 else list.size
    }

    override fun getItem(i: Int): Any {
        return list[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        var view = view
        var holder: MyViewHolder
        if (view == null) {
            holder = MyViewHolder()
            view = View.inflate(context, R.layout.item, null)
            holder.name = view!!.findViewById(R.id.name) as TextView
            holder.content = view!!.findViewById(R.id.content) as TextView
            view.tag = holder
        } else {
            holder = view.tag as MyViewHolder
        }
        val s = list[i]
        holder.name!!.text = "李四====" + i
        holder.content!!.text = s
        return view
    }
    internal inner class MyViewHolder {
        var name: TextView? = null
        var content: TextView? = null
    }
}
