/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author Johan
 */
public class regexClass {
    // Para este caso haré uso de un ArrayList para almacenar los elementos regex
    /**
     * Funcion que filtra un dato de una Lista
     * @param f
     * @param listaRegex 
     */
    public void filter(String f, List<String> listaRegex) {
        String[] parts = f.split("");
        listaRegex.addAll(Arrays.asList(parts));
        listaRegex.stream().map(String::toLowerCase).filter(x -> x.startsWith(f)).forEach(x -> System.out.println(x));
    }

    /**
     * Funcion para ordenar una lista
     * @param listaRegex 
     */
    public void sort(List<String> listaRegex) {
        listaRegex.stream().sorted().forEach(System.out::println);
    }

    /**
     * Contar los elementos de una lista
     * @param listaRegex 
     */
    public void count(List<String> listaRegex) {
        long x = listaRegex.stream().count();
        System.out.println(x-1);
    }

    /**
     * Funcion que mmuestra solo la cantidad de elementos dada de una lista
     * @param l
     * @param listaRegex 
     */
    public void limit(int limite, List<String> listaRegex) {
        listaRegex.stream().limit(limite).forEach(System.out::println);
    }

    /**
     * Funcion para contar la cantidad de letras en una cadena de caraccteres (para el segundo punto)
     * @param regex 
     */
    public void cantidadLetras(String regex) {
        List<String> listaRegex = new ArrayList<>();
        String[] parts = regex.split("");
        listaRegex.addAll(Arrays.asList(parts));

        Map<String, Long> frecuency = listaRegex.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        frecuency.entrySet().removeIf(entry -> (entry.getValue() < 2));

        System.out.println("''" + regex + "'' =>" + frecuency);
    }

    private void pointOne() {
        System.out.println("***************** PRIMER PUNTO ******************");
        //Creamos el String para el ejemplo
        String regex = "aaabbccaa";
        
        //Ese String lo separamos en un ArrayList
        List<String> regexList = new ArrayList<>();
        String[] parts = regex.split("");
        regexList.addAll(Arrays.asList(parts));
        
        System.out.println("Filtrar dependiendo del patron");
        filter("c", regexList);
        System.out.println("");
        
        System.out.println("Ordenar un ArrayList de Strings");
        sort(regexList);
        System.out.println("");
        
        System.out.println("Contar los datos de un ArrayList de Strings");
        count(regexList);
        System.out.println("");
        
        System.out.println("Mostrar al cantidad de datos dada de una lista");
        limit(2, regexList);
        System.out.println("");
    }

    private void pointTwo() {
        System.out.println("******************* SEGUNDO PUNTO ****************");

        cantidadLetras("abcde");

        cantidadLetras("aabbcde");

        cantidadLetras("aabBcde");

        cantidadLetras("indivisibility");

        cantidadLetras("Indivisibilities");

        cantidadLetras("aA11");

        cantidadLetras("ABBA");
    }

    public static void main(String[] args) {
        // TODO code application logic here
        regexClass r = new regexClass();
        r.pointOne();
        r.pointTwo();

    }
}
