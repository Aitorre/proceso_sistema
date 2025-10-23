package es.etg.dam;

public class GeneradorInforme {

    private static final String SALTO_LINEA = "\n", CODIGO_MD = "```", HEADER_MD = "## ",TERMINAL = "bash";

    public static String escribirTitulo(String titulo) {
        return titulo + SALTO_LINEA;
    }

    // Ahora escribirBloque recibe el output ya ejecutado
    public static String escribirBloque(String comando, String salidaComando) {
        StringBuilder bloque = new StringBuilder();

        bloque.append(SALTO_LINEA).append(HEADER_MD).append(comando).append(SALTO_LINEA).append(SALTO_LINEA).append(CODIGO_MD).append(TERMINAL).append(SALTO_LINEA);

        bloque.append(salidaComando);

        bloque.append(CODIGO_MD).append(SALTO_LINEA);

        return bloque.toString();
    }
}
