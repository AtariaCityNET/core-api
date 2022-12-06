package de.lukas.coreapi.utils.sql;

import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;

public class SQL {

    private String host, port, database,user,password;
    private Connection con;
    private Statement statement;
    private DatabaseMetaData databaseMetaData;
    private AutoReconnector autoReconnector;

    public SQL(String host, String port, String database, String user, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
        this.autoReconnector = new AutoReconnector(this);
    }

    public void connect() {
        if(!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://"+ host +":"+ port +"/"+ database +"?autoReconnect=true", user, password);
                System.out.println("[MySQL] Verbindung zu "+database+" aufgebaut!");

                statement = con.createStatement();
                databaseMetaData = con.getMetaData();
                autoReconnector.run();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void disconnect() {
        if(autoReconnector != null) {
            autoReconnector.stop();
        }
        if (isConnected()) {
            try {
                con.close();
                System.out.println("[MySQL] Verbindung zu "+database+" getrennt!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isConnected() {
        return (con != null);
    }

    public void update(String qry) {
        if (isConnected()) {
            try {con.createStatement().execute(qry);
            } catch (SQLException var2) {var2.printStackTrace();}
        }
    }

    public void createTable(final String tableName, final String... args) {
        if(!isConnected()) {
            return;
        }

        String arg = "";
        for(final String argument : args) {
            arg += arg.equals("") ? argument : ", " + argument;
        }

        try {
            con.prepareStatement("CREATE TABLE IF NOT EXISTS " + tableName + " (" + arg + ")").executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static class AutoReconnector {
        public final Timer timer = new Timer();
        public final SQL database;

        public AutoReconnector(final SQL database) {
            this.database = database;
        }

        public void run() {
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    try {
                        database.getStatement().execute("USE " + database.getDatabase());
                    } catch (SQLException exception) {
                        System.out.println("Error on handle reconnector: " + exception);
                    }
                }
            }, 0, 1000 * 60 * 10);
        }

        public void stop() {
            timer.cancel();
        }
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public Connection getConnection() {
        return con;
    }

    public Statement getStatement() {
        return statement;
    }

    public DatabaseMetaData getDatabaseMetaData() {
        return databaseMetaData;
    }

}
