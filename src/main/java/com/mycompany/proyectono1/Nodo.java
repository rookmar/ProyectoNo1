/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectono1;

/**
 *
 * @author Marlon
 */
public class Nodo {
    private char valor;
    private Nodo izquierda,derecha,padre;
     
    //Constructores 
    public Nodo(char valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }
        
    public Nodo() {        
        this.izquierda = null;
        this.derecha = null;
    } 
// metodos getter y setter
    public void setValor(char valor) {
        this.valor = valor;
    }
 
    public char getValor() {
        return valor;
    }
 
    public Nodo getIzquierda() {
        return izquierda;
    }
 
    public void setIzquierda(Nodo hojaIzquierda) {
        this.izquierda = hojaIzquierda;
    }
 
    public Nodo getDerecha() {
        return derecha;
    }
 
    public void setDerecha(Nodo hojaDerecha) {
        this.derecha = hojaDerecha;
    }   

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo nodoPadre) {
        this.padre= nodoPadre;
    }
    
    
    
}
