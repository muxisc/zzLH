package com.lh.blog.util.pagination;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 描述:  分页请求对象.<br>
 */
public class PageRequest implements Serializable {
    private static final long serialVersionUID = -911527837717383901L;

    /**
     * 请求次数计数器
     */
    private int draw;
    /**
     * 列参数集合
     */
    private List<Map<Column, Object>> columns;
    /**
     * 排序参数集合
     */
    private List<Map<Order, Object>> order;
    /**
     * 分页起始位置
     */
    private int skipResult;
    /**
     * 分页页码
     */
    private int pageNum;
    
	/**
     * 每页显示的记录数
     */
    private int pageSize;
    /**
     * 全局搜索条件
     */
    private Map<Search, Object> search;
    /**
     * 业务查询参数
     */
    private Map<String, Object> params;

    
    
    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public List<Map<Column, Object>> getColumns() {
        return columns;
    }

    public void setColumns(List<Map<Column, Object>> columns) {
        this.columns = columns;
    }

    public List<Map<Order, Object>> getOrder() {
        return order;
    }

    public void setOrder(List<Map<Order, Object>> order) {
        this.order = order;
    }

    public Map<Search, Object> getSearch() {
        return search;
    }

    public void setSearch(Map<Search, Object> search) {
        this.search = search;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public int getSkipResult() {
		return skipResult;
	}

	public void setSkipResult(int skipResult) {
		this.skipResult = skipResult;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return this.getSkipResult() / this.getPageSize() + 1;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	/**
     * 描述: 列参数
     */
    public enum Column {
        /**
         * 绑定的数据源
         */
        data,
        /**
         * 列名称
         */
        name,
        /**
         * 是否可搜索
         */
        searchable,
        /**
         * 是否可排序
         */
        orderable,
        /**
         * 列搜索条件
         */
        searchValue,
        /**
         * 列搜索是否作为正则表达式
         */
        searchRegex

    }

    /**
     * 描述: 查询参数
     */
    public enum Search {
        /**
         * 全局的搜索条件
         */
        value,
        /**
         * 是否作为正则表达式
         */
        regex

    }

    /**
     * 描述：排序参数
     */
    public enum Order {
        /**
         * 排序列索引
         */
        column,
        /**
         * 排序方式 asc | desc
         */
        dir
    }
}
