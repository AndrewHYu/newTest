package transaction;

/**
 * @author Andrew
 * @date 2018/1/10
 */
public class TestCglib {
    public static void main(String[] args) {
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacade bookFacade = new BookFacadeImpl();
//        bookFacade.addBook();

        BookFacadeImpl bookCglib =(BookFacadeImpl) cglib.getInstance(bookFacade);
        bookCglib.addBook();

//        bookFacade.addBook();
    }
}
