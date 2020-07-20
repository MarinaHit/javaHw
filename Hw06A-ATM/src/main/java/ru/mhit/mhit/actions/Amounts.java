package ru.mhit.mhit.actions;

import ru.mhit.mhit.services.EnterATM;

public class Amounts {

    private static Cell[] cell = new Cell[6];
    private static long amountAll;
    private static long amountMin;

    public Amounts(Cell[] cell) {
        this.cell = cell;
    }
    public Amounts() {
        cell[0] = new Cell(100);
        cell[1] = new Cell(200);
        cell[2] = new Cell(500);
        cell[3] = new Cell(1000);
        cell[4] = new Cell(2000);
        cell[5] = new Cell(5000);
    }
    public long amountMIN(){
         return this.amountMin;
    }
    public long amountAll(){
        return this.amountAll;
    }

    public static void amount(){
        amountAll = 0;
        amountMin = 0;
        for (int i = 0; i < cell.length; i++) {
            amountAll = amountAll + cell[i].getAmount();
            if( cell[i].getCount() != 0 & amountMin == 0  ) {
                amountMin = cell[i].getNominal();
            }
        }
    }
    public static void amountPrint(){
        Amounts.amount();
        System.out.println("==============================================================================");
        System.out.println("Amount min: " + amountMin + "   Amount max: " + amountAll);
    }

    public static void load(){
        amountAll = 0;
        amountMin = 0;
        for (int i = 0; i < cell.length; i++) {
            cell[i].setCountMax();
            amountAll = amountAll + cell[i].getAmount();
            if( amountMin == 0  ) {
                amountMin = cell[i].getNominal();
            }
        }
        System.out.println("Load");
    }

    public void depositCash(){
        long amount = 0;
        int count = 0;
        for (int i = 0; i < cell.length; i++) {
            String txt = "Enter count nominal " + cell[i].getNominal() +" (max "+ (cell[i].getCount_Max() - cell[i].getCount()) +"):";
            count = new EnterATM().startATMInt(txt);
            while (count > cell[i].getCount_Max() - cell[i].getCount() ){
                 count = new EnterATM().startATMInt(txt);
            }
            cell[i].setCount(cell[i].getCount() + count);
            amount = amount + count*cell[i].getNominal();
            System.out.println("Accepted in cash (nominal :" +
                    cell[i].getNominal()+"): " + count*cell[i].getNominal() +
                    "  amount all: " + amount);
        }
        System.out.println("Accepted in cash: " + amount);
        Amounts.amount();
     }

    public static void amountToGive(long amount){
        long amountTime = amount;
        int countTime = 0;
        int countAmountAll = 0;
        for ( int i = cell.length-1; i >= 0; i--)
        {
            countTime = (int) (amountTime / cell[i].getNominal());
            if( countTime > cell[i].getCount()){    countTime = cell[i].getCount();            }
            amountTime = amountTime - countTime*cell[i].getNominal();
            cell[i].setCount( cell[i].getCount() - countTime );
            countAmountAll = countAmountAll + countTime;
            if (countTime !=0 ) System.out.println("Nominal: " + cell[i].getNominal() +
                    " Count: " + countTime + "  Amount:" + countTime*cell[i].getNominal() );
        }
        System.out.println("Issued amount: " + amount);
    }

    public static boolean amountFind(long amount){
        if (amount > amountAll) {   return false;}
        if (amount < amountMin) {   return false;}
        if (amount % amountMin != 0) {   return false;}
        long amountTime = amount;
        int countAmountAll = 0;
        int countTime = 0;
        for ( int i = cell.length-1; i >= 0; i--)
        {
            countTime = (int) (amountTime / cell[i].getNominal());
            if( countTime > cell[i].getCount())     countTime = cell[i].getCount();
            amountTime = amountTime - countTime*cell[i].getNominal();
            countAmountAll = countAmountAll + countTime;
        }
        if (amountTime != 0) {   return false;}
        return true;
    }

}
