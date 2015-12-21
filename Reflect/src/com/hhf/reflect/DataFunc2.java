package com.hhf.reflect;

public class DataFunc2 {  
    @SuppressWarnings("unused")  
    private int data1;  
    @SuppressWarnings("unused")  
    private int data2;  
    private int result;  
  
    public DataFunc2() {  
        data1 = 0;  
        data2 = 0;  
        result = 0;  
    }  
  
    public DataFunc2(int x, int y) {  
        data1 = x;  
        data2 = y;  
  
    }  
  
    public int add2(int a, int b, int c) {  
        result = a + b + c;  
        return result;  
    }  
}  