package net.atariacity.coreapi.utils.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SQLFunctions {
    private SQL database;
    private SQLMethods methods;

    /**
     * Constructor for all SQL-Functions
     *
     * @param database Parameter for the Database you want to take the values from!
     */
    public SQLFunctions(SQL database) {
        this.database = database;
        methods = new SQLMethods(database);
    }

    /**
     * Method to set a Data into the MySQL
     *
     * @param table      Targeted Table-Name
     * @param column     Targeted Column
     * @param value      Value you want to set
     */
    public boolean setData(String table, String column, Object value) {
        final Boolean[] b = {false};
        methods.setData(table, column, value, new Callback() {
            @Override
            public void onSucces(Object done) {
                b[0] = (Boolean) done;
            }
        });
        return b[0];
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
    public int getInt(String table, String column, Object identifier, Object value) {
        final int[] i = {0};
        methods.getInt(table, column, identifier, value, new Callback() {
            @Override
            public void onSucces(Object done) {
                i[0] = (int) done;
            }
        });
        return i[0];
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
    public double getDouble(String table, String column, Object identifier, Object value) {
        final double[] d = {0};
        methods.getDouble(table, column, identifier, value, new Callback() {
            @Override
            public void onSucces(Object done) {
                d[0] = (double) done;
            }
        });
        return d[0];
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
    public String getString(String table, String column, Object identifier, Object value) {
        final String[] s = {""};
        methods.getString(table, column, identifier, value, new Callback() {
            @Override
            public void onSucces(Object done) {
                s[0] = (String) done;
            }
        });
        return s[0];
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
    public boolean getBoolean(String table, String column, Object identifier, Object value) {
        final boolean[] b = {false};
        methods.getBoolean(table, column, identifier, value, new Callback() {
            @Override
            public void onSucces(Object done) {
                b[0] = (boolean) done;
            }
        });
        return b[0];
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
    public Long getLong(String table, String column, Object identifier, Object value) {
        final long[] l = {Long.parseLong("")};
        methods.getLong(table, column, identifier, value, new Callback() {
            @Override
            public void onSucces(Object done) {
                l[0] = (long) done;
            }
        });
        return l[0];
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
    public Float getFloat(String table, String column, Object identifier, Object value) {
        final Float[] f = {Float.valueOf(0)};
        methods.getFloat(table, column, identifier, value, new Callback() {
            @Override
            public void onSucces(Object done) {
                f[0] = (Float) done;
            }
        });
        return f[0];
    }

    /**
     * Method to return all entries for the give Column in the given Table
     *
     * @param table  Targeted Table-Name
     * @param column Targeted Column
     * @return Returns the Column you are searching for
     */
    public List<String> getResultsString(String table, String column) {
        final List<String>[] list = new List[]{new ArrayList<>()};
        methods.getResultsString(table, column, new Callback() {
            @Override
            public void onSucces(Object done) {
                list[0] = (List<String>) done;
            }
        });
        return list[0];
    }

    /**
     * Method to return all entries for the give Column in the given Table
     *
     * @param table  Targeted Table-Name
     * @param column Targeted Column
     * @return Returns the Column you are searching for
     */
    public List<Integer> getResultsInteger(String table, String column) {
        final List<Integer>[] list = new List[]{new ArrayList<>()};

        methods.getResultsInteger(table, column, new Callback() {
            @Override
            public void onSucces(Object done) {
                list[0] = (List<Integer>) done;
            }
        });
        return list[0];
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
    public List<String> getList(String table, String column, Object identifier, Object value) {
        final List<String>[] list = new List[]{new LinkedList<>()};
        methods.getList(table, column, identifier, value, new Callback() {
            @Override
            public void onSucces(Object done) {
                list[0] = (List<String>) done;
            }
        });
        return list[0];
    }

    /**
     * Method to check if a Table contains content
     * @param table Targeted Table-Name
     * @return Returns true if the Table contains content
     */
    public boolean nullCheck(String table) {
        final boolean[] b = {false};
        methods.nullCheck(table, new Callback() {
            @Override
            public void onSucces(Object done) {
                b[0] = (boolean) done;
            }
        });
        return b[0];
    }

    /**
     * Method to get the highest value
     * @param table Targeted Table-Name
     * @param column Targeted column
     * @return Returns the highest object in this column
     */
    public Object getHighest(String table, String column) {
        final Object[] o = {new Object()};
        methods.getHighest(table, column, new Callback() {
            @Override
            public void onSucces(Object done) {
                o[0] = done;
            }
        });
        return o[0];
    }

    /**
     * Method to check if a Table contains content
     * @param table Targeted Table-Name
     * @param identifier Column you target for
     * @param value      Value you target for
     * @return Returns true if the Table contains content
     */
    public boolean contentExists(String table, Object identifier, Object value) {
        final boolean[] b = {false};
        methods.contentExists(table, identifier, value, new Callback() {
            @Override
            public void onSucces(Object done) {
                b[0] = (boolean) done;
            }
        });
        return b[0];
    }

    /**
     * Method to check if a Table exists
     * @param table
     * @return Returns true if the Table exists
     */
    public boolean tableExists(String table) {
        try {
            ResultSet rs = database.getDatabaseMetaData().getTables(null, null, table, null);
            return rs.next();
        } catch (SQLException var3) {
            var3.printStackTrace();
            return false;
        }
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
