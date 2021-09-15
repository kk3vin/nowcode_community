package com.wenkai.nowcode_community.entity;

public class Page {

    private int current=1;
    //一页最多显示多少数据
    private int limit=10;
    //一共有多少返回数据
    //用于计算总页数
    private int rows;
    //查询路径（用于复用链接）
    //通过这个路径访问数据，后面其他页码的数据可以通过调整offset来更新
    //理论上，这个路径可以访问所有服务器返回的数据
    private String path;

    //获取当前页码
    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current>=1) {
            this.current = current;
        }
    }
    //
    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit>=1 && limit<=100){
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows>=0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    //获取当前页的起始行
    //因为SQL通过offset来提取分页的数据
    //不同的页码对应不同的offset
    //通过调整offset的值来告诉服务器所需数据的范围
    public int getOffset(){
        return (current-1)*limit;
    }
    //用于获取总的页数
    public int getTotal(){
        if(rows%limit==0){
            return rows/limit;
        }else{
            return rows/limit+1;
        }
    }

    public int getFrom(){
        return current-2<1?1:current-2;
    }
    public int getTo(){
        int total = getTotal();
        return current+2>total?total:current+2;
    }
}
