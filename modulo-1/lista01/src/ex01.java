import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex01 {
    public static void main(String[] args) {
        //declara��o de vari�veis
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
        System.out.println("Ol� seu nome � " + nome + ", voc� tem " + idade + " anos," + "� da cidade de " + cidade + ", situada no Estado de " + estado + ".");
    }
}
