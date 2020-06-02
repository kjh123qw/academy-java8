package mainPackage;

public class Subject implements Comparable<Subject> {
	private String id;
	private String subject;
	private int total;
	private int startApply;
	private int endApply;
	private int startDay;
	private int endDay;
	private int time;
	private String tcid;
	private String teacherName;
	private int stSize;
	
	public Subject(String id, String subject, int total, int startApply, int endApply, int startDay, int endDay, int time, int stSize) {
		super();
		this.id = id;
		this.subject = subject;
		this.total = total;
		this.startApply = startApply;
		this.endApply = endApply;
		this.startDay = startDay;
		this.endDay = endDay;
		this.time = time;
		this.stSize = stSize;
		this.tcid = "";
		this.teacherName = "";
	}
	
	public Subject(String id, String subject, int total, int startApply, int endApply, int startDay, int endDay, int time, int stSize,
			String tcid, String teacherName) {
		super();
		this.id = id;
		this.subject = subject;
		this.total = total;
		this.startApply = startApply;
		this.endApply = endApply;
		this.startDay = startDay;
		this.endDay = endDay;
		this.time = time;
		this.stSize = stSize;
		this.tcid = tcid;
		this.teacherName = teacherName;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getStartApply() {
		return startApply;
	}
	public void setStartApply(int startApply) {
		this.startApply = startApply;
	}
	public int getEndApply() {
		return endApply;
	}
	public void setEndApply(int endApply) {
		this.endApply = endApply;
	}
	public int getStartDay() {
		return startDay;
	}
	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}
	public int getEndDay() {
		return endDay;
	}
	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getStSize() {
		return stSize;
	}
	public void setStSize(int stSize) {
		this.stSize = stSize;
	}
	public String getTcid() {
		return tcid;
	}
	public void setTcid(String tcid) {
		this.tcid = tcid;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Sbuject: %12s | Teacher: %12s | Max: %2d/%2d | Apply: %8d ~ %8d | Period : %8d ~ %8d", subject, teacherName, stSize, total, startApply, endApply, startDay, endDay);
	}

	@Override
	public int compareTo(Subject o) {
        return Integer.compare(this.startApply, o.getStartApply());
    }
	
}
