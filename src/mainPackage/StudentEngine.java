package mainPackage;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import mainPackage.DBUtil.State;
import mainPackage.TeacherEngine.Type;

public class StudentEngine {
	private ArrayList<Student> allStudentList = null;
	private static StudentEngine instance = new StudentEngine();
	private Scanner sc = new Scanner(System.in);
	private ClassEngine ce;
	public StudentEngine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static StudentEngine getInstance() {
		return instance;
	}
	
	public void setInstances(ClassEngine ce) {
		this.ce = ce;
	}
	
	public void studentMain() {
		String input = "";
		while(true) {
			System.out.println("************************************************************");
			System.out.println("[MAIN MENU] > [STUDENT]");
			System.out.println(String.format("   1.%13s\n   2.%13s\n   3.%13s\n   4.%13s\n   5.%13s\n   6.%13s", "Registration", "Modify-Info", "Modify-Class", "List", "Delete", "Back"));
			System.out.print("select number >> ");
			input = sc.nextLine();
			if(input.equals("6")) {
				break;
			} else if(input.equals("1")) {
				studentRegistration();
			} else if(input.equals("2")) {
				studentModify();
			} else if(input.equals("3")) {
				modifyStudentClassRegi();
			} else if(input.equals("4")) {
				studentList();
			} else if(input.equals("5")) {
				studentDelete();
			} else {
				System.out.println("---------- err: wrong number");
			}
		}
	}
	public void studentRegistration() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[MAIN MENU] > [STUDENT] > [REGISTRATION]");
		System.out.println("==> MSG: Registration of a student");
		ArrayList<Subject> targetClassList = new ArrayList<Subject>();
		String name = "";
		int age = 0;
		int tgSbId = 0;
		String input = "";
		int step = 0;
		while(true) {
			if(step == 0) {
				System.out.print(String.format("%s [back:!b] : ", "NAME (max 12)"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.STRING, 12, 2)) {
						name = input.replace(" ", "%20");
						step = 1;
					} else {
						System.out.println("  Err - only English 12 letters");
					}
				}
			} else if(step == 1) {
				System.out.print(String.format("%s [back:!b] : ", "AGE (numbers)"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, 150, 5)) {
						age = Integer.parseInt(input);
						step = 2;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 2) {
				ArrayList<Subject> tempSubjectList = JsonToObejct.subjectObjectArray(DBUtil.academyList(State.Apply));
		        for(int i = 0; i < tempSubjectList.size(); i++) {
		        	if(tempSubjectList.get(i).getTotal() > tempSubjectList.get(i).getStSize()) {
		        		targetClassList.add(tempSubjectList.get(i));
		        	}
		        }
				targetClassList = targetClassList.stream().sorted().collect(Collectors.toCollection(ArrayList<Subject>::new));
		        for(int i = 0; i < targetClassList.size(); i++) {
		        	System.out.println(String.format("   %2d. %s", i + 1, targetClassList.get(i)));
		        }
		        if(targetClassList.size() == 0) {
		        	System.out.println("!!!! We don't have a class. Please register new one.");
		        	return;
		        }
				System.out.print(String.format("%s [back:!b, skip:0] : ", "Select class"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.STRING, targetClassList.size(), -1)) {
						tgSbId = Integer.parseInt(input) - 1;
						step = 3;
					} else {
						System.out.println("  Err - only English 12 letters");
					}
				}
			} else if(step == 3) {
				String str = "/0/" + name + "/" + age;
				if(tgSbId != -1) {
					str += "/" + targetClassList.get(tgSbId).getId();
				}
				DBUtil.create(DBName.AS, str);
				System.out.println("Completed to register for database.");
				System.out.println("------------------------------------------------------------");
				allStudentList = null;
				ce.setListNull();
				break;
			}
		}
	}
	
	public void studentList() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[MAIN MENU] > [STUDENT] > [LIST]");
		System.out.println("==> MSG: Student list");
		if(allStudentList == null) {
			ArrayList<Student> tempStudentList = JsonToObejct.studentObjectArray(DBUtil.getList(DBName.AS));
			allStudentList = tempStudentList.stream().sorted().collect(Collectors.toCollection(ArrayList<Student>::new));
		} else {
			allStudentList = allStudentList.stream().sorted().collect(Collectors.toCollection(ArrayList<Student>::new));
		}
        for(Student st : allStudentList) {
            System.out.println(st);
        }
	}

	public void studentModify() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[MAIN MENU] > [STUDENT] > [MODIFY INFORMATION]");
		System.out.println("==> MSG: Modify a student");
		if(allStudentList == null) {
			ArrayList<Student> tempStudentList = JsonToObejct.studentObjectArray(DBUtil.getList(DBName.AS));
			allStudentList = tempStudentList.stream().sorted().collect(Collectors.toCollection(ArrayList<Student>::new));
		} else {
			allStudentList = allStudentList.stream().sorted().collect(Collectors.toCollection(ArrayList<Student>::new));
		}
        if(allStudentList.size() == 0) {
        	System.out.println("!!!! We don't have a student. Please register new student.");
        	return;
        }
        for(int i = 0; i < allStudentList.size(); i++) {
        	System.out.println(String.format("   %2d. %s", i + 1, allStudentList.get(i)));
        }
		String name = "";
		int age = 0;
		int tgId = 0;
		String input = "";
		int step = 0;
		while(true) {
			if(step == 0) {
				System.out.print(String.format("%s [back:!b] : ", "Select target number"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, allStudentList.size(), 0)) {
						tgId = Integer.parseInt(input) - 1;
						step = 1;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 1) {
				System.out.print(String.format("%s [back:!b] : ", "NAME (max 12)"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.STRING, 12, 2)) {
						name = input.replace(" ", "%20");
						step = 2;
					} else {
						System.out.println("  Err - only English 12 letters");
					}
				}
			} else if(step == 2) {
				System.out.print(String.format("%s [back:!b] : ", "AGE (numbers)"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, 150, 5)) {
						age = Integer.parseInt(input);
						step = 3;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 3) {
				String str = "/" + allStudentList.get(tgId).getId() + "/" + name + "/" + age;
				if(!allStudentList.get(tgId).getSubject().equals("")) {
					str += "/" + allStudentList.get(tgId).getSbid() + "/" + allStudentList.get(tgId).getSubject();
				}
				DBUtil.create(DBName.AS, str);
				System.out.println("Completed to register for database.");
				System.out.println("------------------------------------------------------------");
				allStudentList = null;
				break;
			}
		}
	}

