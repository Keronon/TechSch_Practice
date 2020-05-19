package ru.phoenixdnr.entities;

public class FinancialOperation
{
    public FinancialOperation() {};

    //Variables
    private Integer id;
    private Integer idBill;
    private Integer idTransactionType;
    private Integer sum;
    private Character[] operationDate = new Character[10];
    private Integer idUser;
    private Integer idContractPart;
    private Character[] cancellationDate = new Character[10];
    private Integer idCancellationUser;
    private String comment;

    //Functions
}
