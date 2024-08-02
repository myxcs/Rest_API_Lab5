<?php
$res = array();
$server="localhost"; $user="root"; $password=""; $db="a1";
$connect = new mysqli($server, $user, $password, $db);
$sql = "SELECT * FROM SanPham";
$result = $connect -> query($sql); //doc du lieu va tra ve result
if($result->num_rows>0){ 
    //num_rows tra ve so dong
    $res['products'] = array();
    while($row = $result->fetch_assoc()){
        $product = array();
        $product['MaSP'] = $row['MaSP'];
        $product['TenSP'] = $row['TenSP'];
        $product['MoTa'] = $row['MoTa'];
        array_push($res['products'], $product); // day du lieu doc dc vao mang 
    }
    $res['success'] = 1;
    $res['message'] = "select thanh cong";
    echo json_encode($res);
}
else{
    $res['success'] = 0;
    $res['message'] = "select that bai";
    //echo json_encode($res);
    echo "loi: ".$connect->error;
}
//b5 dong ket noi 
$connect->close();

//http://localhost/000/rest_api_lab5/insert.php?MaSP=sp2&TenSP=San pham 2&MoTa=Mo ta 2