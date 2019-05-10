package com.moxiaowei.btree;

import com.moxiaowei.pojo.Node;
import com.moxiaowei.pojo.NodeCon;

import java.io.File;
import java.util.HashMap;

import static com.moxiaowei.file.Filer.readLogConFromFile;
import static com.moxiaowei.file.Filer.writeLogConToFile;

public class BTree {

    private String suffix = ".cb";

    private int treeMaxSize = 1000;

    private String dpath = BTree.class.getResource("/").getPath() + Node.class.getSimpleName();

    public NodeCon createNewLogCon() {
        HashMap<String, Node> nodes = new HashMap<>();
        NodeCon logCon = new NodeCon();
        logCon.setNodes(nodes);
        return logCon;
    }

//    public LogCon add(LogCon logCon, Log log){
//        HashMap<Integer, Log> nodes = logCon.getLogs();
//        nodes.put(log.hashCode(), log);
//        return logCon;
//    }

    public NodeCon getRoot() {
        File file1 = new File(dpath + "/ROOT" + suffix);
        if (!file1.exists()) {
            File file = new File(dpath);
            if (!file.exists())
                file.mkdirs();
            NodeCon root = createNewLogCon();
            writeLogConToFile(root, dpath + "/ROOT" + suffix);
            return root;

        } else {
            return readLogConFromFile(dpath + "/ROOT" + suffix);
        }
    }

    private NodeCon root;

    public BTree() {
        root = getRoot();
    }

    public void add(Object value) {
        HashMap<String, Node> nodes = this.root.getNodes();
        if (nodes.size() < this.treeMaxSize) {
            Node node = new Node(value, false, null);
            nodes.put(node.hash(), node);
        }
        this.root.setNodes(nodes);
        writeLogConToFile(root, dpath + "/ROOT" + suffix);
    }

    public static void main(String[] args) {
        BTree bTree = new BTree();
//        bTree.add(136);
//        bTree.add(236);
        HashMap<String, Node> nodes = bTree.root.getNodes();
        for (String key : nodes.keySet()) {
            System.out.println(key + ": " + nodes.get(key));
        }
    }
}
