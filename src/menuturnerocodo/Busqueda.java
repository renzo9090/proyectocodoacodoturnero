package menuturnerocodo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import conf.ConexionDB;

public class Busqueda {
	public void mostarMenuBus() {
		Scanner in = new Scanner(System.in);
		int opcion;
		// Seccion de busqueda ¿como busco?
		List<String> menuBus = new ArrayList<String>();
		menuBus.add("Busqueda por: ");
		menuBus.add("[1] Paciente");
		menuBus.add("[2] Medicos");
		menuBus.add("[9] Atras");
		do {
			System.out.println("----------");
			for (String op : menuBus) {
				System.out.println(op);
			}
			opcion = in.nextInt();
			switch (opcion) {
			case 1:
				buscarPaciente(in);
				break;
			case 2:
				buscarMedico(in);
				break;
			case 9:
				do {
					System.out.println("Atras.");
				} while (opcion != 9);
				break;
			default:
				System.err.println("Opcion incorrecta, vuelva a ingresarla.");
				break;
			}
		} while (opcion != 9);
	}

	private void buscarMedico(Scanner in) {
		System.out.println("----------------------- Buscar Medico ----------------------------");
		System.out.println("");
		System.out.println("1-nombre, 2-apellido, 3-dni");
		int op=in.nextInt();
		
		switch (op) {
		
		case 1:
			System.out.println("Ingrese el nombre");
			String nom=in.next();			
			List<medico> listMed1=new ArrayList<medico>();
			ConexionDB con1=new ConexionDB();
			Statement st1=con1.conectar();
			ResultSet rs1;
			try {
				rs1 = st1.executeQuery("SELECT * FROM profesores WHERE nombre LIKE '"+nom+"%' ");
				while (rs1.next()) {
					medico med=new medico();
					med.setId(rs1.getInt("id"));
					med.setNombre(rs1.getString("nombre"));
					med.setApellido(rs1.getString("apellido"));
					med.setDni(rs1.getInt("dni"));
					med.setEmail(rs1.getString("email"));
					listMed1.add(med);
				}							
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("  id  |   nombre    |      apellido      |     dni     |        email        ");
			System.out.println("------------------------------------------------------------------------");		
			for (medico medico : listMed1) {
				System.out.println("  " + medico.getId() + "   	  " + medico.getNombre() + "          "
						+ medico.getApellido()+"         " + medico.getDni() + "    	    " + medico.getEmail());
			}
			System.out.println("----------------------------------------------------------");
			System.out.println("----------------------------------------------------------");
			System.out.println("Presione una tecla para continuar");
			String cont1 = in.next();
			break;
		case 2:
			System.out.println("Ingrese el apellido");
			String ape=in.next();			
			List<medico> listMed11=new ArrayList<medico>();
			ConexionDB con11=new ConexionDB();
			Statement st11=con11.conectar();
			ResultSet rs11;
			try {
				rs11 = st11.executeQuery("SELECT * FROM profesores WHERE apellido LIKE '"+ape+"%' ");
				while (rs11.next()) {
					medico med=new medico();
					med.setId(rs11.getInt("id"));
					med.setNombre(rs11.getString("nombre"));
					med.setApellido(rs11.getString("apellido"));
					med.setDni(rs11.getInt("dni"));
					med.setEmail(rs11.getString("email"));
					listMed11.add(med);
				}							
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("  id  |   nombre    |      apellido      |     dni     |        email        ");
			System.out.println("------------------------------------------------------------------------");		
			for (medico medico : listMed11) {
				System.out.println("  " + medico.getId() + "   	  " + medico.getNombre() + "          "
						+ medico.getApellido()+"         " + medico.getDni() + "    	    " + medico.getEmail());
			}
			System.out.println("----------------------------------------------------------");
			System.out.println("----------------------------------------------------------");
			System.out.println("Presione una tecla para continuar");
			String cont11 = in.next();
			break;
		case 3:
			System.out.println("Ingrese el dni");
			String dni=in.next();			
			List<medico> listMed111=new ArrayList<medico>();
			ConexionDB con111=new ConexionDB();
			Statement st111=con111.conectar();
			ResultSet rs111;
			try {
				rs111 = st111.executeQuery("SELECT * FROM profesores WHERE dni LIKE '"+dni+"%' ");
				while (rs111.next()) {
					medico med=new medico();
					med.setId(rs111.getInt("id"));
					med.setNombre(rs111.getString("nombre"));
					med.setApellido(rs111.getString("apellido"));
					med.setDni(rs111.getInt("dni"));
					med.setEmail(rs111.getString("email"));
					listMed111.add(med);
				}							
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("  id  |   nombre    |      apellido      |     dni     |        email        ");
			System.out.println("------------------------------------------------------------------------");		
			for (medico medico : listMed111) {
				System.out.println("  " + medico.getId() + "   	  " + medico.getNombre() + "          "
						+ medico.getApellido()+"         " + medico.getDni() + "    	    " + medico.getEmail());
			}
			System.out.println("----------------------------------------------------------");
			System.out.println("----------------------------------------------------------");
			System.out.println("Presione una tecla para continuar");
			String cont111 = in.next();
			break;
	}	
	}

	public void buscarPaciente(Scanner in) {
		System.out.println("----------------------- Buscar Paciente ----------------------------");
		System.out.println("");
		System.out.println("1-nombre, 2-apellido, 3-dni");
		int op=in.nextInt();
		
		switch (op) {
		
		case 1:
			System.out.println("Ingrese el nombre");
			String nom=in.next();		
			List<paciente> listPac1 = new ArrayList<paciente>();
			ConexionDB con1=new ConexionDB();
			Statement st1=con1.conectar();
			ResultSet rs1;
			try {
				rs1 = st1.executeQuery("SELECT * FROM alumnos WHERE nombre LIKE '"+nom+"%' ");
				while (rs1.next()) {
					paciente pac=new paciente();
					pac.setId(rs1.getInt("id"));
					pac.setNombre(rs1.getString("nombre"));
					pac.setApellido(rs1.getString("apellido"));
					pac.setDni(rs1.getInt("dni"));
					pac.setEmail(rs1.getString("email"));
					listPac1.add(pac);
				}							
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("  id  |   nombre    |      apellido      |     dni     |        email        ");
			System.out.println("------------------------------------------------------------------------");
			
			for (paciente paciente : listPac1) {
				System.out.println("  " + paciente.getId() + "   	  " + paciente.getNombre() + "          "
						+ paciente.getApellido() +"         " + paciente.getDni()+ "    	    " + paciente.getEmail());
			}
			System.out.println("----------------------------------------------------------");
			System.out.println("----------------------------------------------------------");
			System.out.println("Presione una tecla para continuar");
			String cont11 = in.next();
			break;
		case 2:
			System.out.println("Ingrese el apellido");
			String ape=in.next();		
			List<paciente> listPac3 = new ArrayList<paciente>();
			ConexionDB con2=new ConexionDB();
			Statement st2=con2.conectar();
			ResultSet rs2;
			try {
				rs1 = st2.executeQuery("SELECT * FROM alumnos WHERE apellido LIKE '"+ape+"%' ");
				while (rs1.next()) {
					paciente pac=new paciente();
					pac.setId(rs1.getInt("id"));
					pac.setNombre(rs1.getString("nombre"));
					pac.setApellido(rs1.getString("apellido"));
					pac.setDni(rs1.getInt("dni"));
					pac.setEmail(rs1.getString("email"));
					listPac3.add(pac);
				}							
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("  id  |   nombre    |      apellido      |     dni     |        email        ");
			System.out.println("------------------------------------------------------------------------");
			
			for (paciente paciente : listPac3) {
				System.out.println("  " + paciente.getId() + "   	  " + paciente.getNombre() + "          "
						+ paciente.getApellido() +"         " + paciente.getDni()+ "    	    " + paciente.getEmail());
			}
			System.out.println("----------------------------------------------------------");
			System.out.println("----------------------------------------------------------");
			System.out.println("Presione una tecla para continuar");
			String cont3 = in.next();
			break;
		case 3:
			System.out.println("Ingrese el dni");
			String dni=in.next();		
			List<paciente> listPac31 = new ArrayList<paciente>();
			ConexionDB con21=new ConexionDB();
			Statement st21=con21.conectar();
			ResultSet rs21;
			try {
				rs1 = st21.executeQuery("SELECT * FROM alumnos WHERE dni LIKE '"+dni+"%' ");
				while (rs1.next()) {
					paciente pac=new paciente();
					pac.setId(rs1.getInt("id"));
					pac.setNombre(rs1.getString("nombre"));
					pac.setApellido(rs1.getString("apellido"));
					pac.setDni(rs1.getInt("dni"));
					pac.setEmail(rs1.getString("email"));
					listPac31.add(pac);
				}							
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("  id  |   nombre    |      apellido      |     dni     |        email        ");
			System.out.println("------------------------------------------------------------------------");
			
			for (paciente paciente : listPac31) {
				System.out.println("  " + paciente.getId() + "   	  " + paciente.getNombre() + "          "
						+ paciente.getApellido() +"         " + paciente.getDni()+ "    	    " + paciente.getEmail());
			}
			System.out.println("----------------------------------------------------------");
			System.out.println("----------------------------------------------------------");
			System.out.println("Presione una tecla para continuar");
			String cont31 = in.next();
			break;
	}
	}
}
