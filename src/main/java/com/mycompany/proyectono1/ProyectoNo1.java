/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectono1;

import java.io.DataInputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Marlon
 */
public class ProyectoNo1 {

    public static void main(String[] args) {
       // variable que guradara nuestra expresion  
        String expresion = null; 
        System.out.print("Ingrese una expresion aritmetica para analizar: ");
       // metodo de expeccion para analizar la varibale
        try{
            DataInputStream ingresar = new DataInputStream(System.in);
            expresion = ingresar.readLine();
        }catch (IOException e){            
            e.printStackTrace();
        }
        // crearmos un objeto arbol
        Arbol arbol = new Arbol();
        // le mandamos al obejeto arbol nuestra variable con su contenido
        arbol.GenerarArbol(expresion);
        // imprime los recorridos del arbol posorden inorden postorden
        arbol.imprimir();
          System.out.println("");
  
        // imprimimos nuestro arbol 
        System.out.println("la expresion es " + expresion);
        System.out.println(" ARBOL:  ");
        System.out.println("nodos izquierda");
        arbol.Mostrar(arbol.getRaiz().getIzquierda());
        System.out.println("nodos derechos ");
        arbol.Mostrar(arbol.getRaiz().getDerecha());
        System.out.println("nodo padre ");
        arbol.Mostrar(arbol.getRaiz().getPadre());
        
    }
}


