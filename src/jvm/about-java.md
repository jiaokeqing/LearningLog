1.1 Java优势：
    1>摆脱了硬件平台的束缚，实现“一次编译，到处运行”
    2>提供了一种相对安全的内存管理和访问机制，避免了绝大部分内存泄漏和指针越界的问题
    3>实现了热点代码检测和运行时编译及优化
    4>拥有完善的应用程序接口和第三方类库

1.2 Java技术体系
    1.2.1 JDK: Java程序设计语言、Java虚拟机、Java类库。JDK是用于支持Java程序开发的最小环境
    1.2.2 JRE: Java类库API中的Java SE API子集和Java虚拟机。JRE是支持Java程序运行的标准环境
    1.2.3 Java Card: 支持Java小程序(Applets)运行在小内存设备(如智能卡)上的平台
    1.2.4 Java ME: 支持Java程序运行在移动终端(手机、PDA)上的平台。Android不属于Java Me
    1.2.5 Java SE: 支持面向桌面级应用的Java平台，提供了完整的Java核心API
    1.2.6 Java EE: 支持使用多层架构的企业级应用(ERP、MIS、CRM应用)的Java平台
1.3 Java发展史
    1.3.1 JDK8提供的主要功能包括：
            1>JEP 126: 对Lambda表达式的支持
            2>JEP 104: 内置Nashorn JavaScript引擎的支持
            3>JEP 150: 新的时间、日期API
            4>JEP 122: 彻底移除HotSpot的永久代
            ...
