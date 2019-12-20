package ru.phoenixdnr;

public class Appeal
{
    // Variables
    private String appealDate;
    private int idDuty;
    private int idProblem;
    private int idClient;
    private String problemAnalysis;
    private String decisionDate;
    private String decision;
    private String culprit;
    private String downtime;
    private boolean checkOut;
    private boolean decisionSuccess;

    Appeal(String appeal_date, int id_duty, int id_problem, int id_client,
           String problem_analysis, String decision_date, String decision,
           String culprit, String downtime, boolean check_out, boolean decision_success)
    {
        this.appealDate = appeal_date;
        this.idDuty = id_duty;
        this.idProblem = id_problem;
        this.idClient = id_client;
        this.problemAnalysis = problem_analysis;
        this.decisionDate = decision_date;
        this.decision = decision;
        this.culprit = culprit;
        this.downtime = downtime;
        this.checkOut = check_out;
        this.decisionSuccess = decision_success;
    }

    // Functions
    public void showAppeals()
    {
        System.out.print(appealDate + "\t|\t" + idDuty + "\t|\t" + idProblem + "\t|\t" + idClient + "\t|\t" +
                         problemAnalysis + "\t|\t" + decisionDate + "\t|\t" + decision + "\t|\t" +
                         culprit + "\t|\t" + downtime + "\t|\t" + checkOut + "\t|\t" + decisionSuccess);
    }
}
