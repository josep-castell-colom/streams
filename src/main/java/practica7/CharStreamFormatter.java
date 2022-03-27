package practica7;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamFormatter {
    public static String leerChar(String fileIn){
        String format = "--------------------------------------\n\nCartelera de CineFBMoll\n\n--------------------------------------\n\n";
        try{
            File entrada = new File("/home/josep/Documentos/daw/programacio/java/practica7/stream_formatter/src/main/webapp/resources/" + fileIn);
            FileReader lector = new FileReader(entrada);
            int caracter;
            int contador = 0;
            format += "------";
            while((caracter = lector.read()) != -1){
                if(caracter != -1){
                    if((char)caracter=='#'){
                        contador += 1;
                        switch(contador){
                            case 1: format += "------\n\nAño: ";
                            break;
                            case 2: format += "\n\nDirector: ";
                            break;
                            case 3: format += "\n\nDuración: ";
                            break;
                            case 4: format +=" minutos\n\nSinopsis: ";
                            break;
                            case 5: format +="\n\nReparto: ";
                            break;
                            case 6: format  += "\n\nSesión: ";
                            break;
                        }
                    } else if((char)caracter=='{'){
                        contador = 0;
                        format += " horas\n\n------";
                    } else {
                        format += ((char)caracter);
                    }
                }
            }
            if(caracter == -1){
                format += " horas\n\n--------------------------------------";
            }
            lector.close();
        }catch(IOException e){
            System.out.println("Error al leer archivo");
            System.out.println(e.getMessage());
        }
        return format;
    }

    public static void escribirChar(String fileOut, String content){
        try{
            File archivoSalida = new File("/home/josep/Documentos/daw/programacio/java/practica7/stream_formatter/src/main/webapp/resources/" + fileOut);
            FileWriter escritor = new FileWriter(archivoSalida);
            for(int i = 0; i < content.length(); i ++){
                escritor.write(content.charAt(i));
            }
            escritor.close();
        }catch(IOException e){
            System.out.println("Error escribiendo archivo");
            System.out.println(e.getMessage());
        }
    }
}
