package com.moxiaowei.file;

import com.moxiaowei.pojo.NodeCon;

import java.io.*;

public class Filer {

    public static void writeLogConToFile(NodeCon logs, String filePath) {
        File file = new File(filePath);
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeObject(logs);
            objOut.flush();
            objOut.close();
            System.out.println("write object success!");
        } catch (IOException e) {
            System.out.println("write object failed");
            e.printStackTrace();
        }
    }


    public static NodeCon readLogConFromFile(String filePath) {
        Object temp = null;
        FileInputStream in;
        try {
            in = new FileInputStream(filePath);
            ObjectInputStream objIn = new ObjectInputStream(in);
            temp = objIn.readObject();
            objIn.close();
            System.out.println("read object success!");
        } catch (IOException e) {
            System.out.println("read object failed");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (NodeCon) temp;
    }


    public static void main(String[] args) {
    }
}
