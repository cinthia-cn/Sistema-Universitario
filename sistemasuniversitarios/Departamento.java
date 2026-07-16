package sistemasuniversitarios;
public class Departamento {

// ATRIBUTOS
    private String nombre;
    private String codigo;
    private String ubicacion;

/**
AQUI AGREGAMOS UNA ASOCION PQ COMO SABEMOS UN SOLO DEPARTAMENTO PUEDE TENER MUCHOS PROFESORES
POR ESO EL ARREGLO, PERO ¿QUE ES UNA ASOCIACION?
ESTE NOS DICE QUE ENTRE CLASES SE CONOCEN, PERO SI DESAPARECIERA DEPARTAMENTO, NO LE PASARIA NADA A LOS PROFES
EN ESTE CASO DEPARTAMENTO VA A CONOCER A PDI, PAS Y MAS EN CASO DE QUE SEA ASI.
**/
    private Pdi[] profesores;

/**
AGREGACION(UML), ¿QUE ESY PQ?
LA AGREGACION DICE QUE  ES UN TIPO DE ASOCIACION(SE CONOCEN) QUE 
REPRESENTA QUE "TIENE PARTE DE" ENTRE DOS CLASES.
DONDE DEPARTAMENTO ES UN CONTENEDOR PERO EL CONTENIDO ESTUDIANTE GRADO, PUEDE EXISTIR INDEPENDIENTEMENTE
CREAMOS UN ARREGLO PQ TAMBIEN UN DEPARTAMENTO PUEDE TENER MUCHOS ESTUDIANTES DE GRADO, Y NO SOLO UNO. 
**/
    private EstudianteGrado[] estudiantes;

// CONSTRUCTOR
    public Departamento(String nombre,
                         String codigo,
                         String ubicacion) {

        this.nombre = nombre;
        this.codigo = codigo;
        this.ubicacion = ubicacion;

        profesores = new Pdi[10];
        estudiantes = new EstudianteGrado[30];
    }
 // CONSTRUCTOR VACIO

