package UserInterface;

public class ThreadMoveBike extends Thread {

    private BikeGif bike;

    public ThreadMoveBike (BikeGif bike) {
        super("BikeGif");

        this.bike = bike;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(10);
                bike.move();
                bike.repaint();
            }
            catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
