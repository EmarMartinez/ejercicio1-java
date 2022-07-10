package Lector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

public class LectorFichero {
    public static void main(String[] args) {
        Lector accediendo = new Lector();
        accediendo.lee();
    }
}

class Lector {

    public void lee(){
        try {
            List<Persona> list = new ArrayList<Persona>() ;
            String[] datos;
            int contador = 1;
            FileReader entrada = new FileReader("C:\\Users\\emar.martinez\\Ejercicio1\\ejercicio1.txt");

            BufferedReader bf = new BufferedReader(entrada);

            String linea;
            while ((linea = bf.readLine())!=null) {
                String ciudadTest = null;
                String nombreTest = null;
                String edadTest = null;
                datos = linea.split(":");
                nombreTest = datos[0];
                if(datos.length>1) {
                    ciudadTest = datos[1];
                }
                if(datos.length>2) {
                    edadTest = datos[2];
                }
                Persona persona = new Persona(nombreTest,ciudadTest,edadTest);
                list.add(persona);
                if(persona.getEdad() != "Desconocida" && parseInt(persona.getEdad()) < 25)  {
                    System.out.println("Linea " + contador + ": Nombre: " + persona.getNombre() + " Ciudad: " + persona.getCiudad() + " Edad: " + persona.getEdad());

                    contador++;
                }
            }
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }




    }


}