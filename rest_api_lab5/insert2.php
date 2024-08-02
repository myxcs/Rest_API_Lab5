<?php
//tat ca ca bien truy cap se co dau $
//truy cap thuoc tinh doi tuong ->
//noi chuoi dung dau .
//echo == in ra man hinh 
//b1 khai bao cong thong tin
$res = array();
$server="localhost"; $user="root"; $password=""; $db="a1";
//b2: ket noi
$connect = new mysqli($server, $user, $password, $db);
$MaSP = $_POST['MaSP'];
$TenSP = $_POST['TenSP'];
$MoTa = $_POST['MoTa'];
//b3: viet lenh insert
$sql = "INSERT into SanPham (MaSP, TenSP, MoTa) VALUES ('$MaSP', '$TenSP', '$MoTa')";
//b4: thuc hien insert
if($connect->query($sql)==TRUE){
    $res['success'] = 1;
    $res['message'] = "ket noi thanh cong";
    echo json_encode($res);
}
else{
    $res['success'] = 0;
    $res['message'] = "ket noi that bai";
    //echo json_encode($res);
    echo "loi: ".$connect->error;
}
//b5 dong ket noi 
$connect->close();

//http://localhost/000/rest_api_lab5/insert.php?MaSP=sp2&TenSP=San pham 2&MoTa=Mo ta 2