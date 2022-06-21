import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex07 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        //matriz
        double[][] matriz = new double[4][4];
        //contador de valores maiores que 10
        int contador = 0;

        //populando a matriz
        for (int i = 0; i < matriz.length;i++) {
            for(int j = 0; j < matriz.length; j++){
                System.out.println("Digite o valor: ");
                matriz[i][j] = leia.nextDouble();
                if (matriz[i][j] > 10){
                    contador += 1;
                }
            }
        }
        //exibindo qtd no console
        System.out.println("Quantidade de valores maiores que 10: " + contador);
    }
}
