<?php
    include 'connection.php';

    $st_check=$conn->prepare("SELECT * FROM users WHERE email=? AND password=?");
    $st_check->bind_param("ss",$_POST["email"],$_POST["password"]);
    $st_check->execute();
    $rs = $st_check->get_result();

    if($rs->num_rows==0){
        echo "Invalid user";
    }else{
        echo "Success";
    }
?>