import java.time.LocalDate;
import sistemasuniversitarios.Trabajador;
import sistemasuniversitarios.Estudiante;
import banco.CuentaCorriente;
import banco.CuentaAhorro;

public class MainBanco {

    public static void main(String[] args) {

        // =====================
        // CUENTA CORRIENTE
        // =====================

        CuentaCorriente cc =
                new CuentaCorriente(
                        "CC001",
                        5000
                );

        Trabajador trabajador =
                new Trabajador(
                        LocalDate.of(2020, 1, 15),
                        12000,
                        "Administrador",
                        "Juan Perez",
                        LocalDate.of(1985, 5, 20),
                        "Puebla",
                        cc
                );

        System.out.println("=== TRABAJADOR ===");
        System.out.println(trabajador);

        trabajador.getCuenta().depositar(1000);
        trabajador.getCuenta().retirar(500);
        trabajador.getCuenta().girarCheque(300);
        trabajador.getCuenta().cobrarComision();

        System.out.println(
                "Saldo actual: $" +
                trabajador.getCuenta().consultarSaldo()
        );

        // =====================
        // CUENTA AHORRO
        // =====================

        CuentaAhorro ca =
                new CuentaAhorro(
                        "CA001",
                        10000,
                        15000
                );

        Estudiante estudiante =
                new Estudiante(
                        "A001",
                        9.5,
                        LocalDate.of(2023, 8, 1),
                        "Maria Lopez",
                        LocalDate.of(2004, 3, 10),
                        "Puebla",
                        ca
                );

        System.out.println("\n=== ESTUDIANTE ===");
        System.out.println(estudiante);

        estudiante.getCuenta().depositar(2000);

        System.out.println(
                "Intereses generados: $" +
                estudiante.getCuenta().calcularIntereses()
        );

        System.out.println(
                "Saldo actual: $" +
                estudiante.getCuenta().consultarSaldo()
        );
    }
}
