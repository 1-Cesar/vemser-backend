package homework;

import java.sql.SQLOutput;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Ex04 {

    public void quarto() {
        System.out.println("\nVocê tem um show do Wesley Safadão com o Black Sabbath para ir no dia 14/09/2024 às 18h30 em Londres, utilizando LocalDateTime, mostrar quantos anos, meses, dias, horas, minutos e segundos faltam para o evento\n");

        LocalDateTime dataHj = LocalDateTime.now().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();

        LocalDateTime show = LocalDateTime.of(2024,9,14,18,30,0).atZone(ZoneId.of("Europe/London")).toLocalDateTime();

        Long anos = ChronoUnit.YEARS.between(dataHj, show);
        dataHj = dataHj.plusYears(anos);
        Long meses = ChronoUnit.MONTHS.between(dataHj, show);
        dataHj = dataHj.plusMonths(meses);
        Long dias = ChronoUnit.DAYS.between(dataHj, show);
        dataHj = dataHj.plusDays(dias);
        Long horas = ChronoUnit.HOURS.between(dataHj, show);
        dataHj = dataHj.plusHours(horas);
        Long minutos = ChronoUnit.MINUTES.between(dataHj, show);
        dataHj = dataHj.plusMinutes(minutos);
        Long segundos = ChronoUnit.SECONDS.between(dataHj, show);

        System.out.println("Contagem regressiva até o show com Wesley Safadao e Black Sabbath: " + anos + " anos / " + meses + " meses / " + dias + " dias / " + horas + " horas / " + minutos + " minutos / " + segundos + " segundos.");
    }

}
