import java.util.Scanner;
/**
 * @author cesar
 * @date 20/06/2022
 * @version vemSer
 */
public class ex06 {
    public static void main(String[] args) {
        //declaracao de variavel
        String palavra;
        //scanner para leitura de dados
        Scanner leia = new Scanner(System.in);

        //entrada de dados
        System.out.println("Digite uma palavra para traduzir: ");
        palavra = leia.nextLine();

        //estrura condicional para identificar o idioma e traduzir
        if (palavra.equals("Cachorro")) {
            System.out.println("Dog");
        } else if (palavra.equals("Dog")) {
            System.out.println("Cachorro");
        } else if (palavra.equals("Tempo")) {
            System.out.println("Time");
        } else if (palavra.equals("Time")) {
            System.out.println("Tempo");
        } else if (palavra.equals("Amor")) {
            System.out.println("Love");
        } else if (palavra.equals("Love")) {
            System.out.println("Amor");
        } else if (palavra.equals("Cidade")) {
            System.out.println("City");
        } else if (palavra.equals("City")) {
            System.out.println("Cidade");
        } else if (palavra.equals("Feliz")) {
            System.out.println("Happy");
        } else if (palavra.equals("Happy")) {
            System.out.println("Feliz");
        } else if (palavra.equals("Triste")) {
            System.out.println("Sad");
        } else if (palavra.equals("Sad")) {
            System.out.println("Triste");
        } else if (palavra.equals("Deveria")) {
            System.out.println("Shoud");
        } else if (palavra.equals("Shoud")) {
            System.out.println("Deveria");
        } else if (palavra.equals("Poderia")) {
            System.out.println("Could");
        } else if (palavra.equals("Could")) {
            System.out.println("Poderia");
        } else {
            System.out.println("Essa palavra não é válida");
        }
    }
}
