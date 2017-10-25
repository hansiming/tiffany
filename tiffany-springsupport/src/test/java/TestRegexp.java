import org.junit.Test;

/**
 * Created by hansiming on 2017/10/25.
 */
public class TestRegexp {

    @Test
    public void addressTest() {
//        String regexp = "([0-254].){3}[0-254]:\\d";
        //这种叫作非捕获括号，使得你能够定义为与正则表达式运算符一起使用的子表达式。来看示例表达式 /(?:foo){1,2}/。
        //如果表达式是 /foo{1,2}/，{1,2}将只对 ‘foo’ 的最后一个字符 ’o‘ 生效。
        //如果使用非捕获括号，则{1,2}会匹配整个 ‘foo’ 单词。
        String regexp = "((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))";
        String regexp1 = "(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))";
        String address = "127.0.0.1";
        assert address.matches(regexp);
    }
}
