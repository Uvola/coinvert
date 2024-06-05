package com.aluracursos.coinvert;


import com.aluracursos.coinvert.api.Cliente;
import com.aluracursos.coinvert.divisas.Divisas;

import com.aluracursos.coinvert.mensajes.Texto;
import com.aluracursos.coinvert.ui.UiHandler;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        Cliente cliente = new Cliente(gson);
        Texto texto = new Texto();
        UiHandler uiHandler = new UiHandler(texto);
        Divisas divisas = new Divisas(uiHandler);

        uiHandler.showWelcomeMessage();

        while (true) {
            String base = divisas.selectorDivisa("Seleccione una divisa base:");
            System.out.println("¿Qué monto deseas cambiar?");
            float monto = (float) uiHandler.getUserInput();
            String target = divisas.selectorDivisa("Seleccione la divisa de destino:");

            try {
                ExchangeRate exchangeRate = cliente.getExchangeRate(base, target);
                float cambio = divisas.conversorDivisas((float)exchangeRate.conversion_rate(), monto);
                uiHandler.showExchangeRate(base, target, exchangeRate.conversion_rate());
                uiHandler.showConversion(cambio, base, target);
            } catch (IOException | InterruptedException e) {
                System.err.println("Error al obtener la tasa de cambio: " + e.getMessage());
            }

            uiHandler.showMessage("¿Desea realizar otra conversión? (s/n)");
            String again = uiHandler.getUserInputString();
            if (!again.equalsIgnoreCase("s")) {
                break;
            }
        }
    }
}
