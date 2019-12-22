package ru.phoenixdnr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

import static ru.phoenixdnr.ConsoleSupporting.input;
import static ru.phoenixdnr.ConsoleSupporting.scan;

public class Processor
{
    private static Processor processor;
    private Processor() {}

    public static synchronized Processor getProcessor()
    {
        if (processor == null) processor = new Processor();
        return processor;
    }

    //Variables
    int counter = 0;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private String table;
    private ArrayList header = new ArrayList();
    private int columns;

    //Functions
    public void run()
    {
        ConsoleSupporting.clearScreen();
        System.out.println(ConsoleSupporting.RUN);
        input = scan.nextLine();
        while (!input.equals(ConsoleSupporting.QUIT))
        {
            setConnection();
            processing();
        }
    }

    private void setConnection()
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

    private void printTableHead()
    {
        try
        {
            columns = 0;
            header.clear();
            resultSet = statement.executeQuery(ConsoleSupporting.SELECT_COLUMN_NAME + table + "'");
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
            System.exit(0);
        }
    }

    private void printTableRows()
    {
        try
        {
            resultSet = statement.executeQuery(ConsoleSupporting.SELECT_ALL + table + ConsoleSupporting.SELECT_ORDER);
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
            System.exit(0);
        }
    }

    private void processing()
    {
        try
        {
            ConsoleSupporting.clearScreen();
            System.out.println(ConsoleSupporting.ABOUT_TABLES);
            resultSet = statement.executeQuery(ConsoleSupporting.SELECT_TABLE_NAME);
            counter = 0;
            while (resultSet.next())
            {
                if (counter == 4) {System.out.println(); counter = 0;}
                System.out.printf("%.30s\t", resultSet.getString(1).trim() + ConsoleSupporting.VOID);
                counter++;
            }
            System.out.println();

            System.out.print(ConsoleSupporting.SELECTION_OF_QUIT);
            System.out.println(ConsoleSupporting.SELECTION_OF_TABLE);

            input = scan.nextLine();
            if (!input.equals(ConsoleSupporting.QUIT))
            {
                table = input;
                ConsoleSupporting.clearScreen();
                printTableHead();
                printTableRows();

                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.SELECTION_OF_PROCESSING);
                input = scan.nextLine();
                if (input.equals(ConsoleSupporting.INSERT)) {
                    while (!input.equals(ConsoleSupporting.CANCEL)) {
                        insert();
                    }
                }
                if (input.equals(ConsoleSupporting.UPDATE)) {
                    while (!input.equals(ConsoleSupporting.CANCEL)) {
                        update();
                    }
                }
                if (input.equals(ConsoleSupporting.DELETE)) {
                    while (!input.equals(ConsoleSupporting.CANCEL)) {
                        delete();
                    }
                }
            }

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

    private void insert()
    {
        try
        {
            ConsoleSupporting.clearScreen();
            System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
            System.out.println(ConsoleSupporting.INSERTING_OF_ROW);
            printTableHead();

            input = scan.nextLine();
            if (!input.equals(ConsoleSupporting.CANCEL))
            {

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private void update()
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
                printTableHead();
                System.out.println();
                input = scan.nextLine();

                String[] inputted = input.split(", ");
                AtomicReference<String> query = new AtomicReference<>("UPDATE " + table + " SET ");
                counter = 0;
                header.forEach((v) -> {query.set(query.get() + v + "=\'" + inputted[counter] + "\', "); counter++;});
                String str = query.toString();
                str = str.substring(0, str.length() - 2) + " WHERE id=" + id;
                //System.out.println(str);
                statement.executeUpdate(str);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private void delete()
    {
        try
        {
            ConsoleSupporting.clearScreen();
            System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
            System.out.println(ConsoleSupporting.DELETING_OF_ROW);
            printTableHead();

            input = scan.nextLine();
            if (!input.equals(ConsoleSupporting.CANCEL))
            {

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
