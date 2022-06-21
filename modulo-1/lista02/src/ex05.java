import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex05 {
    public static void main(String[] args) {

        //Scanner para leitura de valores
        Scanner leia = new Scanner(System.in);

        //vetor para armazenamento de valores
        double[] vetor = new double[20];

        //populando vetor
        for (int contador = 0; contador < vetor.length; contador++) {
            System.out.println("Digite o numero");
            vetor[contador] = leia.nextDouble();
        }

        //colocando vetor em ordem decrescente
        for (int contador = 0; contador < vetor.length; contador++) {
            for (int contador2 = 0; contador2 < contador; contador2++) {
                if (vetor[contador] > vetor[contador2]) {
                    double aux = vetor[contador];
                    vetor[contador] = vetor[contador2];
                    vetor[contador2] = aux;
                }
            }
        }

        //exibindo vetor
        for (int cont = 0; cont < vetor.length; cont++) {
            System.out.println(vetor[cont]);
        }

        //fechando scanner
        leia.close();
    }
}
