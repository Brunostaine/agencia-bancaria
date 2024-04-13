import Banco.Conta;
import Banco.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<>();
        iniciar();

    }

    public static void iniciar() {
        System.out.println("--------------------------------------------------------");
        System.out.println("--------------Bem vindos a nossa agência----------------");
        System.out.println("--------------------------------------------------------");
        System.out.println("--------Selecione a operação que deseja realizar--------");
        System.out.println("--------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Extrato       |");
        System.out.println("|   Opção 6 - Listar contas |");
        System.out.println("|   Opção 7 - Sair          |");

        int novaOperacao = input.nextInt();

        switch (novaOperacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                extrato();
                break;
            case 6:
                listarContas();
                break;
            case 7:
                System.out.println("Obrigado por usar nosso banco digital. Até mais!");
                System.exit(0);
            default:
                System.out.println("Opção inválida");
                iniciar();
        }
    }

    public static void criarConta() {
        System.out.println("Nome: ");
        String nome = input.next();
        System.out.println("CPF: ");
        String cpf = input.next();
        System.out.println("Email: ");
        String email = input.next();

        Usuario usuario = new Usuario(nome, cpf, email);
        Conta conta = new Conta(usuario);
        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso, " + conta.getUsuario().getNome() + ".");
        System.out.println("Numero da conta: " + conta.getNumeroConta());

        iniciar();
    }

    public static void depositar() {
        System.out.println("Digite o numero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = buscarConta(numeroConta);

        if (conta != null) {
            System.out.println("Digite o valor que deseja depositar: ");
            double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
        } else {
            System.out.println("A conta que você digitou nao existe!");
        }
        iniciar();
    }

    public static void sacar() {
        System.out.println("Digite o numero da conta que deseja sacar: ");
        int numeroConta = input.nextInt();

        Conta conta = buscarConta(numeroConta);

        if (conta != null) {
            System.out.println("Digite o valor que deseja sacar: ");
            double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("A conta que você digitou nao existe!");
        }
        iniciar();
    }

    public static void transferir() {
        System.out.println("Digite o numero da sua conta: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = buscarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            System.out.println("Digite o numero da conta que voce deseja transferir: ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = buscarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                System.out.println("digite o valor que deseja transferir");
                Double valor = input.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);
            } else {
                System.out.println("A conta que você digitou nao existe! ");
            }
        } else {
            System.out.println("A conta que você digitou nao existe! ");
        }
        iniciar();
    }

    public static void extrato() {
        System.out.println("Digite o numero da sua conta: ");
        int numeroConta = input.nextInt();

        Conta conta = buscarConta(numeroConta);
        if(conta != null) {
            System.out.println("Extrato bancario: ");
            System.out.println("Usuario: " + conta.getUsuario().getNome());
            System.out.println("CPF: " + conta.getUsuario().getCPF());
            System.out.println("Email: " + conta.getUsuario().getEmail());
            conta.extrato();
        } else {
            System.out.println("A conta que você digitou nao existe! ");
        }
        iniciar();
    }

    public static void listarContas() {
        if(contasBancarias.size() > 0){
            for (Conta contas : contasBancarias){
                System.out.println(contas);
            }
        } else {
            System.out.println("Não há contas cadastradas!");
        }
        iniciar();
    }

    public static Conta buscarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta) conta = c;
            }
        }
        return conta;
    }
}
