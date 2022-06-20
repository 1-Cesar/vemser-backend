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
        System.out.println("\n Estados dispon�veis\n" +
                "\n 1- S�o Paulo \n 2- Paran� \n 3- Santa Catarina \n");
        System.out.println("Digite uma op��o: ");
        estado = leia.nextInt();

        //estrutura de "escolha" para apresenta��o das cidades no console
        switch (estado) {
            case 1:
                System.out.println("\n Cidades: \n Informa��es \n" +
                        "\n * S�o Paulo:" +
                        "\n Popula��o - 12.396.372 habitantes \n IDH - 0,805 \n Altitude - 772m \n" +
                        "------------------------- \n" +
                        " * S�o Jos� dos Campos: \n" +
                        " Popula��o - 737.310 habitantes \n IDH - 0,807 \n Altitude - 600m");
                break;
            case 2:
                System.out.println("\n Cidades: \n Informa��es \n" +
                        "\n * Curitiba:" +
                        "\n Popula��o - 1.963.726 habitantes \n IDH - 0,823 \n Altitude - 934m \n" +
                        "------------------------- \n" +
                        " * Londrina: \n" +
                        " Popula��o - 580.870 habitantes \n IDH - 0,778 \n Altitude - 610m");
                break;
            case 3:
                System.out.println("\n Cidades: \n Informa��es \n" +
                        "\n * Abdon Batista:" +
                        "\n Popula��o - 2.577 habitantes \n IDH - 0,774 \n Altitude - 716m \n" +
                        "------------------------- \n" +
                        " * Abelardo Luz: \n" +
                        " Popula��o - 17.847 habitantes \n IDH - 0,785 \n Altitude - 760m");
                break;
            //mensagem no console quando nenhuma op��o � atendida
            default:
                System.out.println("Op��o inv�lida");
        }
    }
}
