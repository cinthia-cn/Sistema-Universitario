package sistemasuniversitarios;

import banco.CuentaCorriente;
import banco.CuentaAhorro;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Universidad uni = new Universidad(
                "Universidad Tecnológica",
                "Puebla",
                1995
        );

        Departamento sistemas = new Departamento(
                "Sistemas",
                "ISC01",
                "Edificio A"
        );

        uni.agregarDepartamento(sistemas);

        Trabajador trabajador = new Trabajador(
                LocalDate.of(2020, 1, 15),
                12000,
                "T001",
                "Administrador",
                "Juan Pérez",
                LocalDate.of(1985, 5, 20),
                "Puebla"
        );

        trabajador.agregarCuenta(
                new CuentaCorriente("CC001", 5000)
        );

        uni.contratarTrabajador(trabajador);

        Doctor doctor = new Doctor(
                "Ciencias Computacionales",
                "UNAM",
                2015,
                LocalDate.of(2016, 2, 1),
                30000,
                "D001",
                "Investigador",
                "Roberto Díaz",
                LocalDate.of(1978, 11, 4),
                "Puebla"
        );

        doctor.agregarCuenta(
                new CuentaCorriente("CC002", 8000)
        );

        uni.contratarTrabajador(doctor);

        Pdi profesor = new Pdi(
                "Titular",
                "Inteligencia Artificial",
                20,
                LocalDate.of(2018, 8, 1),
                25000,
                "P001",
                "Profesor Investigador",
                "Ana Martínez",
                LocalDate.of(1980, 3, 20),
                "Puebla"
        );

        sistemas.asignarProfesor(profesor);

        Pas administrativo = new Pas(
                "Recursos Humanos",
                2,
                "Matutino"
        );

        EstudianteGrado eg = new EstudianteGrado(
                "Tesis",
                320,
                true,
                "A001",
                9.4,
                LocalDate.of(2022, 8, 1),
                "María García",
                LocalDate.of(2004, 7, 15),
                "Puebla"
        );

        eg.agregarCuenta(
                new CuentaAhorro("CA001", 10000, 15000)
        );
	uni.registrarEstudiante(eg);
        sistemas.agregarEstudiante(eg);

        EstudianteDoctorado ed = new EstudianteDoctorado(
                "Doctorado en Computación",
                "IA en Educación",
                "Dr. Pérez",
                "D001",
                9.8,
                LocalDate.of(2024, 1, 10),
                "Luis Hernández",
                LocalDate.of(1998, 2, 28),
                "CDMX"
        );

        ed.agregarCuenta(
                new CuentaAhorro("CA002", 15000, 20000)
        );

        uni.registrarEstudiante(ed);

        System.out.println("\n===== UNIVERSIDAD =====");
        System.out.println(uni);

        System.out.println("\n===== DEPARTAMENTO =====");
        System.out.println(sistemas);

        System.out.println("\n===== TRABAJADOR =====");
        System.out.println(trabajador);
        trabajador.mostrarCuentas();

        System.out.println("\n===== DOCTOR =====");
        System.out.println(doctor);
        doctor.mostrarCuentas();

        System.out.println("\n===== ESTUDIANTE GRADO =====");
        System.out.println(eg);
        eg.mostrarCuentas();

        System.out.println("\n===== ESTUDIANTE DOCTORADO =====");
        System.out.println(ed);
        ed.mostrarCuentas();

        sistemas.listarPersonal();
        sistemas.listarEstudiantes();

        profesor.investigar("Machine Learning");
        profesor.impartirClase();

        administrativo.administrarRecursos();
        administrativo.generarReporte();

        doctor.validarTitulo();
        doctor.registrarTitulo();

        eg.realizarProyecto();
        eg.solicitarTitulacion();

        ed.realizarTesis();
        ed.publicarArticulo();


System.out.println("\n===== PRUEBA DE EQUALS Y compareTo =====");

// ---------- ESTUDIANTES ----------
EstudianteGrado eg2 = new EstudianteGrado(
        "Otro Proyecto",
        300,
        false,
        "A001", // Misma matrícula que eg
        8.0,
        LocalDate.of(2023, 8, 1),
        "María López",
        LocalDate.of(2004, 7, 15),
        "Puebla"
);

System.out.println("equals Estudiante: " + eg.equals(eg2));
System.out.println("compareTo Estudiante: " + eg.compareTo(ed));


// ---------- TRABAJADORES ----------
Trabajador trabajador2 = new Trabajador(
        LocalDate.of(2022, 1, 10),
        15000,
        "T001", // Mismo identificador que trabajador
        "Auxiliar",
        "Pedro Gómez",
        LocalDate.of(1990, 6, 1),
        "Puebla"
);

System.out.println("equals Trabajador: " + trabajador.equals(trabajador2));
System.out.println("compareTo Trabajador: " + trabajador.compareTo(doctor));


// ---------- CUENTAS ----------
CuentaCorriente cuenta2 = new CuentaCorriente("CC002", 8000);

System.out.println("equals Cuenta: "
        + trabajador.buscarCuenta("CC001").equals(cuenta2));

System.out.println("compareTo Cuenta: "
        + trabajador.buscarCuenta("CC001").compareTo(cuenta2));


  }
}
