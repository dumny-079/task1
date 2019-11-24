package com.company;

public class Main {
   public static void main(String[] args) {
	String[] arr = {"Z11-100", "Z12-150", "Z13-120", "Z11-80", "Z12-50", "Z13-40", "Z11-200", "Z12-0", "Z13-10", "Z11-170"};
    	double fuelZ11 = 46.1;
    	double fuelZ12 = 47.5;
    	double fuelX13 = 48.9;
    	double expenceZ11 = 12.5;
    	double expenceZ12 = 12;
    	double expenceZ13 = 11.5;
    	double expence = 15;
    	double sum = 0;
    	double sumZ11Km = 0;
    	double sumZ12Km = 0;
    	double sumZ13Km = 0;
		double sumZ11 = 0;
		double sumZ12 = 0;
		double sumZ13 = 0;
		double sumZ11liter = 0;
		double sumZ12liter = 0;
		double sumZ13liter = 0;
		String max;
		String min;
    	for(int i = 0; i < arr.length; i++){
			if(arr[i].indexOf("Z11") != -1){
				sumZ11Km += Double.parseDouble(arr[i].substring(4));
			}
			if(arr[i].indexOf("Z12") != -1){
				sumZ12Km += Double.parseDouble(arr[i].substring(4));
			}
			if(arr[i].indexOf("Z13") != -1){
				sumZ13Km += Double.parseDouble(arr[i].substring(4));
			}
		}
		Scanner in = new Scanner(System.in);
		System.out.println("Выберите режим: 1 - расход одинаковый, 2 - расход разный");
		String mode = in.nextLine();
		if(mode.equals("1")){
			sumZ11liter = sumZ11Km / 100 * expence;
			sumZ12liter = sumZ12Km / 100 * expence;
			sumZ13liter = sumZ13Km / 100 * expence;
		}
		else if (mode.equals("2")){
			sumZ11liter = sumZ11Km / 100 * expenceZ11;
			sumZ12liter = sumZ12Km / 100 * expenceZ12;
			sumZ13liter = sumZ13Km / 100 * expenceZ13;
		}

		sumZ11 = sumZ11liter * fuelZ11;
		sumZ12 = sumZ11liter * fuelZ12;
		sumZ13 = sumZ11liter * fuelX13;
		if(sumZ11 > sumZ12) {
			if(sumZ11 > sumZ13) {
				max = "Z11";
				if(sumZ12 > sumZ13) min = "Z13";
				else min = "Z12";
			}
			else {
				min = "Z12";
				max = "Z13";
			}
		}
		else {
			if(sumZ12 > sumZ13){
				max = "Z12";
				if(sumZ11 > sumZ13) min = "Z13";
				else min = "Z11";
			}
			else {
				min = "Z11";
				max = "Z13";
			}
		}


		sum = sumZ11 + sumZ12 + sumZ13;
		System.out.println("Общий расход на ГСМ: " + sum);
		//System.out.println("Расход з11 " + sumZ11);
		//System.out.println("z12 " + sumZ12);
		//System.out.println("z13 " + sumZ13);
		System.out.println("\nmin " + min);
		System.out.println("max " + max);
    }
}
