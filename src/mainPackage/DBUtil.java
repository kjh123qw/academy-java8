package mainPackage;

public class DBUtil {
	public enum State {
		All, Apply, Not, Expected
	}

	private static final String URL = "https://31vmfl2fk8.execute-api.ap-northeast-2.amazonaws.com/default/";
	
	public static String getItem(DBName db, String id) {
		String newUrl = URL + db.getFullName() + "/" + id;
//		System.out.println(newUrl);
		return ApiCall.get(newUrl);
	}
	
	public static String getList(DBName db) {
		String newUrl = URL + db.getFullName() + "/list/";
//		System.out.println(newUrl);
		return ApiCall.get(newUrl);
	}
	
	public static String academyList(State state) {
		String newUrl = URL + DBName.A.getFullName() + "/list/" + state;
//		System.out.println(newUrl);
		return ApiCall.get(newUrl);
	}
	
	public static String create(DBName db, String strArr) {
		String newUrl = URL + "create/" + db.getCreateName() + strArr;
//		System.out.println(newUrl);
		return ApiCall.post(newUrl);
	}
	
	public static String update(DBName db, String strArr) {
		String newUrl = URL + "create/update/" + db.getCreateName() + strArr;
//		System.out.println(newUrl);
		return ApiCall.post(newUrl);
	}
	
	public static String delete(DBName db, String id) {
		String newUrl = URL + db.getFullName()  + "/delete/" + id;
//		System.out.println(newUrl);
		return ApiCall.post(newUrl);
	}
}
