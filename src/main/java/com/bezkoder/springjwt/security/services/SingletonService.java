package com.bezkoder.springjwt.security.services;

import org.springframework.stereotype.Service;

@Service // Spring gère ce bean comme un singleton par défaut
public class SingletonService {

    private int count = 0;

    public SingletonService() {
        System.out.println("SingletonService instance created!");
    }

    public void incrementCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
