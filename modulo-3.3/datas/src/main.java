import homework.Ex01;
import homework.Ex02;
import homework.Ex03;
import homework.Ex04;

import java.text.ParseException;


public class main {
    public static void main(String[] args) throws ParseException {

        Ex01 primeiro = new Ex01();
        Ex02 segundo = new Ex02();
        Ex03 terceiro = new Ex03();
        Ex04 quarto = new Ex04();

        primeiro.primeiro();
        segundo.segundo();
        terceiro.terceiro();
        quarto.quarto();
    }
}
