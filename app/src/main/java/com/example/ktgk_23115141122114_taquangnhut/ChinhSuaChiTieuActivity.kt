package com.example.ktgk_23115141122114_taquangnhut

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaChiTieuActivity : AppCompatActivity() {
    private lateinit var edtSuaTen_114: EditText
    private lateinit var edtSuaSoTien_114: EditText
    private lateinit var edtSuaGhiChu_114: EditText
    private lateinit var btnLuu_114: Button
    private lateinit var btnHuy_114: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_chi_tieu)

        supportActionBar?.title = "Tạ Quang Nhựt - 114 - Chỉnh sửa khoản chi"

        anhXa_114()
        nhanDuLieuCu_114()
        suKienClick_114()
    }

    private fun anhXa_114() {
        edtSuaTen_114 = findViewById(R.id.edtSuaTenKhoanChi_114)
        edtSuaSoTien_114 = findViewById(R.id.edtSuaSoTien_114)
        edtSuaGhiChu_114 = findViewById(R.id.edtSuaGhiChu_114)
        btnLuu_114 = findViewById(R.id.btnLuu_114)
        btnHuy_114 = findViewById(R.id.btnHuy_114)
    }

    private fun nhanDuLieuCu_114() {
        // Nhận dữ liệu hiện tại để hiển thị sẵn lên các ô nhập
        edtSuaTen_114.setText(intent.getStringExtra("TEN_CU"))
        edtSuaSoTien_114.setText(intent.getStringExtra("SO_TIEN_CU"))
        edtSuaGhiChu_114.setText(intent.getStringExtra("GHI_CHU_CU"))
    }

    private fun suKienClick_114() {
        btnLuu_114.setOnClickListener {
            val intentKetQua_114 = Intent().apply {
                putExtra("TEN_MOI", edtSuaTen_114.text.toString().trim())
                putExtra("SO_TIEN_MOI", edtSuaSoTien_114.text.toString().trim())
                putExtra("GHI_CHU_MOI", edtSuaGhiChu_114.text.toString().trim())
            }
            setResult(Activity.RESULT_OK, intentKetQua_114)
            finish()
        }

        btnHuy_114.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}