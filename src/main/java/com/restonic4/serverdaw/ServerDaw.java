package com.restonic4.serverdaw;

import net.fabricmc.api.ModInitializer;

import javax.swing.*;

public class ServerDaw implements ModInitializer {
    public static String customName = null;

    @Override
    public void onInitialize() {
        System.out.println("La inyeccion de codigo esta en otra clase");
    }

    public static String getName() {
        if (customName == null) {
            customName = JOptionPane.showInputDialog("Escribe tu nombre de usuario, no uses espacion o simbolos extraños: ");
        }

        return customName;
    }
}
