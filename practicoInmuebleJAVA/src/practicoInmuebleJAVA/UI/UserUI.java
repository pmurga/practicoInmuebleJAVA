package practicoInmuebleJAVA.UI;

import practicoInmuebleJAVA.*;

import java.io.IOException;
import java.util.ArrayList;



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
	
	Inmueble i1 = new Inmueble (p1, a1, "Berna", 234, "CASA");
	i1.alquilar(9500, 10, true, 30, 1, 24,a1);
	Inmueble i2 = new Inmueble (p2, a1, "Londres", 2145, "CASA");
	i2.vender(2200000, 4, 15, a1);
	Inmueble i3 = new Inmueble (p3, a1, "Ginebra", 1343, 3, "C", "DEPARTAMENTO");
	i3.alquilar(10500, 15, true, 25.5f, 1, 24,a1);
	Inmueble i4 = new Inmueble (p4, a2, "Berlin", 456, "TRIPLEX");
	i4.alquilar(15000, 12, false, 34.5f, 2, 12,a2);
	Inmueble i5 = new Inmueble (p5, a2, "Gandara", 3423, "DUPLEX");
	i5.vender(1865790, 4, 13, a3);
	Inmueble i6 = new Inmueble (p1, a2, "Liverpool", 1254, 2, "B", "DEPARTAMENTO");
	i6.alquilar(8500, 15, false, 12.5f, 1, 24,a2);
	Inmueble i7 = new Inmueble (p2, a3, "La Haya", 334, "LOCAL");
	i7.alquilar(15500, 10, false, 10.5f, 1, 12,a3);
	Inmueble i8 = new Inmueble (p3, a3, "Dublin", 4322, 1, "A", "DEPARTAMENTO");
	i8.vender(1250000, 5, 10, a3);
	
	
	//para inicializar el programa con una base de datos
	
	ArrayList <Object> inicializador = new ArrayList<>();
	inicializador.add(a1);
	inicializador.add(a2);
	inicializador.add(a3);
	inicializador.add(i1);
	inicializador.add(i2);
	inicializador.add(i3);
	inicializador.add(i4);
	inicializador.add(i5);
	inicializador.add(i6);
	inicializador.add(i7);
	inicializador.add(i8);
	
	//inicializar base de datos de inmobiliaria
	for (Object objeto : inicializador) {
		
		if (objeto instanceof Inmueble) {
			caece.addInmueble((Inmueble)objeto);
		}
		if (objeto instanceof Agente) {
			caece.addAgente((Agente)objeto);
		}	
	}
	
	
	Menues menus = new Menues();
	menus.Menu1(caece);

			
	}
	
}

