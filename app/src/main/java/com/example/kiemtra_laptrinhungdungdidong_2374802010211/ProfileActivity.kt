package com.example.kiemtra_laptrinhungdungdidong_2374802010211

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // 2.2 & 3.2. Ánh xạ View bằng findViewById
        val tvProfileTitle = findViewById<TextView>(R.id.tvProfileTitle)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        val lvSubjects = findViewById<ListView>(R.id.lvSubjects)

        // 2.4. Trích xuất dữ liệu Email từ Intent và gán hiển thị lên TextView Email
        val email = intent.getStringExtra("EXTRA_EMAIL") ?: ""
        tvEmail.text = "Email: $email"

        // 2.5. Xử lý Đăng xuất: Gọi finish() để đóng màn hình hiện tại và quay về LoginActivity
        btnLogout.setOnClickListener {
            finish()
        }

        // 3.3. Dữ liệu mảng gồm 05 môn học/kỹ năng mẫu
        val subjects = arrayOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android"
        )

        // 3.4. Gắn ArrayAdapter với layout mẫu android.R.layout.simple_list_item_1
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            subjects
        )
        lvSubjects.adapter = adapter

        // 3.5. Bắt sự kiện Click cho ListView hiển thị Toast chính xác tên phần tử đã chọn
        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            val selectedSubject = subjects[position]
            Toast.makeText(this, selectedSubject, Toast.LENGTH_SHORT).show()
        }
    }
}
