package com.fiturrizaga.searcher.service.impl;

import com.fiturrizaga.searcher.util.impl.HashTagWordMatcherImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * Created by frankieic on 10/28/16.
 */
public class HashtagWordMatcherImplTest {

    private HashTagWordMatcherImpl target;

    @Before
    public void setUp() throws Exception {
        target = new HashTagWordMatcherImpl();
    }

    @Test
    public void matchOkTest() throws Exception {

        StringBuilder sbHtml = new StringBuilder();
        sbHtml.append("<p>@john Olor it amet, consectetuer adipiscing elit. Aenean commodo")
            .append("<a class='autocompletedTag' href='#' data-id='u:2'>@john_wayne</a></p> ")
            .append("<p>@john @kate <a>@royal_baby</a> #england <a>#russia</a></p> ")
            .append("<p>#sale #stack #hello <a>@batman</a> #avengers <a>#iron_man</a></p>' ");

        Set<String> result =target.match(sbHtml.toString());
        System.out.println(result);
        Assert.assertEquals(7,result.size());
        Assert.assertTrue(result.contains("#stack"));
        Assert.assertTrue(result.contains("#avengers"));
        Assert.assertTrue(result.contains("#england"));
        Assert.assertTrue(result.contains("#russia"));
        Assert.assertTrue(result.contains("#iron_man"));
        Assert.assertTrue(result.contains("#sale"));
        Assert.assertTrue(result.contains("#hello"));

    }
}
