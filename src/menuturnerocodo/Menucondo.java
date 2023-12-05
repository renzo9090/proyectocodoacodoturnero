package menuturnerocodo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menucondo {

	public static void main(String[] args) {

		// Iniciamos la agenda ingresando usuario y contraseña.
		Scanner in = new Scanner(System.in);

		// Ingreso con usu y contraseña con while
		String usuOK = "turnero@gmail.com";
		String passOK = "123";

		String usu;
		String pass;

		System.out.println("Ingrese su usuario");
		usu = in.next();
		System.out.println("Ingrese su contrase�a");
		pass = in.next();

		// Mejor while para no limitar intentos
		while (!usu.equals(usuOK) || !pass.equals(passOK)) {
			System.err.println("Error. Ingrese usuario y contraseña correcta.");
			System.out.println("Ingrese su usuario");
			usu = in.next();
			System.out.println("Ingrese su contrase�a");
			pass = in.next();
		}

		// Ingresamos a la agenda y vemos las opciones a seleccionar.
		System.out.println("Muchas Gracias.");
		int opcion;

		List<String> menuIni = new ArrayList<String>();
		menuIni.add("Bienvenidos al turnero de estudios Medicoss.");
		menuIni.add("Porfavor elija la opcion deseada.");
		menuIni.add("[1] Pacientes");
		menuIni.add("[2] Medicoss");
		menuIni.add("[3] Buscar Medicos o paciente");
		menuIni.add("[0] Salir");

		// Utilizamos DO para movernos dentro de las opciones.
		do {
			System.out.println("----------");
			for (String op : menuIni) {
				System.out.println(op);
			}
			opcion = in.nextInt();

			// Dentro de las opciones, comenzamos a seleccionar cada una.
			switch (opcion) {
			case 1:
				Pacientes pac = new Pacientes();
				pac.mostarMenuPac();
				break;

			case 2:
				Medicos med = new Medicos();
				med.mostrarMenuMed();
				break;

			case 3:
				Busqueda bus = new Busqueda();
				bus.mostarMenuBus();
				break;

			// Seccion de ir hacia atras en las opciones.
			case 0:
				do {
					System.out.println("Hasta luego.");
				} while (opcion != 0);
				break;

			default:
				System.err.println("Opcion incorrecta, vuelva a ingresarla.");
				break;
			}
		} while (opcion != 0);

		// ¿Como vuelvo atras desde donde ingresa a usu y pass?
		in.close();
	}
}