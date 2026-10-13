package com.example.ktgk_23115141122114_taquangnhut

class KhoanChi_114(
    val maKhoanChi_114: String,
    var tenKhoanChi_114: String,
    var soTien_114: Double,
    var ghiChu_114: String,
    var daThanhToan_114: Boolean
) {
    fun layThongTin_114(): String {
        val trangThai_114 = if (daThanhToan_114) "Đã thanh toán" else "Chưa thanh toán"
        return "Mã: $maKhoanChi_114 - Tên: $tenKhoanChi_114 - Số tiền: $soTien_114 VNĐ - Trạng thái: $trangThai_114"
    }

    fun laSoTienHopLe_114(): Boolean {
        return soTien_114 > 0.0
    }
}