package controller;

public class NumericalController {

	public static void main(String[] args) {
		int count = 0;
		int add = 0;
		int num = 0;
		for (num = 1; num <= 3999; num++) {

			//使用している記号を数える

			int M = num / 1000;
			int amari = num % 1000;
			//System.out.println(amari);
			for (int i = 0; i < M; i++) {
				//System.out.print("M");
				count++;
			}
			if (amari >= 900) {
				//System.out.print("CM");
				amari -= 900;
				count += 2;
			}
			if (amari >= 500) {
				//System.out.print("D");
				amari -= 500;
				count++;
			}
			if (amari >= 400) {
				//System.out.print("CD");
				amari -= 400;
				count += 2;
			}
			if (amari >= 100) {

				int C = amari / 100;

				for (int i = 0; i < C; i++) {
					//System.out.print("C");
					count++;
				}
				amari -= 100 * C;

			}
			if (amari >= 90) {
				//System.out.print("XC");
				amari -= 90;
				count += 2;
			}
			if (amari >= 50) {
				//System.out.print("L");
				amari -= 50;
				count++;
			}
			if (amari >= 40) {
				//System.out.print("XL");
				amari -= 40;
				count += 2;
			}
			if (amari >= 10) {

				int X = amari / 10;

				for (int i = 0; i < X; i++) {
					//System.out.print("X");
					count++;
				}
				amari -= 10 * X;
			}
			if (amari >= 9) {
				//System.out.print("IX");
				amari -= 9;
				count += 2;
			}
			if (amari >= 5) {
				//System.out.print("V");
				amari -= 5;
				count++;
			}
			if (amari >= 4) {
				//System.out.print("IV");
				amari -= 4;
				count += 2;
			}
			if (amari == 3) {
				//System.out.print("III");
				count += 3;
			} else if (amari == 2) {
				//System.out.print("II");
				count += 2;
			} else if (amari == 1) {
				//System.out.print("I");
				count++;
				//System.out.println("");

			}
			//System.out.println(count);
			if (count == 12) {
				add++;
			}
			count = 0;
		}
		System.out.println("A:" + add + "通り");
	}
}
