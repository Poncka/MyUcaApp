<?php
    $mysql = new mysqli("localhost", "root" , "" , "MyUca");
    if($mysql->connect_error){
        echo"Error: ";
        die("Error de conexión");
    }
?>