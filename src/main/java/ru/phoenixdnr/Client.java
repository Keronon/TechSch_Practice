package ru.phoenixdnr;

public class Client
{
    // Variables
    private String name;
    private int idTechnicalInformation;
    private int idCity;
    private String address;
    private String contactInformation;

    Client(String name, int id_technical_information, int id_city, String address, String contact_information)
    {
        this.name = name;
        this.idTechnicalInformation = id_technical_information;
        this.idCity = id_city;
        this.address = address;
        this.contactInformation = contact_information;
    }

    // Functions
    public void showClients()
    {
        System.out.print(name + "\t|\t" + idCity + "\t|\t" + idTechnicalInformation + "\t|\t" + address + "\t|\t" + contactInformation);
    }
}
