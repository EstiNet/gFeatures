package net.estinet.gFeatures.SQL.Update;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.estinet.gFeatures.API.Logger.Debug;

import java.sql.Connection;

public class Serialization {
	  static final String WRITE_OBJECT_SQL = "INSERT INTO java_objects(name, object_value) VALUES (?, ?)";

	  static final String READ_OBJECT_SQL = "SELECT object_value FROM java_objects WHERE id = ?";
	  
	  public static long writeJavaObject(Connection conn, Object object) throws Exception {
		    String className = object.getClass().getName();
		    PreparedStatement pstmt = conn.prepareStatement(WRITE_OBJECT_SQL);

		    // set input parameters
		    pstmt.setString(1, className);
		    pstmt.setObject(2, object);
		    pstmt.executeUpdate();

		    // get the generated key for the id
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

		  public static Object readJavaObject(Connection conn, long id) throws Exception {
		    PreparedStatement pstmt = conn.prepareStatement(READ_OBJECT_SQL);
		    pstmt.setLong(1, id);
		    ResultSet rs = pstmt.executeQuery();
		    rs.next();
		    Object object = rs.getObject(1);
		    String className = object.getClass().getName();

		    rs.close();
		    pstmt.close();
		    Debug.print("readJavaObject: done de-serializing: " + className);
		    return object;
		  }
}
