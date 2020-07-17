package ru.mhit.mhit;

import ru.mhit.mhit.actions.Amounts;
import ru.mhit.mhit.services.EnterATM;

public class MyATM3 {

    public static void main(String[] args) throws NullPointerException{
        System.out.println("Start");
        Amounts amounts = new Amounts();
        int i = 1;
        int numberCommand;
        try {
            while (i > 0) {
                amounts.amount();
                amounts.amountPrint();
                if(amounts.amountAll() == 0)  {
                    System.out.println("ATM close - amount 0");
                    i=0;
                }
                else {
                    numberCommand = new EnterATM().startATMInt("Load - 1; To give cash - 2; Close ATM - 3;");
                    if (numberCommand == 1) {
                        amounts.load();
                    }
                    if (numberCommand == 2) {
                        amounts.amountPrint();
                        long amount = new EnterATM().startATMLong("Enter then amount: ");
                        while(amounts.amountFind(amount) == false){
                            amounts.amountPrint();
                            amount = new EnterATM().startATMLong("No amount! Enter then amount: ");
                        }
                        amounts.amountToGive(amount);
                    }
                    if (numberCommand == 3) {
                        i = 0;
                        amounts.amount();
                        amounts.amountPrint();
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
}
