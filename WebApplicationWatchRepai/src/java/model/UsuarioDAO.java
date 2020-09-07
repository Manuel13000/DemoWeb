/*
 * @author Manul turcios
 */
package model;
//Imports
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    //Instanciar la conexion
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    int r = 0;

    public Usuario validar(String user, String pass) {
        Usuario us = new Usuario();
        String sql = "SELECT * FROM usuario WHERE usuario=? AND clave=? AND estado=?";

        try {
            con = cn.Conexion();
            pst = con.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, pass);
            pst.setString(3, "A");
            rs = pst.executeQuery();
            while (rs.next()) {
                us.setIdUsuario(rs.getInt("idUsuario"));
                us.setUsuario(rs.getString("usuario"));
                us.setClave(rs.getString("clave"));
                us.setNombre(rs.getString("nombre"));
                us.setEmail(rs.getString("email"));
                us.setEstado(rs.getString("estado"));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return us;
    }

    //Operaciones CRUD
    public List listar() {
        //Creamos la variable sql de tipo cadena
        String sql = "SELECT * FROM usuario WHERE estado=?";
        //Creamos la vaiable lista de tipo ArrayList
        List<Usuario> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            pst = con.prepareStatement(sql);
            pst.setString(1, "A");
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario us = new Usuario();
                us.setIdUsuario(rs.getInt(1));
                us.setNombre(rs.getString(2));
                us.setUsuario(rs.getString(3));
                us.setEmail(rs.getString(4));
                us.setClave(rs.getString(5));
                us.setEstado(rs.getString(6));

                //Agregamos los registros al ArrayList
                lista.add(us);
            }
            pst.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return lista;
    }

    public int agregar(Usuario u) {
        //Creamos la variable sql de tipo cadena
        String sql = "INSERT INTO usuario(nombre,usuario,email,clave) values(?,?,?,?)";

        try {
            con = cn.Conexion();
            pst = con.prepareStatement(sql);
            pst.setString(1, u.getNombre());
            pst.setString(2, u.getUsuario());
            pst.setString(3, u.getEmail());
            pst.setString(4, u.getClave());
            r = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return r;
    }

    public int actualizar(Usuario u) {
        //Creamos la variable sql de tipo cadena
        String sql = "UPDATE usuario SET nombre=?,usuario=?,email=?,clave=SHA2(?,512) WHERE idUsuario=?";

        try {
            con = cn.Conexion();
            pst = con.prepareStatement(sql);
            pst.setString(1, u.getNombre());
            pst.setString(2, u.getUsuario());
            pst.setString(3, u.getEmail());
            pst.setString(4, u.getClave());
            pst.setInt(5, u.getIdUsuario());
            r = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return r;
    }

    public void eliminar(int id) {
        //Creamos la variable sql de tipo cadena
        String sql = "UPDATE usuario SET estado=? WHERE idUsuario=?";

        try {
            con = cn.Conexion();
            pst = con.prepareStatement(sql);
            pst.setString(1, "I");
            pst.setInt(2, id);

            r = pst.executeUpdate();

            pst.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public Usuario listarId(int id) {
        //Creamos la variable sql de tipo cadena
        String sql = "SELECT * FROM usuario WHERE idUsuario=?";
        Usuario us = new Usuario();
        try {
            con = cn.Conexion();
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            rs = pst.executeQuery();
            while (rs.next()) {
                us.setNombre(rs.getString(2));
                us.setUsuario(rs.getString(3));
                us.setEmail(rs.getString(4));
                us.setClave(rs.getString(5));
                us.setEstado(rs.getString(6));
            }
            pst.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return us;
    }
}