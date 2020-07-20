package ru.mhit.mhit.objects;

import ru.mhit.mhit.actions.Amounts;
import ru.mhit.mhit.services.EnterATM;

public class ToGive implements Operation {
    @Override
    public int action(int command, Amounts amounts) {
        return 0;
    }

    @Override
    public Amounts actionAmount(int command, Amounts amounts) {
        if(command == 2) {
            amounts.amountPrint();
            if (amounts.amountAll() == 0) {
                System.out.println("ATM amount 0!!!");
            } else {
                long amount = new EnterATM().startATMLong("Enter then amount: ");
                while (amounts.amountFind(amount) == false) {
                    amounts.amountPrint();
                    amount = new EnterATM().startATMLong("No amount! Enter then amount: ");
                }
                amounts.amountToGive(amount);
            }
        }
        return amounts;
    }
}
