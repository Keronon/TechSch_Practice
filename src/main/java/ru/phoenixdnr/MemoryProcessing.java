package ru.phoenixdnr;

import ru.phoenixdnr.entities.Appeal;
import ru.phoenixdnr.entities.Client;
import ru.phoenixdnr.entities.User;

import java.util.ArrayList;

import static ru.phoenixdnr.ConsoleSupporting.input;
import static ru.phoenixdnr.ConsoleSupporting.scan;

public class MemoryProcessing implements IDataProcessing
{
    private static MemoryProcessing memoryProcessing;
    private MemoryProcessing() {}

    public static synchronized MemoryProcessing getMemoryProcessing()
    {
        if (memoryProcessing == null) memoryProcessing = new MemoryProcessing();
        return memoryProcessing;
    }

    //Variables
    private Integer counter = 0;

    private ArrayList<Appeal> appeals = new ArrayList<Appeal>();
    private ArrayList<Client> clients = new ArrayList<Client> ();
    private ArrayList<User> users = new ArrayList<User>();
    private static Appeal a = new Appeal();
    private static Client c = new Client();
    private static User u = new User();



    //Queries
    private final String TABLE_APPEALS = "id\tappealDate\tidDuty\tidProblem\tidClient" +
            "\tproblemAnalysis\tdecisionDate\tdecision" +
            "\tculprit\tdowntime\tcheckOut\tdecisionSuccess";
    private final String TABLE_CLIENTS = "id\tname\tidTechnicalInformation\tidCity\tadress\tcantactInformation";
    private final String TABLE_USERS = "id\tlastName\tfirstName\tlogin\tpassword\torganization" +
            "\tcontactInformation\tidRole\tidStatus";


    //Functions
    public void run()
    {
        for (int i = 1; i <= 100; i++ )
        {
            a.id = i;
            a.appealDate = "20.05.2020";
            a.checkOut = false;
            a.culprit = "hz";
            a.decision = "hz2";
            a.decisionDate = "25.05.2020";
            a.decisionSuccess = true;
            a.downtime = "04.07.2021";
            a.idClient = (int)Math.random()*55;
            a.idDuty = 1;
            a.idProblem = 1;
            a.problemAnalysis = "otsutstvie";

            appeals.add(a);

            c.id = i;
            c.name = "ROG";
            c.idTechnicalInformation = 1;
            c.idCity = 1;
            c.adress = "Abai31";
            c.cantactInformation = "0713350244";

            clients.add(c);

            u.id = i;
            u.lastName = "Merser";
            u.firstName = "Joh";
            u.login = "joh1333Merser";
            u.password = "0000";
            u.organization = "hz";
            u.contactInformation = "hz2";
            u.idRole = 1;
            u.idStatus = 3;

            users.add(u);
        }
    }

    public void end()
    {

    }

    public boolean isTable(String table)
    {
        switch (table)
        {
            case "Appeals" : return true;
            case "Clients" : return true;
            case "Users" : return true;
            default : return false;
        }
    }

    public String[] getTables()
    {
        return new String[] {"Appeals", "Clients", "Users"};
    }

    public void printTableHead(String table)
    {
        switch (table)
        {
            case "Appeals" : System.out.println(TABLE_APPEALS);
                break;
            case "Clients" : System.out.println(TABLE_CLIENTS);
                break;
            case "Users" : System.out.println(TABLE_USERS);
                break;
        }
    }

    public void printTableRows(String table)
    {
        switch (table)
        {

            case "Appeals" : for (int i = 0; i<100; i++)
            {
                a = appeals.get(i);

                System.out.println(
                a.id + " " +
                a.appealDate + " " +
                a.checkOut + " " +
                a.culprit + " " +
                a.decision + " " +
                a.decisionDate + " " +
                a.decisionSuccess + " " +
                a.downtime + " " +
                a.idClient + " " +
                a.idDuty + " " +
                a.idProblem+ " " +
                a.problemAnalysis);
                //System.out.println(i);
                //System.out.println(a.id);
            };
                break;
            case "Clients" : for (int i = 0; i<100; i++)
            {
                System.out.println(
                c.id + " " +
                c.name + " " +
                c.idTechnicalInformation + " " +
                c.idCity + " " +
                c.adress + " " +
                c.cantactInformation);
            }
                break;
            case "Users" : for (int i = 0; i<100; i++)
            {
                System.out.println(
                u.id + " " +
                u.lastName + " " +
                u.firstName + " " +
                u.login + " " +
                u.password + " " +
                u.organization + " " +
                u.contactInformation+ " " +
                u.idRole + " " +
                u.idStatus);
            }
                break;

        }
    }

