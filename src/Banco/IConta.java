package Banco;

public interface IConta {
    void sacar(double valor);

    void depositar(double valor);

    void transferir(Conta contaTransferencia, double valor);

    void extrato();
}
