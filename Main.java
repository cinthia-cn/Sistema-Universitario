public class Main {

    public static void main(String[] args) {

        CuentaCorriente cc =
                new CuentaCorriente("CC001", 5000);

        CuentaAhorro ca =
                new CuentaAhorro("CA001", 10000, 20000);

        // Cuenta Corriente
        cc.depositar(1000);
        cc.retirar(500);
        cc.girarCheque(300);
        cc.cobrarComision();

        System.out.println(cc);
        System.out.println("Saldo: " + cc.consultarSaldo());

        System.out.println();

        // Cuenta Ahorro
        ca.depositar(2000);
        ca.retirar(1000);

        System.out.println(ca);
        System.out.println("Interés: $" +
                ca.calcularIntereses());
    }
}
