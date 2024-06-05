package com.aluracursos.coinvert.ui;

import com.aluracursos.coinvert.mensajes.Texto;
import java.util.Scanner;

public class UiHandler {
    private final Scanner scanner;
    private final Texto texto;

    public UiHandler(Texto texto) {
        this.scanner = new Scanner(System.in);
        this.texto = texto;
    }

    public void showWelcomeMessage() {
        System.out.println("Bienvenido a Coinvert");
    }

    public void showDivisas(){
        texto.divisas();
    }

    public int getUserInput() {
        return scanner.nextInt();
    }

    public String getUserInputString() {
        return scanner.next();
    }

    public void showExchangeRate(String base, String target, double rate) {
        System.out.printf("La tasa de cambio de %s a %s es: %f%n", base, target, rate);
    }

    public void showConversion(float monto, String base, String target) {
        System.out.printf("Obtuviste %.2f %s por tus %s%n", monto, target, base);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}

