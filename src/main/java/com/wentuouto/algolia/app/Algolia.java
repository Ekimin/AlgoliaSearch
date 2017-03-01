package com.wentuouto.algolia.app;

import com.algolia.search.Index;
import com.algolia.search.responses.SearchResult;
import com.wentuotuo.algolia.AlgoliaManager;
import com.wentuotuo.algolia.model.Hexo;

/**
 * Created by Ekimin on 2017/3/1.
 * AlgoliaSearch
 */
public class Algolia {

    public static  void main(String[] args){
        AlgoliaManager algoliaManager = new AlgoliaManager("0XHJNLJKH5", "a8aa45462154736510bedf5ddadc838e");

        Index<Hexo> index = algoliaManager.apiClient.initIndex("Hexo", Hexo.class);
        
    }
}
