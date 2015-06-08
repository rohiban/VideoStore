package test;

import com.sahaj.video_store.Customer;
import com.sahaj.video_store.Movie;
import com.sahaj.video_store.RegularPriceCode;
import com.sahaj.video_store.VideoStore;
import junit.framework.TestCase;
import org.junit.Test;


/**
 * Created by rbansal on 08/06/15.
 */
public class VideoStoreTest extends TestCase {
    protected VideoStore testStore;
    protected Customer cust;

    protected void setUp() {
        testStore = new VideoStore();
        testStore.initialize();

        cust = new Customer("Donald Duck");
    }

    @Test
    public void testRegisterUnregister() {
        assertFalse(testStore.unRegister(cust));

        assertTrue(testStore.register(cust));

        assertTrue(testStore.unRegister(cust));

    }

    @Test
    public void testCheckInCheckOut() {
        testStore.register(cust);

        testStore.checkOut(cust, Movie.MADAGASCAR, 5);
        assertFalse(testStore.hasMovie(Movie.MADAGASCAR));

        testStore.doReturn(cust);
        assertTrue(testStore.hasMovie(Movie.MADAGASCAR));
    }

    @Test
    public void testMovieAddition() {
        testStore.addMovie(Movie.ANKUSH, new RegularPriceCode());
        assertTrue((testStore.hasMovie(Movie.ANKUSH)));
    }

    protected void tearDown() {
    }
}
