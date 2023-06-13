package com.nuist.thread.synchronize.communication;

/**
 * @author Helen
 * @date 2023-02-13 21:03
 */
public class CommunicationTest {
    public static void main(String[] args) {
        ThreadCommunication threadCommunication = new ThreadCommunication();

        Thread th1 = new Thread(threadCommunication, "Java");
        Thread th2 = new Thread(threadCommunication, "MySQL");

        th2.start();
        th1.start();
    }
}
