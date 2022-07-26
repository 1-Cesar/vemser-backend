package homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ex02 {

    public void segundo() {

        System.out.println("\nInformar duas datas e comparar quantos dias meses e anos elas tem de diferença uma da outra");

        Scanner leia = new Scanner(System.in);

        int conversor = 1;

        System.out.println("Digite a primeira data (dia/mes/ano): ");
        String data = leia.nextLine();
        System.out.println("Digite a segunda data (dia/mes/ano): ");
        String data2 = leia.nextLine();

        LocalDate dataFormatada = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataFormatada2 = LocalDate.parse(data2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (dataFormatada.isBefore(dataFormatada2)) {
            conversor = -1;
        }

        System.out.println("Dias: " + ChronoUnit.DAYS.between(dataFormatada2, dataFormatada) * conversor);
        System.out.println("Meses: " + ChronoUnit.MONTHS.between(dataFormatada2, dataFormatada) * conversor);
        System.out.println("Anos: " + ChronoUnit.YEARS.between(dataFormatada2, dataFormatada) * conversor);

    }
}

