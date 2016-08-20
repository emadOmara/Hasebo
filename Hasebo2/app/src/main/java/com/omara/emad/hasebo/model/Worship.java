package com.omara.emad.hasebo.model;

/**
 * Created by Emad on 8/15/2016.
 */
public class Worship {

    private int id;
    private boolean fajr;
    private int fajrSonah;
    private  boolean zohr;
    private int zohrSonah;
    private boolean asr;
    private int asr_sonah;
    private boolean maghreb;
    private int  maghreb_sonah;
    private boolean eshaa;
    private int eshaaSonah;
    private boolean doha;
    private boolean azkarMoorning;
    private boolean azkarNight;
    private  int quran;
    private String date;

    public boolean isFajr() {
        return fajr;
    }

    public void setFajr(boolean fajr) {
        this.fajr = fajr;
    }

    public int getFajrSonah() {
        return fajrSonah;
    }

    public void setFajrSonah(int fajrSonah) {
        this.fajrSonah = fajrSonah;
    }

    public boolean isZohr() {
        return zohr;
    }

    public void setZohr(boolean zohr) {
        this.zohr = zohr;
    }

    public int getZohrSonah() {
        return zohrSonah;
    }

    public void setZohrSonah(int zohrSonah) {
        this.zohrSonah = zohrSonah;
    }

    public boolean isAsr() {
        return asr;
    }

    public void setAsr(boolean asr) {
        this.asr = asr;
    }

    public int getAsr_sonah() {
        return asr_sonah;
    }

    public void setAsr_sonah(int asr_sonah) {
        this.asr_sonah = asr_sonah;
    }

    public boolean isMaghreb() {
        return maghreb;
    }

    public void setMaghreb(boolean maghreb) {
        this.maghreb = maghreb;
    }

    public int getMaghreb_sonah() {
        return maghreb_sonah;
    }

    public void setMaghreb_sonah(int maghreb_sonah) {
        this.maghreb_sonah = maghreb_sonah;
    }

    public boolean isEshaa() {
        return eshaa;
    }

    public void setEshaa(boolean eshaa) {
        this.eshaa = eshaa;
    }

    public int getEshaaSonah() {
        return eshaaSonah;
    }

    public void setEshaaSonah(int eshaaSonah) {
        this.eshaaSonah = eshaaSonah;
    }

    public boolean isDoha() {
        return doha;
    }

    public void setDoha(boolean doha) {
        this.doha = doha;
    }

    public boolean isAzkarMoorning() {
        return azkarMoorning;
    }

    public void setAzkarMoorning(boolean azkarMoorning) {
        this.azkarMoorning = azkarMoorning;
    }

    public boolean isAzkarNight() {
        return azkarNight;
    }

    public void setAzkarNight(boolean azkarNight) {
        this.azkarNight = azkarNight;
    }

    public int getQuran() {
        return quran;
    }

    public void setQuran(int quran) {
        this.quran = quran;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
