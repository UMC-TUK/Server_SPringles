// 학생(Student) 클래스를 작성해보세요.
// 학생 클래스는 이름(name), 학번(studentID), 전공(major) 멤버 변수를 가지며, 생성자와 정보를 출력하는 메서드를 작성하세요.
// 학생 객체를 생성하고, 정보를 출력해보세요.


public class Student {
    String name;
    int studentId;
    String major;

    // 생성자
    public Student(String name, int studentId, String major) {
        this.name = name;
        this.studentId = studentId;
        this.major = major;
    }

    // 정보 출력
    public void printInfo() {
        System.out.println("이름: " + name);
        System.out.println("학번: " + studentId);
        System.out.println("전공: " + major);
    }
}

