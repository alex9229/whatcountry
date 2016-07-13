package alex.whatcountry;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 23.10.15.
 */
public class CountryUtill {
    Map Countrycode = new HashMap<Integer, String>();

    public  String getCountry(String code) {
        createListCountry();
        try{
            return Countrycode.get(Integer.parseInt(code.substring(0, 3))).toString();
        }catch (Exception e){return null;}

    }






    public  void createListCountry() {
        filling(0, 13, "Usa/Canada");
        filling(300, 70, "France");
        Countrycode.put(380, "Bulgaria");
        Countrycode.put(383, "Slovenia");
        Countrycode.put(385, "Croatia");
        Countrycode.put(387, "Bosnia and Herzegovina");
        filling(400, 40, "Germany");
        Countrycode.put(450, "Japan");
        Countrycode.put(490, "Japan");
        filling(460, 9, "Russia");
        Countrycode.put(471, "Taiwan");
        Countrycode.put(474, "Estonia");
        Countrycode.put( 475, "Latvia");
        Countrycode.put( 476, "Azerbaijan");
        Countrycode.put(477, "Lithuania");
        Countrycode.put( 478, "Uzbekistan");
        Countrycode.put( 479, "Sri Lanka");
        Countrycode.put(480, "Philippines");
        Countrycode.put(481, "Belarus");
        Countrycode.put( 482, "Ukraine");
        Countrycode.put( 484, "Moldova");
        Countrycode.put( 485, "Armenia");
        Countrycode.put( 486, "Georgia");
        Countrycode.put(487, "Kazakhstan");
        Countrycode.put( 489, "Hong Kong");
        Countrycode.put( 500, "United Kingdom");
        Countrycode.put( 520, "Greece");
        Countrycode.put( 528, "Lebanon");
        Countrycode.put( 529, "Cyprus");
        Countrycode.put( 531, "Macedonia");
        Countrycode.put( 535, "Malta");
        Countrycode.put( 539, "Ireland");
        Countrycode.put( 540, "Belgium and Luxembourg");
        Countrycode.put( 560, "Portugal");
        Countrycode.put( 540, "Belgium and Luxembourg");
        Countrycode.put( 569, "Iceland");
        Countrycode.put( 570, "Denmark");
        Countrycode.put( 590, "Poland");
        Countrycode.put( 594, "Romania");
        Countrycode.put( 599, "Hungary");
        Countrycode.put( 600, "South Africa");
        Countrycode.put( 601, "South Africa");
        Countrycode.put( 609, "Mauritius");
        Countrycode.put( 611, "Morocco");
        Countrycode.put(613, "Algeria");
        Countrycode.put( 616, "Kenya");
        Countrycode.put(619, "Tunisia");
        Countrycode.put( 621, "Syria");
        Countrycode.put( 622, "Egypt");
        Countrycode.put( 625, "Jordan");
        Countrycode.put( 626, "Iran");
        Countrycode.put(628, "Saudi Arabia");
        Countrycode.put(640, "Finland");
        filling(490, 3, "China");
        Countrycode.put(670, "Norway");
        Countrycode.put(729, "Israel");
        Countrycode.put( 730, "Sweden");
        Countrycode.put( 740, "Guatemala");
        Countrycode.put( 741, "El Salvador");
        Countrycode.put( 742, "Honduras");
        Countrycode.put( 743, "Nicaragua");
        Countrycode.put( 744, "Costa Rica");
        Countrycode.put( 745, "Panama");
        Countrycode.put( 746, "Dominican Republic");
        Countrycode.put( 750, "Mexico");
        Countrycode.put( 759, "Venezuela");
        Countrycode.put(760, "Switzerland");
        Countrycode.put( 770, "Colombia");
        Countrycode.put(773, "Uruguay");
        Countrycode.put( 779, "Argentina");
        Countrycode.put( 775, "Peru");
        Countrycode.put( 780, "Chile");
        Countrycode.put( 784, "Paraguay");
        Countrycode.put(786, "Ecuador");
        Countrycode.put(789, "Brazil");
        filling(800, 30, "Italy");
        Countrycode.put(840, "Spain");
        Countrycode.put(850, "Cuba");
        Countrycode.put( 858, "Slovakia");
        Countrycode.put( 859, "Czech Republic");
        Countrycode.put( 860, "Yugoslavia");
        Countrycode.put( 867, "North Korea");
        Countrycode.put( 869, "Turkey");
        Countrycode.put( 870, "Netherlands");
        Countrycode.put( 880, "South Korea");
        Countrycode.put( 885, "Thailand");
        Countrycode.put( 888, "Singapore");
        Countrycode.put( 890, "India");
        Countrycode.put( 893, "Vietnam");
        Countrycode.put(775, "Indonesia");
        filling(900, 10, "Austria");
        Countrycode.put(930, "Australia");
        Countrycode.put( 940, "New Zealand");
        Countrycode.put( 955, "Malaysia");
        Countrycode.put( 958, "Macau");
    }

    public  void filling(int start,int count,String data) {
       for(int i=0;i<count;i++){
           Countrycode.put(start + i, data);
       }
    }

}
