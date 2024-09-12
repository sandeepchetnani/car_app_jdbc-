package com.ty.dto;

public class Singleton {
	
	private Singleton()
	{
		
		
		System.out.println("singleton class");
	}
	static Singleton getSingleton()
	{
		
		return new Singleton();
		
	}
	
	
	

}
class Program1
{
	public static void main(String[] args) {
		System.out.println(Singleton.getSingleton());
		
	}
}
