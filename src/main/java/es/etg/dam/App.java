package es.etg.dam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class App {

    private static final String SALTO_LINEA = "\n", INFORME = "informe.md", TITULO_DOC = "# Informe de los procesos";
    private static final List<String> COMANDOS = List.of("ps", "df", "free");
    private static final StringBuilder informe = new StringBuilder();

    public static void main(String[] args) throws IOException, InterruptedException {
        
        informe.append(GeneradorInforme.escribirTitulo(TITULO_DOC));

        for (String comando : COMANDOS) {
            String salida = ejecutarComando(comando);
            informe.append(GeneradorInforme.escribirBloque(comando, salida));
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INFORME))) {
            writer.write(informe.toString());
        }
    }

    private static String ejecutarComando(String comando) throws IOException, InterruptedException {
        Process proceso = Runtime.getRuntime().exec(comando);
        StringBuilder resultado = new StringBuilder();
        String linea;

        try (BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
            while ((linea = lector.readLine()) != null) {
                resultado.append(linea).append(SALTO_LINEA);
            }
        }

        proceso.waitFor();

        return resultado.toString();
    }
}