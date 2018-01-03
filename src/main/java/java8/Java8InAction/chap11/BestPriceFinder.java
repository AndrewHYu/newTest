package java8.Java8InAction.chap11;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Andrew
 * @date 2017/12/26
 */
public class BestPriceFinder {
    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                                    new Shop("LetsSaveBig"),
                                                    new Shop("MyFavoriteShop"),
                                                    new Shop("BuyItAll"),
                                                    new Shop("ShopEasy"));
    private final Executor executor = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    private final ExchangeService exchangeService = new ExchangeService();

    public List<String> findPrices(String product){
        List<CompletableFuture<String>> priceFuture = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
                .collect(Collectors.toList());
        return priceFuture.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
    public Double exchangeMoney(Shop shop, String product){
        //代码错误，需要shop.getPrice(product)返回double类型
/*        Future<Double> futurePriceInUSD = CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                .thenCombine(CompletableFuture.supplyAsync(() ->
                        ExchangeService.getRate(ExchangeService.Money.EUR, ExchangeService.Money.USD)), (price, rate) -> price * rate);*/

        return null;
    }

    /**
     * findPricesStream("myPhone").map(f -> f.thenAccept(System.out::println));
     * @param product
     * @return
     */

    public Stream<CompletableFuture<String>>findPricesStream(String product) {
        return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote))));
    }

    @Test
    public void findPricesStreamTest(){
        CompletableFuture[] completableFutures = findPricesStream("myPhone")
                .map(f -> f.thenAccept(System.out::println))
                .toArray(CompletableFuture[]::new);
        //等待所有任务完成，使用anyOf等待任意一个完成
        CompletableFuture.allOf(completableFutures).join();

    }
}
