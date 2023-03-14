-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 14, 2023 lúc 05:11 PM
-- Phiên bản máy phục vụ: 10.4.25-MariaDB
-- Phiên bản PHP: 7.4.30

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
  `MaCV` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenCV` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
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
  `MaHD` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaSP` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenSP` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuong` int(20) NOT NULL,
  `DonGia` int(20) NOT NULL,
  `ThanhTien` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `cthoadon`
--

INSERT INTO `cthoadon` (`MaHD`, `MaSP`, `TenSP`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES
('HD12', 'SP05', 'Bàn làm việc Pio', 1, 13650000, 13650000),
('HD13', 'SP03', 'Bàn làm việc Osaka', 4, 22900000, 91600000),
('HD13', 'SP04', 'Bàn làm việc Osaka KA', 3, 48900000, 146700000),
('HD13', 'SP05', 'Bàn làm việc Pio', 4, 13650000, 54600000),
('HD14', 'SP01', 'Bàn làm việc Finn 260011', 7, 22900000, 160300000),
('HD14', 'SP02', 'Bàn làm việc Maxine', 2, 51940000, 103880000),
('HD14', 'SP03', 'Bàn làm việc Osaka', 3, 22900000, 68700000),
('HD14', 'SP04', 'Bàn làm việc Osaka KA', 3, 48900000, 146700000),
('HD14', 'SP05', 'Bàn làm việc Pio', 5, 13650000, 68250000),
('HD15', 'SP01', 'Bàn làm việc Finn 260011', 5, 22900000, 114500000),
('HD16', 'SP01', 'Bàn làm việc Finn 260011', 1, 22900000, 22900000),
('HD17', 'SP02', 'Bàn làm việc Maxine', 9, 51940000, 467460000),
('HD17', 'SP04', 'Bàn làm việc Osaka KA', 3, 48900000, 146700000),
('HD17', 'SP05', 'Bàn làm việc Pio', 3, 13650000, 40950000),
('HD18', 'SP03', 'Bàn làm việc Osaka', 2, 22900000, 45800000),
('HD19', 'SP04', 'Bàn làm việc Osaka KA', 5, 48900000, 244500000),
('HD19', 'SP05', 'Bàn làm việc Pio', 8, 13650000, 109200000),
('HD20', 'SP02', 'Bàn làm việc Maxine', 5, 51940000, 259700000),
('HD20', 'SP03', 'Bàn làm việc Osaka', 3, 22900000, 68700000),
('HD21', 'SP05', 'Bàn làm việc Pio', 4, 13650000, 54600000),
('HD22', 'SP05', 'Bàn làm việc Pio', 1, 13650000, 13650000),
('HD23', 'SP04', 'Bàn làm việc Osaka KA', 1, 48900000, 48900000),
('HD26', 'SP01', 'Bàn làm việc Finn 260011', 4, 250000, 1000000),
('HD27', 'SP04', 'Bàn làm việc Osaka KA', 3, 365000, 1095000),
('HD28', 'SP02', 'Bàn làm việc Maxine', 5, 300000, 1500000),
('HD29', 'SP01', 'Bàn làm việc Finn 260011', 5, 250000, 1250000),
('HD29', 'SP02', 'Bàn làm việc Maxine', 6, 300000, 1800000),
('HD30', 'SP01', 'Bàn làm việc Finn 260011', 4, 250000, 1000000),
('HD30', 'SP04', 'Bàn làm việc Osaka KA', 5, 365000, 1825000),
('HD31', 'SP02', 'Bàn làm việc Maxine', 2, 300000, 600000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `MaPN` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaSP` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenSP` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuong` int(20) NOT NULL,
  `DonGia` int(20) NOT NULL,
  `ThanhTien` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctphieunhap`
--

INSERT INTO `ctphieunhap` (`MaPN`, `MaSP`, `TenSP`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES
('PN05', 'SP01', 'Bàn làm việc Finn 260011', 2, 100000, 200000),
('PN07', 'SP03', 'Bàn làm việc Osaka', 3, 230000, 690000),
('PN08', 'SP02', 'Bàn làm việc Maxine', 1, 150000, 150000),
('PN09', 'SP02', 'Bàn làm việc Maxine', 2, 150000, 300000),
('PN10', 'SP04', 'Bàn làm việc Osaka KA', 2, 250000, 500000),
('PN11', 'SP03', 'Bàn làm việc Osaka', 4, 230000, 920000),
('PN11', 'SP04', 'Bàn làm việc Osaka KA', 3, 250000, 750000),
('PN12', 'SP02', 'Bàn làm việc Maxine', 1, 150000, 150000),
('PN12', 'SP04', 'Bàn làm việc Osaka KA', 4, 250000, 1000000),
('PN13', 'SP02', 'Bàn làm việc Maxine', 4, 150000, 600000),
('PN13', 'SP03', 'Bàn làm việc Osaka', 4, 230000, 920000),
('PN14', 'SP05', 'Bàn làm việc Pio', 5, 186000, 930000),
('PN15', 'SP04', 'Bàn làm việc Osaka KA', 1, 250000, 250000),
('PN16', 'SP04', 'Bàn làm việc Osaka KA', 5, 250000, 1250000),
('PN17', 'SP02', 'Bàn làm việc Maxine', 2, 150000, 300000),
('PN18', 'SP04', 'Bàn làm việc Osaka KA', 6, 250000, 1500000),
('PN18', 'SP05', 'Bàn làm việc Pio', 3, 186000, 558000),
('PN19', 'SP04', 'Bàn làm việc Osaka KA', 5, 250000, 1250000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctphieuxuat`
--

CREATE TABLE `ctphieuxuat` (
  `MaPX` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaSP` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenSP` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuong` int(20) NOT NULL,
  `DonGia` int(20) NOT NULL,
  `ThanhTien` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ctphieuxuat`
--

INSERT INTO `ctphieuxuat` (`MaPX`, `MaSP`, `TenSP`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES
('PX02', 'SP04', 'Bàn làm việc Osaka KA', 3, 365000, 1095000),
('PX03', 'SP05', 'Bàn làm việc Pio', 3, 300000, 900000),
('PX04', 'SP01', 'Bàn làm việc Finn 260011', 2, 250000, 500000),
('PX05', 'SP04', 'Bàn làm việc Osaka KA', 5, 365000, 1825000),
('PX06', 'SP02', 'Bàn làm việc Maxine', 3, 300000, 900000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaKH` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `MaNV` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `NgayLap` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `TongTien` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `MaKH`, `MaNV`, `NgayLap`, `TongTien`) VALUES
('HD01', 'KH02', 'NV04', '10/11/2022', 250200000),
('HD02', 'KH01', 'NV01', '10/11/2022', 195600000),
('HD03', 'KH03', 'NV03', '10/11/2022', 68250000),
('HD04', 'HD04', 'NV03', '10/11/2022', 195600000),
('HD05', 'KH05', 'NV05', '10/11/2022', 293400000),
('HD06', 'KH06', 'NV06', '10/11/2022', 27300000),
('HD07', 'KH07', 'NV07', '10/11/2022', 97800000),
('HD08', 'KM08', 'NV08', '10/11/2022', 13650000),
('HD09', 'KH09', 'NV09', '10/11/2022', 48900000),
('HD10', 'KH10', 'NV10', '10/11/2022', 13650000),
('HD11', 'KH11', 'NV11', '10/11/2022', 13650000),
('HD12', 'KH12', 'NV12', '10/11/2022', 13650000),
('HD13', 'KH13', 'NV13', '10/11/2022', 292900000),
('HD14', 'KH14', 'NV14', '12/11/2022', 547830000),
('HD15', 'KH15', 'NV15', '12/11/2022', 114500000),
('HD16', 'KH16', 'NV16', '12/11/2022', 22900000),
('HD17', 'KH17', 'NV17', '12/11/2022', 655110000),
('HD18', 'KH18', 'NV18', '15/11/2022', 45800000),
('HD19', 'KH11', 'NV11', '15/11/2022', 353700000),
('HD20', 'KH20', 'NV20', '15/11/2022', 328400000),
('HD21', 'KH01', 'NV09', '17/11/2022', 54600000),
('HD22', 'KH22', 'NV17', '17/11/2022', 108800),
('HD23', 'KH23', 'NV04', '17/11/2022', 342300),
('HD24', 'KH01', 'NV01', '08/11/2022', 2002000),
('HD25', 'KH25', 'NV25', '10/12/2022', 840000),
('HD26', 'KH26', 'NV26', '10/12/2022', 800000),
('HD27', 'KH03', 'NV03', '11/12/2022', 876000),
('HD28', 'KH13', 'NV13', '12/12/2022', 1050000),
('HD29', 'KH10', 'NV10', '12/12/2022', 2135000),
('HD30', 'KH10', 'NV05', '03/03/2023', 2260000),
('HD31', '111', '111', '03/03/2023', 420000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Ho` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Ten` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgaySinh` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `GioiTinh` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DiaChi` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoDT` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `IMG` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `kho`
--

CREATE TABLE `kho` (
  `MaSP` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenSP` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `GiaNhap` int(11) NOT NULL,
  `DonViTinh` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaLoai` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `IMG` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `kho`
--

INSERT INTO `kho` (`MaSP`, `TenSP`, `SoLuong`, `GiaNhap`, `DonViTinh`, `MaLoai`, `IMG`) VALUES
('SP01', 'Bàn làm việc Finn 260011', 9, 100000, 'Cái', 'L01', ''),
('SP02', 'Bàn làm việc Maxine', 7, 150000, 'Cái', '', 'SP02.jpg'),
('SP03', 'Bàn làm việc Osaka', -1, 230000, 'Cái', '', ''),
('SP04', 'Bàn làm việc Osaka KA', 5, 250000, 'Cái', '', ''),
('SP05', 'Bàn làm việc Pio', 0, 186000, 'Cái', '', 'null');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MaKM` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenKM` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
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
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNCC` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenNCC` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DiaChi` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoDT` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `DiaChi`, `SoDT`) VALUES
('NCC01', 'Phố Xinh', '273 ADV, Vietnam', '0814099714');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Ho` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Ten` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgaySinh` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `GioiTinh` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DiaChi` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoDT` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaCV` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `IMG` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
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
('NV19', 'Đ', 'Đ', '02/05/1991', 'Nam', 'D', '072', 'CV04', 'null'),
('NV20', 'Yook', 'Sungjae', '12/10/1995', 'Nam', 'North Korea', '12101995', 'CV04', 'null');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPN` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNCC` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNV` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayLap` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TongTien` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`MaPN`, `MaNCC`, `MaNV`, `NgayLap`, `TongTien`) VALUES
('PN01', 'NCC01', 'NV01', '20/11/2022', 100000),
('PN02', 'NCC02', 'NV02', '20/11/2022', 1000000),
('PN03', 'NCC03', 'NV03', '20/11/2022', 460000),
('PN04', 'NCC04', 'NV04', '20/11/2022', 372000),
('PN05', 'NCC05', 'NV05', '20/11/2022', 200000),
('PN06', 'NCC06', 'NV06', '20/11/2022', 600000),
('PN07', 'NC007', 'NV07', '20/11/2022', 690000),
('PN08', 'NCC08', 'NV08', '20/11/2022', 350000),
('PN09', 'NCC09', 'NV09', '20/11/2022', 760000),
('PN10', 'NCC10', 'NV10', '20/11/2022', 872000),
('PN11', 'NCC11', 'NV11', '20/11/2022', 1670000),
('PN12', 'NCC12', 'NV12', '21/11/2022', 1150000),
('PN13', 'NCC13', 'NV13', '22/11/2022', 1520000),
('PN14', 'NCC14', 'NV14', '22/11/2022', 930000),
('PN15', 'NCC15', 'NV15', '27/11/2022', 250000),
('PN16', 'NCC', '16', '10/12/2022', 1250000),
('PN17', 'NCC01', 'NV15', '11/12/2022', 300000),
('PN18', 'NCC12', 'NV01', '12/12/2022', 2058000),
('PN19', 'NCC11', 'NV01', '03/03/2023', 1250000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `MaPX` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNV` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayLap` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TongTien` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuxuat`
--

INSERT INTO `phieuxuat` (`MaPX`, `MaNV`, `NgayLap`, `TongTien`) VALUES
('PX01', 'NV01', '22/11/2022', 365000),
('PX02', 'NV02', '23/11/2022', 1095000),
('PX03', 'NV03', '27/11/2022', 900000),
('PX04', 'NV04', '27/11/2022', 500000),
('PX05', 'NV05', '10/12/2022', 1825000),
('PX06', 'NV07', '11/12/2022', 900000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MaSP` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenSP` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoLuong` int(20) NOT NULL,
  `DonGia` int(20) NOT NULL,
  `DonViTinh` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaLoai` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `IMG` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MaSP`, `TenSP`, `SoLuong`, `DonGia`, `DonViTinh`, `MaLoai`, `IMG`) VALUES
('SP01', 'Bàn làm việc Finn 260011', 0, 250000, 'Cái', '', ''),
('SP02', 'Bàn làm việc Maxine', 0, 300000, 'Cái', '', 'SP02.jpg'),
('SP03', 'Bàn làm việc Osaka', 0, 350000, 'Cái', '', ''),
('SP04', 'Bàn làm việc Osaka KA', 6, 365000, 'Cái', '', ''),
('SP05', 'Bàn làm việc Pio', 6, 300000, 'Cái', '', 'null');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MaNV` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenDangNhap` char(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MatKhau` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `PhanQuyen` char(25) COLLATE utf8mb4_unicode_ci NOT NULL
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
  ADD PRIMARY KEY (`MaSP`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`MaKM`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPN`);

--
-- Chỉ mục cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`MaPX`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaSP`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`TenDangNhap`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
