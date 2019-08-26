package org.tangdao.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oshi.SystemInfo;
import oshi.hardware.Baseboard;
import oshi.hardware.CentralProcessor;
import oshi.hardware.CentralProcessor.TickType;
import oshi.hardware.ComputerSystem;
import oshi.hardware.Display;
import oshi.hardware.Firmware;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;
import oshi.hardware.PowerSource;
import oshi.hardware.Sensors;
import oshi.hardware.SoundCard;
import oshi.hardware.UsbDevice;
import oshi.software.os.FileSystem;
import oshi.software.os.NetworkParams;
import oshi.software.os.OSFileStore;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.software.os.OperatingSystem.ProcessSort;
import oshi.util.FormatUtil;
import oshi.util.Util;

public class OSUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(OSUtil.class);
	
	static List<String> oshi = ListUtils.newArrayList();
	
	 /**
     * The main method, demonstrating use of classes.
     *
     * @param args
     *            the arguments (unused)
     */
    public static void main(String[] args) {
    	oshi();
    }
    
    public static synchronized List<String> oshi() {
    	if(oshi!=null&&oshi.size()>0) {
    		long time = Long.valueOf(oshi.get(0));
    		if((new Date().getTime()-time)>10000) {
    			init();
    		}
    	} else {
    		init();
    	}
    	return oshi;
    }
    
    private static void init() {
    	logger.info("Initializing System...");
    	oshi = ListUtils.newArrayList();
    	oshi.add(String.valueOf(new Date().getTime()));
        try {
			printProperty();
		} catch (UnknownHostException e) {}
        
        SystemInfo si = new SystemInfo();
        
        HardwareAbstractionLayer hal = si.getHardware();
        OperatingSystem os = si.getOperatingSystem();

        printOperatingSystem(os);

//        logger.info("Checking computer system...");
        printComputerSystem(hal.getComputerSystem());

//        logger.info("Checking Processor...");
        printProcessor(hal.getProcessor());

//        logger.info("Checking Memory...");
        printMemory(hal.getMemory());

//        logger.info("Checking CPU...");
        printCpu(hal.getProcessor());

//        logger.info("Checking Processes...");
        printProcesses(os, hal.getMemory());

//        logger.info("Checking Sensors...");
        printSensors(hal.getSensors());

//        logger.info("Checking Power sources...");
        printPowerSources(hal.getPowerSources());

//        logger.info("Checking Disks...");
        printDisks(hal.getDiskStores());

//        logger.info("Checking File System...");
        printFileSystem(os.getFileSystem());

//        logger.info("Checking Network interfaces...");
        printNetworkInterfaces(hal.getNetworkIFs());

//        logger.info("Checking Network parameters...");
        printNetworkParameters(os.getNetworkParams());

        // hardware：displays
//        logger.info("Checking Displays...");
        printDisplays(hal.getDisplays());

        // hardware：USB devices
//        logger.info("Checking USB Devices...");
        printUsbDevices(hal.getUsbDevices(true));

//        logger.info("Checking Sound Cards...");
        printSoundCards(hal.getSoundCards());

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < oshi.size(); i++) {
            output.append(oshi.get(i));
            if (oshi.get(i) != null && !oshi.get(i).endsWith("\n")) {
                output.append('\n');
            }
        }
        logger.info("Printing Operating System and Hardware Info：{}{}", '\n', output);
    }

    private static void printOperatingSystem(final OperatingSystem os) {
        oshi.add(String.valueOf(os));
        oshi.add("Booted：" + Instant.ofEpochSecond(os.getSystemBootTime()));
        oshi.add("Uptime：" + FormatUtil.formatElapsedSecs(os.getSystemUptime()));
        oshi.add("Running with" + (os.isElevated() ? "" :"out") + " elevated permissions.");
    }

    private static void printComputerSystem(final ComputerSystem computerSystem) {
//        oshi.add("system：" + computerSystem.toString());
//        oshi.add(" firmware：" + computerSystem.getFirmware().toString());
//        oshi.add(" baseboard：" + computerSystem.getBaseboard().toString());
    	oshi.add("manufacturer：" + computerSystem.getManufacturer());
    	oshi.add("model：" + computerSystem.getModel());
    	oshi.add("serialnumber：" + computerSystem.getSerialNumber());
         final Firmware firmware = computerSystem.getFirmware();
         oshi.add("firmware：");
         oshi.add("  manufacturer：" + firmware.getManufacturer());
         oshi.add("  name：" + firmware.getName());
         oshi.add("  description：" + firmware.getDescription());
         oshi.add("  version：" + firmware.getVersion());
         oshi.add("  release date：" + (firmware.getReleaseDate() == null ? "unknown"
                 :firmware.getReleaseDate() == null ? "unknown" :DateUtils.parseDate(firmware.getReleaseDate())));
         final Baseboard baseboard = computerSystem.getBaseboard();
         oshi.add("baseboard：");
         oshi.add("  manufacturer：" + baseboard.getManufacturer());
         oshi.add("  model：" + baseboard.getModel());
         oshi.add("  version：" + baseboard.getVersion());
         oshi.add("  serialnumber：" + baseboard.getSerialNumber());
    }

    private static void printProcessor(CentralProcessor processor) {
        oshi.add(processor.toString());
        oshi.add(" " + processor.getPhysicalPackageCount() + " physical CPU package(s)");
        oshi.add(" " + processor.getPhysicalProcessorCount() + " physical CPU core(s)");
        oshi.add(" " + processor.getLogicalProcessorCount() + " logical CPU(s)");

        oshi.add("Identifier：" + processor.getIdentifier());
        oshi.add("ProcessorID：" + processor.getProcessorID());
    }

    private static void printMemory(GlobalMemory memory) {
//        oshi.add("Memory：\n " + JsonMapper.toJson(memory));
//        VirtualMemory vm = memory.getVirtualMemory();
//        oshi.add("Swap：\n " + JsonMapper.toJson(vm));
    	oshi.add("Memory：" + FormatUtil.formatBytes(memory.getAvailable()) + "/"
                + FormatUtil.formatBytes(memory.getTotal()));
    	oshi.add("Swap used：" + FormatUtil.formatBytes(memory.getVirtualMemory().getSwapUsed()) + "/"
                + FormatUtil.formatBytes(memory.getVirtualMemory().getSwapTotal()));
    }

    private static void printCpu(CentralProcessor processor) {
        oshi.add("Context Switches/Interrupts：" + processor.getContextSwitches() + " / " + processor.getInterrupts());

        long[] prevTicks = processor.getSystemCpuLoadTicks();
        long[][] prevProcTicks = processor.getProcessorCpuLoadTicks();
        oshi.add("CPU, IOWait, and IRQ ticks @ 0 sec：" + Arrays.toString(prevTicks));
        // Wait a second...
        Util.sleep(1000);
        long[] ticks = processor.getSystemCpuLoadTicks();
        oshi.add("CPU, IOWait, and IRQ ticks @ 1 sec：" + Arrays.toString(ticks));
        long user = ticks[TickType.USER.getIndex()] - prevTicks[TickType.USER.getIndex()];
        long nice = ticks[TickType.NICE.getIndex()] - prevTicks[TickType.NICE.getIndex()];
        long sys = ticks[TickType.SYSTEM.getIndex()] - prevTicks[TickType.SYSTEM.getIndex()];
        long idle = ticks[TickType.IDLE.getIndex()] - prevTicks[TickType.IDLE.getIndex()];
        long iowait = ticks[TickType.IOWAIT.getIndex()] - prevTicks[TickType.IOWAIT.getIndex()];
        long irq = ticks[TickType.IRQ.getIndex()] - prevTicks[TickType.IRQ.getIndex()];
        long softirq = ticks[TickType.SOFTIRQ.getIndex()] - prevTicks[TickType.SOFTIRQ.getIndex()];
        long steal = ticks[TickType.STEAL.getIndex()] - prevTicks[TickType.STEAL.getIndex()];
        long totalCpu = user + nice + sys + idle + iowait + irq + softirq + steal;

        oshi.add(String.format(
                "User：%.1f%% Nice：%.1f%% System：%.1f%% Idle：%.1f%% IOwait：%.1f%% IRQ：%.1f%% SoftIRQ：%.1f%% Steal：%.1f%%",
                100d * user / totalCpu, 100d * nice / totalCpu, 100d * sys / totalCpu, 100d * idle / totalCpu,
                100d * iowait / totalCpu, 100d * irq / totalCpu, 100d * softirq / totalCpu, 100d * steal / totalCpu));
        oshi.add(String.format("CPU load：%.1f%%", processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100));
        double[] loadAverage = processor.getSystemLoadAverage(3);
        oshi.add("CPU load averages：" + (loadAverage[0] < 0 ? " N/A" :String.format(" %.2f", loadAverage[0]))
                + (loadAverage[1] < 0 ? " N/A" :String.format(" %.2f", loadAverage[1]))
                + (loadAverage[2] < 0 ? " N/A" :String.format(" %.2f", loadAverage[2])));
        // per core CPU
        StringBuilder procCpu = new StringBuilder("CPU load per processor：");
        double[] load = processor.getProcessorCpuLoadBetweenTicks(prevProcTicks);
        for (double avg :load) {
            procCpu.append(String.format(" %.1f%%", avg * 100));
        }
        oshi.add(procCpu.toString());
        long freq = processor.getVendorFreq();
        if (freq > 0) {
            oshi.add("Vendor Frequency：" + FormatUtil.formatHertz(freq));
        }
        freq = processor.getMaxFreq();
        if (freq > 0) {
            oshi.add("Max Frequency：" + FormatUtil.formatHertz(freq));
        }
        long[] freqs = processor.getCurrentFreq();
        if (freqs[0] > 0) {
            StringBuilder sb = new StringBuilder("Current Frequencies：");
            for (int i = 0; i < freqs.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(FormatUtil.formatHertz(freqs[i]));
            }
            oshi.add(sb.toString());
        }
    }

    private static void printProcesses(OperatingSystem os, GlobalMemory memory) {
        oshi.add("Processes：" + os.getProcessCount() + ", Threads：" + os.getThreadCount());
        // Sort by highest CPU
        List<OSProcess> procs = Arrays.asList(os.getProcesses(5, ProcessSort.CPU));

        oshi.add("   PID  %CPU %MEM       VSZ       RSS Name");
        for (int i = 0; i < procs.size() && i < 5; i++) {
            OSProcess p = procs.get(i);
            oshi.add(String.format(" %5d %5.1f %4.1f %9s %9s %s", p.getProcessID(),
                    100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime(),
                    100d * p.getResidentSetSize() / memory.getTotal(), FormatUtil.formatBytes(p.getVirtualSize()),
                    FormatUtil.formatBytes(p.getResidentSetSize()), p.getName()));
        }
    }

    private static void printSensors(Sensors sensors) {
        oshi.add("Sensors：" + sensors.toString());
    }

    private static void printPowerSources(PowerSource[] powerSources) {
        StringBuilder sb = new StringBuilder("Power：");
        if (powerSources.length == 0) {
            sb.append("Unknown");
        }
        for (PowerSource powerSource :powerSources) {
            sb.append("\n ").append(powerSource.toString());
        }
        oshi.add(sb.toString());
    }

    private static void printDisks(HWDiskStore[] diskStores) {
        oshi.add("Disks：");
        for (HWDiskStore disk :diskStores) {
            oshi.add(" " + disk.toString());

            HWPartition[] partitions = disk.getPartitions();
            for (HWPartition part :partitions) {
                oshi.add(" |-- " + part.toString());
            }
        }

    }

    private static void printFileSystem(FileSystem fileSystem) {
        oshi.add("File System：");

        oshi.add(String.format(" File Descriptors：%d/%d", fileSystem.getOpenFileDescriptors(),
                fileSystem.getMaxFileDescriptors()));

        OSFileStore[] fsArray = fileSystem.getFileStores();
        for (OSFileStore fs :fsArray) {
            long usable = fs.getUsableSpace();
            long total = fs.getTotalSpace();
            oshi.add(String.format(
                    " %s (%s) [%s] %s of %s free (%.1f%%), %s of %s files free (%.1f%%) is %s "
                            + (fs.getLogicalVolume() != null && fs.getLogicalVolume().length() > 0 ? "[%s]" :"%s")
                            + " and is mounted at %s",
                    fs.getName(), fs.getDescription().isEmpty() ? "file system" :fs.getDescription(), fs.getType(),
                    FormatUtil.formatBytes(usable), FormatUtil.formatBytes(fs.getTotalSpace()), 100d * usable / total,
                    FormatUtil.formatValue(fs.getFreeInodes(), ""), FormatUtil.formatValue(fs.getTotalInodes(), ""),
                    100d * fs.getFreeInodes() / fs.getTotalInodes(), fs.getVolume(), fs.getLogicalVolume(),
                    fs.getMount()));
        }
    }

    private static void printNetworkInterfaces(NetworkIF[] networkIFs) {
        oshi.add("Network interfaces：");
        for (NetworkIF net :networkIFs) {
            oshi.add(String.format(" Name：%s (%s)%n", net.getName(), net.getDisplayName()));
            oshi.add(String.format("   MAC Address：%s %n", net.getMacaddr()));
            oshi.add(String.format("   MTU：%s, Speed：%s %n", net.getMTU(),
                    FormatUtil.formatValue(net.getSpeed(), "bps")));
            oshi.add(String.format("   IPv4：%s %n", Arrays.toString(net.getIPv4addr())));
            oshi.add(String.format("   IPv6：%s %n", Arrays.toString(net.getIPv6addr())));
            boolean hasData = net.getBytesRecv() > 0 || net.getBytesSent() > 0 || net.getPacketsRecv() > 0
                    || net.getPacketsSent() > 0;
            oshi.add(String.format("   Traffic：received %s/%s%s; transmitted %s/%s%s",
                    hasData ? net.getPacketsRecv() + " packets" :"?",
                    hasData ? FormatUtil.formatBytes(net.getBytesRecv()) :"?",
                    hasData ? " (" + net.getInErrors() + " err)" :"",
                    hasData ? net.getPacketsSent() + " packets" :"?",
                    hasData ? FormatUtil.formatBytes(net.getBytesSent()) :"?",
                    hasData ? " (" + net.getOutErrors() + " err)" :""));
        }
    }

    private static void printNetworkParameters(NetworkParams networkParams) {
        oshi.add("Network parameters：");
        oshi.add(String.format(" Host name：%s%n", networkParams.getHostName()));
        oshi.add(String.format(" Domain name：%s%n", networkParams.getDomainName()));
        oshi.add(String.format(" DNS servers：%s%n", Arrays.toString(networkParams.getDnsServers())));
        oshi.add(String.format(" IPv4 Gateway：%s%n", networkParams.getIpv4DefaultGateway()));
        oshi.add(String.format(" IPv6 Gateway：%s%n", networkParams.getIpv6DefaultGateway()));
    }

    private static void printDisplays(Display[] displays) {
        oshi.add("Displays：");
        int i = 0;
        for (Display display :displays) {
            oshi.add(" Display " + i + "：");
            oshi.add(String.valueOf(display));
            i++;
        }
    }

    private static void printUsbDevices(UsbDevice[] usbDevices) {
        oshi.add("USB Devices：");
        for (UsbDevice usbDevice :usbDevices) {
            oshi.add(String.valueOf(usbDevice));
        }
    }

    private static void printSoundCards(SoundCard[] cards) {
        oshi.add("Sound Cards：");
        for (SoundCard card :cards) {
            oshi.add(String.valueOf(card));
        }
    }
    
    private static void printProperty() throws UnknownHostException {
        Runtime r = Runtime.getRuntime();
        Properties props = System.getProperties();
        InetAddress addr;
        addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress();
        Map<String, String> map = System.getenv();
        String userName = map.get("USERNAME");// 获取用户名
        String computerName = map.get("COMPUTERNAME");// 获取计算机名
        String userDomain = map.get("USERDOMAIN");// 获取计算机域名
        oshi.add("用户名：" + userName);
        oshi.add("计算机名：" + computerName);
        oshi.add("计算机域名：" + userDomain);
        oshi.add("本地ip地址：" + ip);
        oshi.add("本地主机名：" + addr.getHostName());
        oshi.add("JVM可以使用的总内存：" + r.totalMemory());
        oshi.add("JVM可以使用的剩余内存：" + r.freeMemory());
        oshi.add("JVM可以使用的处理器个数：" + r.availableProcessors());
        oshi.add("Java的运行环境版本：" + props.getProperty("java.version"));
        oshi.add("Java的运行环境供应商：" + props.getProperty("java.vendor"));
        oshi.add("Java供应商的URL：" + props.getProperty("java.vendor.url"));
        oshi.add("Java的安装路径：" + props.getProperty("java.home"));
        oshi.add("Java的虚拟机规范版本：" + props.getProperty("java.vm.specification.version"));
        oshi.add("Java的虚拟机规范供应商：" + props.getProperty("java.vm.specification.vendor"));
        oshi.add("Java的虚拟机规范名称：" + props.getProperty("java.vm.specification.name"));
        oshi.add("Java的虚拟机实现版本：" + props.getProperty("java.vm.version"));
        oshi.add("Java的虚拟机实现供应商：" + props.getProperty("java.vm.vendor"));
        oshi.add("Java的虚拟机实现名称：" + props.getProperty("java.vm.name"));
        oshi.add("Java运行时环境规范版本：" + props.getProperty("java.specification.version"));
        oshi.add("Java运行时环境规范供应商：" + props.getProperty("java.specification.vender"));
        oshi.add("Java运行时环境规范名称：" + props.getProperty("java.specification.name"));
        oshi.add("Java的类格式版本号：" + props.getProperty("java.class.version"));
        oshi.add("Java的类路径：" + props.getProperty("java.class.path"));
        oshi.add("加载库时搜索的路径列表：" + props.getProperty("java.library.path"));
        oshi.add("默认的临时文件路径：" + props.getProperty("java.io.tmpdir"));
        oshi.add("一个或多个扩展目录的路径：" + props.getProperty("java.ext.dirs"));
        oshi.add("操作系统的名称：" + props.getProperty("os.name"));
        oshi.add("操作系统的构架：" + props.getProperty("os.arch"));
        oshi.add("操作系统的版本：" + props.getProperty("os.version"));
        oshi.add("文件分隔符：" + props.getProperty("file.separator"));
        oshi.add("路径分隔符：" + props.getProperty("path.separator"));
        oshi.add("行分隔符：" + props.getProperty("line.separator"));
        oshi.add("用户的账户名称：" + props.getProperty("user.name"));
        oshi.add("用户的主目录：" + props.getProperty("user.home"));
        oshi.add("用户的当前工作目录：" + props.getProperty("user.dir"));
    }

}