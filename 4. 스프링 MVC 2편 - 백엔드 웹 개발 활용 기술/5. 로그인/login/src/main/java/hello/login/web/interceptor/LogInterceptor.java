package hello.login.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.asm.Handle;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    public static final String LOG_ID = "logId";
    // 싱글톤이라 여기서 prehandle코드 작성 불가
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();

        request.setAttribute(LOG_ID, uuid);
        // @Controller가 아니라 정적 리소스가 호출되는 경우에는 : ResourceHttpRequestHandler
        if (handler instanceof HandlerMethod){ // @RequestMapping의 경우 사용 되는 handler가 handlerMethod이다.
            HandlerMethod hm = (HandlerMethod) handler; // 호출할 컨트롤러 메소드의 모든 정보가 포함되어 있다
        }
        log.info("REQUEST [{}][{}][{}]", uuid, requestURI, handler);
        return true;
        // true 다음 컨트롤러 호출
        // false 여기서 끝남
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle [{}]", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        String logId = (String)request.getAttribute(LOG_ID);
        log.info("RESPONSE [{}][{}]", logId, requestURI);
        if (ex != null) {
            // 예외가 NUll이 아니면(예외처리를 여기서 하는 이유는 PostHandle이 호출되지 않는다)
            log.error("afterCompletion error!!", ex); // 에러를 찍어볼 수 있음
        }
    }
}
