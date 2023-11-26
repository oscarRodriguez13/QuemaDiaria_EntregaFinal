package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class CifrarTexto {
    public String encodeToBase64URLSafe(String inputString) {
        // Convierte el string a bytes
        byte[] inputBytes = inputString.getBytes(StandardCharsets.UTF_8);

        // Codifica los bytes a Base64 URL Safe
        byte[] encodedBytes = Base64.getUrlEncoder().encode(inputBytes);

        // Convierte los bytes codificados de nuevo a un string
        return new String(encodedBytes, StandardCharsets.UTF_8);
    }

    public String decodeFromBase64URLSafe(String encodedString) {
        // Convierte el string codificado en bytes
        byte[] encodedBytes = encodedString.getBytes(StandardCharsets.UTF_8);

        // Decodifica los bytes Base64 URL Safe a bytes originales
        byte[] decodedBytes = Base64.getUrlDecoder().decode(encodedBytes);

        // Convierte los bytes originales de nuevo a un string
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
}
