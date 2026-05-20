/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author jairj
 */
public abstract class Contenido implements Comparable<Contenido> {
    
    protected Artista artista;
    protected String titulo;
    protected int duracion;
    protected int likes;
    
    protected static Random generadorLikes;


    
    public Contenido(String titulo, int duracion, Artista artista) {

    this.titulo = titulo;
    this.duracion = duracion;
    this.artista = artista;}
    
    public Contenido(String titulo,int duracion,String nombreArtista,String apellidoArtista,String paisArtista) {

    this(titulo,duracion,new Artista(nombreArtista, apellidoArtista, paisArtista)
    );
}
    
    static {       
        Contenido.generadorLikes = new Random();
    
    }
    
    public int getLikes(){
    
        if(this.likes== 0){
            
            this.likes = Contenido.generadorLikes.nextInt(1, 1000000);
        }
        return this.likes;
         
    }
    
    private String mostrar(Contenido c){

        StringBuilder sb = new StringBuilder();
        sb.append("Contenido{");
        sb.append("artista=").append(artista);
        sb.append(", titulo=").append(titulo);
        sb.append(", duracion=").append(duracion);
        sb.append(", likes=").append(likes);
        sb.append('}');
        return sb.toString();
    }
    
    public boolean sonIguales(Contenido c1, Contenido c2){
    
        if(c1.titulo.equals(c2) && c1.artista.equals(c2))
            {return true;}
       else{
           return false;}
        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contenido other = (Contenido) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return Objects.equals(this.artista, other.artista);
    }
    
    public String toString(){
    
        StringBuilder contenido = new StringBuilder();
        
        contenido.append("Titulo: ").append(this.titulo);
        contenido.append(" | Artista: ").append(this.artista);
        contenido.append(" | Cantidad de likes: ").append(this.likes);
        
        return contenido.toString();
    }
    
    @Override
    public int compareTo(Contenido otro){
    
        int retorno;
        
        retorno = this.artista.getApellido().compareTo(otro.artista.getApellido());
        
        if(retorno == 0){
        
            retorno = this.artista.getNombre().compareTo(otro.artista.getNombre());
            
            if(retorno == 0){
            
                retorno = this.titulo.compareTo(otro.titulo);
            }
        }
        return retorno;
    
    }
    
    
    
    
    
    
}
