package mainPackage;

public class Student implements Comparable<Student> {
	private String id;
	private String name;
	private int age;
	private String sbid;
	private String subject;
	
	public Student(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sbid = "";
		this.subject = "";
	}
	
	public Student(String id, String name, int age, String sbid, String subject) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sbid = sbid;
		this.subject = subject;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSbid() {
		return sbid;
	}
	public void setSbid(String sbid) {
		this.sbid = sbid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Name: %12s | Age: %3d | Subject: %10s", name, age, subject);
	}

	@Override
    public int compareTo(Student o) {
        return Integer.compare(Integer.parseInt(this.id), Integer.parseInt(o.getId()));
    }
	
}
