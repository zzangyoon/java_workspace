//6
package day1110.network.unicasting;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class UniClient extends JFrame{
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
	BufferedReader buffr;
	BufferedWriter buffw;
	
	public UniClient() {
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
				send();
				listen();
				t_input.setText("");
			}
		});
		
		//키보드와 리스너 연결
		t_input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					send();
					listen();
					t_input.setText("");
				}
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
			
			//접속이 성공되었으므로, 스트림을 얻을 수 있다
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));	//한줄로 끝내기!
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//서버에 메시지 보내기(출력)
	public void send() {
		String msg = t_input.getText();	//유저가 입력한 텍스트박스 메시지
		try {
			buffw.write(msg+"\n");
			buffw.flush();	//남아있는 데이터 없이, 버퍼비우기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//서버가 보낸 메시지 듣기
	public void listen() {
		String msg = null;
		try {
			msg = buffr.readLine();
			area.append(msg+"\n");	//대화기록하기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new UniClient();
	}
}
