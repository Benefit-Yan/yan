package com.hhf.reflect;

public class DataFunc {  
	  private int data1;  
	  private int data2;  
	  private int result;  
	  
	  public DataFunc() {  
	    data1=0;  
	    data2=0;  
	    result=0;  
	  }  
	  public DataFunc(int x,int y){  
	    data1=x;  
	    data2=y;  
	     
	  }  
	  
	  public int add(){  
	    result=data1+data2+1;  
	    return result;  
	  }  
	    
	  public int substract(){  
	    result=data1-data2;  
	    return result;  
	  }  
	  
	  public int multiply(){  
	    result=data1*data2;  
	    return result;  
	  }  
	    
	  public int divide(){  
	      result=data1/data2;  
	      return result;  
	        
	  }  
	    
	  
	}  