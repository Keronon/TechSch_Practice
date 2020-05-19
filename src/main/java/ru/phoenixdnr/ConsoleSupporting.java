package ru.phoenixdnr;

import java.util.Scanner;

public class ConsoleSupporting
{
    private ConsoleSupporting() {}

    //Variables
    protected static String input;
    protected static Scanner scan = new Scanner(System.in);

    //STRINGS
    //Inputs
    protected static final String CANCEL = "CANCEL";
    protected static final String INSERT = "INSERT";
    protected static final String UPDATE = "UPDATE";
    protected static final String DELETE = "DELETE";

    //Outputs
    protected static final String VOID = "                              ";
    protected static final String ABOUT_TABLES = "\nСписок таблиц:\n";

    protected static final String SELECTION_OF_CANCELLING = "\nВведите \"CANCEL\" для выхода на главную\n";
    protected static final String SELECTION_OF_TABLE = "\nВведите название таблицы, с которой будете работать\n";
    protected static final String SELECTION_OF_PROCESSING = "\nВведите INSERT для добавления пользователя\nВведите UPDATE для изменения пользователя\nВведите DELETE для удаления пользователя\n";

    protected static final String INSERTING_OF_ROW = "\nили данные для новой записи через запятую\n(строки и даты необходимо заключать в одиночные кавычки):\n";
    protected static final String UPDATING_ID = "\nили id записи, которую нужно изменить:\n";
    protected static final String UPDATING_OF_ROW = "\nВведите новые данные для записи через запятую:\n";
    protected static final String DELETING_OF_ROW = "\nили id удаляемой записи:\n";

    //Functions
    protected static void clearScreen()
    {
        for(int i = 0; i < 5; i++)
        {
            System.out.print("\n\n\n\n\n");
        }
    }
}
