package practicoInmuebleJAVA.UI;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import practicoInmuebleJAVA.*;

public class Menues {
	
	private Scanner entrada;
	private String tipoProp = null;
	private String estado = null;
	private String luminosidad = null;
	private String vigilancia = null;
	private String estConserva = null;
		
	// Desarrollo de todos los menues del main.
	
	public void Menu1 (Inmobiliaria im) {
		String valor = "0";
		System.out.println("BIENVENIDOS A INMOBILIARIA CAECE 2018\n");
		System.out.println("Elija su perfil:\n");
		entrada = new Scanner(System.in);
		
		while (!valor.equals("3")){
			
			System.out.println("PERFIL:\n");   
			System.out.println ( "1 - INMOBILIARIO");
			System.out.println ( "2 - POSIBLE CLIENTE");
			System.out.println ( "3 - SALIR");
				
			valor = entrada.nextLine();
				switch (valor) {
					case "1":
						 this.MenuInmob(im); break;
					case "2":
						this.MenuCliente(im); break;
					case "3":
						break;
					default:
						System.out.println("Ud. ingreso un dato erroneo, intentelo de nuevo"); break;
					}
				//para salir
				if (valor.equals("3")) {
					System.out.println("Gracias, vuelva pronto!");
					break;
				}
		}
	}

	// Menu para el inmobiliario.
	
	public void MenuInmob (Inmobiliaria im) {
		String valor = "0";
		int valor2 = 0;
		entrada = new Scanner(System.in);
		
		while (!valor.equals("6")) {
			
			System.out.println("INMOBILIARIO:\n");   
			System.out.println ( "1 - AGREGAR UNA PROPIEDAD");
			System.out.println ( "2 - ELIMINAR UNA PROPIEDAD");
			System.out.println ( "3 - AGREGAR UN AGENTE");
			System.out.println ( "4 - ELIMINAR UN AGENTE");
			System.out.println ( "5 - CALCULAR SALARIOS DE AGENTE");
			System.out.println ( "6 - MENU ANTERIOR");
						
			valor = entrada.nextLine();
				switch (valor) {
					case "1":
						 im.MenuAgregarInmueble(im);break;
					case "2":
						System.out.println ( "Metodo para eliminar una propiedad..."); break;
					case "3":
						System.out.println ( "Metodo para agregar un agente..."); break;
					case "4":
						System.out.println ( "Metodo para eliminar un agente..."); break;
					case "5":
						double sueldo = 0;
						boolean repetir = true;
   						System.out.println("Ingrese el dni del agente: ");
						try {
							valor2= entrada.nextInt();
						}catch(InputMismatchException e){
							System.out.println("Error, has introducido mal el dni");
						}
						//Metodo para calcular el sueldo del agente.
						sueldo = im.calcularSueldoAgente(valor2);							
						System.out.println("El sueldo del agente de dni:" + valor2 + "es: " + sueldo);
						break;
					case "6":
						break;
					default:
						System.out.println("Ud. ingreso un nro erroneo, intentelo de nuevo");
				}
				if (valor.equals("6")) {
					break;
				}
		}
	}
	
	public void MenuCliente (Inmobiliaria im) {
		String valor = "0";
		entrada = new Scanner(System.in);
		ArrayList<String> f = new ArrayList<String>();
		
		while (!valor.equals("2")) {
			System.out.println("POSIBLE CLIENTE:\n");   
			System.out.println ( "1 - BUSQUEDA DE PROPIEDAD");
			System.out.println ( "2 - MENU ANTERIOR");
		
			valor = entrada.nextLine();
			
			switch (valor) {
				case "1":
					f = this.Filtros();
					List <Inmueble> inmuebles = im.buscarInmueble(f);
					im.mostrarInmuebles(inmuebles);
					if(inmuebles.size() > 0) {
						System.out.println("ELIJA EL INMUEBLE CON EL QUE DESEA OPERAR O 0 PARA VOLVER");
						Scanner seleccionado = new Scanner(System.in);
						String indice = seleccionado.nextLine();
						if(!indice.equals("") && Integer.parseInt(indice) >= 1 && Integer.parseInt(indice) < inmuebles.size())
							im.operar(inmuebles.get(Integer.parseInt(indice) -1).getId());
						else
							System.out.println("La propiedad seleccionada no existe");
						seleccionado.close();
						break;
					}
				case "2":
					break;
				default:
					System.out.println("Ud. ingreso un nro erroneo, intentelo de nuevo");
			}
			//para volver al menu anterior cuando se sale de bloque switch
			if (valor.equals("2")) {
				break;
			}
		}
					
	}
	
	// Filtro para eleccion de tipo de propiedad.
	
