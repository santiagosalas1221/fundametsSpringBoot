package com.fundaments.springboot.fundaments.bean.Operation;

public class MyOperationImpl implements MyOperation {
    @Override
    public int sum(int number) {
        System.out.println("Start class MyOperationImpl - number operation: " + number);
        int result = number + 1;
        System.out.println("Result of class MyOperationImpl: " + result);
        return result;
    }
}
