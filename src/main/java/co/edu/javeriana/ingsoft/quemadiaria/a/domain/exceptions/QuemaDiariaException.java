package co.edu.javeriana.ingsoft.quemadiaria.a.domain.exceptions;

public class QuemaDiariaException extends RuntimeException {

    public static final Integer ERROR_USUARIO_NO_ENCONTRADO = 400;
    public static final Integer ERROR_USUARIO_YA_EXISTE = 401;
    public static final Integer ERROR_CREDENCIALES_INVALIDAS = 402;
    private static final long serialVersionUID = 1L;
    private Integer codigo;

    public QuemaDiariaException(Integer codigo, String mensaje) {
        super(mensaje);
        this.codigo = codigo;
    }
    public Integer getCodigo() {
        return codigo;
    }
}
