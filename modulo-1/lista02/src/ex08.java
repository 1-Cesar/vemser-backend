import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex08 {
    public static void main(String[] args) {

        //Scanner para leitura de dados, matriz e variaveis
        Scanner leia = new Scanner(System.in);
        double[][] matriz = new double[5][4];
        double maiorNota = 0, matricula = 0, media = 0;

        //estrutura de repeti��o para popular a matriz
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length; j++){
                if (j == 0) {
                    System.out.println("Digite o n�mero da matricula: ");
                    matriz[i][j] = leia.nextInt();
                } else if (j == 1) {
                    System.out.println("Digite a m�dia das provas: ");
                    matriz[i][j] = leia.nextInt();
                } else if (j == 2) {
                    System.out.println("Digite a m�dia dos trabalhos: ");
                    matriz[i][j] = leia.nextInt();
                } else if (j == 3) {
                    matriz[i][j] = (matriz[i][j-2] * 0.6 + matriz[i][j-1] * 0.4);
                    if (maiorNota < matriz[i][j]) {
                        maiorNota = matriz[i][j];
                        matricula = matriz[i][j-3];
                    }
                }
            }
        }

        //sa�da no console com asterisco dividindo os alunos
        for (int i = 0; i < matriz.length; i++){
            System.out.println("*********");
            for (int j = 0; j < matriz.length; j++){
                if (j == 0) {
                    System.out.println("Matricula: " + matriz[i][j]);
                } else if (j == 1) {
                    System.out.println("M�dia das provas: " + matriz[i][j]);
                } else if (j == 2) {
                    System.out.println("M�dia dos trabalhos: " + matriz[i][j]);
                } else if (j == 3) {
                    System.out.println("M�dia final: " + matriz[i][j]);
                }
            }
        }

        //exibi��o da maior nota e matricula
        System.out.println("*********");
        System.out.println("Maior nota final: " + maiorNota);
        System.out.println("Matricula pertencente � esta nota: " + matricula);

        //fechando scanner
        leia.close();
    }
}
