package lab9;

public class lab9_2 {
    public static void main(String[] args) {
        new Student("Decha", "ABI").show();
        new Student("George1", "ABC").show();
        new Student("John Young", "DB").show();
        new Student("Ted", "JAB").show();
        new Student("Tony", "CAB").show();

    }
}

class Student {
    private String name;
    private String grade;

    public Student(String name, String grade) {
        setName(name);
        setGrade(grade);
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        try {
            validate(getName(), getGrade());
            int totalGrade = 0;
            for (char c : getGrade().toCharArray()) {
                totalGrade += gradeFormat(c);
            }
            double GPA = totalGrade / grade.length();
            System.out.println(getName() + " registered " + grade.length() + " subjects and got GPA " + GPA);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private int gradeFormat(char grade) {
        switch (grade) {
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'C':
                return 2;
            case 'D':
                return 1;
            case 'F':
                return 0;
            default:
                return -1;
        }
    }

    public void validate(String name, String grade) throws IncompleteException, DigitException, SpaceException, GradeException {
        if (name.contains(" "))
            throw new SpaceException("(space is not allowed in name) cannot display.");
        if (grade.contains("I"))
            throw new IncompleteException("(grade I is incomplete) cannot display.");

        for (char c : grade.toCharArray()) {
            if(c < 'A' || c > 'F' || c == 'E')
                throw new GradeException("(grade must be A B C D F) cannot display.");
        }
        
        for (char c : name.toCharArray()) {
            if(c >= '0' && c <= '9')
                throw new DigitException("(digit is not allowed in name) cannot display.");
        }
        
    }
}

class IncompleteException extends Exception {
    public IncompleteException(String msg) {
        super(msg);
    }
}

class DigitException extends Exception {
    public DigitException(String msg) {
        super(msg);
    }
}

class SpaceException extends Exception {
    public SpaceException(String msg) {
        super(msg);
    }
}

class GradeException extends Exception {
    public GradeException(String msg) {
        super(msg);
    }
}
