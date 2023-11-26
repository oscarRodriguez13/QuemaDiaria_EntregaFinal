package co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.database;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Credenciales;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Perfil;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.NotificacionDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.PerfilDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Por ahora es un ejemplo de como se puede hacer la conxión a la base de datos
 * */
public class UsuarioBaseDatosRepositorio implements UsuarioRepositorio {
    private Connection connection;

    public UsuarioBaseDatosRepositorio() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/path/to/your/database.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        try {
            String insertQuery = "INSERT INTO usuarios (nombre, correo, username, password) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getCorreo());
            statement.setString(3, usuario.getCredenciales().getNombreUsuario());
            statement.setString(4, usuario.getCredenciales().getContrasenna());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> consultarListaUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            String selectQuery = "SELECT nombre, correo, username, password FROM usuarios";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correo");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                Usuario usuario = new Usuario(nombre, correo, new Credenciales(username, password));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public Usuario consultarUsuarioPorUserName(String username) {
        try {
            String selectQuery = "SELECT nombre, correo, username, password FROM usuarios WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correo");
                String password = resultSet.getString("password");

                return new Usuario(nombre, correo, new Credenciales(username, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Usuario consultarUsuarioPorUserName2(String userName) {
        try {
            String selectQuery = "SELECT nombre, correo, username, password FROM usuarios WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String correo = resultSet.getString("correo");
                String password = resultSet.getString("password");

                return new Usuario(nombre, correo, new Credenciales(userName, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizarContrasennaUsuario(String nombreUsuario, String nuevaContrasenna) {}

    @Override
    public void actualizarPerfil(PerfilDTO perfilDTO, Usuario usuario) {
        try {
            // Crear una consulta de actualización SQL
            String updateQuery = "UPDATE usuarios SET altura = ?, peso = ?, complexion = ?, objetivo = ? WHERE numeroDocumento = ?";
            PreparedStatement statement = connection.prepareStatement(updateQuery);
            statement.setInt(1, perfilDTO.getAltura());
            statement.setInt(2, perfilDTO.getPeso());
            statement.setString(3, perfilDTO.getComplexion());
            statement.setString(4, perfilDTO.getObjetivo());
            statement.setString(5, usuario.getNumeroDocumento());

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Perfil actualizado correctamente");
            } else {
                System.out.println("Usuario no encontrado o no se actualizó el perfil.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarEstadoNotificaciones(NotificacionDTO notificacionDTO, Usuario usuario) {

    }
}
