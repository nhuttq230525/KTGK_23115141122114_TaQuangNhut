package com.example.ktgk_23115141122114_taquangnhut

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChiTietChiTieuActivity : AppCompatActivity() {
    private lateinit var txtThongTinChiTiet_114: TextView
    private lateinit var btnQuayLai_114: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_chi_tieu)

        // Tiêu đề ActionBar theo đúng định dạng
        supportActionBar?.title = "Tạ Quang Nhựt - 114 - Chi tiết khoản chi"

        txtThongTinChiTiet_114 = findViewById(R.id.txtThongTinChiTiet_114)
        btnQuayLai_114 = findViewById(R.id.btnQuayLai_114)

        nhanVaHienThiDuLieu_114()

        btnQuayLai_114.setOnClickListener {
            finish()
        }
    }

    private fun nhanVaHienThiDuLieu_114() {
        val ten_114 = intent.getStringExtra("TEN_KHOAN_CHI")
        val soTienStr_114 = intent.getStringExtra("SO_TIEN")
        val ghiChu_114 = intent.getStringExtra("GHI_CHU")

        val soTien_114 = soTienStr_114?.toDoubleOrNull() ?: 0.0

        // Kiểm tra dữ liệu không hợp lệ hoặc thiếu theo yêu cầu đề
        if (ten_114.isNullOrEmpty() || soTienStr_114.isNullOrEmpty() || soTien_114 <= 0.0) {
            txtThongTinChiTiet_114.text = "Lỗi: Dữ liệu khoản chi không hợp lệ hoặc bị thiếu!"
        } else {
            txtThongTinChiTiet_114.text = "Tên khoản chi: $ten_114\nSố tiền: $soTien_114 VNĐ\nGhi chú: $ghiChu_114"
        }
    }
}