package training.common;

import com.github.opendevl.JFlat;

import java.util.Iterator;
import java.util.List;

public class CSVGenerator {
    public static String generateCSV(String JsonStr, char delimiter, String headerSeparator) throws Exception {
        List<Object[]> sheetMatrix = null;
        JFlat flatMe = new JFlat(JsonStr);
        sheetMatrix =  flatMe.json2Sheet().headerSeparator(headerSeparator).getJsonAsSheet();
        StringBuffer resultStr = new StringBuffer();
        boolean comma = false;
        Iterator iterator = sheetMatrix.iterator();

        while(iterator.hasNext()) {
            Object[] o = (Object[])iterator.next();
            comma = false;
            Object[] var7 = o;
            int var8 = o.length;

            for(int var9 = 0; var9 < var8; ++var9) {
                Object t = var7[var9];
                if (t == null) {
                    resultStr.append(comma ? delimiter : "");
                } else {
                    resultStr.append(comma ? delimiter + t.toString() : t.toString());
                }

                if (!comma) {
                    comma = true;
                }
            }

            resultStr.append("\n");
        }

        return resultStr.toString();
    }
}
