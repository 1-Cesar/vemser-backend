import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex09 {
    public static void main(String[] args) {
        //declaracao de variaveis
        int anos, meses, dias;
        //scanner para leitura de dados
        Scanner leia = new Scanner(System.in);

        //entrada de dados por parte do usuário
        System.out.println("Digite sua idade em anos: ");
        anos = leia.nextInt();
        System.out.println("Digite sua idade em meses: ");
        meses = leia.nextInt();
        System.out.println("Digite sua idade em dias: ");
        dias = leia.nextInt();

        //calculo de dados
        dias = (dias + (anos * 365) + (meses * 30));

        //exibição do calculo no console
        System.out.println("Sua idade é dias é: " + dias);
    }
}
