package transaction;

/**
 * @author Andrew
 * @date 2018/1/10
 */
public class TestProxy {
    public static void main(String[] args) {
        /**
         * invoke只打印了一次，也就是说jdk动态代理只有在外部调用其方法时才会代理调用，
         * 自己调用自己的方法是不会走代理调用的。
         */
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookFacade = new BookFacadeImpl();
        bookFacade.addBook();
        BookFacade bookProxy = (BookFacade) proxy.bind(bookFacade);
        bookProxy.addBook();

        bookFacade.addBook();
    }
}
