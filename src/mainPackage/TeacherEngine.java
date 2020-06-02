package mainPackage;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TeacherEngine {
	public enum Type { INT, STRING }
	private ArrayList<Teacher> teacherList = null;
	private static TeacherEngine instance = new TeacherEngine();
	private Scanner sc = new Scanner(System.in);
	private ClassEngine ce;
	public TeacherEngine() {
		super();
		ce = ClassEngine.getInstance();
		// TODO Auto-generated constructor stub
	}
	
	public static TeacherEngine getInstance() {
		return instance;
	}
	
	public void setInstances(ClassEngine ce) {
		this.ce = ce;
	}
	
	public ArrayList<Teacher> getTeacherList() {
		if(teacherList == null) {
			ArrayList<Teacher> tempTeacherList = JsonToObejct.teacherObjectArray(DBUtil.getList(DBName.AT));
			teacherList = tempTeacherList.stream().sorted().collect(Collectors.toCollection(ArrayList<Teacher>::new));
		} else {
			teacherList = teacherList.stream().sorted().collect(Collectors.toCollection(ArrayList<Teacher>::new));
		}
		return teacherList;
	}
	
	public void teacherMain() {
		String input = "";
		while(true) {
			System.out.println("************************************************************");
			System.out.println("[MAIN MENU] > [TEACHER]");
			System.out.println(String.format("   1.%13s\n   2.%13s\n   3.%13s\n   4.%13s\n   5.%13s\n   6.%13s","Registration", "Modify", "Regi-Class", "List", "Delete", "Back"));
			System.out.print("select number >> ");
			input = sc.nextLine();
			if(input.equals("6")) {
				break;
			} else if(input.equals("1")) {
				teacherRegistration();
			} else if(input.equals("2")) {
				teacherModify();
			} else if(input.equals("3")) {
				teacherClassRegi();
			} else if(input.equals("4")) {
				teacherList();
			} else if(input.equals("5")) {
				teacherDelete();
			} else {
				System.out.println("---------- err: wrong number");
			}
		}
	}
	
	public void teacherRegistration() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[MAIN MENU] > [TEACHER] > [REGISTRATION]");
		System.out.println("==> MSG: Registration of a teacher");
		String name = "";
		int age = 0;
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
				String str = "/0/" + name + "/" + age;
				DBUtil.create(DBName.AT, str);
				System.out.println("Completed to register for database.");
				System.out.println("------------------------------------------------------------");
				teacherList = null;
				break;
			}
		}
	}
	public void teacherList() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[MAIN MENU] > [TEACHER] > [LIST]");
		System.out.println("==> MSG: Teacher list");
		if(teacherList == null) {
			ArrayList<Teacher> tempTeacherList = JsonToObejct.teacherObjectArray(DBUtil.getList(DBName.AT));
			teacherList = tempTeacherList.stream().sorted().collect(Collectors.toCollection(ArrayList<Teacher>::new));
		} else {
			teacherList = teacherList.stream().sorted().collect(Collectors.toCollection(ArrayList<Teacher>::new));
		}
        for(int i = 0; i < teacherList.size(); i++) {
        	System.out.println(String.format("   %2d. %s", i + 1, teacherList.get(i)));
        }
		int tgId = -1;
		String input = "";
		while(tgId == -1) {
			System.out.print(String.format("%s [back:!b] : ", "Select target number"));
			input = sc.nextLine();
			if(input.equals("!b")) {
				return;
			} else {
				if(valInput(input, Type.INT, teacherList.size(), 0)) {
					tgId = Integer.parseInt(input) - 1;
				} else {
					System.out.println("  Err - only numbers");
				}
			}
		}
		System.out.println("------------------------------------------------------------");
		System.out.println("[MAIN MENU] > [TEACHER] > [LIST] > [DETAILS]");
		System.out.println(teacherList.get(tgId));
		if(!teacherList.get(tgId).getSbid().equals("")) {
			String[] ids = teacherList.get(tgId).getSbid().split(", ");
			for(int i = 0; i < ids.length; i++) {
				System.out.println(JsonToObejct.subjectObject(DBUtil.getItem(DBName.A, ids[i])));
			}
		} else {
			System.out.println("There is not a class.");
		}
	}
	
	public void teacherModify() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[MAIN MENU] > [TEACHER] > [MODIFY]");
		System.out.println("==> MSG: Modify a teacher");
		ArrayList<Subject> classList = null;
		if(teacherList == null) {
			ArrayList<Teacher> tempTeacherList = JsonToObejct.teacherObjectArray(DBUtil.getList(DBName.AT));
			teacherList = tempTeacherList.stream().sorted().collect(Collectors.toCollection(ArrayList<Teacher>::new));
		} else {
			teacherList = teacherList.stream().sorted().collect(Collectors.toCollection(ArrayList<Teacher>::new));
		}
        if(teacherList.size() == 0) {
        	System.out.println("!!!! We don't have a teacher. Please register new teacher.");
        	return;
        }
        for(int i = 0; i < teacherList.size(); i++) {
        	System.out.println(String.format("   %2d. %s", i + 1, teacherList.get(i)));
        }
		String name = "";
		int age = 0;
		int tgId = 0;
		int tgSbId = 0;
		String input = "";
		int step = 0;
		while(true) {
			if(step == 0) {
				System.out.print(String.format("%s [back:!b] : ", "Select target number"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.INT, teacherList.size(), 0)) {
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
				classList = ce.getClassList();
		        if(classList.size() == 0) {
		        	System.out.println("!!!! We don't have any class. Please register new class.");
		        	return;
		        }
		        for(int i = 0; i < classList.size(); i++) {
		        	System.out.println(String.format("   %2d. %s", i + 1, classList.get(i)));
		        }
				System.out.print(String.format("%s [back:!b, skip:0] : ", "Select class"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.STRING, classList.size(), -1)) {
						tgSbId = Integer.parseInt(input) - 1;
						step = 4;
					} else {
						System.out.println("  Err - only English 12 letters");
					}
				}
			} else if(step == 4) {
				String str = "/" + teacherList.get(tgId).getId() + "/" + name + "/" + age;
				DBUtil.create(DBName.AT, str);
				if(tgSbId != -1) {
					String str2 = "/" + classList.get(tgSbId).getId() + "/" + teacherList.get(tgId).getId();
					DBUtil.update(DBName.A, str2);
				}
				System.out.println("Completed to register for database.");
				System.out.println("------------------------------------------------------------");
				teacherList = null;
				ce.setListNull();
				break;
			}
		}
	}
	
	public void teacherClassRegi() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[MAIN MENU] > [TEACHER] > [REGISTER CLASS]");
		System.out.println("==> MSG: Teacher register class");
		ArrayList<Subject> classList = null;
		if(teacherList == null) {
			ArrayList<Teacher> tempTeacherList = JsonToObejct.teacherObjectArray(DBUtil.getList(DBName.AT));
			teacherList = tempTeacherList.stream().sorted().collect(Collectors.toCollection(ArrayList<Teacher>::new));
		} else {
			teacherList = teacherList.stream().sorted().collect(Collectors.toCollection(ArrayList<Teacher>::new));
		}
        if(teacherList.size() == 0) {
        	System.out.println("!!!! We don't have any teacher. Please register new teacher.");
        	return;
        }
        for(int i = 0; i < teacherList.size(); i++) {
        	System.out.println(String.format("   %2d. %s", i + 1, teacherList.get(i)));
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
					if(valInput(input, Type.INT, teacherList.size(), 0)) {
						tgId = Integer.parseInt(input) - 1;
						step = 1;
					} else {
						System.out.println("  Err - only numbers");
					}
				}
			} else if(step == 1) {
				classList = ce.getClassList();
		        if(classList.size() == 0) {
		        	System.out.println("!!!! We don't have any class. Please register new class.");
		        	return;
		        }
		        for(int i = 0; i < classList.size(); i++) {
		        	System.out.println(String.format("   %2d. %s", i + 1, classList.get(i)));
		        }
				System.out.print(String.format("%s [back:!b] : ", "Select class"));
				input = sc.nextLine();
				if(input.equals("!b")) {
					break;
				} else {
					if(valInput(input, Type.STRING, classList.size(), 0)) {
						tgSbId = Integer.parseInt(input) - 1;
						step = 2;
					} else {
						System.out.println("  Err - only English 12 letters");
					}
				}
			} else if(step == 2) {
				String str = "/" + classList.get(tgSbId).getId() + "/" + teacherList.get(tgId).getId();
				DBUtil.update(DBName.A, str);
				System.out.println("Completed to register for database.");
				System.out.println("------------------------------------------------------------");
				teacherList = null;
				ce.setListNull();
				break;
			}
		}
	}
	
	public void teacherDelete() {
		System.out.println("------------------------------------------------------------");
		System.out.println("[MAIN MENU] > [TEACHER] > [DELETE]");
		System.out.println("==> MSG: Registration of a teacher");
		if(teacherList == null) {
			ArrayList<Teacher> tempTeacherList = JsonToObejct.teacherObjectArray(DBUtil.getList(DBName.AT));
			teacherList = tempTeacherList.stream().sorted().collect(Collectors.toCollection(ArrayList<Teacher>::new));
		} else {
			teacherList = teacherList.stream().sorted().collect(Collectors.toCollection(ArrayList<Teacher>::new));
		}
        for(int i = 0; i < teacherList.size(); i++) {
        	System.out.println(String.format("   %2d. %s", i + 1, teacherList.get(i)));
        }
		int tgId = -1;
		String input = "";
		while(tgId == -1) {
			System.out.print(String.format("%s [back:!b] : ", "Select target number"));
			input = sc.nextLine();
			if(input.equals("!b")) {
				return;
			} else {
				if(valInput(input, Type.INT, teacherList.size(), 0)) {
					tgId = Integer.parseInt(input) - 1;
				} else {
					System.out.println("  Err - only numbers");
				}
			}
		}
		DBUtil.delete(DBName.AT, teacherList.get(tgId).getId());
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
		teacherList = null;
	}
}
