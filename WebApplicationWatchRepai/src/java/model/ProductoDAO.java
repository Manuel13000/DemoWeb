/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

//imports
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
     //Instanciar la conexion
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int r = 0;
    Producto pt = new Producto();
    //Operaciones CRUD
    public List listar() {
        //Creamos la variable sql de tipo cadena
        String sql = "SELECT * FROM producto WHERE estado=?";
        //Creamos la vaiable lista de tipo ArrayList
        List<Producto> lista1 = new ArrayList<>();
        try {
            con = cn.Conexion();
            pst = con.prepareStatement(sql);
            pst.setString(1, "A");
            rs = pst.executeQuery();
            while (rs.next()) {
                Producto pt = new Producto();
                pt.setIdProducto(rs.getInt(1));
                pt.setProducto(rs.getString(2));
                pt.setPrecio(rs.getString(3));
                pt.setStock(rs.getString(4));
                pt.setEstado(rs.getString(5));

                //Agregamos los registros al ArrayList
                lista1.add(pt);
            }
            pst.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return lista1;
    }

    public int agregar(Producto u) {
        //Creamos la variable sql de tipo cadena
        String sql = "INSERT INTO producto(producto,precio,stock) values(?,?,?)";

        try {
            con = cn.Conexion();
            pst = con.prepareStatement(sql);
            pst.setString(1,u.getProducto());
            pst.setString(2, u.getPrecio());
            pst.setString(3,u.getStock());
        
            r = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return r;
    }

    public int actualizar(Producto u) {
        //Creamos la variable sql de tipo cadena
        String sql = "UPDATE producto SET producto=?, precio=?,stock=?, WHERE idProducto=?";

        try {
            con = cn.Conexion();
            pst = con.prepareStatement(sql);
            pst.setString(1, u.getProducto());
            pst.setString(2, u.getPrecio());
            pst.setString(3, u.getStock());
            pst.setInt(4, u.getIdProducto());
            r = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return r;
    }

    public void eliminar(int idp) {
        //Creamos la variable sql de tipo cadena
        String sql = "UPDATE prodcuto SET estado=? WHERE idProducto=?";

        try {
            con = cn.Conexion();
            pst = con.prepareStatement(sql);
            pst.setString(1, "I");
            pst.setInt(2, idp);

            r = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public Producto listarIds(int id) {
        //Creamos la variable sql de tipo cadena
        String sql = "SELECT * FROM producto WHERE idProducto=?";
        Producto pt = new Producto();
        try {
            con = cn.Conexion();
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            rs = pst.executeQuery();
            while (rs.next()) {
                pt.setProducto(rs.getString(2));
                pt.setPrecio(rs.getString(3));
                pt.setStock(rs.getString(4));
                pt.setEstado(rs.getString(5));

            }
            pst.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return pt;
    }
}