package practicoInmuebleJAVA.UI;

import practicoInmuebleJAVA.*;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;


public class UserUI {

	public static void main(String[] args) throws IOException {

	Inmobiliaria caece = new Inmobiliaria();
	
	Agente a1 = new Agente("Carlos", "Ramos", 5456789, 43567856, 1567893456, "cramos@gmail.com", "Avalos 3456", "1234", "CABA", "", 1, 27547898, 10000);
	Agente a2 = new Agente("Norma", "Zadil", 20456345, 54673470, 1534672300, "norma.zadil@hotmail.com", "Ricardo Gutierrez 2578", "1004", "CABA", "", 1, 2345679, 5000);
	Agente a3 = new Agente("Roberto", "Espinosa", 10456983, 34892765, 1533786541, "espinosa.robert@gmail.com", "Av. Libertador 5670", "1567", "CABA", "", 1, 20104567, 13000);
	
	Propietario p1 = new Propietario("Soledad", "Soriano", 3456987, 56749800, 1534562789, "sole.so@gmail.com", "Rivadavia 396", "2367", "CABA", "");
	Propietario p2 = new Propietario("Marcelo", "Santillan", 23456897, 56893721, 1545803467, "santillan.marcelo@gmail.com", "Tacuarí 675", "1009", "CABA", "");
	Propietario p3 = new Propietario("Esteban", "Rinauldo", 9758386, 499805732, 1560789530, "esteban_r@gmail.com", "Combatientes 4569", "3400", "CABA", "");
	Propietario p4 = new Propietario("Julio", "Lima", 7668983, 499807656, 1534560087, "lima.julio@hotmail.com", "Doblas 44531", "4589", "CABA", "");
	Propietario p5 = new Propietario("Beatriz", "Garcia", 5990876, 45609138, 1545332109, "bgarcia@hotmailmail.com", "La Pampa 3487", "1431", "CABA", "");
	
	Inmueble i1 = new Inmueble (p1, a1, "Berna", 234);
	Inmueble i2 = new Inmueble (p2, a1, "Londres", 2145);
	Inmueble i3 = new Inmueble (p3, a1, "Ginebra", 1343, 3, "C");
	Inmueble i4 = new Inmueble (p4, a2, "Berlin", 456);
	Inmueble i5 = new Inmueble (p5, a2, "Gandara", 3423);
	Inmueble i6 = new Inmueble (p1, a2, "Liverpool", 1254, 2, "B");
	Inmueble i7 = new Inmueble (p2, a3, "La Haya", 334);
	Inmueble i8 = new Inmueble (p3, a3, "Dublin", 4322, 1, "A");
	
	Menues menus = new Menues();
	menus.Menu1();
	

	//Ejecucion de busqueda de popiedad con los filtros configurados.
		
		//	caece.busqueda(estado, luminosidad, vigilancia, estConserva, tipoProp);
			
	//Procedimiento para mostrar todas las popiedades encontradas numeras con todas sus propiedades para que el usuario elija la quedese
		
	//Eleccion de tipo de operacion
		
	// Operacion
		
	//Operaciones postOperacion solicitadas
		
		
			
	}
	
}

