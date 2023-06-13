/** Stream流的相关操作
 * 筛选与切片
    * Stream<T>	filter(Predicate<? super T> predicate)
         返回由与此给定谓词匹配的此流的元素组成的流。
    * Stream<T>	skip(long n)
         在丢弃流的第一个 n元素后，返回由该流的 n元素组成的流。
    * Stream<T>	distinct()
         返回由该流的不同元素（根据 Object.equals(Object) ）组成的流。

 * 查找匹配
    *  boolean	allMatch(Predicate<? super T> predicate)
        返回此流的所有元素是否与提供的谓词匹配。
    * boolean	anyMatch(Predicate<? super T> predicate)
        返回此流的任何元素是否与提供的谓词匹配。
    * boolean	noneMatch(Predicate<? super T> predicate)
         返回此流的元素是否与提供的谓词匹配。
    * long	count()：返回此流中的元素数。

* 返回Optional类型
    * Optional<T>	findAny()
        返回描述流的一些元素的Optional如果流为空，则返回一个空的Optional 。
    * Optional<T>	findFirst()
        返回描述此流的第一个元素的Optional如果流为空，则返回一个空的Optional 。
    * Optional<T>	max(Comparator<? super T> comparator)
        根据提供的 Comparator返回此流的最大元素。
    * Optional<T>	min(Comparator<? super T> comparator)
        根据提供的 Comparator返回此流的最小元素。

 * Optional类的相关用法
    * static <T> Optional<T> empty()：返回一个空的 Optional实例。
    * static <T> Optional<T>	of(T value)：返回具有 Optional的当前非空值的Optional。
    * static <T> Optional<T>	ofNullable(T value)：返回一个 Optional指定值的Optional，如果非空，则返回一个空的 Optional 。

    * Optional<T>	filter(Predicate<? super T> predicate)
        如果一个值存在，并且该值给定的谓词相匹配时，返回一个 Optional描述的值，否则返回一个空的 Optional 。
    * <U> Optional<U>	flatMap(Function<? super T,Optional<U>> mapper)
        如果一个值存在，应用提供的 Optional映射函数给它，返回该结果，否则返回一个空的 Optional 。
    * T	get()：如果 Optional中有一个值，返回值，否则抛出 NoSuchElementException 。
    * void	ifPresent(Consumer<? super T> consumer)
        如果存在值，则使用该值调用指定的消费者，否则不执行任何操作。
    * boolean	isPresent():返回 true如果存在值，否则为 false 。

    * T	orElse(T other)：返回值如果存在，否则返回 other 。
    * T	orElseGet(Supplier<? extends T> other)：返回值（如果存在），否则调用 other并返回该调用的结果。
    * <X extends Throwable> T	orElseThrow(Supplier<? extends X> exceptionSupplier)
        返回包含的值（如果存在），否则抛出由提供的供应商创建的异常。
 */
package com.nuist.newproperty;

import com.nuist.classfile.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamMethodTest {
    //        创建集合对象
    ArrayList<Employee> employeeList = Employee.getEmp();
    @Test
    public void filterTest() {

//      创建流对象
        Stream<Employee> employeeStream = employeeList.stream();
//        过滤filter，查询年龄小于27的对象
        employeeStream.filter(employee -> employee.getAge() < 27).
                forEach(System.out::println);
        System.out.println("----------------");
    }

    @Test
    public void skipTest() {
        //        调用完之后会自动关闭流，故必须重新开启
        Stream<Employee> employeeStream = employeeList.stream();

//      丢弃前2个，skip()
        employeeStream.skip(2).forEach(System.out::println);
        System.out.println("-------------------");
    }

    @Test
    public void distinctTest() {
        //  去重distinct
        employeeList.add(new Employee("ss", 29, "engineer"));
        employeeList.add(new Employee("ss", 27, "engineer"));
        employeeList.add(new Employee("qq", 27, "data"));
        employeeList.add(new Employee("qq", 27, "engineer"));
//        加入重复数据
        Stream<Employee> employeeStream2 = employeeList.stream();
        employeeStream2.distinct().forEach(System.out::println);
        System.out.println("----------------------");
    }

    @Test
    public void booleanTest() {
//        创建集合对象
        ArrayList<Employee> employeeList = Employee.getEmp();
//        判断年龄是否均大于25
        boolean b1 = employeeList.stream().allMatch(employee -> employee.getAge() > 25);
        System.out.println(b1);   // true

//      任一年龄大于26
        boolean b2 = employeeList.stream().anyMatch(employee -> employee.getAge() > 26);
        System.out.println(b2);   // true

        boolean b3 = employeeList.stream().noneMatch(employee -> employee.getAge() > 26);
        System.out.println(b3);   // false

//        计算年龄大于26的个数，count
        long counter = employeeList.stream().map(Employee::getAge).
                filter(age -> age > 26).count();
        System.out.println(counter);
    }

    @Test
    public void optionalTest() {
        //        创建集合对象
        ArrayList<Employee> employeeList = Employee.getEmp();

//        返回任意对象
        Optional<Employee> opt = employeeList.stream().findAny();
        System.out.println(opt);

//        排序后返回第一个
        Optional<Employee> opt2 = employeeList.parallelStream().
                                    sorted(Comparator.comparingInt(Employee::getAge).
                                            thenComparing(Employee::getName)).findFirst();
        System.out.println(opt2);

//        max
        Optional<Employee> opt3 = employeeList.stream().max(
                Comparator.comparingInt(Employee::getAge));
        System.out.println(opt3);
        System.out.println("-------------------------");
    }

    @Test
    public void optional() {
//        创建Employee对象
        Employee em = new Employee("Helen");
//        将其赋值为null
//        em = null;
//        NullPointerException，用of()方法，其参数不能为null
        Optional<Employee> employeeOptional = Optional.of(em);
        System.out.println(employeeOptional);  // Optional[Employee {name=null,age=0,career=null}]

//        使用ofNullable()方法，其参数可为任意值
        em = null;
        Optional<Employee> employeeOptional1 = Optional.ofNullable(em);
        System.out.println(employeeOptional1);  // Optional.empty
        System.out.println();

//      ifPresent，如果存在执行Consumer操作，void	ifPresent(Consumer<? super T> consumer)
        employeeOptional.ifPresent(Employee::show);
        System.out.println();

//        orElse用法，如果对象为null，则返回该结果，T orElse(T other)
        Employee res1 = employeeOptional.orElse(new Employee("helen"));
        Employee orElse = employeeOptional1.orElse(new Employee("helen"));
        System.out.println(res1);  // 不在null，返回其值
        System.out.println(orElse);  // 为null，返回other的值
        System.out.println();

//        T	orElseGet(Supplier<? extends T> other)用法,存在则返回值，不存在则使用Supplier结果
        Employee get = employeeOptional.orElseGet(Employee::new);
        System.out.println(get);
    }
}
