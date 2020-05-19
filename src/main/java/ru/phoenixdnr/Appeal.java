package ru.phoenixdnr;

public class Appeal
{
    public Appeal() {}

    public Appeal(Integer i)
    {
        this.id = i;
        this.appealDate = "20.05.2020";
        this.checkOut = false;
        this.culprit = "hz";
        this.decision = "hz2";
        this.decisionDate = "25.05.2020";
        this.decisionSuccess = true;
        this.downtime = "04.07.2021";
        this.idClient = (int)Math.random()*55;
        this.idDuty = 1;
        this.idProblem = 1;
        this.problemAnalysis = "otsutstvie";
    }

    public Appeal(
            Integer id,
            String appeal_date,
            Integer id_duty,
            Integer id_problem,
            Integer id_client,
            String problem_analysis,
            String decision_date,
            String decision,
            String culprit,
            String downtime,
            Boolean check_out,
            Boolean decision_success)
    {
        this.id = id;
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

    //Variables
    public Integer id;
    public String appealDate;
    public Integer idDuty;
    public Integer idProblem;
    public Integer idClient;
    public String problemAnalysis;
    public String decisionDate;
    public String decision;
    public String culprit;
    public String downtime;
    public Boolean checkOut;
    public Boolean decisionSuccess;

    //Functions
    public String toString()
    {
        return  id + "\t\t" + appealDate + "\t\t" + idDuty + "\t\t" + idProblem + "\t\t" +
                idClient + "\t\t" + problemAnalysis + "\t\t" + decisionDate + "\t\t" + decision + "\t\t" +
                culprit + "\t\t" + downtime + "\t\t" + checkOut + "\t\t" + decisionSuccess;
    }
}
