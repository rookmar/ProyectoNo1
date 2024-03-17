/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectono1;

import java.util.Stack;

/**
 *
 * @author Marlon
 */
public class Arbol {
     private Nodo raiz;
    private String expresion;
//constructor sin parametros para inciar el arbol
    public Arbol() {
        raiz = null;
        expresion = null;
    }
// constructor con parametros 
    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
// metodo para añadir un nodo nueva
    public Nodo AnadirNodo(char exp) {
        Nodo nodo = new Nodo();
        nodo.setValor(exp);
        nodo.setDerecha(null);
        nodo.setIzquierda(null);
        return nodo;
    }
// metodo para iniciar a crear o generar el nodo
    public void GenerarArbol(String incio) {      
        incio = "(" + incio;
        incio += ")";
        this.expresion = incio;
        this.raiz = GenerarArbol();
    }
// sedundo metodo para iniciar a crear o generar el nodo 
    public Nodo GenerarArbol() {
        String incio = this.expresion;
        Stack<Nodo> stN = new Stack<>();
        Stack<Character> stC = new Stack<>();
        Nodo temp, temp1, temp2;

        int[] p = new int[123];
        p['+'] = p['-'] = 1;
        p['/'] = p['*'] = 2;
        p['^'] = 3;
        p[')'] = 0;

        for (int i = 0; i < incio.length(); i++) {
            if (incio.charAt(i) == '(') {
                stC.add(incio.charAt(i));
            }
            else if (Character.isDigit(incio.charAt(i))) {
                temp = AnadirNodo(incio.charAt(i));
                stN.add(temp);
            } else if (p[incio.charAt(i)] > 0) {
                while (!stC.isEmpty() && stC.peek() != '(' && ((incio.charAt(i) != '^' && p[stC.peek()] >= p[incio.charAt(i)]) || (incio.charAt(i) == '^' && p[stC.peek()] > p[incio.charAt(i)]))) {
                    temp = AnadirNodo(stC.peek());
                    stC.pop();
                    temp1 = stN.peek();
                    stN.pop();
                    temp2 = stN.peek();
                    stN.pop();
                    temp.setIzquierda(temp2);
                    temp.setDerecha(temp1);
                    stN.add(temp);
                }
            stC.push(incio.charAt(i));
            } else if (incio.charAt(i) == ')') {
                while (!stC.isEmpty() && stC.peek() != '(') {
                    temp = AnadirNodo(stC.peek());
                    stC.pop();
                    temp1 = stN.peek();
                    stN.pop();
                    temp2 = stN.peek();
                    stN.pop();
                    temp.setIzquierda(temp2);
                    temp.setDerecha(temp1);
                    stN.add(temp);
                }
                stC.pop();
            }
        }
        temp = stN.peek();
        return temp;
    }
// metodo para imprimir los recorridos en preorden inorden postorden
    public void imprimir() {
          System.out.println("RECORRIDO EN PREORDE ");
          MostrarPreOrden(this.raiz);
          System.out.println("- - - - - - - - - - -");
          System.out.println("RECORRIDO EN INORDEN ");
          MostrarInOrden(this.raiz);
          System.out.println("- - - - - - - - - - -");
          System.out.println("RECORRIDO EN POSORDEN ");
          MostrarPostOrden(this.raiz);
          System.out.println("- - - - - - - - - - -");
          
        
    }
// metodo para recorrer preorden
    private void MostrarPreOrden(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.getValor() + ",");
            MostrarPreOrden(raiz.getIzquierda());
            MostrarPreOrden(raiz.getDerecha());
                        
        }
    }

// metodo para recorrer inorden
    private void MostrarInOrden(Nodo raiz) {
        if (raiz != null) {
            MostrarInOrden(raiz.getIzquierda());
            System.out.print(raiz.getValor() + ",");
            MostrarInOrden(raiz.getDerecha());
            
        }
    }

// metodo para mostar postorden
    private void MostrarPostOrden(Nodo raiz) {
        if (raiz != null) {
            MostrarPostOrden(raiz.getIzquierda());
            MostrarPostOrden(raiz.getDerecha());
            System.out.print(raiz.getValor() + ",");
            
        }
    }
// metodo para imprimir o mostrar el arbol y sus nodos
    public void Mostrar(Nodo n){
        
        if(n != null){
            
            Mostrar(n.getPadre());
            System.out.println("NODOS = " + n.getValor());
            Mostrar(n.getDerecha());
            Mostrar(n.getIzquierda());

        }
    }
    
}
