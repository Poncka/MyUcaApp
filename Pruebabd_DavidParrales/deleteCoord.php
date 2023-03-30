
<?php
    
    if($_SERVER["REQUEST_METHOD"] == "POST"){
        require_once 'conexion.php';
        
        $id = $_POST["id"];
        $my_query = "delete from coordinador where id =".$id;
        
        $result = $mysql->query($my_query);

        if($result == true){
            echo 'Registro eliminado satisfactoriamente';
        } else { 
            echo 'Error';
        }
    } else {
        echo 'Error desconocido';
    }

?>