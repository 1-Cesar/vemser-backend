import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex05 {
    public static void main(String[] args) {
        //declaracao de variaveis
        float horaValor, salario;
        int horasTrabalhadas, horas50, horas100;

        //scanner para leitura de dados
        Scanner leia = new Scanner(System.in);

        //entrada de dados
        System.out.println("Digite o valor da hora: ");
        horaValor = leia.nextFloat();
        System.out.println("Digite o número de horas normais trabalhadas: ");
        horasTrabalhadas = leia.nextInt();
        System.out.println("Digite o número de horas extras 50%: ");
        horas50 = leia.nextInt();
        System.out.println("Digite o número de horas extras 100%: ");
        horas100 = leia.nextInt();

        //calculo de salario
        salario = (float) ((horasTrabalhadas * horaValor) + (horas50 * horaValor * 1.5) + (horas100 * horaValor * 2));

        //exibição de salario no console
        System.out.println("Salário R$: " + salario);
    }
}
