package com.nuist.collection.genericsClass;

public class GameTest {
    public static void main(String[] args) {
        LotteryGame<String> lotteryGame = new LotteryGame<>();
        lotteryGame.put("苹果14");
        lotteryGame.put("小米12");
        lotteryGame.put("没中奖");
        lotteryGame.put("华为p40");
        lotteryGame.put("没中奖");
        lotteryGame.put("荣耀");
        lotteryGame.put(null);
        lotteryGame.put("没中奖");

        System.out.println(lotteryGame.getPrize());

    }
}
