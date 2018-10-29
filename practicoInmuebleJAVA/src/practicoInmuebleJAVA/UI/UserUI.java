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
	
//	// Creo las variables para ingreso de informacion por pantalla
//	
//	Scanner entrada = new Scanner(System.in);
//	
//		
//	// Bienvenida.
//		System.out.println("Bienvenido a Inmobiliaria CAECE 2018\n");
//	
//	// Consulta al usuario por los inmubles que que desea encontrar.
//	
//		System.out.println("Que tipo de propiedad esta buscando:\n");
//		System.out.println("Filtre por estas 5 principales caracteristicas:\n");
//		System.out.println("Ingresar por favor los nombres exactos que aparecen entre parentesis en cada caracteristica\n");
//	
//		System.out.println("Tipo de propiedad: ESTUDIO, LOFT, DEPARTAMENTO, PISO, DUPLEX, TRIPLEX, CHALET, CASA, LOCAL, COCHERA, OFICINA, EDIFICIO");
//			String tipoProp = entrada.nextLine();
//		System.out.println("Estado: HABITADO_PROPIETARIO, DESHABITADO, EN_CONSTRUCCION, HABITADO_INQUILINO");
//			String estado = entrada.nextLine();
//		System.out.println("Luminocidad: ALTA, MEDIA, BAJA");
//			String luminocidad = entrada.nextLine();
//		System.out.println("Vigilancia: VEINTICUATRO_HS, DIURNO, NOCTURNO, NO_TIENE");
//			String vigilancia = entrada.nextLine();
//		System.out.println("Estado de conservación: A_ESTRENAR, A_RECICLAR, IMPECABLE, BUENO, MUY_BUENO");
//			String estConserva = entrada.nextLine();
//		
//	//Impresion de los datos ingresados
//			
//		System.out.println("Tipo de propiedad:" + tipoProp);
//		System.out.println("Estado:" + estado);
//		System.out.println("Luminocidad:" + luminocidad);
//		System.out.println("Vigilancia:" + vigilancia);
//		System.out.println("Estado de conservación:" + estConserva);
//			
//	//Ejecucion de busqueda de popiedad con los filtros configurados.
			
//		//	caece.busqueda(estado, luminocidad, vigilancia, estConserva, tipoProp);
			
	
	// Creo las variables para ingreso de informacion por pantalla
	
		String tipoProp;
		String estado;
		String luminocidad;
		String vigilancia;
		String estConserva;
			
	// Bienvenida.
		
		JOptionPane.showMessageDialog(null,"BIENVENIDOS A LA INMOBILIARIA CAECE 2018\n" + "\n" + "¿Qué tipo de propiedad esta buscando?:\n" + "\n" + "Filtre por estas 5 principales caracteristicas:\n" + "TIPO DE PROPIEDAD, ESTADO, LUMINOCIDAD, VIGILANCIA, ESTADO DE CONSERVACION\n" + "(Ingresar por favor los nombres exactos que aparecen entre parentesis en cada caracteristica:)");
		
	// Consulta al usuario por los inmubles que que desea encontrar.
		
		tipoProp = JOptionPane.showInputDialog(null, "Iipo de propiedad:\n" + "\n" + "ESTUDIO, LOFT, DEPARTAMENTO, PISO, DUPLEX, TRIPLEX, CHALET, CASA, LOCAL, COCHERA, OFICINA, EDIFICIO");
		estado = JOptionPane.showInputDialog(null, "Estado:\n" + "\n" + "HABITADO_PROPIETARIO, DESHABITADO, EN_CONSTRUCCION, HABITADO_INQUILINO");
		luminocidad = JOptionPane.showInputDialog(null, "Luminocidad:\n" + "\n" + "ALTA, MEDIA, BAJA");
		vigilancia = JOptionPane.showInputDialog(null, "Vigilancia: \n" + "\n" + "VEINTICUATRO_HS, DIURNO, NOCTURNO, NO_TIENE");
		estConserva = JOptionPane.showInputDialog(null, "Estado de conservación:\n" + "\n" + "A_ESTRENAR, A_RECICLAR, IMPECABLE, BUENO, MUY_BUENO");

		
	// Impresion de los datos ingresados				
		System.out.println("Tipo de propiedad:" + tipoProp);
		System.out.println("Estado:" + estado);
		System.out.println("Luminocidad:" + luminocidad);
		System.out.println("Vigilancia:" + vigilancia);
		System.out.println("Estado de conservación:" + estConserva);
		
	// Ejecucion de busqueda de popiedad con los filtros configurados.
			
	//	caece.busqueda(estado, luminocidad, vigilancia, estConserva, tipoProp);	
			
	}
	
}

