package menuturnerocodo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import conf.ConexionDB;

public class Medicos {
	public void mostrarMenuMed() {
		Scanner in = new Scanner(System.in);
		int opcion;

		// Seccion medico ¿como ingreso datos?
		List<String> menuMed = new ArrayList<String>();
		menuMed.add("Ingrese opcion para su carga de datos: ");
		menuMed.add("[1] Listar Medicos");
		menuMed.add("[2] Modificar Medicos");
		menuMed.add("[3] Eliminar Medicos");
		menuMed.add("[4] Alta Medicos");
		menuMed.add("[9] Atras");

		do {
			System.out.println("----------");
			for (String op : menuMed) {
				System.out.println(op);
			}
			opcion = in.nextInt();

			switch (opcion) {
			case 1:
				listarMedicos(in);
				break;

			case 2:
				modificarMedicos(in);
				break;
			case 3:
				eliminarMedicos(in);
				break;

			case 4:
				altaMedicos(in);
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

	public void modificarMedicos(Scanner in) {
		ConexionDB con = new ConexionDB();
		Statement st = con.conectar();
		System.out.println("----------------------- Modificar Medico ----------------------------");
		List<medico> listMed = buscarMedico(in, st);
		int id = in.nextInt();
		try {
			for (medico medico : listMed) {
				if (medico.getId() == id) {
					System.out.println("Ingrese los datos del medico a modificar");
					System.out.println("Nombre: " + medico.getNombre());
					String nombre = in.next();
					System.out.println("Apellido: " + medico.getApellido());
					String apellido = in.next();
					System.out.println("DNI: " + medico.getDni());
					int dni = in.nextInt();
					System.out.println("email: " + medico.getEmail());
					String email = in.next();
					int updateOk = st.executeUpdate("UPDATE profesores SET nombre='" + nombre + "', apellido='"
							+ apellido + "', dni=" + dni + ", email='" + email + "' WHERE id=" + id);
					if (updateOk == 1) {
						System.out.println("El medico se modifico exitosamente");
					} else {
						System.err.println("No se pudo modificar el medico");
					}
				}
			}
		} catch (SQLException e) {
			System.err.println("No se pudo modificar el medico");
		}
	}

	public List<medico> buscarMedico(Scanner in, Statement st) {
		List<medico> listMed = new ArrayList<medico>();
		ResultSet rs;
		System.out.println("1-nombre, 2-apellido, 3-dni");
		int op = in.nextInt();
		switch (op) {
		case 1:
			System.out.println("Ingrese el nombre");
			String nom = in.next();
			try {
				rs = st.executeQuery("SELECT * FROM profesores WHERE nombre LIKE '" + nom + "%' ");
				while (rs.next()) {
					medico pac = new medico();
					pac.setId(rs.getInt("id"));
					pac.setNombre(rs.getString("nombre"));
					pac.setApellido(rs.getString("apellido"));
					pac.setDni(rs.getInt("dni"));
					pac.setEmail(rs.getString("email"));
					listMed.add(pac);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("  id  |   nombre    |      apellido      |     dni     |        email        ");
			System.out.println("------------------------------------------------------------------------");
			for (medico medico : listMed) {
				System.out.println("  " + medico.getId() + "   	  " + medico.getNombre() + "          "
						+ medico.getApellido() + "         " + medico.getDni() + "    	    " + medico.getEmail());
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("------------------------------------------------------------------------");
			break;
		case 2:
			System.out.println("Ingrese el apellido");
			String ape = in.next();
			try {
				rs = st.executeQuery("SELECT * FROM profesores WHERE apellido LIKE '" + ape + "%' ");
				while (rs.next()) {
					medico pac = new medico();
					pac.setId(rs.getInt("id"));
					pac.setNombre(rs.getString("nombre"));
					pac.setApellido(rs.getString("apellido"));
					pac.setDni(rs.getInt("dni"));
					pac.setEmail(rs.getString("email"));
					listMed.add(pac);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("  id  |   nombre    |      apellido      |     dni     |        email        ");
			System.out.println("------------------------------------------------------------------------");
			for (medico medico : listMed) {
				System.out.println("  " + medico.getId() + "   	  " + medico.getNombre() + "          "
						+ medico.getApellido() + "         " + medico.getDni() + "    	    " + medico.getEmail());
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("------------------------------------------------------------------------");
			break;
		case 3:
			System.out.println("Ingrese el dni");
			int dni = in.nextInt();
			try {
				rs = st.executeQuery("SELECT * FROM profesores WHERE dni LIKE '" + dni + "%' ");
				while (rs.next()) {
					medico pac = new medico();
					pac.setId(rs.getInt("id"));
					pac.setNombre(rs.getString("nombre"));
					pac.setApellido(rs.getString("apellido"));
					pac.setDni(rs.getInt("dni"));
					pac.setEmail(rs.getString("email"));
					listMed.add(pac);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("  id  |   nombre    |      apellido      |     dni     |        email        ");
			System.out.println("------------------------------------------------------------------------");
			for (medico medico : listMed) {
				System.out.println("  " + medico.getId() + "   	  " + medico.getNombre() + "          "
						+ medico.getApellido() + "         " + medico.getDni() + "    	    " + medico.getEmail());
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("------------------------------------------------------------------------");
			break;
		}
		return listMed;
	}

	public void eliminarMedicos(Scanner in) {
		ConexionDB con = new ConexionDB();
		Statement st = con.conectar();
		System.out.println("----------------------- Eliminar Medico ----------------------------");
		buscarMedico(in, st);
		System.out.println("Ingrese el id del medico a eliminar");
		String id = in.next();
		try {
			int deleteOk = st.executeUpdate("DELETE FROM profesores WHERE id=" + id);
			if (deleteOk == 1) {
				System.out.println("El medicos se elimino exitosamente");
			} else {
				System.err.println("No se pudo eliminar el medico");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void listarMedicos(Scanner in) {
		List<medico> listMedi = new ArrayList<medico>();
		ConexionDB con = new ConexionDB();
		Statement st = con.conectar();
		ResultSet rs;
		try {
			rs = st.executeQuery("SELECT * FROM profesores");
			while (rs.next()) {
				medico med = new medico();
				med.setId(rs.getInt("id"));
				med.setNombre(rs.getString("nombre"));
				med.setApellido(rs.getString("apellido"));
				med.setDni(rs.getInt("dni"));
				med.setEmail(rs.getString("email"));
				listMedi.add(med);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("------------------ Listado de Medicos ------------------------------------");
		System.out.println("");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("  id  |   nombre    |   apellido    |      dni      |        email        ");
		System.out.println("-------------------------------------------------------------------------------");

		for (medico medico : listMedi) {
			System.out.println("  " + medico.getId() + "   	  " + medico.getNombre() + "          "
					+ medico.getApellido() + "         " + medico.getDni() + "    	    " + medico.getEmail());
		}

		System.out.println("----------------------------------------------------------");
		System.out.println("----------------------------------------------------------");

		System.out.println("Presione una tecla para continuar");
		String cont = in.next();
	}

	public void altaMedicos(Scanner in) {
		System.out.println("------------------ Alta de Medicos --------------------");
		System.out.println("");
		System.out.println("----------------------------------------------------------");
		System.out.println("Ingrese los datos del medico");
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
			int insOk = st.executeUpdate("INSERT INTO profesores (nombre, apellido, dni, email) VALUES ('" + nombre
					+ "','" + apellido + "'," + dni + ",'" + email + "') ");
			if (insOk == 1) {
				System.out.println("El medico se agrego correctamente");
			} else {
				System.err.println("ERROR: el medico no se pudo agregar, contactese con el administrador");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
