package ru.phoenixdnr;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import static ru.phoenixdnr.ConsoleSupporting.input;
import static ru.phoenixdnr.ConsoleSupporting.scan;

public class DBaseProcessing implements IDataProcessing
{
    private static DBaseProcessing dBaseProcessing;
    private DBaseProcessing() {}

    public static synchronized DBaseProcessing getDBaseProcessing()
    {
        if (dBaseProcessing == null) dBaseProcessing = new DBaseProcessing();
        return dBaseProcessing;
    }

    //Variables
    private Integer counter = 0;

    private ArrayList header = new ArrayList();
    private Integer columns;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    //STRINGS
    //Queries
    private final String SELECT_TABLE_IS = "SELECT COUNT(*) FROM information_schema.tables WHERE table_name='";
    private final String SELECT_TABLE_NAME = "SELECT table_name FROM information_schema.tables WHERE table_schema='public' ORDER BY 1";
    private final String SELECT_COLUMN_NAME = "SELECT column_name FROM information_schema.columns WHERE table_name='";
    private final String SELECT_ALL_ROWS = "SELECT * FROM %s ORDER BY 1";
    private final String INSERT_ROW = "INSERT INTO %s (%s) VALUES (%s)";
    private final String UPDATE_ROW = "UPDATE %s SET %s WHERE id=%d";
    private final String DELETE_ROW = "DELETE FROM %s WHERE id=%s;";

    //Functions
    public void run()
    {
        setConnection();
    }

    public void end()
    {
        try
        {
            resultSet.close();
            statement.close();
            connection.commit();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public boolean isTable(String table)
    {
        try
        {
            resultSet = statement.executeQuery(this.SELECT_TABLE_IS + table + "'");
            resultSet.next();
            if (resultSet.getInt(1) == 1)
                return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return false;
    }

    public void printTableList()
    {
        try
        {
            resultSet = statement.executeQuery(this.SELECT_TABLE_NAME);
            counter = 0;
            while (resultSet.next()) {
                if (counter == 4) {
                    System.out.println();
                    counter = 0;
                }
                System.out.printf("%.30s\t", resultSet.getString(1).trim() + ConsoleSupporting.VOID);
                counter++;
            }
            System.out.println();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void printTableHead(String table)
    {
        try
        {
            columns = 0;
            header.clear();
            resultSet = statement.executeQuery(this.SELECT_COLUMN_NAME + table + "'");
            while (resultSet.next())
            {
                columns++;
                header.add(resultSet.getString(1).trim());
                System.out.printf("%.15s\t", resultSet.getString(1).trim() + ConsoleSupporting.VOID);
            }
            System.out.println();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void printTableRows(String table)
    {
        try
        {
            resultSet = statement.executeQuery(String.format(this.SELECT_ALL_ROWS, table));
            while (resultSet.next())
            {
                for (int i = 1; i <= columns; i++)
                {
                    System.out.printf("%.15s\t", String.valueOf(resultSet.getObject(i)).trim() + ConsoleSupporting.VOID);
                }
                System.out.println();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void insert(String table)
    {
        try
        {
            ConsoleSupporting.clearScreen();
            System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
            System.out.println(ConsoleSupporting.INSERTING_OF_ROW);

            String string = String.valueOf(header);
            System.out.println(string.substring(5, string.length() - 1));
            System.out.println();

            input = scan.nextLine();
            if (!input.equals(ConsoleSupporting.CANCEL))
            {
                statement.executeUpdate(String.format(this.INSERT_ROW, table, string.substring(5, string.length() -1), input));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void update(String table)
    {
        try
        {
            ConsoleSupporting.clearScreen();
            System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
            System.out.println(ConsoleSupporting.UPDATING_ID);

            input = scan.nextLine();
            if (!input.equals(ConsoleSupporting.CANCEL))
            {
                int id = Integer.parseInt(input);

                System.out.println(ConsoleSupporting.UPDATING_OF_ROW);
                printTableHead(table);
                System.out.println();
                input = scan.nextLine();

                String[] inputted = input.split(", ");
                AtomicReference<String> query = new AtomicReference<>();
                counter = 0;
                header.forEach((v) -> {query.set(query.get() + v + "='" + inputted[counter] + "', "); counter++;});
                String string = query.toString();
                statement.executeUpdate(String.format(this.UPDATE_ROW, table, string.substring(0, string.length() - 2), id));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void delete(String table)
    {
        try
        {
            ConsoleSupporting.clearScreen();
            System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
            System.out.println(ConsoleSupporting.DELETING_OF_ROW);

            input = scan.nextLine();
            if (!input.equals(ConsoleSupporting.CANCEL))
            {
                statement.executeUpdate(String.format(this.DELETE_ROW, table, input));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void setConnection()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.
                    getConnection("jdbc:postgresql://localhost:5432/PracticeDB", "A.T.A.N", "123");
            connection.setAutoCommit(false);
            System.out.println("-- Opened database successfully");

            statement = connection.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
