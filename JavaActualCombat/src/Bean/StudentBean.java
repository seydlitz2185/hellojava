package Bean;
import java.io.Serializable;
/**
 * @author stevenyu
 */
public class StudentBean implements Serializable{
        private String stuName;
        private int grade;
        private CourseBean[] sc;



    public void setStuName(String stuName){
        this.stuName = stuName;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setSc(CourseBean[] sc) {
        this.sc = sc;
    }

    public String getStuName() {
        return stuName;
    }

    public int getGrade() {
        return grade;
    }

    public CourseBean[] getSc() {
        return sc;
    }
}
