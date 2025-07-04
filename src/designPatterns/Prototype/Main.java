package designPatterns.Prototype;

public class Main {
    public static void main(String[] args) {
        Student batch1Prototype = new Student();
        batch1Prototype.setBatchName("Batch 1");
        batch1Prototype.setBatchId(1);
        batch1Prototype.setInstructorName("Sandeep");
        batch1Prototype.setModule("LLD");
        batch1Prototype.setSchedule("MWF Evening");
        batch1Prototype.setBatchPsp(56.45);
        batch1Prototype.setBatchAttendance(70);

        Student batch2Prototype = new Student();
        batch2Prototype.setBatchName("Batch 2");
        batch2Prototype.setBatchId(2);
        batch2Prototype.setInstructorName("Naman");
        batch2Prototype.setModule("HLD");
        batch2Prototype.setSchedule("MWF Evening");
        batch2Prototype.setBatchPsp(76);
        batch2Prototype.setBatchAttendance(30);

        Registry<Student> registry = new Registry<>();
        registry.add("BATCH 1", batch1Prototype);
        registry.add("BATCH 2", batch2Prototype);

        //add student -> Milan, 1, 1234567890, 90
        Student milan = batch1Prototype.copy();
        milan.setName("Milan");
        milan.setId(1);
        milan.setContactDetails("1234567890");
        milan.setPsp(90);

        //add student -> Hrushikesh, 2, 0987654321, 10
        Student hrushikesh = batch1Prototype.copy();
        hrushikesh.setName("Hrushikesh");
        hrushikesh.setId(2);
        hrushikesh.setContactDetails("0987654321");
        hrushikesh.setPsp(10);

        //create student of batch 2
        Student ravi = registry.get("BATCH 2").copy();
        ravi.setName("Ravi");
        ravi.setId(3);
        ravi.setContactDetails("0987654321");
        ravi.setPsp(3);
    }
}
