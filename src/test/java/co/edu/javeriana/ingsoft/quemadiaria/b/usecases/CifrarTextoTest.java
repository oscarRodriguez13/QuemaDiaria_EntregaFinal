package co.edu.javeriana.ingsoft.quemadiaria.b.usecases;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CifrarTextoTest {

    @Test
    void testEncodeToBase64URLSafe() {
        CifrarTexto cifrarTexto = new CifrarTexto();
        String originalString = "Hello, this is a test string!";
        String encodedString = cifrarTexto.encodeToBase64URLSafe(originalString);

        String decodedString = cifrarTexto.decodeFromBase64URLSafe(encodedString);

        assertEquals(originalString, decodedString);
    }

    @Test
    void testDecodeFromBase64URLSafe() {
        CifrarTexto cifrarTexto = new CifrarTexto();
        String originalString = "Another test string for decoding!";
        String encodedString = cifrarTexto.encodeToBase64URLSafe(originalString);

        String decodedString = cifrarTexto.decodeFromBase64URLSafe(encodedString);

        assertEquals(originalString, decodedString);
    }
}
