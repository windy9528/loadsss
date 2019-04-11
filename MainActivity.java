package baway.com.loadsss;

import android.os.AsyncTask;
import android.os.NetworkOnMainThreadException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.qy.xlistview.XListView;

import java.util.List;

import baway.com.loadsss.bean.NewsBean;
import baway.com.loadsss.util.NetUtil;

public class MainActivity extends AppCompatActivity implements XListView.IXListViewListener{

    private XListView xListView;
    private List<NewsBean.Third> list;
    private String url = "http://172.17.8.100/small/commodity/v1/commodityList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xListView = findViewById(R.id.xlv);

        new LoadDataFromServer().execute(url);

    }

    class LoadDataFromServer extends AsyncTask<String, Void, String>{
        @Override
        protected void onPostExecute(String s) {
            Gson gson = new Gson();
            NewsBean newsBean = gson.fromJson(s, NewsBean.class);
            //抽集合
            list = newsBean.result.rxxp.commodityList;
            //加数据
            list.addAll(list);
            //发送给适配器
        }

        @Override
        protected String doInBackground(String... strings) {
            return NetUtil.getDataFromServer(strings[0]);
        }
    }



    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
