package ru.phoenixdnr;

import java.util.Scanner;

public class ConsoleSupporting
{
    private ConsoleSupporting() {}

    //Variables
    protected static String input;
    protected static Scanner scan = new Scanner(System.in);

    //Strings
    protected static final String QUIT = "q";
    protected static final String CANCEL = "c";
    protected static final String CLIENT = "ru.phoenix.Client";
    protected static final String APPEAL = "ru.phoenix.Appeal";
    protected static final String INSERT = "INSERT";
    protected static final String UPDATE = "UPDATE";
    protected static final String DELETE = "DELETE";

    protected static final String OUTPUT_RUN = "Введите \"RUN\" для начала работы\n\n";
    protected static final String OUTPUT_QUIT = "Введите \"q\" чтобы закрыть приложение\n\n";
    protected static final String OUTPUT_CLIENT_OR_APPEAL = "Введите \"ru.phoenix.Client\" для изменения клиентов\nили\n\"ru.phoenix.Appeal\" для изменения обращений\n\n";

    protected static final String OUTPUT_CLIENT_TABLE_HEAD = "id\t|\tname\t|\tidCity\t|\tidTechnicalInformation\t|\taddress\t|\tcontactInformation\n";
    protected static final String OUTPUT_PROCESSING_CLIENT = "\n\nВведите \"c\" для выхода на главную или\nВведите INSERT для добавления пользователя\nВведите UPDATE для изменения пользователя\nВведите DELETE для удаления пользователя\n\n";
    protected static final String OUTPUT_INSERT_CLIENT = "Введите \"c\" для выхода на главную\nили\nимя, id технической информации, id города, адрес,\nконтактную информацию нового пользователя ниже\n\n";
    protected static final String OUTPUT_UPDATE_ID_CLIENT = "Введите \"c\" для выхода на главную\nили\nid пользователя, которого нужно изменить\n\n";
    protected static final String OUTPUT_UPDATE_CLIENT = "\nВведите новые данные клиента:\nимя, id технической информации, id города, адрес,\nконтактную информацию нового пользователя ниже\n\n";
    protected static final String OUTPUT_DELETE_CLIENT = "Введите \"c\" для выхода на главную\nили\nid удаляемого пользователя\n\n";

    protected static final String OUTPUT_APPEAL_TABLE_HEAD = "id\t|\tappeal_dat\t|\tid_duty\t|\tid_problem\t|\tid_client\t|\tproblem_analysis\t|\tdecision_date\t|\tdecision\t|\tculprit\t|\tdowntime\t|\tcheck_out\t|\tdecision_success\n";
    protected static final String OUTPUT_PROCESSING_APPEAL = "\n\nВведите \"c\" для выхода на главную или\nВведите INSERT для добавления оюращения\nВведите UPDATE для изменения оюращения\nВведите DELETE для удаления оюращения\n\n";
    protected static final String OUTPUT_INSERT_APPEAL = "Введите \"c\" для выхода на главную\nили\nдату обращения, дежурного, id проблемы, id клиента,\nанализ, дату принятия решения, решение, виновного,\nпростой, проверку выезда, успешность решения ниже\n\n";
    protected static final String OUTPUT_UPDATE_ID_APPEAL = "Введите \"c\" для выхода на главную\nили\nid обращения, которое нужно изменить\n\n";
    protected static final String OUTPUT_UPDATE_APPEAL = "\nВведите новые данные обращения:\nдату обращения, дежурного, id проблемы, id клиента,\nанализ, дату принятия решения, решение, виновного,\nпростой, проверку выезда, успешное решение ниже\n\n";
    protected static final String OUTPUT_DELETE_APPEAL = "Введите \"c\" для выхода на главную\nили\nid удаляемого обращения\n\n";

    //Functions
    protected static void clearScreen()
    {
        for(int i = 0; i < 5; i++)
        {
            System.out.print("\n\n\n\n\n\n\n\n\n\n");
        }
    }
}
