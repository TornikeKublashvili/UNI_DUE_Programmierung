import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementierung des Database-Interfaces, die Objekte über Listen des Java
 * Collection-Framework direkt im Speicher verwaltet
 */
public class InMemoryDatabase implements Database {

	private List<Student> students = new LinkedList<>();
	private List<Course> courses = new LinkedList<>();

	@Override
	public void insertStudent(Student student) {
		// Aufgabe
	}

	@Override
	public void insertStudents(List<Student> students) {
		// Aufgabe
	}

	@Override
	public int countStudents() {
		// Aufgabe
		return -1;
	}

	@Override
	public List<Student> getStudents() {
		// Aufgabe
		return null;
	}

	@Override
	public List<Student> getStudentsBornAfter(Calendar date) {
		// Aufgabe
		return null;
	}

	@Override
	public List<Student> getGoodStudents(double gradeThreshold) {
		// Aufgabe
		return null;
	}

	@Override
	public List<Student> getGoodStudentsOrderedByGrade(double gradeThreshold) {
		// Aufgabe
		return null;
	}

	@Override
	public List<Student> getStudentsAttendingCourse(Course course) {
		// Aufgabe
		return null;
	}

	@Override
	public void insertCourse(Course course) {
		// Aufgabe
	}

	@Override
	public List<Course> getCourses() {
		// Aufgabe
		return null;
	}

	@Override
	public List<Course> getCoursesInTerm(Term term) {
		// Aufgabe
		return null;
	}

	@Override
	public int countCourses() {
		// Aufgabe
		return -1;
	}
}
