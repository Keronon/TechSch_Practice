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
    ClientProcessor clientProcessor = ClientProcessor.getClientProcessor();
    AppealProcessor appealProcessor = AppealProcessor.getAppealProcessor();

    //Functions
    public void run()
    {
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_RUN);
        input = scan.nextLine();
        while (!input.equals(ConsoleSupporting.QUIT))
        {
            processingApp();
        }
    }

    private void processingApp()
    {
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_QUIT);
        System.out.print(ConsoleSupporting.OUTPUT_CLIENT_OR_APPEAL);

        input = scan.nextLine();
        if (input.equals(ConsoleSupporting.CLIENT))
        {
           // while (!input.equals(ConsoleSupporting.CANCEL))
            {
                clientProcessor.testFunction();
            }
        }

        if (input.equals(ConsoleSupporting.APPEAL))
        {
            while (!input.equals(ConsoleSupporting.CANCEL))
            {
                appealProcessor.testFunction();
            }
        }
    }
}
