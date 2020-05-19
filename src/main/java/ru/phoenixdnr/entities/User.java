package ru.phoenixdnr.entities;

public class User
{
    public User() {}

    public User(Integer i)
    {
        this.id = i;
        this.lastName = "Merser";
        this.firstName = "Joh";
        this.login = "joh1333Merser";
        this.password = "0000";
        this.organization = "hz";
        this.contactInformation = "hz2";
        this.idRole = 1;
        this.idStatus = 3;
    };

    public User(
            Integer id,
            String last_name,
            String first_name,
            String login,
            String password,
            String organization,
            String contact_information,
            Integer id_role,
            Integer id_status)
    {
        this.id = id;
        this.lastName = last_name;
        this.firstName = first_name;
        this.login = login;
        this.password = password;
        this.organization = organization;
        this.contactInformation = contact_information;
        this.idRole = id_role;
        this.idStatus = id_status;
    }

    //Variables
    public Integer id;
    public String lastName;
    public String firstName;
    public String login;
    public String password;
    public String organization;
    public String contactInformation;
    public Integer idRole;
    public Integer idStatus;

    //Functions
    public String toString()
    {
        return  id + "\t\t" + lastName + "\t\t" + firstName + "\t\t" + login + "\t\t" + password + "\t\t" +
                organization + "\t\t" + contactInformation + "\t\t" + idRole + "\t\t" + idStatus;
    }
}
