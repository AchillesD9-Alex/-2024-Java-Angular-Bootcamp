package TA22_MVC.Ej2_Controllers;

import java.util.List;

import TA22_MVC.Ej2_Models.Proyecto;

public class ProyectoController {

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

    public static void updateProyecto(String idProyecto, String nombre, int horas) {
        Proyecto proyecto = new Proyecto(idProyecto, nombre, horas);
        proyecto.updateProyecto();
    }

    public static void deleteProyecto(String idProyecto) {
        Proyecto.deleteProyecto(idProyecto);
    }
    
    public static String getNextIdProyecto() {
        // Obtener todos los proyectos
        List<Proyecto> proyectos = Proyecto.getAllProyectos();
        if (proyectos.isEmpty()) {
            // Si no hay proyectos registrados, retornar el primer ID posible
            return "PR01";
        } else {
            // Obtener el último proyecto registrado
            Proyecto ultimoProyecto = proyectos.get(proyectos.size() - 1);
            // Extraer el número del ID del último proyecto
            String ultimoId = ultimoProyecto.getIdProyecto().substring(2); // Excluye "PR"
            // Incrementar el número del ID y formatearlo con "PR"
            int siguienteNumero = Integer.parseInt(ultimoId) + 1;
            String siguienteId = String.format("PR%02d", siguienteNumero);
            return siguienteId;
        }
    }
}
