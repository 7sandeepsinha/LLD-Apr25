package designPatterns.Prototype;

public class Student implements Prototype<Student>{
    private int id;
    private String name;
    private String contactDetails;
    private double psp;
    private String batchName;
    private int batchId;
    private String instructorName;
    private String module;
    private String schedule;
    private double batchPsp;
    private double batchAttendance;

    @Override
    public Student copy() {
        Student copy = new Student();
        copy.batchName = this.batchName;
        copy.batchId = this.batchId;
        copy.instructorName = this.instructorName;
        copy.module = this.module;
        copy.schedule = this.schedule;
        copy.batchPsp = this.batchPsp;
        copy.batchAttendance = this.batchAttendance;
        return copy;
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
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public double getBatchPsp() {
        return batchPsp;
    }

    public void setBatchPsp(double batchPsp) {
        this.batchPsp = batchPsp;
    }

    public double getBatchAttendance() {
        return batchAttendance;
    }

    public void setBatchAttendance(double batchAttendance) {
        this.batchAttendance = batchAttendance;
    }
}
