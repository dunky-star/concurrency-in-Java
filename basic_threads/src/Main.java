public class Main {
    public static void main(String[] args)
    {
        System.out.println(ThreadColor.ANSI_BLUE + "\nThreads construction in Java!");
        // Creating a thread using subclass.
        Thread thread1 = new Thread1();
        thread1.setName("== Thread 1 ==");
        // To invoke the run method in thread1.
        thread1.start();

        // Creating an anonymous thread.
        new Thread() {
            public void run(){
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class thread.");
            }
        }.start();

        // Another way of creating Thread using Runnable
        Thread myRunnableThread = new Thread(new MyRunnable(){

            // Creating anonymous class with Runnable
            @Override
            public void run(){
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class implementation of run()");
                // To join a thread without waiting.
                try {
                    thread1.join();
                } catch (InterruptedException e){
                    System.out.println("I couldn't wait after all. I was interrupted");
                }
            }
        });
        myRunnableThread.start();
        // Interrupting a thread.
        // thread1.interrupt();
        System.out.println(ThreadColor.ANSI_BLUE + "Hello again from the main thread.");
    }
}