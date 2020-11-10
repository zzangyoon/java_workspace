//9
package day1110.network.multicasting;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiClient extends JFrame{
	JPanel p_north;
	Choice ch_ip;
	JTextField t_port;
	JButton bt_connect;
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt_send;
	
	Socket socket;	//대화용 소켓
	
	ClientThread clientThread;
	
	public MultiClient() {
		p_north = new JPanel();
		ch_ip = new Choice();
		t_port = new JTextField("7777", 10);
		bt_connect = new JButton("접속");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input = new JTextField(15);
		bt_send = new JButton("send");
		
		ch_ip.add("localhost");
		
		//조립
		p_north.add(ch_ip);
		p_north.add(t_port);
		p_north.add(bt_connect);
		
		p_south.add(t_input);
		p_south.add(bt_send);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		add(p_south, BorderLayout.SOUTH);
		
		//접속버튼과 리스너 연결
		bt_connect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		bt_send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientThread.send(t_input.getText());
				//listen();
				t_input.setText("");
			}
		});
		
		//키보드와 리스너 연결
		t_input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					clientThread.send(t_input.getText());
					//listen();	@-5 끝없이 들어야 하므로 반복문! while
					t_input.setText("");
				}
			}
		});
		
		//현재프레임과 윈도우리스너 연결
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
				clientThread.send("exit");	//나간다는 의사를 서버에 전송하자!
				clientThread.flag=false;
				System.exit(0);	//클라이언트의 프로세스도 종료
			}
		});
		
		setBounds(300, 200, 300, 400);
		setVisible(true);
	}
	
	//에코 서버에 접속한다!
	public void connect() {
		try {
			socket = new Socket(ch_ip.getSelectedItem(), Integer.parseInt(t_port.getText()));
			area.append("서버에 접속\n");

			//무한루프로 메시지를 받고, 메시지를 보내줄 쓰레드 생성
			clientThread = new ClientThread(this, socket);
			clientThread.start();	//runnable 상태로 진입, run 메서드를 수행하게됨
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MultiClient();
	}
}
