import java.awt.*;
 
public class Test extends Frame{
    
     Label lblId, lblPwd, lblName, lblHp, lblGen, lblHobby,lblJob,lblAddr,lblAge ;
     TextField txtId, txtPwd, txtName;
     TextField txtHp1, txtHp2, txtHp3;
     Checkbox cbMale,cbFeMale;
     Checkbox cbHobby1, cbHobby2, cbHobby3;
     Choice chJob;
     TextField txtAddr,txtAge;
     Button btnSubmit, btnCancel;
    
     public Test() {
         
          super("ȸ������");
          setLayout(null);
         
          lblId =new Label("���̵�");
          lblPwd=new Label("�н�����");
          lblName=new Label("�̸�");
          lblHp=new Label("�ڵ���");
          lblGen=new Label("����");
          lblHobby=new Label("���");
          lblJob=new Label("����");
          lblAddr=new Label("�ּ�");
          lblAge =new Label("����");
         
          lblId.setBounds(20, 50, 100, 20);
          lblPwd.setBounds(20, 80, 100, 20);
          lblName.setBounds(20, 110, 100, 20);
          lblHp.setBounds(20, 140, 100 , 20);
          lblGen.setBounds(20, 170, 100, 20);
          lblHobby.setBounds(20, 200, 100, 20);
          lblJob.setBounds(20, 230, 100, 20);
          lblAddr.setBounds(20, 260, 100, 20);
          lblAge.setBounds(20, 290, 100, 20);
         
          add(lblId);
          add(lblPwd);
          add(lblName);
          add(lblHp);
          add(lblGen);
          add(lblHobby);
          add(lblJob);
          add(lblAddr);
          add(lblAge);
         
          txtId =new TextField(20);
          txtPwd =new TextField(20);
          txtName= new TextField(20);
          Label lblhipen1 = new Label("-");
          Label lblhipen2 = new Label("-");
          txtHp1 = new TextField();
          txtHp2 = new TextField();
          txtHp3 = new TextField();
         
          Panel panGen = new Panel(new FlowLayout(FlowLayout.LEFT));
          Panel panHobby = new Panel(new FlowLayout(FlowLayout.LEFT));
    
          CheckboxGroup group = new CheckboxGroup();
          cbMale = new Checkbox("����",group,true);
          cbFeMale = new Checkbox("����",group,false);
         
          panGen.add(cbMale);
          panGen.add(cbFeMale);
          panGen.setBounds(120, 162, 100, 30);         
         
         
          cbHobby1 = new Checkbox("������");
          cbHobby2 = new Checkbox("��ǻ��");
          cbHobby3 = new Checkbox("����");
          panHobby.add(cbHobby1);
          panHobby.add(cbHobby2);
          panHobby.add(cbHobby3);
         
          panHobby.setBounds(120, 192, 200, 30);
         
          chJob = new Choice();
          chJob.add("�ڹ����α׷���");
          chJob.add("�Ӻ�������α׷���");
          chJob.add("�����α׷���");
          chJob.add("��������α׷���");
         
          txtAddr = new TextField();
          txtAge = new TextField();
         
          btnCancel = new Button("���");       
          btnSubmit = new Button("���ԿϷ�");
          //btnCancel.setSize(150, 40 );
          //btnSubmit.setSize(150, 40);
         
          txtId.setBounds(120, 50, 150, 20);
          txtPwd.setBounds(120, 80, 150, 20);
          txtName.setBounds(120, 110, 150, 20);
          txtHp1.setBounds(120, 140, 60, 20);
          lblhipen1.setBounds(190, 140, 10, 20);
          txtHp2.setBounds(210, 140, 60, 20);
          lblhipen2.setBounds(275, 140, 10, 20);
          txtHp3.setBounds(290, 140, 60, 20);
                  
          chJob.setBounds(120,230, 150, 20);
          txtAddr.setBounds(120, 260, 150, 20);
          txtAge.setBounds(120, 290, 150, 20);
         
         
          Panel paButton = new Panel();
          paButton.add(btnSubmit);
          paButton.add(btnCancel);
          paButton.setBounds(0, 320, 370, 370);
             
    
         
          add(txtId);
          add(txtPwd);
          add(txtName);
          add(txtHp1);
          add(lblhipen1);
          add(txtHp2);
          add(lblhipen2);
          add(txtHp3);
          add(panGen);
          add(panHobby);
          add(chJob);
          add(txtAddr);
          add(txtAge);
          add(paButton);
         
          setSize(370, 300);
          setResizable(false);
          setVisible(true);
         
     }
    
     public static void main(String[] args) {
          new Test();
     }   
}
