package ru.phoenixdnr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;

import static ru.phoenixdnr.ConsoleSupporting.input;
import static ru.phoenixdnr.ConsoleSupporting.scan;

public class ClientProcessor
{

    private static ClientProcessor clientProcessor;
    private ClientProcessor() {}

    public static synchronized ClientProcessor getClientProcessor()
    {
        if (clientProcessor == null) clientProcessor = new ClientProcessor();
        return clientProcessor;
    }

    //Variables

    //Functions
    public void testFunction() {
        Connection c;
        Statement stmt;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/PracticeDB", "A.T.A.N", "123");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");

            //--------------- SELECT DATA ------------------
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from clients order by id");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int id_t_i = rs.getInt("id_technical_information");
                int id_city = rs.getInt("id_city");
                String adress = rs.getString("adress");
                String contact_information = rs.getString("contact_information");
                System.out.println(String.format("id=%s name=%s id_technical_information=%s id_city=%s adress=%s contact_information=%s",
                        id, name, id_t_i, id_city, adress, contact_information));
            }
            rs.close();
            stmt.close();
            c.commit();
            System.out.println("-- Operation SELECT done successfully");


            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("-- All Operations done successfully");
    }

    public void processingClients()
    {
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_CLIENT_TABLE_HEAD);

        System.out.print(ConsoleSupporting.OUTPUT_PROCESSING_CLIENT);

        input = scan.nextLine();
        if (input.equals(ConsoleSupporting.INSERT))
        {
            while (!input.equals(ConsoleSupporting.CANCEL))
            {
                insertClient();
            }
        }
        if (input.equals(ConsoleSupporting.UPDATE))
        {
            while (!input.equals(ConsoleSupporting.CANCEL))
            {
                updateClient();
            }
        }
        if (input.equals(ConsoleSupporting.DELETE))
        {
            while (!input.equals(ConsoleSupporting.CANCEL))
            {
                deleteClient();
            }
        }
    }

    private void insertClient()
    {
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_INSERT_CLIENT);

        input = scan.nextLine();
        if (!input.equals(ConsoleSupporting.CANCEL))
        {
            String[] string = input.split(" ");
        }
    }

    private void updateClient()
    {
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_UPDATE_ID_CLIENT);

        input = scan.nextLine();
        if (!input.equals(ConsoleSupporting.CANCEL))
        {
            System.out.print(ConsoleSupporting.OUTPUT_UPDATE_CLIENT);

            String info = scan.nextLine();
            String[] string = info.split(" ");
        }
    }

    private void deleteClient()
    {
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_DELETE_CLIENT);

        input = scan.nextLine();
        if (!input.equals(ConsoleSupporting.CANCEL))
        {
        }
    }
}
