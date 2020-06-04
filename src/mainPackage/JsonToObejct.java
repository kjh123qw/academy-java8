package mainPackage;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonToObejct {
	
	public static Teacher teacherObject(String str){
		JSONParser parser = new JSONParser();
		JSONObject jobj;
		Teacher tc = null;
		
		try {
			jobj = (JSONObject)parser.parse(str);
			JSONObject tempJobj = (JSONObject)jobj.get("Item");
			String id = (String)tempJobj.get("Id");
			if(!id.equals("0")) {
				String sbid = "";
				String subject = "";
    			String name = (String)tempJobj.get("Name");
    			int age = Integer.parseInt(tempJobj.get("Age").toString());
    			JSONArray arrayJ2 = (JSONArray)tempJobj.get("Subjects");
    			if(arrayJ2.size() != 0) {
    				for(int j = 0; j < arrayJ2.size(); j++) {
	        			JSONObject tempJobj2 = (JSONObject)arrayJ2.get(j);
	        			if(j != 0) {
	        				subject += ", ";
	        				sbid += ", ";
	        			}
	        			subject += (String)tempJobj2.get("Subject");
	        			sbid += (String)tempJobj2.get("Id");
    				}
	    			tc = new Teacher(id, name, age, sbid, subject);
    			} else {
	    			tc = new Teacher(id, name, age);
    			}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tc;
	}
	
	public static Subject subjectObject(String str){
		JSONParser parser = new JSONParser();
		JSONObject jobj;
		Subject sb = null;
		
		try {
			jobj = (JSONObject)parser.parse(str);
			JSONObject tempJobj = (JSONObject)jobj.get("Item");
			String id = (String)tempJobj.get("Id");
			if(!id.equals("0")) {
				String tcid = (String)tempJobj.get("TcId");
				String teacherName = (String)tempJobj.get("TcName");
    			String subject = (String)tempJobj.get("Subject");
    			JSONObject infoJobj = (JSONObject)tempJobj.get("Info");
    			int total = Integer.parseInt(infoJobj.get("Total").toString());
    			int startApply = Integer.parseInt(infoJobj.get("StartApply").toString());
    			int endApply = Integer.parseInt(infoJobj.get("EndApply").toString());
    			int startDay = Integer.parseInt(infoJobj.get("StartDay").toString());
    			int endDay = Integer.parseInt(infoJobj.get("EndDay").toString());
    			int time = Integer.parseInt(infoJobj.get("Time").toString());
    			int stSize = Integer.parseInt(tempJobj.get("StSize").toString());
    			sb = new Subject(id, subject, total, startApply, endApply, startDay, endDay, time, stSize, tcid, teacherName);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;
	}

	public static Student studentObject(String str){
		JSONParser parser = new JSONParser();
		JSONObject jobj;
		Student st = null;
		
		try {
			jobj = (JSONObject)parser.parse(str);
			JSONObject tempJobj = (JSONObject)jobj.get("Item");
			String id = (String)tempJobj.get("Id");
			if(!id.equals("0")) {
				String sbid = (String)tempJobj.get("SbId");
				String subject = (String)tempJobj.get("SbTitle");
    			String name = (String)tempJobj.get("Name");
    			int age = Integer.parseInt(tempJobj.get("Age").toString());
    			st = new Student(id, name, age, sbid, subject);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}
	public static ArrayList<Teacher> teacherObjectArray(String str){
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		JSONParser parser = new JSONParser();
		JSONObject jobj;
		JSONArray arrayJ;
		
		try {
			jobj = (JSONObject)parser.parse(str);
			arrayJ = (JSONArray)jobj.get("Items");
            for(int i = 0; i < arrayJ.size(); i++) {
    			JSONObject tempJobj = (JSONObject)arrayJ.get(i);
    			String id = (String)tempJobj.get("Id");
    			if(!id.equals("0")) {
    				String sbid = "";
    				String subject = "";
    				Teacher tc = null;
	    			String name = (String)tempJobj.get("Name");
	    			int age = Integer.parseInt(tempJobj.get("Age").toString());
	    			JSONArray arrayJ2 = (JSONArray)tempJobj.get("Subjects");
	    			if(arrayJ2.size() != 0) {
	    				for(int j = 0; j < arrayJ2.size(); j++) {
		        			JSONObject tempJobj2 = (JSONObject)arrayJ2.get(j);
		        			if(j != 0) {
		        				subject += ", ";
		        				sbid += ", ";
		        			}
		        			subject += (String)tempJobj2.get("Subject");
		        			sbid += (String)tempJobj2.get("Id");
	    				}
		    			tc = new Teacher(id, name, age, sbid, subject);
	    			} else {
		    			tc = new Teacher(id, name, age);
	    			}
	    			teacherList.add(tc);
    			}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return teacherList;
	}
	
	public static ArrayList<Subject> subjectObjectArray(String str){
		ArrayList<Subject> subjectList = new ArrayList<Subject>();
		JSONParser parser = new JSONParser();
		JSONObject jobj;
		JSONArray arrayJ;

		try {
			jobj = (JSONObject)parser.parse(str);
			arrayJ = (JSONArray)jobj.get("Items");
            for(int i = 0; i < arrayJ.size(); i++) {
    			JSONObject tempJobj = (JSONObject)arrayJ.get(i);
    			String id = (String)tempJobj.get("Id");
    			if(!id.equals("0")) {
    				String tcid = (String)tempJobj.get("TcId");
    				String teacherName = (String)tempJobj.get("TcName");
	    			String subject = (String)tempJobj.get("Subject");
	    			JSONObject infoJobj = (JSONObject)tempJobj.get("Info");
	    			int total = Integer.parseInt(infoJobj.get("Total").toString());
	    			int startApply = Integer.parseInt(infoJobj.get("StartApply").toString());
	    			int endApply = Integer.parseInt(infoJobj.get("EndApply").toString());
	    			int startDay = Integer.parseInt(infoJobj.get("StartDay").toString());
	    			int endDay = Integer.parseInt(infoJobj.get("EndDay").toString());
	    			int time = Integer.parseInt(infoJobj.get("Time").toString());
	    			int stSize = Integer.parseInt(tempJobj.get("StSize").toString());
	    			Subject sb = new Subject(id, subject, total, startApply, endApply, startDay, endDay, time, stSize, tcid, teacherName);
	    			subjectList.add(sb);
    			}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return subjectList;
	}
	
	public static ArrayList<Student> studentObjectArray(String str){
		ArrayList<Student> studentList = new ArrayList<Student>();
		JSONParser parser = new JSONParser();
		JSONObject jobj;
		JSONArray arrayJ;
		
		try {
			jobj = (JSONObject)parser.parse(str);
			arrayJ = (JSONArray)jobj.get("Items");
            for(int i = 0; i < arrayJ.size(); i++) {
    			JSONObject tempJobj = (JSONObject)arrayJ.get(i);
    			String id = (String)tempJobj.get("Id");
    			if(!id.equals("0")) {
    				Student st = null;
    				String sbid = (String)tempJobj.get("SbId");
    				String subject = (String)tempJobj.get("SbTitle");
	    			String name = (String)tempJobj.get("Name");
	    			int age = Integer.parseInt(tempJobj.get("Age").toString());
	    			st = new Student(id, name, age, sbid, subject);
	    			studentList.add(st);
    			}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return studentList;
	}
}
