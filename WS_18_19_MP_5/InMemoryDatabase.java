import java.util.Calendar;
import java.util.Collections;
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
		students.add(student);
	}

	@Override
	public void insertStudents(List<Student> students) {
		// Aufgabe
		this.students.addAll(students);
	}

	@Override
	public int countStudents() {
		// Aufgabe
		return students.size();
	}

	@Override
	public List<Student> getStudents() {
		// Aufgabe

		List <Student> allStudents= new LinkedList<>();
		allStudents.addAll(students);
		return allStudents;
	}

	@Override
	public List<Student> getStudentsBornAfter(Calendar date) {
		// Aufgabe
//		List<Student> studentsBornAfter = new  LinkedList<>();
//		Object [] alleStudents =  students.toArray();
//		
//		for(int i = 0; i < alleStudents.length; i ++) {
//			if(((Student) alleStudents[i]).getDateOfBirth().compareTo(date) > 0){
//				studentsBornAfter.add((Student)alleStudents[i]);
//			}
//		}
//		return studentsBornAfter;
		
		//alternativ
		
		List<Student> studentsBornAfter = new LinkedList<>();
		for(int i = 0; i < students.size(); i ++) {
			if(students.get(i).getDateOfBirth().compareTo(date) > 0) {
				studentsBornAfter.add(students.get(i));
			}
		}
		return studentsBornAfter;
	}

	@Override
	public List<Student> getGoodStudents(double gradeThreshold) {
		// Aufgabe
		List<Student> goodStudents = new LinkedList<>();
		for(int i = 0; i < students.size(); i ++) {
			if(students.get(i).getAverageGrade() > 0 && students.get(i).getAverageGrade() < gradeThreshold) {
				goodStudents.add(students.get(i));
			}
		}
		return goodStudents;
	}

	@Override
	public List<Student> getGoodStudentsOrderedByGrade(double gradeThreshold) {
		// Aufgabe
		List<Student> goodStudents  = getGoodStudents(gradeThreshold);
		Collections.sort(goodStudents, new GradeComparator());
		return goodStudents;
	}

	@Override
	public List<Student> getStudentsAttendingCourse(Course course) {
		// Aufgabe
		List<Student> studentsAttendingCourse = new LinkedList<>();
		for(int i = 0; i < students.size(); i ++) {
			if(students.get(i).getAttendedCourses().contains(course)) {
				
				studentsAttendingCourse.add(students.get(i));
			}
		}
		return studentsAttendingCourse;
		}

	@Override
	public void insertCourse(Course course) {
		// Aufgabe
		courses.add(course);
	}

	@Override
	public List<Course> getCourses() {
		// Aufgabe
		List <Course> Courses= new LinkedList<>();
		Courses.addAll(courses);
		return Courses;
	}

	@Override
	public List<Course> getCoursesInTerm(Term term) {
		// Aufgabe
		
		List <Course> CoursesInTerm= new LinkedList<>();
		
		for(int i = 0; i <this.courses.size(); i ++) {
			if(courses.get(i).getTerm() == term) {
				CoursesInTerm.add(courses.get(i));
			}
		}
		return CoursesInTerm;
	}

	@Override
	public int countCourses() {
		// Aufgabe
		return courses.size();
	}
}
