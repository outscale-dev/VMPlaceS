package bug;

import org.simgrid.msg.*;
import org.simgrid.msg.Process;

public class Main {
    public static void main(String[] args) throws NativeException, HostNotFoundException, HostFailureException, TaskCancelledException {
        Msg.init(args);
        Msg.createEnvironment(args[0]);
        Msg.info("Environment created");
        Msg.deployApplication(args[1]);

        Msg.run();

        Msg.info("End of run");

        System.exit(0);
    }
}
