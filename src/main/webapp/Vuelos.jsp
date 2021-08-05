<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Vuelos</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Vuelos" method="POST">
                        <div class="form-group">                            
                            <label>Numero</label>  
                            <input type="text" value="${vuelos.getNumero()}" name="txtNumero" class="form-control" >   
                        </div>
                        <div class="form-group">
                            <label>Avion</label>
                            <input type="text" value="${vuelos.getAvionId()}" name="txtAvionId" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Origen</label>
                            <input type="text" value="${vuelos.getOrigen()}" name="txtOrigen" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Destino</label>
                            <input type="text" value="${vuelos.getDestino()}" name="txtDestino" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Horario</label>
                            <input type="text" value="${vuelos.getHorario()}" name="txtHorario" class="form-control">
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
                            <th>NUMERO</th>
                            <th>AVION ID</th>
                            <th>ORIGEN</th>
                            <th>DESTINO</th>
                            <th>HORARIO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="vu" items="${vuelo}">
                            <tr>
                                <td>${vu.getIdVuelo()}</td>
                                <td>${vu.getNumero()}</td>
                                <td>${vu.getAvionId()}</td>
                                <td>${vu.getOrigen()}</td>
                                <td>${vu.getDestino()}</td>
                                <td>${vu.getHorario()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Vuelos&accion=Editar&id=${vu.getIdVuelo()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Vuelos&accion=Delete&id=${vu.getIdVuelo()}">Delete</a>

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
