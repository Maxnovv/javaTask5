//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

class MyClock implements Runnable {

    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println("Tik");
                Thread.sleep(500L);
            } catch (InterruptedException var3) {
                Thread.currentThread().interrupt();
            }

            try {
                System.out.println("Tak");
                Thread.sleep(500L);
            } catch (InterruptedException var2) {
                Thread.currentThread().interrupt();
            }
        }

    }
    public static void main(String[] args) throws InterruptedException
    {
        Thread clock = new Thread(new MyClock(),"clock");
        clock.start();
        Thread.currentThread().sleep(5000);
        clock.interrupt();
    }
}

