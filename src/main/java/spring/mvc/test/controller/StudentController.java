package spring.mvc.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.mvc.test.dto.Student;
import spring.mvc.test.exceptions.SpringException;
import spring.mvc.test.services.StudentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ModelAttribute("countries")
    public List<String> populateCountries() {
        List<String> countries= new ArrayList<>();
        countries.add("India");
        countries.add("USA");
        countries.add("Japan");
        return countries;
    }

    /*
     * *******Example of using @ModelAttribute on a method*******
     *
     * The following handler method accept a model and add multiple attribute to it
     */
    @ModelAttribute
    public void populateCitiesAndLanguages(Model model) {

        List<String> cities= new ArrayList<>();
        cities.add("Paris");
        cities.add("New York");
        cities.add("London");
        cities.add("Delhi");
        cities.add("Beijing");

        List<String> languages= new ArrayList<>();
        languages.add("English");
        languages.add("Hindi");
        languages.add("Urdu");


        model.addAttribute("cities", cities);
        model.addAttribute("languages", languages);
    }


    @RequestMapping(value = "/studentEdit", method = RequestMethod.GET)
    public String student(Model model) {
        System.out.println(studentService.list().size());
                model.addAttribute("command", new Student());
                model.addAttribute("list", studentService.list());
        return "student";
    }
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    @ExceptionHandler({SpringException.class})
    public String addStudent(@ModelAttribute("command") Student student,
                             ModelMap model) {
        if (student.getName().length() < 2 )
            throw new SpringException("Name too short");
        //model.addAttribute("name", student.getName());
        //model.addAttribute("age", student.getAge());
        //model.addAttribute("id", student.getId());

        studentService.save(student);

        return "redirect:/studentEdit";
    }

}
