package com.wentuotuo.algolia;

import com.algolia.search.APIClient;
import com.algolia.search.ApacheAPIClientBuilder;
import com.algolia.search.Index;
import com.wentuotuo.algolia.model.Contact;

/**
 * Created by Ekimin on 2017/3/1.
 * AlgoliaSearch
 */
public class AlgoliaManager {
    public APIClient apiClient;
    public Index<Object> index;
    private boolean is_IndexInit = false;

    /**
     *
     * @param appID Application ID
     * @param APIKey API Key
     */
    public AlgoliaManager(String appID, String APIKey){
        apiClient = new ApacheAPIClientBuilder(appID, APIKey).build();
    }
}
