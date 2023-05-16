<?php
    $conn =  mysqli_connect('localhost','root','','qrattendance');

    if(!$conn){
        die("Connection Error" . mysqli_connect_error());
    }
?>