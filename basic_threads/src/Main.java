public class Main {
    public static void main(String[] args)
    {
        System.out.println(ThreadColor.ANSI_BLUE + "\nThreads construction in Java!");
        Thread thread1 = new Thread1();
        // To invoke the run method in thread1.
        thread1.start();

        // Creating an anonymous thread.
        new Thread() {
            public void run(){
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class thread.");
            }
        }.start();

        // Another way of creating Thread
        Thread myRunnableThread = new Thread(new MyRunnable(){

            // Creating anonymous class with Runnable
            @Override
            public void run(){
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class implementation of run()");
            }
        });
        myRunnableThread.start();
        System.out.println(ThreadColor.ANSI_BLUE + "Hello again from the main thread.");
    }
}