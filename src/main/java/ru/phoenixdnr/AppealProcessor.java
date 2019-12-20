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
    private int appealsCount = 0;
    private LinkedHashMap<Integer, Appeal> appeals = new LinkedHashMap<>();

    //Functions
    private void printAppealInfo(Integer id, Appeal appeal)
    {
        System.out.print(id + "\t|\t");
        appeal.showAppeals();
        System.out.print("\n");
    }

    public void processingAppeals()
    {
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_APPEAL_TABLE_HEAD);
        appeals.forEach(this::printAppealInfo);

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
            appealsCount++;
            appeals.put(appealsCount, new Appeal(string[0], Integer.parseInt(string[1]),
                                                 Integer.parseInt(string[2]), Integer.parseInt(string[3]),
                                                 string[4], string[5], string[6], string[7], string[8],
                                                 string[9].equals("1"), string[10].equals("1")));
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
            appeals.put(appealsCount, new Appeal(string[0], Integer.parseInt(string[1]),
                                                 Integer.parseInt(string[2]), Integer.parseInt(string[3]),
                                                 string[4], string[5], string[6], string[7], string[8],
                                                 string[9].equals("1"), string[10].equals("1")));
        }
    }

    private void deleteAppeal()
    {
        ConsoleSupporting.clearScreen();
        System.out.print(ConsoleSupporting.OUTPUT_DELETE_APPEAL);

        input = scan.nextLine();
        if (!input.equals(ConsoleSupporting.CANCEL))
        {
            appeals.remove(Integer.parseInt(input));
        }
    }
}
