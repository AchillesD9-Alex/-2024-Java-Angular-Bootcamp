package TA22_MVC.Ej2_Controllers;

import java.util.List;

import TA22_MVC.Ej2_Models.Cientifico;
import TA22_MVC.Ej2_Models.Proyecto;

public class ProyectoController {
	
	public List<String> getAllNombresProyectos() {
        return Proyecto.getAllNombresProyectos();
    }
	
    public static void addProyecto(String idProyecto, String nombre, int horas) {
        Proyecto proyecto = new Proyecto(idProyecto, nombre, horas);
        proyecto.addProyecto();
    }

    public static List<Proyecto> getAllProyectos() {
        return Proyecto.getAllProyectos();
    }

    public static Proyecto getProyectoById(String idProyecto) {
        return Proyecto.getProyectoById(idProyecto);
    }

    public static void updateProyecto(String idProyecto, String nombre, Integer horas) {
        Proyecto.updateProyecto(idProyecto, nombre, horas);
    }

    public static void deleteProyecto(String idProyecto) {
        Proyecto.deleteProyecto(idProyecto);
    }
}