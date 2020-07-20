package ru.mhit.mhit.services;

public class EnterATM implements EnterATMInterface {
    private final IOService ioService;

    public EnterATM() {
        this.ioService = new IOServiceConsole(System.out, System.in);
    }
    public EnterATM(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public int startATMInt(String txt) {
        ioService.out(txt);
        int command = ioService.readInt();
        return command;
    }

    @Override
    public long startATMLong(String txt) {
        ioService.out(txt);
        long amount = ioService.readLong();
        return amount;
    }

}
