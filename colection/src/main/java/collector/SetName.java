package collector;

import java.util.HashMap;
import java.util.Map;

/**
 * Allows for the cards to be asigned a set value that helps with sorting and keeping the cards orginized
 */
public enum SetName {
    UDS11617,
    UDS21617,
    UDS21516;

    private static final Map<SetName, String> setnamemap = new HashMap<>();
    private static final Map<String, SetName> setenummap = new HashMap<>();

    /**
     * Creates the maps that allows the change between enums and strings
     */
    static {
        setnamemap.put(UDS11617, "Upper Deck 2016-2017 Series one");
        setenummap.put("Upper Deck 2016-2017 Series one", UDS11617);

        setnamemap.put(UDS21617, "Upper Deck 2016-2017 Series two");
        setenummap.put("Upper Deck 2016-2017 Series two", UDS21617);

        setnamemap.put(UDS21516, "Upper Deck 2015-2016 Series two");
        setenummap.put("Upper Deck 2016-2017 Series two", UDS21516);
    }

    /**
     * 
     * @param key
     * @return String
     */
    public static String getName(SetName key) {
        return setnamemap.get(key);
    }

    /**
     * 
     * @param key
     * @return SetName
     */
    public static SetName getEnum(String key) {
        return setenummap.get(key);
    }


    public static void main(String[] args) {
        System.out.println(setnamemap.get(UDS21617));
        System.out.println(setenummap.get("Upper Deck 2016-2017"));
    }

    
}

