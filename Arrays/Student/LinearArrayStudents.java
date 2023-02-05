package Arrays.Student;

public class LinearArrayStudents {
    Student [] s;
    public void insert(Student S){
        for (int i = 0; i < s.length; i++) {
            if(s[i].getId() == 0)
                s[i] = S;
        }
    }
    public void delete(Student S){
        for (int i = 0; i < s.length; i++) {
            if(s[i].getId() == S.getId())
                s[i] = null;
        }
    }
    public Student search(int id) {
        for (int i = 0; i < s.length; i++) {
            if(s[i].getId() == id)
                return s[i];
        }
        return null;
    }
}
