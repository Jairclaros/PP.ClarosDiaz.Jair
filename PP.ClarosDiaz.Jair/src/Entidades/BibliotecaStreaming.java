/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author jairj
 */
public class BibliotecaStreaming {
    private int capacidad;
    private Collection<Contenido> contenidos;
    
    public BibliotecaStreaming(){
    
        this.capacidad = 3;
        this.contenidos = new ArrayList<>();
    
    }

    public BibliotecaStreaming(int capacidad) {
        this();
        this.capacidad = capacidad;
    }
    
    private boolean sonIguales(Contenido c){
    
        for (Contenido aux : this.contenidos){
        
            if(aux.equals(c)){
                return true;
            }
        
        }
        
        return false;
    }
    
    public void agregar(Contenido c){
    
        if (this.contenidos.size()>= this.capacidad){
            System.out.println("No hay mas espacio");
        }
        else if( this.sonIguales(c)){
            System.out.println("El contenido ya existe");}
        
        else{
            this.contenidos.add(c);
            System.out.println("Contenido agregado correctamente");
        
        }   
    }
    
    private int getDuracionContenido(TipoContenido tc){
    
        int duracion = 0;
        
        for(Contenido c: contenidos){
            switch(tc){

                case CANCIONES:
                    if(c instanceof Cancion){
                        duracion += ((Publicitable) c).getDuracionConPublicidad();
                        break;
                    
                }
                case PODCASTS:
                    if (c instanceof Podcast){
                        duracion += ((Publicitable)c).getDuracionConPublicidad();}
                        break;
                
                case TODOS:
                    duracion += ((Publicitable)c).getDuracionConPublicidad();
                    break;

            }
        }
        return duracion;
    }
    
    
    private int getDuracionCanciones(){
        
        return this.getDuracionContenido(TipoContenido.CANCIONES);
    }
    
    private int getDuracionPodcasts(){
    
        return this.getDuracionContenido(TipoContenido.PODCASTS);
    }
    
    private int getDuracioonTotal(){
    
        return this.getDuracionContenido(TipoContenido.TODOS);
    }
    
    private void ordenar(){
    
        ArrayList<Contenido> lista = (ArrayList<Contenido>) this.contenidos;
        
        Collections.sort(lista);
    }

    @Override
    public String toString() {
        
        this.ordenar();
        
        StringBuilder sb = new StringBuilder();
        sb.append("Cantidad de contenidos").append(this.contenidos.size());
        sb.append(System.lineSeparator());
        for(Contenido c :this.contenidos){
            
            sb.append(c.toString());
            sb.append(System.lineSeparator());}
            
        sb.append(" Duracion canciones: ").append(this.getDuracionCanciones());
        sb.append(System.lineSeparator());
        sb.append(" Duracion podcasts: ").append(this.getDuracionPodcasts());
        sb.append(System.lineSeparator());
        sb.append(" Duracion total: ").append(this.getDuracioonTotal());
        sb.append(System.lineSeparator());
        
        return sb.toString();
    }
    
    
    
    
}
