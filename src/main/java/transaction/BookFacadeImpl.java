package transaction;

/**
 * @author Andrew
 * @date 2018/1/10
 */
public class BookFacadeImpl implements BookFacade{
    @Transaction
    public void addBook() {
        query();
        System.out.println("增加图书方法。。。");
    }

    @Transaction
    public void query() {
        System.out.println("查询是否可以增加图书");
    }
}
