package es.studium.practica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal
{
	public static void main(String[] args)
	{
		ListaDeLaCompra mercadona = new ListaDeLaCompra("Mercadona");
		ListaDeLaCompra carrefour = new ListaDeLaCompra();

		carrefour.setNombreLista("Carrefour");
		mercadona.agregarProductoAComprar(new ArticuloAComprar("Paquete de arroz de 1 Kg", 3, "Kg"));
		mercadona.agregarProductoAComprar(new ArticuloAComprar("Leche entera", 6, "L"));
		mercadona.agregarProductoAComprar(new ArticuloAComprar("Barra de pan", 4, "U"));
		carrefour.agregarProductoAComprar(new ArticuloAComprar("Huevos camperos", 12, "U"));
		carrefour.agregarProductoAComprar(new ArticuloAComprar("Aceite de oliva", 2, "L"));
		carrefour.agregarProductoAComprar(new ArticuloAComprar("Tomate frito", 5, "U"));

		System.out.println("ANTES DE ELIMINAR");

		mostrar(mercadona);
		mostrar(carrefour);

		mercadona.eliminarArticulo("Leche entera");
		carrefour.eliminarArticulo("Aceite de oliva");
		System.out.println("DESPUÉS DE ELIMINAR");

		mostrar(mercadona);
		mostrar(carrefour);
		guardar(mercadona);
		guardar(carrefour);

		System.out.println("RECUPERADAS DESDE FICHERO");
		mostrar(recuperar("Mercadona"));
		mostrar(recuperar("Carrefour"));
	}

	private static void guardar(ListaDeLaCompra lista)
	{
		try
		{
			FileWriter output = new FileWriter(lista.getNombreLista() + ".txt");
			for (ArticuloAComprar a : lista.getArticulos())
			{
				output.write(a.getDescripcion() + ";" + a.getCantidad() + ";" + a.getUnidad() + "\n");
			}
			output.close();
		}
		catch (IOException ex)
		{
			System.err.println("Se ha producido un ERROR al guardar: " + ex.getMessage());
		}
	}
	private static ListaDeLaCompra recuperar(String nombreLista)
	{
		ListaDeLaCompra lista = new ListaDeLaCompra(nombreLista);
		try
		{
			FileReader fr = new FileReader(nombreLista + ".txt");
			BufferedReader bf = new BufferedReader(fr);
			String linea = bf.readLine();
			while (linea != null)
			{
				String[] partes = linea.split(";");
				lista.agregarProductoAComprar(
				new ArticuloAComprar(partes[0], Integer.parseInt(partes[1]), partes[2]));
				linea = bf.readLine();
			}
			bf.close();
			fr.close();
		}
		catch (IOException ex)
		{
			System.err.println("Se ha producido un ERROR al recuperar: " + ex.getMessage());
		}
		return lista;
	}
	private static void mostrar(ListaDeLaCompra lista)
	{
		System.out.println("Lista: " + lista.getNombreLista());
		for (ArticuloAComprar a : lista.getArticulos())
		{
			System.out.println(" - " + a.getDescripcion() + ": " + a.getCantidad() + " " + a.getUnidad());
		}
		System.out.println();
	}
}