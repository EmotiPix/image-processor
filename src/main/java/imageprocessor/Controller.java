package imageprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@RestController
public class Controller {
    @Autowired
    private Processor processor;

    @RequestMapping("/")
    public String test() {
        return "Hey!";
    }

    @PostMapping("/process")
    public String process(@Valid @RequestBody Request request) {
        try {
            return processor.process(request.getImage(), request.getEmotion());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
