package Synchronization;

class SharedResource {
    synchronized void display(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class ThreadDemo extends Thread {
    SharedResource resource;
    String message;

    ThreadDemo(SharedResource res, String msg) {
        resource = res;
        message = msg;
    }

    public void run() {
        resource.display(message);
    }
}

public class SyncDemo {

	public static void main(String[] args) {
		SharedResource resource = new SharedResource();
        ThreadDemo t1 = new ThreadDemo(resource, "Hello");
        ThreadDemo t2 = new ThreadDemo(resource, "World");

        t1.start();
        t2.start();

	}

}
