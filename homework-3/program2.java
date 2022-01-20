import java.io.*;
import java.util.*;

class program2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new FileReader("country-list.csv"));
        String line = reader.readLine();
        HashMap<String, String> mp = new HashMap<>();
        System.out.println("Task 1:");
        System.out.println(" ");
        int i = 10;
        while ((line = reader.readLine()) != null) {
            if(i>=1) {
                System.out.println(line);
                i--;
            }
            String[] arr = line.split(",");
            mp.put(arr[0], arr[1]);
        }

       HashMap<String, String> fin = sortByValue(mp);

        System.out.println(" ");
        System.out.println("Task 3:");
        System.out.println(" ");

        Integer cap = fin.size();
        Integer j = 1;
        for(Map.Entry<String, String> entry: mp.entrySet()) {
            if(cap - j <= 10) {
                System.out.println("Country: " + entry.getKey() + " Capital: " + entry.getValue());
            }
            j++;
        }



    }

    public static HashMap<String, String> sortByValue(HashMap<String, String> hm)
    {
        List<Map.Entry<String, String> > list =
                new LinkedList<Map.Entry<String, String> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, String> >() {
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<String, String> temp = new LinkedHashMap<String, String>();
        for (Map.Entry<String, String> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
