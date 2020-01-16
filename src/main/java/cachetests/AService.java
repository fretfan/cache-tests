package cachetests;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class AService {

//    @Cacheable("strings")
    public List<String> getStrings(String postfix) {
        System.out.println("Run");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        List<String> list = new ArrayList<>();
//        var x = Math.random();
//        if (x > 0.5) {
//            postfix = new StringBuilder(postfix).reverse().toString();
//        }
        String finalPostfix = postfix;
        IntStream.range(1, 50000).forEach(number -> {
            list.add("item:" + number + ":postfix:" + finalPostfix);
        });
        return list;
    }

    @CacheEvict(value = "strings", allEntries = true)
    public void clearCache() {
        System.out.println("cache cleared");
    }
}
