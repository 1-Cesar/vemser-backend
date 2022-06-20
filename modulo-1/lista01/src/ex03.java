import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex03 {
    public static void main(String[] args) {

        //declaracao de variaveis
        float consumido, pago, troco;
        //scanner para leitura de dados
        Scanner leia = new Scanner(System.in);
        //entrada de dados
        System.out.println("Digite o total consumido: ");
        consumido = leia.nextFloat();
        System.out.println("Digite o valor pago pelo cliente: ");
        pago = leia.nextFloat();

        //calculo de troco
        troco = pago - consumido;

        //estrutura condicional com saida no console
        if (consumido > pago) {
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido");
        }
        else if (consumido < pago) {
            System.out.println("Conta paga ! Troco do cliente: R$" + troco);
        }
        else {
            System.out.println("Conta paga !");
        }
    }
}
