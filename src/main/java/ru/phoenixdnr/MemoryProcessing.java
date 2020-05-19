package ru.phoenixdnr;

import ru.phoenixdnr.entities.Appeal;
import ru.phoenixdnr.entities.Client;
import ru.phoenixdnr.entities.User;

import java.util.ArrayList;

import static ru.phoenixdnr.ConsoleSupporting.input;
import static ru.phoenixdnr.ConsoleSupporting.scan;

public class MemoryProcessing implements IDataProcessing {
    private static MemoryProcessing memoryProcessing;

    private MemoryProcessing() {
    }

    public static synchronized MemoryProcessing getMemoryProcessing() {
        if (memoryProcessing == null) memoryProcessing = new MemoryProcessing();
        return memoryProcessing;
    }

    //Variables
    private Integer counter = 0;

    private static ArrayList<Appeal> appeals = new ArrayList<Appeal>();
    private static ArrayList<Client> clients = new ArrayList<Client>();
    private static ArrayList<User> users = new ArrayList<User>();

    //STRINGS
    //Outputs
    private final String TABLE_APPEALS =
            "id\tappealDate\tidDuty\tidProblem\tidClient" +
                    "\tproblemAnalysis\tdecisionDate\tdecision" +
                    "\tculprit\tdowntime\tcheckOut\tdecisionSuccess\n";

    private final String TABLE_CLIENTS =
            "id\tname\tidTechnicalInformation\tidCity\tadress\tcantactInformation\n";

    private final String TABLE_USERS =
            "id\tlastName\tfirstName\tlogin\tpassword\torganization" +
                    "\tcontactInformation\tidRole\tidStatus\n";

    //Functions
    public void run() {
        if (appeals.isEmpty())
            for (int i = 1; i <= 100; i++) {
                appeals.add(new Appeal(i));
                clients.add(new Client(i));
                users.add(new User(i));
            }
    }

    public void end() {

    }

    public boolean isTable(String table) {
        switch (table) {
            case "Appeals":
                return true;
            case "Clients":
                return true;
            case "Users":
                return true;
            default:
                return false;
        }
    }

    public String[] getTables() {
        return new String[]{"Appeals", "Clients", "Users"};
    }

    public void printTableHead(String table) {
        switch (table) {
            case "Appeals":
                System.out.println(TABLE_APPEALS);
                break;
            case "Clients":
                System.out.println(TABLE_CLIENTS);
                break;
            case "Users":
                System.out.println(TABLE_USERS);
                break;
        }
    }

    public void printTableRows(String table) {
        switch (table) {
            case "Appeals":
                for (int i = 0; i < appeals.size(); i++) {
                    System.out.println(appeals.get(i).toString());
                }
                break;
            case "Clients":
                for (int i = 0; i < clients.size(); i++) {
                    System.out.println(clients.get(i).toString());
                }
                break;
            case "Users":
                for (int i = 0; i < users.size(); i++) {
                    System.out.println(users.get(i).toString());
                }
                break;
        }
    }

    public void insert(String table) {
        switch (table) {
            case "Appeals": {
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.INSERTING_OF_ROW);
                System.out.println("(не указывая id)");

                input = scan.nextLine();
                if (!input.equals(ConsoleSupporting.CANCEL)) {
                    String[] inputted = input.split(", ");
                    appeals.add(new Appeal(
                            appeals.get(appeals.size() - 1).id + 1,
                            inputted[0],
                            Integer.valueOf(inputted[1]),
                            Integer.valueOf(inputted[2]),
                            Integer.valueOf(inputted[3]),
                            inputted[4],
                            inputted[5],
                            inputted[6],
                            inputted[7],
                            inputted[8],
                            Boolean.valueOf(inputted[9]),
                            Boolean.valueOf(inputted[10])
                    ));
                }
            }
            break;
            case "Clients": {
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.INSERTING_OF_ROW);
                System.out.println("(не указывая id)");

                input = scan.nextLine();
                if (!input.equals(ConsoleSupporting.CANCEL)) {
                    String[] inputted = input.split(", ");
                    clients.add(new Client(
                            clients.get(clients.size() - 1).id + 1,
                            inputted[0],
                            Integer.valueOf(inputted[1]),
                            Integer.valueOf(inputted[2]),
                            inputted[3],
                            inputted[4]
                    ));
                }
            }
            break;
            case "Users": {
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.INSERTING_OF_ROW);
                System.out.println("(не указывая id)");

