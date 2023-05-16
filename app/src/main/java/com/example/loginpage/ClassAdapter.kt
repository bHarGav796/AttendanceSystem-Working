package com.example.loginpage

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClassAdapter(private val context: Context, private val classItems: ArrayList<ClassItem>) :
    RecyclerView.Adapter<ClassAdapter.ClassViewHolder>() {

    class ClassViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ClassName: TextView = itemView.findViewById(R.id.class_tv)
        val SubjectName: TextView = itemView.findViewById(R.id.subject_tv)
        val UniqueName: TextView = itemView.findViewById(R.id.Unique_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.class_item, parent, false)
        return ClassViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        holder.ClassName.text = classItems[position].ClassName
        holder.SubjectName.text = classItems[position].SubjectName
        holder.UniqueName.text = classItems[position].UniqueName

        holder.itemView.setOnClickListener {
            when (position) {
                0 -> {
                    val intent = Intent(context, StudentActivity1::class.java)
                    context.startActivity(intent)
                }
                1 -> {
                    val intent = Intent(context, StudentActivity2::class.java)
                    context.startActivity(intent)
                }
                // add more cases for other positions if needed
                else -> {
                    // handle click event for other positions
                }
            }
        }
    }


    override fun getItemCount(): Int {
        return classItems.size
    }
}
