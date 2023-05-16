package com.example.loginpage

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {

    private lateinit var fab: FloatingActionButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var classAdapter: ClassAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var classItems = ArrayList<ClassItem>()

    private lateinit var class_edt: EditText
    private lateinit var subject_edt: EditText
    private lateinit var Unique_edt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        fab = findViewById(R.id.fab_main)
        fab.setOnClickListener { showDialog() }

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        classAdapter = ClassAdapter(this, classItems)
        recyclerView.adapter = classAdapter
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        val view = LayoutInflater.from(this).inflate(R.layout.dialog, null)
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()

        class_edt = view.findViewById(R.id.class_edt)
        subject_edt = view.findViewById(R.id.subject_edt)
        Unique_edt = view.findViewById(R.id.Unique_edt)

        val cancel = view.findViewById<Button>(R.id.cancel_btn)
        val add = view.findViewById<Button>(R.id.add_btn)

        cancel.setOnClickListener { dialog.dismiss() }
        add.setOnClickListener {
            addClass()
            dialog.dismiss()
        }
    }

    private fun addClass() {
        val className = class_edt.text.toString()
        val subjectName = subject_edt.text.toString()
        val UniqueName = Unique_edt.text.toString()
        classItems.add(ClassItem(className, subjectName, UniqueName))
        classAdapter.notifyDataSetChanged()
    }
}
