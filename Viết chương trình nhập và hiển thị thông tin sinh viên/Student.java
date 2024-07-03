
public class Student {
    private String name;
    private String className;
    private int age;
    private double englishScore;
    private double mathScore;

    public Student(String name, String className, int age, double englishScore, double mathScore) {
        this.name = name;
        this.className = className;
        this.age = age;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
    }

    public double calculateAverageScore() {
        return (englishScore + mathScore) / 2;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Class: " + className);
        System.out.println("Age: " + age);
        System.out.println("English Score: " + englishScore);
        System.out.println("Math Score: " + mathScore);
        System.out.println("Average Score: " + calculateAverageScore());
    }

    
}
