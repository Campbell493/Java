package tools;
import java.awt.event.*;
import javax.swing.*;
import java.applet.AudioClip;
import java.io.*;
import java.applet.Applet;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Image;

//关于修改按钮的字体、背景以及标题图标的练习√
//关于在背景图片上显示按钮的练习√
//关于通过点击按钮返回之前页面的练习√
//添加BGM√
public class mainPart extends JFrame{

    JButton btn;
    private String bgsrc;
    public void setMain(){
        //1.把图片添加到标签里（把标签的大小设置为和图片相同）
        //把标签放在分层面板的最底层；
        JFrame jf=new JFrame();
        bgsrc="D:\\APP\\VScode Work\\SecondGame\\NovelGame-VNG\\img\\mainbg.jpg";
        ImageIcon bg=new ImageIcon((bgsrc));
        JLabel label1=new JLabel(bg);
        label1.setSize(bg.getIconWidth(),bg.getIconHeight());
        jf.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));
        //2.把窗口面板设置为内容面板并设为透明、流动布局。
        JPanel pan=(JPanel)jf.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);
        //3.之后把组件的面板添加到窗口面板就可以了
        JButton btn=new JButton();
        btn=setButton(bg,"D:\\APP\\VScode Work\\SecondGame\\NovelGame-VNG\\img\\Start.png");
        pan.add(btn);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Test successfully!");
                setPart1();
                jf.dispose();
            }
        });//设置监听器，读取鼠标点击事件。
        jf.setSize(bg.getIconWidth(),bg.getIconHeight());
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        //标题及图标
        jf.setTitle("无职转生 ~到了异世界就拿出真本事~ ");
        Image mainIcon=getToolkit().getImage("D:\\APP\\VScode Work\\SecondGame\\NovelGame-VNG\\img\\mainIcon.jpeg");
        jf.setIconImage(mainIcon);
    }


    public void setPart1(){
        JFrame jf=new JFrame();
        bgsrc="D:\\APP\\VScode Work\\SecondGame\\NovelGame-VNG\\img\\Part1\\Part1.jpg";
        ImageIcon bg=new ImageIcon((bgsrc));
        JLabel label1=new JLabel(bg);
        label1.setSize(bg.getIconWidth(),bg.getIconHeight());
        jf.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));
        JPanel pan=(JPanel)jf.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);
        JButton btn=new JButton();
        btn=setButton(bg,"D:\\APP\\VScode Work\\SecondGame\\NovelGame-VNG\\img\\Part1\\Next.png");
        pan.add(btn);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Test successfully!");
                setPart2();
                jf.dispose();
            }
        });//设置监听器，读取鼠标点击事件。
        jf.setSize(bg.getIconWidth(),bg.getIconHeight());
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setTitle("无职转生 ~到了异世界就拿出真本事~ ");
        Image mainIcon=getToolkit().getImage("D:\\APP\\VScode Work\\SecondGame\\NovelGame-VNG\\img\\mainIcon.jpeg");
        jf.setIconImage(mainIcon);//上三行为图标
    } 

    public void setPart2(){
        JFrame jf=new JFrame();
        bgsrc="D:\\APP\\VScode Work\\SecondGame\\NovelGame-VNG\\img\\Part2\\Part2.jpeg";
        ImageIcon bg=new ImageIcon((bgsrc));
        JLabel label1=new JLabel(bg);
        label1.setSize(bg.getIconWidth(),bg.getIconHeight());
        jf.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));
        JPanel pan=(JPanel)jf.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(null);
        JButton btn=new JButton();
        btn=setButton(bg,"D:\\APP\\VScode Work\\SecondGame\\NovelGame-VNG\\img\\Part1\\Next.png");
        pan.add(btn);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Test successfully!");
                setPart1();
                jf.dispose();
            }
        });//设置监听器，读取鼠标点击事件。
        jf.setSize(bg.getIconWidth(),bg.getIconHeight());
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setTitle("无职转生 ~到了异世界就拿出真本事~ ");
        Image mainIcon=getToolkit().getImage("D:\\APP\\VScode Work\\SecondGame\\NovelGame-VNG\\img\\mainIcon.jpeg");
        jf.setIconImage(mainIcon);//上三行为图标
    }

     //设置按钮
     public JButton setButton(ImageIcon bg,String src){
        JButton btn=new JButton();
        Image source=getToolkit().getImage(src);
        Image changeSize=source.getScaledInstance(250,120, Image.SCALE_DEFAULT);//调整图片大小
        ImageIcon start=new ImageIcon(changeSize);
        btn.setIcon(start);
        btn.setSize(start.getIconWidth(),start.getIconHeight());
        btn.setBorderPainted(false);//无边框
        btn.setLocation(bg.getIconWidth()-400, bg.getIconHeight()-250);
        btn.setContentAreaFilled(false);//设置按钮透明  Oh！！！！！好耶！！！！
        //透明相关资料：https://blog.csdn.net/qq_38712932/article/details/78724921?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0-78724921-blog-83918687.pc_relevant_default&spm=1001.2101.3001.4242.1&utm_relevant_index=3
        return btn;
    }
    
    static void playMusic(){//背景音乐播放
		try {
			URL cb;
			File f = new File("D:\\APP\\VScode Work\\test22.4.11\\Helloworld\\bgm\\testBgm.wav"); // 引号里面的是音乐文件所在的路径
			cb = f.toURL();
			AudioClip aau;
			aau = Applet.newAudioClip(cb);
		
			aau.play();	
			aau.loop();//循环播放
			System.out.println("可以播放");
			// 循环播放 aau.play()
			//单曲 
            //aau.stop();//停止播放
 
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
	}

    public static void main(String[] args) {
        //可以让主界面换一个样式JFrame.setDefaultLookAndFeelDecorated(true);
        mainPart test=new mainPart();
        test.setMain();
        playMusic();
        System.out.println("MAIN Test successfully!");
           
    }
}

