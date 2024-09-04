public class MyDesserts {
    abstract class Dessert {
        abstract String ingredients();
        abstract String name();
        abstract String where();
        public String toString() {
            return name() + " contains " + ingredients() + " and the best comes from " + where();
        }

    }
    class Cake extends Dessert {
        String ingredients() {
            return "flour, sugar, eggs, butter, baking powder";
        }
        String name() {
            return "Cake";
        }
        String where() {
            return "My Mom's Kitchen";
        }
    }
    class IceCream extends Dessert {
        String ingredients() {
            return "milk, sugar, cream, strawberries";
        }
        String name() {
            return "Ice Cream";
        }
        String where() {
            return "Basket Robbins";
        }
    }
    class Pizza extends Dessert {
        String ingredients() {
            return "flour, sugar, eggs, butter, baking powder, pepperoni";
        }
        String name() {
            return "Pizza";
        }
        String where() {
            return "Domino's Pizza";
        }
    }

    public static void main(String[] args) {
        //randomly select a dessert
        MyDesserts myDesserts = new MyDesserts();
        MyDesserts.Dessert[] desserts = {myDesserts.new Cake(), myDesserts.new IceCream(), myDesserts.new Pizza()};
        int random = (int) (Math.random() * 3);
        System.out.println(desserts[random]);
    }
}
