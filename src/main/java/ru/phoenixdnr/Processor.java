package ru.phoenixdnr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
    private Connection connection;

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
        int counter = 0;
        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet;

            ConsoleSupporting.clearScreen();
            System.out.println(ConsoleSupporting.ABOUT_TABLES);
            resultSet = statement.executeQuery("select table_name from information_schema.tables where table_schema='public' order by 1");
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
                ConsoleSupporting.clearScreen();

                int columns = 0;
                resultSet = statement.executeQuery("select column_name from information_schema.columns where table_name='" + input + "'");
                while (resultSet.next())
                {
                    columns++;
                    System.out.printf("%.15s\t", resultSet.getString(1).trim() + ConsoleSupporting.VOID);
                }
                System.out.println();

                resultSet = statement.executeQuery("select * from " + input + " order by 1");
                while (resultSet.next())
                {
                    for (int i = 1; i <= columns; i++)
                    {
                        System.out.printf("%.15s\t", String.valueOf(resultSet.getObject(i)).trim() + ConsoleSupporting.VOID);
                    }
                    System.out.println();
                }

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
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_INSERT_CLIENT);

        input = scan.nextLine();
        if (!input.equals(ConsoleSupporting.CANCEL))
        {
        }
    }

    private void update()
    {
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_UPDATE_ID_CLIENT);

        input = scan.nextLine();
        if (!input.equals(ConsoleSupporting.CANCEL))
        {
        }
    }

    private void delete()
    {
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_DELETE_CLIENT);

        input = scan.nextLine();
        if (!input.equals(ConsoleSupporting.CANCEL))
        {
        }
    }
}
