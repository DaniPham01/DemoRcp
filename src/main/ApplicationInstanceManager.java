package main;


public class ApplicationInstanceManager {
        private static ApplicationInstanceListener subListener;

    /** Randomly chosen, but static, high socket number */
    public static final int SINGLE_INSTANCE_NETWORK_SOCKET = 6000;

    /** Must end with newline */
    public static final String SINGLE_INSTANCE_SHARED_KEY = "$$NewInstance$$\n";

    /**
     * Registers this instance of the application.
     *
     * @return true if first instance, false if not.
     */
    public static boolean registerInstance() {
    	 return true;
    }

    public static void setApplicationInstanceListener(ApplicationInstanceListener listener) {
        subListener = listener;
    }
}