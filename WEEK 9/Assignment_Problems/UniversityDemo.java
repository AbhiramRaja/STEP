public class UniversityDemo {
    private String uniName;

    public UniversityDemo(String uniName) {
        this.uniName = uniName;
    }

    class Department {
        private String deptName;

        public Department(String deptName) {
            this.deptName = deptName;
        }

        public void showInfo() {
            System.out.println("University: " + uniName + ", Department: " + deptName);
        }
    }

    static class ExamCell {
        public static void announceExam(String course) {
            System.out.println("Exam for " + course + " scheduled. Check notices.");
        }

        public void generalInfo() {
            System.out.println("ExamCell handles registrations and results.");
        }
    }

    public static void main(String[] args) {
        UniversityDemo uni = new UniversityDemo("State University");
        UniversityDemo.Department dept = uni.new Department("Computer Science");
        dept.showInfo();

        // static nested class usage
        UniversityDemo.ExamCell.announceExam("Data Structures");
        UniversityDemo.ExamCell cell = new UniversityDemo.ExamCell();
        cell.generalInfo();
    }
}