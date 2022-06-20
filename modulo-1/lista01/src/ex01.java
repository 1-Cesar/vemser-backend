import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex01 {
    public static void main(String[] args) {
        //declaração de variáveis
        String nome, cidade, estado, idade;

        //scanner para leitura de dados
        Scanner leia = new Scanner(System.in);

        //entrada de dados
        System.out.print("Digite seu nome: ");
        nome = leia.nextLine();

        System.out.print("Digite sua idade: ");
        idade = leia.nextLine();

        System.out.print("Digite sua cidade: ");
        cidade = leia.nextLine();

        System.out.print("Digite seu Estado: ");
        estado = leia.nextLine();

        //saida no console
        System.out.println("Olá seu nome é " + nome + ", você tem " + idade + " anos," + "é da cidade de " + cidade + ", situada no Estado de " + estado + ".");
    }
}
