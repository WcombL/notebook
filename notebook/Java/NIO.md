# NIO

有两种场景会用到IO：
- 文件IO
- 网络IO

> nio的优势在于网络IO

## IO与NIO的区别

IO是面向流的处理，NIO是面向块(缓冲区)的处理

- 面向流的I/O 系统一次一个字节地处理数据。
- 一个面向块(缓冲区)的I/O系统以块的形式处理数据。

## nio 组件

- buffer缓冲区
- Channel管道
- Selector选择器

Channel 不与数据打交道只负责传输数据
Buffer 负责与数据打交道

### Buffer

在NIO中负责数据的存取。缓冲区就是数组。用于存储不同数据类型的数据

根据数据类型不同，提供相应的缓冲区：
- ByteBuffer
- CharBuffer
- ShortBuffer
- IntBuffer
- LongBuffer
- FloatBuffer
- DoubleBuffer

上述缓冲区的管理方式几乎一致，通过allocate()获取缓冲区。

读取缓冲区数据和写数据到缓冲区(get()、put())

Buffer维护4个核心属性，以提供包含数组的信息

- 容量Capacity
    缓冲区能够容纳的数据元素的最大数量。容量在缓冲区创建时被设定，并且永远不会改变(因为底层使用的是数组)
- 上界Limit
  缓冲区里的数据总数，代表当前缓冲区一共有多少数据
- 位置Position
  下一个要被读或写的元素位置。Position会自动由相应的get()和put()函数更新
- 标记Mark
  一个备忘位置。用于记录上一次读写的位置。可以通过reset()恢复到mark位置

缓冲区数据的核心方法：
- put(): 存入数据到缓冲区
- flip(): 切换成读模式
- get(): 获取缓冲区的数据
- clear(): 清空缓冲区，并使缓冲区可写


### Channel 管道

管道：用于源节点与目标节点的连接。在NIO中负责缓冲区数据传输。Channel 本身不存储数据，因此需要配合缓冲区进行传输

主要实现类：
- FileChannel
- SocketChannel
- ServerSocketChannel
- DatagramChannel

获取管道：
- getChannel(): 流
- 各类管道的静态方法open()
- Files工具类的newByteChannel()
- transfer(): 数据传输(直接操作缓冲区)

#### 直接与非直接缓冲区

- 非直接缓冲区是需要经过一个copy的阶段(从内核空间copy到用户空间)
- 直接缓冲区不需要经过copy阶段，也可以理解成内存映射文件


## IO模型

阻塞I/O模型

### 阻塞I/O模型

默认情况下所有操作都是阻塞的

在进程空间中调用recvform,其系统调用直到数据包到达且被复制到应用进程的缓冲区中或者发生错误时才返回，在此期间一直等待
