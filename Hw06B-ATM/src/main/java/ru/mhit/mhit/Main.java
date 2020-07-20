package ru.mhit.mhit;

import ru.mhit.mhit.objects.ATM;
import ru.mhit.mhit.objects.Cell;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Start");
        Scanner in = new Scanner(System.in);
        ATM atm = new ATM();
        try {
            System.out.println("Amount ATM: " + atm.amount());
            for(Cell i : atm.getATMCell()){
                System.out.print("Enter then count nominal: "+ i.getNominal()+"  ( max  " + (i.getCount_Max() - i.getCount()) + " ): ");
                int nominal = in.nextInt();
                if (atm.setCellATM(i.getNominal(),nominal)) System.out.println("Amount atm: " + atm.amount());
                else  throw new Exception();
            }
            System.out.println("===========================================================================");
            if (atm.amount() == 0 ) {
                System.out.println("Load ATM");
                atm.load();
                System.out.println("Amount ATM: " + atm.amount());
                System.out.println("===========================================================================");
            }
            System.out.println("Amount min: " + atm.amountMIN() + "   Amount max: " + atm.amount());
            System.out.print("Enter then amount: ");
            long amount = in.nextLong();
            int[] countsNominal = new int[atm.getCountCellATM()];
            int x = 0;
            for( Cell i: atm.getATMCell() ) {
                countsNominal[x] = atm.getCellATM(i.getNominal());
                x++;
            }
            if (atm.amountToGive(amount)) {
                System.out.println( "Issued amount: " + amount );
            }
            else throw new Exception();
            int k = 0;
            for(Cell i: atm.getATMCell() ){
                if ((countsNominal[k] - i.getCount()) * i.getNominal() != 0)
                    System.out.println( "Nominal: " + i.getNominal() +
                            " count: " + (countsNominal[k] - i.getCount()) +
                            " amount: " + (countsNominal[k] - i.getCount()) * i.getNominal() );
                k++;
            }
            System.out.println("================================================================================");
            for (Cell c: atm.getATMCell()){
                System.out.println(c.toString());
            }
        }catch (Exception e){
            System.out.println("Exception no amount in ATM!!! ");
        } finally {
            System.out.println("Amount ATM: " + atm.amount() );
            System.out.println("End");
        }
    }
}