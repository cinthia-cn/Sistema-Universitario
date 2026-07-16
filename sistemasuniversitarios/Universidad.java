package sistemasuniversitarios;

public class Universidad {

// ATRIBUTOS
    private String nombre;
    private String ciudad;
    private int fundacion;

/** ASOCIACION 
En este caso es una asociacion (UML)
Pq  implica que universitad conoce a los estudiantes y a los trabajadores 
y que pueden interactuar entre ellas**/

    private Estudiante[] estudiantes;
    private Trabajador[] trabajadores;

/** COMPOSICION (UML)
 AQUI es una composicion pq como sabemos 
 una composicion no puede exixstir sin esta clase contenedora
 es decir si destuimos UNIVERSIDAD deja de existir Departamento
 Aqui es un arreglo pq hay muchos departamenos en la universidad, no solo uno**/

    private Departamento[] departamentos;

// CONSTRUCTOR CON PARAMETROS
    public Universidad(String nombre,
                        String ciudad,
                        int fundacion) {

        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fundacion = fundacion;

        estudiantes = new Estudiante[100];
        trabajadores = new Trabajador[50];
        departamentos = new Departamento[20];
// En caso de que queramos mas espacios, se me cambia en nombre
    }


//CONSTRUCTOR VACIO
    public Universidad() {

        this.nombre = "";
        this.ciudad = "";
        this.fundacion = 0;

        estudiantes = new Estudiante[100];
        trabajadores = new Trabajador[50];
        departamentos = new Departamento[20];
    }

// GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getFundacion() {
        return fundacion;
    }

// SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

//METODO PARA EL MAIN 
public Estudiante buscarEstudiante(String matricula) {
    return buscarEstudiante(matricula, 0);
}

/**
METODO DE BUSQUEDA RECURSIVA (sin fors)
Podemos ver que tenemos 2 parametros
matricula e i que es el estudiante que buscamos.
**/

private Estudiante buscarEstudiante(String matricula, int i) {

    if (i >= estudiantes.length) { //CASO BASE
        return null;
    }//NOS DICE SI  YA RECORRIO TODO EL ARREGLO Y SI ENCONTRO AL ESTUDIANTE O NO. 
// EN CASO DE QUE NO. TERMINA LA BUSQUEDA. 

    if (estudiantes[i] != null && //AQUI PREGUNTA SI HAY ESTUDIANTE
        estudiantes[i].getMatricula().equals(matricula)) {
		//AQUI DICE QUE SI LA MATRICULA ES IGUAL A LA MATRICULA QUE SE ESTA BUSCANDO 

        return estudiantes[i]; // SISI DEVUELVE  Y TERMINA LA BUSQUEDA RECURSIVA. 
    }

    return buscarEstudiante(matricula, i + 1);
//AQUI LO QUE PASA ES QUE SI NO ESCONTRO UN ESTUDIANTE... LO QUE HACE ES AVANZAR  A LA SIGUIENTE POSICION
		// PPR EJEMPLO SI ESTA EN LA 0, (i)=0 le sumara uno y avanzara a la posicion (0+1=1)
			//HASTA LLEGAR AL CASO BASE :)
}
/**
¿PQ USAMOS EQUALS()?
Pq estamos comparando cadenas de texto Strings.
y en java asi se trabaja.
si fuera un COMPARETO este regresaria numeros y == puede que haga la igualacion mal. 
**/


// BUSQUEDA RECURSIVA PARA TRABAJADOR.  
public Trabajador buscarTrabajador(String identificador) {
    return buscarTrabajador(identificador, 0);
}
/**
AQUI  TENEMOS 2 PARAMETROS IDENTIFICADOR, E i... IDENTIFICADOR ES QUE BUSCAMOS
i ES DONDE ESTA ESE DATO.

**/

private Trabajador buscarTrabajador(String identificador, int i) {

    if (i >= trabajadores.length) {
        return null; //CASO BASE
			//SIN UN CASO BASE, SE LLAMARIA UNA Y OTRA VEZ, SIN SOLUCION.
    }

    if (trabajadores[i] != null && //ESTA EL IDENTIFICADOR? SI,SI
        trabajadores[i].getIdentificador().equals(identificador)) {//ES EL QUE ESTOY BUSCANSO? SI,SI

        return trabajadores[i]; //REGRESA LA POSICION EN DONDE SE ENCUNTRA EL DATO. 
    }
// SI NO?
//AQUI ES DONDE OCURRE LA RECURSIVIDAD
    return buscarTrabajador(identificador, i + 1);
//IRA INCREMENTANDO LAS POSICIONES HASTA ENCONTRAR LO QUE BUSCAMOS. O HASTA LLEGAR AL CASO BASE
}



