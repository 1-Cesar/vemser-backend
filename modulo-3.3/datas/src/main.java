import homework.ex01;
import homework.ex02;
import homework.ex03;
import homework.ex04;

import java.text.ParseException;


public class main {
    public static void main(String[] args) throws ParseException {

        ex01 primeiro = new ex01();
        ex02 segundo = new ex02();
        ex03 terceiro = new ex03();
        ex04 quarto = new ex04();

        primeiro.primeiro();
        segundo.segundo();
        terceiro.terceiro();
        quarto.quarto();
    }
}
