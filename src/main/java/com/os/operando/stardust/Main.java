package com.os.operando.stardust;

import java.io.IOException;

public class Main {

    public static void main(String[] s){
        try {
            System.out.print(Stardust.getChannelsList(""));
            System.out.print(Stardust.getUsersList(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
