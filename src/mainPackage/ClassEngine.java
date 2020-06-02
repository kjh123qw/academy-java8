package mainPackage;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import mainPackage.DBUtil.State;

public class ClassEngine {
	public enum Type { INT, STRING }
	private ArrayList<Subject> allClassList = null;
	private ArrayList<Subject> applyClassList = null;
	private ArrayList<Subject> expectedClassList = null;
	private ArrayList<Subject> aeClassList = null;
	private static ClassEngine instance = new ClassEngine();
	private Scanner sc = new Scanner(System.in);
	private TeacherEngine te;
	private StudentEngine se;
	public ClassEngine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static ClassEngine getInstance() {
		return instance;
	}
	
	public void setInstances(TeacherEngine te, StudentEngine se) {
		this.te = te;
		this.se = se;
	}
	
	public ArrayList<Subject> getClassList() {
		if(allClassList == null) {
			ArrayList<Subject> tempclassList = JsonToObejct.subjectObjectArray(DBUtil.academyList(State.All));
			allClassList = tempclassList.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
		} else {
			allClassList = allClassList.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
		}
		return allClassList;
	}
	
	public void classMain() {
		String input = "";
		while(true) {
			System.out.println("************************************************************");
			System.out.println("[MAIN MENU] > [CLASS]");
			System.out.println(String.format("   1.%13s\n   2.%13s\n   3.%13s\n   4.%13s\n   5.%13s\n   6.%13s","Registration", "Modify", "Apply List", "All List", "Delete", "Back"));
			System.out.print("select number >> ");
			input = sc.nextLine();
			if(input.equals("6")) {
				break;
			} else if(input.equals("1")) {
				classRegistration();
			} else if(input.equals("2")) {
				classModify();
			} else if(input.equals("3")) {
				classList();
			} else if(input.equals("4")) {
				classAllList();
			} else if(input.equals("5")) {
				classDelete();
			} else {
				System.out.println("---------- err: wrong number");
			}
		}
	}
	
