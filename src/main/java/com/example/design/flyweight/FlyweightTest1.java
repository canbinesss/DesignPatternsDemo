package com.example.design.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlyweightTest1 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1, 2, TreeFactory.getTree("xxxx", "xxxxxxxxxxxx"));
        TreeNode treeNode2 = new TreeNode(5, 2, TreeFactory.getTree("xxxx", "xxxxxxxxxxxx"));
        System.out.println(treeNode1);
        System.out.println(treeNode2);
    }
}

class TreeNode{
    private int x;
    private int y;
    private Tree tree;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }
}

class TreeFactory {
    private static final Map<String, Tree> map = new ConcurrentHashMap<>();
    public static Tree getTree(String name, String data) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        Tree tree = new Tree(name, data);
        map.put(name, tree);
        return tree;
    }
}

class Tree{
    private final String name;
    private final String data;

    public String getName() {
        return name;
    }
    public String getData() {
        return data;
    }

    public Tree(String name, String data) {
        System.out.println("create tree"+name+" created Data"+data);
        this.name = name;
        this.data = data;
    }
}
