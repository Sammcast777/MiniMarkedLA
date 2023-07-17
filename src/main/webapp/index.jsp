<%-- 
    Document   : index
    Created on : 15 jul. 2023, 08:02:15
    Author     : samue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">       
        <title>JSP Page</title>
        <style>
        /* Color de fondo de la página */
        .bg-page {
            background-color: #ffe6e6; /* Rojo suave (#ffe6e6) */
        }

        /* Estilos del contenedor del formulario */
        .form-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            padding: 20px;
        }

        /* Estilos del logo */
        .logo {
            width: 100px; /* Ajusta el tamaño deseado */
            margin-bottom: 20px; /* Espacio entre el logo y los demás elementos */
        }

        /* Estilos del input */
        .custom-input {
            background-color: #c6e5b1 !important; /* Cambia el color de fondo del input */
        }

        /* Estilos del botón */
        .custom-button {
            background-color: #ffa07a; /* Cambia el color de fondo del botón a salmon (#ffa07a) */
            border: none;
            color: white;
            font-weight: bold;
        }

        /* Estilo del título */
        h3 {
            font-size: 24px;
            font-weight: bold;
            color: #333;
            margin-top: 20px; /* Espacio entre el logo y el título */
            text-align: center; /* Centra el título horizontalmente */
        }
    </style>
</head>
<body class="bg-page"> <!-- Aplicamos la clase "bg-page" al cuerpo de la página -->
    <div class="container mt-4 col-lg-4">
        <div class="card col-sm-10">
            <div class="card-body form-container"> <!-- Aplicamos la clase "form-container" al contenedor del formulario -->
                <!-- Logo arriba y centrado -->
                <img src="img/logo.jpg" alt="Logo" class="logo"> <!-- Cambia "Logo.jpg" por el nombre de tu archivo de imagen del logo -->
                <!-- Título del formulario -->
                <h3>LOGIN - MINIMARKET LOS ANDES</h3>

                <form class="form-sign" action="Validar" method="POST" >
                    <div class="form-group text-center">
                        <img src="img/anonimo.png" alt="70" width="170"/>
                        <label> Bienvenidos al sistema de ventas de Minimarket Los Andes</label>
                    </div>
                    <div class="form-group">
                        <label>USUARIO</label>
                        <input type="txt" name="txtuser" class="form-control custom-input"> <!-- Agregamos la clase "custom-input" al input -->
                    </div>
                    <div class="form-group">
                        <label>PASSWORD</label>
                        <input type="password" name="txtpass" class="form-control custom-input"> <!-- Agregamos la clase "custom-input" al input -->
                    </div>
                    <br>
                    <!-- Agregamos la clase "custom-button" al botón -->
                    <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block custom-button">
                </form>   
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
