package ru.mhit.mhit.objects;

import ru.mhit.mhit.actions.Amounts;

public class Close implements Operation {
    @Override
    public int action(int command, Amounts amounts) {
        if (command ==3) {
            amounts.amountPrint();
            return 3;
        }
        else{
            return command;
        }
    }

    @Override
    public Amounts actionAmount(int command, Amounts amounts) {
        return null;
    }
}
