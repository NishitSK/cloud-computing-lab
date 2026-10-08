# CloudSim SJF Scheduling

A cloud scenario simulated with **CloudSim**, using a **Shortest Job First (SJF)** scheduling algorithm that CloudSim does not provide out of the box.

---

## About

CloudSim's default broker sends cloudlets (tasks) to a virtual machine in the order they were submitted. This exercise adds a broker that sorts the cloudlets by length first, so the shortest one runs first.

The simulated scenario:

| Entity | Configuration |
|---|---|
| Datacenter | 1 host with one 1000 MIPS core, 2048 MB RAM |
| Virtual machine | 1 VM, 1000 MIPS, 512 MB RAM, space-shared cloudlet scheduler |
| Cloudlets | 4 cloudlets with lengths 40000, 10000, 30000 and 20000 MI |

Because the VM is space-shared, it runs one cloudlet at a time and the rest wait in a queue. That makes the effect of the ordering visible in the start and finish times.

With SJF the cloudlets run in the order 1, 3, 2, 0 (shortest to longest). At 1000 MIPS they take 10, 20, 30 and 40 seconds, so the waiting times are 0, 10, 30 and 60 seconds, an average of 25 seconds. In the submitted order (0, 1, 2, 3) the average would be 42.5 seconds.

---

## Technologies Used

- CloudSim 3.0.3
- Java (JDK 8 or later)
- Eclipse IDE or the command line

---

## Steps

### 1. Download CloudSim

Download `cloudsim-3.0.3.zip` from https://github.com/Cloudslab/cloudsim/releases/tag/cloudsim-3.0.3 and extract it. The library is `jars/cloudsim-3.0.3.jar`.

### 2. Set up the project

Copy `cloudsim-3.0.3.jar` into this folder, next to the two `.java` files.

In Eclipse instead: create a Java project, add both `.java` files to `src`, then **Build Path > Add External Archives** and select the jar.

### 3. Compile

```bash
javac -cp cloudsim-3.0.3.jar SjfBroker.java SjfSchedulingExample.java
```

### 4. Run

On Windows:

```bash
java -cp ".;cloudsim-3.0.3.jar" SjfSchedulingExample
```

On Linux or macOS:

```bash
java -cp ".:cloudsim-3.0.3.jar" SjfSchedulingExample
```

### 5. Read the output

The program prints CloudSim's event log, then a table with the start time, finish time and waiting time of each cloudlet, followed by the average waiting time.

---

## How the Scheduler Works

[SjfBroker.java](SjfBroker.java) extends `DatacenterBroker` and overrides `submitCloudletList()`. It sorts the cloudlets by `getCloudletLength()` in ascending order before passing them to the default broker logic.

[SjfSchedulingExample.java](SjfSchedulingExample.java) creates the datacenter, the VM and the cloudlets, runs the simulation and prints the results.

---

## Project Structure

```
.
├── SjfBroker.java
├── SjfSchedulingExample.java
└── README.md
```

---

## Screenshots

Not added yet. To capture after the run:

- The program running in Eclipse or the terminal
- The output table with the average waiting time
