package com.aluracursos.coinvert.divisas;

import com.aluracursos.coinvert.ui.UiHandler;

public class Divisas {
    private final UiHandler uiHandler;

    public Divisas(UiHandler uiHandler) {
        this.uiHandler = uiHandler;
    }

    public String selectorDivisa(String prompt) {
        while (true) {
            uiHandler.showMessage(prompt);
            uiHandler.showDivisas();
            int input = uiHandler.getUserInput();

            switch (input) {
                case 1:
                    return "USD";
                case 2:
                    return "EUR";
                case 3:
                    return "MXN";
                case 4:
                    return "JPY";
                case 5:
                    return "GBP";
                default:
                    uiHandler.showMessage("Por favor, seleccione una opción válida.");
            }
        }
    }

    public float conversorDivisas (float exchangeRate, float monto){
        return monto * exchangeRate;
    }
}

