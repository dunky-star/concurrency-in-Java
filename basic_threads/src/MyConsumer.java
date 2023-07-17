import java.util.List;

class MyConsumer implements Runnable {
    private final List<String> buffer;
    private final String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        while(true) {
            if(buffer.isEmpty()) {
                continue;
            }
            if(buffer.get(0).equals(Main.EOF)) {
                System.out.println(color + "Exiting");
                break;
            } else {
                System.out.println(color + "Removed " + buffer.remove(0));
            }
        }
    }
}
