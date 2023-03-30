
<?php
    
    if($_SERVER["REQUEST_METHOD"] == "POST"){
        require_once 'conexion.php';

        
        $nombres = $_POST["nombres"];
        $apellidos = $_POST["apellidos"];
        $fechaNac = $_POST["fechaNac"];
        $titulo = $_POST["titulo"];
        $email = $_POST["email"];
        $facultad = $_POST["facultad"];
        $id = $_POST["id"];

        $my_query = "update coordinador set nombres= '".$nombres."', apellidos= '".$apellidos."', fechaNac= '".$fechaNac."', titulo= '".$titulo."', email= '".$email."', facultad= '".$facultad."' where id=".$id;
        $result = $mysql->query($my_query);

        if($result == true){
            echo 'Registro actualizado correctamente';
        } else { 
            echo 'Error';
        }
    } else {
        echo 'Error desconocido';
    }

?>