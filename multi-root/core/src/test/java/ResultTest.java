import com.example.util.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Result.class)
public class ResultTest {

    @Test
    void resultTest1() {
        Result result = new Result();
        result.setMsg(Result.STATUS_SUCCESS);

        println();
        System.out.println(result.getResult());
        println();
    }

    @Test
    void resultTest2() {
        Result result = new Result();
        result.setMsg(Result.STATUS_WARNING,Result.STATUS_WARNING_MESSAGE);

        println();
        System.out.println(result.getResult());
        println();
    }

    void println(){
        System.out.println("================================");
    }

}
