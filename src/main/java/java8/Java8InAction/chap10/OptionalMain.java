package java8.Java8InAction.chap10;

import java.util.Optional;

/**
 * @author Andrew
 * @date 2017/12/25
 */
public class OptionalMain {
    public static void main(String[] args) {

        //创建一个Optional对象
        //创建空对象，单例，对象本身不为null, optCar.value = null
        Optional<Car> optCar = Optional.empty();
        //如果参数为null则会有NullPointException
        Optional<Car> optCar2 = Optional.of(new Car());
        //参数为null会指向空对象
        Optional<Car> optCar3 = Optional.ofNullable(null);


        //使用map 从Optional 对象中提取和转换值
        Optional<Insurance> optInsurance = Optional.of(new Insurance());
        Optional<String> name = optInsurance.map(Insurance::getName);

        //使用flatMap 链接Optional 对象
        Optional<Person> optPerson = Optional.of(new Person());
        Optional<String> name2 = optPerson.flatMap(Person::getCar)
                            .flatMap(Car::getInsurance)
                            .map(Insurance::getName);
    }

    public Insurance findCheapestInsurance(Person person, Car car) {
        // 不同的保险公司提供的查询服务
        // 对比所有数据
        return new Insurance();
    }

    public Optional<Insurance> nullSafeFindCheapestInsurance(
            Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }
}
