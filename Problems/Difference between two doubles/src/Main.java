import java.util.Random;

class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int lower = 10;
        int upper = 100;
        System.out.println(random.nextInt(upper - lower + 1) + lower);
    }
}