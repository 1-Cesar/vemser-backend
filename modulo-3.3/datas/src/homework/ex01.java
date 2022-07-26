package homework;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ex01 {

    public void primeiro() throws ParseException {

    System.out.println("Pedir para o usuário informar a sua data de aniversário, fazer o cálculo de quantos dias e meses faltam até a próxima data");

    Scanner leia = new Scanner(System.in);

    System.out.println("Digite a data do seu aniversário (dia/mes/ano): ");
    String aniversario = leia.nextLine();

    LocalDate aniversarioFormatado = LocalDate.parse(aniversario, DateTimeFormatter.ofPattern("dd/MM/yyyy")).withYear(LocalDate.now().getYear());

    LocalDate dataHj = LocalDate.now();

    int mes = aniversarioFormatado.getMonthValue();

        if (mes > dataHj.getMonthValue()) {

            int diferencaMes = mes - dataHj.getMonthValue();

            int diaAniversario = aniversarioFormatado.getDayOfMonth();
            int diaAtual = dataHj.getDayOfMonth();

            System.out.println("Faltam: " + diferencaMes + " meses e " + (diaAniversario - diaAtual) + " dias para seu aniversário");
        }
        else {
                Period periodo = Period.between(dataHj, aniversarioFormatado.plusYears(1));

                System.out.println("Faltam: " + periodo.getMonths()+ " meses e " + periodo.getDays() + " dias para seu aniversário.");
        }
    }
}

