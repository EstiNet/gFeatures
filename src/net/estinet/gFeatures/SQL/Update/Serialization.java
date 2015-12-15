package net.estinet.gFeatures.SQL.Update;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.API.Logger.Debug;
import net.estinet.gFeatures.SQL.Player.EstiPlayer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;

public class Serialization {
	  static final String WRITE_OBJECT_SQL = "INSERT INTO People(Name, Object) VALUES (?, ?)";

	  static final String READ_OBJECT_SQL = "SELECT Object FROM People WHERE id = ?";
	  static net.estinet.gFeatures.SQL.Update.Connection con = new net.estinet.gFeatures.SQL.Update.Connection();
	  public static long writeJavaObject(String name, Object object) throws Exception {
		  	
		    Connection conn = DriverManager.getConnection(con.toURL(Basic.getPort(), Basic.getAddress(), Basic.getTablename()), Basic.getUsername(), Basic.getPassword());
		    String className = object.getClass().getName();
		    PreparedStatement pstmt = conn.prepareStatement(WRITE_OBJECT_SQL, Statement.RETURN_GENERATED_KEYS);

		    pstmt.setString(1, name);
		    pstmt.setObject(2, object);
		    pstmt.executeUpdate();

		    ResultSet rs = pstmt.getGeneratedKeys();
		    int id = -1;
		    if (rs.next()) {
		      id = rs.getInt(1);
		    }

		    rs.close();
		    pstmt.close();
		    Debug.print("writeJavaObject: done serializing: " + className);
		    return id;
		  }

		  public static EstiPlayer readJavaObject(long id) throws Exception {
			Connection conn = DriverManager.getConnection(toURL(Basic.getPort(), Basic.getAddress(), Basic.getTablename()), Basic.getUsername(), Basic.getPassword());
		    PreparedStatement pstmt = conn.prepareStatement(READ_OBJECT_SQL);
		    pstmt.setLong(1, id);
		    ResultSet rs = pstmt.executeQuery();
		    //rs.next();
		    //Object object = (Object) rs.getObject(1);
		    //String className = object.getClass().getName();
		    			
		    ByteArrayOutputStream bos = new ByteArrayOutputStream() ;
		    byte[] buf = bos.toByteArray();
		    
			if (rs.next()) {
				buf = rs.getBytes(1);	
			}
			
			ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(buf));
	        EstiPlayer object = (EstiPlayer) in.readObject();
	        in.close();
		    
		    rs.close();
		    pstmt.close();
		    return object;
		  }
		  public static String toURL(String port, String address, String table){
				return "jdbc:mysql://" + address + ":" + port + "/" + table + "?" + "autoDeserialize=true";
			}
}
