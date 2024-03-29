<%-- 
    Document   : Principal
    Created on : 15 jul. 2023, 08:01:46
    Author     : samue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-info">
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="#">Home</a>
        </li>
        <li class="nav-item">
            <a style="margin-left:10px; border: none " class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleados</a>
        </li>
        <li class="nav-item">
          <a style="margin-left:10px; border: none " class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Productos</a>
        </li>
        <li class="nav-item">
          <a style="margin-left:10px; border: none" class="btn btn-outline-light"href="Controlador?menu=Cliente&accion=Listar"" target="myFrame">Clientes</a>
        </li>
        <li class="nav-item">
            <a style="margin-left:10px; border: none" class="btn btn-outline-light"href="Controlador?menu=NuevaVenta&accion=default" target="myFrame">Nueva Venta</a>
        </li>
      </ul>
    </div> 
    <div class="dropdown">
        <button class="btn btn-outline-light btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            ${usuario.getNom()}
        </button>
        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton"> 
            <a class="dropdown-item" href="#">
                <img src="img/user.png" alt="60" width="60"/>
            </a>
            <a class="dropdown-item" href="#">${usuario.getUser()}</a>
            <a class="dropdown-item" href="#">usuario@gmail.com</a>
            <div class="dropdown-divider"></div>
            <form action="Validar" method="POST"> 
                <button name="accion" value="salir" class="dropdown-item" href="#">Salir</a>            
            </form>
        </div>
    </div>
        
    </nav>
    <div class="m-4" style="height:830px">
        <iframe name="myFrame" style="height:100% ; width:100%; border: none"></iframe>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