    public Departamento() {

        this("","","");
    }

// GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

// SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

/**
BUSQUEDA RECURSIVA
LO QUE HACE EL METODO DE BUSCAR PROFESOR 
ES IR POSICION UNO POR UNO (0) BUSCANDO UN IDENTIFICADOR QUE ES CARACTERISTICA DE PROFESOR
**/
public Pdi buscarProfesor(String identificador) {
    return buscarProfesor(identificador, 0);
}

private Pdi buscarProfesor(String identificador, int i) {

    if (i >= profesores.length){
        return null;// NO HAY? REGRESA NULL
    }/**
¿QUE ES .LENGTH?
ESTE INDICA EL TAMAÑO EL ARREGLO 
TIPO EN LA PARTE DE ARRIBA YO PUSE QUE SERIA UN ARREGLO DE 10 PROFESORES
PUES ESTE COMPARA EL TAMAÑO DEL AREGLO CON LA i QUE ES LO QIE BUSCAMOS.
**/

    if (profesores[i] != null &&//CASO BASE
        profesores[i].buscarTrabajador(identificador) != null) {
//AQUI BUSCA POSICION, PROFESOR Y SI NO  (!= OPERADOR LOGICO DE COMPARACION
// QUE REGRESA UN BOOLEANO)
        return profesores[i];
    }
// BUSQUEDA RECURSIVA, BUSCA HASTA ENCONTRAR O RECORRER TOOD EL ARRGELO Y LLEGAR A CASO BASE
    return buscarProfesor(identificador, i + 1);
}

/**
BUSQUEDA RECURSIVA DE BUSCAR ESTUDIANTE
ESTE FUNCIONA IGUAL QUE TODOS
EMPIEZA EN LA POSICION 0, BUSCA, COMPARA .LENGTH, SI NO, REGRESA NULL
ESTA EL CASO BASE, COMPARA .EQUALS, SI SI, REGRESA LO QUE ESTAMOS BUSCANDO.
SI NO, SIGUE BUSCANDO i+1 POSICION POR POSICION, HASTA ENCONTRAR O NO Y REGRESAR AL CASO BASE
QUE EN CASO DE QUE NO, REGRESA NULL.
**/
public EstudianteGrado buscarEstudiante(String matricula) {
    return buscarEstudiante(matricula, 0);
}

private EstudianteGrado buscarEstudiante(String matricula, int i) {

    if (i >= estudiantes.length) {
        return null;
    }

    if (estudiantes[i] != null &&
        estudiantes[i].getMatricula().equals(matricula)) {

        return estudiantes[i];
    }

    return buscarEstudiante(matricula, i + 1);
}

/**
METODO ASIGNAR PROFESOR
EN ESTE METODO LO QUE HACE ES  RECORRER EL ARREGLO, BUSCANDO PROFESOR POR ASGINAR
SI NO HAY PROFESOR REGRESA NULL, SI NAY PROFESOR, REGRESA QUE SI SE ASIGNO
SI NO HAY NINGUNO DE LOS DOS, REGRESA QUE NO HAY ESPACIO DISPONIBLE
**/
    public void asignarProfesor(Pdi profesor) {

        for (int i = 0; i < profesores.length; i++) {

            if (profesores[i] == null) {

                profesores[i] = profesor;

                System.out.println(
                    "Profesor asignado correctamente."
                );

                return;
            }
        }

        System.out.println(
            "No hay espacio disponible para profesores."
        );
    }

/** METODO LISTAR PERSONAL
   EL PROPOSITO DE ESTE METODO ES
ENLISTAR EL PERSONAL DEL DEPARTAMENTO, ESTE RECORRE EL ARREGLO Y DEBOLVERA UNA LISTA
DEL PERSONAL, SI NO HAY REGRESA NULL
**/
 public void listarPersonal() {

        System.out.println(
            "\nPERSONAL DEL DEPARTAMENTO"
        );

        for (int i = 0; i < profesores.length; i++) {

            if (profesores[i] != null) {

                System.out.println(
                    profesores[i]
                );
            }
        }
    }

/**
METODO PARA AGREGAR ESTUDIANTES
ESTE LO QUE HACE ES RECORRER EL ARREGLO, SI ENCUENTA UN NULL O ESPACIO VACIO
AGREGARA AL ESTUDIANTE, SI NO, ES QUE YA NO HAY ESPACIO
**/
    public void agregarEstudiante(EstudianteGrado estudiante) {

        for (int i = 0; i < estudiantes.length; i++) {

            if (estudiantes[i] == null) {

                estudiantes[i] = estudiante;

                System.out.println(
                    "Estudiante agregado correctamente."
                );

                return; //ESTOS ROMPEN EL CICLO EN CASO DE QUE YA HAYA ACABADO
            }
        }

        System.out.println(
            "No hay espacio disponible para estudiantes."
        );
    }

/**
ESTE  METODO AL IGUAL DE LISTAR DEPARTAMENTO
FUNCIONA IGUAL, RECORRE EL TAMAÑO DEL ARREGLO UNO POR UNO, E IMPRIMIRA 
EL CONTENIDO DEL ARREGLO HASTO NO HAY UN ESPACIO NULL, VACIO. 
**/
    public void listarEstudiantes() {

        System.out.println(
            "\nESTUDIANTES DEL DEPARTAMENTO"
        );

        for (int i = 0; i < estudiantes.length; i++) {

            if (estudiantes[i] != null) {

                System.out.println(
                    estudiantes[i]
                );
            }
        }
    }

// METODO TOSTRING
    @Override // ESTE METODO ESTA SOBREESCRITO EN CLASE PADRE, PERO LE DAMOS OTRO COMPORTAMIENTO AQUI.
    public String toString() {

        return "Departamento" +
               "\nNombre:" + nombre +
               "\nCodigo:" + codigo + 
               "\nUbicacion:" + ubicacion; 
            
    }
}