    public void insert(String table)
    {
        switch (table)
        {
            case "Appeals" :
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                printTableRows(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.INSERTING_OF_ROW);


                    a.id = appeals.get(appeals.size()-1).id+1;
            System.out.println("Введите appealDate");
                input = scan.nextLine();
                    a.appealDate = input;
            System.out.println("Введите checkOut");
                input = scan.nextLine();
                    a.checkOut = Boolean.valueOf(input);
            System.out.println("Введите culprit");
                input = scan.nextLine();
                    a.culprit = input;
            System.out.println("Введите decision");
                input = scan.nextLine();
                    a.decision = input;
            System.out.println("Введите decisionDate");
                input = scan.nextLine();
                    a.decisionDate = input;
            System.out.println("Введите decisionSuccess");
                input = scan.nextLine();
                    a.decisionSuccess = Boolean.valueOf(input);
            System.out.println("Введите downtime");
                input = scan.nextLine();
                    a.downtime = input;
            System.out.println("Введите idClient");
                input = scan.nextLine();
                    a.idClient = Integer.valueOf(input);
            System.out.println("Введите idDuty");
                input = scan.nextLine();
                    a.idDuty = Integer.valueOf(input);
            System.out.println("Введите idProblem");
                input = scan.nextLine();
                    a.idProblem =Integer.valueOf(input);
            System.out.println("Введите problemAnalysis");
                input = scan.nextLine();
                    a.problemAnalysis = input;

                    appeals.add(a);
                    break;
            case "Clients" :
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                printTableRows(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.INSERTING_OF_ROW);

                c.id = clients.get(clients.size()-1).id+1;

                System.out.println("Введите id");
                    input = scan.nextLine();
                        c.id = Integer.valueOf(input);
                System.out.println("Введите name");
                    input = scan.nextLine();
                        c.name = input;
                System.out.println("Введите idTechnicalInformation");
                    input = scan.nextLine();
                        c.idTechnicalInformation = Integer.valueOf(input);
                System.out.println("Введите idCity");
                    input = scan.nextLine();
                        c.idCity = Integer.valueOf(input);
                System.out.println("Введите adress");
                    input = scan.nextLine();
                        c.adress = input;
                System.out.println("Введите cantactInformation");
                    input = scan.nextLine();
                        c.cantactInformation = input;


                clients.add(c);
                break;
            case "Users" :
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                printTableRows(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.INSERTING_OF_ROW);

                u.id = users.get(users.size()-1).id+1;

                System.out.println("Введите id");
                    input = scan.nextLine();
                        u.id = Integer.valueOf(input);
                System.out.println("Введите lastName");
                    input = scan.nextLine();
                        u.lastName = input;
                System.out.println("Введите firstName");
                    input = scan.nextLine();
                        u.firstName = input;
                System.out.println("Введите login");
                    input = scan.nextLine();
                        u.login = input;
                System.out.println("Введите password");
                    input = scan.nextLine();
                        u.password = input;
                System.out.println("Введите organization");
                    input = scan.nextLine();
                        u.organization = input;
                System.out.println("Введите contactInformation");
                    input = scan.nextLine();
                        u.contactInformation = input;
                System.out.println("Введите idRole");
                    input = scan.nextLine();
                        u.idRole = Integer.valueOf(input);
                System.out.println("Введите idStatus");
                    input = scan.nextLine();
                        u.idStatus = Integer.valueOf(input);

                users.add(u);
                break;
        }
    }

