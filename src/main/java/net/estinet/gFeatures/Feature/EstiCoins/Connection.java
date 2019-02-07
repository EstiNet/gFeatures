package net.estinet.gFeatures.Feature.EstiCoins;

import net.estinet.gFeatures.API.Logger.Debug;
import org.bukkit.Bukkit;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2018 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class Connection {
    private static ResultSet doSQLQuery(String url, String user, String password, String query, boolean printError, boolean wantReturn) {
        try {
            java.sql.Connection con = DriverManager.getConnection(url, user, password);
            java.sql.Statement st = con.createStatement();
            ResultSet rs = null;
            if (wantReturn) {
                rs = st.executeQuery(query);
            } else {
                st.executeUpdate(query);
            }
            if (rs != null) rs.close();
            st.close();
            con.close();
            return rs;
        } catch (SQLException ex) {
            if (!printError) Debug.print(ex.getMessage());
            else {
                Bukkit.getLogger().info("Aww... Unable to connect to MySQL Server " + url);
                Bukkit.getLogger().info("Make sure you check if the port is correct!");
                ex.printStackTrace();
            }
        }
        return null;
    }

    public static void connect(String url, String user, String password, String query) {
        doSQLQuery(url, user, password, query, false, false);
    }

    public static List<String> connectReturn(String url, String user, String password, String query) {
        ResultSet result = doSQLQuery(url, user, password, query, false, true);
        if (result == null) return null;
        List<String> array = new ArrayList<>();
        try {
            result.beforeFirst();
            while (!result.isLast()) {
                result.next();
                array.add(result.getString(1));
                array.add(result.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static String toURL(String port, String address, String table) {
        return "jdbc:mysql://" + address + ":" + port + "/" + table + "?autoReconnect=true&useSSL=false";
    }
}
