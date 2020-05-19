package ru.phoenixdnr.entities;

public class Client
{
    public Client() {}

    public Client(Integer i)
    {
        this.id = i;
        this.name = "ROG";
        this.idTechnicalInformation = 1;
        this.idCity = 1;
        this.adress = "Abai31";
        this.contactInformation = "0713350244";
    };

    public Client(
            Integer id,
            String name,
            Integer idTechnical_information,
            Integer id_city,
            String adress,
            String contact_information)
    {
        this.id = id;
        this.name = name;
        this.idTechnicalInformation = idTechnical_information;
        this.idCity = id_city;
        this.adress = adress;
        this.contactInformation = contact_information;
    }

    //Variables
    public Integer id;
    public String name;
    public Integer idTechnicalInformation;
    public Integer idCity;
    public String adress;
    public String contactInformation;

    //Functions
    public String toString()
    {
        return  id + "\t\t" + name + "\t\t" + idTechnicalInformation + "\t\t" +
                idCity + "\t\t" + adress + "\t\t" + contactInformation;
    }
}
