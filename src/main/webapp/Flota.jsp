<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Flota</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Flota" method="POST">
                        <div class="form-group">                            
                            <label>Modelo</label>  
                            <input type="text" value="${flota.getModelo()}" name="txtModelo" class="form-control" >   
                        </div>
                        <div class="form-group">
                            <label>Capacidad</label>
                            <input type="text" value="${flota.getCapacidad()}" name="txtCapacidad" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Max Venta</label>
                            <input type="text" value="${flota.getMaxVenta()}" name="txtMaxVenta" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>            
            </div>  
            <div class="col-sm-8" >
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>MODELO</th>
                            <th>CAPACIDAD</th>
                            <th>MAXVENTA</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="fl" items="${flotas}">
                            <tr>
                                <td>${fl.getId()}</td>
                                <td>${fl.getModelo()}</td>
                                <td>${fl.getCapacidad()}</td>
                                <td>${fl.getMaxVenta()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Flota&accion=Editar&id=${fl.getId()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Flota&accion=Delete&id=${fl.getId()}">Delete</a>

                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>  
            </div>
        </div           
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
