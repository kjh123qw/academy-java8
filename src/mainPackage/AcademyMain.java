package mainPackage;

import java.util.Scanner;


public class AcademyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("************************************************************");
		System.out.println("***************** Academy Manager Ver 1.0.0 ****************");
		System.out.println("************************************************************");
		TeacherEngine te = TeacherEngine.getInstance();
		ClassEngine ce = ClassEngine.getInstance();
		StudentEngine se = StudentEngine.getInstance();
		ce.setInstances(te, se);
		te.setInstances(ce);
		se.setInstances(ce);
		Scanner sc = new Scanner(System.in);
		String input = "";
		while(true) {
			System.out.println("[MAIN MENU]");
			System.out.println(String.format("   1.%13s\n   2.%13s\n   3.%13s\n   4.%13s","Teacher", "Class", "Student", "Quit"));
			System.out.print("select number >> ");
			input = sc.nextLine();
			if(input.equals("4")) {
				System.out.println("Good bye~!");
				break;
			} else if(input.equals("1")) {
				te.teacherMain();
			} else if(input.equals("2")) {
				ce.classMain();
			} else if(input.equals("3")) {
				se.studentMain();
			} else {
				System.out.println("---------- err: wrong number");
			}
		}
		sc.close();
	}

}
