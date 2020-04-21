package com.frankstar.leetcode;

import java.util.List;

/**
 * @author : frankstar
 * @version V1.0
 * @Project: java-improve
 * @Package com.frankstar.leetcode
 * @Description: TODO
 * @mail :  frankstar007@163.com
 * @date Date : 2020年04月21日 22:25
 */
public class MNode {

    public int val;
    public List<MNode> children;

    public MNode() {}

    public MNode(int _val) {
        val = _val;
    }

    public MNode(int _val, List<MNode> _children) {
        val = _val;
        children = _children;
    }
}
