package practicoInmuebleJAVA.UI;

import practicoInmuebleJAVA.*;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;


public class UserUI {

	public static void main(String[] args) throws IOException {

	Inmobiliaria caece = new Inmobiliaria();
	
	Inmueble i1 = new Inmueble ();
	Inmueble i2 = new Inmueble ();
	Inmueble i3 = new Inmueble ();
	Inmueble i4 = new Inmueble ();
	Inmueble i5 = new Inmueble ();
	Inmueble i6 = new Inmueble ();
	Inmueble i7 = new Inmueble ();
	Inmueble i8 = new Inmueble ();
	
	Agente a1;
	Agente a2;
	Agente a3;
	
	Propietario p1;
	Propietario p2;
	Propietario p3;
	Propietario p4;
	Propietario p5;
	
	// Creo las variables para ingreso de informacion por pantalla
		Scanner entrada = new Scanner(System.in);
		String tipoProp = null;
		String estado = null;
		String luminosidad = null;
		String vigilancia = null;
		String estConserva = null;
		
	// Bienvenida.
	
	// Consulta al usuario por los inmubles que que desea encontrar.
		
		System.out.println("BIENVENIDOS A INMOBILIARIA CAECE 2018\n");
		System.out.println("Que tipo de propiedad esta buscando?:\n");
		System.out.println("Filtre por estas 5 principales características:\n");
		System.out.println("Las opciones están numeradas, por favor elija el número de la opción que desee\n");
	
		System.out.println("A - Tipo de propiedad:\n");   
		System.out.println ( "1 - ESTUDIO");
		System.out.println ( "2 - LOFT");
		System.out.println ( "3 - DEPARTAMENTO");
		System.out.println ( "4 - PISO");
		System.out.println ( "5 - DUPLEX");
		System.out.println ( "6 - TRIPLEX");
		System.out.println ( "7 - CHALET");
		System.out.println ( "8 - CASA");
		System.out.println ( "9 - LOCAL");
		System.out.println ( "10 - COCHERA");
		System.out.println ( "11 - OFICINA");
		System.out.println ( "12 - EDIFICIO");
			String valor = entrada.nextLine();
			
			switch (valor) {
			case "1":
				tipoProp = "ESTUDIO"; break;
			case "2":
				tipoProp = "LOFT"; break;
			case "3":
				tipoProp = "DEPARTAMENTO"; break;
			case "4":
				tipoProp = "PISO"; break;
			case "5":
				tipoProp = "DUPLEX"; break;
			case "6":
				tipoProp = "TRIPLEX"; break;
			case "7":
				tipoProp = "CHALET"; break;
			case "8":
				tipoProp = "CASA"; break;
			case "9":
				tipoProp = "LOCAL"; break;
			case "10":
				tipoProp = "COCHERA"; break;
			case "11":
				tipoProp = "OFICINA"; break;
			case "12":
				tipoProp = "EDIFICIO"; break;
			}
				
		System.out.println("B - Estado:\n");   
		System.out.println ( "1 - HABITADO POR PROPIETARIO");
		System.out.println ( "2 - HABITADO POR INQUILINO");
		System.out.println ( "3 - DESHABITADO");
		System.out.println ( "4 - EN CONSTRUCCION");
			 valor = entrada.nextLine();
					
			switch (valor) {
			case "1":
				estado = "HABITADO_PROPIETARIO"; break;
			case "2":
				estado = "HABITADO_INQUILINO"; break;
			case "3":
				estado = "DESHABITADO"; break;
			case "4":
				estado = "EN_CONTRUCCION"; break;
			}
					
		System.out.println("C - Luminosidad:\n");   
		System.out.println ( "1 - ALTA");
		System.out.println ( "2 - MEDIA");
		System.out.println ( "3 - BAJA");
			valor = entrada.nextLine();
							
			switch (valor) {
			case "1":
				luminosidad = "ALTA"; break;
			case "2":
				luminosidad = "MEDIA"; break;
			case "3":
				luminosidad = "BAJA"; break;
			}
			
				
		System.out.println("D - Vigilancia:\n");   
		System.out.println ( "1 - 24 HS");
		System.out.println ( "2 - DIURNO");
		System.out.println ( "3 - NOCTURNO");
		System.out.println ( "4 - SIN VIGILANCIA");
			valor = entrada.nextLine();
									
			switch (valor) {
			case "1":
				vigilancia = "VEINTICUATRO_HS"; break;
			case "2":
				vigilancia = "DIURNO"; break;
			case "3":
				vigilancia = "NOCTURNO"; break;				
			case "4":
				vigilancia = "NO_TIENE"; break;			
			}	
				
		System.out.println("D - Estdo de conservación:\n");   
		System.out.println ( "1 - A ESTRENAR");
		System.out.println ( "2 - A RECICLAR");
		System.out.println ( "3 - IMPECABLE");
		System.out.println ( "4 - MUY BUENO");
		System.out.println ( "5 - BUENO");
			valor = entrada.nextLine();
										
			switch (valor) {
			case "1":
				estConserva = "A_ESTRENAR"; break;
			case "2":
				estConserva = "A_RECICLAR"; break;
			case "3":
				estConserva = "IMPECABLE"; break;				
			case "4":
				estConserva = "MUY_BUENO"; break;				
			case "5":
				estConserva = "BUENO"; break;
			}
				
		//Impresion de los datos ingresados
			
		System.out.println("Tipo de propiedad:" + tipoProp);
		System.out.println("Estado:" + estado);
		System.out.println("Luminosidad:" + luminosidad);
		System.out.println("Vigilancia:" + vigilancia);
		System.out.println("Estado de conservación:" + estConserva);
			
	//Ejecucion de busqueda de popiedad con los filtros configurados.
		
		//	caece.busqueda(estado, luminosidad, vigilancia, estConserva, tipoProp);
			
	//Procedimiento para mostrar todas las popiedades encontradas numeras con todas sus propiedades para que el usuario elija la quedese
		
	//Eleccion de tipo de operacion
		
	// Operacion
		
	//Operaciones postOperacion solicitadas
		
		
			
	}
	
}

