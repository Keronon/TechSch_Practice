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
    protected static final String SELECTION_OF_TABLE = "\nВведите название таблицы, с которой будете работать\n";

    protected static final String OUTPUT_PROCESSING_CLIENT = "\nВведите \"c\" для выхода на главную или\nВведите INSERT для добавления пользователя\nВведите UPDATE для изменения пользователя\nВведите DELETE для удаления пользователя\n";
    protected static final String OUTPUT_INSERT_CLIENT = "\nВведите \"c\" для выхода на главную\nили\nимя, id технической информации, id города, адрес,\nконтактную информацию нового пользователя ниже\n";
    protected static final String OUTPUT_UPDATE_ID_CLIENT = "\nВведите \"c\" для выхода на главную\nили\nid пользователя, которого нужно изменить\n";
    protected static final String OUTPUT_DELETE_CLIENT = "\nВведите \"c\" для выхода на главную\nили\nid удаляемого пользователя\n";

    //Functions
    protected static void clearScreen()
    {
        for(int i = 0; i < 5; i++)
        {
            System.out.print("\n\n\n\n\n\n\n\n\n\n");
        }
    }
}
