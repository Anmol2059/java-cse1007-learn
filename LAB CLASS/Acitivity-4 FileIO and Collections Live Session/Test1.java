public static void main(String[] args){
    String[] inputs = {
    "100001, 16, 18, 18, 17, 16, 16",
    "100002, 20, 20, 19, 19, 19, 17",
    "100003, 20, 17, 18, 19, 20, 20",
    "100004, 13, 19, 11, 13, 16, 19",
    "100005, 11, 18, 9, 0, 16, 16",
    "100006, 17, 20, 19, 13, 18, 16",
    "100007, 15, 20, 17, 13, 14, 17",
    "100008, 15, 10, 17, 11, 14, 27",
    };
    ArrayList<StudentMarks> students = new ArrayList<>();
    StudentMarks tmp = null;
    try{
    for(int i = 0; i < inputs.length; i++){
    students.add(StudentMarks.addStudent(inputs[i]));
    } 
    }catch(BadMarksFormatException e){
    System.out.println(e.getMessage());
    }catch(Exception e){
    System.out.println(e.getMessage());
    }
    // printing the read data
    students.forEach(System.out::println);
    // students who scored greater than 15 in all lab assessements
    System.out.println("\nThe students who scored >15 in all 
    assessements are\n");
    // System.out.println(
    System.out.println(
    students.stream()
    .filter(x -> (x.getMarks().stream()
    .filter(e -> e > 15)
    .toList().size() == StudentMarks.assessements)
    ).toList()
    );
    // int ind = 2;
    System.out.println("\nAverage of students second assessement");
    System.out.println(
    students.stream()
    .mapToDouble(e ->
    e.getMarks().get(1)
    ).average().getAsDouble()
    );
    System.out.println("\nMarks converted to 100");
    System.out.println(
    students.stream()
    .map(e -> e.getMarks().stream()
    .map(x -> ((x * 100) / 20) )
    .toList()
    ).toList()
    )