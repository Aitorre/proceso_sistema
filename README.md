# Generador de informes

Este código ejecuta en la terminal de linux los comando

```bash
ps
df
free
```

Luego crea un fichero markdown que guarda los que salga en la terminal

Con esta clase podemos escribir todos los comandos que queramos y devolver al main lo que devuelva el comando

```java
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
```
