package hello.login.web.session;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class SessionManager {
    public static final String SESSION_COOKIE_NAME= "mySessionId";
    private Map<String, Object> sessionStore = new ConcurrentHashMap<>();

    // 1. 세션 생성
    public void createSession(Object value, HttpServletResponse response){
        //세션 아이디 생성하고 값을 세션에 저장
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, value);
        
        // 쿠키를 생성
        Cookie mySessionCookie = new Cookie(SESSION_COOKIE_NAME, sessionId);
        response.addCookie(mySessionCookie);

    }
    // 2. 세션 조회
    public Object getSession(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie == null) {
            return null;
        }
        return sessionStore.get(sessionCookie.getValue());
    }
    private Cookie findCookie(HttpServletRequest request, String cookieName) {
        if (request.getCookies() == null) {
            return null;
        }
        return Arrays.stream(request.getCookies())// 배열의 값을 하나씩 넘기며 돌리는게 stream
                .filter(cookie -> cookie.getName().equals(cookieName))
                .findAny()
                .orElse(null);
    }

    // 위의 코드는 아래의 코드를 리팩토링 한 것이다.
    //    public Object getSession(HttpServletRequest request){
//        Cookie[] cookies = request.getCookies();// 배열로 반환됨
//        if (cookies == null){
//            return null;
//        }
//        for(Cookie cookie : cookies){
//            if(cookie.getName().equals(SESSION_COOKIE_NAME)){
//                return sessionStore.get(cookie.getValue());
//            }
//        }
//        return null;
//    }

    // 3. 세션 만료
    public void expire(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie != null) {
            sessionStore.remove(sessionCookie.getValue());
        }
    }
}