import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

public class HotelReviewSystem {
    private HotelReviewSystem1 hotelReviewSystem;
    private JFrame frame;
    private JTextArea displayArea;
    private JComboBox<String>hotelDropdown;
    public HotelReviewSystem() {
    	hotelReviewSystem=new  HotelReviewSystem1();
    	initSampleData();
    	initialize();
    }
	
	private void initSampleData() {
		Hotel hotel1=new Hotel("Surise Hotel");
		hotel1.addReview(new Review("Alice",5,"Excellent stay !"));
		hotel1.addReview(new Review("Archana",4,"nice stay !"));
		hotel1.addReview(new Review("divya",5,"Excellent stay !"));
		hotel1.addReview(new Review("iswarya",3,"Average stay !"));
		hotel1.addReview(new Review("naveen",4,"very good service !"));
		
		hotelReviewSystem.addHotel(hotel1);	
	}

	private void initialize() {
		frame=new JFrame("Hotel Review System");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		 
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(4,2));
		
		JLabel  hotelLabel=new JLabel("select Hotel:");
		panel.add(hotelLabel);
		
		hotelDropdown=new JComboBox<>();
		for(Hotel hotel : hotelReviewSystem.getHotels()) {
			hotelDropdown.addItem(hotel.getName());	
		}
		panel.add(hotelDropdown);
		
		JButton addReviewButton = new JButton("Add Reviews");
		panel.add(addReviewButton);
		
		JButton displayReviewButton =new JButton("Display Reviews");
		panel.add(displayReviewButton);
		
		JButton sortReviewsButton =new JButton("sort Reviews by Rating");
		panel.add(sortReviewsButton);
		
		JButton FilterReviewsButton = new JButton("Filter Reviews by Rating");
		panel.add(FilterReviewsButton);
		
		displayArea=new JTextArea();
		displayArea.setEditable(false);
		JScrollPane scrollPane=new JScrollPane(displayArea);
		frame.add(panel,BorderLayout.NORTH);
		frame.add(scrollPane,BorderLayout.CENTER);
		
		addReviewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addReview();
			}
		});
		displayReviewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				displayReview();	
			}	
		});
		
		sortReviewsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sortReviews();		
			}	
		});
		FilterReviewsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				filterReviews();	
			}
		});
		frame.setVisible(true);	
	}
	private void addReview() {
		String hotelName=(String)hotelDropdown.getSelectedItem();
		Hotel hotel=hotelReviewSystem.findHotelByName(hotelName);
		
		if(hotel !=null) {
			String userName=JOptionPane.showInputDialog("Enter your name:");
			int rating=Integer.parseInt(JOptionPane.showInputDialog("Enter your Rating(1-5):"));
			String comment=JOptionPane.showInputDialog("Enter your comment:");
			Review review=new Review(userName,rating,comment);
			hotel.addReview(review);
			JOptionPane.showMessageDialog(frame,"Review added successfully!");
		}
	    
	}
	private void displayReview() {
		String hotelName=(String)hotelDropdown.getSelectedItem();
		Hotel hotel=hotelReviewSystem.findHotelByName(hotelName);
		if(hotel!=null) {
			displayArea.setText("");
			for(Review review: hotel.getReviews()) {
				displayArea.append(review.toString()+"\n");
			}
		}
	}
	private void sortReviews() {
		String hotelName=(String)hotelDropdown.getSelectedItem();
		Hotel hotel=hotelReviewSystem.findHotelByName(hotelName);
		if(hotel!=null) {
			hotelReviewSystem.sortReviewsByRating(hotel);
			displayReview();
		}
	}
	private void filterReviews() {
		String hotelName=(String)hotelDropdown.getSelectedItem();
		Hotel hotel=hotelReviewSystem.findHotelByName(hotelName);
		if(hotel!=null) {
			int minRating=Integer.parseInt(JOptionPane.showInputDialog("Enter minimum rating to filter by (1-5)"));
			displayArea.setText("");
			List<Review> filteredReviews=hotelReviewSystem.filterReviewsByRating(hotel,minRating);
			if(filteredReviews.isEmpty()) {
				displayArea.setText("No reviews with a rating of" + minRating +"or rating of"+minRating +"or higher.");
			}else {
				for(Review review:filteredReviews) {
					displayArea.append(review.toString()+"\n");
				}
			}
		}
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new HotelReviewSystem());

	}

}
