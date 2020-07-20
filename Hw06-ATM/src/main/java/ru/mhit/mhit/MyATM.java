package ru.mhit.mhit;

import ru.mhit.mhit.actions.Amounts;
import ru.mhit.mhit.services.EnterATM;

public class MyATM {
    private static Amounts amounts = new Amounts();
    public static void main(String[] args) throws NullPointerException{
        System.out.println("Start");
        int numberCommand = 4;
        try {
            while (numberCommand !=3) {
                amounts.amountPrint();
                numberCommand = new EnterATM().startATMInt
                        ("Deposit cash - 1; To give cash - 2; Close ATM - 3; Load ATM - 4 ");
                switch (numberCommand){
                    case 1 : {
                       amounts.depositCash();
                        break;
                    }
                    case 3 : {
                        amounts.amountPrint();
                        break;
                    }
                    case 2: {
                        amounts.amountPrint();
                        if(amounts.amountAll() == 0)  {
                            System.out.println("ATM amount 0!!!");
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
                    case 4: {
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
