package ru.mhit.mhit;

import java.util.Scanner;

import ru.mhit.mhit.actions.Cell;
import ru.mhit.mhit.services.EnterATM;


public class MyATM2 {

    private static long amountAll;
    private static long amountMin;

    public static void main(String[] args) throws NullPointerException{
        System.out.println("Start");
        Cell[] cell = new Cell[6];
        setCell(cell);
        int i = 1;
        int numberCommand;
        try {
            while (i > 0) {
                amount(cell);
                amountPrint();
                if(amountAll == 0 )  {
                    System.out.println("ATM close - amount 0");
                    i=0;
                }
                else {
                    numberCommand = new EnterATM().startATMInt("Load - 1; To give cash - 2; Close ATM - 3;");
                    if (numberCommand == 1) {
                        load(cell);
                    }
                    if (numberCommand == 2) {
                        toGive(cell);
                    }
                    if (numberCommand == 3) {
                        i = 0;
                        amount(cell);
                        amountPrint();
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Exception " +e );
        }
        finally {
            System.out.println("End");
        }
    }
    private static Cell[] setCell(Cell[] cell){
        cell[0] = new Cell(100);
        cell[1] = new Cell(200);
        cell[2] = new Cell(500);
        cell[3] = new Cell(1000);
        cell[4] = new Cell(2000);
        cell[5] = new Cell(5000);
        return cell;
    }
    private static void amount(Cell[] cell){
        amountAll = 0;
        amountMin = 0;
        for (int i = 0; i < cell.length; i++) {
            amountAll = amountAll + cell[i].getAmount();
            if( cell[i].getCount() != 0 & amountMin == 0  ) {
                amountMin = cell[i].getNominal();
            }
        }
    }
    private static void amountPrint(){
        System.out.println("Amount min: " + amountMin + "   Amount max: " + amountAll);
    }

    private static void close(Cell[] cell){
        System.out.println("Close");
    }

    private static void load(Cell[] cell){
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

    private static void toGive(Cell[] cell){
        Scanner console = new Scanner(System.in);
        long amount;
        amount(cell);
        System.out.println("Enter the amount (" + amountMin +  "-" + amountAll + " ("+ amountMin +") ) :");
        amount = console.nextLong();
        while(amountFind(cell, amount) == false){
            System.out.println("Not amount. Enter the amount (" + amountMin +  "-" + amountAll + " ("+ amountMin +") ) :");
            amount = console.nextLong();
        }
        long amountTime = amount;
        int countTime = 0;
        int countAmountAll = 0;
        for ( int i = cell.length-1; i >= 0; i--)
        {
            countTime = (int) (amountTime / cell[i].getNominal());
            if( countTime > cell[i].getCount()){
                countTime = cell[i].getCount();
            }
            amountTime = amountTime - countTime*cell[i].getNominal();
            cell[i].setCount( cell[i].getCount() - countTime );
            countAmountAll = countAmountAll + countTime;
            System.out.println("Nominal: " + cell[i].getNominal() +
                    " Count: " + countTime + "  Amount:" + countTime*cell[i].getNominal() );
        }
        System.out.println("Issued amount: " + amount);
    }

    private static boolean amountFind(Cell[] cell, long amount) {
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

