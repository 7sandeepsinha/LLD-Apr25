package designPatterns.Builder;

import designPatterns.Builder.productionised.Student;

public class Main {
    public static void main(String[] args) {
        // pre-inner classes
        /*
        Student student = null;
        StudentHelper studentHelper
                = new StudentHelper(1, "Taposhi", 99, 25, "Sandeep's Batch", "ABCD Uni", 2022, "1234567890");
        boolean isValid = StudentValidator.validate(studentHelper);
        if(isValid) {
            student = new Student(studentHelper);
        }

         */

        //productionised
        Student.Builder builder = Student.builder();
        builder = builder.id(1);
        builder = builder.psp(99);
        // Student.builder().id(1).psp(99)
        //Student.builder(); // returns empty StudentHelper object
        Student student =
                Student.builder()
                    .id(1)
                    .psp(99)
                    .name("Dheeraj")
                    .gradYear(2024)
                    .age(23)
                    .universityName("ABCD")
                    .batch("Sandeep's Batch")
                    .phoneNumber("1234567890")
                        .build();
        System.out.println(student);
    }
}
// student object not getting created before validation -> DONE
// too many params, bad readability -> DONE
// all logic should be inside Student class -> YES

/*
      1. Moved the StudentHelper class as a static inner class inside Student
      2. Removed all getters from StudentHelper, as its only for validations, and wont be used anywhere else in code
      3. Since, we dont have getters and setters, we only have setters, we dont need, to put prefix in names, like setName() or setAge()
      only, name(..), age(..) will suffice and would make code shorter/readable
      4. put all the validations inside StudentHelper method with a method called validate()
      5. created a method called build() -> which would return a Student object post validation
      6. Add a static method in Student to get StudentHelper object
      7. Follow ->
         ClassName obj =  ClassName.builder()
                        .attr1()
                        .attr2()
                        .attr3()
                        .build();
 */
