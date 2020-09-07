/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import model.UsuarioDAO;
import model.Producto;
import model.ProductoDAO;
/**
 *
 * @author manux
 */

public class Controlador extends HttpServlet {
    //instancia de Usuario y UsuarioDAO
    Usuario us = new Usuario();
    UsuarioDAO uDao = new UsuarioDAO();
    //Instancia de Producto y ProductoDAO
    Producto pt = new Producto();
    ProductoDAO pDao = new ProductoDAO();
    int ide = 0;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String option = request.getParameter("opc");
        String action = request.getParameter("acc");

        if (option.equals("main")) {

        } else if (option.equals("user")) {
            switch (action) {
                case "listar":
                    List lista = uDao.listar();
                    request.setAttribute("usuarios", lista);
                    request.getRequestDispatcher("usuario.jsp").forward(request, response);
                    break;
                case "agregar":
                    String nombre = request.getParameter("txtNombre");
                    String usuario = request.getParameter("txtUsuario");
                    String email = request.getParameter("txtEmail");
                    String password = request.getParameter("txtPassword");

                    int resp = 0;
                    String msg = "";

                    us.setNombre(nombre);
                    us.setUsuario(usuario);
                    us.setEmail(email);
                    us.setClave(password);
                    resp = uDao.agregar(us);

                    if (resp == 1) {
                        msg = "Registrado";
                        response.setContentType("text/plain");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write(msg);
                    } else {
                        msg = "Denegado";
                        response.setContentType("text/plain");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write(msg);
                    }
                    break;
                case "editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Usuario u = uDao.listarId(ide);
                    request.setAttribute("usuario", u);
                    request.getRequestDispatcher("Controlador?opc=user&acc=listar").forward(request, response);
                    break;
                case "actualizar":
                    String nombreU = request.getParameter("txtNombre");
                    String usuarioU = request.getParameter("txtUsuario");
                    String emailU = request.getParameter("txtEmail");
                    String passwordU = request.getParameter("txtPassword");

                    us.setNombre(nombreU);
                    us.setUsuario(usuarioU);
                    us.setEmail(emailU);
                    us.setClave(passwordU);
                    us.setIdUsuario(ide);
                    resp = uDao.actualizar(us);
                    //Listar los usuarios actualizados
                    request.getRequestDispatcher("Controlador?opc=user&acc=listar").forward(request, response);

                    break;
                case "eliminar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    uDao.eliminar(ide);
                    //Listar los usuarios actualizados
                    request.getRequestDispatcher("Controlador?opc=user&acc=listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
         
            request.getRequestDispatcher("index.html").forward(request, response);
        }else if(option.equals("prt"))
        {  switch (action) {
                case "listar":
                    List lista = pDao.listar();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("producto.jsp").forward(request, response);
                    break;
                case "agregar":
                    String producto = request.getParameter("txtProducto");
                    String precio = request.getParameter("txtPrecio");
                    String stock = request.getParameter("txtStock");
                    
                    int resp = 0;
                    String msg ="";
                    
                    pt.setProducto(producto);
                    pt.setPrecio(precio);
                    pt.setStock(stock);
                    resp = pDao.agregar(pt);
                    
                    if (resp == 1) {
                        msg = "Datos Registrados";
                        response.setContentType("text/plain");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write(msg);

                    }
                    request.getRequestDispatcher("producto.jsp").forward(request, response);
                    break;
                case "editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                   Producto u =  pDao.listarIds(ide);
                    request.setAttribute("producto", u);
                    request.getRequestDispatcher("Controlador?opc=prt&acc=listar").forward(request, response);
                    
                    break;
                case "actualizar":
                   String productoU = request.getParameter("txtProducto");
                    String precioU = request.getParameter("txtPrecio");
                    String stockU = request.getParameter("txtStock");
                   
                    
                    pt.setProducto(productoU);
                    pt.setPrecio(precioU);
                    pt.setStock(stockU);
                    pt.setIdProducto(ide);
                    resp = pDao.actualizar(pt);
                    //Listar los Productos actualizado
                     request.getRequestDispatcher("Controlador?opc=prt&acc=listar").forward(request, response);

                    break;
                case "eliminar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    pDao.eliminar(ide);
                     request.getRequestDispatcher("Controlador?opc=prt&acc=listar").forward(request, response);
                
                    break;
                default:
                    throw new AssertionError();
            }
             
             
             
        }  if (option.equals("logout")) {
            request.getRequestDispatcher("index.html").forward(request, response);
        }

    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
