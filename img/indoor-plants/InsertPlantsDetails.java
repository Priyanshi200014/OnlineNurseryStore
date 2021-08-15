import java.sql.*;
import java.io.*;
class InsertPlantsDetails
{
	public static void main(String...s)
	{
	  try
	  {
		  Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/OnlineNurseryStore","Priyanshi","root");
		 
		  PreparedStatement ps = con.prepareStatement("insert into PlantsInformation values(?,?,?,?)");
		  ps.setString(1,"Euphorbia (Peach)");
		  
		  ps.setString(2,"550");
		  
		  ps.setString(3,"Euphorbia milii,crown of thorns,Christ plant,Christ thorn,spurge, Rosa Corona");
		  
		   ps.setString(4,"Bright-green leaves grow along its thick, thorny stems. Lower leaves naturally fall off as the plant ages. If your plant gets too tall and leggy, you can prune it back by half its size in spring. This will cause it to branch out.New stems will grow from below where the pruning cuts were made, making this succulent bushy and full.Euphorbia includes annuals, perennial herbs, shrubs and trees that have a corrosive and poisonous milky sap. Many are succulent and can either be thorny or unarmed. The deciduous leaves can either be alternate, opposite or in whorls. All spurges produce unisexual flowers.Its flowers are actually bracts that last for several weeks and are available in bright pink, red, white or yellow. Today's hybrids produce more -- even bigger -- flowers than ever before. Spring and summer are usually the best seasons for an abundance of blooms. Crown of Thorns flower dependably when they get enough light. They're easy to grow and drought-tolerant, prefering slightly dry, sandy soil.");
		   
		  int i=ps.executeUpdate();
		  System.out.println(i+" records affected");
		  con.close();
		  
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	
	}
}