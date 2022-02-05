/*
    Create a class Product having some attributes of your choice.
Demonstrate the use of stream APIs like
1. Max
2. Min
3. Any match
4. All match
5. Filter
6. Sorted
7. GroupingBy
Also
● Find the average price of the products
● Find the sum of all the prices after incrementing the prices by 25%
(No need to explain in the recording)


 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Program1 {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product("Pen", 100.0));
        products.add(new Product("Notebook", 175.0));
        products.add(new Product("Pencil", 20.0));
        products.add(new Product("Mouse", 1010.0));
        products.add(new Product("Cable", 230.0));

        Optional<Product> optionalProductWithMaxPrice = products.stream().max((x, y) -> x.price.compareTo(y.price));
        System.out.println("The max price element is: " + optionalProductWithMaxPrice.get().name + " " + optionalProductWithMaxPrice.get().price);


        Optional<Product> optionalProductWithMinPrice = products.stream().min((x, y) -> x.price.compareTo(y.price));
        System.out.println("The min price element is: " + optionalProductWithMinPrice.get().name + " " + optionalProductWithMinPrice.get().price);

        boolean isAnyProductCostlyThan1000 = products.stream().anyMatch(x -> x.price>1000);
        System.out.println("Is there any product with price > 1000 " + isAnyProductCostlyThan1000);

        boolean areAllProductsCostlyThan100 = products.stream().allMatch(x -> x.price>100);
        System.out.println("Are all products costly than 100? " + isAnyProductCostlyThan1000);

        System.out.println("All the items having price > 100: ");
        Stream<Product> priceMoreThan100 = products.stream().filter(x -> x.price > 100);
        Iterator<Product> it = priceMoreThan100.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().name);
        }

        System.out.println("Price in sorted order: ");
        products.stream().sorted((x, y) -> x.price.compareTo(y.price)).forEach(z -> System.out.println(z.price));

        System.out.println("Counting products");
        Map<Product, Long> countingProducts = products.stream().collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));
        System.out.println(countingProducts);

        System.out.println("Average price: ");
        Double sum = products.stream().map(x -> x.getPrice()).reduce(0.0, Double::sum);
        System.out.println(sum/products.size());

        System.out.println("Sum of price after incrementing by 25%: ");
        sum = products.stream().map(x -> x.getPrice()*1.25).reduce(0.0, Double::sum);
        System.out.println(sum);

    }
}

class Product {
    String name;
    Double price;

    Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
    Double getPrice() {
        return this.price;
    }
}