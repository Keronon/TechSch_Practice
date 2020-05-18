package ru.phoenixdnr;

public class MemoryProcessing implements IDataProcessing
{
    private static MemoryProcessing memoryProcessing;
    private MemoryProcessing() {}

    public static synchronized MemoryProcessing getMemoryProcessing()
    {
        if (memoryProcessing == null) memoryProcessing = new MemoryProcessing();
        return memoryProcessing;
    }

    //Variables
    private Integer counter = 0;

    //Functions
    public void run()
    {}

    public void end()
    {}

    public boolean isTable(String table)
    {
        return false;
    }

    public void printTableList()
    {}

    public void printTableHead(String table)
    {}

    public void printTableRows(String table)
    {}

    public void insert(String table)
    {}

    public void update(String table)
    {}

    public void delete(String table)
    {}
}
