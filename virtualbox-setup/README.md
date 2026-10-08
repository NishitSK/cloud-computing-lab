# VirtualBox Setup with Linux and Windows Guests

Installing **Oracle VirtualBox** on a Windows host and creating virtual machines that run different guest operating systems.

---

## About

This exercise sets up a hosted (type 2) hypervisor on a personal machine and uses it to run more than one operating system side by side.

It covers:

- Installing VirtualBox on the Windows host
- Creating a virtual machine and installing Ubuntu from an ISO image
- Creating a second virtual machine with a different OS flavor
- Checking that each guest boots and reports its own OS

---

## Technologies Used

- Oracle VirtualBox
- Windows (host OS)
- Ubuntu Desktop ISO (first guest)
- A second guest ISO, for example Linux Mint, Fedora or Windows 10

---

## Steps

### 1. Install VirtualBox

1. Download the **Windows hosts** installer from https://www.virtualbox.org/wiki/Downloads
2. Run the installer and keep the default features.
3. Accept the warning that the network connection resets for a moment.
4. Click **Install**, then **Finish**.

Hardware virtualization (Intel VT-x or AMD-V) has to be enabled in the BIOS for 64-bit guests to run.

### 2. Create a virtual machine

In VirtualBox Manager click **New** and use these settings:

| Setting | Value |
|---|---|
| Name | `ubuntu-vm` |
| Type / Version | Linux / Ubuntu (64-bit) |
| Base memory | 2048 MB or more |
| Processors | 2 |
| Hard disk | VDI, dynamically allocated, 25 GB |

### 3. Attach the ISO

Open **Settings > Storage**, select the empty optical drive and choose the downloaded ISO file.

### 4. Install the guest OS

Start the VM and follow the installer. Restart the VM when the installer finishes.

### 5. Verify the guest

```bash
lsb_release -a
```

```bash
uname -r
```

### 6. Add a second OS flavor

Repeat steps 2 to 5 with a different ISO and the matching **Type / Version**. On a Windows guest, run `winver` to show the OS version.

---

## Project Structure

```
.
└── README.md
```

---

## Screenshots

Not added yet. To capture after the run:

- VirtualBox Manager listing both virtual machines
- First guest desktop with the `lsb_release -a` output
- Second guest desktop showing its OS version