                input = scan.nextLine();
                if (!input.equals(ConsoleSupporting.CANCEL)) {
                    String[] inputted = input.split(", ");
                    users.add(new User(
                            users.get(users.size() - 1).id + 1,
                            inputted[0],
                            inputted[1],
                            inputted[2],
                            inputted[3],
                            inputted[4],
                            inputted[5],
                            Integer.valueOf(inputted[6]),
                            Integer.valueOf(inputted[7])
                    ));
                }
            }
            break;
        }
    }

    public void update(String table) {
        switch (table) {
            case "Appeals": {
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                printTableRows(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.UPDATING_ID);

                input = scan.nextLine();
                if (!input.equals(ConsoleSupporting.CANCEL)) {
                    int index = 0;
                    int id = Integer.valueOf(input);
                    for (int i = 0; i < appeals.size(); i++) if (appeals.get(i).id == Integer.valueOf(input)) index = i;

                    System.out.println(ConsoleSupporting.UPDATING_OF_ROW);
                    System.out.println("(не указывая id)");
                    printTableHead(table);
                    System.out.println();

                    input = scan.nextLine();
                    String[] inputted = input.split(", ");
                    appeals.set(index, new Appeal(
                            id,
                            inputted[0],
                            Integer.valueOf(inputted[1]),
                            Integer.valueOf(inputted[2]),
                            Integer.valueOf(inputted[3]),
                            inputted[4],
                            inputted[5],
                            inputted[6],
                            inputted[7],
                            inputted[8],
                            Boolean.valueOf(inputted[9]),
                            Boolean.valueOf(inputted[10])
                    ));
                }
            }
            break;
            case "Clients": {
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                printTableRows(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.UPDATING_ID);

                input = scan.nextLine();
                if (!input.equals(ConsoleSupporting.CANCEL)) {
                    int index = 0;
                    int id = Integer.valueOf(input);
                    for (int i = 0; i < clients.size(); i++) if (clients.get(i).id == Integer.valueOf(input)) index = i;

                    System.out.println(ConsoleSupporting.UPDATING_OF_ROW);
                    System.out.println("(не указывая id)");
                    printTableHead(table);
                    System.out.println();

                    input = scan.nextLine();
                    String[] inputted = input.split(", ");
                    clients.set(index, new Client(
                            id,
                            inputted[0],
                            Integer.valueOf(inputted[1]),
                            Integer.valueOf(inputted[2]),
                            inputted[3],
                            inputted[4]
                    ));
                }
            }
            break;
            case "Users": {
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                printTableRows(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.UPDATING_ID);

                input = scan.nextLine();
                if (!input.equals(ConsoleSupporting.CANCEL)) {
                    int index = 0;
                    int id = Integer.valueOf(input);
                    for (int i = 0; i < users.size(); i++) if (users.get(i).id == Integer.valueOf(input)) index = i;

                    System.out.println(ConsoleSupporting.UPDATING_OF_ROW);
                    System.out.println("(не указывая id)");
                    printTableHead(table);
                    System.out.println();

                    input = scan.nextLine();
                    String[] inputted = input.split(", ");
                    users.set(index, new User(
                            id,
                            inputted[0],
                            inputted[1],
                            inputted[2],
                            inputted[3],
                            inputted[4],
                            inputted[5],
                            Integer.valueOf(inputted[6]),
                            Integer.valueOf(inputted[7])
                    ));
                }
            }
            break;
        }
    }

    public void delete(String table) {
        switch (table) {
            case "Appeals": {
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                printTableRows(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.DELETING_OF_ROW);

                input = scan.nextLine();
                if (!input.equals(ConsoleSupporting.CANCEL))
                {
                    int index = 0;
                    for (int i = 0; i < appeals.size(); i++) if (appeals.get(i).id == Integer.valueOf(input)) index = i;
                    appeals.remove(index);
                }
            }
            break;
            case "Clients": {
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                printTableRows(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.DELETING_OF_ROW);

                input = scan.nextLine();
                if (!input.equals(ConsoleSupporting.CANCEL))
                {
                    int index = 0;
                    for (int i = 0; i < clients.size(); i++) if (clients.get(i).id == Integer.valueOf(input)) index = i;
                    clients.remove(index);
                }
            }
            break;
            case "Users": {
                ConsoleSupporting.clearScreen();
                printTableHead(table);
                printTableRows(table);
                System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                System.out.println(ConsoleSupporting.DELETING_OF_ROW);

                input = scan.nextLine();
                if (!input.equals(ConsoleSupporting.CANCEL))
                {
                    int index = 0;
                    for (int i = 0; i < users.size(); i++) if (users.get(i).id == Integer.valueOf(input)) index = i;
                    users.remove(index);
                }
                break;
            }
        }
    }
}
