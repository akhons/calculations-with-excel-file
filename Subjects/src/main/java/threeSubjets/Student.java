package threeSubjets;


class Student {
	String name;
    int maths;
    int physics;
    int chemistry;

    public Student(String name, int maths,int physics, int chemistry) {
        this.name = name;
        this.maths = maths;
        this.physics = physics;
        this.chemistry = chemistry;
    }

    public String Grade(int marks) {
        if (marks >= 90) return "A1";
        else if (marks > 80) return "A2";
        else if (marks > 70) return "B1";
        else if (marks > 60) return "B2";
        else if (marks > 50) return "C1";
        else if (marks > 40) return "C2";
        else if (marks >= 33) return "D";
        else return "F";
    }

    public String getGrade(int marks) {
        return Grade(marks);
    }
    public int percentage(int maths, int physics, int chemistry) {
    	int a= (maths+physics+chemistry)/3;
    	return a;
    }

    public int calculateGradePoint(int marks) {
        String grade = Grade(marks);
        int gradeValue;

        switch (grade) {
            case "D":
                gradeValue = 4;
                break;
            case "C2":
                gradeValue = 5;
                break;
            case "C1":
                gradeValue = 6;
                break;
            case "B2":
                gradeValue = 7;
                break;
            case "B1":
                gradeValue = 8;
                break;
            case "A2":
                gradeValue = 9;
                break;
            case "A1":
                gradeValue = 10;
                break;
            default:
                gradeValue = 0; // Set to 0 if grade is not recognized
        }

        return gradeValue;
    }

}

