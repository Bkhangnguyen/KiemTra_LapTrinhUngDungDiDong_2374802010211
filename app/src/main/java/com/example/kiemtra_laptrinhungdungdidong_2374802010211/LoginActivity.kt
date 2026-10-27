package com.example.kiemtra_laptrinhungdungdidong_2374802010211

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 1.3. Ánh xạ View bằng findViewById truyền thống (không dùng ViewBinding)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        // 1.4 & 2.3 & 2.4. Xử lý sự kiện click vào Button 'Đăng nhập' và điều hướng Explicit Intent
        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()

            when {
                email.isEmpty() && password.isEmpty() -> {
                    tvStatus.setTextColor(Color.parseColor("#D32F2F"))
                    tvStatus.text = "Vui lòng nhập đầy đủ Email và Mật khẩu!"
                }
                email.isEmpty() -> {
                    tvStatus.setTextColor(Color.parseColor("#D32F2F"))
                    tvStatus.text = "Vui lòng không để trống Email!"
                }
                password.isEmpty() -> {
                    tvStatus.setTextColor(Color.parseColor("#D32F2F"))
                    tvStatus.text = "Vui lòng không để trống Mật khẩu!"
                }
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    tvStatus.setTextColor(Color.parseColor("#D32F2F"))
                    tvStatus.text = "Email không đúng định dạng!"
                }
                password.length < 6 -> {
                    tvStatus.setTextColor(Color.parseColor("#D32F2F"))
                    tvStatus.text = "Mật khẩu phải có ít nhất 6 ký tự!"
                }
                else -> {
                    tvStatus.setTextColor(Color.parseColor("#2E7D32"))
                    tvStatus.text = "Xác thực thành công!"

                    // 2.3 & 2.4. Điều hướng sang ProfileActivity bằng Explicit Intent kèm putExtra
                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("EXTRA_EMAIL", email)
                    startActivity(intent)
                }
            }
        }
    }
}
