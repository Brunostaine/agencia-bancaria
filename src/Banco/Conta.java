package Banco;

import Utilitarios.Utils;

public class Conta {
    private static int contadorConta = 100;
    private int numeroConta;
    private Usuario usuario;
    private Double saldo = 0d;

    public Conta(Usuario usuario) {
        this.numeroConta = contadorConta;
        this.usuario = usuario;
        contadorConta+=1;
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
}
