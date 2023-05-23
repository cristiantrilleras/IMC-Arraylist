import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ej1 {
	
	String nombre="";
	double imc,peso,talla;
	ArrayList<String> nombresList;
	ArrayList<String> resultadosList;
	
	public Ej1() {
		nombresList=new ArrayList<String>();
		resultadosList=new ArrayList<String>();
		iniciar();
	}
		
		
	public void iniciar() {
		System.out.println("CALCULO DE IMC");

		int opcion;
		do {
			opcion = mostrarMenu();
			switch (opcion) {
				case 1:
					ingresarDatos();
					calcularIMC();
					break;
				case 2:
					imprimirListas();
					break;
				case 3:
					consultarPorNombre();
					break;
				case 4:
					System.out.println("¡Hasta luego!");
					break;
				default:
					System.out.println("Opción inválida. Por favor, selecciona una opción válida del menú.");
					break;
			}
		} while (opcion != 4);
	}
	
	private int mostrarMenu() {
		String mensaje = "Seleccione una opción:\n" +
						 "1. Ingresar datos\n" +
						 "2. Imprimir listas\n" +
						 "3. Consultar por nombre\n" +
						 "4. Salir";
		return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
	}
	private void consultarPorNombre() {
		
		String nombreConsulta=JOptionPane.showInputDialog("Ingrese el nombre a buscar");

		if (nombresList.contains(nombreConsulta)) {
			for (int i = 0; i < nombresList.size(); i++) {
				if (nombresList.get(i).equalsIgnoreCase(nombreConsulta)) {
					System.out.println("Si existe "+nombreConsulta+","
							+ " tiene "+resultadosList.get(i));
				}
			}	
			
			
			System.out.println("Imprime la consulta usando for each");
			for (String elemento : nombresList) {
				int pos=nombresList.indexOf(elemento);
				if (nombresList.get(pos).equalsIgnoreCase(nombreConsulta)) {
					System.out.println(elemento+", resultado= "+resultadosList.get(pos));
					
				}
			}
			
			
		}else {
			System.out.println("NO existe");
		}
	
	}

	public void imprimirListas() {
		System.out.println("********RESULTADOS**********");
		for (int i = 0; i < nombresList.size(); i++) {
			System.out.println(nombresList.get(i)+", resultado: "+resultadosList.get(i));
		}
		System.out.println("*****************************");
	}

	private void ingresarDatos() {
		nombre=JOptionPane.showInputDialog("Ingrese el nombre");
		nombresList.add(nombre);
		imc=0;
		peso=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso"));
		talla=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la talla"));
		
	}
	
	private void calcularIMC() {
		imc=peso/(talla*talla);
		System.out.println("El IMC es: "+imc);
		
		String result="";
		
		if (imc<18) {
			result=("Anorexia");
		}else if (imc>=18 && imc <20) {
			result=("Delgadez");
		}else if (imc>=20 && imc <27) {
			result=("Normalidad");
		}else if (imc>=27 && imc <30) {
			result=("Obesidad 1");
		}else if (imc>=30 && imc <35) {
			result=("Obesidad 2");
		}else if (imc>=35 && imc <40) {
			result=("Obesidad 3");
		}else if (imc>=40) {
			result=("Obesidad Morbida");
		}

		resultadosList.add(result);
		System.out.println("El Resultado es: "+result);
	}



	
}