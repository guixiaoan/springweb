package com.example.guixiaoan.springweb.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/9/20 18:15
 * @update: 2022/9/20 18:15
 */
public class Student {

    private String name;
    private String sex;
    private String age;

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
            this.name = name;
        }

        public static void main(String[] args) {
            Student student = new Student();
            student.setName("张三");
            student.setSex("女");
            student.setAge("18");
            Student student1 = new Student();
            student1.setName("王美美");
            student1.setSex("男");
            student1.setAge("57");
            List<Student> studentList = new ArrayList<>();
            studentList.add(student);
            studentList.add(student1);
            Student student3 = new Student();
            student3.setName("张三1");
            student3.setSex("女");
            student3.setAge("18");
            Student student4 = new Student();
            student4.setName("王美美1");
            student4.setSex("男");
            student4.setAge("57");
            List<Student> studentList1 = new ArrayList<>();
            studentList1.add(student3);
            studentList1.add(student4);
            studentList.stream().forEach(stu->{
                System.out.println(stu.getName());
            });
            List<List<Student>> commonList = new ArrayList<List<Student>>() ;
            commonList.add(studentList1) ;
            commonList.stream().forEach(studentList::addAll);
            System.out.println(commonList.toString());
        }

}
