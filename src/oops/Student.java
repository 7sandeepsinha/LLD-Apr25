package oops;

public class Student {
    private int id;
    private String name;
    private String school;

    public Student(){
    }

    public Student(int sId){
        id = sId;
    }

    public Student(int sId, String sName){
        id = sId;
        name = sName;
    }

    public Student(Student student){
        id = student.id;
        name = student.name;
    }

    public void print() {
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("School : " + school);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //null checks here
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
