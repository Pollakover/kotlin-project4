package com.example.kotlin_project4

import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

class List : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val data = mutableListOf<String>()

        //доступ к Documents
        val documentsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)

        //указать путь к файлу photos/data
        val dataFile = File(documentsDir, "photos/data")

        // Чтение всего файла
        val inputStream = FileInputStream(dataFile)
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))

        // Чтение данных построчно
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            line?.let { data.add(it) }
        }

        // Закрытие потоков
        bufferedReader.close()
        inputStream.close()

        val adapter = MyAdapter(data)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}