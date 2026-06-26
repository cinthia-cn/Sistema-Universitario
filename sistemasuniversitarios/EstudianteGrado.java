package sistemasuniversitarios;
import java.time.LocalDate;

public class EstudianteGrado extends Estudiante {

// ATRIBUTOS
    private String titulacion;
    private int creditos;
    private boolean servicioSocial;

// CONSTRUCTOR 

    public EstudianteGrado(String titulacion,
                           int creditos,
                           boolean servicioSocial,
                           String matricula,
                           double promedio,
                           LocalDate fechaIngreso,
                           String nombre,
                           LocalDate fechaNacimiento,
                           String direccion) {

        super(matricula, promedio, fechaIngreso,
              nombre, fechaNacimiento, direccion);

        this.titulacion = titulacion;
        this.creditos = creditos;
        this.servicioSocial = servicioSocial;
    }

//CONSTRUCTOR VACIO 
    public EstudianteGrado() {

        super(); //Llama al constructor de ESTUDIANTE y ese constructor llama a  los constructores de PERSONA 

        this.titulacion = "";
        this.creditos = 0;
        this.servicioSocial = false;
    }

// GETTERS
    public String getTitulacion() {
        return titulacion;
    }

    public int getCreditos() { 
        return creditos;
    }

    public boolean getServicioSocial() {
        return servicioSocial;
    }

// SETTERS
    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setServicioSocial(boolean servicioSocial) {
        this.servicioSocial = servicioSocial;
    }

// METODO  REALIZAR  PROYECTO
    public void realizarProyecto() {

        System.out.println(
            getNombre() +
            " ha concluido satisfactoriamente su proyecto de titulacion por modalidad: "
            + titulacion
        );
    }

// METODO SOLICITAR TITULACION 
    public void solicitarTitulacion() {

        if(servicioSocial && creditos >= 300) {

            System.out.println(
                getNombre() +
                " puede iniciar el tramite de titulacion."
            );

        } else {

            System.out.println(
                getNombre() +
                " aun no cumple los requisitos de titulacion."
            );

            if(!servicioSocial) {

                System.out.println(
                    "Falta completar el servicio social."
                );
            }

            if(creditos < 300) {

                System.out.println(
                    "Faltan creditos. Tiene "
                    + creditos +
                    " de 300 requeridos."
                );
            }
        }
    }

// METODO TO STRING
    @Override
    public String toString() {

        return super.toString() +
               "\nTitulacion: " + titulacion +
               "\nCreditos: " + creditos +
               "\nServicio Social: " + servicioSocial;
    }
}
