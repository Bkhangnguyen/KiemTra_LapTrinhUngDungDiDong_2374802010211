package com.example.kiemtra_laptrinhungdungdidong_2374802010211

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // 2.2. Ánh xạ View bằng findViewById
        val tvProfileTitle = findViewById<TextView>(R.id.tvProfileTitle)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // 2.4. Trích xuất dữ liệu Email từ Intent và gán hiển thị lên TextView Email
        val email = intent.getStringExtra("EXTRA_EMAIL") ?: ""
        tvEmail.text = "Email: $email"

        // 2.5. Xử lý Đăng xuất: Gọi finish() để đóng màn hình hiện tại và quay về LoginActivity
        btnLogout.setOnClickListener {
            finish()
        }
    }
}
