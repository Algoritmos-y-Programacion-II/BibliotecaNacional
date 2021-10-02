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

public class ArregloUsuarios {
    private ArrayList<Usuario> usuario;

    //constructor
    public ArregloUsuarios() {
        usuario = new ArrayList<Usuario>();
    }
    
    public void cargarUsuarios(){
        try{
            File f = new File("usuarios.txt");
            if(f.exists()){
                FileReader fr= new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while((linea = br.readLine()) != null){
                    String[] userLine = linea.split("-");
                    Usuario usr = new Usuario(userLine[0], userLine[1], userLine[2], userLine[3], userLine[4], userLine[5], userLine[6]);
                    usuario.add(usr); 
                }
            }else{
                System.out.println("Archivo no existe");
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    
    //metodo para adicionar un usuario al arraylist
    public void adicionarUsuario(Usuario x){
        usuario.add(x);
    }
    
    //metodo para eliminar un usuario del arraylist
    public void eliminarUsuario(Usuario x){
        usuario.remove(x);
    }
    
    //metodo para obtener el elemento de una posicion especifica
    public Usuario obtenerUsuario(int pos){
        return usuario.get(pos);
    }
    
    //metodo para buscar un usuario del arraylist por su dni
    public Usuario buscarUsuario(String dni){
        for(int i=0; i < usuario.size(); i++){
            if(dni == usuario.get(i).getDni()){
                return usuario.get(i);
            }
        }
        
        return null;
    }
    
    //metodo para obtener la cantidad de usuarios
    public int totalUsuarios(){
        return usuario.size();
    }
    
//    metodo para obtener el rol del usuario
//    public String rolUsuario(){
//        
//    }
}

//void imprimir(){
//    bandeja.setText("");
//}
//void imprimir(String cadena){
//    bandeja.append(cadena + "\n");
//}