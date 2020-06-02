package mainPackage;

public enum DBName {
	A("AcademyDB", "sb"),
	AS("AcademyStudentDB", "st"),
	AT("AcademyTeacherDB", "tc");
	
    private String fullName;
    private String createName;

    DBName(String fullName, String createName) {
        this.fullName = fullName;
        this.createName = createName;
    }
    
    public String getFullName() {
    	return fullName;
	}
    
    public String getCreateName() {
    	return createName;
	}
}
