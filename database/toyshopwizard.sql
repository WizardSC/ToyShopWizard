-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 13, 2023 lúc 06:12 PM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `toyshopwizard`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chucvu`
--

CREATE TABLE `chucvu` (
  `MaCV` varchar(20) NOT NULL,
  `TenCV` varchar(30) NOT NULL,
  `Luong` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chucvu`
--

INSERT INTO `chucvu` (`MaCV`, `TenCV`, `Luong`) VALUES
('CV01', 'Quản Lý', 15000000),
('CV02', 'Nhân Viên Thu Ngân', 8500000),
('CV03', 'Kế Toán', 10000000),
('CV04', 'Nhân Viên Kho', 9000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cthoadon`
--

CREATE TABLE `cthoadon` (
  `MaHD` varchar(10) NOT NULL,
  `MaSP` varchar(10) NOT NULL,
  `TenSP` varchar(50) NOT NULL,
  `SoLuong` int(20) NOT NULL,
  `DonGia` int(20) NOT NULL,
  `ThanhTien` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `MaPN` varchar(15) NOT NULL,
  `MaSP` varchar(15) NOT NULL,
  `TenSP` varchar(50) NOT NULL,
  `SoLuong` int(20) NOT NULL,
  `DonGia` int(20) NOT NULL,
  `ThanhTien` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctphieunhap`
--

INSERT INTO `ctphieunhap` (`MaPN`, `MaSP`, `TenSP`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES
('PN01', 'SP01', 'Siêu Xe Porsche 963', 2, 838950, 1677900),
('PN01', 'SP03', 'Xe Mô Tô Cổ Điển', 5, 492450, 2462250),
('PN01', 'SP08', 'Bộ làm bếp 3 món mini Hồng', 4, 586950, 2347800),
('PN01', 'SP12', 'Xe chở xăng MAN TGS', 3, 2310000, 6930000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctphieuxuat`
--

CREATE TABLE `ctphieuxuat` (
  `MaPX` varchar(15) NOT NULL,
  `MaSP` varchar(20) NOT NULL,
  `TenSP` varchar(50) NOT NULL,
  `SoLuong` int(20) NOT NULL,
  `DonGia` int(20) NOT NULL,
  `ThanhTien` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` varchar(15) NOT NULL,
  `MaKH` varchar(15) DEFAULT NULL,
  `MaNV` varchar(15) DEFAULT NULL,
  `NgayLap` date DEFAULT current_timestamp(),
  `TongTien` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `MaKH`, `MaNV`, `NgayLap`, `TongTien`) VALUES
('HD26', 'KH26', 'NV26', '2023-05-15', 800000),
('HD27', 'KH03', 'NV03', '2023-05-15', 876000),
('HD28', 'KH13', 'NV13', '2023-05-15', 1050000),
('HD29', 'KH10', 'NV10', '2023-06-10', 2135000),
('HD30', 'KH10', 'NV05', '2023-06-10', 2260000),
('HD31', '111', '111', '2023-06-10', 420000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` varchar(20) NOT NULL,
  `Ho` varchar(50) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `NgaySinh` varchar(20) NOT NULL,
  `GioiTinh` varchar(15) NOT NULL,
  `DiaChi` varchar(255) NOT NULL,
  `SoDT` varchar(20) NOT NULL,
  `IMG` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `Ho`, `Ten`, `NgaySinh`, `GioiTinh`, `DiaChi`, `SoDT`, `IMG`) VALUES
('dà', 'r3', '423', '34', 'Nam', '24', '2423', 'null'),
('KH01', 'So', 'Junghwan', '18/02/2005', 'Nam', 'South Korea', '18022005', 'Junghwan.jpg'),
('KH03', 'Watanabe', 'Haruto', '05/04/2004', 'Nam', 'South Korea', '05042004', 'Haruto.jpg'),
('KH04', 'Son', 'Dongwoon', '06/06/1991', 'Nam', 'South Korea', '06061991', 'Dongwoon.jpg'),
('KH05', 'Kwak', 'Aaron', '21/05/1993', 'Nam', 'USA', '21051993', 'Aaron.jpg'),
('KH06', 'Kim', 'Jonghyun', '08/06/1995', 'Nam', 'South Korea', '08061995', ''),
('KH07', 'Kang', 'Dongho', '21/07/1995', 'Nam', 'South Korea', '21071995', ''),
('KH08', 'Hwang', 'Minhyun', '09/08/1995', 'Nam', 'South Korea', '09081995', 'null'),
('KH09', 'Choi', 'Mingi', '03/11/1995', 'Nam', 'South Korea', '03111995', 'null'),
('KH10', 'Kim', 'Jisoo', '03/01/1995', 'Nữ', 'South Korea', '03011995', 'Jisoo.jpg'),
('KH11', 'Kim', 'Jennie', '16/01/1996', 'Nữ', 'South Korea', '16011996', 'Jennie.jpg'),
('KH12', 'Park', 'Chaeyoung', '11/02/1997', 'Nữ', 'New Zealand', '11021997', 'Chaeyoung.jpg'),
('KH13', 'Manobal', 'Lalisa', '27/03/1997', 'Nữ', 'Thailand', '27031997', 'Lalisa.jpg'),
('KH14', 'Park', 'Bom', '24/03/1984', 'Nữ', 'South Korea', '24031984', 'Bom.jpg'),
('KH15', 'Park', 'Sandara', '12/11/1984', 'Nữ', 'South Korea', '12111984', 'Sandara.jpg'),
('KH16', 'Lee', 'Chaelim', '26/02/1991', 'Nữ', 'South Korea', '26021991', 'Chaelim.jpg'),
('KH17', 'Gong', 'Minzy', '18/01/1994', 'Nữ', 'South Korea', '18011994', 'Minzy.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `kho`
--

CREATE TABLE `kho` (
  `MaSP` varchar(20) NOT NULL,
  `TenSP` varchar(50) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `GiaNhap` int(11) NOT NULL,
  `DonViTinh` varchar(20) NOT NULL,
  `MaLoai` varchar(20) NOT NULL,
  `IMG` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `kho`
--

INSERT INTO `kho` (`MaSP`, `TenSP`, `SoLuong`, `GiaNhap`, `DonViTinh`, `MaLoai`, `IMG`) VALUES
('SP01', 'Siêu Xe Porsche 963', 1, 838950, 'Cái', 'L01', 'null'),
('SP02', 'Siêu Xe Pagani Utopia', 0, 838950, 'Cái', 'L01', 'null'),
('SP03', 'Xe Mô Tô Cổ Điển', 5, 492450, 'Cái', 'L01', 'null'),
('SP04', 'Bộ Gạch Sáng Tạo Neon Vui Nhộn', 0, 454650, 'Cái', 'L01', 'null'),
('SP05', 'Bộ Gạch Sáng Tạo Pastel Dễ Thương', 0, 649950, 'Bộ', 'L01', 'null'),
('SP06', 'Siêu Xe Của Người Nhện', 0, 324450, 'Chiếc', 'L01', 'null'),
('SP07', 'Combo 2 mô hình nhân vật MOBILITY JOINT GUNDAM VOL', 0, 502950, 'Chiếc', 'L01', 'null'),
('SP08', 'Bộ làm bếp 3 món mini Hồng', 4, 586950, 'Cái', 'L05', 'null'),
('SP09', 'Bộ nồi lẩu điện mini Xanh dương', 0, 418950, 'Cái', 'L05', 'null'),
('SP10', 'Set bánh vui vẻ 28 chi tiết ', 0, 329700, 'Bộ', 'L05', 'null'),
('SP11', 'Trung tâm thương mại hiện đại', 0, 2100000, 'Bộ', 'L05', 'null'),
('SP12', 'Xe chở xăng MAN TGS', 3, 2310000, 'Cái', 'L02', 'null'),
('SP13', 'Đồ chơi mô hình tỷ lệ 1:16 xe chở hàng DHL ', 0, 1890000, 'Cái', 'L02', 'null'),
('SP14', 'Đồ chơi búp bê thời trang tóc đỏ ', 0, 270900, 'Cái', 'L04', 'null'),
('SP15', 'Đồ chơi búp bê thời trang jumpsuit xanh dạo phố ', 0, 270900, 'Cái', 'L04', 'null'),
('SP16', 'Bộ đồ chơi búp bê đi picnic cùng thú cưng ', 0, 735000, 'Cái', 'L04', 'null'),
('SP17', 'Đồ chơi búp bê nam thời trang áo xám ', 0, 387450, 'Cái', 'L04', 'null'),
('SP18', 'Sư tử Leo lười ', 0, 595350, 'Cái', 'L04', 'null'),
('SP19', 'Gấu Lizzie tinh nghịch ', 0, 519750, 'Con', 'L06', 'null'),
('SP20', 'Gấu Bobbie tinh nghịch ', 0, 519750, 'Con', 'L06', 'null');

--
-- Bẫy `kho`
--
DELIMITER $$
CREATE TRIGGER `before_kho_update` BEFORE UPDATE ON `kho` FOR EACH ROW BEGIN
UPDATE sanpham
SET
TenSP = NEW.TenSP,
DonViTinh = NEW.DonViTinh,
MaLoai = NEW.MaLoai,
IMG = NEW.IMG
WHERE MaSP = NEW.MaSP;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MaKM` varchar(10) NOT NULL,
  `TenKM` varchar(40) NOT NULL,
  `PhanTramKM` int(10) NOT NULL,
  `DieuKien` int(20) NOT NULL,
  `NgayBatDau` date NOT NULL,
  `NgayKetThuc` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`MaKM`, `TenKM`, `PhanTramKM`, `DieuKien`, `NgayBatDau`, `NgayKetThuc`) VALUES
('KM01', 'Giảm Giá 10%', 10, 200000, '2022-11-01', '2022-11-02'),
('KM02', 'Giảm Giá 20%', 20, 50000, '2022-11-08', '2022-11-29'),
('KM03', 'Giảm Giá 30%', 30, 200000, '2022-11-07', '2022-12-28');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai`
--

CREATE TABLE `loai` (
  `MaLoai` varchar(20) NOT NULL,
  `TenLoai` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loai`
--

INSERT INTO `loai` (`MaLoai`, `TenLoai`) VALUES
('L01', 'Xếp hình'),
('L02', 'Mô hình'),
('L03', 'Vận động'),
('L04', 'Búp bê'),
('L05', 'Mô phỏng'),
('L06', 'Thú bông');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` varchar(20) NOT NULL,
  `TenNCC` varchar(30) NOT NULL,
  `DiaChi` varchar(20) NOT NULL,
  `SoDT` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `DiaChi`, `SoDT`) VALUES
('NCC01', 'BRUDER', 'Germany', '01011927'),
('NCC02', 'LEGO CLASSIC', 'Denmark', '02021926');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` varchar(10) NOT NULL,
  `Ho` varchar(20) NOT NULL,
  `Ten` varchar(20) NOT NULL,
  `NgaySinh` varchar(15) NOT NULL,
  `GioiTinh` varchar(10) NOT NULL,
  `DiaChi` varchar(20) NOT NULL,
  `SoDT` varchar(20) NOT NULL,
  `MaCV` varchar(10) NOT NULL,
  `IMG` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `Ho`, `Ten`, `NgaySinh`, `GioiTinh`, `DiaChi`, `SoDT`, `MaCV`, `IMG`) VALUES
('NV01', 'Seo', 'Eunkwang', '22/11/1990', 'Nam', 'South Korea', '22111990', 'CV01', 'Eunkwang.jpg'),
('NV02', 'Lee', 'Minhyuk', '29/11/1990', 'Nam', 'South Korea', '29111990', 'CV01', 'Minhyuk.jpg'),
('NV03', 'Shin', 'Peniel', '10/03/1993', 'Nam', 'USA', '10031993', 'CV01', 'Peniel.jpg'),
('NV04', 'Jung', 'Ilhoon', '04/10/1994', 'Nam', 'South Korea', '04101994', 'CV01', 'Ilhoon.jpg'),
('NV05', 'Lee', 'Changsub', '26/02/1991', 'Nam', 'South Korea', '26021991', 'CV01', 'Changsub.jpg'),
('NV06', 'Yook', 'Sungjae', '02/05/1995', 'Nam', 'South Korea', '02051995', 'CV01', 'Sungjae.jpg'),
('NV07', 'Im', 'Hyunsik', '07/03/1992', 'Nam', 'South Korea', '07031992', 'CV01', 'Hyunsik.jpg'),
('NV08', 'Kim', 'Dami', '09/04/1995', 'Nữ', 'South Korea', '09041995', 'CV01', 'Dami.jpg'),
('NV09', 'Choi', 'Woosik', '26/03/1990', 'Nam', 'South Korea', '26031990', 'CV01', 'Woosik.jpg'),
('NV10', 'Roh', 'Jeongeui', '31/07/2001', 'Nữ', 'South Korea', '31072001', 'CV01', 'Jeongeui.jpg'),
('NV11', 'Kim', 'Sungcheol', '31/12/1991', 'Nam', 'South Korea', '31121991', 'CV01', 'Sungcheol.jpg'),
('NV12', 'Trần Thùy', 'Chi', '04/05/1990', 'Nữ', 'Vietnam', '04051990', 'CV01', 'Chi.jpg'),
('NV13', 'Chi', 'Pu', '14/06/1993', 'Nữ', 'Vietnam', '14061993', 'CV01', 'Pu.jpg'),
('NV14', 'Jeon', 'Soyeon', '26/08/1998', 'Nữ', 'South Korea', '26081998', 'CV01', 'Soyeon.jpg'),
('NV15', 'Cho', 'Miyeon', '31/01/1997', 'Nữ', 'South Korea', '31011997', 'CV01', 'Miyeon.jpg'),
('NV16', 'Yontararak', 'Minnie', '23/10/1997', 'Nữ', 'Thailand', '23101997', 'CV01', 'Minnie.jpg'),
('NV17', 'Song', 'Yuqi', '23/09/1999', 'Nữ', 'China', '23091999', 'CV01', 'Yuqi.jpg'),
('NV18', 'Yeh', 'Shuhua', '06/01/2000', 'Nữ', 'Taiwan', '06012000', 'CV01', 'Shuhua.jpg'),
('NV20', 'Yook', 'Sungjae', '12/10/1995', 'Nam', 'North Korea', '12101995', 'CV04', 'null');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPN` varchar(15) NOT NULL,
  `MaNCC` varchar(15) NOT NULL,
  `MaNV` varchar(15) NOT NULL,
  `NgayLap` date NOT NULL,
  `TongTien` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`MaPN`, `MaNCC`, `MaNV`, `NgayLap`, `TongTien`) VALUES
('PN01', 'NCC02', 'NV04', '2023-04-12', 13417950);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `MaPX` varchar(15) NOT NULL,
  `MaNV` varchar(15) NOT NULL,
  `NgayLap` date NOT NULL,
  `TongTien` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSP` varchar(20) NOT NULL,
  `TenSP` varchar(100) NOT NULL,
  `SoLuong` int(20) NOT NULL,
  `DonGia` int(20) NOT NULL,
  `DonViTinh` varchar(20) NOT NULL,
  `MaLoai` varchar(20) NOT NULL,
  `IMG` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MaSP`, `TenSP`, `SoLuong`, `DonGia`, `DonViTinh`, `MaLoai`, `IMG`) VALUES
('SP01', 'Siêu Xe Porsche 963', 0, 799000, 'Cái', 'L01', 'null'),
('SP02', 'Siêu Xe Pagani Utopia', 0, 799000, 'Cái', 'L01', 'null'),
('SP03', 'Xe Mô Tô Cổ Điển', 0, 469000, 'Cái', 'L01', 'null'),
('SP04', 'Bộ Gạch Sáng Tạo Neon Vui Nhộn', 0, 433000, 'Cái', 'L01', 'null'),
('SP05', 'Bộ Gạch Sáng Tạo Pastel Dễ Thương', 0, 619000, 'Bộ', 'L01', 'null'),
('SP06', 'Siêu Xe Của Người Nhện', 0, 309000, 'Chiếc', 'L01', 'null'),
('SP07', 'Combo 2 mô hình nhân vật MOBILITY JOINT GUNDAM VOL', 0, 479000, 'Chiếc', 'L01', 'null'),
('SP08', 'Bộ làm bếp 3 món mini Hồng', 0, 559000, 'Cái', 'L05', 'null'),
('SP09', 'Bộ nồi lẩu điện mini Xanh dương', 0, 399000, 'Cái', 'L05', 'null'),
('SP10', 'Set bánh vui vẻ 28 chi tiết ', 0, 314000, 'Bộ', 'L05', 'null'),
('SP11', 'Trung tâm thương mại hiện đại', 0, 2000000, 'Bộ', 'L05', 'null'),
('SP12', 'Xe chở xăng MAN TGS', 0, 2200000, 'Cái', 'L02', 'null'),
('SP13', 'Đồ chơi mô hình tỷ lệ 1:16 xe chở hàng DHL ', 0, 1800000, 'Cái', 'L02', 'null'),
('SP14', 'Đồ chơi búp bê thời trang tóc đỏ ', 0, 258000, 'Cái', 'L04', 'null'),
('SP15', 'Đồ chơi búp bê thời trang jumpsuit xanh dạo phố ', 0, 258000, 'Cái', 'L04', 'null'),
('SP16', 'Bộ đồ chơi búp bê đi picnic cùng thú cưng ', 0, 700000, 'Cái', 'L04', 'null'),
('SP17', 'Đồ chơi búp bê nam thời trang áo xám ', 0, 369000, 'Cái', 'L04', 'null'),
('SP18', 'Sư tử Leo lười ', 0, 567000, 'Cái', 'L06', 'null'),
('SP19', 'Gấu Lizzie tinh nghịch ', 0, 495000, 'Con', 'L06', 'null'),
('SP20', 'Gấu Bobbie tinh nghịch ', 0, 495000, 'Con', 'L06', 'null');

--
-- Bẫy `sanpham`
--
DELIMITER $$
CREATE TRIGGER `trg_add_product_to_kho` AFTER INSERT ON `sanpham` FOR EACH ROW BEGIN
    INSERT INTO Kho(MaSP, TenSP, SoLuong, GiaNhap, DonViTinh, MaLoai, IMG)
    VALUES (NEW.MaSP, NEW.TenSP, NEW.SoLuong, NEW.DonGia * 1.05, NEW.DonViTinh, NEW.MaLoai, NEW.IMG);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MaNV` char(20) NOT NULL,
  `TenDangNhap` char(30) NOT NULL,
  `MatKhau` char(20) NOT NULL,
  `PhanQuyen` char(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`MaNV`, `TenDangNhap`, `MatKhau`, `PhanQuyen`) VALUES
('NV01', 'admin', '123', 'CV01'),
('NV02', 'admin1', '123456', 'CV02'),
('NV03', 'admin12345', '123456', 'CV03'),
('NV04', 'nv04', '123', 'CV04');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chucvu`
--
ALTER TABLE `chucvu`
  ADD PRIMARY KEY (`MaCV`);

--
-- Chỉ mục cho bảng `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD PRIMARY KEY (`MaHD`,`MaSP`);

--
-- Chỉ mục cho bảng `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD PRIMARY KEY (`MaPN`,`MaSP`);

--
-- Chỉ mục cho bảng `ctphieuxuat`
--
ALTER TABLE `ctphieuxuat`
  ADD PRIMARY KEY (`MaPX`,`MaSP`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Chỉ mục cho bảng `kho`
--
ALTER TABLE `kho`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `FK_KHO_LOAI` (`MaLoai`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`MaKM`);

--
-- Chỉ mục cho bảng `loai`
--
ALTER TABLE `loai`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`),
  ADD KEY `FK_NHANVIEN_CHUCVU` (`MaCV`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPN`),
  ADD KEY `FK_PHIEUNHAP_NHACUNGCAP` (`MaNCC`),
  ADD KEY `FK_PHIEUNHAP_NHANVIEN` (`MaNV`);

--
-- Chỉ mục cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`MaPX`),
  ADD KEY `FK_PHIEUXUAT_NHANVIEN` (`MaNV`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `FK_SANPHAM_LOAI` (`MaLoai`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`TenDangNhap`),
  ADD KEY `FK_TAIKHOAN_NHANVIEN` (`MaNV`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `kho`
--
ALTER TABLE `kho`
  ADD CONSTRAINT `FK_KHO_LOAI` FOREIGN KEY (`MaLoai`) REFERENCES `loai` (`MaLoai`);

--
-- Các ràng buộc cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `FK_NHANVIEN_CHUCVU` FOREIGN KEY (`MaCV`) REFERENCES `chucvu` (`MaCV`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `FK_PHIEUNHAP_NHACUNGCAP` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`),
  ADD CONSTRAINT `FK_PHIEUNHAP_NHANVIEN` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`);

--
-- Các ràng buộc cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `FK_PHIEUXUAT_NHANVIEN` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `FK_SANPHAM_LOAI` FOREIGN KEY (`MaLoai`) REFERENCES `loai` (`MaLoai`);

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `FK_TAIKHOAN_NHANVIEN` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
