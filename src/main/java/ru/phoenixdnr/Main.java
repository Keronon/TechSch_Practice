package ru.phoenixdnr;

import java.io.IOException;

public class Main
{
    private Main() {}

    public static void main(String[] args) throws IOException
    {
        Processor processor = Processor.getProcessor();
        processor.run();
    }
}