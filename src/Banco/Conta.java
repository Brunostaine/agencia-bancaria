package Banco;

import Utilitarios.Utils;

public class Conta implements IConta {
    private static int contadorConta = 100;
    private int numeroConta;
    private Usuario usuario;
    private Double saldo = 0d;

    public Conta(Usuario usuario) {
        this.numeroConta = contadorConta;
        this.usuario = usuario;
        contadorConta += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta=" + numeroConta +
                ", usuario=" + usuario +
                ", saldo=" + Utils.doubleToString(saldo) +
                '}';
    }

    @Override
    public void sacar(double valor) {
        if(valor > 0 && getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o saque, verifique o valor!");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Deposito realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o deposito, verifique o valor!");
        }
    }

    @Override
    public void transferir(Conta contaTransferencia, double valor) {
        if(valor > 0 && getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            contaTransferencia.saldo = contaTransferencia.getSaldo() + valor;
            System.out.println("Transferencia realizada com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a transferencia, verifique o valor!");
        }
    }

    @Override
    public void extrato() {
        System.out.println("Saldo: " + saldo);
    }
}
