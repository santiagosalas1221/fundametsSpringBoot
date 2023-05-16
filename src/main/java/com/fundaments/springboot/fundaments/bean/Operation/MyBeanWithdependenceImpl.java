package com.fundaments.springboot.fundaments.bean.Operation;

public class MyBeanWithdependenceImpl implements MyBeanWithDependence {

    MyOperation myOperation;

    public MyBeanWithdependenceImpl(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependence() {
        int number = 1;
        myOperation.sum(number);
        System.out.println(myOperation.sum(number));
        System.out.println("Start clas MyBeanWithdependenceImpl ");
    }
}
