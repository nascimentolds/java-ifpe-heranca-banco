package ifpe.ads;

public class ContaBancaria {
    private final String nomeCliente;
    private final int numConta;
    protected double saldo;

    public ContaBancaria(String nomeCliente, int numConta, double saldo) {
        this.nomeCliente = nomeCliente;
        this.numConta = numConta;
        this.saldo = saldo;
    }

    public boolean sacar(double valor) {
        if(valor <= saldo ) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        } else {
            return false;
        }
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getNumConta() {
        return numConta;
    }

}
