import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.CloudletSchedulerSpaceShared;
import org.cloudbus.cloudsim.Datacenter;
import org.cloudbus.cloudsim.DatacenterCharacteristics;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Pe;
import org.cloudbus.cloudsim.Storage;
import org.cloudbus.cloudsim.UtilizationModel;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.Vm;
import org.cloudbus.cloudsim.VmAllocationPolicySimple;
import org.cloudbus.cloudsim.VmSchedulerTimeShared;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;

/**
 * One datacenter, one host, one VM and four cloudlets of different lengths.
 * The cloudlets are created in a mixed order and scheduled by SjfBroker.
 */
public class SjfSchedulingExample {

    // Lengths in MI, deliberately not in sorted order
    private static final long[] CLOUDLET_LENGTHS = {40000, 10000, 30000, 20000};

    public static void main(String[] args) {
        try {
            CloudSim.init(1, Calendar.getInstance(), false);

            createDatacenter("Datacenter_0");

            SjfBroker broker = new SjfBroker("SjfBroker");
            int brokerId = broker.getId();

            // Space-shared: the VM runs one cloudlet at a time, the rest wait in a queue
            List<Vm> vmList = new ArrayList<Vm>();
            vmList.add(new Vm(0, brokerId, 1000, 1, 512, 1000, 10000, "Xen",
                    new CloudletSchedulerSpaceShared()));
            broker.submitVmList(vmList);

            UtilizationModel full = new UtilizationModelFull();
            List<Cloudlet> cloudletList = new ArrayList<Cloudlet>();
            for (int id = 0; id < CLOUDLET_LENGTHS.length; id++) {
                Cloudlet cloudlet = new Cloudlet(id, CLOUDLET_LENGTHS[id], 1, 300, 300,
                        full, full, full);
                cloudlet.setUserId(brokerId);
                cloudlet.setVmId(0);
                cloudletList.add(cloudlet);
            }
            broker.submitCloudletList(cloudletList);

            CloudSim.startSimulation();
            CloudSim.stopSimulation();

            List<Cloudlet> finished = broker.getCloudletReceivedList();
            printResults(finished);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Datacenter createDatacenter(String name) throws Exception {
        List<Pe> peList = new ArrayList<Pe>();
        peList.add(new Pe(0, new PeProvisionerSimple(1000)));

        List<Host> hostList = new ArrayList<Host>();
        hostList.add(new Host(0, new RamProvisionerSimple(2048), new BwProvisionerSimple(10000),
                1000000, peList, new VmSchedulerTimeShared(peList)));

        DatacenterCharacteristics characteristics = new DatacenterCharacteristics(
                "x86", "Linux", "Xen", hostList, 10.0, 3.0, 0.05, 0.001, 0.0);

        return new Datacenter(name, characteristics, new VmAllocationPolicySimple(hostList),
                new LinkedList<Storage>(), 0);
    }

    private static void printResults(List<Cloudlet> list) {
        DecimalFormat dft = new DecimalFormat("###.##");

        double firstStart = Double.MAX_VALUE;
        for (Cloudlet cloudlet : list) {
            firstStart = Math.min(firstStart, cloudlet.getExecStartTime());
        }

        System.out.println();
        System.out.println("========== SJF SCHEDULING OUTPUT ==========");
        System.out.println("Cloudlet ID\tLength\tSTATUS\tVM ID\tStart\tFinish\tWaiting");

        double totalWaiting = 0;
        for (Cloudlet cloudlet : list) {
            // Time spent queued behind the cloudlets that ran before this one
            double waiting = cloudlet.getExecStartTime() - firstStart;
            totalWaiting += waiting;

            String status = cloudlet.getCloudletStatus() == Cloudlet.SUCCESS ? "SUCCESS" : "FAILED";
            System.out.println(cloudlet.getCloudletId() + "\t\t"
                    + cloudlet.getCloudletLength() + "\t"
                    + status + "\t"
                    + cloudlet.getVmId() + "\t"
                    + dft.format(cloudlet.getExecStartTime()) + "\t"
                    + dft.format(cloudlet.getFinishTime()) + "\t"
                    + dft.format(waiting));
        }

        System.out.println("Average waiting time: " + dft.format(totalWaiting / list.size()));
    }
}
