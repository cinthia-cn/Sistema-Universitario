package banco;

public interface Transaccionable {

    void depositar(double monto);

    void retirar(double monto);
}
