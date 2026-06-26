import java.time.LocalDate;
import banco.*;
import sistemasuniversitarios.*;


public class Main {

    public static void main(String[] args) {

        // =========================
        // UNIVERSIDAD
        // =========================

        Universidad uni = new Universidad(
                "Universidad Tecnologica",
                "Puebla",
                1995
        );

        // =========================
        // DEPARTAMENTO
        // =========================

        Departamento sistemas = new Departamento(
                "Sistemas",
                "ISC01",
                "Edificio A"
        );

        uni.agregarDepartamento(sistemas);

        // =========================
        // PAS
        // =========================

        Pas administrativo = new Pas(
                "Recursos Humanos",
                2,
                "Matutino",
                LocalDate.of(2020, 1, 15),
                12000,
		"T001",
                "Auxiliar",
                "Carlos Lopez",
                LocalDate.of(1985, 5, 10),
                "Puebla"
        );

        administrativo.administrarRecursos();
        administrativo.generarReporte();

        // =========================
        // PDI
        // =========================

        Pdi profesor = new Pdi(
                "Titular",
                "Inteligencia Artificial",
                20,
                LocalDate.of(2018, 8, 1),
                25000,
		"P001", 
                "Profesor Investigador",
                "Ana Martinez",
                LocalDate.of(1980, 3, 20),
                "Puebla"
        );

        profesor.investigar("Machine Learning");
        profesor.impartirClase();

        sistemas.asignarProfesor(profesor);

        // =========================
        // ESTUDIANTE DE GRADO
        // =========================

        EstudianteGrado eg = new EstudianteGrado(
                "Tesis",
                320,
                true,
                "A001",
                9.4,
                LocalDate.of(2022, 8, 1),
                "Maria Garcia",
                LocalDate.of(2004, 7, 15),
                "Puebla"
        );

        eg.inscribirMateria("Programacion Orientada a Objetos");

        System.out.println(
                "Beca: $" + eg.calcularBeca()
        );

        eg.realizarProyecto();
        eg.solicitarTitulacion();

        uni.registrarEstudiante(eg);

        // =========================
        // ESTUDIANTE DOCTORADO
        // =========================

        EstudianteDoctorado ed = new EstudianteDoctorado(
                "Doctorado en Computacion",
                "Aplicaciones de IA en Educacion",
                "Dr. Perez",
                "D001",
                9.8,
                LocalDate.of(2024, 1, 10),
                "Luis Hernandez",
                LocalDate.of(1998, 2, 28),
                "CDMX"
        );

        ed.realizarTesis();
        ed.publicarArticulo();

        uni.registrarEstudiante(ed);

        // =========================
        // DOCTOR
        // =========================

        Doctor doctor = new Doctor(
                "Ciencias Computacionales",
                "UNAM",
                2015,
                LocalDate.of(2016, 2, 1),
                30000,
		"D001",
                "Investigador",
                "Roberto Diaz",
                LocalDate.of(1978, 11, 4),
                "Puebla"
        );

        doctor.validarTitulo();
        doctor.registrarTitulo();

        uni.contratarTrabajador(doctor);

        // =========================
        // MOSTRAR OBJETOS
        // =========================

        System.out.println("\n===== UNIVERSIDAD =====");
        System.out.println(uni);

        System.out.println("\n===== DEPARTAMENTO =====");
        System.out.println(sistemas);

        System.out.println("\n===== PAS =====");
        System.out.println(administrativo);

        System.out.println("\n===== PDI =====");
        System.out.println(profesor);

        System.out.println("\n===== ESTUDIANTE GRADO =====");
        System.out.println(eg);

        System.out.println("\n===== ESTUDIANTE DOCTORADO =====");
        System.out.println(ed);

        System.out.println("\n===== DOCTOR =====");
        System.out.println(doctor);
    }
}
