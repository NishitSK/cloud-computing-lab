# C Program in a VirtualBox VM

Installing a C compiler inside an **Ubuntu** virtual machine running on **VirtualBox**, then compiling and running a simple program with **gcc**.

---

## About

This exercise uses the virtual machine from [virtualbox-setup](../virtualbox-setup/) as a development machine.

It covers:

- Installing `gcc` in the guest OS
- Writing a small C program in the VM
- Compiling it and running the executable

The program in [sum.c](sum.c) reads two whole numbers and prints their sum.

---

## Technologies Used

- Oracle VirtualBox
- Ubuntu (guest OS)
- GCC (`build-essential` package)
- C

---

## Steps

### 1. Update the package list

```bash
sudo apt update
```

### 2. Install the compiler

```bash
sudo apt install build-essential -y
```

### 3. Check the installation

```bash
gcc --version
```

### 4. Create the source file

```bash
nano sum.c
```

Type in the contents of [sum.c](sum.c), then save with `Ctrl+O` and exit with `Ctrl+X`.

### 5. Compile

```bash
gcc sum.c -o sum
```

### 6. Run

```bash
./sum
```

Example run:

```
Enter two numbers: 65 23
Sum of 65 and 23 is 88
```

---

## Project Structure

```
.
├── sum.c
└── README.md
```

---

## Screenshots

Not added yet. To capture after the run:

- `gcc --version` output in the VM terminal
- The program being compiled and run in the VM terminal
