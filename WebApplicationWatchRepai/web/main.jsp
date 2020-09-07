<%-- 
    Document   : main
    Created on : May 7, 2020, 12:17:21 PM
    Author     : manux
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vintage Watch and Clock Store</title>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
         <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
        <!-- CSS -->
        <link href="Assets/css/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="page-wrapper chiller-theme toggled">
            <a id="show-sidebar" class="btn btn-sm btn-dark" href="#">
                <i class="fas fa-bars"></i>
            </a>
            <nav id="sidebar" class="sidebar-wrapper">
                <div class="sidebar-content">
                    <div class="sidebar-brand">
                        <a href="#">MY NEW WEBSITE</a>
                        <div id="close-sidebar">
                            <i class="fas fa-angle-double-left"></i>
                        </div>
                    </div>
                    <div class="sidebar-header">
                        <div class="user-pic">
                            <img class="img-responsive img-rounded" src="https://raw.githubusercontent.com/azouaoui-med/pro-sidebar-template/gh-pages/src/img/user.jpg"
                                 alt="User picture">
                        </div>
                        <div class="user-info">
                            <span class="user-name">Jhon
                                <strong>Smith</strong>
                            </span>
                            <span class="user-role">Administrator</span>
                            <span class="user-status">
                                <i class="fa fa-circle"></i>
                                <span>Online</span>
                            </span>
                        </div>
                    </div>
                    <!-- sidebar-header  -->
                  
                    <!-- sidebar-search  -->
                    <div class="sidebar-menu">
                        <ul>
                            <li class="header-menu">
                                <span>General</span>
                            </li>
                            <li>
                                <a href="Controlador?opc=user&acc=listar" target="contenido">
                                    <i class="fa fa-user"></i>
                                    <span>Gesti&oacute;n de usuario</span>
                                </a>
                            </li>
                            <li>
                                <a href="Controlador?opc=prt&acc=listar" target="contenido">
                                    <i class="fa fa-cubes"></i>
                                    <span>Gesti&oacute;n de productos</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-shopping-basket"></i>
                                    <span>Gesti&oacute;n de ordenes</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <!-- sidebar-menu  -->
                </div>
                <!-- sidebar-content  -->
                <div class="sidebar-footer">
                   
                    <a href="#">
                        <i class="fa fa-power-off"></i>
                    </a>
                </div>
            </nav>
            <!-- sidebar-wrapper  -->
            <main class="page-content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12" style="height: 650px">
                            <iframe id="contenido" name="contenido" frameborder="0" scrolling="0" width="100%" height="100%"></iframe>
                           
                        </div>
                    </div>
                </div>

            </main>
            <!-- page-content" -->
        </div>

         <!-- Optional JavaScript -->
            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
            <script src="https://code.jquery.com/jquery-3.4.1.min.js" ></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" ></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" ></script>
            <script src="Assets/js/myscript.js" type="text/javascript"></script>
    </body>
</html>
