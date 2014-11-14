package es.mundo.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.mundo.modelo.Negocio;
import es.mundo.modelo.Pais;

/**
 * Servlet implementation class DarAltaServlet
 */
@WebServlet("/DarAlta")
public class DarAltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DarAltaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.recuperar los datos de la URL
		//2.adaptarlos si es necesario al tipo de datos del modelo(convertir de String a entero,etc)
		String nombre = request.getParameter("nombre");
		int habitantes = Integer.parseInt(request.getParameter("habitantes"));
		//3. pasarle los datos recuperados al negocio
		 Negocio negocio = new Negocio();
		int id= negocio.darAlta(nombre, habitantes);
		//consultar el pais
		Pais p=negocio.consultarUno(id);
		//meter el pais en el request...(setAttribute)
		request.setAttribute("pais", p);
		//redirigir a la vista individual
		RequestDispatcher rd;
		rd=request.getRequestDispatcher("vistaindividual.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
