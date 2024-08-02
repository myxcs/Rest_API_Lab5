<?php
$res = array();
$server="localhost"; $user="root"; $password=""; $db="a1";
$connect = new mysqli($server, $user, $password, $db);
$MaSP = $_POST['MaSP'];
$TenSP = $_POST['TenSP'];
$MoTa = $_POST['MoTa'];
$sql = "UPDATE SanPham SET TenSP = '$TenSP', MoTa = '$MoTa' WHERE MaSP = '$MaSP'";
if($connect->query($sql)==TRUE){
    $res['success'] = 1;
    $res['message'] = "update thanh cong";
    echo json_encode($res);
}
else{
    $res['success'] = 0;
    $res['message'] = "update that bai";
    //echo json_encode($res);
    echo "loi: ".$connect->error;
}
//b5 dong ket noi 
$connect->close();

//http://localhost/000/rest_api_lab5/insert.php?MaSP=sp2&TenSP=San pham 2&MoTa=Mo ta 2