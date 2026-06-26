package sistemasuniversitarios;

import java.time.LocalDate;

public class Doctor extends Trabajador {

// ATRIBUTOS
    private String especialidad;
    private String universidad;
    private int anioObtencion;

// CONSTRUCTOR
    public Doctor(String especialidad,
                  String universidad,
                  int anioObtencion,
                  LocalDate fechaIngreso,
                  double salario,
		  String identificador;
                  String puesto,
                  String nombre,
                  LocalDate fechaNacimiento,
                  String direccion) {

        super(fechaIngreso, salario,identificador, puesto,
              nombre, fechaNacimiento, direccion);

        this.especialidad = especialidad;
        this.universidad = universidad;
        this.anioObtencion = anioObtencion;
    }

// CONSTRUCTOR VACIO 

    public Doctor() {

        super();

        this.especialidad = "";
        this.universidad = "";
        this.anioObtencion = 0;
    }

// GETTERS
    public String getEspecialidad() {
        return especialidad;
    }

    public String getUniversidad() {
        return universidad;
    }

    public int getAnioObtencion() {
        return anioObtencion;
    }

// SETTERS
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public void setAnioObtencion(int anioObtencion) {
        this.anioObtencion = anioObtencion;
    }

// METODO VALIDAR TITULO
    public void validarTitulo() {

        if(anioObtencion > 0) {

            System.out.println(
                "Titulo validado correctamente."
            );

        } else {

            System.out.println(
                "No existe informacion suficiente para validar el titulo."
            );
        }
    }

// METODO REGISTRAR TITULO
    public void registrarTitulo() {

        System.out.println(
            getNombre() +
            " ha registrado su titulo de doctor."
        );

        System.out.println(
            "Especialidad: " + especialidad
        );

        System.out.println(
            "Universidad: " + universidad
        );

        System.out.println(
            "Año de obtencion: " + anioObtencion
        );
    }

    @Override
    public String toString() {

        return super.toString() +
               "\nEspecialidad: " + especialidad +
               "\nUniversidad: " + universidad +
               "\nAño de obtencion: " + anioObtencion;
    }
}
