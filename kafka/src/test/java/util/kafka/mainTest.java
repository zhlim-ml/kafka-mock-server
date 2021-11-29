package util.kafka;

import java.util.function.Consumer;

public class mainTest {
    public static void main(String[] args){
        Consumers test = new Consumers("cashAdvance.repayment-date-deferred");
        test.readValue().stream().forEach(System.out::println);
    }
}
