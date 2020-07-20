package ru.mhit.mhit;

import ru.mhit.mhit.actions.Amounts;
import ru.mhit.mhit.services.EnterATM;

public class MyATM4 {
    private static Amounts amounts = new Amounts();
    public static void main(String[] args) throws NullPointerException{
        System.out.println("Start");
        int i = 1;
        int numberCommand = 1;
        try {
            while (numberCommand !=3) {
                amounts.amountPrint();
                numberCommand = new EnterATM().startATMInt("Load - 1; To give cash - 2; Close ATM - 3;");
                switch (numberCommand){
                    case 3 : {
                        amounts.amountPrint();
                        break;
                    }
                    case 2: {
                        amounts.amountPrint();
                        if(amounts.amountAll() == 0)  {
                            System.out.println("ATM close - amount 0");
                            i=0;
                        }
                        else {
                            long amount = new EnterATM().startATMLong("Enter then amount: ");
                            while (amounts.amountFind(amount) == false) {
                                amounts.amountPrint();
                                amount = new EnterATM().startATMLong("No amount! Enter then amount: ");
                            }
                            amounts.amountToGive(amount);
                        }
                        break;
                    }
                    case 1: {
                        amounts.load();
                        break;
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
