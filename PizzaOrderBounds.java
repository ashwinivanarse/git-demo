import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
public class PizzaOrderBounds extends JFrame implements ActionListener
{
	JList toppings;
	JComboBox areas;
	JRadioButton veg,non_veg;
	JCheckBox cash;
	JTextArea orderdetails;
	JButton placeorder;
	String kolhapur_areas[]={"shahupuri","rajarampuri","Tarabai park","Nagala Park","Shivaji Park"};
	DefaultListModel dm=new DefaultListModel();  
	JLabel lbl1,lbl2,lbltitle;
	ButtonGroup bgr;
	public PizzaOrderBounds()
	{
	    	setLayout(null);
		Font fnt=new Font("Times New Roman",Font.BOLD,26);
		lbltitle=new JLabel("Choose Your Favourate Pizza Order");
		lbltitle.setFont(new Font("Monotype corsiva",Font.BOLD,30));
		lbltitle.setForeground(Color.red);
		lbltitle.setBounds(40,20,500,30);
		add(lbltitle);
		lbl1=new JLabel("Select area :");
		lbl1.setFont(fnt);
		lbl1.setBounds(40,70,200,30);
		add(lbl1);
		areas=new JComboBox(kolhapur_areas);
		areas.setFont(fnt);
		areas.setBounds(280,70,200,30);
	    add(areas);
		lbl2=new JLabel("Select Toppings");
		lbl2.setFont(fnt);
		lbl2.setBounds(40,120,200,30);
		add(lbl2);
		dm.addElement("tomatoes");
		dm.addElement("mushrooms");
		dm.addElement("caramelized onions");
		
		toppings=new JList(dm);
		toppings.setFont(fnt);
		JScrollPane js1=new JScrollPane(toppings);
		js1.setBounds(280,120,200,80);
		add(js1);
		bgr=new ButtonGroup();
		veg=new JRadioButton("Veg");
		veg.setFont(fnt);
		veg.setBounds(40,220,100,30);
		add(veg);
		non_veg=new JRadioButton("Non-Veg");
		non_veg.setFont(fnt);
		non_veg.setBounds(160,220,150,30);
		add(non_veg);
		bgr.add(veg);
		bgr.add(non_veg);
		cash=new JCheckBox("Cash on Delivery");
		cash.setFont(fnt);
		cash.setBounds(320,220,300,30);
		add(cash);
		placeorder=new JButton("Place Order");
		placeorder.setFont(fnt);
		placeorder.addActionListener(this);
		placeorder.setBounds(150,280,200,30);
		add(placeorder);
		orderdetails=new JTextArea();
		orderdetails.setFont(fnt);
		JScrollPane js2=new JScrollPane(orderdetails);
		js2.setBounds(80,340,400,200);
		add(js2);
	}
	public void actionPerformed(ActionEvent e)
	{
	   String orderis="Your area is :"+areas.getSelectedItem().toString();
	   orderis+="\nToppings is :"+toppings.getSelectedValue().toString();
	   if(veg.isSelected())
	   orderis+="\nType : "+veg.getText();
	   if(non_veg.isSelected())
	   orderis+="\nType : "+non_veg.getText();
	   if(cash.isSelected())
	   orderis+="\nCash on delivery";
	   orderdetails.setText(orderis);
	}
	public static void main(String args[])
	{
		PizzaOrderBounds x=new PizzaOrderBounds();
		x.setTitle("Order Pizza");
		x.setBounds(500,200,650,650);
		x.setVisible(true);
		x.setResizable(false);
		x.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}