package cachetests;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Controller
public class AController {

    private AService aService;

    public AController(AService aService) {
        this.aService = aService;
    }


    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<String>> getStrings(WebRequest request, @RequestParam String postfix) {
        System.out.println("postfix: " + postfix);
        String eTag = "123asd";
//        if (request.checkNotModified(eTag)) {
//            System.out.println("Not modified");
//            return null;
//        }
        List<String> list = aService.getStrings(postfix);
        return ResponseEntity.ok()
//                .cacheControl(CacheControl.maxAge(2, TimeUnit.HOURS))
//                .eTag(eTag)
                .body(list);
    }

    @GetMapping("/clear")
    @ResponseBody
    public void clearCache() {
        aService.clearCache();
    }

    @GetMapping("/alo")
    public String getIndex() {
        return "index";
    }
}