// BUSQUEDA RECURSIVA PARA DEPARTAMENTO.
public Departamento buscarDepartamento(String dato) {
    return buscarDepartamento(dato, 0); // EL 0 ES LA POSICION DONDE EMPIEZA
}

private Departamento buscarDepartamento(String dato, int i) {
    if (i >= departamentos.length) {//CASO BASE 
        return null; 
    }

    if (departamentos[i] != null &&  //SI HAY?
       (departamentos[i].getNombre().equals(dato) //ESTO ES LO QUE NECESITO?
        ||// OR ES UN OPERADOR LOGICO AQUI COMPARA EN NOMBRE O EL CODIGO, BASTA CON QUE UNA SEA VERDADERA
        departamentos[i].getCodigo().equals(dato))) {

        return departamentos[i]; 
    }

    return buscarDepartamento(dato, i + 1); // SI NO COINCIDE, AVANZA A LA SIGUIENTE POSICION. 
}

// NULL ES LO QUE REGRESA CUANDO NO HAY OBJETO GUARDADO.

// METODO REGISTRAR ESTUDIANTE
    public void registrarEstudiante(Estudiante estudiante) {
// LO QUE  HACE ES REGISTRAR A UN ESTUDIANTE MEDIANTE DEL ARREGLO. 
        for (int i = 0; i < estudiantes.length; i++) {
// EMPIEZA EN LA POSICION 0, RECORRE EL ARREGLO UNO POR UNO
            if (estudiantes[i] == null) { // REGRESA NULL  SI NO HAY NADA DENTRO DEL ARREGLO

                estudiantes[i] = estudiante;// REGISTRA AL ESTUDIANTE

                System.out.println(
                    "Estudiante registrado correctamente."
                );

                return; //Este  return lo que hace es poner un alto de que ya acabo y termina el metodo. 
            }
        }

        System.out.println(//En caso de que el arreglo este lleno regresa. 
            "No hay espacio disponible para estudiantes."
        );
    }



// METODO CONTRATAR TRABAJADOR 
    public void contratarTrabajador(Trabajador trabajador) {
/**
Aqui hace lo miso que el de arriba
busca un espacio vacio en el arreglo, para ello recorre uno por uno, y donde haya un null, 
es donde mete al nuevo trabajador, en casos donde el arreglo este lleno, no haya lugares
este avisara.

**/
        for (int i = 0; i < trabajadores.length; i++) {

            if (trabajadores[i] == null) {

                trabajadores[i] = trabajador;

                System.out.println(
                    "Trabajador contratado correctamente."
                );

                return;
            }
        }

        System.out.println(
            "No hay espacio disponible para trabajadores."
        );
    }



// COMPOSICION CON DEPARTAMENTO 
//Pq es composicion?
// En el diagrama UML nos indica que esta clase, no podria existir sin universidad.    
 /**
PASA LO MISMO, BUSCA UN ESPACIO(NULL) EN EL ARREGLO, EN CASO DE QUE  HALLA UN VACIO
AGREGA EL DEPARTAMENTO, Y SALE DEL METODO. EN CASO DE QUE ESTE LLENO, NO SE REGISTRARA
Y EL SISTEMA LO NOTIFICARA. 
**/

 public void agregarDepartamento(Departamento departamento) {

        for (int i = 0; i < departamentos.length; i++) {

            if (departamentos[i] == null) {

                departamentos[i] = departamento;

                System.out.println(
                    "Departamento agregado correctamente."
                );

                return;
            }
        }

        System.out.println(
            "No hay espacio disponible para departamentos."
        );
    }


/** METODO DE LA COMPOSICION DE DEPARTAMENOT
 ESTE LO QUE HACE ES LISTAR LOS DEPARTAMENTOS QUE  HAY
PREGUNTA SI ESTAN LOS DEPARTAMENTOS.. EN CASO DE QUE HAYA NULL EN EL ARREGLO, NO LES HACE CASO
SOLO MOSTRATA LAS CADENAS DE TEXTO VALIDAS**/
    public void listarDepartamentos() {

        System.out.println(
            "\nDEPARTAMENTOS DE LA UNIVERSIDAD"
        );

        for (int i = 0; i < departamentos.length; i++) {

            if (departamentos[i] != null) {

                System.out.println(
                    departamentos[i]
                );
            }
        }
    }

    @Override
    public String toString() {

        return "Universidad" +
               "\nNombre: " + nombre + 
               "\nCiudad: " + ciudad + 
               "\nFundacion: " + fundacion;
               
    }
}