1.4 Java虚拟机家族
    1.4.1 虚拟机始祖: Sun Classic/Exact VM
            >1 JDK1.0版本所带的虚拟机就是Classic VM。这款虚拟机只能使用纯解释器方式执行Java代码
            >2 如果要使用即时编译器就必须进行外挂，但是如果外挂了即时编译器，即时编译器就会完全接管虚拟机的执行系统，解释器便不能工作
            >3 Exact VM是因为它使用准确式内存管理而得名。
            >4 准确式内存管理是指虚拟机可以知道内存中某个位置的数据到底是什么类型。
            >5 Exact VM可以抛弃掉以前Classic VM基于句柄(Handle)的对象查找方式(原因是垃圾收集后对象将可能会被移动位置，如果地址为123456的对象移动到654321，
                在没有明确信息表明内存中的哪些数据是引用类型的前提下，那虚拟机肯定是不敢把内存中所有为123456的值改成654321的，所以要是用句柄来保持引用值的稳定),
                这样每次定位对象都少了一次简介查找的开销，显著提升执行性能。
            >6 Classic VM在JDK1.2之前是JDK唯一的虚拟机;JDK1.2时，与HotSpot并存，但是默认虚拟机还是Classic VM;JDK1.3时，默认虚拟机改为HotSpot;JDK1.4时，
                Classic VM完全退出商用虚拟机舞台。
    1.4.2 武林盟主: HotSpot VM
            >1 优点: 准确式内存管理、热点代码探索技术
            >2 HotSpot VM的热点代码探索能力可以通过执行计数器找出最具有编译价值的代码，然后通知即时编译器以方法为单位进行编译
            >3 如果一个方法被频繁调用，或方法中有效循环次数很多，将会分别出发标准即时编译和栈上替换编译(On-Stack Replacement,OSR)行为
            >4 通过编译器与解释器恰当协调工作，可以在最优化的程序响应时间与最佳执行性能中取得平衡，而无须等待本地代码输出才能执行程序，即时编译的压力也相对减少，这样
            有助于引入更复杂的代码优化技术，输出质量更高的本地代码
            >5 JDK8，HopSpot移除永久代，吸收了JRockit的Java Mission Control监控工具等功能
    1.4.3 小家碧玉: Mobile/Embedded VM
            1> Mobile/Embedded VM主要是面向移动端和嵌入式方向的虚拟机，但是由于Java ME的发展不如意，以及有Android、iOS，所以虚拟机发展也不理想
    1.4.4 天下第二: BEA JRockit/IBM J9 VM
            1> BEA为一款专门为服务器硬件和服务端应用场景高度优化的虚拟机，由于专注服务端应用，它可以不太关注于程序启动速度，因此JRockit内部不包含解释器实现，全部代码
            都靠即时编译器编译后执行
            2> JRockit实现了垃圾收集器和Java Mission Control故障处理套件
            3> JRockit永远停留在JDK6版本
            4> J9有一个BUG是因为8KB常量值定义错误引起，J9的市场定位与HotSpot相近。
            5> J9直至今天仍然非常活跃，J9的职责与模块化做得比HotSpot更优秀
    1.4.5 软硬合璧: BEA Liquid VM/Azul VM
            1> Liquid VM是由BEA公司开发的可以直接运行在自家Hypervisor系统上的JRockit
            2> Liquid VM不需要操作系统的支持，或者说它本身实现了一个专用操作系统的必要功能，如线程调度、文件系统、网络支持等。目前Liquid VM项目已停止
            3> Azul VM是Azul Systems公司在HotSpot基础上进行大量改进，运行于Azul Systems公司的专有硬件Vega系统上的Java虚拟机，每个Azul VM实例
            都可以管理至少数十个CPU和数百GB的内存的硬件资源，并提供在巨大内存范围内停顿时间可控的垃圾收集器(即业内赫赫有名的PGC和C4收集器)，
            为专有硬件优化的线程调度等优秀特性
            4> Zing虚拟机是一个从HotSpot某旧版代码分支基础上独立出来重新开发的高性能Java虚拟机，它可以运行在通用的Linux/x86-64平台上。Azul公司为它
            编写了新的垃圾收集器，也修改了HotSpot内的许多实现细节
            5> 在要求低延迟、快速预热等场景中，Zing VM都要比HotSpot表现得更好。Zing的PGC、C4收集器可以轻易支持TB级别的Java堆内存，而且保证暂停时间仍然可以
            维持在不超过10毫秒的范围里，HotSpot要一直到JDK 11和JDK 12的ZGC及Shenandoah收集器才达到了相同的目标，而且目前效果仍然远不如C4
            6>Zing的ReadyNow！功能可以利用之前运行时收集到的性能监控数据，引导虚拟机在启动后快速达到稳定的高性能水平，减少启动后从解释执行到即时编译的等待时间。
            Zing自带的ZVision/ZVRobot功能可以方便用户监控Java虚拟机的运行状态，从找出代码热点到对象分配监控、锁 竞争监控等。Zing能让普通用户无须了解垃圾收集等
            底层调优，就可以使得Java应用享有低延迟、快速预热、易于监控的功能，这是Zing的核心价值和卖点，很多Java应用都可以通过长期努力在应用、框架层面优化来提升性能，
            但使用Zing的话就可以把精力更多集中在业务方面。
    1.4.6 挑战者: Apache Harmony/Google Android Dalvik VM
            1> Apache Harmony是一个Apache软件基金会旗下以Apache License协议开源的实际兼容于JDK 5和 JDK 6的Java程序运行平台，它含有自己的虚拟机和Java类库API，用户可以在上面运行Eclipse、
            Tomcat、Maven等常用的Java程序。但是，它并没有通过TCK认证，所以我们不得不用一长串冗长拗口的语言来介绍它，而不能用一句“Apache的JDK”或者“Apache的Java虚拟机”来直接代指
            2> Dalvik虚拟机曾经是Android平台的核心组成部分之一。Dalvik虚拟机并不是一个Java虚拟机，它没有遵循《Java虚拟机规范》，不能直接执行Java的Class文件，
            使用寄存器架构而不是Java虚拟机中常见的栈架构。
            3> 是它与Java却又有着千丝万缕的联系，它执行的DEX（Dalvik Executable）文件可以通过Class文件转化而来，使用Java语法编写应用程序，可以直接使用绝大部分的Java API等。
            在Android发展的早期，Dalvik虚拟机随着Android的成功迅速流行，在Android 2.2中开始提供即时编译器实现，执行性能又有了进一步提高。不过到了Android 4.4时代，
            支持提前编译（Ahead of Time Compilation，AOT）的ART虚拟机迅速崛起，在当时性能还不算特别强大的移动设备上，提前编译要比即时编译更容易获得高性能，所以在Android 5.0里ART就
            全面代替了Dalvik虚拟机。
    1.4.7 没有成功，但并非失败: Microsoft JVM及其他
            
            