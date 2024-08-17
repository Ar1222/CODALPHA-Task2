
public class Review {
  private String user;
  private int rating;
  private String comment;
 public Review(String user, int rating, String comment) {
	super();
	this.user = user;
	this.rating = rating;
	this.comment = comment;
 }
public int getRating() {
	return rating;
}
public String getComment() {
	return comment;
}
  @Override
  public String toString() {
	  return "User:" + user +"Rating:" +rating +"/5,comment:" +comment;
  }  
}
