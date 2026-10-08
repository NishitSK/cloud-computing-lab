import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.DatacenterBroker;

/**
 * Broker that applies Shortest Job First: cloudlets are handed to the VM
 * in ascending order of length instead of the order they were created in.
 */
public class SjfBroker extends DatacenterBroker {

    public SjfBroker(String name) throws Exception {
        super(name);
    }

    @Override
    public void submitCloudletList(List<? extends Cloudlet> list) {
        List<Cloudlet> sorted = new ArrayList<Cloudlet>(list);
        Collections.sort(sorted, new Comparator<Cloudlet>() {
            @Override
            public int compare(Cloudlet a, Cloudlet b) {
                return Long.compare(a.getCloudletLength(), b.getCloudletLength());
            }
        });
        super.submitCloudletList(sorted);
    }
}
