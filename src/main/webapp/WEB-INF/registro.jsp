<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    <!-- Action = ruta donde enviaremos la información-->
  <div class="container-fluid">
  <h2>Formulario registro</h2>

  <c:if test="${msgError!=null }">
  <div class="alert alert-danger" role="alert">
  <c:out value="${msgError}"></c:out>  <!-- placeholder-->
  </div>
  </c:if> <!-- igual a un if normal pero con etiqueta-->
    
  <div class="card">
  <div class="card-body">
    <form action="/registro/usuario" method="post">
        <label for="nombre" class="form-label">Nombre:</label>
        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingrese su nombre">
        <br>
        <label for="apellido" class="form-label">Apellido:</label>
        <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Ingrese su apellido">
        <br>
        <label for="nick" class="form-label">Nick:</label>
        <input type="text" class="form-control" id="nick" name="nick" placeholder="Ingrese su nickname">
        <br>
        <label for="correo" class="form-label">Correo:</label>
        <input type="email" class="form-control" id="correo" name="correo" placeholder="hola@ejemplo.com">
        <br>
        <label for="password" class="form-label">Password:</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="ingrese password">
        <br>
         <label for="password2" class="form-label">Confirme su password:</label>
        <input type="password" class="form-control" id="password2" name="password2" placeholder="ingrese password">
        <br>
        <button type="submit" class="btn btn-outline-success" value="Enviar">Login</button>
    </form>
  </div>
</div>
    
</div>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>    
</body>
</html>