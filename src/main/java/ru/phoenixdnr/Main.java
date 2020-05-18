package ru.phoenixdnr;

import java.io.IOException;

public class Main
{
    private Main() {}

    public static void main(String[] args) throws IOException
    {
        Application application = Application.getApplication();
        application.run();
    }
}