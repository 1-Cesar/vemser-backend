import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex04 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        //declaracao de vetor e variavel posicao
        double[] vetor = new double[3];
        int posicao = 0;

        //populando o vetor
        for (int contador = 0; contador < vetor.length; contador ++){
            System.out.println("Digite um n�mero: ");
            vetor[contador] = leia.nextDouble();
        }

        //comparando as posi��es do vetor
        for (int controle = 0; controle < vetor.length; controle++) {
            for (int controle2 = 0; controle2 < vetor.length; controle2++) {
                if (vetor[controle] < vetor[controle2]) {
                    posicao = controle2;
                }
            }
        }

        //exibi��o de posi��o no console
        System.out.println("Posi��o do vetor com maior n�mero: " + posicao);

        //fechando o scanner
        leia.close();
    }
}
