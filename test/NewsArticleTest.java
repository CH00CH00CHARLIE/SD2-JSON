import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsArticleTest {

    private static final String ARTICLE_JSON = "{\n"+
            "     \"source\":{\n"+
            "     \"id\":\"ars-technica\",\n"+
            "     \"name\":\"Ars Technica\"\n"+
            "     },\n"+
            "     \"author\":\"Kiona N. Smith\",\n"+
            "     \"title\":\"Humans expanded out of Africa 40,000 years earlier than we thought\",\n"+
            "     \"description\":\"The discovery sheds new light on the timing of early human migration.\",\n"+
            "     \"url\":\"https://arstechnica.com/science/2018/01/humans-expanded-out-of-africa-40000-years-earlier-than-we-thought/\",\n"+
            "     \"urlToImage\":\"https://cdn.arstechnica.net/wp-content/uploads/2018/01/hershkovitz4HR-760x380.jpg\",\n"+
            "     \"publishedAt\":\"2018-01-25T20:00:44+00:00\"\n"+
            "     }";
    private static final String ARTICLE_ARRY_JSON = "[{\"source\":{\"id\":\"ars-technica\",\"name\":\"Ars Technica\"},\"author\":\"Kiona N. Smith\",\"title\":\"Humans expanded out of Africa 40,000 years earlier than we thought\",\"description\":\"The discovery sheds new light on the timing of early human migration.\",\"url\":\"https://arstechnica.com/science/2018/01/humans-expanded-out-of-africa-40000-years-earlier-than-we-thought/\",\"urlToImage\":\"https://cdn.arstechnica.net/wp-content/uploads/2018/01/hershkovitz4HR-760x380.jpg\",\"publishedAt\":\"2018-01-25T20:00:44+00:00\"},{\"source\":{\"id\":\"ars-technica\",\"name\":\"Ars Technica\"},\"author\":\"Chris Lee\",\"title\":\"New form of qubit control may yield longer computation times\",\"description\":\"Finessing qubit control may be better than hammering the message home.\",\"url\":\"https://arstechnica.com/science/2018/01/new-form-of-qubit-control-may-yield-longer-computation-times/\",\"urlToImage\":\"https://cdn.arstechnica.net/wp-content/uploads/2016/04/SeriousManChalkboard-640x215.jpg\",\"publishedAt\":\"2018-01-25T19:45:26+00:00\"},{\"source\":{\"id\":\"ars-technica\",\"name\":\"Ars Technica\"},\"author\":\"Ars Staff\",\"title\":\"Dealmaster: Get a 55-inch 4K Roku TV for $370\",\"description\":\"Plus deals on Bluetooth headphones, gaming laptops, SSDs, and more.\",\"url\":\"https://arstechnica.com/staff/2018/01/dealmaster-get-a-55-inch-4k-roku-tv-for-370/\",\"urlToImage\":\"https://cdn.arstechnica.net/wp-content/uploads/2018/01/0125-hero-760x380.png\",\"publishedAt\":\"2018-01-25T19:19:03+00:00\"},{\"source\":{\"id\":\"ars-technica\",\"name\":\"Ars Technica\"},\"author\":\"Jonathan M. Gitlin\",\"title\":\"Compression ignition engines are a big breakthrough—we got to try one\",\"description\":\"It's called Spark Controlled Compression Ignition, and Mazda made it work.\",\"url\":\"https://arstechnica.com/cars/2018/01/mazdas-skyactiv-x-shows-the-internal-combustion-engine-has-a-future/\",\"urlToImage\":\"https://cdn.arstechnica.net/wp-content/uploads/2018/01/Mazda-tech-forum-42-760x380.jpg\",\"publishedAt\":\"2018-01-25T19:00:06+00:00\"},{\"source\":{\"id\":\"ars-technica\",\"name\":\"Ars Technica\"},\"author\":\"Sam Machkovech\",\"title\":\"Celeste review: With amazing twists, this 2D game reaches great heights\",\"description\":\"From the makers of Towerfall comes the first must-buy solo game of the year.\",\"url\":\"https://arstechnica.com/gaming/2018/01/celeste-review-with-amazing-twists-this-2d-game-reaches-such-great-heights/\",\"urlToImage\":\"https://cdn.arstechnica.net/wp-content/uploads/2018/01/celeste-ars-approved-760x380.png\",\"publishedAt\":\"2018-01-25T17:00:42+00:00\"},{\"source\":{\"id\":\"ars-technica\",\"name\":\"Ars Technica\"},\"author\":\"Sam Machkovech\",\"title\":\"Nintendo’s Miitomo shutdown is a wake-up call for its smartphone track record\",\"description\":\"Miitomo will end after roughly two years, missed the mark in so many ways.\",\"url\":\"https://arstechnica.com/gaming/2018/01/nintendos-first-smartphone-app-will-shut-down-in-may-and-good-riddance/\",\"urlToImage\":\"https://cdn.arstechnica.net/wp-content/uploads/2018/01/banner_top.png\",\"publishedAt\":\"2018-01-25T16:56:00+00:00\"},{\"source\":{\"id\":\"ars-technica\",\"name\":\"Ars Technica\"},\"author\":\"Kyle Orland\",\"title\":\"The legislative fight over loot boxes expands to Washington state\",\"description\":\"New bill would require the gambling commission to weigh in on randomized items.\",\"url\":\"https://arstechnica.com/gaming/2018/01/the-legislative-fight-over-loot-boxes-expands-to-washington-state/\",\"urlToImage\":\"https://cdn.arstechnica.net/wp-content/uploads/2018/01/whats-in-the-box-760x380.jpg\",\"publishedAt\":\"2018-01-25T16:05:53+00:00\"},{\"source\":{\"id\":\"ars-technica\",\"name\":\"Ars Technica\"},\"author\":\"Jon Brodkin\",\"title\":\"Net neutrality will be enforced in New York under orders from governor\",\"description\":\"Executive order prevents state from buying Internet service that isn't neutral.\",\"url\":\"https://arstechnica.com/tech-policy/2018/01/net-neutrality-will-be-enforced-in-new-york-under-orders-from-governor/\",\"urlToImage\":\"https://cdn.arstechnica.net/wp-content/uploads/2018/01/getty-andrew-cuomo-760x380.jpg\",\"publishedAt\":\"2018-01-25T15:51:42+00:00\"},{\"source\":{\"id\":\"ars-technica\",\"name\":\"Ars Technica\"},\"author\":\"Timothy B. Lee\",\"title\":\"Tesla Semi spotted driving on public roads\",\"description\":\"A YouTube video shows the truck cruising down a suburban street.\",\"url\":\"https://arstechnica.com/cars/2018/01/tesla-semi-spotted-driving-on-public-roads/\",\"urlToImage\":\"https://cdn.arstechnica.net/wp-content/uploads/2018/01/Screen-Shot-2018-01-25-at-9.41.12-AM-760x380.png\",\"publishedAt\":\"2018-01-25T15:07:22+00:00\"},{\"source\":{\"id\":\"ars-technica\",\"name\":\"Ars Technica\"},\"author\":\"Valentina Palladino\",\"title\":\"Apple’s iBooks to become “Books” in forthcoming reading app redesign\",\"description\":\"iPhones and iPad may feel like new e-readers with this update.\",\"url\":\"https://arstechnica.com/gadgets/2018/01/apples-ibooks-to-become-books-in-forthcoming-reading-app-redesign/\",\"urlToImage\":\"https://cdn.arstechnica.net/wp-content/uploads/2018/01/ibook-760x380.png\",\"publishedAt\":\"2018-01-25T14:31:36+00:00\"}]";

    private static NewsArticle newsArticle;

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        newsArticle = gson.fromJson(ARTICLE_JSON,NewsArticle.class);
    }

    @Test
    public void getAuthor() {
        assertEquals("Kiona N. Smith",newsArticle.getAuthor());
    }

    @Test
    public void getTitle() {
        assertEquals("Humans expanded out of Africa 40,000 years earlier than we thought",newsArticle.getTitle());
    }

    @Test
    public void getTitleArray() {
        Gson localgson = new Gson();
        NewsArticle [] newsArticleArray = localgson.fromJson(ARTICLE_ARRY_JSON, NewsArticle[].class);
        assertEquals("Humans expanded out of Africa 40,000 years earlier than we thought",newsArticleArray[0].getTitle());
    }

    @Test
    public void getDescription() {
    }
}