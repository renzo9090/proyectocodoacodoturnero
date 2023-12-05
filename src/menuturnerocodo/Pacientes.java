package menuturnerocodo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import conf.ConexionDB;

public class Pacientes {
	public void mostarMenuPac() {
		Scanner in = new Scanner(System.in);
		int opcion;
		// Menu pacientes
		List<String> menuPac = new ArrayList<String>();
		menuPac.add("Ingrese opcion para su carga de datos: ");
		menuPac.add("[1] Listar Pacientes");
		menuPac.add("[2] Modificar Pacientes");
		menuPac.add("[3] Eliminar Pacientes");
		menuPac.add("[4] Alta Pacientes");
		menuPac.add("[9] Atras");
		do {
			System.out.println("----------");
			for (String op : menuPac) {
				System.out.println(op);
			}
			// Ingreso opcion para cargar sus respectivos datos
			opcion = in.nextInt();
			switch (opcion) {
			case 1:
				listarPacientes(in);
				break;

			case 2:
				modificarPacientes(in);
				break;

			case 3:
				eliminarPaciente(in);
				break;

			case 4:
				altaPaciente(in);
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

	public void modificarPacientes(Scanner in) {
		ConexionDB con = new ConexionDB();
		Statement st = con.conectar();
		System.out.println("----------------------- Modificar Paciente ----------------------------");
		List<paciente> listPac = buscarPaciente(in, st);
		System.out.println("Ingrese el id del paciente a modificar");
		int id = in.nextInt();
		try {
			for (paciente paciente : listPac) {
				if (paciente.getId() == id) {
					System.out.println("Ingrese los datos del paciente a modificar");
					System.out.println("Nombre: " + paciente.getNombre());
					String nombre = in.next();
					System.out.println("Apellido: " + paciente.getApellido());
					String apellido = in.next();
					System.out.println("DNI: " + paciente.getDni());
					int dni = in.nextInt();
					System.out.println("email: " + paciente.getEmail());
					String email = in.next();
					int updateOk = st.executeUpdate("UPDATE alumnos SET nombre='" + nombre + "', apellido='" + apellido
							+ "', dni=" + dni + ", email='" + email + "' WHERE id=" + id);
					if (updateOk == 1) {
						System.out.println("El paciente se modifico exitosamente");
					} else {
						System.err.println("No se pudo modificar el paciente");
					}
				}
			}
		} catch (SQLException e) {
			System.err.println("No se pudo modificar el paciente");
		}
	}

	public List<paciente> buscarPaciente(Scanner in, Statement st) {
		List<paciente> listPac = new ArrayList<paciente>();
		ResultSet rs;
		System.out.println("1-nombre, 2-apellido, 3-dni");
		int op = in.nextInt();
		switch (op) {
		case 1:
			System.out.println("Ingrese el nombre");
			String nom = in.next();
			try {
				rs = st.executeQuery("SELECT * FROM alumnos WHERE nombre LIKE '" + nom + "%' ");
				while (rs.next()) {
					paciente pac = new paciente();
					pac.setId(rs.getInt("id"));
					pac.setNombre(rs.getString("nombre"));
					pac.setApellido(rs.getString("apellido"));
					pac.setDni(rs.getInt("dni"));
					pac.setEmail(rs.getString("email"));
					listPac.add(pac);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("  id  |   nombre    |      apellido      |     dni     |        email        ");
			System.out.println("------------------------------------------------------------------------");
			for (paciente paciente : listPac) {
				System.out.println("  " + paciente.getId() + "   	  " + paciente.getNombre() + "          "
						+ paciente.getApellido() + "         " + paciente.getDni() + "    	    "
						+ paciente.getEmail());
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("------------------------------------------------------------------------");
			break;
		case 2:
			System.out.println("Ingrese el apellido");
			String ape = in.next();
			try {
				rs = st.executeQuery("SELECT * FROM alumnos WHERE apellido LIKE '" + ape + "%' ");
				while (rs.next()) {
					paciente pac = new paciente();
					pac.setId(rs.getInt("id"));
					pac.setNombre(rs.getString("nombre"));
					pac.setApellido(rs.getString("apellido"));
					pac.setDni(rs.getInt("dni"));
					pac.setEmail(rs.getString("email"));
					listPac.add(pac);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("  id  |   nombre    |      apellido      |     dni     |        email        ");
			System.out.println("------------------------------------------------------------------------");
			for (paciente paciente : listPac) {
				System.out.println("  " + paciente.getId() + "   	  " + paciente.getNombre() + "          "
						+ paciente.getApellido() + "         " + paciente.getDni() + "    	    "
						+ paciente.getEmail());
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("------------------------------------------------------------------------");
			break;
		case 3:
			System.out.println("Ingrese el dni");
			int dni = in.nextInt();
			try {
				rs = st.executeQuery("SELECT * FROM alumnos WHERE dni LIKE '" + dni + "%' ");
				while (rs.next()) {
					paciente pac = new paciente();
					pac.setId(rs.getInt("id"));
					pac.setNombre(rs.getString("nombre"));
					pac.setApellido(rs.getString("apellido"));
					pac.setDni(rs.getInt("dni"));
					pac.setEmail(rs.getString("email"));
					listPac.add(pac);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("  id  |   nombre    |      apellido      |     dni     |        email        ");
			System.out.println("------------------------------------------------------------------------");
			for (paciente paciente : listPac) {
				System.out.println("  " + paciente.getId() + "   	  " + paciente.getNombre() + "          "
						+ paciente.getApellido() + "         " + paciente.getDni() + "    	    "
						+ paciente.getEmail());
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("------------------------------------------------------------------------");
			break;
		}
		return listPac;
	}

	public void eliminarPaciente(Scanner in) {
		ConexionDB con = new ConexionDB();
		Statement st = con.conectar();
		System.out.println("----------------------- Eliminar Paciente ----------------------------");
		buscarPaciente(in, st);
		System.out.println("Ingrese el id del paciente a eliminar");
		String id = in.next();
		try {
			int deleteOk = st.executeUpdate("DELETE FROM alumnos WHERE id=" + id);
			if (deleteOk == 1) {
				System.out.println("El paciente se elimino exitosamente");
			} else {
				System.err.println("No se pudo eliminar el paciente");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void listarPacientes(Scanner in) {
		List<paciente> listPac = new ArrayList<paciente>();
		ConexionDB con = new ConexionDB();
		Statement st = con.conectar();
		ResultSet rs;
		try {
			rs = st.executeQuery("SELECT * FROM alumnos");
			while (rs.next()) {
				paciente pac = new paciente();
				pac.setId(rs.getInt("id"));
				pac.setNombre(rs.getString("nombre"));
				pac.setApellido(rs.getString("apellido"));
				pac.setDni(rs.getInt("dni"));
				pac.setEmail(rs.getString("email"));
				listPac.add(pac);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("--------------------- Listado de Pacientes ------------------------------------");
		System.out.println("");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("  id  |   nombre    |   apellido    |      dni      |        email        ");
		System.out.println("-------------------------------------------------------------------------------");
		for (paciente paciente : listPac) {
			System.out.println("  " + paciente.getId() + "   	  " + paciente.getNombre() + "          "
					+ paciente.getApellido() + "         " + paciente.getDni() + "    	    " + paciente.getEmail());
		}
		System.out.println("----------------------------------------------------------");
		System.out.println("----------------------------------------------------------");
		System.out.println("Presione una tecla para continuar");
		String cont = in.next();
	}

	/**
	 * alta de paciente nuevo con datos que ingresa usuario
	 */
	public void altaPaciente(Scanner in) {
		System.out.println("------------------ Alta de Paciente --------------------");
		System.out.println("");
		System.out.println("----------------------------------------------------------");
		System.out.println("Ingrese los datos del paciente");
		System.out.println("Nombre:");
		String nombre = in.next();
		System.out.println("Apellido:");
		String apellido = in.next();
		System.out.println("DNI:");
		int dni = in.nextInt();
		System.out.println("email:");
		String email = in.next();
		ConexionDB con = new ConexionDB();
		Statement st = con.conectar();
		try {
			int insOk = st.executeUpdate("INSERT INTO alumnos (nombre, apellido, dni, email) VALUES ('" + nombre + "','"
					+ apellido + "'," + dni + ",'" + email + "') ");
			if (insOk == 1) {
				System.out.println("El paciente se agrego correctamente");
			} else {
				System.err.println("ERROR: el paciente no se pudo agregar, contactese con el administrador");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
