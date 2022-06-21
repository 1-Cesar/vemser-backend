import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex01 {
    public static void main(String[] args) {
        String produto;
        float valor, desconto;
        Scanner leia = new Scanner(System.in);

        System.out.println("Digite o nome do produto: ");
        produto = leia.nextLine();

        System.out.println("Digite o preço do produto: ");
        valor = leia.nextFloat();

        //informações do produto
        System.out.println("\nProduto: " + produto);
        System.out.printf("R$ %.2f", valor);
        System.out.println("\nPromoção: " + produto + "\n" + "----------------");

        //primeiro percentual de desconto
        float percentual = 5;

        for (int controle = 1; controle <= 10; controle++) {

            //calculo de desconto
            desconto = valor - (valor*(percentual/100));

            //utilização da classe Decimal Format para personalização de saída float no console
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println(controle + " x R$ " + df.format(desconto) + " = R$ " + df.format(desconto*controle));

            //acrescimo de 5% para o proximo calculo de desconto
            percentual += 5;
        }

        //fechando o scanner
        leia.close();
    }
}
