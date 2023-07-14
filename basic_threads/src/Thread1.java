public class Thread1 extends Thread {

    @Override
    public void run(){
        System.out.println(ThreadColor.ANSI_RED  + " Hello from " + currentThread().getName() );
    }

}
