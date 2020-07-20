package ru.mhit.mhit.objects;

import ru.mhit.mhit.actions.Amounts;

public interface Operation {
    int action(int command, Amounts amounts);
    Amounts actionAmount(int command, Amounts amounts);
}
