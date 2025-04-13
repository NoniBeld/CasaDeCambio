package com.casadecambio.api.app;


import com.casadecambio.model.RespuestaDivisa;
import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIService {

    private static final String API_URL = "https://api.frankfurter.app/latest";

    public static double obtenerTasaCambio(String from, String to) throws Exception {
        if (from.equals(to)) {
            return 1.0; // misma moneda, misma tasa
        }

        String urlStr = "https://api.frankfurter.app/latest?from=" + from + "&to=" + to;
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("Error HTTP: " + connection.getResponseCode());
        }

        try (InputStreamReader reader = new InputStreamReader(connection.getInputStream())) {
            Gson gson = new Gson();
            RespuestaDivisa respuesta = gson.fromJson(reader, RespuestaDivisa.class);

            if (respuesta.rates == null || !respuesta.rates.containsKey(to)) {
                throw new RuntimeException("No se encontró la tasa de cambio para: " + to);
            }

            return respuesta.rates.get(to);
        }
    }

}
