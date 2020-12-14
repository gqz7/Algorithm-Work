import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'priceCheck' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY products
     *  2. FLOAT_ARRAY productPrices
     *  3. STRING_ARRAY productSold
     *  4. FLOAT_ARRAY soldPrice
     */

    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
        
        int priceErrors = 0;
        
        for (int i = 0; i < productSold.size(); i++) {
            String pName = productSold.get(i);
            float itemSalePrice = soldPrice.get(i);
            int realPriceIndex = products.indexOf(pName);
            
            if (productPrices.get(realPriceIndex) != itemSalePrice)
                priceErrors++;
        }
        
        return priceErrors;

    }

}