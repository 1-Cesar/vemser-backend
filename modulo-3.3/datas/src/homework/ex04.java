package homework;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class ex04 {

    public void quarto() {
        System.out.println("\nVocê tem um show do Wesley Safadão com o Black Sabbath para ir no dia 14/09/2024 às 18h30 em Londres, utilizando LocalDateTime, mostrar quantos anos, meses, dias, horas, minutos e segundos faltam para o evento");
        LocalDateTime show = LocalDateTime.of(2024, 9, 14, 18, 30);
        ZoneId zoneId = ZoneId.of("Europe/London");

        ZoneId fuso = ZoneId.systemDefault();
        LocalDateTime atual = LocalDateTime.now();

        ZonedDateTime zonedDateTime = ZonedDateTime.of(show, zoneId);
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(atual, fuso);

        System.out.println("anos: " +  ChronoUnit.YEARS.between(zonedDateTime2.toLocalDate(), zonedDateTime.toLocalDate()));
        System.out.println("meses: " +  ChronoUnit.MONTHS.between(zonedDateTime2.toLocalDate(), zonedDateTime.toLocalDate()));
        System.out.println("dias: " +  ChronoUnit.DAYS.between(zonedDateTime2.toLocalDate(), zonedDateTime.toLocalDate()));
        System.out.println("horas: " +  ChronoUnit.HOURS.between(zonedDateTime2.toLocalDateTime(), zonedDateTime.toLocalDateTime()));
        System.out.println("minutos: " +  ChronoUnit.MINUTES.between(zonedDateTime2.toLocalDateTime(), zonedDateTime.toLocalDateTime()));
        System.out.println("segundos: " +  ChronoUnit.SECONDS.between(zonedDateTime2.toLocalDateTime(), zonedDateTime.toLocalDateTime()));
    }

}
