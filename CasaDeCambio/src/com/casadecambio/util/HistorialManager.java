package com.casadecambio.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HistorialManager {

    private static final String ARCHIVO_HISTORIAL = "historial.txt";

    public static void guardarHistorial(String entrada) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_HISTORIAL, true))) {
            writer.write(entrada);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error guardando historial: " + e.getMessage());
        }
    }

    public static String leerHistorial() {
        try {
            return Files.readString(Paths.get(ARCHIVO_HISTORIAL));
        } catch (IOException e) {
            return "No hay historial aún.";
        }
    }
}