	public void classRegistration() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[MAIN MENU] > [CLASS] > [REGISTRATION]");
		System.out.println("==> MSG: Register a class");
		String name = "";
		int total = 0;
		int sa = 0;
		int ea = 0;
		int sd = 0;
		int ed = 0;
		int tm = 0;
		String input = "";
		int step = 0;
		while(true) {
			if(step == 0) {
				System.out.print(String.format("%s [back:!b] : ", "SUBJECT (max 12)"));
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
				System.out.print(String.format("%s [back:!b] : ", "TOTAL (Maximum numbers)"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, 150, 5)) {
						total = Integer.parseInt(input);
						step = 2;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 2) {
				System.out.print(String.format("%s [back:!b] : ", "START APPLY (ex> 20200522)"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, 21000101, 20200101)) {
						sa = Integer.parseInt(input);
						step = 3;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 3) {
				System.out.print(String.format("%s [back:!b] : ", "END APPLY (ex> 20200522)"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, 21000101, 20200101)) {
						ea = Integer.parseInt(input);
						step = 4;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 4) {
				System.out.print(String.format("%s [back:!b] : ", "START DAY (ex> 20200522)"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, 21000101, 20200101)) {
						sd = Integer.parseInt(input);
						step = 5;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 5) {
				System.out.print(String.format("%s [back:!b] : ", "END DAY (ex> 20200522)"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, 21000101, 20200101)) {
						ed = Integer.parseInt(input);
						step = 6;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 6) {
				System.out.print(String.format("%s [back:!b] : ", "TIME (0, 1, 2)"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, 2, -1)) {
						tm = Integer.parseInt(input);
						step = 7;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 7) {
				String str = "/0/" + name + "/" + total + "/" + sa + "/" + ea + "/" + sd + "/" + ed + "/" + tm;
				DBUtil.create(DBName.A, str);
				System.out.println("Completed to register for database.");
				System.out.println("------------------------------------------------------------");
				setListNull();
				break;
			}
		}
	}
	public void classList() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[MAIN MENU] > [CLASS] > [LIST]");
		System.out.println("==> MSG: class list");
		System.out.println("    <Class you can apply>");
		if(applyClassList == null) {
			ArrayList<Subject> tempclassList = JsonToObejct.subjectObjectArray(DBUtil.academyList(State.Apply));
			applyClassList = tempclassList.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
		} else {
			applyClassList = applyClassList.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
		}
		if(applyClassList.size() == 0) {
			System.out.println("No List.");
		} else {
	        for(Subject sb : applyClassList) {
	            System.out.println(sb);
	        }
        }
		System.out.println("    <Class schedule>");
		if(expectedClassList == null) {
			ArrayList<Subject> tempclassList = JsonToObejct.subjectObjectArray(DBUtil.academyList(State.Expected));
			expectedClassList = tempclassList.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
		} else {
			expectedClassList = expectedClassList.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
		}
		if(expectedClassList.size() == 0) {
			System.out.println("No List.");
		} else {
	        for(Subject sb : expectedClassList) {
	            System.out.println(sb);
	        }
		}
	}
	public void classAllList() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[MAIN MENU] > [CLASS] > [ALL LIST]");
		System.out.println("==> MSG: all class list");
		if(allClassList == null) {
			ArrayList<Subject> tempclassList = JsonToObejct.subjectObjectArray(DBUtil.academyList(State.All));
			allClassList = tempclassList.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
		} else {
			allClassList = allClassList.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
		}
		if(allClassList.size() == 0) {
			System.out.println("No List.");
		} else {
	        for(Subject sb : allClassList) {
	            System.out.println(sb);
	        }
        }
	}
	
	public void classModify() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[MAIN MENU] > [CLASS] > [MODIFY]");
		System.out.println("==> MSG: Modify a class");
		if(aeClassList == null) {
			ArrayList<Subject> tempclassList = JsonToObejct.subjectObjectArray(DBUtil.academyList(State.Apply));
			tempclassList.addAll(JsonToObejct.subjectObjectArray(DBUtil.academyList(State.Expected)));
			aeClassList = tempclassList.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
		} else {
			aeClassList = aeClassList.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
		}
        if(aeClassList.size() == 0) {
        	System.out.println("!!!! We don't have any class. Please register new class.");
        	return;
        }
        for(int i = 0; i < aeClassList.size(); i++) {
        	System.out.println(String.format("   %2d. %s", i + 1, aeClassList.get(i)));
        }
		String name = "";
		int total = 0;
		int sa = 0;
		int ea = 0;
		int sd = 0;
		int ed = 0;
		int tm = 0;
		int tgId = 0;
		String input = "";
		int step = 0;
		while(true) {
			if(step == 0) {
				System.out.print(String.format("%s [back:!b] : ", "Select target class number"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, aeClassList.size(), 0)) {
						tgId = Integer.parseInt(input) - 1;
						step = 1;
					} else {
						System.out.println("  Err - only English 12 letters");
					}
				}
			} else if(step == 1) {
				System.out.print(String.format("%s [back:!b] : ", "SUBJECT (max 12)"));
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
				System.out.print(String.format("%s [back:!b] : ", "TOTAL (Maximum numbers)"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, 150, 5)) {
						total = Integer.parseInt(input);
						step = 3;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 3) {
				System.out.print(String.format("%s [back:!b] : ", "START APPLY (ex> 20200522)"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, 21000101, 20200101)) {
						sa = Integer.parseInt(input);
						step = 4;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 4) {
				System.out.print(String.format("%s [back:!b] : ", "END APPLY (ex> 20200522)"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, 21000101, 20200101)) {
						ea = Integer.parseInt(input);
						step = 5;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 5) {
				System.out.print(String.format("%s [back:!b] : ", "START DAY (ex> 20200522)"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, 21000101, 20200101)) {
						sd = Integer.parseInt(input);
						step = 6;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 6) {
				System.out.print(String.format("%s [back:!b] : ", "END DAY (ex> 20200522)"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, 21000101, 20200101)) {
						ed = Integer.parseInt(input);
						step = 7;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 7) {
				System.out.print(String.format("%s [back:!b] : ", "TIME (0, 1, 2)"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, 2, -1)) {
						tm = Integer.parseInt(input);
						step = 8;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 8) {
				String str = "/" + aeClassList.get(tgId).getId() + "/" + name + "/" + total + "/" + sa + "/" + ea + "/" + sd + "/" + ed + "/" + tm;
				if(!aeClassList.get(tgId).getTeacherName().equals("")) {
					str += "/" + aeClassList.get(tgId).getTcid();
				}
				DBUtil.create(DBName.A, str);
				System.out.println("Completed to register for database.");
				System.out.println("------------------------------------------------------------");
				setListNull();
				te.setListNull();
				se.setListNull();
				break;
			}
		}
	}
//	
//	public void classTeacherRegi() {
//		System.out.println("------------------------------------------------------------");
//		System.out.println("[MAIN MENU] > [CLASS] > [TEACHER REGISTER]");
//		System.out.println("==> MSG: Class register teacher");
//		ArrayList<Subject> targetClassList = new ArrayList<Subject>();
//		ArrayList<Teacher> targetTeacherList = new ArrayList<Teacher>();
//		if(allClassList == null) {
//			ArrayList<Subject> tempclassList = JsonToObejct.subjectObjectArray(DBUtil.academyList(State.All));
//			allClassList = tempclassList.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
//		} else {
//			allClassList = allClassList.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
//		}
//        for(int i = 0; i < allClassList.size(); i++) {
//        	if(allClassList.get(i).getTeacherName().equals("")) {
//        		targetClassList.add(allClassList.get(i));
//        	}
//        }
//        if(targetClassList.size() == 0) {
//        	System.out.println("!!!! We don't have any class. Please register new class.");
//        	return;
//        }
//        for(int i = 0; i < targetClassList.size(); i++) {
//    		System.out.println("   " + (i + 1) + ". " + targetClassList.get(i));
//        }
//		int tgId = 0;
//		int tgTcId = 0;
//		String input = "";
//		int step = 0;
//		while(true) {
//			if(step == 0) {
//				System.out.print(String.format("%s [back:!b] : ", "Select target class number"));
//				input = sc.nextLine();
//				if(input.equals("!b")) {
//					break;
//				} else {
//					if(valInput(input, Type.INT, targetClassList.size(), 0)) {
//						tgId = Integer.parseInt(input) - 1;
//						step = 1;
//					} else {
//						System.out.println("  Err - only numbers");
//					}
//				}
//			} else if(step == 1) {
//				TeacherEngine tete = new TeacherEngine();
//				ArrayList<Teacher> teacherList = tete.getTeacherList();
//		        for(int i = 0; i < teacherList.size(); i++) {
//		        	if(teacherList.get(i).getSubject().equals("")) {
//		        		targetTeacherList.add(teacherList.get(i));
//		        	}
//		        }
//		        if(targetTeacherList.size() == 0) {
//		        	System.out.println("!!!! We don't have any teacher. Please register new teacher.");
//		        	return;
//		        }
//		        for(int i = 0; i < targetTeacherList.size(); i++) {
//	        		System.out.println("   " + (i + 1) + ". " + targetTeacherList.get(i));
//		        }
//				System.out.print(String.format("%s [back:!b] : ", "Select teacher"));
//				input = sc.nextLine();
//				if(input.equals("!b")) {
//					break;
//				} else {
//					if(valInput(input, Type.INT, targetTeacherList.size(), 0)) {
//						tgTcId = Integer.parseInt(input) - 1;
//						step = 2;
//					} else {
//						System.out.println("  Err - only English 12 letters");
//					}
//				}
//			} else if(step == 2) {
//				String str = "/" + targetTeacherList.get(tgTcId).getId() + "/" + targetClassList.get(tgId).getId() + "/" + targetClassList.get(tgId).getSubject() + "/";
//				String str2 = "/" + targetClassList.get(tgId).getId() + "/" + targetTeacherList.get(tgTcId).getId() + "/" + targetTeacherList.get(tgTcId).getName() + "/";
//				DBUtil.update(DBName.AT, str);
//				DBUtil.update(DBName.A, str2);
//				System.out.println("Completed to register for database.");
//				System.out.println("------------------------------------------------------------");
//				setListNull();
//				te.setListNull();
//				se.setListNull();
//				break;
//			}
//		}
//	}

	public void classDelete() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[MAIN MENU] > [TEACHER] > [DELETE]");
		System.out.println("==> MSG: Registration of a teacher");
		if(allClassList == null) {
			ArrayList<Subject> tempTeacherList = JsonToObejct.subjectObjectArray(DBUtil.academyList(State.All));
			allClassList = tempTeacherList.stream().sorted().collect(Collectors.toCollection(ArrayList<Subject>::new));
		} else {
			allClassList = allClassList.stream().sorted().collect(Collectors.toCollection(ArrayList<Subject>::new));
		}
        for(int i = 0; i < allClassList.size(); i++) {
        	System.out.println(String.format("   %2d. %s", i + 1, allClassList.get(i)));
        }
		int tgId = -1;
		String input = "";
		while(tgId == -1) {
			System.out.print(String.format("%s [back:!b] : ", "Select target number"));
			input = sc.nextLine();
			if(input.equals("!b")) {
				return;
			} else {
				if(valInput(input, Type.INT, allClassList.size(), 0)) {
					tgId = Integer.parseInt(input) - 1;
				} else {
					System.out.println("  Err - only numbers");
				}
			}
		}
		DBUtil.delete(DBName.A, allClassList.get(tgId).getId());
		System.out.println("Completed to delete for database.");
		System.out.println("------------------------------------------------------------");
		setListNull();
		te.setListNull();
		se.setListNull();
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
		allClassList = null;
		applyClassList = null;
		expectedClassList = null;
		aeClassList = null;
	}
}
