-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 29, 2022 lúc 06:08 PM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Cơ sở dữ liệu: `dblinhkien`
--
CREATE DATABASE IF NOT EXISTS `dblinhkien` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `dblinhkien`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

DROP TABLE IF EXISTS `chitiethoadon`;
CREATE TABLE IF NOT EXISTS `chitiethoadon` (
  `MAHD` int(11) NOT NULL,
  `MALINHKIEN` int(11) NOT NULL,
  `DONGIA` bigint(20) DEFAULT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `TONGITEN` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`MAHD`,`MALINHKIEN`),
  KEY `FK_CHITIETHOADON_SANPHAM` (`MALINHKIEN`),
  KEY `FK_CHITIETHOADON_HD` (`MAHD`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `chitiethoadon`:
--   `MALINHKIEN`
--       `linhkien` -> `MALINHKIEN`
--   `MAHD`
--       `hoadon` -> `MAHD`
--   `MAHD`
--       `hoadon` -> `MAHD`
--   `MAHD`
--       `hoadon` -> `MAHD`
--   `MAHD`
--       `hoadon` -> `MAHD`
--

--
-- Đang đổ dữ liệu cho bảng `chitiethoadon`
--

INSERT INTO `chitiethoadon` VALUES
(58, 2, 30000000, 100, 3000000000),
(58, 4, 10000000, 100, 1000000000),
(59, 3, 15490000, 1, 15490000),
(60, 5, 20990000, 6, 125940000),
(61, 6, 10000000, 1, 10000000),
(61, 89, 14490000, 1, 14490000),
(62, 3, 15490000, 3, 46470000),
(62, 41, 14490000, 18, 260820000),
(62, 69, 3000000, 1, 3000000),
(63, 1, 21990000, 1, 21990000),
(63, 63, 790000, 3, 2370000),
(64, 1, 21990000, 1, 21990000),
(64, 63, 790000, 3, 2370000);

--
-- Bẫy `chitiethoadon`
--
DROP TRIGGER IF EXISTS `trg_chitiethoadon`;
DELIMITER $$
CREATE TRIGGER `trg_chitiethoadon` BEFORE INSERT ON `chitiethoadon` FOR EACH ROW UPDATE linhkien SET SOLUONG = SOLUONG - new.SOLUONG 
    WHERE MALINHKIEN = new.MALINHKIEN
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
CREATE TABLE IF NOT EXISTS `hoadon` (
  `MAHD` int(11) NOT NULL AUTO_INCREMENT,
  `MAKH` varchar(10) DEFAULT NULL,
  `TONGTIEN` bigint(20) DEFAULT NULL,
  `NGAYLAPHOADON` date DEFAULT NULL,
  PRIMARY KEY (`MAHD`),
  KEY `FK_HOADON_KHACHHANG` (`MAKH`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `hoadon`:
--   `MAKH`
--       `khachhang` -> `USERNAME`
--   `MAKH`
--       `khachhang` -> `USERNAME`
--

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` VALUES
(58, 'hi', 4000000000, '2022-05-29'),
(59, 'hi', 15490000, '2022-05-29'),
(60, 'dongduy', 125940000, '2022-05-29'),
(61, 'dongduy', 24490000, '2022-05-29'),
(62, 'dongduy', 310290000, '2022-05-29'),
(63, 'dongduy', 24360000, '2022-05-29'),
(64, 'dongduy', 24360000, '2022-05-29');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE IF NOT EXISTS `khachhang` (
  `USERNAME` varchar(10) NOT NULL,
  `TENKH` varchar(100) DEFAULT NULL,
  `MATKHAU` varchar(100) DEFAULT NULL,
  `DIACHI` varchar(100) DEFAULT NULL,
  `SODT` int(11) DEFAULT NULL,
  `HINHANH` char(100) DEFAULT NULL,
  PRIMARY KEY (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `khachhang`:
--

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` VALUES
('dongduy', 'Dương Đông Duy', '5dc6da3adfe8ccf1287a98c0a8f74496', 'Tiền Giangss', 376880903, 'BIDV_16516429093691653802724023.jpg'),
('ducduy', 'Hồ Đức Duy', '827ccb0eea8a706c4c34a16891f84e7b', 'Cần Thơ', 703337662, 'staff.png'),
('duy', 'Dương Đông Duy', '827ccb0eea8a706c4c34a16891f84e7b', 'Tiền Giang', 376880903, 'FB_IMG_16534432551141653744012257.jpg'),
('duynghia', 'Dương Duy Nghĩa', '211b461416eaa21318ac809d050ce371', 'Tiền Giang province ', 988322241, 'staff.png'),
('haha', 'a', 'f3c2cefc1f3b082a56f52902484ca511', 'a', 0, ''),
('hi', 'dương đông duy', '49f68a5c8493ec2c0bf489821c21fc3b', 'tiền giang', 0, 'received_4614633723120461653755013471.jpeg'),
('limminh', 'Lim Bảo Minh', '827ccb0eea8a706c4c34a16891f84e7b', 'TP.HCM', 703337662, 'staff.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `linhkien`
--

DROP TABLE IF EXISTS `linhkien`;
CREATE TABLE IF NOT EXISTS `linhkien` (
  `MALINHKIEN` int(11) NOT NULL AUTO_INCREMENT,
  `TENLINHKIEN` varchar(200) DEFAULT NULL,
  `GIATIEN` bigint(20) DEFAULT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `GIATIENKHUYENMAI` bigint(20) DEFAULT NULL,
  `MOTA` varchar(500) DEFAULT NULL,
  `HINHANH` varchar(100) DEFAULT NULL,
  `NGAYCAPNHAT` date DEFAULT NULL,
  `MALLINHKIEN` int(11) DEFAULT NULL,
  PRIMARY KEY (`MALINHKIEN`),
  KEY `FK_LINHKIEN_LOAILINHKIEN` (`MALLINHKIEN`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `linhkien`:
--   `MALLINHKIEN`
--       `loailinhkien` -> `MALLINHKIEN`
--

--
-- Đang đổ dữ liệu cho bảng `linhkien`
--

INSERT INTO `linhkien` VALUES
(1, 'ASUS ROG STRIX G G512 IAL013T', 21990000, 43, 0, 'Laptop Asus Gaming ROG Strix G512 i5 (IAL013T) mang đến ngôn ngữ thiết kế hiện đại, cấu hình mạnh mẽ với vi xử lí gen 10 mới, card đồ họa rời GeForce GTX 1650Ti, chiến những tựa game nặng kí nhất.', 'imagelp1.jpg', '2022-05-25', 1),
(2, 'MACBOOK PRO 13 2020 Z11B000CT', 36990000, 0, 30000000, 'Apple trang bị cho MacBook Pro 2020 chip bảo mật T2 mã hóa dữ liệu ổ cứng cùng với cảm biến vân tay nhỏ gọn được tích hợp giúp bạn có thể mở máy nhanh chóng, không cần mất thời gian nhập mật mã, thanh toán trực tuyến dễ dàng.', 'imagelp2.jpg', '2022-05-25', 1),
(3, 'ACER ASPIRE 3 A315 57G 524Z', 15490000, 96, 0, 'Card đồ họa rời NVIDIA GeForce MX330 mạnh mẽ xử lý tốt tác vụ đồ họa. Màn hình 15.6 inch Full HD hiển thị hình ảnh sắc nét, màu sắc chân thực', 'imagelp3.jpg', '2022-05-25', 1),
(4, 'ASUS VIVOBOOK D515UA Ẹ045T', 13490000, 0, 10000000, 'Chiếc máy trang bị bộ vi xử lý Intel Core i3 thế hệ 10, với 4 GB RAM kèm ổ cứng 128 GB chuẩn SSD sẽ mang lại hiệu năng vượt trội để giúp bạn yên tâm xử lý công việc lẫn giải trí thoải mái.', 'imagelp4.jpg', '2022-05-25', 1),
(5, 'MSI MODERN 14 B11MO 011VN', 20990000, 94, 0, 'Được đánh giá là mẫu laptop có hiệu năng cực cao khi trang bị CPU Intel 11th với chất liệu vỏ nhôm nguyên khối toàn bộ và thiết kế sang trọng, nhỏ gọn tăng tính cơ động và có thời lượng pin dài sẽ rất phù hợp với Nhân viên văn phòng, Học sinh và sinh, giới trẻ đam mê sáng tạo, thích sự năng động.', 'imagelp5.jpg', '2022-05-25', 1),
(6, 'LENOVO IDEAPAD	SLIM 3 14IIL05 81WD00VJVN', 10490000, 99, 10000000, 'Intel Core i3-1005G1 (1.20GHz up to 3.40GHz, 4MB Cache) 14.0 inch FHD (1920x1080) TN 220nits Anti-glare, 60Hz', 'imagelp6.jpg', '2022-05-25', 1),
(7, 'ASUS H410M-E', 1865000, 100, 0, 'Socket: Socket 1200 hỗ trợ CPU intel thế hệ 10. Kích thước: m-ATX. Khe cắm RAM: 2 khe (Tối đa 64GB)', 'imagemb1.jpg', '2022-05-25', 2),
(8, 'GIGABYTE B460M GAMING HD', 1990000, 100, 1000000, 'Intel® B460 Gaming Motherboard with GIGABYTE 8118 Gaming LAN, PCIe Gen3 x4 M.2, Anti-Sulfur Resistor, Smart Fan 5', 'imagemb2.jpg', '2022-05-25', 2),
(9, 'ASUS H410M-CS', 1810000, 100, 0, 'Socket Intel® LGA 1200: Sẵn sàng cho bộ xử lý Intel® Core ™ thế hệ thứ 10. Bảo vệ 5X III: Bảo vệ nhiều phần cứng để bảo vệ toàn diện', 'imagemb3.jpg', '2022-05-25', 2),
(10, 'MSI MAG B365M MORTAR', 2390000, 100, 0, 'Military style with Extended heatsink design for better thermal solution, Intel Gaming LAN, Pre-installed I/O Shielding, Core Boost, DDR4 Boost, Turbo M.2 and USB 3.1 connector', 'imagemb4.jpg', '2022-05-25', 2),
(11, 'GIGABYTE B365M GAMING HD', 1750000, 100, 1000000, 'Intel B365 Gaming motherboard with GIGABYTE 8118 Gaming LAN, PCIe Gen3 x4 M.2, Anti-Sulfur Resistor, Smart Fan 5, CEC 2019', 'imagemb5.jpg', '2022-05-25', 2),
(12, 'GIGABYTE Z390 GAMING X', 4090000, 100, 4000000, 'Intel Z390 GAMING Motherboard with 10+2 Digital PWM Design, 2-Way CrossFire™ Multi-Graphics, USB 3.1 Gen2 Type-A, M.2 Thermal Guard, Intel GbE LAN with cFosSpeed, Smart Fan 5, Dual M.2, Dual Armor with Ultra Durable™ Technology, DualBIOS, CEC 2019', 'imagemb6.jpg', '2022-05-25', 2),
(13, 'AMD Ryzen 7 3700x', 8490000, 100, 0, 'Dominant Gaming and Streaming. A beautifully balanced design for serious PC enthusiasts', 'imagecp1.jpg', '2022-05-25', 3),
(14, 'AMD Ryzen 9 5900X', 15290000, 100, 0, 'The World’s Best Gaming Processor.12 cores to power through gaming, streaming and more.', 'imagecp2.jpg', '2022-05-25', 3),
(15, 'AMD Ryzen Threadripper PRO', 72000000, 100, 70000000, 'Design. Build. Accelerate. On The Ultimate Workstation Processor', 'imagecp3.jpg', '2022-05-25', 3),
(16, 'AMD Ryzen 5 2600', 5050000, 100, 0, 'Highest Multiprocessing Performance in Its Class for Gamers and Creators1', 'imagecp4.jpg', '2022-05-25', 3),
(17, 'Intel Celeron G4900', 1150000, 100, 1000000, 'Socket: LGA 1151-v2 , Intel Celeron G. Tốc độ xử lý: 3.1 GHz ( 2 nhân, 2 luồng). Bộ nhớ đệm: 2MB.Đồ họa tích hợp: Intel UHD Graphics 610', 'imagecp5.jpg', '2022-05-25', 3),
(18, 'Adata Value Value 4GB', 550000, 100, 500000, 'Ram Adata Value 4GB DDR4 2666 (AD4U2666J4G19-S) được sản xuất bởi công ty ADATA - là một trong những công ty đứng đầu trong ngành sản xuất, thiết kế bộ nhớ và ổ cứng kho dữ liệu trên thế giói được thành lập vào tháng 5 năm 2001.', 'imagera1.jpg', '2022-05-25', 4),
(19, 'Gigabyte Memory 2666', 1190000, 100, 0, 'MOTMemory Size: 8GB.Frequency:DDR4-2666 MHz.Timing:16-16-16-35. Voltage:1.2V. 100% Sorted & Tested. High efficient classic black heat spreaders. Profile: XMP 2.0A', 'imagera2.jpg', '2022-05-25', 4),
(20, 'G.SKILL Ripjaws V', 1190000, 100, 1000000, 'Designed for performance, G.SKILL desktop memory is engineered from hand-selected components and rigorously tested for stability and compatibility.', 'imagera3.jpg', '2022-05-25', 4),
(21, 'G.SKILL Trident Z RGB', 2890000, 100, 0, 'Featuring a completely exposed light bar with vibrant RGB LEDs, merged with the award-winning Trident Z heatspreader designed, and constructed with the highest quality components.', 'imagera4.jpg', '2022-05-25', 4),
(22, 'G.SKILL Z Neo', 4390000, 100, 4000000, 'Engineered and optimized for full compatibility on the latest AMD Ryzen platforms, Trident Z Neo brings unparalleled memory performance and vibrant RGB lighting to any gaming PC or workstation', 'imagera5.jpg', '2022-05-25', 4),
(23, 'Corsair Vengeance RGB PRO', 11990000, 100, 11000000, 'Năng động đa Zone RGB chiếu sáng 2. thế hệ tiếp theo phần mềm 3. Tùy chỉnh hiệu suất PCB 4. chặt chẽ chiếu bộ nhớ. Băng thông tối đa.', 'imagera6.jpg', '2022-05-25', 4),
(24, 'MSI GeForce RTX 3090 SUPRIM X 24G', 75990000, 100, 0, 'There is more than meets the eye. Heatpipes beneath the sturdy brushed-finish metal backplate provide additional cooling for the memory modules on the rear of the PCB.succed', 'imagevg1.jpg', '2022-05-25', 5),
(25, 'MSI Geforce RTX 3090 GAMING X TRIO 24G', 72990000, 100, 72000000, 'TORX FAN 4.0 is built on teamwork, with pairs of fan blades bound together with a linked outer ring design that focuses airflow into the updated TRI FROZR 2 cooling system', 'imagevg2.jpg', '2022-05-25', 5),
(26, 'MSI Geforce RTX 3080 SUPRIM X 10G', 60990000, 100, 60000000, 'NVIDIA DLSS là công nghệ kết xuất đột phá nhờ sự hỗ trợ của trí tuệ nhân tạo (AI), giúp tăng tốc độ khung hình lên ít nhất 1,5 lần mà chất lượng hình ảnh không bị suy giảm nhờ sức mạnh của Nhân Tensor xử lý AI chuyên dụng trên GeForce RTX 3080.', 'imagevg3.jpg', '2022-05-25', 5),
(27, 'GIGABYTE AORUS Geforce RTX 3070 MASTER 8G', 35990000, 100, 0, 'NVIDIA Ampere Streaming Multiprocessors. 2nd Generation RT Cores. 3rd Generation Tensor Cores', 'imagevg4.jpg', '2022-05-25', 5),
(28, 'GIGABYTE AORUS Radeon RX 6800 MASTER 16G', 31990000, 100, 31000000, 'Boost Clock* : up to 2310 MHz (Reference card: 2250 MHz).Game Clock* : up to 2065 MHz (Reference card: 2015 MHz)', 'imagevg5.jpg', '2022-05-25', 5),
(29, 'ASUS Dual Radeon RX 6700', 22490000, 100, 22000000, 'VGA Asus Dual Radeon RX 6700 XT 12G – 12GB GDDR6 192 Bit là dòng card đồ họa được thiết kế dựa trên bộ vi xử lý đồ họa (GPU) Radeon RX 6700 XT.', 'imagevg4.jpg', '2022-05-25', 5),
(30, 'PNY SSD CS900 240GB 2.5\" Sata 3', 890000, 100, 0, 'MOỔ cứng SSD đã không còn xa lạ gì với những ai thường xuyên sử dụng máy tính, với những tính năng của nó mang lại SSD đã dần thay thế được HDD trong những chiếc laptop hiện nay.TA', 'imagess1.jpg', '2022-05-25', 6),
(31, 'SSD SAMSUNG 980 M.2 PCLe NVMe 250GB', 1990000, 100, 1000000, 'Dung lượng 250GB. Chuẩn giao tiếp PCIe Gen 4.0 x4, NVMe 1.3c. Tốc độ đọc Up to 7,000 MB/s', 'imagess2.jpg', '2022-05-25', 6),
(32, 'SSD SAMSUNG 980 PRO 250GB M.2 NVMe MZ -V8P250BW', 2450000, 100, 2000000, 'Chuẩn SSD: M.2 NVMe Gen3 x4.Tốc độ đọc: 2900 MB/s.Tốc độ ghi: 1300 MB/s', 'imagess3.jpg', '2022-05-25', 6),
(33, 'SSD KINGSTON A2000 1TB M.2 NVMe-SA2000M8/1000G', 3290000, 100, 0, 'Dung lượng: 1TB. Kích thước: M.2 2280. Kết nối: M.2 NVMe. NAND: 3D-NAND', 'imagess4.jpg', '2022-05-25', 6),
(34, 'WD SSD Black SN750 500GB M.2 NVMe PCIe 3470/2600 MB/s', 0, 100, 0, 'Chuẩn SSD: M.2 NVMe Gen3 x4.Tốc độ đọc: 3470 MB/s.Tốc độ ghi: 2600 MB/s', 'imagess5.jpg', '2022-05-25', 6),
(35, 'SSD WD SN850 500GB M.2 PCIe NVMe (Gen 4)', 3690000, 100, 3000000, 'SSD WD SN850 500GB M.2 PCIe NVMe (Gen 4) là một trong những dòng SSD mới nhất đến từ Western Digital mang đến công nghệ tối tân nhất cho PC của bạn để bạn không bị tụt hậu trong thế giới liên tục thay đổi ngày nay.', 'imagess6.jpg', '2022-05-25', 6),
(36, 'HDD WD Blue 1TB 7200rpm', 1050000, 100, 1000000, 'Dung lượng: 1TB.Tốc độ vòng quay: 7200rpm.Bộ nhớ đệm: 64MB Cache.Kích thước: 3.5”.Chuẩn kết nối: SATA 3', 'imagehd1.jpg', '2022-05-25', 7),
(37, 'HDD WD Red 2TB 5400rpm', 2190000, 100, 2000000, 'Dung lượng: 2TB.Tốc độ quay: 5400rpm.Bộ nhớ Cache: 256Mb.Chuẩn giao tiếp: SATA3Kích thước: 3.5Inch', 'imagehd2.jpg', '2022-05-25', 7),
(38, 'HDD WD Black 1TB 7200rpm', 2000000, 100, 0, 'Cho dù bạn là một nhiếp ảnh gia, biên tập video hay nghệ sĩ kỹ thuật số hoặc muốn xây dựng một hệ thống của riêng bạn, thì WD black chính là giải pháp của bạn.', 'imagehd3.jpg', '2022-05-25', 7),
(39, 'WD HDD Black 2TB 7200rpm', 3690000, 100, 3000000, 'Ổ cứng HDD 2TB WD Black WD2003FZEX kích thước 3.5 inch, Sata 3 6Gb/s, 7200RPM, 64MB Cache.', 'imagehd4.jpg', '2022-05-25', 7),
(40, 'HDD Seagate Ironwolf PRO 4TB 7200rpm', 5090000, 100, 0, 'Ổ cứng HDD Seagate Ironwolf Pro 4Tb 7200rpm được thiết kế nhằm phục vụ cho các hệ thống lưu trữ mạng NAS dành cho doanh nghiệp vừa và nhỏ cũng như đám mây cá nhân, hướng đến sự bền bỉ, khả năng mở rộng lưu trữ nhanh chóng cũng như môi trường làm việc liên tục.', 'imagehd5.jpg', '2022-05-25', 7),
(41, 'HDD Seagate Ironwolf PRO 14TB 7200rpm', 14490000, 82, 0, 'Với chất lượng vượt trội và hiệu năng cao. HDD Seagate  là một sự lựa chọn tối ưu khi bạn muốn nâng cấp ổ cứng.Tối ưu hóa cho NAS với AgileArray™ và khả năng phục hồi lỗi giúp cải thiện chất lượng của ổ cứng hoạt động trong dãy RAID.', 'imagehd6.jpg', '2022-05-25', 7),
(42, 'Case XIGMATEK AERO 2F', 690000, 100, 600000, 'Case Xigmatek AERO 2F được xem là sản phẩm có kích thước khá nhỏ gọn chỉ 34.5 x 20 x 39 cm. Tuy nhiên, khả năng chứa đựng của nó là điều không thể bàn cãi, bạn hãy yên tâm rằng thùng máy này sẽ chửa đủ và bảo vệ các thiết bị của bạn an toàn nhất có thể.', 'imagevm1.jpg', '2022-05-25', 8),
(43, 'Case XIGMATEK GAMING X 3FX', 850000, 100, 800000, 'Vỏ case XIGMATEK GAMING X 3FX là thùng máy tính có thiết kế kiểu dáng hiện đại, chắc chắn với khung thép dày 0.5mm và mặt trước dạng lưới (mesh) thoáng khí, đảm bảo nhiệt độ tối ưu cho các linh kiện bên trong. Vách kính cường lực nằm bên trái, thiết kế khung gầm thông gió và luồng không khí cao cấp.', 'imagevm2.jpg', '2022-05-25', 8),
(44, 'Case MSI MAG VAMPIRIC 100R', 1490000, 100, 1400000, 'Dòng MAG VAMPIRIC 100R luôn ở trạng thái cân bằng, nơi mà các chức năng đáp ứng được liền mạch với thiết kế của vỏ case.', 'imagevm3.jpg', '2022-05-25', 8),
(45, 'Case Antec NX800', 1750000, 100, 1700000, 'Antec một công ty chuyên về linh kiện máy tính của Mỹ. Và mới đây Antec vừa cho ra sản phẩm case mới, NX800.', 'imagevm4.jpg', '2022-05-25', 8),
(46, 'Case Xigmatek Aquarius Plus-Black', 2000000, 100, 1900000, 'Case Xigmatek Aquarius đặc biệt đi kèm với nhìn qua bảng mặt trước bằng kính cường lực, nó là một lựa chọn hoàn hảo để hiển thị việc xây dựng hệ thống của bạn sẽ đẹp như thế nào..', 'imagevm5.jpg', '2022-05-25', 8),
(47, 'Case Deepcool CL500 4F', 2190000, 100, 2000000, 'Case Deepcool CL500-4F thiết kế với tấm lưới lớn hút nhiều luồng không khí hơn để đảm bảo hệ thống được làm mát và hoạt động ở mức cao nhất.', 'imagevm6.jpg', '2022-05-25', 8),
(48, '(600W) Nguồn SliverStone ST60F-ES230-80 Plus', 1090000, 100, 0, 'Công suất danh định	600W.Hiệu suất hoạt động 82%~85%.PFC Active PFC.Tuổi thọ sản phẩm 100,000 giờ', 'imageps1.jpg', '2022-05-25', 9),
(49, '(750W) Nguồn CoolerMaster MWE 750 BRONZE-V2 230V', 2090000, 100, 0, 'Công suất tối đa	750 W.Số cổng cắm Non-Modular. Hiệu suất 80 Plus Bronze', 'imageps2.jpg', '2022-05-25', 9),
(50, '(650W) Nguồn Corsair RM650-80 Plus Gold-Full Modular', 2690000, 100, 2000000, 'Công suất tối đa 650 Watts.Chứng nhận 80 Plus Gold.Chuẩn nguồn	ATX', 'imageps3.jpg', '2022-05-25', 9),
(51, '(850W) Nguồn Corsair RM850-80 Plus Gold-Full Modular', 3290000, 100, 3200000, 'Sê-ri RM cung cấp năng lượng với hiệu suất lên tới 90%, giảm mức tiêu thụ năng lượng, tiếng ồn, nhiệt độ và hóa đơn tiền điện của bạn.', 'imageps4.jpg', '2022-05-25', 9),
(52, '(850W) Nguồn Corsair RM850X-80 Plus Gold-Full Modular', 3790000, 100, 3700000, 'Nguồn Máy Tính PSU Corsair CP-9020180-NA Fully Modular 850W 135mm có công suất hoạt động lên đến 850W, đạt chứng nhận 80 Plus Platinum mang đến khả năng cung cấp năng lượng tối ưu đồng thời tiết kiệm điện năng sử dụng.', 'imageps5.jpg', '2022-05-25', 9),
(53, '(1200W)Nguồn Corsair AX1200i-1200 Watt-80 Plus Platinum-Full Modular', 9200000, 100, 9000000, 'The revolutionary AX1200i is the first desktop PC power supply to use digital (DSP) control and CORSAIR iCUE to bring you an unprecedented level of monitoring and performance customization.', 'imageps6.jpg', '2022-05-25', 9),
(54, 'Fan DEEPCOOL CF120-FAN RGB(CF120)', 450000, 100, 0, 'Quạt sử dụng cánh quạt cao cấp, hỗ trợ tản nhiệt một cách hiệu quả. Dễ dàng lắp đặt và hoạt động hiệu quả ở mọi hệ thống máy tính.', 'imagetn1.jpg', '2022-05-25', 10),
(55, 'Tản nhiệt Xigmatek Windpower Pro ARGB', 890000, 100, 800000, 'Là loại tản nhiệt thế hệ mới ra mắt của Xigmatek. Có khả năng tăng hiệu quả làm việc của CPU. Giúp người dùng có trải nghiệm tốt hơn.', 'imagetn2.jpg', '2022-05-25', 10),
(56, 'Fan Cooler Master MASTERFAN MF120 PRISMATIC 3 IN 1', 1550000, 100, 0, '24 bóng LED ARGB được bố trí đồng nhất xung quanh vòng pha lê với 6 bóng LED phụ trên hub quạt. Thiết kế vòng lặp pha lê độc đáo trên cả hai mặt quạt mang lại khả năng tán sắc tối đa trên các bóng LED ARGB.', 'imagetn3.jpg', '2022-05-25', 10),
(57, 'Tản nhiệt Cooler Master MASTERAIR MA610P ARGB', 1750000, 100, 1700000, 'Hai Quạt SickleFlow 120 ARGB.6 Ống Dẫn Nhiệt Đồng Nhất.Hoạt Động Yên Tĩnh', 'imagetn4.jpg', '2022-05-25', 10),
(58, 'Tản nhiệt GIGABYTE AORUS ATC800', 2050000, 100, 2000000, 'Tản nhiệt CPU Gigabyte Aorus ATC800 RGB có Ống đồng trực tiếp 6 x 6mm, tản nhiệt CPU 200W một cách hiệu quả. Quạt RGB 2 bóng 12 x 2cm.', 'imagetn5.jpg', '2022-05-25', 10),
(59, 'Tản nhiệt Deepcool Assassin III', 2250000, 100, 0, 'Tản nhiệt khí DEEPCOOL ASSASSIN III được thiết kế với 7 ống dẫn nhiệt Ø6 mm công nghệ sinter mới, quạt kép 140mm độc đáo giúp nâng cao áp suất không khí và giảm tiếng ồn.', 'imagetn6.jpg', '2022-05-25', 10),
(60, 'Tai nghe DareU EH416 RGB', 350000, 100, 300000, 'DareU EH416 RGB với đèn LED 16.8 triệu màu (tự động chuyển màu). LED được bố trí rất hợp lý hai bên tai nghe với màu trắng đẹp mắt, sáng rõ, bao gồm led viền và Logo rất nổi bật.', 'imagetng1.jpg', '2022-05-25', 11),
(61, 'Tai nghe HyperX Cloud II RED', 2090000, 100, 2000000, 'Dòng tai nghe Cloud đa năng được thiết kế để phù hợp với nhu cầu chơi game của tất cả mọi người, với tất cả mọi hệ thống, phong cách chơi hoặc phong cách cá nhân.', 'imagetng2.jpg', '2022-05-25', 11),
(62, 'Tai nghe Gaming Logitech G Pro Gen 2', 2390000, 100, 0, 'Tai nghe gaming giá rẻ Logitech G đầu tiên có tên gọi PRO (CHUYÊN NGHIỆP) được thiết kế dưới sự hợp tác với những chuyên gia hàng đầu thế giới. Được làm từ các vật liệu chất lượng cao nhất và có công nghệ tiên tiến, đem lại hiệu suất âm thanh không gì sánh được.', 'imagetng3.jpg', '2022-05-25', 11),
(63, 'Tai nghe HyperX Cloud Stinger Core', 799000, 94, 790000, 'HyperX Cloud Stinger™ Core được thiết kế dành cho game thủ PC muốn có chất lượng âm thanh tuyệt vời từ một chiếc tai nghe nhẹ. Tai nghe này cung cấp tất cả các tính năng mà game thủ cần từ tai nghe của họ; chất lượng âm thanh tuyệt vời, thoải mái, tiện lợi và đáng tin cậy.', 'imagetng4.jpg', '2022-05-25', 11),
(64, 'Tai nghe Razer Hammerhead True Wireless Earbuds', 2290000, 100, 0, 'Light up your immersion with the new Razer Hammerhead True Wireless—cutting-edge earbuds destined to dominate the soundstage.', 'imagetng5.jpg', '2022-05-25', 11),
(65, 'Tai nghe Cooler Master MH710', 990000, 100, 900000, 'Một sự phù hợp không thoải mái có thể làm hỏng tiềm năng của một củ tai chất lượng. MH710 - Tai nghe gaming giá rẻ đảm bảo phù hợp hoàn hảo với nhiều loại khuyên tai với nhiều hình dạng và kích cỡ khác nhau.', 'imagetng6.jpg', '2022-05-25', 11),
(66, 'Bàn phím Razer Huntsman Mini', 3190000, 100, 0, 'Razer Huntsman Mini Mecury là một trong những bàn phím cơ phiên bản màu trắng thu nhỏ chỉ còn 60% so với Razer Huntsman Mecury.', 'imagebp1.jpg', '2022-05-25', 12),
(67, 'Bàn phím Razer Blackwidow V3', 3590000, 100, 3000000, 'The name that started it all returns to reassert its dominance. Feel the difference with the Razer BlackWidow V3—backed by a legacy as the first', 'imagebp2.jpg', '2022-05-25', 12),
(68, 'Bàn phím Razer Blackwidow V3 Pro', 5990000, 100, 5000000, 'The world’s first and most iconic mechanical gaming keyboard makes its next game-changing evolution.', 'imagebp3.jpg', '2022-05-25', 12),
(69, 'Bàn phím Logitech G813 RGB', 3090000, 99, 3000000, 'G813 là kỳ công kỹ thuật và thiết kế với dáng vẻ tinh tế đến đáng ngạc nhiên và mỏng đến không tưởng mà không đánh đổi về hiệu suất hoặc tính năng.', 'imagebp4.jpg', '2022-05-25', 12),
(70, 'Bàn phím Logitech G913 TKL Lightspeed Wireless', 3990000, 100, 0, 'G913 là một chiếc bàn phím cơ giá rẻ đặc biệt dành cho những ai tìm kiếm sự khác biệt. Có thể giá của nó không dễ chịu chút nào nhưng những gì nó đem lại thì thật sự xứng đáng', 'imagebp5.jpg', '2022-05-25', 12),
(71, 'Bàn phím Leopold FC660MPD Light Pink', 2750000, 100, 2700000, 'Beauty is in the eyes of the beholder” (Vẻ đẹp tùy thuộc vào đôi mắt của người nhìn), câu nói nổi tiếng cho chúng ta thấy quan niệm về cái đẹp và việc đánh giá vẻ đẹp phức tạp đến nhường nào.', 'imagebp6.jpg', '2022-05-25', 12),
(72, 'Màn hình ViewSonic VX2458-P 24\" 144Hz FreeSync', 4350000, 100, 4300000, 'Với Tần số quét 144Hz nhanh chóng, màn hình này mang lại tính lưu động trực quan tuyệt vời và đồ họa hoàn hảo cho các tựa game hành động và có diễn biến nhanh.', 'imagemh1.jpg', '2022-05-25', 13),
(73, 'Màn hình Asus TUF GAMING VG249Q 24\" IPS 144Hz FreeSync chuyên game', 5450000, 100, 0, 'Tấm nền IPS 23,8 inch Full HD (1920 X 1080) của TUF Gaming VG249Q mang đến hình ảnh tuyệt đẹp từ mọi góc độ với góc nhìn rộng 178 độ đảm bảo độ méo và thay đổi màu tối thiểu ngay cả khi bạn đang xem từ các vị trí khắc nghiệt.', 'imagemh2.jpg', '2022-05-25', 13),
(74, 'Màn hình ViewSonic VP2458 24\" IPS chuyên đồ họa', 4500000, 100, 4000000, 'Độ sáng 250 cd/m2 (Typ).Tỷ lệ tương phản 1000:1 (Typ).Độ tương phản động 20,000,000.Khả năng hiển thị màu sắc NTSC: 72.57% / sRGB: 100% / REC709: 100%.Độ sai lệch màu sắc Delta E < 2.Độ phân giải Full HD 1920 x 1080', 'imagemh3.jpg', '2022-05-25', 13),
(75, 'Màn hình ASUS ProArt PA248QV 24\" IPS 75Hz 16:10 chuyên đồ họa', 5190000, 100, 5000000, 'Màn Hình Chuyên Đồ Họa Asus ProArt PA248QV 24.1\' Tỉ lệ 16:10 WUXGA (1920 x 1200) 5ms/ 75Hz/ IPS/ 100% sRGB/ 100% Rec.709/ Color Accuracy ΔE < 2/ Stereo Speaker (2Wx2) - Hàng Chính Hãng', 'imagemh4.jpg', '2022-05-25', 13),
(76, 'Màn hình Dell UltraSharp U2721DE 27\" IPS 2K chuyên đồ họa', 10690000, 100, 0, 'Màn hình DELL U2721DE tối ưu hóa không gian làm việc của bạn với màn hình thời trang có cấu hình bảng mỏng, chân đế nhỏ gọn và khe quản lý cáp có thể ẩn máy cắt cáp khỏi tầm nhìn.', 'imagemh5.jpg', '2022-05-25', 13),
(77, 'Màn hình cong Philips 322M8CZ 32\" VA 165Hz Freesync', 6290000, 100, 6200000, 'Màn hình: IPS - FHD.Curve : 1500R.Kích thước : 32\".Độ phân giải : 1920 x 1080.Tần số quét : 165Hz.Thời gian đáp ứng : 1 ms', 'imagemh6.jpg', '2022-05-25', 13),
(78, 'Chuột Logitech G102 Lightsync RGB Black', 400000, 100, 0, 'Dù có mức giá rất bình dân nhưng Chuột Logitech G102 Lightsync RGB lại được trang bị led  RGB 16,8 triệu màu .Chọn một màu hay trộn 3 màu, hiệu ứng có sẵn hay tạo hiệu ứng của riêng bạn .', 'imagech1.jpg', '2022-05-25', 14),
(79, 'Chuột Logitech G502 Hero', 990000, 100, 900000, 'G502 HERO có cảm biến quang học tiên tiến cho độ chính xác theo dõi tối đa, tính năng chiếu sáng RGB có thể tùy chỉnh, cấu hình trò chơi tùy chỉnh, từ 200 cho tới 25.600 DPI và các khối nặng có thể đặt lại vị trí.', 'imagech2.jpg', '2022-05-25', 14),
(80, 'Chuột Logitech G Pro Wireless', 2690000, 100, 2600000, 'Đối với G Pro Wireless Hero 25K được tối ưu hóa để thực hiện những cú flick chuột ở tốc độ trên 400 IPS một cách dễ dàng.', 'imagech3.jpg', '2022-05-25', 14),
(81, 'Chuột Razer DeathAdder V2', 1690000, 100, 1600000, 'Với hơn 10 triệu chiếc chuột Razer DeathAdder đã được bán, đây là chiếc chuột chơi game cực nổi tiếng và đã được trao giải nhất trên thế giới trong nhiều năm qua. Nổi tiếng nhờ thiết kế công thái học đặc biệt.', 'imagech4.jpg', '2022-05-25', 14),
(82, 'Chuột Razer DeathAdder V2 Pro', 2990000, 100, 2000000, 'Chuột chơi game Razer DeathAdder V2 Pro nhanh hơn 25% so với bất kỳ công nghệ chuột bluetooth, không dây nào khác hiện nay. Thậm chí sẽ không nhận ra rằng mình đang sử dụng chuột chơi game không dây do truyền tốc độ cao, độ trễ nhấp chuột thấp nhất và chuyển đổi tần số liền mạch trong môi trường ồn ào nhất, bão hòa dữ liệu.', 'imagech5.jpg', '2022-05-25', 14),
(83, 'Chuột Steelseries Rival 650', 2590000, 100, 2500000, 'Ở phiên bản không dây cao cấp nhất này, SteelSeries đã lấy nguyên mẫu thiết kế và tính năng cực kỳ cao cấp của Rival 600, chính vì vậy mà SteelSeries Rival 650 là chuột gaming không dây được trang bị những tính năng và công nghệ cao cấp nhất.', 'imagech6.jpg', '2022-05-25', 14),
(84, 'Bộ định tuyến WiFi 5 ASUS RT-AC1500UHP Chuẩn AC1500 (Xuyên tường)', 1690000, 100, 0, 'Được tăng cường bằng Wi-Fi thế hệ thứ 5 (Wi-Fi 5G), chipset 802.11ac giúp RT-AC1500UHP đạt tốc độ không dây siêu nhanh. RT-AC1500UHP cho tốc độ lên tới 867 Mbps ở băng tần 5Ghz và 4x4 600 Mbps ở băng tần 2,4 Ghz, nhanh hơn 2 lần so với các bộ định tuyến 300 Mbps.', 'imagetbm1.jpg', '2022-05-25', 15),
(85, 'Bộ định tuyến WiFi 6 Asus RT-AX82U Gundam Edition', 6390000, 100, 6000000, 'Bộ định tuyến chơi game WiFi 6 Asus RT-AX82U Gundam Edition là một trong những bộ định tuyến ấn tượng nhất với thiết kế độc đáo lấy chủ đề Gundam. Bên cạnh đó là hiệu năng cao và nhiều công nghệ hiện đại hỗ trợ.', 'imagetbm2.jpg', '2022-05-25', 15),
(86, 'Bộ định tuyến WiFi 6 Asus RT-AX86U Zaku II Gundam Edition', 7390000, 100, 7300000, 'Asus RT-AX86U Zaku II Gundam Edition khoác lên mình bộ giáp của ZAKU II Char Aznable Custom, một trong những cỗ máy chiến đấu trong series phim hoạt hình nổi tiếng của tuổi thơ, Gundam.', 'imagetbm3.jpg', '2022-05-25', 15),
(87, 'Bộ định tuyến WiFi 6 ASUS RT-AX88U Chuẩn AX6000', 8190000, 100, 8100000, 'ASUS RT-AX88U (Gaming Router) Wifi AX6000 2 băng tần, Wifi 6 (802.11ax), AiMesh 360 WIFI Mesh, AiProtection, USB 3.1 2 băng tần chuẩn cho tổng tốc độ 6000Mbps (2.4Ghz:1148Mbps+ 5GHz: 4804Mbps), 4 ăng-ten rời 5dBi. Cổng: 8 port x 10/100/1000 Lan, 1x 10/100/1000 Wan, 2 x USb 3.1 Vi xử lý Quad-core 1.8Ghz, RAM 1GB, 256MB Flash', 'imagetbm4.jpg', '2022-05-25', 15),
(88, 'Bộ định tuyến WiFi 6 ASUS RT-AX92U Chuẩn AX6100', 9090000, 100, 9000000, 'Công nghệ AiMesh cho phép bạn thiết lập một hệ thống WiFi mạnh hơn nữa với công nghệ 802.11ax như là đường truyền không dây để truyền dữ liệu giữa hai bộ định tuyến RT-AX92U, đảm bảo WiFi ổn định nhất có thể cho các thiết bị được kết nối.', 'imagetbm5.jpg', '2022-05-25', 15),
(89, 'Bộ định tuyến WiFi 6 ROG Rapture GT-AX11000 Chuẩn AX11000', 14490000, 99, 0, 'Router wifi ASUS ROG Rapture GT-AX11000 - Bộ định tuyến WiFi 10 Gigabit đầu tiên trên thế giới với chip xử lý lõi tứ, tương thích với PS5, cổng 2.5G, băng tần DFS, wtfast, chế độ Adaptive QoS, AiMesh dành cho hệ thống wifi mesh và bảo mật mạng miễn phí', 'imagetbm6.jpg', '2022-05-25', 15);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loailinhkien`
--

DROP TABLE IF EXISTS `loailinhkien`;
CREATE TABLE IF NOT EXISTS `loailinhkien` (
  `MALLINHKIEN` int(11) NOT NULL AUTO_INCREMENT,
  `TENLLINHKIEN` varchar(20) DEFAULT NULL,
  `HINHANH` char(100) DEFAULT NULL,
  PRIMARY KEY (`MALLINHKIEN`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `loailinhkien`:
--

--
-- Đang đổ dữ liệu cho bảng `loailinhkien`
--

INSERT INTO `loailinhkien` VALUES
(1, 'Laptop', 'laptop.png'),
(2, 'Mainboard', 'mainboard.png'),
(3, 'CPU', 'cpu.png'),
(4, 'RAM', 'ram.png'),
(5, 'VGA', 'vga.png'),
(6, 'SSD', 'ssd-disk.png'),
(7, 'HDD', 'hdd.png'),
(8, 'VỎ MÁY TÍNH', 'high-tower.png'),
(9, 'PSU', 'psu.png'),
(10, 'TẢN NHIỆT', 'heat-pad.png'),
(11, 'TAI NGHE', 'headphones.png'),
(12, 'BÀN PHÍM', 'keyboard.png'),
(13, 'MÀN HÌNH', 'desktop.png'),
(14, 'CHUỘT', 'computer-mouse.png'),
(15, 'THIẾT BỊ MẠNG', 'network-hub.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `MANV` int(11) NOT NULL,
  `MATKHAU` varchar(100),
  `HOTEN` varchar(20) DEFAULT NULL,
  `GIOITINH` varchar(3) DEFAULT NULL,
  `NGAYSINH` date DEFAULT NULL,
  `DIACHI` varchar(30) DEFAULT NULL,
  `SODT` int(11) DEFAULT NULL,
  PRIMARY KEY (`MANV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `nhanvien`:
--




--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `FK_CHITIETHOADON_SANPHAM` FOREIGN KEY (`MALINHKIEN`) REFERENCES `linhkien` (`MALINHKIEN`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_CTHD_HOADON` FOREIGN KEY (`MAHD`) REFERENCES `hoadon` (`MAHD`),
  ADD CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`MAHD`) REFERENCES `hoadon` (`MAHD`);


--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `FK_HOADON_KHACHHANG` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`USERNAME`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`USERNAME`);

--
-- Các ràng buộc cho bảng `linhkien`
--
ALTER TABLE `linhkien`
  ADD CONSTRAINT `FK_LINHKIEN_LOAILINHKIEN` FOREIGN KEY (`MALLINHKIEN`) REFERENCES `loailinhkien` (`MALLINHKIEN`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;
