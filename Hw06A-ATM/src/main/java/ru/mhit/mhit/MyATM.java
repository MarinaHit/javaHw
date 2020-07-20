package ru.mhit.mhit;

import ru.mhit.mhit.actions.Amounts;
import ru.mhit.mhit.objects.*;
import ru.mhit.mhit.services.EnterATM;
import ru.mhit.objects.*;

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
                amounts = new MyATM().goAmount(numberCommand, new Load(), amounts);
                amounts = new MyATM().goAmount(numberCommand, new ToGive(), amounts);
                amounts = new MyATM().goAmount(numberCommand, new Deposit(), amounts);
                numberCommand = new MyATM().go(numberCommand, new Close(), amounts);
            }
        }catch (Exception e){
            System.out.println("Exception " +e );
        }
       finally {
           System.out.println("End");
       }
    }
    private int go(int command, Operation operation, Amounts amounts)
    {
        int Int = operation.action(command, amounts);
        return Int;
    }

    private Amounts goAmount(int command, Operation operation, Amounts amounts)
    {
        amounts = operation.actionAmount(command, amounts);
        return amounts;
    }
 }
