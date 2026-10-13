package com.example.ktgk_23115141122114_taquangnhut

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietChiTieuActivity : AppCompatActivity() {
    private lateinit var txtThongTinChiTiet_114: TextView
    private lateinit var chkTrangThai_114: CheckBox
    private lateinit var btnQuayLai_114: Button
    private lateinit var btnChinhSua_114: Button

    private var tenHienTai_114 = ""
    private var soTienHienTai_114 = ""
    private var ghiChuHienTai_114 = ""
    private var daThanhToan_114 = false

    private lateinit var launcherChinhSua_114: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_chi_tieu)

        supportActionBar?.title = "Tạ Quang Nhựt - 114 - Chi tiết khoản chi"

        txtThongTinChiTiet_114 = findViewById(R.id.txtThongTinChiTiet_114)
        chkTrangThai_114 = findViewById(R.id.chkTrangThai_114)
        btnQuayLai_114 = findViewById(R.id.btnQuayLai_114)
        btnChinhSua_114 = findViewById(R.id.btnChinhSua_114)

        launcherChinhSua_114 = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data_114 = result.data
                tenHienTai_114 = data_114?.getStringExtra("TEN_MOI") ?: tenHienTai_114
                soTienHienTai_114 = data_114?.getStringExtra("SO_TIEN_MOI") ?: soTienHienTai_114
                ghiChuHienTai_114 = data_114?.getStringExtra("GHI_CHU_MOI") ?: ghiChuHienTai_114
                // Giữ nguyên trạng thái thanh toán hiện tại, không bị mất đi sau khi sửa thông tin

                hienThiThongTin_114()
            }
        }

        nhanDuLieuBanDau_114()

        // Lắng nghe sự kiện thay đổi trạng thái thanh toán trực tiếp qua CheckBox
        chkTrangThai_114.setOnCheckedChangeListener { _, isChecked ->
            daThanhToan_114 = isChecked
            hienThiThongTin_114()
        }

        btnQuayLai_114.setOnClickListener { finish() }

        btnChinhSua_114.setOnClickListener {
            val intent_114 = Intent(this, ChinhSuaChiTieuActivity::class.java)
            intent_114.putExtra("TEN_CU", tenHienTai_114)
            intent_114.putExtra("SO_TIEN_CU", soTienHienTai_114)
            intent_114.putExtra("GHI_CHU_CU", ghiChuHienTai_114)
            launcherChinhSua_114.launch(intent_114)
        }
    }

    private fun nhanDuLieuBanDau_114() {
        tenHienTai_114 = intent.getStringExtra("TEN_KHOAN_CHI") ?: ""
        soTienHienTai_114 = intent.getStringExtra("SO_TIEN") ?: ""
        ghiChuHienTai_114 = intent.getStringExtra("GHI_CHU") ?: ""
        daThanhToan_114 = false // Mặc định ban đầu chưa thanh toán

        chkTrangThai_114.isChecked = daThanhToan_114
        hienThiThongTin_114()
    }

    private fun hienThiThongTin_114() {
        val soTien_114 = soTienHienTai_114.toDoubleOrNull() ?: 0.0
        val trangThaiStr_114 = if (daThanhToan_114) "Đã thanh toán" else "Chưa thanh toán"

        if (tenHienTai_114.isEmpty() || soTien_114 <= 0.0) {
            txtThongTinChiTiet_114.text = "Dữ liệu không hợp lệ hoặc thiếu thông tin khoản chi!"
        } else {
            txtThongTinChiTiet_114.text = "Tên khoản chi: $tenHienTai_114\nSố tiền: $soTien_114 VNĐ\nGhi chú: $ghiChuHienTai_114\nTrạng thái: $trangThaiStr_114"
        }
    }
}