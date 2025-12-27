package org.main;

import org.beans.Student;
import org.mapper.StudentRowMapper;
import org.resources.SpringConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//  <------------INSERTION OPERATION -------------->
//        int std_roll = 96;
//        String std_name = "Deedee";
//        float std_marks = 8.1f;
//        String insert_sql_query = "INSERT INTO student VALUES(?,?,?)";
//        int count = jdbcTemplate.update(insert_sql_query, std_roll, std_name, std_marks);
//
//        if(count>0) {
//            System.out.println("insertion successful");
//        }
//        else {
//            System.out.println("Insertion failed !!");
//        }

// <--------UPDATION OPERATION---------->
//        float marks = 91.0f;
//        int roll = 96;
//        String update_sql_query = "UPDATE student SET std_marks=? WHERE std_roll=?";
//        int count2 = jdbcTemplate.update(update_sql_query, marks, roll);
//
//        if (count2>0) {
//            System.out.println("Updation successful");
//        }
//        else {
//            System.out.println("Updation failed!!");
//        }
    //<----------DELETION OPERATION---------->
//        int roll2=99;
//        String delete_sql_query = "DELETE FROM student WHERE std_roll=?";
//        int count3 = jdbcTemplate.update(delete_sql_query,  roll2);
//
//        if (count3>0) {
//            System.out.println("Deletion Successful");
//        }
//        else {
//            System.out.println("Deletion failed !!");
//        }

        String select_sql_query = "SELECT * FROM student";
        List<Student> std_list = jdbcTemplate.query(select_sql_query, new StudentRowMapper());
        for(Student std : std_list) {
            System.out.println("RollNo -->"+ std.getRoll());
            System.out.println("Name -->"+ std.getName());
            System.out.println("Marks -->"+ std.getMarks());
            System.out.println("---------------------");
        }
    }
}
