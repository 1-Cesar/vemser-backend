import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex02 {
    public static void main(String[] args) {

        //declaracao de variaveis
        float nota1, nota2, nota3, nota4, media;

        //scanner para leitura de dados
        Scanner leia = new Scanner(System.in);

        //entrada de dados
        System.out.println("Digite a primeira nota: ");
        nota1 = leia.nextFloat();
        System.out.println("Digite a segunda nota: ");
        nota2 = leia.nextFloat();
        System.out.println("Digite a terceira nota: ");
        nota3 = leia.nextFloat();
        System.out.println("Digite a quarta nota: ");
        nota4 = leia.nextFloat();

        //calculo de media
        media = (nota1 + nota2 + nota3 + nota4) / 4;

        //estrutura condicional com saida no console
        if (media >= 0 && media <= 5) {
            System.out.println("\n Reprovado \n Media: " + media);
        } else if (media >= 5.1 && media <= 6.9) {
            System.out.println("\n Em exame \n Media: " + media);
        }
        else {
            System.out.println("\n Aprovado \n Media: " + media);
        }
    }
}
