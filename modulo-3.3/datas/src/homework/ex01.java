package homework;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ex01 {

    public void primeiro() throws ParseException {

    System.out.println("Pedir para o usu�rio informar a sua data de anivers�rio, fazer o c�lculo de quantos dias e meses faltam at� a pr�xima data");

    Scanner leia = new Scanner(System.in);

    System.out.println("Digite a data do seu anivers�rio (dia/mes/ano): ");
    String aniversario = leia.nextLine();

    LocalDate aniversarioFormatado = LocalDate.parse(aniversario, DateTimeFormatter.ofPattern("dd/MM/yyyy")).withYear(LocalDate.now().getYear());

    LocalDate dataHj = LocalDate.now();

    int mes = aniversarioFormatado.getMonthValue();

        if (mes > dataHj.getMonthValue()) {

            int diferencaMes = mes - dataHj.getMonthValue();

            int diaAniversario = aniversarioFormatado.getDayOfMonth();
            int diaAtual = dataHj.getDayOfMonth();

            System.out.println("Faltam: " + diferencaMes + " meses e " + (diaAniversario - diaAtual) + " dias para seu anivers�rio");
        }
        else {
                Period periodo = Period.between(dataHj, aniversarioFormatado.plusYears(1));

                System.out.println("Faltam: " + periodo.getMonths()+ " meses e " + periodo.getDays() + " dias para seu anivers�rio.");
        }
    }
}

