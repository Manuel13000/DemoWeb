<%-- 
    Document   : usuario
    Created on : May 7, 2020, 1:38:31 PM
    Author     : manuel Turcios
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gesti&oacute;n de usuarios</title>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">

        <!-- CSS personalizados -->
        <link href="Assets/css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h3>Gesti&oacute;n de usuarios</h3>
        <hr>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form id="frmUsuario" method="post" class="form-horizontal" action="Controlador?opc=user">
                        <div class="form-group">
                            <label for="nombres">Nombres</label>
                            <input type="text" class="form-control" id="txtNombre" name="txtNombre" placeholder="Digite su nombre completo" value="${usuario.getNombre()}" />
                        </div>
                        <div class="form-group">
                            <label for="usuario">Usuario</label>
                            <input type="text" class="form-control" id="txtUsuario" name="txtUsuario" placeholder="Digite el usuario" value="${usuario.getUsuario()}" />
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="text" class="form-control" id="txtEmail" name="txtEmail" placeholder="Digite su correo electronico" value="${usuario.getEmail()}" />
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="txtPassword" name="txtPassword" placeholder="Digite la clave" value="${usuario.getClave()}" />
                        </div>
                        <button type="submit" name="acc" value="actualizar" class="btn btn-success">Actualizar  <i class="fa fa-save"></i></button>
                    </form>
                </div>
                <div></div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover table-sm">
                    <caption>Lista de usuarios</caption>
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Usuario</th>
                            <th scope="col">Email</th>
                            <th scope="col" hidden>Clave</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="us" items="${usuarios}">
                            <tr>
                                <th scope="row">${us.getIdUsuario()}</th>
                                <td>${us.getNombre()}</td>
                                <td>${us.getUsuario()}</td>
                                <td>${us.getEmail()}</td>
                                <td hidden>${us.getClave()}</td>
                                <td>${us.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning btn-sm text-white" href="Controlador?opc=user&acc=editar&id=${us.getIdUsuario()}">Editar <i class="fa fa-edit"></i></a>
                                    <a class="btn btn-danger btn-sm text-white" onclick="confirmar(${us.getIdUsuario()})">Eliminar <i class="fa fa-trash-alt"></i></a>
                                </td>
                            </tr>
                        </c:forEach>


                    </tbody>
                </table>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/5.4.0/bootbox.min.js"></script>

        <script>
            function confirmar(id)
            {
                bootbox.confirm({
                    message: "&iquest;Esta seguro de eliminar al usuario?",
                    buttons: {
                        confirm: {
                            label: 'Si',
                            className: 'btn-success'
                        },
                        cancel: {
                            label: 'No',
                            className: 'btn-danger'
                        }
                    },
                    callback: function (result) {
                        if(result)
                            location.href = "Controlador?opc=user&acc=eliminar&id="+id;
                    }
                });
            }
        </script>
    </body>
</html>
