package es.studium.ServletArrayMinusculaMayuscula;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletArray
 */
@WebServlet("/ServletArray")
public class ServletArray extends HttpServlet 
{
	Modelo modelo = new Modelo();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletArray() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Obtener el valor del parámetro "palabras".
		String palabras = request.getParameter("palabras");
		
        //Establecer el tipo de contenido como "text/html".
   	    response.setContentType("text/html");
   	    
   	    //Obtener el objeto PrintWriter.
   	    PrintWriter teclado = response.getWriter();
		
		//Controlar error: si escriben números en vez de palabras.
		if (!palabras.matches("^[a-zA-Z]+(?:, ?[a-zA-Z]+)*$")) 
		{
            response.getWriter().append("Error: solo debe contener palabras separadas por comas.");
            
    	    teclado.println("<br><br><a href='index.html'><button>Volver</button></a>");
    	    
    	    teclado.close();
            return;
        }

		ArrayList<String> original = new ArrayList<String>();
		String[] tablaPalabras = palabras.split(",");

		for (String palabra : tablaPalabras)
		{
			original.add(palabra);
		}

		//Nuevo ArrayList.
		ArrayList<String> resultado = modelo.cambiar(original);

		response.getWriter().append(resultado + "");
	    
	    teclado.println("<br><br><a href='index.html'><button>Volver</button></a>");
	    
	    teclado.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
