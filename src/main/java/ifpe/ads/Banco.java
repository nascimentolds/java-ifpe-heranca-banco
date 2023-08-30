package ifpe.ads;

import java.util.ArrayList;
import java.util.Scanner;

// Crie uma classe ContaBancaria, que contém os atributos nome do cliente,
// num_conta, saldo e os métodos sacar (o saldo não pode ficar negativo) e depositar. Crie
// duas classes herdadas de ContaBancaria: ContaPoupança e ContaEspecial, com as
// seguintes características a mais: Classe ContaPoupança tem o atributo dia de
// rendimento e o calcularNovoSaldo, recebe a taxa de rendimento da poupança e atualiza o saldo.
//  Já a classe ContaEspecial possui o atributo limite é uma redefinição no métodos sacar,
// permitindo saldo negativo até o valor do limite. Crie uma classe Teste e nela ofereça as
// seguintes opções:
//  1) Incluir dados relativos a conta de um cliente (Limitado a 5 contas);
//  2) Sacar um determinado valor de uma conta (Procure pelo número da conta);
//  3) Depositar um determinado valor na sua conta (Procure pelo número da conta);
//  4) Mostrar o novo saldo do cliente, a partir da taxa de rendimento, daqueles que possuem conta poupança;
//  5) Mostrar os dados de todas as contas cadastradas.

public class Banco {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        ContaBancaria conta;
        String nomeCliente;
        int numConta;
        double valor;
        int tipoConta;
        ArrayList<ContaBancaria> contas = new ArrayList<ContaBancaria>();

        int opcao = 6;

        while (opcao != 0) {
            menu();
            System.out.print("Opção: ");
            opcao = ler.nextInt();
            System.out.println("-------------------------------");

            switch (opcao) {
                case 1 -> {
                    System.out.println("Nome do cliente: ");
                    ler.nextLine();
                    nomeCliente = ler.nextLine();

                    System.out.println("Número da conta: ");
                    numConta = ler.nextInt();

                    System.out.println("Escolha o tipo da conta: ");
                    System.out.println("1 = Conta poupança: ");
                    System.out.println("2 = Conta especial: ");
                    tipoConta = ler.nextInt();

                    if (tipoConta == 1) {
                        conta = new ContaPoupanca(nomeCliente, numConta, 0, 30);
                        contas.add(conta);
                        System.out.println("-------------------------------");
                        System.out.println("Conta poupança cadastrada!");
                        System.out.println("-------------------------------");
                    }

                    if (tipoConta == 2) {
                        conta = new ContaEspecial(nomeCliente, numConta, 0, 600);
                        contas.add(conta);
                        System.out.println("-------------------------------");
                        System.out.println("Conta especial cadastrada!");
                        System.out.println("-------------------------------");
                    }
                }
                case 2 -> {
                    System.out.println("-------------------------------");
                    System.out.println("Número da conta: ");
                    numConta = ler.nextInt();

                    System.out.println("Quanto deseja sacar: ");
                    valor = ler.nextInt();

                    for (ContaBancaria c : contas) {
                        if (numConta == c.getNumConta()) {
                            if (c.sacar(valor)) {
                                System.out.printf("Você sacou: %.2f \n", valor);
                            } else {
                                System.out.println("Não há saldo suficiente!");
                            }
                        }
                    }
                    System.out.println("-------------------------------");
                }
                case 3 -> {
                    System.out.println("-------------------------------");
                    System.out.println("Número da conta: ");
                    numConta = ler.nextInt();

                    System.out.println("Quanto deseja depositar: ");
                    valor = ler.nextInt();

                    for (ContaBancaria c : contas) {
                        if (numConta == c.getNumConta()) {
                            if (c.depositar(valor)) {
                                System.out.printf("Você depositou: %.2f \n", valor);
                            } else {
                                System.out.println("Deposito não realizado!");
                            }
                        }
                    }
                    System.out.println("-------------------------------");
                }
                case 4 -> {
                    System.out.println("-------------------------------");
                    System.out.println("Número da conta: ");
                    numConta = ler.nextInt();

                    boolean encontrouContaPoupanca = false;

                    for (ContaBancaria c : contas) {
                        if (numConta == c.getNumConta() && c instanceof ContaPoupanca) {
                            ((ContaPoupanca) c).calcularNovoSaldo(10);
                            System.out.println("-------------------------------");
                            System.out.printf("Nome: %s \n", c.getNomeCliente());
                            System.out.printf("Conta nº: %d \n", c.getNumConta());
                            System.out.printf("Saldo: %.2f \n", c.saldo);
                            System.out.println("-------------------------------");
                            encontrouContaPoupanca = true;
                            break;
                        }
                    }

                    if (!encontrouContaPoupanca) {
                        System.out.println("-------------------------------");
                        System.out.println("Nenhuma conta poupança encontrada!");
                        System.out.println("-------------------------------");
                    }
                }
                case 5 -> {
                    for (ContaBancaria c : contas) {
                        System.out.println("-------------------------------");
                        System.out.printf("Nome: %s \n", c.getNomeCliente());
                        System.out.printf("Conta nº: %d \n", c.getNumConta());
                        System.out.printf("Saldo: %.2f \n", c.saldo);
                        System.out.println("-------------------------------");
                    }
                }
            }
        }
    }

    public static void menu() {
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("-------------------------------");
        System.out.println("[1] Cadastrar cliente");
        System.out.println("[2] Sacar");
        System.out.println("[3] Depositar");
        System.out.println("[4] Saldo de rendimento");
        System.out.println("[5] Listar cadastrados");
        System.out.println("[0] Sair");
        System.out.println("-------------------------------");
    }
}
