package TA5;

import java.util.Scanner;

public class Extra3 {
	
	public static void main(String[] args) {
		/* Escribe un programa que imprima todas
		 * las tablas de multiplicar del 1 al 9 (desde 0 hasta 10).*/
		
		int n = 0;
		int tabla = 1;
		
		while (tabla == 1 && n<10){
			System.out.println("--Tabla del 1--");
			do{
				int t1 = 1 * n;
				System.out.println("1 * " +n+ " = " +t1);
				n++;
				
			}while(n<=10 && tabla == 1);
		}tabla++; n=0;
		
		
		while (tabla == 2 && n<10){
			System.out.println("\n--Tabla del 2--");
			do{ 
				int t2 = 2 * n;
				System.out.println("2 * " +n+ " = " +t2);
				n++;
				
			}while(n<=10 && tabla == 2);
		}tabla++; n=0;
		
		
		while (tabla == 3 && n<10){
			System.out.println("\n--Tabla del 3--");
			do{ 
				int t3 = 3 * n;
				System.out.println("3 * " +n+ " = " +t3);
				n++;
				
			}while(n<=10 && tabla == 3);
		}tabla++; n=0;
		
		
		while (tabla == 4 && n<10){
			System.out.println("\n--Tabla del 4--");
			do{ 
				int t4 = 4 * n;
				System.out.println("4 * " +n+ " = " +t4);
				n++;
			}while(n<=10 && tabla == 4);
			
		}tabla++; n=0;
		
		while (tabla == 5 && n<10){
			System.out.println("\n--Tabla del 5--");
			do{ 
				int t5 = 5 * n;
				System.out.println("5 * " +n+ " = " +t5);
				n++;
				
			}while(n<=10 && tabla == 5);
		}tabla++; n=0;
		
		
		while (tabla == 6 && n<10){
			System.out.println("\n--Tabla del 6--");
			do{ 
				int t6 = 6 * n;
				System.out.println("6 * " +n+ " = " +t6);
				n++;
				
			}while(n<=10 && tabla == 6);
		}tabla++; n=0;
		
		
		while (tabla == 7 && n<10){
			System.out.println("\n--Tabla del 7--");
			do{ 
				int t7 = 7 * n;
				System.out.println("7 * " +n+ " = " +t7);
				n++;
				
			}while(n<=10 && tabla == 7);
		}tabla++; n=0;
		

		while (tabla == 8 && n<10){
			System.out.println("\n--Tabla del 8--");
			do{ 
				int t8 = 8 * n;
				System.out.println("8 * " +n+ " = " +t8);
				n++;
				
			}while(n<=10 && tabla == 8);
		}tabla++; n=0;
		

		while (tabla == 9 && n<10){
			System.out.println("\n--Tabla del 9--");
			do{ 
				int t9 = 9 * n;
				System.out.println("9 * " +n+ " = " +t9);
				n++;
				
			}while(n<=10 && tabla == 9);
		}
		System.out.println("\n-- FIN DEL PROGRAMA --");
	
	}
}

