package practica7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamFormatter {    
    public static String leerBytes(String inFile){
        String format = "--------------------------------------\n\nCartelera de CineFBMoll\n\n--------------------------------------";
        try(FileInputStream fin = new FileInputStream("/home/josep/Documentos/daw/programacio/java/practica7/stream_formatter/src/main/webapp/resources/" + inFile)){
            int i = -1;
            int contador = 0;
            format += "\n\n-----";
            do{
                i = fin.read();
                if(i != -1){
                    if((char)i=='#'){
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
                    } else if((char)i=='{'){
                        contador = 0;
                        format += " horas\n\n------";
                    } else {
                        format += ((char)i);
                    }
                }
            }while(i != -1);
            if(i==-1){
                format += " horas\n\n--------------------------";
            }
            fin.close();
        }catch(IOException e){
            System.out.println("Error al leer el archivo");
            System.out.println(e.getMessage());
        }
        return format;
    }

    public static void escribirBytes(String outFile, String content){
        try(FileOutputStream fout = new FileOutputStream("/home/josep/Documentos/daw/programacio/java/practica7/stream_formatter/src/main/webapp/resources/" + outFile)){
            for(int i = 0;i < content.length(); i ++){
                fout.write((int)content.charAt(i));
            }
        }catch(IOException e){
            System.out.println("Error al escribir el archivo");
            System.out.println(e.getMessage());
        }
    }
}
