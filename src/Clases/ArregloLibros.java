/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ArregloLibros {
    private ArrayList<Libro> libro;
    
    //constructor
    public ArregloLibros() {
        libro = new ArrayList<Libro>();
    }
    
    public void cargarLibros(){
        try{
            File f = new File("libros.txt");
            if(f.exists()){
                FileReader fr= new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while((linea = br.readLine()) != null){
                    String[] bookLine = linea.split("-");
                    Libro bk = new Libro( Integer.parseInt(bookLine[0]), bookLine[1], bookLine[2] );
                    libro.add(bk);
                }
            }else{
                System.out.println("Archivo no existe");
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    
    //metodo para obtener el elemento de una posicion especifica
    public Libro obtenerLibro(int pos){
        return libro.get(pos);
    }
    
    //metodo para obtener la cantidad de libros
    public int totalLibros(){
        return libro.size();
    }
    
    //metodo para adicionar un libro al arraylist
    public void adicionarLibro(Libro x){
        libro.add(x);
    }
    
    //metodo para eliminar un libro del arraylist
    public void eliminarLibro(Libro x){
        libro.remove(x);
    }
}
