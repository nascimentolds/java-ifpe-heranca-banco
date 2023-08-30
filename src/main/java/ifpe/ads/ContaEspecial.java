package ifpe.ads;

public class ContaEspecial extends ContaBancaria {
    private final double limite;

    public ContaEspecial(String nomeCliente, int numConta, double saldo, double limite) {
        super(nomeCliente, numConta, saldo);
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor) {
        if(valor <= (saldo + limite)) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }
}
