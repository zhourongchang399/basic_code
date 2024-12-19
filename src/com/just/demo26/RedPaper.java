package com.just.demo26;

public class RedPaper {
    public static void main(String[] args) {
        RedPaperThread redPaperThread1 = new RedPaperThread();
        RedPaperThread redPaperThread2 = new RedPaperThread();
        RedPaperThread redPaperThread3 = new RedPaperThread();
        RedPaperThread redPaperThread4 = new RedPaperThread();
        RedPaperThread redPaperThread5 = new RedPaperThread();

        redPaperThread1.setName("Person 1");
        redPaperThread2.setName("Person 2");
        redPaperThread3.setName("Person 3");
        redPaperThread4.setName("Person 4");
        redPaperThread5.setName("Person 5");

        redPaperThread1.start();
        redPaperThread2.start();
        redPaperThread3.start();
        redPaperThread4.start();
        redPaperThread5.start();
    }
}
