package ru.phoenixdnr;

public interface IDataProcessing
{
    //Functions
    void run();
    void end();

    boolean isTable(String table);
    String[] getTables();
    void printTableHead(String table);
    void printTableRows(String table);

    void insert(String table);
    void update(String table);
    void delete(String table);
}
