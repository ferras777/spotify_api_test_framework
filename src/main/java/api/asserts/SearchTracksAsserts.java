package api.asserts;

import api.bodies.search_tracks.Items;
import api.bodies.search_tracks.SearchTrackBody;

import static org.testng.Assert.assertTrue;

public class SearchTracksAsserts {

    public void checkTrackNameContainsSearchString(SearchTrackBody searchTrackBody, String searchString) {
        for (Items items : searchTrackBody.getTracks().getItems())
            assertTrue(items.getName().toLowerCase().
                    contains(searchString.toLowerCase()), "Track not contains search string");
    }
}
