/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author jairj
 */
public class Podcast extends Contenido implements Publicitable{
    private TipoPodcast tipoPodcast;

    public Podcast(String titulo, int duracion, String nombreArtista, String apellidoArtista, String paisArtista, TipoPodcast tipoPodcast) {
        super(titulo, duracion, nombreArtista, apellidoArtista, paisArtista);
        this.tipoPodcast = tipoPodcast;
    }

    @Override
    public int getDuracionConPublicidad(){

        switch(this.tipoPodcast){

                case TECNOLOGIA:
                    return this.duracion + 60;
                case ENTRETENIMIENTO:
                    return this.duracion + 45;
                case EDUCACION:
                    return this.duracion + 20;

            }
        
        return this.duracion;
    
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" | Podcast");
        sb.append(" | Tipo de Podcast: ").append(tipoPodcast);
        sb.append(" | Duracion con publicidad: ").append(this.getDuracionConPublicidad());
        
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj){
    
        if(super.equals(obj) && obj instanceof Podcast){
            Podcast aux = (Podcast) obj;
            
            return this.tipoPodcast == aux.tipoPodcast;}
        
        return false;
    }
    
    
    
}
