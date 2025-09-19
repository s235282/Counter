## Environment setup for the Advanced Operating Systems course

This is not a graded lab. This document provides you with a guide
to set up a kernel development environment. Throughout the semester,
we will be using Linux kernel version **v6.15** for labs.

## Environment setup

To not affect your host system, we recommend using a virtual machine
for kernel testing. To create a virtual machine you might check QEMU,
VMware, WSL, Multipass, etc. Following are the steps for setting up a
VM using VirtualBox:

- Download the [VirtualBox](https://www.virtualbox.org/) installer for your host OS.
- Download an Ubuntu image (25.04). If you don't want a GUI, please install the server edition.
- Create a new VM
    - disk >= 64GB, RAM >= 4GB
    - Add port forwarding rule
        - protocol: TCP, host IP: 127.0.0.1
        - host port: 2222, guest port: 22
    - Use `Shared folders` for file sharing between the Linux VM and your host

## Getting the kernel source code

Now you need to download and install the Linux kernel. Follow these steps inside your VM.

Install the required dependencies:

```sh
sudo apt install build-essential libncurses-dev bison flex libssl-dev libelf-dev dwarves fakeroot libdw-dev debhelper-compat git gcc
```

Get the kernel source:

```sh
git clone https://github.com/torvalds/linux.git

git checkout v6.15
```

Create the `.config` file:

```sh
make olddefconfig

```

Compile and install the kernel:

```sh
make -j$(nproc)
sudo make modules_install
sudo make install
```

Update the grub:

```sh
sudo update-grub
```

And reboot the machine:

```sh
sudo reboot
```

Then check the kernel version:

```sh
uname -r
```
