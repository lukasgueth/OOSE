public class Zähler {
    public int counter = 0;

    public void inkrementiereCounter() {
        if (this.counter < 1000) {
            this.counter++;
            System.out.println(
                "counter: " + this.counter +
                ", Thread: " + Thread.currentThread().getName()
            );
        }
    }
}
