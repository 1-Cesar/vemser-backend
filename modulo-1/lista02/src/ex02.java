import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex02 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        double numero,numero2;
        System.out.println("Digite um n�mero: ");
        numero = leia.nextDouble();
        System.out.println("Vez do seu amigo adivinhar...");
        System.out.println("Digite um n�mero: ");
        numero2 = leia.nextDouble();

        while(numero != numero2) {
            if (numero2 < numero) {
                System.out.println("O n�mero a ser encontrado � maior do que voc� digitou");
                System.out.println("Digite um n�mero: ");
                numero2 = leia.nextDouble();
            } else if (numero2 > numero) {
                System.out.println("O n�mero a ser encontrado � menor do que voc� digitou");
                System.out.println("Digite um n�mero: ");
                numero2 = leia.nextDouble();
            }
        }
        System.out.println("Parabens!! Voc� acertou e ganhou uma Lamborghini");

        //fechando o scanner
        leia.close();
    }
}
