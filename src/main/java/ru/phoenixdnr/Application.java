package ru.phoenixdnr;

import static ru.phoenixdnr.ConsoleSupporting.input;
import static ru.phoenixdnr.ConsoleSupporting.scan;

public class Application
{
    private static Application application;
    private Application() {}

    public static synchronized Application getApplication()
    {
        if (application == null) application = new Application();
        return application;
    }

    //Variables
    private IDataProcessing processing = MemoryProcessing.getMemoryProcessing();

    private String table;

    //STRINGS
    //Inputs
    private final String MEMORY = "Memory";
    private final String DBASE = "Data_base";

    //Outputs
    private final String RUN = "\nВведите \"RUN\" для начала работы\n";
    private final String SELECTION_OF_QUIT = "\nВведите \"q\" чтобы закрыть приложение\n";
    private final String SELECTION_OF_PROCECCING_TYPE = "\nВыберите хранилище обрабатываемых данных:\n\t\tMemory\t\t\tData_base\n\nили";

    //Functions
    public void run()
    {
        ConsoleSupporting.clearScreen();
        System.out.println(this.RUN);
        input = scan.nextLine();

        while (!input.equals(this.MEMORY) && !input.equals(this.DBASE) && !input.equals(ConsoleSupporting.QUIT))
        {
            ConsoleSupporting.clearScreen();
            System.out.print(this.SELECTION_OF_PROCECCING_TYPE);
            System.out.print(this.SELECTION_OF_QUIT);
            System.out.print("\n");
            input = scan.nextLine();
            if (input.equals(this.DBASE))
                this.processing = DBaseProcessing.getDBaseProcessing();
        }
        while (!input.equals(ConsoleSupporting.QUIT))
        {
            ConsoleSupporting.clearScreen();
            processing.run();

            System.out.println(ConsoleSupporting.ABOUT_TABLES);
            this.processing.printTableList();

            System.out.print(this.SELECTION_OF_QUIT);
            System.out.println(ConsoleSupporting.SELECTION_OF_TABLE);
            input = scan.nextLine();

            if (!input.equals(ConsoleSupporting.QUIT))
            {
                this.table = input;
                if (processing.isTable(this.table))
                {
                    ConsoleSupporting.clearScreen();
                    processing.printTableHead(this.table);
                    processing.printTableRows(this.table);

                    System.out.print(ConsoleSupporting.SELECTION_OF_CANCELLING);
                    System.out.println(ConsoleSupporting.SELECTION_OF_PROCESSING);
                    input = scan.nextLine();

                    if (input.equals(ConsoleSupporting.INSERT)) {
                        while (!input.equals(ConsoleSupporting.CANCEL)) {
                            processing.insert(this.table);
                        }
                    }
                    if (input.equals(ConsoleSupporting.UPDATE)) {
                        while (!input.equals(ConsoleSupporting.CANCEL)) {
                            processing.update(this.table);
                        }
                    }
                    if (input.equals(ConsoleSupporting.DELETE)) {
                        while (!input.equals(ConsoleSupporting.CANCEL)) {
                            processing.delete(this.table);
                        }
                    }
                }
            }
            processing.end();
        }
        ConsoleSupporting.clearScreen();
    }
}
