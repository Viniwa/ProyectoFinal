/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Clases.ConexionDB;
import Formularios.LoginForm;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Clases.Usuario;
import Formularios.panelAdmin;
import Formularios.panelUsuario;

/**
 *
 * @author Vini
 */
public class consultas {

    public void actualizarUsuario(Usuario usuario) {
        ConexionDB conexionDB = new ConexionDB();
        Connection con = conexionDB.conectar();
        PreparedStatement ps = null;

        try {
            String query = "UPDATE usuarios SET nombre =?, apellidos =?, direccion =?, ciudad =?, provincia =?, c_postal =?, telefono =? WHERE id=?";
            ps = con.prepareStatement(query);

            // Establecer los parámetros de la consulta
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getDireccion());
            ps.setString(4, usuario.getCiudad());
            ps.setString(5, usuario.getProvincia());
            ps.setInt(6, usuario.getC_postal());
            ps.setInt(7, usuario.getTelefono());
            ps.setInt(8, usuario.getId());

            // Ejecutar la consulta
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Datos del usuario actualizados correctamente.");
            } else {
                System.out.println("No se han actualizado los datos del usuario.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos del usuario: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void guardarUsuario(String correo, String pass, String nombre, String apellidos, String direccion, String ciudad, String provincia, int c_postal, int telefono) {
        ConexionDB db = new ConexionDB();
        String sql = "insert into usuarios(correo, clave, nombre, apellidos, direccion, ciudad, provincia, c_postal, telefono ) values ('" + correo + "'" + ",'" + pass + "','" + nombre + "',"
                + "'" + apellidos + "','" + direccion + "','" + ciudad + "','" + provincia + "','" + c_postal + "','" + telefono + "');";
        Statement st;
        Connection conexion = db.conectar();
        try {
            st = (Statement) conexion.createStatement();
            int rs = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Guardado correctamente");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    private static Usuario usuarioLogueado;

    public Usuario consultarUsuario(String correo, String pass, LoginForm loginForm) {

        ConexionDB db = new ConexionDB();
        Usuario usuarioLogin = null;

        try (Connection cn = db.conectar(); PreparedStatement pst = cn.prepareStatement("SELECT id, correo, clave, nombre, apellidos, direccion, ciudad, provincia, c_postal, telefono FROM usuarios WHERE correo =? AND clave =?")) {
            pst.setString(1, correo);
            pst.setString(2, pass);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Login successful

                    if (correo.equals("admin") && pass.equals("admin")) {
                        // Login de administrador
                        JOptionPane.showMessageDialog(null, "Login de Administrador correcto");
                        loginForm.dispose(); // Cierra la instancia de LoginForm
                        panelAdmin pd = new panelAdmin();
                        pd.setVisible(true);
                    } else {
                        // Login de usuario
                        usuarioLogin = extractUserData(rs);
                        usuarioLogueado = usuarioLogin;
                        JOptionPane.showMessageDialog(null, "Login correcto Bienvenido " + correo);
                        loginForm.dispose(); // Cierra la instancia de LoginForm
                        panelUsuario pu = new panelUsuario(); 
                        pu.setVisible(true);

                    }
                } else {
                    // Credenciales invalidas
                    JOptionPane.showMessageDialog(null, "Correo o contraseña incorrecta");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        return usuarioLogin;
    }

    public static Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public Usuario extractUserData(ResultSet rs) throws SQLException {
        return new Usuario(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8),
                rs.getInt(9),
                rs.getInt(10)
        );

    }
}
