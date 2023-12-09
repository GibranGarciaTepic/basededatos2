/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gg1br
 */
public class Escuela {
     String numcontrol;
    String nombrealumno;
    String carrera;
    String fechaexpedicion;
    String semestre;
    
    public Escuela(String d, String t, String i, String n, String g){
        numcontrol = i;
        nombrealumno = n;
        carrera = d;
        fechaexpedicion = g;
        semestre = t;
    }   
    public String[] toReglon(){
        String[] vector = new String[4];
        vector[0]=numcontrol;
        vector[1]=nombrealumno;
        vector[2]=carrera;
        vector[3]=fechaexpedicion;
        vector[4]=semestre;
        return vector;
    }
}
