import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex08 {
    public static void main(String[] args) {
        //declaracao de variaveis
        float base, altura, area;
        //scanner para leitura de dados
        Scanner leia = new Scanner(System.in);

        //entrada de dados
        System.out.println("Digite a base do Ret�ngulo: ");
        base = leia.nextFloat();
        System.out.println("Digite a altura do Ret�ngulo: ");
        altura = leia.nextFloat();

        //calculo de area do retangulo
        area = base * altura;

        //exibi��o do resultado do calculo no console
        System.out.println("�rea do Ret�ngulo: " + area);
    }
}
