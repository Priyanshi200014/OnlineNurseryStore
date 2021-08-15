import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
public class ShopDetails extends HttpServlet
{
 
  public void service(HttpServletRequest req , HttpServletResponse res)throws IOException , ServletException
   {
        res.setContentType("text/html");	   
	    PrintWriter out = res.getWriter();
	    
		String plantName = "";
	   		
	 
	try
	{
		int flag=0;
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection c = DriverManager.getConnection("jdbc:mysql://localhost/OnlineNurseryStore","Priyanshi","root");
		 
				if(req.getParameter("Dianthus(White)")!=null)
				{
					plantName="Dianthus (White)";
				
				}
				else if(req.getParameter("Hydrangea-Macrophylla")!=null)
				{
					plantName="Hydrangea Macrophylla (Blue)";
				
				}
				else if(req.getParameter("Philodendron-Ceylon-Golden")!=null)
				{
					plantName="Philodendron Ceylon Golden";
				
				}else if(req.getParameter("Shevanti")!=null)
				{
					plantName="Shevanti";
				
				}else if(req.getParameter("Dianthus (Pink)")!=null)
				{
					plantName="Dianthus (Pink)";
				
				}else if(req.getParameter("Lemon grass")!=null)
				{
					plantName="Lemon Grass";
				
				}else if(req.getParameter("Money Plant")!=null)
				{
					plantName="Money Plant";
				
				}else if(req.getParameter("Dianthus (White-Pink)")!=null)
				{
					plantName="Dianthus (White Pink)";
				
				}else if(req.getParameter("Zinnia")!=null)
				{
					plantName="Zinnia";
				
				}else if(req.getParameter("Sansevieria-Snake")!=null)
				{
					plantName="Sansevieria trifasciata Hahnii, Snake ";
				
				}else if(req.getParameter("Syngonium-Pink")!=null)
				{
					plantName="Syngonium ( Pink )";
				
				}else if(req.getParameter("Euphorbia")!=null)
				{
					plantName="Euphorbia (Peach)";
				
				}
				
				PreparedStatement ps1 = c.prepareStatement("Select PlantName,Price,CommonName,Description from PlantsInformation where PlantName=?");
				    ps1.setString(1,plantName);
					ResultSet rs1=ps1.executeQuery();
					while(rs1.next())
					{
						out.println("<p class='plantNamedata'> "+rs1.getString(1)+" </p> <p class='pricedata'>"+rs1.getString(2)+" </p>  <p class='commonNamedata'> "+rs1.getString(3)+" </p> <p class='descriptiondata' >"+rs1.getString(4)+"</p>");
					}
					
					
					
						 RequestDispatcher dispatcher = req.getRequestDispatcher("Shop-details1.html");
				   dispatcher.include(req,res);

         	
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	   out.close();
	}	
	
	
}