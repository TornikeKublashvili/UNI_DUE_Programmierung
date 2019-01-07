public class Student extends Person {

	private String course;
	private int libraryPassword;

	public Student(String firstName, String lastName, int yearOfBirth) {
		super(firstName, lastName, yearOfBirth );
		libraryPassword = yearOfBirth;
	}

	public int getLibraryPassword() {
		return libraryPassword;
	}

	public void enroll(String course) {
		this.course = course;
	}

	public void enroll() {
		course = "Germanistik";
	}

	public String getCourse() {
		return course;
	}

}
