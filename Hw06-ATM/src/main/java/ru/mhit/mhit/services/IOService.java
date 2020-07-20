package ru.mhit.mhit.services;

public interface IOService {
    void out(String message);
    String readLn(String prompt);
    int readInt();
    long readLong();
}
