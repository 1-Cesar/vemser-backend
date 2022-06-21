import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex03 {
    public static void main(String[] args) {

        //scanner para leitura de dados
        Scanner leia = new Scanner(System.in);

        //declaração de variaveis com inicialização
        String nome = "";
        float altura,peso, maisPesado = 0, maiorAltura = 0, mediaAltura = 0, somaAltura = 0;
        int cont = 0, idade, maisVelho = 0;

        //classe para formatação de float no console
        DecimalFormat df = new DecimalFormat("0.00");

        //condição de saída antes do loop
        while (!nome.toLowerCase().equals("sair")) {

            //entrada de dados
            System.out.println("Digite o nome: ");
            nome = leia.nextLine();

            //condição de saída dentro do loop
            if (nome.toLowerCase().equals("sair")){
                break;
            } else {
                //contador de registros
                cont += 1;
            }

            //entrada de dados
            System.out.println("Digite a altura: ");
            altura = leia.nextFloat();
            System.out.println("Digite a idade: ");
            idade = leia.nextInt();
            System.out.println("Digite o peso: ");
            peso = leia.nextFloat();

            //limpa o scanner
            leia.nextLine();

            //verifica o jogador mais alto
            if (altura >= maiorAltura) {
                maiorAltura = altura;
            }

            //verifica o jogador mais velho
            if (idade >= maisVelho) {
                maisVelho = idade;
            }

            //verifica o jogador mais pesado
            if (peso >= maisPesado) {
                maisPesado = peso;
            }

            //soma da altura dos jogadores
            somaAltura = somaAltura + altura;

            //media da altura dos jogadores
            mediaAltura = somaAltura/cont;
        }

        //informações dos jogadores no console
        System.out.println("\nQuantidade de jogadores cadastrados: " + cont);
        System.out.println("Altura do maior jogador: " + df.format(maiorAltura) + " m");
        System.out.println("Idade do jogador mais velho: " + maisVelho + " anos");
        System.out.println("Jogador mais pesado: " + maisPesado + " kg");
        System.out.println("Média das alturas dos jogadores: " + df.format(mediaAltura) + " m");

        //fechando o scanner
        leia.close();
    }
}
