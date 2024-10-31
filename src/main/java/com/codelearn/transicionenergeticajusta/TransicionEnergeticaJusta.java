package com.codelearn.transicionenergeticajusta;

import Model.EnergiaEolica;
import Services.EnergiaRenovableService;
import Vistas.VistaPrincipal;

import java.util.List;

/**
 * @author MI PC
 */
public class TransicionEnergeticaJusta {

    public static void main(String[] args) {
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        vistaPrincipal.setSize(800, 600);
        vistaPrincipal.setLocationRelativeTo(null);
        vistaPrincipal.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        vistaPrincipal.setVisible(true);
    }
}
