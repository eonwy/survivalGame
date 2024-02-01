package frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import objects.PlayerStudent;

public class SelectAPI extends JPanel implements screenSize{

   private GameFrame gameFrame;
   private SelectAPI selectAPI = this;
   private ImageIcon player1Icon, player2Icon, player3Icon, player4Icon; // 플레이어 셀카 이미지
   private ImageIcon studentDetailIcon1, studentDetailIcon2, studentDetailIcon3, studentDetailIcon4; // 플레이어 상세설명 이미지
   private ImageIcon bigPlayer1icon, bigPlayer2icon, bigPlayer3icon, bigPlayer4icon; // 버튼 누를시 커지는 이미지
   private ImageIcon selectStudentIcon = new ImageIcon("images/SelectStudent.png");
   private Image selectStudentImg = selectStudentIcon.getImage();
   

   public SelectAPI(GameFrame gameFrame) {
      
      setLayout(null);
      
      this.gameFrame = gameFrame;

      player1Icon = new ImageIcon("images/PlayerStudent1.png");
      player2Icon = new ImageIcon("images/PlayerStudent2.png");
      player3Icon = new ImageIcon("images/PlayerStudent3.png");
      player4Icon = new ImageIcon("images/PlayerStudent4.png");


      bigPlayer1icon = new ImageIcon("images/BigStudent1.png");
      bigPlayer2icon = new ImageIcon("images/BigStudent2.png");
      bigPlayer3icon = new ImageIcon("images/BigStudent3.png");
      bigPlayer4icon = new ImageIcon("images/BigStudent4.png");


      studentDetailIcon1 = new ImageIcon("images/StudentDetailImg1.png");
      studentDetailIcon2 = new ImageIcon("images/StudentDetailImg2.png");
      studentDetailIcon3 = new ImageIcon("images/StudentDetailImg3.png");
      studentDetailIcon4 = new ImageIcon("images/StudentDetailImg4.png");

      JButton btn1 = new JButton("", player1Icon);
      JButton btn2 = new JButton("", player2Icon);
      JButton btn3 = new JButton("", player3Icon);
      JButton btn4 = new JButton("", player4Icon);
      
      JLabel studentImg = new JLabel("");

      // 버튼 테두리 없음
      btn1.setBorderPainted(false);
      btn2.setBorderPainted(false);
      btn3.setBorderPainted(false);
      btn4.setBorderPainted(false);

      // 버튼 채우기 없음
      btn1.setContentAreaFilled(false);
      btn2.setContentAreaFilled(false);
      btn3.setContentAreaFilled(false);
      btn4.setContentAreaFilled(false);

      // 버튼 투명
      btn1.setOpaque(false);
      btn2.setOpaque(false);
      btn3.setOpaque(false);
      btn4.setOpaque(false);


      // 버튼 액션
      btn1.addMouseListener(new MouseAdapter() { // 버튼 클릭 리스너
         @Override
         public void mousePressed(MouseEvent e) {
            gameFrame.change("gameMap");
            batch("playerStudent");
         }

         @Override
         public void mouseEntered(MouseEvent e) {
            studentImg.setIcon(studentDetailIcon1);
            btn1.setSize(100, 89);
            btn1.setIcon(bigPlayer1icon);
         }

         @Override
         public void mouseExited(MouseEvent e) {
            studentImg.setIcon(null);
            btn1.setSize(70, 59);
            btn1.setIcon(player1Icon);
         }
      });
      btn2.addMouseListener(new MouseAdapter() { // 버튼 클릭 리스너
         @Override
         public void mousePressed(MouseEvent e) {
            gameFrame.change("gameMap");
            batch("playerStudent2");
         }

         @Override
         public void mouseEntered(MouseEvent e) {
            studentImg.setIcon(studentDetailIcon2);
            btn2.setSize(100, 89);
            btn2.setIcon(bigPlayer2icon);
         }

         @Override
         public void mouseExited(MouseEvent e) {
            studentImg.setIcon(null);
            btn2.setSize(70, 59);
            btn2.setIcon(player2Icon);
         }
      });

      btn3.addMouseListener(new MouseAdapter() { // 버튼 클릭 리스너
         @Override
         public void mousePressed(MouseEvent e) {
            gameFrame.change("gameMap");
            batch("playerStudent3");
         }

         @Override
         public void mouseEntered(MouseEvent e) {
            studentImg.setIcon(studentDetailIcon3);
            btn3.setSize(100, 89);
            btn3.setIcon(bigPlayer3icon);
         }

         @Override
         public void mouseExited(MouseEvent e) {
            studentImg.setIcon(null);
            btn3.setSize(70, 59);
            btn3.setIcon(player3Icon);
         }
      });
      
      btn4.addMouseListener(new MouseAdapter() { // 버튼 클릭 리스너
         @Override
         public void mousePressed(MouseEvent e) {
            gameFrame.change("gameMap");
            batch("playerStudent4");
         }

         @Override
         public void mouseEntered(MouseEvent e) {
            studentImg.setIcon(studentDetailIcon4);
            btn4.setSize(100, 89);
            btn4.setIcon(bigPlayer4icon);
         }

         @Override
         public void mouseExited(MouseEvent e) {
            studentImg.setIcon(null);
            btn4.setSize(70, 59);
            btn4.setIcon(player4Icon);
         }
      });

      btn1.setBounds(100, 640, 70, 59);
      btn2.setBounds(200, 640, 70, 59);
      btn3.setBounds(300, 640, 70, 59);
      btn4.setBounds(400, 640, 70, 59);
      studentImg.setBounds(180, 250, 223, 318);

      this.add(studentImg);
      this.add(btn1);
      this.add(btn2);
      this.add(btn3);
      this.add(btn4);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(selectStudentImg, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, 0, 0, 196, 182, this);
      repaint();
   }
   
   
   public void batch(String playerStudent) { // 비행기 선택 후 비행기 new add
      if (playerStudent == "playerStudent") {
         gameFrame.player = new PlayerStudent(gameFrame,"STUDENT1");
         gameFrame.gamePanel.add(gameFrame.player);
      } else if (playerStudent == "playerStudent2") {
         gameFrame.player = new PlayerStudent(gameFrame,"STUDENT2");
         gameFrame.gamePanel.add(gameFrame.player);
      } else if (playerStudent == "playerStudent3") {
         gameFrame.player = new PlayerStudent(gameFrame, "STUDENT3");
         gameFrame.gamePanel.add(gameFrame.player);
      } else if (playerStudent == "playerStudent4") {
         gameFrame.player = new PlayerStudent(gameFrame, "STUDENT4");
         gameFrame.gamePanel.add(gameFrame.player);
      }
   }
   


}