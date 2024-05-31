package TA22_MVC.Ej2_Controllers;

import java.util.List;

import TA22_MVC.Ej2_Models.Cientifico;

public class CientificoController {

    public static void addCientifico(String DNI, String nomApels) {
        Cientifico cientifico = new Cientifico(DNI, nomApels);
        cientifico.addCientifico();
    }

    public static List<Cientifico> getAllCientificos() {
        return Cientifico.getAllCientificos();
    }

    public static Cientifico getCientificoByDNI(String DNI) {
        return Cientifico.getCientificoByDNI(DNI);
    }

    public static void updateCientifico(String DNI, String nomApels) {
        Cientifico cientifico = new Cientifico(DNI, nomApels);
        cientifico.updateCientifico();
    }

    public static void deleteCientifico(String DNI) {
        Cientifico.deleteCientifico(DNI);
    }
}
