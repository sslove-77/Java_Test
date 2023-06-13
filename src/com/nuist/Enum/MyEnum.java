package com.nuist.Enum;

public enum MyEnum {
    EAST("东边"){
        @Override
        public void show() {
            System.out.println("这是东方");
        }
    },SOUTH("南边"){
        @Override
        public void show() {
            System.out.println("这是南方");
        }
    },WEST("西边"){
        @Override
        public void show() {
            System.out.println("这是西方");
        }
    },NORTH("北边"){
        @Override
        public void show() {
            System.out.println("这是北方");
        }
    };


   private String name;

    MyEnum(String name) {
        this.name = name;
    }

    public abstract void show();
}