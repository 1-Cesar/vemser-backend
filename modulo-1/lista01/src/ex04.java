import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex04 {
    public static void main(String[] args) {
        //declaracao de variavel
        int estado;
        //scanner para leitura de dados
        Scanner leia = new Scanner(System.in);

        //console personalizado para entrada de dados
        System.out.println("\n Estados disponíveis\n" +
                "\n 1- São Paulo \n 2- Paraná \n 3- Santa Catarina \n");
        System.out.println("Digite uma opção: ");
        estado = leia.nextInt();

        //estrutura de "escolha" para apresentação das cidades no console
        switch (estado) {
            case 1:
                System.out.println("\n Cidades: \n Informações \n" +
                        "\n * São Paulo:" +
                        "\n População - 12.396.372 habitantes \n IDH - 0,805 \n Altitude - 772m \n" +
                        "------------------------- \n" +
                        " * São José dos Campos: \n" +
                        " População - 737.310 habitantes \n IDH - 0,807 \n Altitude - 600m");
                break;
            case 2:
                System.out.println("\n Cidades: \n Informações \n" +
                        "\n * Curitiba:" +
                        "\n População - 1.963.726 habitantes \n IDH - 0,823 \n Altitude - 934m \n" +
                        "------------------------- \n" +
                        " * Londrina: \n" +
                        " População - 580.870 habitantes \n IDH - 0,778 \n Altitude - 610m");
                break;
            case 3:
                System.out.println("\n Cidades: \n Informações \n" +
                        "\n * Abdon Batista:" +
                        "\n População - 2.577 habitantes \n IDH - 0,774 \n Altitude - 716m \n" +
                        "------------------------- \n" +
                        " * Abelardo Luz: \n" +
                        " População - 17.847 habitantes \n IDH - 0,785 \n Altitude - 760m");
                break;
            //mensagem no console quando nenhuma opção é atendida
            default:
                System.out.println("Opção inválida");
        }
    }
}
