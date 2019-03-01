package controllers;

import java.util.HashMap;

public abstract class BaseController {
    public HashMap<String, String> mapParams(String params)
    {
        String[] splittedParams = params.split("=|&");
        int index = 0;
        String key = "";
        String value = "";
        HashMap<String, String> mappedParams = new HashMap<>();
        for (String splittedParam: splittedParams) {
            if((index%2)==0) // even
            {
                key = splittedParam;
            }
            else // odd
            {
                value = splittedParam;
                mappedParams.put(key, value);
                System.out.println("Added: " + key + "=" + value);
            }
            index++;
        }
        return mappedParams;
    }
}
