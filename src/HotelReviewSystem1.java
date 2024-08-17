import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HotelReviewSystem1 {
         private List<Hotel>hotels;
         public HotelReviewSystem1() {
        	 this.hotels=new ArrayList<>();
         }
         public void addHotel(Hotel hotel) {
        	 hotels.add(hotel);
         }
         
         public List<Hotel>getHotels(){
        	 return hotels;
         }
         public Hotel findHotelByName(String name) {
        	 for(Hotel hotel : hotels) {
        		 if(hotel.getName().equalsIgnoreCase(name)) {
        			 return hotel;
        		 }
        	 }
        	 return null;
         }
         public void sortReviewsByRating(Hotel hotel) {
        	 hotel.getReviews().sort(Comparator.comparingInt(Review::getRating).reversed());
         }
         
         public List<Review> filterReviewsByRating(Hotel hotel,int minRating) {
        	 List<Review>filteredReviews=new ArrayList<>();
        	 for(Review review : hotel.getReviews()) {
        		 if(review.getRating()>=minRating) {
        			 filteredReviews.add(review);
        		 }
        	 }
        	 return filteredReviews;
         }
}
