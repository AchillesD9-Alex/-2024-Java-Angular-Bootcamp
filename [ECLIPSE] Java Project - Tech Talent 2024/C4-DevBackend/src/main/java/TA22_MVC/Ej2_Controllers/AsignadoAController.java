package TA22_MVC.Ej2_Controllers;

import java.util.List;

import TA22_MVC.Ej2_Models.AsignadoA;

public class AsignadoAController {

    public static void addAsignadoA(String idProyecto, String DNI) {
        AsignadoA asignadoA = new AsignadoA(idProyecto, DNI);
        asignadoA.addAsignadoA();
    }

    public static List<AsignadoA> getAllAsignados() {
        return AsignadoA.getAllAsignados();
    }

    public static AsignadoA getAsignadoById(String idProyecto, String DNI) {
        return AsignadoA.getAsignadoById(idProyecto, DNI);
    }

    public static void updateAsignadoA(String idProyecto, String DNI, String idProyecto2) {
        AsignadoA asignadoA = new AsignadoA(idProyecto, DNI);
        asignadoA.updateAsignadoA();
    }

    public void deleteAsignadoA(String idProyecto, String DNI) {
        AsignadoA.deleteAsignadoA(idProyecto, DNI);
    }
    
}