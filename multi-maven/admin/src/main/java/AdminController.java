import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    public static void main(String[] args) {

        CoreService coreService = new CoreService();
        System.out.println(coreService.hello());
    }

    @GetMapping("/notice")
    public String getNotice(){
        return "notice";
    }
}
