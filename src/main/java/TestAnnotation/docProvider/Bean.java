package TestAnnotation.docProvider;

/**
 * @author huangyu
 * @date 2017/9/8
 */
public class Bean {
    private Integer id;
    @Commit(commit = "bean name")
    private String name;
    @Commit(commit = "1 男，2女",value = "0")
    private Integer sex;
}
