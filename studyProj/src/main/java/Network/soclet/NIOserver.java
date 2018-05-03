package Network.soclet;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;

public class NIOserver implements Runnable{
    private Selector selector;
    //第一个端口
    private Integer port1 = 8099;
    //第一个服务器通道 服务A
    private ServerSocketChannel serversocket1;
    private SocketChannel clientchannel1;
    //缓冲区
    private ByteBuffer buf = ByteBuffer.allocate(512);


    public NIOserver(Selector selector) throws IOException {
        this.selector = selector;
        this.serversocket1 = ServerSocketChannel.open();
        this.serversocket1.configureBlocking(false);
        this.serversocket1.socket().bind(new InetSocketAddress("localhost",8099));
        this.serversocket1.register(this.selector, SelectionKey.OP_ACCEPT);
    }

    @Override
    public void run() {
        System.out.println("kais");
        while (true){
            try {
                this.selector.select();
                Iterator selectorkeys = selector.selectedKeys().iterator();
                while (selectorkeys.hasNext()){
                    SelectionKey selectionKey = (SelectionKey) selectorkeys.next();
                    selectorkeys.remove();
                    if(selectionKey.isAcceptable()){
                        ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                        clientchannel1 = server.accept();
                        clientchannel1.configureBlocking(false);
                        //OP_READ用于读取操作的操作集位
                        clientchannel1.register(this.selector, SelectionKey.OP_READ);
                        System.out.println("accept a conn");
                    }
                    if(selectionKey.isReadable()){
                        this.buf.clear();
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        int count = channel.read(this.buf);
                        if (count == -1) {
                            //取消这个通道的注册
                            //selectionKey.channel().close();
                            //selectionKey.cancel();
                            continue;
                        }

                        //将数据从缓冲区中拿出来
                        String input = new String(this.buf.array()).trim();
                        System.out.println(input);
                    }
                }




            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void run1(){

    }
    public static void main(String[] args) throws IOException {
        NIOserver niOserver = new NIOserver(SelectorProvider.provider().openSelector());
        Thread thread = new Thread(niOserver);
        thread.start();
    }


}
