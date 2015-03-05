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
            rs = st.executeQuery(query);

            if (rs.next()) {
                Bukkit.getLogger().info(rs.getString(1));
            }

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
	public boolean checkOnline(String url, String user, String password){
		java.sql.Connection con = null;
        java.sql.Statement st = null;
        ResultSet rs = null;

        //String url = "jdbc:mysql://localhost:3306/testdb";
        //String user = "testuser";
        //String password = "test623";

        try {
            con = DriverManager.getConnection(url, user, password);
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
        con = DriverManager.getConnection(url, user, password);
        st = con.createStatement();
        CheckConfig cc = new CheckConfig();
        rs = st.executeQuery("SHOW TABLES LIKE '"+ cc.getTablename() +"'");
        Bukkit.getLogger().info(rs.getString(1));
		return false;
	}
	public String toURL(String port, String address, String table){
		return "jdbc:mysql://" + address + ":" + port + "/" + table;
	}
}
