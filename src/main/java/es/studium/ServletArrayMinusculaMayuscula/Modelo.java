package es.studium.ServletArrayMinusculaMayuscula;

import java.util.ArrayList;

public class Modelo
{
	//Constructor.
	Modelo()
	{}

	//Método.
	ArrayList<String> cambiar(ArrayList<String> original)
	{
		ArrayList<String> resultado = new ArrayList<String>();

		for (String palabra : original)
		{
			resultado.add(palabra.toUpperCase());
		}

		return resultado;
	}
}
