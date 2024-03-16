package de.ulrichcech.hae.infrastructure;

import org.h2.tools.Server;

import java.sql.SQLException;

public class H2DatabaseServer {

    public static void main(String[] args) {
        try {
            var baseDir = System.getenv("h2localDirectory");
            if (baseDir == null) {
                baseDir = System.getProperty("user.dir");
            }
            Server h2Server = Server.createTcpServer(
                    "-tcpPort", "9092",
                    "-tcpAllowOthers",
                    "-ifNotExists",
                    "-baseDir", baseDir).start();
            System.out.println("H2-Datenbankserver läuft auf: " + h2Server.getURL());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