	public String filtro1() {
		String valor = "0";
		entrada = new Scanner(System.in);
		
		while (!(valor.equals("1") || valor.equals("2") || valor.equals("3") || valor.equals("4") || valor.equals("5") || valor.equals("6") || valor.equals("7") || valor.equals("8") || valor.equals("9") || valor.equals("10") || valor.equals("11") || valor.equals("12") || valor.equals("13"))) {
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
			System.out.println ( "13 - TODAS");
				
			valor = entrada.nextLine();
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
				case "13":
					tipoProp = "VACIO"; break;
				default:
					System.out.println("Ud. ingreso un nro erroneo, intentelo de nuevo");
			}
		}
		return tipoProp;
	}
	
	public String filtro2() {
		String valor = "0";
		entrada = new Scanner(System.in);

		
		while (!(valor.equals("1") || valor.equals("2") || valor.equals("3") || valor.equals("4") || valor.equals("5"))) {
			
			System.out.println("B - Estado:\n");   
			System.out.println ( "1 - HABITADO POR PROPIETARIO");
			System.out.println ( "2 - HABITADO POR INQUILINO");
			System.out.println ( "3 - DESHABITADO");
			System.out.println ( "4 - EN CONSTRUCCION");
			System.out.println ( "5 - TODAS");
						
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
				case "5":
					estado = "VACIO"; break;
				default:
					System.out.println("Ud. ingreso un nro erroneo, intentelo de nuevo");
			}
		}
		return estado;
	}
	
	public String filtro3() {
		String valor = "0";
		entrada = new Scanner(System.in);
		
		while (!(valor.equals("1") || valor.equals("2") || valor.equals("3") || valor.equals("4"))) {
			
			System.out.println("C - Luminosidad:\n");   
			System.out.println ( "1 - ALTA");
			System.out.println ( "2 - MEDIA");
			System.out.println ( "3 - BAJA");
			System.out.println ( "4 - TODAS");
				
			valor = entrada.nextLine();
			switch (valor) {
				case "1":
					luminosidad = "ALTA"; break;
				case "2":
					luminosidad = "MEDIA"; break;
				case "3":
					luminosidad = "BAJA"; break;
				case "4":
					luminosidad = "VACIO"; break;
				default:
					System.out.println("Ud. ingreso un nro erroneo, intentelo de nuevo");
			}
		}
		return luminosidad;
	}
	
	public String filtro4() {
		String valor = "0";
		entrada = new Scanner(System.in);
		
		while (!(valor.equals("1") || valor.equals("2") || valor.equals("3") || valor.equals("4") || valor.equals("5"))) {
			
			System.out.println("D - Vigilancia:\n");   
			System.out.println ( "1 - 24 HS");
			System.out.println ( "2 - DIURNO");
			System.out.println ( "3 - NOCTURNO");
			System.out.println ( "4 - SIN VIGILANCIA");
			System.out.println ( "5 - TODAS");
				
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
				case "5":
					vigilancia = "VACIO"; break;	
				default:
					System.out.println("Ud. ingreso un nro erroneo, intentelo de nuevo");
			}
		}
		return vigilancia;
	}
	
	public String filtro5() {
		String valor = "0";
		entrada = new Scanner(System.in);
			
		while (!(valor.equals("1") || valor.equals("2") || valor.equals("3") || valor.equals("4") || valor.equals("5") || valor.equals("6")))  {
			System.out.println("E - Estado de conservacion:\n");   
			System.out.println ( "1 - A ESTRENAR");
			System.out.println ( "2 - A RECICLAR");
			System.out.println ( "3 - IMPECABLE");
			System.out.println ( "4 - MUY BUENO");
			System.out.println ( "5 - BUENO");
			System.out.println ( "6 - TODAS");
				
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
				case "6":
					estConserva = "VACIO"; break;
				default:
					System.out.println("Ud. ingreso un nro erroneo, intentelo de nuevo");
			}
		}	
		return estConserva;
	}
	
	public ArrayList<String> Filtros () {
		
		System.out.println("Que tipo de propiedad esta buscando?:\n");
		System.out.println("Filtre por estas 5 principales caracteristicas:\n");
		System.out.println("Las opciones estan numeradas, por favor elija el numero de la opcion que desee\n");
		
		tipoProp = this.filtro1();
		estado = this.filtro2();
		luminosidad = this.filtro3();
		vigilancia = this.filtro4();
		estConserva = this.filtro5();
		
		
		ArrayList<String> filtros = new ArrayList<String>();
		String[] f = {tipoProp, estado, luminosidad, vigilancia, estConserva};
			
		for (String o: f) {
			filtros.add(o);
		}
		return filtros;
		
	}
}