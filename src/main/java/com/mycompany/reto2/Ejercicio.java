/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author
 * Jaime Andrés Muñoz
 * Juan David Vásquez
 */
public class Ejercicio {

    static Scanner lectura = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        menu:
        while (true) {
            System.out.println("Ingrese la opción que desea ejecutar así:\n\n"
                    + "1-Calcular el cuadrado de los N primeros números enteros mediante sumas de impares\n"
                    + "2-Calcular los primeros N números primos y la suma de ellos\n"
                    + "3-Calcular los desarrollos posibles de una bicicleta de montaña\n"
                    + "4-Salir");
            opcion = lectura.nextInt();
            switch (opcion) {
                case 1:
                    ejercicio1();
                    break;
                case 2:
                    ejercicio2();
                    break;
                case 3:
                    ejercicio3();
                    break;
                case 4:
                    System.out.println("Salida exitosa");
                    break menu;
                default:
                    System.out.println("Opción incorrecta, intente de nuevo");
                    break;
            }
        }

    }

    public static void ejercicio1() {
        //Método para calcular el cuadrado de los N primeros números escrito como la suma de impares
        int N, j, cont;
        String resultado = "";
        System.out.println("Ingrese un número");
        N = lectura.nextInt();
        for (int i = 1; i <= N; i++) {
            j = 1;
            cont = 1;
            resultado = (i + "^(2)" + " = ");
            while (cont <= (i * i)) {
                resultado = resultado + j + "+";
                j = j + 2;
                cont = cont + j;
            }
            //Se elimina el último caracter del String
            resultado = resultado.substring(0, resultado.length() - 1);
            System.out.println(resultado);
            resultado = "";
        }
    }

    public static void ejercicio2(){
        //Método para hallar los N primeros números primos
        int N;
        int num = 1;
        int cant = 0;
        int cont = 0;
        int suma = 0;
        String numeros = "";
        
        System.out.println("Ingrese un número");
        N = lectura.nextInt();
        while(true){
            for(int i=1;i<=num;i++){
                if(num%i==0){
                    cont++;
                }
            }
            //Verificar si el número es primo
            if(cont==2){
                numeros = numeros + " "+num+" ";
                suma+=num;
                cant++;
            }
            //Romper el ciclo cuando se hayan encontrado los N primeros números primos
            if(cant==N){
                break;
            }
            cont = 0;
            num++;
        }
        System.out.println("Los "+N+" primeros números primos son:\n"+numeros);
        System.out.println("La suma de ellos es: "+suma);
    }
    
    public static void ejercicio3() {
        //Método para calcular los desarrollos posibles de una bicicleta de montaña (MTB)
        double[] platos = new double[2];
        double[] p = new double[12];
        double res, cir, desarrollo;
        int opcion;
        selecPlato:
        while (true) {
            System.out.println("¿Cuántos platos delanteros tiene (1 o 2)?");
            opcion = lectura.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el número de dientes del plato");
                    res = lectura.nextDouble();
                    while (res <= 0) {
                        System.out.println("el valor debe ser mayor a 0");
                        System.out.println("Ingrese el número de dientes del plato");
                        res = lectura.nextDouble();
                    }
                    platos[0] = res;
                    platos[1] = 0;
                    break selecPlato;
                case 2:
                    System.out.println("Ingrese el número de dientes del primer plato");
                    res = lectura.nextDouble();
                    while (res <= 0) {
                        System.out.println("El valor debe ser mayor a 0");
                        System.out.println("Ingrese el número de dientes del primer plato");
                        res = lectura.nextDouble();
                    }
                    platos[0] = res;
                    System.out.println("Ingrese el número de dientes del segundo plato");
                    res = lectura.nextDouble();
                    while (res < 0) {
                        System.out.println("El valor debe ser mayor a 0");
                        System.out.println("Ingrese el número de dientes del segundo plato");
                        res = lectura.nextDouble();
                    }
                    platos[1] = res;
                    break selecPlato;
                default:
                    System.out.println("Opción errónea, intente de nuevo");
                    break;
            }
        }

        for (int i = 0; i <= 11; i++) {
            System.out.println("Ingrese el número de dientes del piñón " + (i + 1));
            res = lectura.nextDouble();
            while (res <= 0) {
                System.out.println("El valor debe de ser mayor que 0");
                System.out.println("Ingrese el número de dientes del piñón " + (i + 1));
                res = lectura.nextDouble();
            }
            p[i] = res;
        }
        selecLlanta:
        while (true) {

            System.out.println("Elija la dimensión de la llanta así:\n\n"
                    + "1-29x2.1\n"
                    + "2-29x2.2\n"
                    + "3-29x2.3");

            opcion = lectura.nextInt();

            switch (opcion) {
                case 1:
                    cir = 2.288;
                    break selecLlanta;
                case 2:
                    cir = 2.298;
                    break selecLlanta;
                case 3:
                    cir = 2.326;
                    break selecLlanta;
                default:
                    System.out.println("Opción incorrecta, vuelva a intentarlo");
                    break;
            }
        }
        for (int i = 0; i <= platos.length - 1; i++) {
            System.out.println("Los desarrollos posibles de una bicicleta de montaña "
                    + "para un plato de " + platos[i] + " dientes"
                    + " con una circunferencia de " + (cir * 1000) + "mm, son:");
            System.out.println("p='piñones', d='desarrollo'");
            for (int j = 0; j <= p.length - 1; j++) {
                //Fórmula para calcular los desarrollos posibles
                desarrollo = (platos[i] / p[j]) * cir;
                //Aproximar el resultado a 2 decimales
                BigDecimal rounded = new BigDecimal(desarrollo).setScale(2, RoundingMode.HALF_UP);
                desarrollo = rounded.doubleValue();
                //Imprimir el resultado para cada caso
                System.out.println((j + 1) + ") " + "p = " + p[j] + " d = " + desarrollo);
            }
        }
    }
}
