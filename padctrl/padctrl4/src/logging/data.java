package logging;
/*
Written by Henry G for VAR padctrl 5/1/2019
Data storage class
 */
public class data {

    private boolean boosterStat;
    private boolean guidanceStat;
    private boolean rangeStat;
    private boolean flightStat;

    public boolean isBoosterStat() {
        return boosterStat;
    }

    public void setBoosterStat(boolean boosterStat) {
        this.boosterStat = boosterStat;
    }

    public boolean isGuidanceStat() {
        return guidanceStat;
    }

    public void setGuidanceStat(boolean guidanceStat) {
        this.guidanceStat = guidanceStat;
    }

    public boolean isRangeStat() {
        return rangeStat;
    }

    public void setRangeStat(boolean rangeStat) {
        this.rangeStat = rangeStat;
    }

    public boolean isFlightStat() {
        return flightStat;
    }

    public void setFlightStat(boolean flightStat) {
        this.flightStat = flightStat;
    }


}
