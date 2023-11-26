package co.edu.javeriana.ingsoft.quemadiaria.d.infraestructure.persistence.files;

import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Notificacion;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Perfil;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.entities.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.a.domain.exceptions.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.b.usecases.persistence.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.NotificacionDTO;
import co.edu.javeriana.ingsoft.quemadiaria.c.services.dto.PerfilDTO;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * UsuarioArchivosRepositorio es una clase que implementa la interfaz UsuarioRepositorio para gestionar un usuario
 * en un archivo json
 */
public class UsuarioArchivosRepositorio implements UsuarioRepositorio {

    @Override
    public void guardarUsuario(Usuario usuario) {

        try {

            List<Usuario> usuarioList = consultarListaUsuarios();
            System.out.println("Registrando usuario: " + usuario);
            usuarioList.add(usuario);
            FileWriter fileWriter = new FileWriter("Usuarios.json");
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(usuarioList, fileWriter);
            fileWriter.close();
            System.out.println("Informacion guardada correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al gestionar el archivo", e);
        }

    }

    @Override
    public List<Usuario> consultarListaUsuarios() {


        Gson gson = new Gson();
        try {
            Path filePath = Path.of("Usuarios.json");
            String content = Files.readString(filePath);
            List<Usuario> usersList = new ArrayList<>();
            try {
                Usuario[] users = gson.fromJson(content, Usuario[].class);
                if(users == null)
                    return new ArrayList<>();
                return new ArrayList<>(List.of(users));
            } catch (JsonSyntaxException e) {
                if (e.getMessage().equals(
                        "Expected BEGIN_OBJECT but was BEGIN_ARRAY")) {
                    JsonArray jsonArray = new JsonParser()
                            .parse(content)
                            .getAsJsonArray();
                    for (int i = 0; i < jsonArray.size(); i++) {
                        Usuario user = gson.fromJson(jsonArray.get(i), Usuario.class);
                        usersList.add(user);
                    }
                    return usersList;
                } else {
                    // Handle other JSON parsing errors
                    e.printStackTrace();
                    throw new RuntimeException("Error al gestionar el archivo", e);
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al gestionar el archivo", e);
        }

    }

    @Override
    public Usuario consultarUsuarioPorUserName(String userName) {
        if (userName == null ) {
            throw new IllegalArgumentException("Invalido userName");
        }
        return consultarListaUsuarios().
                stream().
                filter(usuario -> usuario.getCredenciales().getNombreUsuario().equals(userName)).
                findFirst().
                orElseThrow(()->new QuemaDiariaException(QuemaDiariaException.ERROR_USUARIO_NO_ENCONTRADO, "Usuario no encontrado: " + userName));
    }

    @Override
    public Usuario consultarUsuarioPorUserName2(String userName) {
        Optional<Usuario> usuarioOptional = consultarListaUsuarios().stream()
                .filter(u -> u.getCredenciales().getNombreUsuario().equals(userName))
                .findFirst();

        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public void actualizarContrasennaUsuario(String nombreUsuario, String nuevaContrasenna) {
        List<Usuario> usuarioList = consultarListaUsuarios();
        for (Usuario usuario : usuarioList) {
            if (usuario.getCredenciales().getNombreUsuario().equals(nombreUsuario)) {
                usuario.getCredenciales().setContrasenna(nuevaContrasenna);
                guardarListaUsuarios(usuarioList);
                return;
            }
        }
    }

    private void guardarListaUsuarios(List<Usuario> usuarioList) {
        try {
            FileWriter fileWriter = new FileWriter("Usuarios.json");
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(usuarioList, fileWriter);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al gestionar el archivo", e);
        }
    }

    @Override
    public void actualizarPerfil(PerfilDTO perfilDTO, Usuario usuario) {
        try {
            List<Usuario> usuarioList = consultarListaUsuarios();

            // Buscar el usuario que coincida con el usuario proporcionado
            Optional<Usuario> usuarioExistente = usuarioList.stream()
                    .filter(u -> u.getCredenciales().getNombreUsuario().equals(usuario.getCredenciales().getNombreUsuario()))
                    .findFirst();

            if (((Optional<?>) usuarioExistente).isPresent()) {
                // Actualizar el perfil del usuario existente
                Perfil perfil = new Perfil(perfilDTO.getAltura(), perfilDTO.getPeso(), perfilDTO.getComplexion(), perfilDTO.getObjetivo());
                usuarioExistente.get().setPerfil(perfil);

                // Guardar los cambios en el archivo JSON
                FileWriter fileWriter = new FileWriter("Usuarios.json");
                Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
                gson.toJson(usuarioList, fileWriter);
                fileWriter.close();

                System.out.println("Información actualizada correctamente");
            } else {
                System.out.println("Usuario no encontrado. No se pudo actualizar el perfil.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al gestionar el archivo", e);
        }
    }

    @Override
    public void cambiarEstadoNotificaciones(NotificacionDTO notificacionDTO, Usuario usuario) {
        try {
            List<Usuario> usuarioList = consultarListaUsuarios();

            // Buscar el usuario que coincida con el usuario proporcionado
            Optional<Usuario> usuarioExistente = usuarioList.stream()
                    .filter(u -> u.getCredenciales().getNombreUsuario().equals(usuario.getCredenciales().getNombreUsuario()))
                    .findFirst();

            if (usuarioExistente.isPresent()) {
                // Obtener la descripción de la notificación a cambiar
                String descripcionNotificacion = notificacionDTO.getDescripcion();

                // Buscar la notificación en la lista de notificaciones del usuario
                Optional<Notificacion> notificacionExistente = usuarioExistente.get().getNotificaciones().stream()
                        .filter(n -> n.getDescripcion().equals(descripcionNotificacion))
                        .findFirst();

                if (notificacionExistente.isPresent()) {
                    // Cambiar el estado de la notificación según el valor proporcionado en notificacionDTO
                    notificacionExistente.get().setActivo(notificacionDTO.isActivo());

                    // Guardar los cambios en el archivo JSON
                    FileWriter fileWriter = new FileWriter("Usuarios.json");
                    Gson gson = new GsonBuilder()
                            .setPrettyPrinting()
                            .create();
                    gson.toJson(usuarioList, fileWriter);
                    fileWriter.close();

                    System.out.println("Estado de notificación actualizado correctamente");
                } else {
                    System.out.println("Notificación no encontrada. No se pudo actualizar el estado.");
                }
            } else {
                System.out.println("Usuario no encontrado. No se pudo actualizar el estado de notificación.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al gestionar el archivo", e);
        }
    }


}
