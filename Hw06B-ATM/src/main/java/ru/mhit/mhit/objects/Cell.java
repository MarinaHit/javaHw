package ru.mhit.mhit.objects;

public class Cell {
    private int nominal;
    private final int count_Max = 1000 ;
    private int count;

    public Cell(int nominal) {
        this.nominal =  nominal;
        this.count = count_Max;
    }
    public Cell(int nominal, int count) {
        this.nominal = nominal;
        this.count = count;
    }
    public int getNominal() {
        return nominal;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void setCountMax() {
        this.count = count_Max;
    }
    public long getAmount() {
        return (long) count*nominal;
    }
    public int getCount_Max() { return count_Max;    }

    @Override
    public String toString() {
        return "Cell{" + "nominal = " + nominal + ", count = " + count + ", amount = " + nominal*count + '}';
    }
}
