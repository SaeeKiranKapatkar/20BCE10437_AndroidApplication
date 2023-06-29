package com.example.assignment2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var bloodTypeEditText: EditText
    private lateinit var addButton: Button
    private lateinit var bloodListView: ListView

    private lateinit var bloodList: ArrayList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bloodTypeEditText = findViewById(R.id.bloodTypeEditText)
        addButton = findViewById(R.id.addButton)
        bloodListView = findViewById(R.id.bloodListView)

        bloodList = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, bloodList)
        bloodListView.adapter = adapter

        addButton.setOnClickListener {
            val bloodType = bloodTypeEditText.text.toString()
            if (bloodType.isNotEmpty()) {
                bloodList.add(bloodType)
                adapter.notifyDataSetChanged()
                bloodTypeEditText.text.clear()
            }
        }
    }
}