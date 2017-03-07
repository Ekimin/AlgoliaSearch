package com.wentuouto.algolia.app;

import com.algolia.search.APIClient;
import com.algolia.search.APIClientBuilder;
import com.algolia.search.ApacheAPIClientBuilder;
import com.algolia.search.Index;
import com.algolia.search.exceptions.AlgoliaException;
import com.algolia.search.objects.Query;
import com.algolia.search.responses.SearchResult;
import com.wentuotuo.algolia.model.Hexo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ekimin on 2017/3/1.
 * https://www.algolia.com/doc/api-client/java/getting-started/
 */
public class Algolia {

    public static void main(String[] args) throws AlgoliaException {

        APIClient client = new ApacheAPIClientBuilder("0XHJNLJKH5", "df8136b265109307bfbbe5576287d635").build();
        Index<Hexo> index = client.initIndex("Hexo", Hexo.class);
        Query query = new Query("*").setAttributesToRetrieve(Arrays.asList("title", "date", "path", "content")).setHitsPerPage(50);
        SearchResult<Hexo> sr = index.search(query);
        List<Hexo> hexoList = sr.getHits();

        String url = "jdbc:mysql://47.90.56.252:3306/test?user=root&password=mysql123456&amp;useUnicode=true&characterEncoding=UTF-8";
        String sql = "INSERT INTO Hexo (ID, title, date, path, content) values (?,?,?,?,?)";


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManager.getConnection(url);
            ps = con.prepareStatement(sql);

            int count = 0;
            for (Hexo hexo : hexoList) {
                String ID = UUID.randomUUID().toString();
                ps.setString(1, ID);
                ps.setString(2, hexo.getTitle());
                ps.setString(3, hexo.getDate());
                ps.setString(4, hexo.getPath());
                ps.setString(5, hexo.getContent());

                System.out.println(hexo.getTitle());
                ps.addBatch();
                count++;
                if (count >= 500) {
                    ps.executeBatch();
                    count = 0;
                }
            }
            if (count > 0) {
                ps.executeBatch();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


        System.out.println();
    }
}
