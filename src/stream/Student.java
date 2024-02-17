package stream;

import java.util.List;


public class Student{
    private Integer id;
    private String name;
    private  Integer rank;
    private List<String> contacts;
    private String department;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String gender;
    private Integer age;

    private List<Student> peerConnection;

    public Student(Integer id, String name,String gender,Integer age, int rank, List<String> contacts, String department) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.rank = rank;
        this.contacts = contacts;
        this.department = department;
    }

    public Student(Integer id, String name, int rank, List<String> contacts, String department,List<Student> peerConnection) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.contacts = contacts;
        this.department = department;
        this.peerConnection = peerConnection;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "stream.Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                ", contacts=" + contacts +
                ", department='" + department + '\'' +
                '}';
    }
}