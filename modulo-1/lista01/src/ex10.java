import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex10 {
    public static void main(String[] args) {
        //declaracao de variaveis
        int eleitores, brancos, nulos, validos;
        //scanner para leitura de dados
        Scanner leia = new Scanner(System.in);
        //entrada de dados
        System.out.println("Digite o n�mero total de eleitores: ");
        eleitores = leia.nextInt();
        System.out.println("Digite o n�meros de votos brancos: ");
        brancos = leia.nextInt();
        System.out.println("Digite o n�mero de votos nulos: ");
        nulos = leia.nextInt();
        System.out.println("Digite o n�mero de votos v�lidos: ");
        validos = leia.nextInt();

        //calculo do percentural de cada voto
        brancos = (100 * brancos) / eleitores;
        nulos = (100 * nulos) / eleitores;
        validos = (100 * validos) / eleitores;

        //exibi��o do percentual no console
        System.out.println("Percentual de votos em branco: " + brancos + "%");
        System.out.println("Percentual de votos nulos: " + nulos + "%");
        System.out.println("Percentual de votos validos: " + validos + "%");

    }
}
