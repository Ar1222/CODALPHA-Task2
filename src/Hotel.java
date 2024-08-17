import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private String name;
	private List<Review> reviews;
	
	public Hotel(String name) {
		super();
		this.name = name;
		this.reviews = new ArrayList<>();
	}
	
	 public String getName() {
		return name;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add( review);
	}
	public void displayReviews() {
		if(reviews.isEmpty()) {
			System.out.println("No Reviews available for "+name);
		}else {
			for(Review review:reviews) {
				System.out.println(review);
			}
		}
	}  
}
