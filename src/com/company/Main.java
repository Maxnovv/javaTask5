//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

import java.io.PrintStream;
import java.util.List;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws InterruptedException {
        Main.OnlineGame onlineGame = new Main.OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        public static volatile boolean isWinnerFound = false;
        public static List<String> steps = List.of("Начало игры", "Сбор ресурсов", "Рост экономики", "Убийство врагов");
        protected Main.Gamer gamer1 = new Main.Gamer("Player 1", 3);
        protected Main.Gamer gamer2 = new Main.Gamer("Player 2", 1);
        protected Main.Gamer gamer3 = new Main.Gamer("Player 3", 5);

        public OnlineGame() {
        }

        public void run() {
            this.gamer1.start();
            this.gamer2.start();
            this.gamer3.start();

            while(!isWinnerFound) {
            }

        }
    }

    public static class Gamer extends Thread {
        private int rating;

        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
        }

        public void run() {
            for(int i = 0; i < 5; ++i) {
                if (!Thread.currentThread().isInterrupted()) {
                    if (i == 4 && !Main.OnlineGame.isWinnerFound) {
                        Main.OnlineGame.isWinnerFound = true;
                        System.out.println(Thread.currentThread().getName() + ":Победитель");
                        Thread.currentThread().interrupt();
                    } else if (Main.OnlineGame.isWinnerFound) {
                        System.out.println(Thread.currentThread().getName() + ":Проиграл");
                        Thread.currentThread().interrupt();
                    } else {
                        PrintStream var10000 = System.out;
                        String var10001 = Thread.currentThread().getName();
                        var10000.println(var10001 + ":" + (String)Main.OnlineGame.steps.get(i));

                        try {
                            Thread.sleep((long)(1000 / this.rating));
                        } catch (InterruptedException var3) {
                            var3.printStackTrace();
                        }
                    }
                }
            }

        }
    }
}
