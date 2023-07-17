<%-- 
    Document   : Clientes
    Created on : 15 jul. 2023, 13:55:26
    Author     : samue
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Registro de Clientes</title>
        <style>
        /* Color de fondo de la página */
        body {
            background-color: #a6bf4d; /* Rojo suave (#ffe6e6) */
        }

        /* Estilos del contenedor del formulario */
        .form-container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
            margin-top: 50px; /* Espacio entre el formulario y el logo */
            margin-bottom: 50px; /* Espacio entre el formulario y el botón */
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
        h1 {
            font-size: 32px;
            font-weight: bold;
            color: #333;
            margin-bottom: 30px;
            text-align: center; /* Centra el título horizontalmente */
        }
    </style>
    </head>
    <body class="bg-page">
        <div class="d-flex">
            <div class="card col-sm-4 form-container">
                    <div class="card-body">
                         <!-- Logo arriba y centrado -->
                    <div class="text-center">
                    <img src="img/logo.jpg" alt="Logo" class="logo"> <!-- Cambia "Logo.jpg" por el nombre de tu archivo de imagen del logo -->
                    </div>
                    <!-- Título del formulario -->
                    <h1>Registro de Clientes</h1>                   
                    
                    <form action="Controlador?menu=Cliente" method="POST" >
                        <div class="form-group">
                            <label>Dni</label>
                            <input ty="text" value="${cliente.getDni()}" name="txtDni" class="form-control">
                        </div>
                        <div class="form-group">
                             <label>Nombres</label>
                            <input ty="text" value="${cliente.getNom()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                             <label>Dirección</label>
                            <input ty="text" value="${cliente.getDir()}" name="txtDir" class="form-control">
                        </div>
                        <div class="form-group">
                             <label>Estado</label>
                            <input ty="text" value="${cliente.getEstado()}" name="txtEstado" class="form-control">
                        </div>                        
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info"> </input>
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success"> </input>
                    </form>
                </div>            
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>DNI</th>
                            <th>NOMBRES</th>
                            <th>DIRECCION</th>
                            <th>ESTADO</th>                            
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>                 
                        <c:forEach var="cli" items="${clientes}">
                            <tr>
                                <td>${cli.getId()}</td>
                                <td>${cli.getDni()}</td>
                                <td>${cli.getNom()}</td>
                                <td>${cli.getDir()}</td>
                                <td>${cli.getEstado()}</td>                                
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Editar&id=${cli.getId()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Delete&id=${cli.getId()}">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
