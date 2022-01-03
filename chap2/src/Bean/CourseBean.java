package Bean;

import java.io.Serializable;

public class CourseBean implements Serializable {
        private String courseName;
        private int creditHour;

        public CourseBean(String courseName, int creditHour) {
            this.courseName = courseName;
            this.creditHour = creditHour;
        }

    public String getCourseName() {
        return courseName;
    }

    public int getCreditHour() {
        return creditHour;
    }
}

