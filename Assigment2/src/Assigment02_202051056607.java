/*
 * @author Turana SHAHBAZZADE
 * @since 09.04.2021
 */
import java.util.ArrayList;

public class Assigment02_202051056607 {
    public static void main(String[] args) {
        Department d1 = new Department("CSE", "Computer Engineering");
        Department d2 = new Department("CSE2", "Computer Engineering");
        Teacher t = new Teacher("Joseph LEDET", "josephledet@akdeniz.edu.tr", 123L, d1, 1);
        Teacher t1 = new Teacher("Melih Gunay", "mgunay@akdeniz.edu.tr", 124L, d2, 4);
        System.out.println(t);
        d1.setChair(t1);
        Course c1 = new Course(d1, 101, "Computer Programming 1", 6, t);
        Course c2 = new Course(d1, 102, "Computer Programming 2", 4, t);
        Course c3 = new Course(d1, 103, "Database Management Systems", 4, t);
        Course c4 = new Course(d1, 104, "Web Programming", 4, t);
        System.out.println(c1.courseCode() + " - " + c1.getTitle());
        System.out.println(c2);
        Student s = new Student("Turana Shahbazzade", "turane@gmail.com", 20180808002L, d2);
        s.addCourse(c1, 100);
        s.addCourse(c2, 100);
        s.addCourse(c2, 100);
        s.addCourse(c3,100);
        s.addCourse(c4,100);
        System.out.println(s.getAKTS());
        System.out.println(s.getAttemptedAKTS());
        System.out.println(s.getGPA());
        System.out.println(s);
        GradStudent gradStudent = new GradStudent("Turana Shahbazzade","turane@gmail.com",202051056607L, d1,"Operating System");
        gradStudent.addCourse(c1,78);
        gradStudent.addCourse(c1,25);
        System.out.println(gradStudent.getGPA());


        }
    }

class Department {
    private String id;
    private String name;
    private Teacher chair;
    public Department(String id, String name) throws InvalidDepartmentIdException{
        if(id.length()==3 || id.length()==4){
            this.id=id;

        } else{
            this.id=id;
            throw new InvalidDepartmentIdException(id);
        }
       this.name=name;
    }

