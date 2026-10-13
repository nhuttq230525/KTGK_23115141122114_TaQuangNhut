package com.example.ktgk_23115141122114_taquangnhut

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var edtTenKhoanChi_114: EditText
    private lateinit var edtSoTien_114: EditText
    private lateinit var edtGhiChu_114: EditText
    private lateinit var btnThemKhoanChi_114: Button
    private lateinit var btnXemChiTiet_114: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        anhXa_114()
        suKienClick_114()
    }

    private fun anhXa_114() {
        edtTenKhoanChi_114 = findViewById(R.id.edtTenKhoanChi_114)
        edtSoTien_114 = findViewById(R.id.edtSoTien_114)
        edtGhiChu_114 = findViewById(R.id.edtGhiChu_114)
        btnThemKhoanChi_114 = findViewById(R.id.btnThemKhoanChi_114)
        btnXemChiTiet_114 = findViewById(R.id.btnXemChiTiet_114)
    }

    private fun suKienClick_114() {
        btnThemKhoanChi_114.setOnClickListener {
            val ten_114 = edtTenKhoanChi_114.text.toString().trim()
            val soTienStr_114 = edtSoTien_114.text.toString().trim()

            if (ten_114.isEmpty()) {
                Toast.makeText(this, "Tên khoản chi không được để trống!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val soTien_114 = soTienStr_114.toDoubleOrNull()
            if (soTien_114 == null || soTien_114 <= 0) {
                Toast.makeText(this, "Số tiền phải là số lớn hơn 0!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Thêm khoản chi thành công!", Toast.LENGTH_SHORT).show()
        }

        btnXemChiTiet_114.setOnClickListener {
            // Tạm thời để trống hoặc chuyển màn hình giả lập cho Câu 1
            Toast.makeText(this, "Chuyển sang màn hình chi tiết (sẽ hoàn thiện ở Câu 2)", Toast.LENGTH_SHORT).show()
        }
    }
}