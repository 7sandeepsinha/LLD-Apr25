package designPatterns.Builder.preInnnerClasses;

public class Student {
    private int id;
    private String name;
    private double psp;
    private int age;
    private String batch;
    private String universityName;
    private int gradYear;
    private String phoneNumber;

    public Student(StudentHelper studentHelper) {
        // super("", 12, true); // calls parent class constructor
        this(studentHelper.getId(), studentHelper.getName(), studentHelper.getPsp(), studentHelper.getAge(), studentHelper.getBatch(), studentHelper.getUniversityName(), studentHelper.getGradYear(), studentHelper.getPhoneNumber()); // calls current class constructor
    }

    public Student(int id, String name, double psp, int age, String batch, String universityName, int gradYear, String phoneNumber) {
        this(id, name, psp);
        this.age = age;
        this.batch = batch;
        this.universityName = universityName;
        this.gradYear = gradYear;
        this.phoneNumber = phoneNumber;
    }

    public Student(int id, String name, double psp) {
        this.id = id;
        this.name = name;
        this.psp = psp;
    }
}