    public String getId(){
       return id;
    }
    public String getName() {
        return name;
    }
    public Teacher getChair() throws DepartmentMismatchException {
        if(chair.getDepartment()==this){
            return chair;
        } else{
            throw new DepartmentMismatchException( chair,chair.getDepartment() );

        }
    }
    public void setId(String id) throws InvalidDepartmentIdException {
        if(id.length()==3 || id.length()==4){
            this.id=id;

        }else {
            this.id=id;
            throw new InvalidDepartmentIdException(id);
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setChair(Teacher chair) throws DepartmentMismatchException {
        if (chair.getDepartment() == this) {
            this.chair = chair;
        } else {
            throw new DepartmentMismatchException(chair, chair.getDepartment());
        }

    }

}

class Course{
    private Department department;
    private  Teacher teacher;
    private int number;
    private String title;
    private int akts;
    public Course(Department department, int number, String title, int akts, Teacher teacher) throws DepartmentMismatchException, InvalidCourseNumberException, InvalidAktsException{

        if((number>100 && number<499) || (number>5000 && number<5999) || (number>7000 && number<7999)){
            this.number=number;
        }
        else
        {
            this.number=number;
            throw new InvalidCourseNumberException( number);
        }
        if(akts>=0){
            this.akts=akts;

        }
        else{
            this.akts=akts;
            throw new InvalidAktsException(akts);
        }
        if(teacher.getDepartment()!=department) {
            this.teacher=teacher;
            throw new DepartmentMismatchException(teacher, this);
        } else{
            this.teacher=teacher;
        }
        this.department=department;
        this.title=title;
    }
    public Department getDepartment(){
        return department;
    }
    public int getNumber() {
        return number;
    }
    public String getTitle() {
        return title;
    }
    public int getAkts() {
        return akts;
    }
    public void setDepartment(Department department) {
        this.department=department;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAkts(int akts) throws InvalidAktsException{
        if(akts>=0){
            this.akts=akts;

        }
        else{
            this.akts=akts;
            throw new InvalidAktsException(akts);
        }
    }
    public void setNumber(int number) throws InvalidCourseNumberException {
        if((number>100 && number<499) || (number>5000 && number<5999) || (number>7000 && number<7999)){
            this.number=number;
        }
        else
        {
            this.number=number;
            throw new InvalidCourseNumberException(number);
        }
    }
    public Teacher getTeacher() throws DepartmentMismatchException {
        if(teacher.getDepartment()!=department) {
            throw new DepartmentMismatchException(teacher, this);
        } else{
            return  teacher;
        }

    }
    public void setTeacher(Teacher teacher) {
        if(teacher.getDepartment()!=this.department) {
            throw new DepartmentMismatchException(teacher, this);
        }else{ this.teacher = teacher;}

    }
    public String courseCode(){
        return  this.department.getId() + " " + this.number;
    }
    public String toString() {
        String string = department.getId() + " " + number + " - " + title + " (" + akts + ")";
        return string;
    }

}

abstract class Person{
    private String name;
    private String email;
    private long id;
    private Department department;

    public Person(String name, String email, long id, Department department) throws InvalidEmailException, InvalidDepartmentIdException {
        if(email.contains("@") && email.substring(email.indexOf("@")).contains(".")){
            this.email=email;
        } else{
            this.email=email;
            throw new InvalidEmailException(email);
        }
        this.name = name;
        this.id = id;
        this.department=department;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) throws InvalidEmailException {
        if(email.contains("@") && email.substring(email.indexOf("@")).contains(".")){
            this.email=email;
        } else{
            this.email=email;
            throw new InvalidEmailException(email);
        }
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setDepartment(Department department) throws InvalidDepartmentIdException {
        if(department.getId().length()==3 || department.getId().length()==4){
            this.department=department;
        } else
        {
            throw new InvalidDepartmentIdException(department.getId());
        }
    }
    public String toString(){
        String string = name + " " + "(" + id + ")" + " - " + email;
        return string;
    }
}

class Teacher extends Person{
    private int rank;
    public Teacher(String name, String email, long id, Department department, int rank) throws InvalidEmailException, InvalidRankException{
        super(name, email, id, department);
        if(rank>=1 && rank<=4){
            this.rank=rank;
        }
        else{
            this.rank=rank;
            throw new InvalidRankException(rank);
        }
    }
    public int getRank() {
        return rank;
    }

    @Override
    public void setDepartment(Department department){

        if(department.getChair()==this.getDepartment().getChair()){
          this.getDepartment().setChair(null);

        }
            super.setDepartment(department);
    }

    public String getTitle(){
        if(rank==1)
            return "Lecturer";
        else if(rank==2)
            return "Assistant Professor";
        else if(rank==3){
            return "Associate Professor";
        }
        else
        {
            return "Professor";
        }
    }

    public void promote() throws InvalidRankException{
        if(rank!=4){
            rank++;
        }
        else{
            rank++;
            throw new InvalidRankException(rank);
        }

    }

    public void demote() throws  InvalidRankException{
        if(rank!=1)
        {
            rank--;
        }
        else{
            rank --;
            throw new InvalidRankException(rank);
        }
    }

    public String toString(){
        String string = getTitle() + " " + super.toString();
        return  string;
    }
}

class Student extends Person{
    public ArrayList<Course> courses;
    public ArrayList<Double> grades;

    public Student(String name, String email, long id, Department department ) {
        super(name, email, id, department);
        courses  = new ArrayList<>();
        grades = new ArrayList<>();
    }
    public int getAKTS(){
        int sumOfPassedAkts=0;
        for(int i=0; i<courses.size(); i++){
            if(grades.get(i)>59){
                sumOfPassedAkts+=courses.get(i).getAkts();
            }
        }
        return sumOfPassedAkts;
    }
    public int getAttemptedAKTS(){
        int sumOfAttemptedAkts =0;
        for(int i=0; i<courses.size(); i++){
            sumOfAttemptedAkts+=courses.get(i).getAkts();
        }
        return sumOfAttemptedAkts;
    }
    public void addCourse(Course course, double grade) throws InvalidGradeException{
        if(grade<0 || grade>100){
            throw new InvalidGradeException(grade);
        }  else if (courses.contains(course)){
            grades.set(courses.indexOf(course),grade);
        } else {
            courses.add(course);
            grades.add(grade);
        }

    }

    public double courseGPAPoints(Course course) throws CourseNotFoundException{
        if (!courses.contains(course)){
            throw new CourseNotFoundException( this, course );
        }
        else{
            double grade = grades.get(courses.indexOf(course));
            if (grade >= 88)
                return 4.0;
            else if (grade >= 81)
                return 3.5;
            else if (grade >= 74)
                return 3.0;
            else if (grade >= 67)
                return 2.5;
            else if (grade >= 60)
                return 2.0;
            else if (grade >= 53)
                return 1.5;
            else if (grade >= 46)
                return 1.0;
            else if (grade >= 35)
                return 0.5;
            else
                return 0.0;
        }

    }
    public String courseGradeLetter(Course course){
        if (!courses.contains(course)){
            throw new CourseNotFoundException( this, course );
        } else {
            double grade = grades.get(courses.indexOf(course));
            if (grade >= 88)
                return "AA";
            else if (grade >= 81)
                return "BA";
            else if (grade >= 74)
                return "BB";
            else if (grade >= 67)
                return "CB";
            else if (grade >= 60)
                return "CC";
            else if (grade >= 53)
                return "DC";
            else if (grade >= 46)
                return "DD";
            else if (grade >= 35)
                return "FD";
            else
                return "FF";
        }

    }
    public String courseResult(Course course){
        if (!courses.contains(course)){
            throw new CourseNotFoundException(this, course );
        }else{
            double grade = grades.get(courses.indexOf(course));
            if((grade>=60))
                return "Passed";
            else if((grade>=40))
                return "Conditionally passed";
                else
                    return "Failed";
        }
    }
    public double getGPA(){
        double sumOfGPA=0;
        for (int i = 0; i < courses.size(); i++) {
            sumOfGPA+=courseGPAPoints(courses.get(i)) * courses.get(i).getAkts() / getAttemptedAKTS();
        }
        return sumOfGPA;
    }
    public String toString(){
         return super.toString() + " --GPA: " + getGPA();
     }
}

class GradStudent extends Student{
    private String thesis;

    public GradStudent(String name, String email, long id, Department department,  String thesis) {
        super(name, email, id, department);
        this.thesis=thesis;
    }
    public void setThesis(String thesis) {
        this.thesis = thesis;
    }
    public String getThesis() {
        return thesis;
    }

    @Override
    public double courseGPAPoints(Course course) throws CourseNotFoundException {
        if (!courses.contains(course)){
            throw new CourseNotFoundException(this, course );
        }
        else{
            double grade = grades.get(courses.indexOf(course));
            if (grade >= 90)
                return 4.0;
            else if (grade >= 85)
                return 3.5;
            else if (grade >= 80)
                return 3.0;
            else if (grade >= 75)
                return 2.5;
            else if (grade >= 70)
                return 2.0;
            else
                return 1.5;
        }
    }

    @Override
    public String courseGradeLetter(Course course){
        if (!courses.contains(course)){
            throw new CourseNotFoundException(this, course );
        } else {
            double grade = grades.get(courses.indexOf(course));
            if (grade >= 90)
                return "AA";
            else if (grade >= 85)
                return "BA";
            else if (grade >= 80)
                return "BB";
            else if (grade >= 75)
                return "CB";
            else if (grade >= 70)
                return "CC";
            else
                return "DC";
        }

    }

    @Override
    public String courseResult(Course course){
        if (!courses.contains(course)){
            throw new CourseNotFoundException( this,course );
        }else{
            double grade = grades.get(courses.indexOf(course));
            if (grade >= 70)
                return "passed";
            else
                return "failed";
        }
    }
    public String toString() {
        return super.toString();
    }
}

class CourseNotFoundException extends RuntimeException{
    private Student student;
    private Course course;

    public CourseNotFoundException(Student student, Course course) {
        this.student=student;
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseNotFoundException: " +
                +student.getId() +
                " has not yet taken " + course.courseCode() ;
    }
}
class DepartmentMismatchException extends RuntimeException{
    private Department department;
    private Teacher person;
    private Course course;

    public DepartmentMismatchException(Teacher person, Course course) {
        this.person = person;
        this.course = course;
        department=null;
    }
    public DepartmentMismatchException(Teacher person,Department department) {
        this.person = person;
        this.department=department;
        course=null;
    }

    @Override
    public String toString() {
        if(course==null){
            return "DepartmentMismatchException: {" + person.getName() + "(" + person.getId()
                    + ") cannot be chair of " + department.getId()
                    + " because he/she is currently assigned to " + person.getDepartment().getId() ;
        }
        else {
            return "DepartmentMismatchException: " + person.getName() + "(" + person.getId()
                    + ")  cannot teach " + course.courseCode()
                    + " because he/she is currently assigned to " + person.getDepartment().getId() ;
        }
    }
}
class InvalidGradeException extends RuntimeException{
    private double grade;

    public InvalidGradeException(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "InvalidGradeException:" +
                + grade ;
    }
}
class InvalidRankException extends RuntimeException{
    private  int rank;

    public InvalidRankException(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "InvalidRankException:" + rank;
    }
}
class InvalidEmailException extends RuntimeException{
    private  String email;

    public InvalidEmailException(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "InvalidEmailException{" +
                "email='" + email + "that must have the format: {text}@{text}.{text}";
    }
}
class InvalidDepartmentIdException extends RuntimeException{
    public String id;

    public InvalidDepartmentIdException(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "InvalidDepartmentIdException" +
                "{id=" + id+"}," + " department id must be 3 or 4 characters";
    }

}
class InvalidCourseNumberException extends RuntimeException{
    private int number;

    public InvalidCourseNumberException(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "InvalidCourseNumberException{" +
                "number=" + number + " }, " + " number must be in the range 100-499 or 5000-5999 or 7000-7999";
    }
}
class InvalidAktsException extends RuntimeException{
    private int akts;

    public InvalidAktsException(int akts) {
        this.akts = akts;
    }

    @Override
    public String toString() {
        return "InvalidAkts{" +
                "akts=" + akts + "}," + " akts must be positive";
    }
}

