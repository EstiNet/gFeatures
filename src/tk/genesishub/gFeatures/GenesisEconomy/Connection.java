package tk.genesishub.gFeatures.GenesisEconomy;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Version;

import org.bukkit.Bukkit;

public class Connection {
	public void Connect(String url, String user, String password, String query){
		java.sql.Connection con = null;
        java.sql.Statement st = null;
        ResultSet rs = null;
        //String url = "jdbc:mysql://localhost:3306/testdb";
        //String user = "testuser";
        //String password = "test623";
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
	}
	public String ConnectReturn(String url, String user, String password, String query){
		java.sql.Connection con = null;
        java.sql.Statement st = null;
        ResultSet rs = null;
        ResultSet result = null;
        //String url = "jdbc:mysql://localhost:3306/testdb";
        //String user = "testuser";
        //String password = "test623";
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            result = st.executeQuery(query);
            result.beforeFirst();
            result.next();
            return result.getString(1);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
		return null;
	}
	public boolean checkOnline(String url, String user, String password){
		java.sql.Connection con = null;
        java.sql.Statement st = null;
        ResultSet rs = null;
        //String url = "jdbc:mysql://localhost:3306/testdb";
        //String user = "testuser";
        //String password = "test623";
        Bukkit.getLogger().info("Establishing Connection to " + url);
        try {
            con = DriverManager.getConnection(url, user, password);
            Bukkit.getLogger().info("Connected!");
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            ex.printStackTrace();
            Bukkit.getLogger().info("Aww... Unable to connect to MySQL Server " + url);
            Bukkit.getLogger().info("Make sure you check if the port is correct!");

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
                ex.printStackTrace();
                Bukkit.getLogger().info("Aww... Unable to connect to MySQL Server " + url);
                Bukkit.getLogger().info("Make sure you check if the port is correct!");
            }
        }
		return false;
	}
	public boolean tableExists(String url, String user, String password) throws SQLException{
		java.sql.Connection con = null;
        java.sql.Statement st = null;
        ResultSet rs = null;
        String url1 = "jdbc:mysql://localhost:3306/";
        con = DriverManager.getConnection(url1, user, password);
        st = con.createStatement();
        CheckConfig cc = new CheckConfig();
       // rs = st.executeQuery("SHOW TABLES LIKE 'Money'");
        //Bukkit.getLogger().info(rs.getString(1));
		return false;
	}
	public String toURL(String port, String address, String table){
		return "jdbc:mysql://" + address + ":" + port + "/" + table;
	}
}
