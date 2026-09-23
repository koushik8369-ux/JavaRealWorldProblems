public class Movie {

    private String movieName;
    private int ticketPrice;

    public Movie(String movieName, int ticketPrice) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }
}