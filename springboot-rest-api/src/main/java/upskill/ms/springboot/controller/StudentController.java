package upskill.ms.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upskill.ms.springboot.bean.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    //http://localhost:8080/students/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student=new Student(
                1,
                "Kamini",
                "M"
        );
       // return new ResponseEntity<>(student, HttpStatus.OK);
        // custom header response
        return ResponseEntity.ok()
                .header("custom","kamini")
                .body(student);

    }

    //http://localhost:8080/students
    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Mina","K"));
        students.add(new Student(2,"Rohan","zen"));
        students.add(new Student(3,"Misha","kholi"));
        students.add(new Student(4,"Kiya","L"));
        return new ResponseEntity<>(students, HttpStatus.OK);

    }

    //Spring boot Rest API with path variable
    //{id} - uri template variable
    //http://localhost:8080/students/1/lia/jain
    @GetMapping("/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int stuid,
                                       @PathVariable("first-name") String firstname,
                                       @PathVariable("last-name") String lastname){
       Student student= new Student(stuid,firstname,lastname);
       return new ResponseEntity<>(student,HttpStatus.OK);
    }

    //Spring boot Rest API with Request param
    //localhost:8080/students/query?id=1&firstName=lia&lastName=J
    //?id=1 - Query parameter

    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        Student student= new Student(id,firstName,lastName);
        return  new ResponseEntity<>(student,HttpStatus.OK);
    }

    //spring boot rest aPI that handles http post requests
    //@PostMapping and @RequestBody
    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    //Spring boot rest api that handles http put request - updating existing resource
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable int id){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    //Spring boot rest api that handles http delete request - deleting the existing resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        System.out.println(id);
        return  ResponseEntity.ok("deleted");
    }
}
