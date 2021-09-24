package maxamx.processor;

import io.smallrye.reactive.messaging.annotations.Blocking;
import maxamx.model.Customer;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@ApplicationScoped
public class CustomerProcessor {

    private Random random = new Random();

    @Incoming("2mgt1okd-customers-requests")
    @Outgoing("2mgt1okd-customers")
    @Blocking
    public Customer process(String name, String nameLast, String document) throws InterruptedException {
        Thread.sleep(200);
        return new Customer(random.nextLong(),name,nameLast,document);
    }
}