//	public void studentClassRegi() {
//		System.out.println("------------------------------------------------------------");
//		System.out.println("[MAIN MENU] > [STUDENT] > [REGISTER CLASS]");
//		System.out.println("==> MSG: Student register class");
//        ArrayList<Student> targetStudentList = new ArrayList<Student>();
//        ArrayList<Subject> targetClassList = new ArrayList<Subject>();
//		if(allStudentList == null) {
//			ArrayList<Student> tempStudentList = JsonToObejct.studentObjectArray(DBUtil.getList(DBName.AS));
//			allStudentList = tempStudentList.stream().sorted().collect(Collectors.toCollection(ArrayList<Student>::new));
//		} else {
//			allStudentList = allStudentList.stream().sorted().collect(Collectors.toCollection(ArrayList<Student>::new));
//		}
//        for(int i = 0; i < allStudentList.size(); i++) {
//        	if(allStudentList.get(i).getSubject().equals("")) {
//        		targetStudentList.add(allStudentList.get(i));
//        	}
//        }
//        if(targetStudentList.size() == 0) {
//        	System.out.println("!!!! We don't have new student. Please register new student.");
//        	return;
//        }
//        for(int i = 0; i < targetStudentList.size(); i++) {
//    		System.out.println("   " + (i + 1) + ". " + targetStudentList.get(i));
//        }
//		int tgId = 0;
//		int tgSbId = 0;
//		String input = "";
//		int step = 0;
//		while(true) {
//			if(step == 0) {
//				System.out.print(String.format("%s [back:!b] : ", "Select teacher"));
//				input = sc.nextLine();
//				if(input.equals("!b")) {
//					break;
//				} else {
//					if(valInput(input, Type.INT, targetStudentList.size(), 0)) {
//						tgId = Integer.parseInt(input) - 1;
//						step = 1;
//					} else {
//						System.out.println("  Err - only numbers");
//					}
//				}
//			} else if(step == 1) {
//				ArrayList<Subject> tempSubjectList = JsonToObejct.subjectObjectArray(DBUtil.academyList(State.Apply));
//				targetClassList = tempSubjectList.stream().sorted().collect(Collectors.toCollection(ArrayList<Subject>::new));
//		        for(int i = 0; i < targetClassList.size(); i++) {
//	        		System.out.println("   " + (i + 1) + ". " + targetClassList.get(i));
//		        }
//		        if(targetClassList.size() == 0) {
//		        	System.out.println("!!!! We don't have a class. Please register new one.");
//		        	return;
//		        }
//				System.out.print(String.format("%s [back:!b] : ", "Select class"));
//				input = sc.nextLine();
//				if(input.equals("!b")) {
//					break;
//				} else {
//					if(valInput(input, Type.STRING, targetClassList.size(), 0)) {
//						tgSbId = Integer.parseInt(input) - 1;
//						step = 2;
//					} else {
//						System.out.println("  Err - only English 12 letters");
//					}
//				}
//			} else if(step == 2) { // /create/tc/{id}/{name}/{age}/{sbid}/{sb}
//				String str = "/" + targetStudentList.get(tgId).getId() + "/" + targetClassList.get(tgSbId).getId() + "/" + targetClassList.get(tgSbId).getSubject() + "/";
//				DBUtil.update(DBName.AS, str);
//				System.out.println("Completed to register for database.");
//				System.out.println("------------------------------------------------------------");
//				allStudentList = null;
//				break;
//			}
//		}
//	}

	public void modifyStudentClassRegi() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[MAIN MENU] > [STUDENT] > [MODIFY CLASS]");
		System.out.println("==> MSG: Student modify class");
        ArrayList<Subject> targetClassList = new ArrayList<Subject>();
		if(allStudentList == null) {
			ArrayList<Student> tempStudentList = JsonToObejct.studentObjectArray(DBUtil.getList(DBName.AS));
			allStudentList = tempStudentList.stream().sorted().collect(Collectors.toCollection(ArrayList<Student>::new));
		} else {
			allStudentList = allStudentList.stream().sorted().collect(Collectors.toCollection(ArrayList<Student>::new));
		}
        if(allStudentList.size() == 0) {
        	System.out.println("!!!! We don't have a student. Please register new student.");
        	return;
        }
        for(int i = 0; i < allStudentList.size(); i++) {
        	System.out.println(String.format("   %2d. %s", i + 1, allStudentList.get(i)));
        }
		int tgId = 0;
		int tgSbId = 0;
		String input = "";
		int step = 0;
		while(true) {
			if(step == 0) {
				System.out.print(String.format("%s [back:!b] : ", "Select teacher"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, allStudentList.size(), 0)) {
						tgId = Integer.parseInt(input) - 1;
						step = 1;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 1) {
				ArrayList<Subject> tempSubjectList = JsonToObejct.subjectObjectArray(DBUtil.academyList(State.Apply));
		        for(int i = 0; i < tempSubjectList.size(); i++) {
		        	if(tempSubjectList.get(i).getTotal() > tempSubjectList.get(i).getStSize()) {
		        		targetClassList.add(tempSubjectList.get(i));
		        	}
		        }
				targetClassList = targetClassList.stream().sorted().collect(Collectors.toCollection(ArrayList<Subject>::new));
		        for(int i = 0; i < targetClassList.size(); i++) {
		        	System.out.println(String.format("   %2d. %s", i + 1, targetClassList.get(i)));
		        }
		        if(targetClassList.size() == 0) {
		        	System.out.println("!!!! We don't have a class. Please register new one.");
		        	return;
		        }
				System.out.print(String.format("%s [back:!b] : ", "Select class"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.STRING, targetClassList.size(), 0)) {
						tgSbId = Integer.parseInt(input) - 1;
						step = 2;
					} else {
						System.out.println("  Err - only English 12 letters");
					}
				}
			} else if(step == 2) {
				String str = "/" + allStudentList.get(tgId).getId() + "/" + targetClassList.get(tgSbId).getId();
				DBUtil.update(DBName.AS, str);
				System.out.println("Completed to register for database.");
				System.out.println("------------------------------------------------------------");
				allStudentList = null;
				ce.setListNull();
				break;
			}
		}
	}

	public void studentDelete() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[MAIN MENU] > [TEACHER] > [DELETE]");
		System.out.println("==> MSG: Registration of a teacher");
		if(allStudentList == null) {
			ArrayList<Student> tempTeacherList = JsonToObejct.studentObjectArray(DBUtil.getList(DBName.AS));
			allStudentList = tempTeacherList.stream().sorted().collect(Collectors.toCollection(ArrayList<Student>::new));
		} else {
			allStudentList = allStudentList.stream().sorted().collect(Collectors.toCollection(ArrayList<Student>::new));
		}
        for(int i = 0; i < allStudentList.size(); i++) {
        	System.out.println(String.format("   %2d. %s", i + 1, allStudentList.get(i)));
        }
		int tgId = -1;
		String input = "";
		while(tgId == -1) {
			System.out.print(String.format("%s [back:!b] : ", "Select target number"));
			input = sc.nextLine();
			if(input.equals("!b")) {
				return;
			} else {
				if(valInput(input, Type.INT, allStudentList.size(), 0)) {
					tgId = Integer.parseInt(input) - 1;
				} else {
					System.out.println("  Err - only numbers");
				}
			}
		}
		DBUtil.delete(DBName.AS, allStudentList.get(tgId).getId());
		System.out.println("Completed to delete for database.");
		System.out.println("------------------------------------------------------------");
		setListNull();
		ce.setListNull();
	}
	
	public boolean valInput(String input, Type type, int limit, int less) {
		// TODO Auto-generated method stub
//		입력값 체크 메서드
//		inp 입력값 / type 확인 타입 / [type("int")]limit 입력값 까지 가능 / [type("String")]limit 글자수 까지 가능
	    boolean retVal = false;
	    int inpNum = 0;
	    if(type.equals(Type.INT)) {
	    	try {
	    		inpNum = Integer.parseInt(input); 
	    		if(less <= inpNum && inpNum <= limit) {
	    			retVal = true;
	    		}
	    	} catch(Exception e) {
//	    		e.printStackTrace();
	    	}
	    } else if (type.equals(Type.STRING)) {
	    	if(less < input.length() && input.length() <= limit) {
	    		retVal = true;
	    	}
	    }
		
		return retVal;
	}
	public void setListNull() {
		allStudentList = null;
	}
}
