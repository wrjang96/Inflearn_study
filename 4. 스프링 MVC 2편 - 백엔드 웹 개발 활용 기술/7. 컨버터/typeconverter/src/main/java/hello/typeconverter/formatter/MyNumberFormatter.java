package hello.typeconverter.formatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Slf4j
public class MyNumberFormatter implements Formatter<Number> {
    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("text={}, locale={}", text, locale);
        NumberFormat format = NumberFormat.getInstance(locale);
        // 문자 중간에 쉼표를 적용하려면 자바가 제공하는 NumberFormat 객체를 사용하면 된다.
        // locale 정보를 활용해서 나라별로 다른 숫자 포맷을 만들어준다.
        return format.parse(text);
        //parse를 통하여 문자를 숫자로 변환
    }
    @Override
    public String print(Number object, Locale locale) {
        // 객체를 문자로 변환
        log.info("object={}, locale={}", object, locale);
        return NumberFormat.getInstance(locale).format(object);
    }
}
