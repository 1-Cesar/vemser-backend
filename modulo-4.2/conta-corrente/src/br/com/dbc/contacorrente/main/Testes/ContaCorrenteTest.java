package br.com.dbc.contacorrente.main.Testes;

import br.com.dbc.contacorrente.main.classes.ContaCorrente;
import br.com.dbc.contacorrente.main.classes.ContaPagamento;
import br.com.dbc.contacorrente.main.classes.ContaPoupanca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaCorrenteTest {

    public ContaCorrenteTest() {
    }

    @Test
    public void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() {
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000.0);
        contaCorrente.setChequeEspecial(1000.0);
        int saque = 1500;
        boolean conseguiuSacar = contaCorrente.sacar((double)saque);
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(-500.0, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo() {
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000.0);
        contaCorrente.setChequeEspecial(1000.0);
        int valorSaque = 3000;
        boolean conseguiuSacar = contaCorrente.sacar((double)valorSaque);
        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(1000.0, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() {
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(1000.0);
        contaPoupanca.creditarTaxa();
        int valorSaque = 500;
        boolean conseguiuSacar = contaPoupanca.sacar((double)valorSaque);
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(510.1, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo() {
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(0);
        int valorSaque = 500;
        boolean conseguiuSacar = contaPoupanca.sacar((double)valorSaque);
        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(0, contaPoupanca.getSaldo());
    }

    @Test
    public void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso() {
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(1000);
        int valorSaque = 500;
        boolean conseguiuSacar = contaPagamento.sacar((double)valorSaque);
        Assertions.assertTrue(conseguiuSacar);
        Assertions.assertEquals(495.75, contaPagamento.getSaldo());
    }d

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo() {
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(0);
        int valorSaque = 500;
        boolean conseguiuSacar = contaPagamento.sacar((double)valorSaque);
        Assertions.assertFalse(conseguiuSacar);
        Assertions.assertEquals(0, contaPagamento.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso() {
        ContaCorrente contaCorrente = new ContaCorrente();
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaCorrente.setSaldo(1000);
        int valorTransferencia = 500;
        boolean conseguiuTransferir = contaCorrente.transferir(contaPoupanca, (double)valorTransferencia);
        Assertions.assertTrue(conseguiuTransferir);
        Assertions.assertEquals(500.0, contaPoupanca.getSaldo());
        Assertions.assertEquals(500.0, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarTransferenciaSemSaldo() {
        ContaCorrente contaCorrente = new ContaCorrente();
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaCorrente.setSaldo(0);
        int valorTransferencia = 500;
        boolean conseguiuTransferir = contaCorrente.transferir(contaPoupanca, (double)valorTransferencia);
        Assertions.assertFalse(conseguiuTransferir);
        Assertions.assertEquals(0, contaPoupanca.getSaldo());
        Assertions.assertEquals(0, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarDepositoEVerificarSaldoComSucesso() {
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000);
        int valorDeposito = 500;
        boolean conseguiuDepositar = contaCorrente.depositar((double)valorDeposito);
        Assertions.assertTrue(conseguiuDepositar);
        Assertions.assertEquals(1500.0, contaCorrente.getSaldo());
    }

    @Test
    public void deveTestarDepositoNegativo() {
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(1000);
        int valorDeposito = -1;
        boolean conseguiuDepositar = contaCorrente.depositar((double)valorDeposito);
        Assertions.assertFalse(conseguiuDepositar);
        Assertions.assertEquals(1000.0, contaCorrente.getSaldo());
    }
}
