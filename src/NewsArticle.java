public class NewsArticle {
    /**
     * {
     "source":{
     "id":"ars-technica",
     "name":"Ars Technica"
     },
     "author":"Kiona N. Smith",
     "title":"Humans expanded out of Africa 40,000 years earlier than we thought",
     "description":"The discovery sheds new light on the timing of early human migration.",
     "url":"https://arstechnica.com/science/2018/01/humans-expanded-out-of-africa-40000-years-earlier-than-we-thought/",
     "urlToImage":"https://cdn.arstechnica.net/wp-content/uploads/2018/01/hershkovitz4HR-760x380.jpg",
     "publishedAt":"2018-01-25T20:00:44+00:00"
     }
     */

    private String author;
    private String title;
    private String description;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public NewsArticle(String author) {
    }
}
