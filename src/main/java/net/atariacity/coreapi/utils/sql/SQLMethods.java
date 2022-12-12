package net.atariacity.coreapi.utils.sql;

import net.atariacity.coreapi.CoreAPI;
import org.bukkit.Bukkit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SQLMethods {
    private SQL database;

    /**
     * Constructor for all SQL-Functions
     *
     * @param database Parameter for the Database you want to take the values from!
     */
    public SQLMethods(SQL database) {
        this.database = database;
    }

    /**
     * Method to set a Data into the MySQL
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param value      Value you want to set
     */
    public void setData(String table, String column, Object value, Callback callback) {
        Bukkit.getScheduler().runTaskAsynchronously(CoreAPI.getInstance(), new Runnable() {
            @Override
            public void run() {
                try(PreparedStatement statement = database.getConnection().prepareStatement("INSERT INTO" + table + " (" + column + ") VALUES (" + value + ")")) {
                    statement.executeQuery();

                    Bukkit.getScheduler().runTask(CoreAPI.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            callback.onSucces(true);
                        }
                    });
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Method to return an Integer value
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the Integer you are searching for or '0'
     */
    public void getInt(String table, String column, Object identifier, Object value, Callback callback) {
        Bukkit.getScheduler().runTaskAsynchronously(CoreAPI.getInstance(), new Runnable() {
            @Override
            public void run() {
                try(PreparedStatement statement = database.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'")) {
                    ResultSet rs = statement.executeQuery();

                    if (rs.next()) {
                        Bukkit.getScheduler().runTask(CoreAPI.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    callback.onSucces(rs.getInt(column));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Method to return a Double value
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the Double you are searching for or '0'
     */
    public void getDouble(String table, String column, Object identifier, Object value, Callback callback) {
        Bukkit.getScheduler().runTaskAsynchronously(CoreAPI.getInstance(), new Runnable() {
            @Override
            public void run() {
                try (PreparedStatement statement = database.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'")) {
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                        Bukkit.getScheduler().runTask(CoreAPI.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    callback.onSucces(rs.getDouble(column));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * Method to return a String value
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the String you are searching for or 'null'
     */
    public void getString(String table, String column, Object identifier, Object value, Callback callback) {
        Bukkit.getScheduler().runTaskAsynchronously(CoreAPI.getInstance(), new Runnable() {
            @Override
            public void run() {
                try (PreparedStatement statement = database.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'")) {
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                        Bukkit.getScheduler().runTask(CoreAPI.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    callback.onSucces(rs.getString(column));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Method to return a Boolean value
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the Boolean you are searching for or 'false'
     */
    public void getBoolean(String table, String column, Object identifier, Object value, Callback callback) {
        Bukkit.getScheduler().runTaskAsynchronously(CoreAPI.getInstance(), new Runnable() {
            @Override
            public void run() {
                try (PreparedStatement statement = database.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'")) {
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                        Bukkit.getScheduler().runTask(CoreAPI.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    callback.onSucces(rs.getBoolean(column));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Method to return a Long value
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the Long you are searching for or 'null'
     */
    public void getLong(String table, String column, Object identifier, Object value, Callback callback) {
        Bukkit.getScheduler().runTaskAsynchronously(CoreAPI.getInstance(), new Runnable() {
            @Override
            public void run() {
                try (PreparedStatement statement = database.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'")) {
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                        Bukkit.getScheduler().runTask(CoreAPI.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    callback.onSucces(rs.getLong(column));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Method to return a Float value
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the Float you are searching for or 'null'
     */
    public void getFloat(String table, String column, Object identifier, Object value, Callback callback) {
        Bukkit.getScheduler().runTaskAsynchronously(CoreAPI.getInstance(), new Runnable() {
            @Override
            public void run() {
                try (PreparedStatement statement = database.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'")) {
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                        Bukkit.getScheduler().runTask(CoreAPI.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    callback.onSucces(rs.getFloat(column));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Method to return all entries for the give Column in the given Table
     *
     * @param table  Targeted Table-Name
     * @param column Targeted Column
     * @return Returns the Column you are searching for
     */
    public void getResultsString(String table, String column, Callback callback) {
        List<String> list = new ArrayList<>();
        Bukkit.getScheduler().runTaskAsynchronously(CoreAPI.getInstance(), new Runnable() {
            @Override
            public void run() {
                try (PreparedStatement statement = database.getConnection().prepareStatement("SELECT " + column + " FROM " + table)) {
                    ResultSet rs = statement.executeQuery();
                    while (rs.next()) {
                        list.add(rs.getString(column));
                    }
                    Bukkit.getScheduler().runTask(CoreAPI.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            callback.onSucces(list);
                        }
                    });
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Method to return all entries for the give Column in the given Table
     *
     * @param table  Targeted Table-Name
     * @param column Targeted Column
     * @return Returns the Column you are searching for
     */
    public void getResultsInteger(String table, String column, Callback callback) {
        List<Integer> list = new ArrayList<>();

        Bukkit.getScheduler().runTaskAsynchronously(CoreAPI.getInstance(), new Runnable() {
            @Override
            public void run() {
                try (PreparedStatement statement = database.getConnection().prepareStatement("SELECT " + column + " FROM " + table)) {
                    ResultSet rs = statement.executeQuery();
                    while (rs.next()) {
                        list.add(rs.getInt(column));
                    }
                    Bukkit.getScheduler().runTask(CoreAPI.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            callback.onSucces(list);
                        }
                    });
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Method to return a List value from an Text Column
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns the List you are searching for
     */
    public void getList(String table, String column, Object identifier, Object value, Callback callback) {
        List<String> list = new LinkedList<>();
        Bukkit.getScheduler().runTaskAsynchronously(CoreAPI.getInstance(), new Runnable() {
            @Override
            public void run() {
                try (PreparedStatement statement = database.getConnection().prepareStatement("SELECT * FROM " + table + " WHERE " + identifier + " = '" + value + "'")) {
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                        String s = rs.getString(column);
                        if (s != null && !s.equalsIgnoreCase("[]")) {
                            String[] arrayOfString;
                            int i = (arrayOfString = s.replace("[", "").replace("]", "").split(", ")).length;

                            for (byte b = 0; b < i; ++b) {
                                String string = arrayOfString[b];
                                list.add(string.trim());
                            }
                        }
                        Bukkit.getScheduler().runTask(CoreAPI.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                callback.onSucces(list);
                            }
                        });
                    }
                } catch (SQLException var3) {
                    var3.printStackTrace();
                }
            }
        });
    }

    /**
     * Method to check if a Table contains content
     * @param table Targeted Table-Name
     * @return Returns true if the Table contains content
     */
    public void nullCheck(String table, Callback callback) {
        final boolean[] b = {false};
        Bukkit.getScheduler().runTaskAsynchronously(CoreAPI.getInstance(), new Runnable() {
            @Override
            public void run() {
                try (PreparedStatement statement = database.getConnection().prepareStatement("SELECT * From " + table)) {
                    ResultSet rs = statement.executeQuery();
                    if(rs.next()) {
                        b[0] = true;
                        Bukkit.getScheduler().runTask(CoreAPI.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                callback.onSucces(b);
                            }
                        });
                    } else {
                        b[0] = false;
                        Bukkit.getScheduler().runTask(CoreAPI.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                callback.onSucces(b);
                            }
                        });
                    }
                } catch (SQLException var3) {
                    var3.printStackTrace();
                }
            }
        });
    }

    /**
     * Method to get the highest value
     * @param table Targeted Table-Name
     * @param column Targeted column
     * @return Returns the highest object in this column
     */
    public void getHighest(String table, String column, Callback callback) {
        Object o = new Object();
        Bukkit.getScheduler().runTaskAsynchronously(CoreAPI.getInstance(), new Runnable() {
            @Override
            public void run() {
                try (PreparedStatement statement = database.getConnection().prepareStatement("SELECT MAX (" + column + ") FROM +" + table)) {
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                        Bukkit.getScheduler().runTask(CoreAPI.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    callback.onSucces(rs.getObject(column));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Method to check if a Table contains content
     * @param table Targeted Table-Name
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns true if the Table contains content
     */
    public void contentExists(String table, Object identifier, Object value, Callback callback) {
        final boolean[] b = {false};
        Bukkit.getScheduler().runTaskAsynchronously(CoreAPI.getInstance(), new Runnable() {
            @Override
            public void run() {
                try (PreparedStatement statement = database.getConnection().prepareStatement("SELECT * From " + table + " WHERE " + identifier + " = '" + value + "'")) {
                    ResultSet rs = statement.executeQuery();
                    if(rs.next()) {
                        b[0] = true;
                        Bukkit.getScheduler().runTask(CoreAPI.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                callback.onSucces(b);
                            }
                        });
                    } else {
                        b[0] = false;
                        Bukkit.getScheduler().runTask(CoreAPI.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                callback.onSucces(b);
                            }
                        });
                    }
                } catch (SQLException var3) {
                    var3.printStackTrace();
                }
            }
        });
    }

    /**
     * Method to get the Database
     *
     * @return Database
     */
    public SQL getDatabase() {
        return database;
    }

    /**
     * Method to set the Database
     *
     * @param database Database to set
     */
    public void setDatabase(SQL database) {
        this.database = database;
    }
}
