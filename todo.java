import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class todo extends JFrame implements ActionListener{

    JPanel cardPanel;
    CardLayout layout;
    private DefaultListModel<String> todoListModel;
    private JList<String> todoList;
    private JTextField TodoField,HidukeField,MemoField,amountField,dateField,contentField;
    private JButton btnTodoHozon,btnKakeiboHozon,btnCalender,firstButton,secondButton,thirdButton;
    private JPanel panel01,panel02,panel03,btnPanel;
    private JScrollPane scrollPane;
    private Container contentPane;
    private JDateChooser dateChooser;
   // private JDateChooser dateChooser;
    public static void main(String[] args) {
        todo frame = new todo();
        frame.setTitle("TodoKakeibo");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }

    todo() {
        // panel01
        JPanel panel01 = new JPanel(new GridBagLayout());
        JButton btnTodoHozon = new JButton("保存");
        JTextField TodoField = new JTextField(50);
        List JuyouList = new List(5);
        for (int i = 1; i <= 10; i++) {
            JuyouList.add(String.valueOf(i));
        }
        JDateChooser datechooser1 = new JDateChooser();
        GridBagConstraints gbc = new GridBagConstraints();
        panel01.setSize(500,600);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(15, 15, 25, 15);
        gbc.gridx=0;gbc.gridy=0;gbc.gridwidth=200;gbc.gridheight=100;
        panel01.add(new JLabel("やること"),gbc);
        gbc.gridx=200;gbc.gridy=0;gbc.gridwidth=300;gbc.gridheight=100;
        panel01.add(TodoField,gbc);

        gbc.gridx=0;gbc.gridy=100;gbc.gridwidth=200;gbc.gridheight=100;
        panel01.add(new JLabel("重要度"),gbc);
        gbc.gridx=200;gbc.gridy=100;gbc.gridwidth=300;gbc.gridheight=100;
        panel01.add(JuyouList,gbc);
        JuyouList.addActionListener(this);
        

        gbc.gridx=0;gbc.gridy=200;gbc.gridwidth=200;gbc.gridheight=100;
        panel01.add(new JLabel("期限"),gbc);
        gbc.gridx=200;gbc.gridy=200;gbc.gridwidth=300;gbc.gridheight=100;
        panel01.add(datechooser1,gbc);

       // btnTodoHozon.setPreferredSize(new Dimension(100, 50));
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.5; 
        btnTodoHozon.setBounds(0, 0, 100, 50);
        gbc.gridx=0;gbc.gridy=300;gbc.gridwidth=500;gbc.gridheight=150;
        panel01.add(btnTodoHozon,gbc);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // panel02
        gbc.insets = new Insets(15, 15, 25, 15);
        JPanel panel02 = new JPanel(new GridBagLayout());
        panel02.setSize(500,600);
        JButton btnKakeiboHozon = new JButton("保存");
        JTextField amountField = new JTextField(50);
        JTextField contentField = new JTextField(50);
        JDateChooser datechooser = new JDateChooser();

        //収入ボタン
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx=0;gbc.gridy=0;gbc.gridwidth=1;gbc.gridheight=1;gbc.weightx =0.5;
        JButton PlusButton = new JButton("収入");
        PlusButton.setPreferredSize(new Dimension(100,50));
        panel02.add(PlusButton,gbc);

        //支出ボタン
        gbc.gridx=1;gbc.gridy=0;gbc.gridwidth=1;gbc.gridheight=1;gbc.weightx =0.5; 
        JButton MinusButton = new JButton("支出");
        MinusButton.setPreferredSize(new Dimension(100,50));
        panel02.add(MinusButton,gbc);

        //金額
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx=0;gbc.gridy=2;gbc.gridwidth=2;gbc.gridheight=1;
        panel02.add(new JLabel("金額"),gbc);

        gbc.gridx=1;gbc.gridy=2;gbc.gridwidth=2;gbc.gridheight=1;
        panel02.add(amountField,gbc);

        //内容
        gbc.gridx=0;gbc.gridy=3;gbc.gridwidth=2;gbc.gridheight=1;
        panel02.add(new JLabel("内容"),gbc);

        gbc.gridx=1;gbc.gridy=3;gbc.gridwidth=2;gbc.gridheight=1;
        panel02.add(contentField,gbc);

        //日付
        gbc.gridx=0;gbc.gridy=4;gbc.gridwidth=1;gbc.gridheight=1;
        panel02.add(new JLabel("日付"),gbc);

        gbc.gridx=1;gbc.gridy=4;gbc.gridwidth=1;gbc.gridheight=1;
        panel02.add(datechooser,gbc);

        //保存ボタン
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx=0;gbc.gridy=5;gbc.gridwidth=2;gbc.gridheight=1;
        btnKakeiboHozon.setPreferredSize(new Dimension(100,50));
        panel02.add(btnKakeiboHozon,gbc);

        // panel03
        JPanel panel03 = new JPanel(new GridBagLayout());
        List YarukotoList = new List();
        List KakeiboList = new List();
        JCalendar calendar = new JCalendar();
        gbc.insets = new Insets(10, 10, 5, 10);
        panel03.setSize(500,600);
        panel03.setBackground(Color.LIGHT_GRAY);

        //Calendarの設置
        gbc.weightx=1;gbc.weighty=1;
        gbc.gridx=0;gbc.gridy=0;gbc.gridwidth=100;gbc.gridheight=60;
        calendar.setPreferredSize(new Dimension(450,180));
        panel03.add(calendar,gbc);

        //やることリストと家計簿の追加
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx=0;gbc.gridy=60;gbc.gridwidth=50;gbc.gridheight=5;
        panel03.add(new JLabel("やること一覧"),gbc);
        gbc.gridx=50;
        panel03.add(new JLabel("今日の収支"),gbc);

        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx=0;gbc.gridy=65;gbc.gridwidth=50;gbc.gridheight=30;
        YarukotoList.setPreferredSize(new Dimension(400,150));
        panel03.add(YarukotoList,gbc);
        gbc.gridx=50;
        KakeiboList.setPreferredSize(new Dimension(400,150));
        panel03.add(KakeiboList,gbc);


        // CardLayout用パネル
        cardPanel = new JPanel();
        layout = new CardLayout();
        cardPanel.setLayout(layout);

        cardPanel.add(panel01, "panel01");
        cardPanel.add(panel02, "panel02");
        cardPanel.add(panel03, "panel03");


        // カード移動用ボタン
        JButton firstButton = new JButton("Todo入力");
        firstButton.addActionListener(this);
        firstButton.setActionCommand("panel01");

        JButton secondButton = new JButton("家計簿入力");
        secondButton.addActionListener(this);
        secondButton.setActionCommand("panel02");

        JButton thirdButton = new JButton("カレンダー");
        thirdButton.addActionListener(this);
        thirdButton.setActionCommand("panel03");

        JPanel btnPanel = new JPanel();
        btnPanel.add(firstButton,BorderLayout.SOUTH);
        btnPanel.add(secondButton,BorderLayout.SOUTH);
        btnPanel.add(thirdButton,BorderLayout.SOUTH);

        // cardPanelとカード移動用ボタンをJFrameに配置
        Container contentPane = getContentPane();
        contentPane.add(cardPanel, BorderLayout.CENTER);
        contentPane.add(btnPanel, BorderLayout.PAGE_END);
    }
    

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        layout.show(cardPanel, cmd);

        if(e.getSource() == btnTodoHozon){
            
        }
    }
}
