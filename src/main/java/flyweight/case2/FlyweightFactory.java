package flyweight.case2;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private static Map<String, Subject> map = new HashMap<>();

    public Subject getSubject(String key) {
        Subject subject = map.get(key);
        if (subject == null) {
            subject = new Subject(key);
            map.put(key, subject);

            System.out.println("새로 생성" + key);
        } else {
            System.out.println("재사용" + key);
        }

        return subject;
    }
}
