package demo.logio;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @Author: penghaoyang
 * @Date: 2019/12/15 11:31
 * @Description: CliController
 */
@ShellComponent
public class FunctionCommander {

    private Logger logger = LoggerFactory.getLogger("FunctionCommander");

    /**
     * 这些注解， 分别定义了 [cmd] ([key] [value]) ()... 的各个未知以及默认值等
     * 当然这个方法也就在尝试特性的使用
     *
     * @param m String
     * @param h String
     * @return String
     */
    @ShellMethod(value = "say hello to this", key = {"hello", "hi"})
    public String hello(
            @ShellOption(help = "param No.1", value = {"-m"}, defaultValue = "world") String m,
            @ShellOption(help = "param No.2", defaultValue = "good") String h
    ){
        return "yes, the '" + m + "' is " + h;
    }

    /**
     * 打印日志指令（使用log4j2）
     * @param msg 打印的信息
     * @param level 级别
     * @param repeat 重复次数
     * @return String
     */
    @ShellMethod(value = "output something into log file")
    public String logger(
            @ShellOption(value = {"--message"}, defaultValue = "^_^ hi, there is some default words in the log line !!") String msg,
            @ShellOption(value = {"--level"}, defaultValue = "info") String level,
            @ShellOption(value = {"--repeat"}, defaultValue = "3") int repeat
    ){
        for (int i = 0; i < repeat; i++) {
            if(StringUtils.endsWithIgnoreCase("debug", level)){
                logger.debug(msg);
            }
            if(StringUtils.endsWithIgnoreCase("info", level)){
                logger.info(msg);
            }
            if(StringUtils.endsWithIgnoreCase("warn", level)){
                logger.warn(msg);
            }
            if(StringUtils.endsWithIgnoreCase("error", level)){
                logger.error(msg);
            }
        }
        return "success";
    }

}
