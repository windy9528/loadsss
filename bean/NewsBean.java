package baway.com.loadsss.bean;

import java.util.List;

public class NewsBean {

    public First result;

    public static class First{
        public Second rxxp;
    }

    public static class Second{
        public List<Third> commodityList;
    }

    public static class Third {
        public String masterPic; //图片
        public int commodityId; //id
    }
}
