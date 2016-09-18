package Nio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by Andrew on 2016/3/31.
 */
public class InterruptibleSocket {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame=new InterruptibleSocketFrame();
                frame.setTitle("InterruptibleSocketTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
class InterruptibleSocketFrame extends JFrame {
    public static final int TEXT_ROWS = 20;
    public static final int TEXT_COLUMS = 60;

    private Scanner in;
    private JButton interruptibleButton;
    private JButton blockingButton;
    private JButton cancelButton;
    private JTextArea messages;
    private TestServer server;
    private Thread connectThread;

    public InterruptibleSocketFrame() {
        JPanel northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);

        messages = new JTextArea(TEXT_ROWS, TEXT_COLUMS);
        add(new JScrollPane(messages));
        interruptibleButton=new JButton("Interruptible");
        blockingButton=new JButton("Bocking");
        northPanel.add(interruptibleButton);
        northPanel.add(blockingButton);

        server = new TestServer();
        new Thread(server).start();
        interruptibleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interruptibleButton.setEnabled(false);
                blockingButton.setEnabled(false);
                cancelButton.setEnabled(true);
                connectThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            connectInterruptibly();
                        } catch (IOException e) {
                            messages.append("\nInterruptibleSocket.connectInterruptibly:" + e);
                        }
                    }
                });
                connectThread.start();
            }
        });
        blockingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interruptibleButton.setEnabled(false);
                blockingButton.setEnabled(false);
                cancelButton.setEnabled(true);
                connectThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            connectBlocking();
                        } catch (IOException E) {
                            messages.append("\nInterruptibleServerSocketTest.connectBocking:" + E);

                        }
                    }
                });
                connectThread.start();
            }
        });
        cancelButton = new JButton("cancel");
        cancelButton.setEnabled(false);
        northPanel.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectThread.interrupt();
                cancelButton.setEnabled(false);
            }
        });
        pack();
    }

    public void connectInterruptibly() throws IOException {
        messages.append("Interruptible:\n");
        try (SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8189))) {
            in = new Scanner(channel);
            while (!Thread.currentThread().isInterrupted()) {

                messages.append("Reading");
                if (in.hasNextLine()) {
                    String line = in.nextLine();
                    messages.append(line);
                    messages.append("\n");
                }
            }
        } finally {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    messages.append("channel closed\n");
                    interruptibleButton.setEnabled(true);
                    blockingButton.setEnabled(true);

                }
            });
        }
    }

    public void connectBlocking() throws IOException {
        messages.append("Blocking:\n");
        try (Socket sock = new Socket("127.0.0.1", 8189)) {
            in = new Scanner(sock.getInputStream());
            while (!Thread.currentThread().isInterrupted()) {
                messages.append("Reading");

                if (in.hasNextLine()) {
                    String line = in.nextLine();
                    messages.append(line);
                    messages.append("\n");

                }
            }
        } finally {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    messages.append("Socket close\n");
                    interruptibleButton.setEnabled(true);
                    blockingButton.setEnabled(true);
                }
            });
        }
    }

    class TestServer implements Runnable {

        @Override
        public void run() {
            try {
                System.out.printf("1");
                ServerSocket s = new ServerSocket(8189);
                while (true) {
                    Socket incoming = s.accept();
                    Runnable r = new TestServerHandler(incoming);
                    Thread t = new Thread(r);
                    t.start();
                }
            } catch (IOException E) {
                messages.append("\n TestServer.run:"+E);
            }
        }
    }
class TestServerHandler implements  Runnable
{
    private Socket incoming;
    private int counter;
    public TestServerHandler(Socket i)
    {
        incoming=i;
    }
    @Override
    public void run() {
    try{
        try{
            OutputStream outputStream=incoming.getOutputStream();
            PrintWriter out=new PrintWriter(outputStream,true);
            while(counter<100)
            {
                System.out.println(counter);
                counter++;
                if(counter<=100)out.print(counter);

                Thread.sleep(100);
            }
            out.flush();
        }
        finally{
            incoming.close();
            messages.append("Close server\n");
        }
    }catch (Exception e)
    {
        messages.append("\n TestServerHandler.run:"+e);
    }
    }
}
}
