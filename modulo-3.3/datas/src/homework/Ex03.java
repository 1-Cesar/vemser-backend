package homework;

import java.time.LocalDateTime;

public class Ex03 {

    public void terceiro () {
        System.out.println("\nImprimir qual é o dia da semana e o dia do ano (corrido) correspondente da data atual + 15 dias e 10 horas");
        LocalDateTime atual = LocalDateTime.now();

        atual = atual.plusDays(15).plusHours(10);

        switch (atual.getDayOfWeek()){
            case MONDAY -> {
                System.out.println("Segunda-Feira");
            }
            case TUESDAY -> {
                System.out.println("Terça-Feira");
            }
            case WEDNESDAY -> {
                System.out.println("Quarta-Feira");
            }
            case THURSDAY -> {
                System.out.println("Quinta-Feira");
            }
            case FRIDAY -> {
                System.out.println("Sexta-Feira");
            }
            case SATURDAY -> {
                System.out.println("Sabado");
            }
            case SUNDAY -> {
                System.out.println("Domingo");
            }
        }
        System.out.println("Dia corrido: " + atual.getDayOfYear());
    }
}
