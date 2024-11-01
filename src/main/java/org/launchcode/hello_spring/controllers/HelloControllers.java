package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HelloControllers {

    // Display the form on a GET request
    @GetMapping("hello")
    public String displayForm() {
        return "<form action='/hello' method='post'>" +
                    "<label for='name'>Name:</label>" +
                    "<input type='text' id='name' name='name'>" +
                    "<label for='language'>Choose language:</label>" +
                    "<select name='language' id='language'>" +
                        "<option value='English'>English</option>" +
                        "<option value='French'>French</option>" +
                        "<option value='Spanish'>Spanish</option>" +
                        "<option value='German'>German</option>" +
                        "<option value='Italian'>Italian</option>" +
                    "</select>" +
                    "<input type='submit' value='Greet me'>" +
                "</form>";
    }

    // Process the form submission on a POST request
    @PostMapping("hello")
    public String processGreeting(@RequestParam String name, @RequestParam String language) {
        if (name == null || name.isEmpty()) {
            name = "World";
        }
        return "<h1>" + createMessage(name, language) + "</h1>";
    }

    // Static method to create a greeting message based on language
    public static String createMessage(String name, String language) {
        String greeting;

        if (language.equals("English")) {
            greeting = "Hello";
        } else if (language.equals("French")) {
            greeting = "Bonjour";
        } else if (language.equals("Spanish")) {
            greeting = "Hola";
        } else if (language.equals("German")) {
            greeting = "Guten Tag";
        } else if (language.equals("Italian")) {
            greeting = "Ciao";
        } else {
            greeting = "Hello";  // Default to English if no match
        }

        return greeting + ", " + name + "!";
    }
}
