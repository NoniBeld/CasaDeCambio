package com.casadecambio.app;

import javax.swing.JOptionPane;

import com.casadecambio.api.app.APIService;
import com.casadecambio.util.HistorialManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Main {

	private static final Map<String, String> MONEDAS_VALIDAS = Map.ofEntries(
		    Map.entry("USD", "Dólar estadounidense"),
		    Map.entry("EUR", "Euro"),
		    Map.entry("GBP", "Libra esterlina"),
		    Map.entry("JPY", "Yen japonés"),
		    Map.entry("MXN", "Peso mexicano"),
		    Map.entry("CAD", "Dólar canadiense"),
		    Map.entry("CHF", "Franco suizo"),
		    Map.entry("BRL", "Real brasileño")
		    // Puedes agregar más
		);
	
    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        while (true) {
            String[] opciones = {
                "1. Convertir divisa",
                "2. Ver historial",
                "3. Salir"
            };
            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:",
                    "Casa de Cambio", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            if (seleccion == null || seleccion.equals("3. Salir")) {
                break;
            }

            switch (seleccion) {
                case "1. Convertir divisa":
                    convertirDivisa();
                    break;
                case "2. Ver historial":
                    JOptionPane.showMessageDialog(null, HistorialManager.leerHistorial());
                    break;
            }
        }
    }

    private static void convertirDivisa() {
        try {
            // Crear listas desplegables
            Object[] opcionesMonedas = MONEDAS_VALIDAS.keySet().toArray();

            String from = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecciona la moneda de origen:",
                    "Moneda Origen",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionesMonedas,
                    "USD");

            if (from == null) return;

            String to = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecciona la moneda destino:",
                    "Moneda Destino",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionesMonedas,
                    "EUR");

            if (to == null) return;

            double cantidad;
            while (true) {
                String cantidadStr = JOptionPane.showInputDialog("Cantidad a convertir:");
                if (cantidadStr == null) return;
                try {
                    cantidad = Double.parseDouble(cantidadStr);
                    if (cantidad <= 0) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Cantidad inválida. Ingresa un número mayor a 0.");
                }
            }

            double tasa = APIService.obtenerTasaCambio(from, to);
            double total = cantidad * tasa;

            String resultado = String.format("""
                    Tasa de cambio actual: 1 %s = %.4f %s
                    -----------------------------
                    %.2f %s = %.4f %s
                    """, from, tasa, to, cantidad, from, total, to);

            JOptionPane.showMessageDialog(null, resultado, "Resultado de Conversión", JOptionPane.INFORMATION_MESSAGE);


            String marcaTiempo = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            HistorialManager.guardarHistorial(marcaTiempo + " - " + resultado);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al realizar la conversión: " + e.getMessage());
        }
    }

}
