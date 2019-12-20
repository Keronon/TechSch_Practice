package ru.phoenixdnr;

import java.util.LinkedHashMap;

import static ru.phoenixdnr.ConsoleSupporting.input;
import static ru.phoenixdnr.ConsoleSupporting.scan;

public class AppealProcessor
{
    private static AppealProcessor appealProcessor;
    private AppealProcessor() {}

    public static synchronized AppealProcessor getAppealProcessor()
    {
        if (appealProcessor == null) appealProcessor = new AppealProcessor();
        return appealProcessor;
    }

    //Variables

    //Functions
    public void testFunction()
    {

    }

    public void processingAppeals()
    {
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_APPEAL_TABLE_HEAD);

        System.out.print(ConsoleSupporting.OUTPUT_PROCESSING_APPEAL);

        input = scan.nextLine();
        if (input.equals(ConsoleSupporting.INSERT))
        {
            while (!input.equals(ConsoleSupporting.CANCEL))
            {
                insertAppeal();
            }
        }
        if (input.equals(ConsoleSupporting.UPDATE))
        {
            while (!input.equals(ConsoleSupporting.CANCEL))
            {
                updateAppeal();
            }
        }
        if (input.equals(ConsoleSupporting.DELETE))
        {
            while (!input.equals(ConsoleSupporting.CANCEL))
            {
                deleteAppeal();
            }
        }
    }

    private void insertAppeal()
    {
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_INSERT_APPEAL);

        input = scan.nextLine();
        if (!input.equals(ConsoleSupporting.CANCEL))
        {
            String[] string = input.split(" ");
        }
    }

    private void updateAppeal()
    {
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_UPDATE_ID_APPEAL);

        input = scan.nextLine();
        if (!input.equals(ConsoleSupporting.CANCEL))
        {
            System.out.print(ConsoleSupporting.OUTPUT_UPDATE_APPEAL);

            String info = scan.nextLine();
            String[] string = info.split(" ");
        }
    }

    private void deleteAppeal()
    {
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_DELETE_APPEAL);

        input = scan.nextLine();
        if (!input.equals(ConsoleSupporting.CANCEL))
        {
        }
    }
}
