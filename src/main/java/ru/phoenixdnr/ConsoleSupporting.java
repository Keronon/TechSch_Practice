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
    protected static final String QUIT = "q";
    protected static final String CANCEL = "c";
    protected static final String INSERT = "INSERT";
    protected static final String UPDATE = "UPDATE";
    protected static final String DELETE = "DELETE";

    //Outputs
    protected static final String VOID = "                              ";
    protected static final String RUN = "\nВведите \"RUN\" для начала работы\n";
    protected static final String ABOUT_TABLES = "\nСписок таблиц:\n";

    protected static final String SELECTION_OF_QUIT = "\nВведите \"q\" чтобы закрыть приложение\n";
    protected static final String SELECTION_OF_CANCELLING = "\nВведите \"c\" для выхода на главную\n";
    protected static final String SELECTION_OF_TABLE = "\nВведите название таблицы, с которой будете работать\n";
    protected static final String SELECTION_OF_PROCESSING = "\nВведите INSERT для добавления пользователя\nВведите UPDATE для изменения пользователя\nВведите DELETE для удаления пользователя\n";

    protected static final String INSERTING_OF_ROW = "\nили данные для новой записи через запятую\n(строки и даты необходимо заключать в одиночные кавычки):\n";
    protected static final String UPDATING_ID = "\nили id записи, которую нужно изменить:\n";
    protected static final String UPDATING_OF_ROW = "\nВведите новые данные для записи через запятую:\n";
    protected static final String DELETING_OF_ROW = "\nили id удаляемой записи:\n";

    //Queries
    protected static final String SELECT_TABLE_IS = "SELECT COUNT(*) FROM information_schema.tables WHERE table_name='";
    protected static final String SELECT_TABLE_NAME = "SELECT table_name FROM information_schema.tables WHERE table_schema='public' ORDER BY 1";
    protected static final String SELECT_COLUMN_NAME = "SELECT column_name FROM information_schema.columns WHERE table_name='";
    protected static final String SELECT_ALL_ROWS = "SELECT * FROM %s ORDER BY 1";
    protected static final String INSERT_ROW = "INSERT INTO %s (%s) VALUES (%s)";
    protected static final String UPDATE_ROW = "UPDATE %s SET %s WHERE id=%d";
    protected static final String DELETE_ROW = "DELETE FROM %s WHERE id=%s;";

    //Functions
    protected static void clearScreen()
    {
        for(int i = 0; i < 5; i++)
        {
            System.out.print("\n\n\n\n\n");
        }
    }
}
