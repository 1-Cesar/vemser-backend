import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex06 {
    public static void main(String[] args) {

        //construindo vetor sem solicitar ao usuário
        int[] vetor = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //Scanner para entrada de dados
        Scanner leia = new Scanner(System.in);

        //declaracao de variavel
        int valor1;
        boolean controle = false;

        System.out.println("Digite um número: ");
        valor1 = leia.nextInt();

        //verificando vetor
        for (int i = 0; i < vetor.length; i++) {
            if (valor1 == vetor[i]) {
                System.out.println("Número já existe, não adicionado. Digitado: " + valor1);
                controle = true;
                break;
            }
        }

        if (controle == false) {
            //nao adicionei em nenhuma posição pois, o exercício nao explicita em qual posição deve ser adicionado
            System.out.println("Número não existe, adicionado. Digitado: " + valor1);
        }
    }
}

