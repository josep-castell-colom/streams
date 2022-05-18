package practica7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferStreamFormatter {
    public static String lecturaBufferedReader(String fileIn){
        String format = "";
        try{
            File archivoEntrada = new File("/home/josep/Documentos/daw/1/programacio/java/practica7/stream_formatter/src/main/webapp/resources/" + fileIn);
            BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada));
            boolean eof = false;
            String lineaLeida = "";
            String [] broken_text = null;
            while(!eof){
                lineaLeida = lector.readLine();
                if (lineaLeida != null){
                    broken_text = lineaLeida.split(" ");
                    format += lineaLeida;
                } else {
                    eof = true;
                }
            }
            lector.close();
        }catch(IOException e){
            System.out.println("Error de lectura");
            System.out.println(e.getMessage());
        }
        return format;
    }
}
