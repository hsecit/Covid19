package com.example.covid19.covidapi.bean;

public class Global {
    private String cases;
    private String deaths;
    private String recovered;


    public Global(String acses, String death, String recovred) {
        this.cases = acses;
        this.deaths = death;
        this.recovered = recovered;
    }

    public String getCases() {
        return cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public void setDeaths(String death) {
        this.deaths = death;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }
}
