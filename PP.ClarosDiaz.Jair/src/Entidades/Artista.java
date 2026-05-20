/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Objects;

/**
 *
 * @author jairj
 */
public class Artista {
    private String nombre;
    private String apellido;
    private String paisDeNacimiento;

    public Artista(String nombre, String apellido, String paisDeNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.paisDeNacimiento = paisDeNacimiento;
    }
    
    public static boolean sonIguales(Artista a1, Artista a2){
        
        
       if(a1.nombre.equals(a2.nombre) && a2.apellido.equals(a2.apellido) && (a1.paisDeNacimiento.equals(a2.paisDeNacimiento)))
            {return true;}
       else{
           return false;}
        
    }
    
    public String getNombre(){
    
        return this.nombre;
    }
    
    public String getApellido(){
    
        return this.apellido;
    }
    
    public String getPais(){
    
        return this.paisDeNacimiento;
    }
    
    public String getArtista(){
    
        StringBuilder artista = new StringBuilder();
        
        artista.append("Nombre: ").append(getNombre());
        artista.append(", Apellido: ").append(getApellido());
        artista.append(", Pais de nacimiento: ").append(getPais());
        
        return artista.toString();
    
    }
    
    
    
        
    }

