package net.estinet.gFeatures.API.SQLInterface;

import net.estinet.gFeatures.API.Logger.Debug;
import org.bukkit.Bukkit;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * gFeatures
 * https://github.com/EstiNet/gFeatures
 *
 *    Copyright 2019 EstiNet
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

public class MySQLUtil {
    public static String toURL(String port, String address, String table){
        return "jdbc:mysql://" + address + ":" + port + "/" + table + "?autoReconnect=true&useSSL=false";
    }
    public static void connect(String url, String user, String password, String query){
        java.sql.Connection con = null;
        java.sql.Statement st = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Debug.print(ex.getMessage());
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
                Debug.print(ex.getMessage());
            }
        }
    }
    public static List<String> connectReturn(String url, String user, String password, String query){
        List<String> array = new ArrayList<>();
        java.sql.Connection con = null;
        java.sql.Statement st = null;
        ResultSet rs = null;
        ResultSet result = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            result = st.executeQuery(query);
            result.beforeFirst();
            for(; !result.isLast();){
                result.next();
                array.add(result.getString(1));
                array.add(result.getString(2));
            }
            return array;
        } catch (SQLException ex) {
            ex.printStackTrace();
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
                ex.printStackTrace();
            }
        }
        return null;
    }

    /*
     * Check if a MySQL server is online.
     * Returns true if it is, and false if an exception occured.
     */
    public static boolean checkServerStatus(String url, String user, String password, boolean printStackTrace){
        java.sql.Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException ex) {
            if (printStackTrace) ex.printStackTrace();
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                if (printStackTrace) ex.printStackTrace();
            }
        }
    }
}
