package ru.phoenixdnr;

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
    private int clientsCount = 0;
    private LinkedHashMap<Integer, Client> clients = new LinkedHashMap<>();

    //Functions
    private void printClientInfo(Integer id, Client client)
    {
        System.out.print(id + "\t|\t");
        client.showClients();
        System.out.print("\n");
    }

    public void processingClients()
    {
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_CLIENT_TABLE_HEAD);
        clients.forEach(this::printClientInfo);

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
            clientsCount++;
            clients.put(clientsCount, new Client(string[0], Integer.parseInt(string[1]),
                    Integer.parseInt(string[2]), string[3], string[4]));
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
            clients.replace(Integer.parseInt(input), new Client(string[0], Integer.parseInt(string[1]),
                    Integer.parseInt(string[2]), string[3], string[4]));
        }
    }

    private void deleteClient()
    {
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_DELETE_CLIENT);

        input = scan.nextLine();
        if (!input.equals(ConsoleSupporting.CANCEL))
        {
            clients.remove(Integer.parseInt(input));
        }
    }
}