    public void update(String table)
    {
        switch (table)
        {
            case "Appeals" :
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                printTableRows(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.UPDATING_ID);

                input = scan.nextLine();
                int indexA =  Integer.valueOf(input);

                a.id = Integer.valueOf(input);
                System.out.println("Введите appealDate");
                input = scan.nextLine();
                a.appealDate = input;
                System.out.println("Введите checkOut");
                input = scan.nextLine();
                a.checkOut = Boolean.valueOf(input);
                System.out.println("Введите culprit");
                input = scan.nextLine();
                a.culprit = input;
                System.out.println("Введите decision");
                input = scan.nextLine();
                a.decision = input;
                System.out.println("Введите decisionDate");
                input = scan.nextLine();
                a.decisionDate = input;
                System.out.println("Введите decisionSuccess");
                input = scan.nextLine();
                a.decisionSuccess = Boolean.valueOf(input);
                System.out.println("Введите downtime");
                input = scan.nextLine();
                a.downtime = input;
                System.out.println("Введите idClient");
                input = scan.nextLine();
                a.idClient = Integer.valueOf(input);
                System.out.println("Введите idDuty");
                input = scan.nextLine();
                a.idDuty = Integer.valueOf(input);
                System.out.println("Введите idProblem");
                input = scan.nextLine();
                a.idProblem =Integer.valueOf(input);
                System.out.println("Введите problemAnalysis");
                input = scan.nextLine();
                a.problemAnalysis = input;

                appeals.set(indexA, a);
                break;
            case "Clients" :
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                printTableRows(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.INSERTING_OF_ROW);

                input = scan.nextLine();
                int indexC =  Integer.valueOf(input);

                c.id = clients.get(clients.size()-1).id+1;

                c.id = Integer.valueOf(input);
                System.out.println("Введите name");
                input = scan.nextLine();
                c.name = input;
                System.out.println("Введите idTechnicalInformation");
                input = scan.nextLine();
                c.idTechnicalInformation = Integer.valueOf(input);
                System.out.println("Введите idCity");
                input = scan.nextLine();
                c.idCity = Integer.valueOf(input);
                System.out.println("Введите adress");
                input = scan.nextLine();
                c.adress = input;
                System.out.println("Введите cantactInformation");
                input = scan.nextLine();
                c.cantactInformation = input;

                clients.add(c);

                clients.set(indexC, c);
                break;
            case "Users" :
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                printTableRows(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.INSERTING_OF_ROW);

                input = scan.nextLine();
                int indexU =  Integer.valueOf(input);

                u.id = users.get(users.size()-1).id+1;

                u.id = Integer.valueOf(input);
                System.out.println("Введите lastName");
                input = scan.nextLine();
                u.lastName = input;
                System.out.println("Введите firstName");
                input = scan.nextLine();
                u.firstName = input;
                System.out.println("Введите login");
                input = scan.nextLine();
                u.login = input;
                System.out.println("Введите password");
                input = scan.nextLine();
                u.password = input;
                System.out.println("Введите organization");
                input = scan.nextLine();
                u.organization = input;
                System.out.println("Введите contactInformation");
                input = scan.nextLine();
                u.contactInformation = input;
                System.out.println("Введите idRole");
                input = scan.nextLine();
                u.idRole = Integer.valueOf(input);
                System.out.println("Введите idStatus");
                input = scan.nextLine();
                u.idStatus = Integer.valueOf(input);

                users.add(u);

                users.set(indexU, u);
                break;
        }
    }

    public void delete(String table)
    {
        switch (table)
        {
            case "Appeals" :
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                printTableRows(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.DELETING_OF_ROW);

                input = scan.nextLine();
                appeals.remove(Integer.valueOf(input));
                break;
            case "Clients" :
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                printTableRows(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.DELETING_OF_ROW);

                input = scan.nextLine();
                clients.remove(Integer.valueOf(input));
                break;
            case "Users" :
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                printTableRows(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.DELETING_OF_ROW);

                input = scan.nextLine();
                users.remove(Integer.valueOf(input));
                break;
        }
    }
}
