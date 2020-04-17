package com.example.covid19.covidapi.bean;

import androidx.core.app.ServiceCompat;

import com.google.gson.annotations.SerializedName;

public class Countrie {
    //{"country":"North America","cases":725968,"todayCases":1408,"deaths":36785,"todayDeaths":76,"recovered":70683,
    // "active":618500,"critical":14459,"casesPerOneMillion":0,"deathsPerOneMillion":0,"totalTests":0,"testsPerOneMillion":0},

    private String country;
    private String cases;
    private String todayCases;
    private String deaths;
    private String todayDeaths;
    private String recovered;
    private String active;
    private String critical;
    private String casesPerOneMillion;
    private String deathsPerOneMillion;
    private String totalTests;
    private String testsPerOneMillion;
    public Countrie(){}
    public Countrie(String country, String cases, String todayCases, String death, String todayDeaths, String recovered, String active, String critical, String casesPerOneMillion, String deathsPerOneMillion, String totalTests, String testsPerOneMillion) {
        this.country = country;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = death;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
        this.casesPerOneMillion = casesPerOneMillion;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.totalTests = totalTests;
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public String getCountry() {
        return country;
    }

    public String getCases() {
        return cases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public String getDeath() {
        return deaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getActive() {
        return active;
    }

    public String getCritical() {
        return critical;
    }

    public String getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public String getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public String getTotalTests() {
        return totalTests;
    }

    public String getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public void setDeath(String death) {
        this.deaths = death;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public void setCasesPerOneMillion(String casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public void setDeathsPerOneMillion(String deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public void setTotalTests(String totalTests) {
        this.totalTests = totalTests;
    }

    public void setTestsPerOneMillion(String testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    @Override
    public String toString() {
        return "Countrie{" +
                "country='" + country + '\'' +
                ", cases='" + cases + '\'' +
                ", todayCases='" + todayCases + '\'' +
                ", deaths='" + deaths + '\'' +
                ", todayDeaths='" + todayDeaths + '\'' +
                ", recovered='" + recovered + '\'' +
                ", active='" + active + '\'' +
                ", critical='" + critical + '\'' +
                ", casesPerOneMillion='" + casesPerOneMillion + '\'' +
                ", deathsPerOneMillion='" + deathsPerOneMillion + '\'' +
                ", totalTests='" + totalTests + '\'' +
                ", testsPerOneMillion='" + testsPerOneMillion + '\'' +
                '}';
    }
}
