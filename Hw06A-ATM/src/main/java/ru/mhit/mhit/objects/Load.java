package ru.mhit.mhit.objects;

import ru.mhit.mhit.actions.Amounts;

public class Load implements Operation {
    @Override
    public int action(int command, Amounts amounts) {
        return 0;
    }

    @Override
    public Amounts actionAmount(int command, Amounts amounts) {
        if(command == 4){
            amounts.load();
        }
        return amounts;
    }
}
