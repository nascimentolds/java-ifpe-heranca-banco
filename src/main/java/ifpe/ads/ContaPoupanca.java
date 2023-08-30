package ifpe.ads;

public class ContaPoupanca extends ContaBancaria {
    private int diaRendimento;

    public ContaPoupanca(String nomeCliente, int numConta, double saldo, int diaRendimento) {
        super(nomeCliente, numConta, saldo);
        this.diaRendimento = diaRendimento;
    }

    public void calcularNovoSaldo(double taxaRendimento) {
        if (diaRendimento == 30) {
            saldo *= (1 + (taxaRendimento / 100));
        }
    }
}
