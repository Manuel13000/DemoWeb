<%-- 
    Document   : producto
    Created on : May 11, 2020, 4:02:19 PM
    Author     : manux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gesti&oacute;n de producto</title>
         <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
         <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
        <!-- CSS -->
        <link href="Assets/css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h3>Gesti&oacute;n de producto</h3>
        <hr>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form id="frmProducto" method="post" class="form-horizontal" action="Controlado?opc=product">
                            <div class="form-group">
                                <label for="nombres">Nombre del producto</label>
                                <input type="text" class="form-control" id="txtProducto" name="txtProducto" placeholder="Nombre del producto"  value="${producto.getProducto()}"/>
                            </div>
                            <div class="form-group">
                                <label for="nombres">Precio </label>
                                <input type="number" class="form-control" id="txtPrecio" name="txtPrecio" placeholder="Digite el precio"  value="${producto.getPrecio()}"/>
                            </div>
                            <div class="form-group">
                                <label for="stock">Stock</label>
                                <input type="text" class="form-control" id="txtStock" name="txtStock" placeholder="Digite la cantidad en stock" value="${producto.getStock()}" />
                            </div>
                            
                            <div class="modal-footer">
                               <button type="submit" name="acc" value="agregar" class="btn btn-primary">agregar <i class="fa fa-check"></i></button>
                                <button type="submit" name="acc" value="actualizar" class="btn btn-success">Actualizar <i class="fa fa-check"></i></button>
                            </div>
                        </form>
                </div>
                <div></div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover table-sm">
                <caption>Lista de productos</caption>
                <thead class="thead-dark">
                    
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Producto</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Stock</th>
                        <th scope="col">Estado</th>
                        <th scope="col">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pt" items="${productos}">
                    <tr>
                        <th scope="row">${pt.getIdProducto()}</th>
                        <td>${pt.getIdProducto()}</td>
                        <td>${pt.getProducto()}</td>
                        <td>${pt.getPrecio()}</td>
                        <td>${pt.getStock()}</td>
                        <td>${pt.getEstado()}</td>
                        <td>
                            <a class="btn btn-warning btn-sm text-white" href="Controlador?opc=producto&acc=editar&id=${pt.getIdProducto()}">Editar<i class="fa fa-edit"></i></a>
                             <a class="btn btn-danger btn-sm text-white" href="Controlador?opc=producto&acc=editar&id=${pt.getIdProducto()}">Eliminar<i class="fa fa-trash-alt"></i></a>
                        </td>
                    </tr>
                    </c:forEach> 
                </tbody>
            </table>
            </div>
        </div>
        <!-- Optional JavaScript -->
            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
            <script src="https://code.jquery.com/jquery-3.4.1.min.js" ></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" ></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" ></script>
    </body>
</html>
