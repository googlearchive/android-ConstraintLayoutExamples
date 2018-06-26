package com.google.androidstudio.motionlayoutexample.fragmentsdemo

import android.graphics.Rect
import android.support.constraint.motion.MotionLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.google.androidstudio.motionlayoutexample.ItemFragment
import com.google.androidstudio.motionlayoutexample.R
import com.google.androidstudio.motionlayoutexample.User

class CustomAdapter(val userList: ArrayList<User>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.txtName?.text = userList[position].name
        holder?.txtTitle?.text = userList[position].title
        holder?.itemView.setOnClickListener({
            var parent = it?.parent?.parent?.parent?.parent
            if (parent is MotionLayout) {
                val offsetViewBounds = Rect()
                it.getDrawingRect(offsetViewBounds)
                parent.offsetDescendantRectToMyCoords(it, offsetViewBounds)
                var placeholder = parent.findViewById<FrameLayout>(R.id.rv_item_placeholder)
//                placeholder.layout(offsetViewBounds.left, offsetViewBounds.top,
//                        offsetViewBounds.right, offsetViewBounds.bottom)
                var transaction = (it.context as AppCompatActivity).supportFragmentManager.beginTransaction()
                var fragment = ItemFragment.newInstance()
                fragment.update(holder)
                transaction.replace(R.id.rv_item_placeholder, fragment)
                transaction.commitNow()
//                holder.itemView.visibility = View.INVISIBLE
//                parent.updateFrame(placeholder, offsetViewBounds, View.VISIBLE)
                parent.transitionToEnd()
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtName = itemView.findViewById<TextView>(R.id.txtName)
        val txtTitle = itemView.findViewById<TextView>(R.id.txtTitle)
    }

}